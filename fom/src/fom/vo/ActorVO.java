package fom.vo;

import java.util.Date;

public class ActorVO {
	private int actor_code;
	private String name;
	private String actor_thumbnail;
	private String member_id;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ActorVO [actor_code=" + actor_code + ", name=" + name + ", actor_thumbnail=" + actor_thumbnail
				+ ", member_id=" + member_id + "]";
	}
	
	public ActorVO() {
		
	}
	
	
}
