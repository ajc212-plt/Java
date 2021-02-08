package fom.vo;

public class MovieVO2 {

	private String name;
	private String open_date;
	private long gross;
	private long viewer;
	private String country;
	private String distribution;
	private String link;
	private int moviecode;
	private String image;
	private int py;
	private String director;
	private String genres;
	private String expert_score;
	private String netizen_score;
	private int dir_code;
	private int actor_code;
	private String member_id;
	private int member_code;
	private String story;
	
	

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

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getDir_code() {
		return dir_code;
	}

	public void setDir_code(int dir_code) {
		this.dir_code = dir_code;
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

	public String getOpen_date() {
		return open_date;
	}

	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}

	public long getGross() {
		return gross;
	}

	public void setGross(long gross) {
		this.gross = gross;
	}

	public long getViewer() {
		return viewer;
	}

	public void setViewer(long viewer) {
		this.viewer = viewer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistribution() {
		return distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getMoviecode() {
		return moviecode;
	}

	public void setMoviecode(int moviecode) {
		this.moviecode = moviecode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	

	public String getExpert_score() {
		return expert_score;
	}

	public void setExpert_score(String expert_score) {
		this.expert_score = expert_score;
	}

	public String getNetizen_score() {
		return netizen_score;
	}

	public void setNetizen_score(String netizen_score) {
		this.netizen_score = netizen_score;
	}



	


	@Override
	public String toString() {
		return "MovieVO2 [name=" + name + ", open_date=" + open_date + ", gross=" + gross + ", viewer=" + viewer
				+ ", country=" + country + ", distribution=" + distribution + ", link=" + link + ", moviecode="
				+ moviecode + ", image=" + image + ", py=" + py + ", director=" + director + ", genres=" + genres
				+ ", expert_score=" + expert_score + ", netizen_score=" + netizen_score + ", dir_code=" + dir_code
				+ ", actor_code=" + actor_code + ", member_id=" + member_id + ", member_code=" + member_code
				+ ", story=" + story + "]";
	}

	public MovieVO2(
			) {
		
	}

}
