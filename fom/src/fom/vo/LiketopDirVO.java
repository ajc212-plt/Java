package fom.vo;

public class LiketopDirVO {
   
   private int dir_code;
   private int num;
   private String dir_thumbnail;
   
   
   
   
   @Override
   public String toString() {
      return "LiketopDirVO [dir_code=" + dir_code + ", num=" + num + ", dir_thumbnail=" + dir_thumbnail + "]";
   }
   public int getDir_code() {
      return dir_code;
   }
   public void setDir_code(int dir_code) {
      this.dir_code = dir_code;
   }
   public String getDir_thumbnail() {
      return dir_thumbnail;
   }
   public void setDir_thumbnail(String dir_thumbnail) {
      this.dir_thumbnail = dir_thumbnail;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   
   public LiketopDirVO() {}
   
   
   
   
   
}