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
      var text = document.getElementById("text");
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
      <h2>배우등록</h2>
      <form action="/fom/actorInsert.do">
         <div>
            <input type="text" name="actor_thumbnail" id="text"  placeholder="이미지"> <input
               type="button" onclick="setThumbnail2(event);" value="버튼">
            <div id="preview2" style="max-width: 550px">
               <input type="hidden" />
            </div>
         </div>
         <ul>
            <li><input type="text" name="actor_code" placeholder="배우코드">
            </li>
            <li><input type="text" name="name" placeholder="배우이름"></li>
            
            <li><button type="submit">등록</button></li>
            <!--onclick="window.open('/fom/actorInsertmove.do', 'actorinsertmove','width=900px, height=900px'); return false"  -->
            
            <li><button type="submit" onclick = "window.close()">취소</button></li>
         </ul>
      </form>
   </section>

</body>
</html>