package fom.vo;

public class MemberVO {
	private int member_code;
	private String member_id;
	private String password;
	private int age;
	private String gender;
	private int movie_code;
	private int actor_code;
	private int dir_code;
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMovie_code() {
		return movie_code;
	}
	public void setMovie_code(int movie_code) {
		this.movie_code = movie_code;
	}
	public int getActor_code() {
		return actor_code;
	}
	public void setActor_code(int actor_code) {
		this.actor_code = actor_code;
	}
	public int getDir_code() {
		return dir_code;
	}
	public void setDir_code(int dir_code) {
		this.dir_code = dir_code;
	}
	@Override
	public String toString() {
		return "MemberVO [member_code=" + member_code + ", member_id=" + member_id + ", password=" + password + ", age="
				+ age + ", gender=" + gender + ", movie_code=" + movie_code + ", actor_code=" + actor_code
				+ ", dir_code=" + dir_code + "]";
	}
	
	
	
}
