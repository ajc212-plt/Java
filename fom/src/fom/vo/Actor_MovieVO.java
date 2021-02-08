package fom.vo;

public class Actor_MovieVO {
	private int movie_code;
	private int actor_code;
	private String hero;
	private String part;
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
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	@Override
	public String toString() {
		return "Actor_MovieVO [movie_code=" + movie_code + ", actor_code=" + actor_code + ", hero=" + hero + ", part="
				+ part + "]";
	}
	public Actor_MovieVO() {
		
	}
	
	
	
}
