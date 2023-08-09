<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
    <h1 class="text-center">{{message}}</h1>
    <my-com1 v-bind:pdata="mycomdata"></my-com1>
    <my-com2 v-bind:pdata="mycomdata"></my-com2>
  </div>
  <template id="aaa">
    <h1>Hello Template</h1>
    <h3>{{pdata}}</h3>
  </template>
  <script>
    Vue.component('my-com1',{
    	props:['pdata'],
    	template:'#aaa'
    })
    Vue.component('my-com2',{
    	props:['pdata'],
    	template:'<h3>{{pdata}}</h3>'
    })
    new Vue({
    	el:'.container',
    	data:{
    		message:'Hello Component!!',
    		mycomdata:'데이터 출력'
    	}
    })
  </script>
</body>
</html>