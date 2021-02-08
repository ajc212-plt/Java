package fom.vo;

public class LiketopMVO {
   
   private int movie_code;
   private int num;
   private String thumbnail;
   
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   
   public LiketopMVO() {}
   public int getMovie_code() {
      return movie_code;
   }
   public void setMovie_code(int movie_code) {
      this.movie_code = movie_code;
   }
   public String getThumbnail() {
      return thumbnail;
   }
   public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
   }
   @Override
   public String toString() {
      return "LiketopMVO [movie_code=" + movie_code + ", num=" + num + ", thumbnail=" + thumbnail + "]";
   }
   

   
   
   
}