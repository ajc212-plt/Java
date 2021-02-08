<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url("/fom/css/sign.css");
</style>
<script type="text/javascript">
   function setThumbnail2(event) {
      var text = document.getElementById("dir_thumbnail");
      var img = document.createElement("img");
      img.setAttribute("src", text.value);
      img.setAttribute("style", "width:30%");
      if (document.querySelector("div#preview2").hasChildNodes()) {
         document.querySelector("div#preview2").lastElementChild.remove();
      }
      document.querySelector("div#preview2").appendChild(img);
   }
</script>
</head>
<body>

   <section class="signbox">
      <h2>감독등록</h2>
      <form action="/fom/dirInsert.do">
         <div>
            <input type="text" name="dir_thumbnail" id="text"> <input
               type="button" onclick="setThumbnail2(event);" value="버튼">
            <div id="preview2" style="max-width: 550px">
               <input type="hidden" />
            </div>
         </div>
         <ul>
            <li><input type="text" name="dir_code" placeholder="감독코드">
            </li>
            <li><input type="text" name="name" placeholder="감독이름"></li>
            
            <li><button type="submit">등록</button></li>
         </ul>
      </form>
   </section>

</body>
</html>