package fom.biz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fom.dao.MovieDaoImple;
import fom.vo.MovieVO2;

@Service
public class MovieBIZ {

	@Autowired
	private MovieDaoImple movieDaoImple;
	
	public List<MovieVO2> Movielistsearch(String name){
		return movieDaoImple.Movielistsearch(name);
	}
	
	
	public MovieVO2 MovieSpecificsearch(int moviecode) {
	      return movieDaoImple.MovieSpecificsearch(moviecode);
	   }
	
	public List<HashMap<String, Integer>> Wishmem_Gender(int movie_code){
		return movieDaoImple.Wishmem_Gender(movie_code);
	}
	
	public List<HashMap<String, Integer>> movie_like_gender(int movie_code){
		return movieDaoImple.movie_like_gender(movie_code);
	}
	public List<MovieVO2> MovieAll(){
		return movieDaoImple.MovieAll();
	}
	public MovieVO2 MovieUpdateSearch(String moviecode) {
		return movieDaoImple.MovieUpdateSearch(moviecode);
	}
}
