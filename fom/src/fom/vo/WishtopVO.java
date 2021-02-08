package fom.vo;

public class WishtopVO {
   
   private int movie_code;
   private int num;
   private String thumbnail;
   
   public int getMovie_code() {
      return movie_code;
   }
   
   public void setMovie_code(int movie_code) {
      this.movie_code = movie_code;
   }
   
   public int getNum() {
      return num;
   }
   
   public void setNum(int num) {
      this.num = num;
   }
   
   public String getThumbnail() {
      return thumbnail;
   }

   public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
   }

   
   
   @Override
   public String toString() {
      return "WishtopVO [movie_code=" + movie_code + ", num=" + num + ", thumbnail=" + thumbnail + "]";
   }

   public WishtopVO() {}
   
   
}