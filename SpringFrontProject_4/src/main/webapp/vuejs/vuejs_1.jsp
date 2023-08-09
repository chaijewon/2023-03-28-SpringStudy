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
<%--
     Vue.component('b-button',
       template:'<html>'
       
     <b-button>
 --%>
<body>
  <div class="container">
   <h1 class="text-center">Modal</h1>
   <div class="row">
    <template>
      <div>
       <b-button id="show-btn" @click="showModal" variant="outline-danger">Open</b-button>
       <b-button id="toggle-btn" @click="toggleModal" variant="success">Toggle</b-button>
       <b-modal ref="my-modal" hide-footer title="Test Modal">
         <div class="text-center">
           <h1>Hello Model</h1>
         </div>
       </b-modal>
      </div>
    </template>
   </div>
  </div>
  <script>
   new Vue({
	  el:'.container' ,
	  methods:{
		  showModal:function(){
			  this.$refs['my-modal'].show()
		  },
		  toggleModal:function(){
			  this.$refs['my-modal'].hide()
		  }
	  }
   })
  </script>
</body>
</html>




