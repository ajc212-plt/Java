package fom.vo;

public class NetworkVO {
	
	private int actor_code;
	private String search_name;
	private String name;
	private int code;
	private int count;
	private int job;
	
	public NetworkVO() {
		super();
	}

	public NetworkVO(int actor_code, String search_name, String name, int code, int count, int job) {
		super();
		this.actor_code = actor_code;
		this.search_name = search_name;
		this.name = name;
		this.code = code;
		this.count = count;
		this.job = job;
	}

	public int getActor_code() {
		return actor_code;
	}

	public void setActor_code(int actor_code) {
		this.actor_code = actor_code;
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getJob() {
		return job;
	}

	public void setJob(int job) {
		this.job = job;
	}
	
	
	
	
}
