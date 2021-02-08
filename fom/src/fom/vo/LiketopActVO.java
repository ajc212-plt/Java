package fom.vo;

public class LiketopActVO {
   
   private int actor_code;
   private int num;
   private String actor_thumbnail;
   
   
   public String getActor_thumbnail() {
      return actor_thumbnail;
   }
   public void setActor_thumbnail(String actor_thumbnail) {
      this.actor_thumbnail = actor_thumbnail;
   }
   public int getActor_code() {
      return actor_code;
   }
   public void setActor_code(int actor_code) {
      this.actor_code = actor_code;
   }
   
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   
   public LiketopActVO() {}
   
   @Override
   public String toString() {
      return "LiketopActVO [actor_code=" + actor_code + ", num=" + num + ", actor_thumbnail=" + actor_thumbnail + "]";
   }
   
   
   
}