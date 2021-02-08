package fom.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import fom.vo.ActorVO;
import fom.vo.DirectorVO;
import fom.vo.MovieVO2;

@Service
public interface DirectorjdbcDao {
	public List<DirectorVO> Directorlistsearch(String dir_name);
	public DirectorVO DirectorSpecificsearch(int dir_code);
	public List<MovieVO2> DirectorFilmography(int dir_code);
	List<HashMap<String, Integer>> dir_like_gender(int dir_code);

}
