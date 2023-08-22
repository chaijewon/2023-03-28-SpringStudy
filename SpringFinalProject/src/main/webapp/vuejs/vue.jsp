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
<!-- <script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script> -->
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <button class="btn btn-sm btn-danger" @click="aaa">First</button>
      <div>{{first}}</div>
    </div>
    <div class="row">
      <button class="btn btn-sm btn-danger" @click="bbb">Second</button>
      <div>{{second}}</div>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		first:'',
    		second:''
    	},
    	methods:{
    		aaa:function(){
    			axios.get("http://localhost:8000/first-service/welcome").then(res=>{
    				this.first=res.data
    			})
    		},
    		bbb:function(){
    			axios.get("http://localhost:8000/second-service/welcome").then(res=>{
    				this.second=res.data
    			})
    		}
    	}
    })
  </script>
</body>
</html>