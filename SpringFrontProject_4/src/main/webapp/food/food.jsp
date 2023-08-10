<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 900px;
}
.images:hover{
  cursor: pointer
}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
  <div class="container">
    <h3>믿고보는 맛집 리스트</h3>
    <hr>
    <div class="row">
      <category1 v-bind:cate1="cate_list1"></category1>
    </div>
    <div style="height: 20px"></div>
    <h3>지역별 맛집 리스트</h3>
    <hr>
    <div class="row">
      <category2 v-bind:cate2="cate_list2"></category2>
    </div>
    <div style="height: 20px"></div>
    <h3>메뉴별 맛집 리스트</h3>
    <hr>
    <div class="row">
      <category3 v-bind:cate3="cate_list3"></category3>
    </div>
    <div id="dialog" title="카테고리별 맛집 목록" v-if="isShow">
         <div class="jumbotrom">
           <!-- <h4 class="text-center">{{category_info.title}}</h4>
           <h5 class="text-center">{{category_info.subject}}</h5> -->
         </div>
          <table class="table">
            <tbody>
            <tr>
              <td>
                <table class="table" v-for="vo in food_list">
                  
                  <tr>
                    <td width=30% class="text-center" rowspan="4">
                      <img :src="vo.poster" style="width:100%">
                    </td>
                    <td width=70% class="text-left"><h3>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3></td>
                  </tr>
                  <tr>
                    <td width=70% class="text-left">{{vo.address}}</td>
                  </tr>
                  <tr>
                    <td width=70% class="text-left">{{vo.tel}}</td>
                  </tr>
                  <tr>
                    <td width=70% class="text-left">{{vo.type}}</td>
                  </tr>
                  
                </table>
              </td>
            </tr>
            </tbody>
          </table>
         </div>
  </div>
  <script>
  Vue.component('category1',{
	  props:['cate1'],
	  template:'<div><div class="col-md-3" v-for="vo in cate1">'
		  +'<div class="thumbnail">'
		  +'<img :src="vo.poster" alt="Lights" style="width:100%" class="images" v-on:click="showFoodList1(vo.cno,true)">'
		  +'<div class="caption">'
		  +'<p style="font-size: 9px">{{vo.title }}</p>'
		  +'</div>'
		  +'</div>'
		  +'</div></div>',
	   methods:{
	    		 showFoodList1:function(cno,bool){
	    			 this.$parent.showGetData(cno,bool)
	    			 $('#dialog').dialog({
	    				 autoOpen:false,
	    				 modal:true,
	    				 width:600,
	    				 height:600
	    			 }).dialog("open")
	    		}
	   }
		 
  })
  Vue.component('category2',{
	  props:['cate2'],
	  template:'<div><div class="col-md-4" v-for="vo in cate2">'
		  +'<div class="thumbnail">'
		  +'<img :src="vo.poster" alt="Lights" style="width:100%" class="images" v-on:click="showFoodList2(vo.cno,true)">'
		  +'<div class="caption">'
		  +'<p style="font-size: 9px">{{vo.title }}</p>'
		  +'</div>'
		  +'</div>'
		  +'</div></div>',
	  methods:{
	    		 showFoodList2:function(cno,bool){
	    			 this.$parent.showGetData(cno,bool)
	    			 $('#dialog').dialog({
	    				 autoOpen:false,
	    				 modal:true,
	    				 width:600,
	    				 height:600
	    			 }).dialog("open")
	    		}
	   }
		 
  })
  Vue.component('category3',{
	  props:['cate3'],
	template:'<div><div class="col-md-3" v-for="vo in cate3">'
			  +'<div class="thumbnail">'
			  +'<img :src="vo.poster" alt="Lights" style="width:100%" class="images" v-on:click="showFoodList3(vo.cno,true)">'
			  +'<div class="caption">'
			  +'<p style="font-size: 9px">{{vo.title }}</p>'
			  +'</div>'
			  +'</div>'
			  +'</div></div>',
		methods:{
		    		 showFoodList3:function(cno,bool){
		    			 this.$parent.showGetData(cno,bool)
		    			 $('#dialog').dialog({
		    				 autoOpen:false,
		    				 modal:true,
		    				 width:600,
		    				 height:600
		    			 }).dialog("open")
		    		}
		   }
		
  })
  new Vue({
	  el:'.container',
	  data:{
		  cate_list1:[],
		  cate_list2:[],
		  cate_list3:[],
		  food_list:[],
		  isShow:false
	  },
	  mounted:function(){
		  axios.get('http://localhost/web/food/category.do',{
			  params:{
				  cno:1
			  }
		  }).then(response=>{
			  console.log(response.data);
			  this.cate_list1=response.data;
		  })
		  
		  axios.get('http://localhost/web/food/category.do',{
			  params:{
				  cno:2
			  }
		  }).then(response=>{
			  console.log(response.data);
			  this.cate_list2=response.data;
		  })
		  
		  axios.get('http://localhost/web/food/category.do',{
			  params:{
				  cno:3
			  }
		  }).then(response=>{
			  console.log(response.data);
			  this.cate_list3=response.data;
		  })
	  },
	  methods:{
		  showGetData:function(cno,bool){
  			
  			let _this=this;
  			_this.isShow=bool
  			
  			axios.get('http://localhost/web/food/food_list.do',{
  				params:{
  					cno:cno
  				}
  			}).then(function(response){
  				console.log(response.data)
  				_this.food_list=response.data
  			})
	    }
	  }
  })
  </script>
</body>
</html>