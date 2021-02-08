package fom.biz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fom.dao.ActorjdbcDao;
import fom.dao.DirectorDaoImple;
import fom.dao.DirectorjdbcDao;
import fom.vo.ActorVO;
import fom.vo.DirectorVO;
import fom.vo.MovieVO2;



@Service
public class DirectorBIZ {

	@Autowired
	private DirectorDaoImple directorDaoImple;
	
	public List<DirectorVO> Directorlistsearch(String name) {
	 return directorDaoImple.Directorlistsearch(name);	
	}
	
	public DirectorVO DirectorSpecificsearch(int dir_code) {
		return directorDaoImple.DirectorSpecificsearch(dir_code);
	}
	public List<MovieVO2> DirectorFilmography(int dir_code){
	      return directorDaoImple.DirectorFilmography(dir_code);
	   }

	public List<HashMap<String, Integer>> dir_like_gender(int dir_code) {
		return directorDaoImple.dir_like_gender(dir_code);
	}
	public List<DirectorVO> DirectorAll(){
		return directorDaoImple.DirectorAll();
	}
	
	public DirectorVO DirectorUpdateSearch(String dir_code) {
		return directorDaoImple.DirectorUpdateSearch(dir_code);
	}

}
