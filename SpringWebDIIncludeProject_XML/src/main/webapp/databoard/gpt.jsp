<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
* {
  font-family: Roboto, sans-serif;
  padding: 0;
  margin: 0;
}


.flexbox {
  background: linear-gradient(155deg, #55c7ed, #2bb3e0, #3bc1ed);
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.search {
  margin: 20px;
}

.search > h3 {
  font-weight: normal;
}

.search > h1,
.search > h3 {
  color: white;
  margin-bottom: 15px;
  text-shadow: 0 1px #0091c2;
}

.search > div {
  display: inline-block;
  position: relative;
  filter: drop-shadow(0 1px #0091c2);
}

.search > div:after {
  content: "";
  background: white;
  width: 4px;
  height: 20px;
  position: absolute;
  top: 40px;
  right: 2px;
  transform: rotate(135deg);
}

.search > div > input {
  color: white;
  font-size: 16px;
  background: transparent;
  width: 25px;
  height: 25px;
  padding: 10px;
  border: solid 3px white;
  outline: none;
  border-radius: 35px;
  transition: width 0.5s;
}

.search > div > input::-moz-placeholder {
  color: #efefef;
  opacity: 0;
  -moz-transition: opacity 150ms ease-out;
  transition: opacity 150ms ease-out;
}

.search > div > input:-ms-input-placeholder {
  color: #efefef;
  opacity: 0;
  -ms-transition: opacity 150ms ease-out;
  transition: opacity 150ms ease-out;
}

.search > div > input::placeholder {
  color: #efefef;
  opacity: 0;
  transition: opacity 150ms ease-out;
}

.search > div > input:focus::-moz-placeholder {
  opacity: 1;
}

.search > div > input:focus:-ms-input-placeholder {
  opacity: 1;
}

.search > div > input:focus::placeholder {
  opacity: 1;
}

.search > div > input:not(:-moz-placeholder-shown) {
  width: 250px;
}

.search > div > input:not(:-ms-input-placeholder) {
  width: 250px;
}

.search > div > input:focus,
.search > div > input:not(:placeholder-shown) {
  width: 250px;
}
/*Resize the wrap to see the search bar change!*/
.wrap{
  width: 30%;
  position: absolute;
  top: 10%;
  left: 50%;
  transform: translate(-50%, -50%);
}
#loading {
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      position: fixed;
      display: block;
      opacity: 0.6;
      background: #e4e4e4;
      z-index: 99;
      text-align: center;
    }

    #loading>img {
      position: absolute;
      top: 40%;
      left: 45%;
      z-index: 100;
    }

    #loading>p {
      position: absolute;
      top: 57%;
      left: 43%;
      z-index: 101;
    }
.row{
   margin: 0px auto;
   width:100%;
}
pre{
   white-space: pre-wrap;
   border: none;
   background-color: white;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	    $('#keywords').keydown(function(key){
    	if(key.keyCode==13)
    	{
    		$('pre').remove();
    		chatGPT();
    	}
    })
})
</script>
</head>
<body>
<!-- <div class="wrap">
   <div class="search">
      <input type="text" class="searchTerm" placeholder="무엇이든 물어보세요"
       id="keywords" name="keywords" required
      >
      <button class="searchButton" onclick="chatGPT()">
        <i class="fa fa-search"></i>
     </button>
     <div id="result" style="white-space: pre-wrap;"></div>
   </div>
   
</div>
-->
<div class="container-fluid">
<div class="row">
 <div class="flexbox">
  <div class="search">
    <h1>무엇이든 물어 보세요</h1>
    <div>
      <input type="text" placeholder="Search . . ." id="keywords" name="keywords" required>
    </div>
  </div>
</div>
</div>
<div style="height: 20px"></div>
  <div class="row">
   <div id="result">
   </div>
  </div>
  <div id="loading">
    <img src="https://studentrights.sen.go.kr/images/common/loading.gif">
  </div>
</div>
  <script>
    $(document).ready(function () {
      $('#loading').hide();
    });

    function chatGPT() {
      const api_key = "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" 
      const keywords = document.getElementById('keywords').value
      $('#loading').show();

      const messages = [
        { role: 'system', content: 'You are a helpful assistant.' },
        { role: 'user', content: keywords + '' },
      ]

      const data = {
        model: 'gpt-3.5-turbo',
        temperature: 0.5,
        n: 1,
        messages: messages,
      }

      $.ajax({
        url: "https://api.openai.com/v1/chat/completions",
        method: 'POST',
        headers: {
          Authorization: "Bearer " + api_key,
          'Content-Type': 'application/json',
        },
        data: JSON.stringify(data),
      }).then(function (response) {
        $('#loading').hide();
        console.log(response)
        let result = document.getElementById('result')
        let pre = document.createElement('pre')

        pre.innerHTML = "\n\n" + response.choices[0].message.content
        result.appendChild(pre)

        document.getElementById('keywords').value = ''
      });
    }
  </script>
</body>
</html>