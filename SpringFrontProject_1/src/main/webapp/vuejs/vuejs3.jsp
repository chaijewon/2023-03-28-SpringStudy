<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 960px;
}
</style>
</head>
<body>
  <div class="container">
    <h1 class="text-center">VueJS(디렉티브:v-for(제어문))</h1>
    <div class="row">
      <table class="table">
       <tr>
        <td>
          <input type=text size=30 class="input-sm" v-model="msg" ref="msg">
          <input type=button class="btn btn-sm btn-primary" value="입력"
           v-on:click="find()"
          >
        </td>
       </tr>
      </table>
      <table class="table">
       <thead>
         <tr class="danger">
           <th class="text-center">순위</th>
           <th class="text-center"></th>
           <th class="text-center">영화명</th>
           <th class="text-center">감독</th>
           <th class="text-center">장르</th>
         </tr>
       </thead>
       <tbody>
         <tr v-for="vo in movie">
           <td class="text-center">{{vo.rank}}</td>
           <td class="text-center">
            <img :src="'https://www.kobis.or.kr'+vo.thumbUrl" style="width: 30px;height: 30px">
           </td>
           <td>{{vo.movieNm}}</td>
           <td class="text-center">{{vo.director}}</td>
           <td class="text-center">{{vo.genre}}</td>
         </tr>
       </tbody>
      </table>
    </div>
  </div>
  <script>
   new Vue({
	   el:'.container',
	   data:{
		   movie:[{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20218541","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/06/thumb/thn_a68cc44d22d84acf9d861d5c931a4254.jpg","movieNm":"밀수","movieNmEn":"Smugglers","synop":"열길 물속은 알아도 한길 사람 속은 모른다!\r\n\r\n 평화롭던 바닷가 마을 군천에 화학 공장이 들어서면서 하루아침에 일자리를 잃은 해녀들.\r\n\r\n먹고 살기 위한 방법을 찾던 승부사 '춘자'(김혜수)는\r\n\r\n바다 속에 던진 물건을 건져 올리기만 하면 큰돈을 벌 수 있다는\r\n\r\n밀수의 세계를 알게 되고 해녀들의 리더 '진숙'(염정아)에게 솔깃한 제안을 한다.\r\n\r\n위험한 일임을 알면서도 생계를 위해 과감히 결단을 내린 해녀 '진숙'은\r\n\r\n전국구 밀수왕 '권 상사'를 만나게 되면서 확 커진 밀수판에 본격적으로 빠지게 된다.\r\n\r\n그러던 어느 날, 일확천금을 얻을 수 있는 일생일대의 기회가 찾아오고\r\n\r\n사람들은 서로를 속고 속이며 거대한 밀수판 속으로 휩쓸려 들어가기 시작하는데...\r\n\r\n물길을 아는 자가 돈길의 주인이 된다!\r\n","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"129","showTs":"3","director":"류승완","prNm":"(주)외유내강","dtNm":"(주)넥스트엔터테인먼트월드(NEW)","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"범죄","watchGradeNm":"15세이상관람가","openDt":"20230726","salesAmt":3399479429,"audiCnt":344096,"scrCnt":1614,"showCnt":6173,"rank":1,"rankInten":0,"rankOldAndNew":"OLD","rownum":1},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20193879","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/08/thumb/thn_745a5d6e9bd24074b86285c230d3e109.jpg","movieNm":"비공식작전","movieNmEn":"Ransomed","synop":"실종된 동료를 구하기 위해 레바논으로 떠난 외교관 민준과 현지 택시기사 판수의 버디 액션 영화","prdtYear":"2022","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"132","showTs":"11","director":"김성훈","prNm":"(주)와인드업필름,와이낫필름","dtNm":"(주)쇼박스","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"드라마","watchGradeNm":"12세이상관람가","openDt":"20230802","salesAmt":1629397927,"audiCnt":164080,"scrCnt":1120,"showCnt":3930,"rank":2,"rankInten":0,"rankOldAndNew":"OLD","rownum":2},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20228930","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/05/thumb/thn_1d8f3d4b27d8479e9250de7c217028ec.jpg","movieNm":"엘리멘탈","movieNmEn":"Elemental","synop":"디즈니·픽사의 놀라운 상상력!\r\n올여름, 세상이 살아 숨 쉰다\r\n\r\n불, 물, 공기, 흙 4개의 원소들이 살고 있는 ‘엘리멘트 시티’\r\n재치 있고 불처럼 열정 넘치는 ‘앰버'는 어느 날 우연히\r\n유쾌하고 감성적이며 물 흐르듯 사는 '웨이드'를 만나 특별한 우정을 쌓으며,\r\n지금껏 믿어온 모든 것들이 흔들리는 새로운 경험을 하게 되는데... \r\n\r\n제76회 칸 영화제 폐막작 선정!\r\n<굿 다이노> 피터 손 감독 연출\r\n<인사이드 아웃>, <소울> 피트 닥터 제작 참여\r\n\r\n6월 14일 극장 대개봉,\r\n웰컴 투 ‘엘리멘트 시티’!","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"109","showTs":"9","director":"피터 손","prNm":null,"dtNm":"월트디즈니컴퍼니코리아 유한책임회사","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20230614","salesAmt":1060225637,"audiCnt":106282,"scrCnt":1009,"showCnt":2829,"rank":3,"rankInten":0,"rankOldAndNew":"OLD","rownum":3},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20218935","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/08/thumb/thn_b9b13d4a5ce94150a8ee0522f60b978f.jpg","movieNm":"더 문","movieNmEn":"The Moon","synop":"2029년, 대한민국의 달 탐사선 우리호가 달을 향한 여정에 나선다. \r\n위대한 도전에 전 세계가 주목하지만 태양 흑점 폭발로 인한 태양풍이 \r\n우리호를 덮치고 ‘황선우’(도경수) 대원만이 홀로 남겨진다.\r\n\r\n대한민국의 우주선이 달로 향한 것이 이번이 처음은 아니었다. \r\n5년 전, 원대한 꿈을 안고 날아올랐지만 \r\n모두가 지켜보고 있는 가운데 공중 폭발로 산산이 부서졌던 나래호. \r\n또다시 일어난 비극에 유일한 생존자인 선우를 지키기 위해 \r\n나로 우주센터 관계자들과 정부는 총력을 다하고 온 국민이 그의 생존을 염원한다. \r\n\r\n선우를 무사 귀환시키기 위해서 5년 전 나래호 사고의 책임을 지고 \r\n산에 묻혀 지내던 전임 센터장 ‘김재국’(설경구)이 다시 합류하지만, \r\n그의 힘만으로는 역부족이다. \r\n\r\n선우를 구출할 또 다른 희망인 NASA 유인 달 궤도선 메인 디렉터 ‘윤문영’(김희애)에게\r\n도움을 청해보지만 그마저 쉽지 않다. \r\n재국은 또다시 누군가를 잃지 않기 위해 마지막으로 자신의 모든 것을 걸어 보는데….\r\n\r\n우주에 홀로 고립된 대원과 그의 무사 귀환에 모든 것을 건 남자\r\n살기 위한, 살려내기 위한 고군분투가 시작된다.","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"129","showTs":"20","director":"김용화","prNm":"(주)블라드스튜디오","dtNm":"(주)씨제이이엔엠","repNationCd":"한국","movieType":"장편","moviePrdtStat":"개봉","genre":"SF,액션,드라마","watchGradeNm":"12세이상관람가","openDt":"20230802","salesAmt":672357587,"audiCnt":63393,"scrCnt":927,"showCnt":2713,"rank":4,"rankInten":0,"rankOldAndNew":"OLD","rownum":4},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20232631","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/06/thumb/thn_fbc864b8a3f64ee98e22372534a81cec.jpg","movieNm":"미션 임파서블: 데드 레코닝 PART ONE","movieNmEn":"Mission: Impossible - Dead Reckoning Part One","synop":"가장 위험한 작전, 그의 마지막 선택\r\n\r\n모든 인류를 위협할 새로운 무기를 추적하게 된 에단 헌트(톰 크루즈)와 IMF팀은\r\n이 무기가 인류의 미래를 통제할 수 있다는 사실을 알게 된다.\r\n\r\n전 세계가 위태로운 상황에 처한 가운데, 이를 추적하던 에단 헌트에게 어둠의 세력까지 접근하고\r\n마침내 미스터리하고 강력한 빌런과 마주하게 된 그는\r\n가장 위험한 작전을 앞두고 자신이 아끼는 사람들의 생명과 중요한 임무 사이에서\r\n선택을 해야 하는 상황에 놓이게 되는데…\r\n","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"163","showTs":"13","director":"크리스토퍼 맥쿼리","prNm":"파라마운트 픽쳐스","dtNm":"롯데컬처웍스(주)롯데엔터테인먼트","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"액션,스릴러,어드벤처","watchGradeNm":"15세이상관람가","openDt":"20230712","salesAmt":458280434,"audiCnt":45993,"scrCnt":614,"showCnt":1148,"rank":5,"rankInten":0,"rankOldAndNew":"OLD","rownum":5},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20232836","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/07/thumb/thn_a327b04c6fb9468caf2dafb8bbd73382.jpg","movieNm":"몬스터 패밀리 2","movieNmEn":"Monster Family 2","synop":"몬스터에서 인간으로 겨우 돌아온 ‘위시본’ 패밀리!\r\n새 가족이 된 전설 속 몬스터 ‘바바 야가’와 ‘렌필드’의 결혼식 날,\r\n그들은 슈퍼 소녀 ‘밀라’에게 납치당한다.\r\n\r\n이들뿐 아니라 드라큘라, 예티, 네시, 그리고 킹 콩가까지!!\r\n‘위시본’ 패밀리는 ‘밀라’에 의해 전 세계 몬스터들이 납치된 것을 알게 되는데…\r\n\r\n몬스터들을 구하기 위해 다시 몬스터로 변한 ‘위시본’ 패밀리!\r\n과연 ‘위시본’ 가족은 몬스터들을 구하고 다시 인간으로 돌아갈 수 있을까?","prdtYear":"2021","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"103","showTs":"8","director":"호거 태프","prNm":null,"dtNm":"메가박스중앙(주)","repNationCd":"영국","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"전체관람가","openDt":"20230802","salesAmt":122025990,"audiCnt":13223,"scrCnt":406,"showCnt":643,"rank":6,"rankInten":1,"rankOldAndNew":"OLD","rownum":6},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20232536","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/07/thumb/thn_ffd2c8072afc4550aaed65767beed8bf.jpg","movieNm":"명탐정코난: 흑철의 어영","movieNmEn":"Detective Conan The Movie: Black Iron Submarine","synop":"인터폴의 최첨단 정보 해양 시설인 ‘퍼시픽 부이’.\r\n일본과 유럽의 CCTV 정보를 확인할 수 있을 뿐 아니라, 장기 수배범이나 유괴당한 피해자를 전 세계에서 찾아낼 수 있는 ‘전연령 인식’이라는 획기적인 AI 기술을 개발 중이다.\r\n\r\n그러던 중 독일에서 검은 조직에 의해 유로폴 직원이 살해되는 사건이 발생하고 뒤를 이어 ‘전연령 인식’의 핵심 기술자가 납치된다. 나이와 상관없이 안면 인식이 가능한 기술이 검은 조직의 손에 들어가면 독약 APTX4869(아포톡신 4869) 개발 후 사망한 것으로 알려진 코드명 ‘셰리’이자 하이바라 아이도 위험하게 되는데!\r\n\r\n코난, FBI, CIA, 공안 경찰이 합세, 하이바라 아이와 함께 전 세계를 위험에 빠지게 할 절체절명의 오션 배틀 로열이 시작된다!","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"109","showTs":"35","director":"타치카와 유즈루","prNm":null,"dtNm":"(주)씨제이이엔엠","repNationCd":"일본","movieType":"장편","moviePrdtStat":"개봉","genre":"애니메이션","watchGradeNm":"12세이상관람가","openDt":"20230720","salesAmt":131661488,"audiCnt":12989,"scrCnt":295,"showCnt":418,"rank":7,"rankInten":1,"rankOldAndNew":"OLD","rownum":7},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20232740","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/07/thumb/thn_162c9770955d4b08b64cd926eb449e1d.jpg","movieNm":"바비","movieNmEn":"Barbie","synop":"원하는 무엇이든 될 수 있는 '바비랜드'에서 살아가던 '바비'가 현실 세계와 이어진 포털의 균열을 발견하게 되고, 이를 해결하기 위해 '켄'과 예기치 못한 여정을 떠나면서 펼쳐지는 이야기","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":null,"showTm":"113","showTs":"54","director":"그레타 거윅","prNm":null,"dtNm":"워너브러더스 코리아(주)","repNationCd":"미국","movieType":"장편","moviePrdtStat":"개봉","genre":"기타","watchGradeNm":"12세이상관람가","openDt":"20230719","salesAmt":123396153,"audiCnt":11435,"scrCnt":229,"showCnt":337,"rank":8,"rankInten":-2,"rankOldAndNew":"OLD","rownum":8},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20219331","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/05/thumb/thn_13a6f9eeac7d4d1a81600212e6c3e38d.jpg","movieNm":"여름날 우리","movieNmEn":"My Love","synop":"처음이었다, 사랑이 싹트는 기분\r\n\r\n너에게 풍덩 빠져버렸던 17살의 여름.\r\n너를 두고 아무것도 할 수 없었던 21살의 여름.\r\n그리고 몇 번의 여름이 지나고 다시 만난 너,\r\n이젠 놓치지 않을 거야.\r\n\r\n“널 만난 건 내 인생 최고의 행운이었어” ","prdtYear":"2021","indieYn":null,"artmovieYn":null,"multmovieYn":"Y","showTm":"114","showTs":"48","director":"한톈","prNm":null,"dtNm":"(주)바이포엠스튜디오,찬란,메가박스중앙(주)","repNationCd":"중국","movieType":"장편","moviePrdtStat":"개봉","genre":"코미디,멜로/로맨스","watchGradeNm":"12세이상관람가","openDt":"20210825","salesAmt":42623206,"audiCnt":5126,"scrCnt":114,"showCnt":147,"rank":9,"rankInten":1,"rankOldAndNew":"OLD","rownum":9},{"startYearDate":"2023.08.06","endYearDate":"2023.08.06","startDate":"2023년 08월 06일(일)","endDate":"2023년 08월 06일(일)","movieCd":"20232698","showDt":"20230806","thumbUrl":"/common/mast/movie/2023/07/thumb/thn_85458581f8d44b0da28af1ad8764f10b.JPG","movieNm":"바다 탐험대 옥토넛 어보브 앤 비욘드 : 육지 넘어 하늘까지!","movieNmEn":"Octonauts: Above and Beyond – Season 2","synop":"#1. 옥토넛과 패닝가 거북\r\n새 탐험선 테라 6호의 시험비행을 나갔다가\r\n엔진 과열로 브라질 사막 한가운데에 추락한 트윅.\r\n엔진을 식힐 물을 구하기 위해 사막에서 만난 거북을 따라 나선다.\r\n바나클, 페이소, 콰지가 급히 구조에 나서지만\r\n폭풍우 때문에 쉽지가 않은데...\r\n\r\n#2. 옥토넛과 힐라 몬스터\r\n수문학자 옥토요원 포니와 함께 사막 물 탐사에 나선 콰지.\r\n해적의 전설에 나오는 사막 괴물, 모래 드래곤을 찾겠다고 야단이다.\r\n그러던 중 ‘힐라 몬스터’라는 도마뱀을 만나게 되고,\r\n코요테와 폭풍우를 피해 굴에 숨는 콰지와 힐라 몬스터.\r\n이 상황을 모르는 포니와 바나클은 사라진 콰지를 찾기 시작하는데...\r\n\r\n#3. 옥토넛과 대기의 강\r\n하늘에서 흐르는 거대한 구름 강, ‘대기의 강’의 지도를 만들기 위해\r\n바나클은 지도제작자 옥토요원 민 박사에게 도움을 청한다.\r\n이에 민과 포니가 새로운 비행선 옥토벌룬에 탑승해 비행을 시작하지만\r\n강한 폭풍에 밀려 높은 산봉우리에 충돌할 위험에 처하고 마는데...\r\n\r\n#4. 옥토넛과 킬리만자로 대작전\r\n식물학자 옥토요원 셀바와 함께\r\n킬리만자로의 마른 땅에 나무 심기 대작전을 시작한 옥토넛.\r\n그런데 나무를 실어 오던 옥토레이가 분화구 옆에 불시착해 구조가 필요한 상황에 처한다.\r\n옥토넛은 높고 높은 산에서 대쉬와 잉클링 교수를 구하고\r\n나무 심기 대작전을 무사히 마칠 수 있을까?","prdtYear":"2023","indieYn":null,"artmovieYn":null,"multmovieYn":"Y","showTm":"57","showTs":"32","director":null,"prNm":null,"dtNm":"와이드 릴리즈(주)","repNationCd":"영국","movieType":"장편","moviePrdtStat":"개봉예정","genre":"애니메이션,어드벤처,액션","watchGradeNm":"전체관람가","openDt":"20230810","salesAmt":37541600,"audiCnt":4122,"scrCnt":137,"showCnt":231,"rank":10,"rankInten":2,"rankOldAndNew":"OLD","rownum":10}],
		   msg:''
	   
	   },
	   beforeCreate:function(){
		   console.log("beforeCreate:Vue객체를 생성하기 전...")
		   // componentWillCreate (React)
	   },
	   created:function(){
		   console.log("created:Vue객체 생성완료...")
		   // componentDidCreate (React)
	   },
	   beforeMount:function(){
		   console.log("beforeMount:가상메모리(가상돔)에 올리기 전...")
	   },
	   mounted:function(){
		   console.log("mounted:가상메모리에 HTML을 올리기 완료..")
		   // $(function()) , window.onload
		   // 가상돔 / 실제 돔을 비교해서 변경 => diff
		   // 가장 많이 사용되는 상태 (서버에서 데이터를 읽어오는 경우)
	   },
	   beforeUpdate:function(){
		  console.log("beforeUpdate:상태가 변경(데이터값 변경)되기 직전상태..") 
		  // 멤버 변수 설정 : react=>state , Vue => data => data를 다른 메소드에서 변경시에는 this.
	   },
	   updated:function(){
		  console.log("updated: 데이터변경이나 수정이 완료된 상태 => mounted를 재호출")
	   },
	   beforeDestory:function(){
		   console.log("beforeDestory:메모리 해제 전 상태")
	   },
	   destoryed:function(){
		   console.log("destoryed:화면이 변경 => Vue객체 해제..")
	   },
	   // 사용자 정의 함수 
	   methods:{
		   find:function(){
			   if(this.msg==="")
			   {
				   alert("데이터 입력");
				   this.$refs.msg.focus();
			   }
		   }
	   }
   })
  </script>
</body>
</html>