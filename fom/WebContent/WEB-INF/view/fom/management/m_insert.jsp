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
      var text = document.getElementById("image");
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
      <h2>영화등록</h2>
      <form action="/fom/movieInsert.do">
         <div>
            <input type="text" name="image" id="text"  placeholder="이미지"> <input
               type="button" onclick="setThumbnail2(event);" value="버튼">
            <div id="preview2" style="max-width: 550px">
               <input type="hidden" />
            </div>
         </div>
         
            <input type="text" name="moviecode" placeholder="영화코드">
            <input type="text" name="name" placeholder="영화이름"><br>
            <input type="text" name="open_date" placeholder="개봉일">
            <input type="text" name="gross" placeholder="매출액"><br>
            <input type="text" name="viewer" placeholder="관람객수">   
            <input type="text" name="country" placeholder="국가"><br>
            <input type="text" name="distribution" placeholder="배급사">
            <input type="text" name="link" placeholder="영화링크"><br>
            <input type="text" name="py" placeholder="제작년도">
            <input type="text" name="director" placeholder="감독"><br>
            <input type="text" name="genres" placeholder="장르">
            <input type="text" name="expert_score" placeholder="평론가평점"><br>
            <input type="text" name="netizen_score" placeholder="네티즌평점">
            <input type="text" name="story" placeholder="스토리"><br>         
            <button type="submit">등록</button>
         
      </form>
   </section>

</body>
</html>
