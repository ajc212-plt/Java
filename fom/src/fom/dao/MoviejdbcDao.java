package fom.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import fom.vo.MovieVO2;

@Repository
public interface MoviejdbcDao {

	public List<MovieVO2> Movielistsearch(String title);
	public MovieVO2 MovieSpecificsearch(int movie_code);
	public List<HashMap<String, Integer>> Wishmem_Gender(int movie_code);
	List<HashMap<String, Integer>> movie_like_gender(int movie_code);
	public List<MovieVO2> MovieAll();
}
