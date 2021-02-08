package fom.vo;

import java.util.Date;

public class DirectorVO {
	private int dir_code;
	private String name;
	private String dir_thumbnail;
	private String member_id;
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getDir_thumbnail() {
		return dir_thumbnail;
	}
	public void setDir_thumbnail(String dir_thumbnail) {
		this.dir_thumbnail = dir_thumbnail;
	}
	public int getDir_code() {
		return dir_code;
	}
	public void setDir_code(int dir_code) {
		this.dir_code = dir_code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DirectorVO() {
	}
	@Override
	public String toString() {
		return "DirectorVO [dir_code=" + dir_code + ", name=" + name + ", dir_thumbnail=" + dir_thumbnail
				+ ", member_id=" + member_id + "]";
	}

	
	
}
