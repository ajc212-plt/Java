package fom.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fom.vo.ActorVO;
import fom.vo.Actor_MovieVO;
import fom.vo.MovieVO2;

@Repository
public interface ActorjdbcDao {
	public List<ActorVO> Actorlistsearch(String actor_name);
	public ActorVO ActorSpecificsearch(int actor_code);
	public List<MovieVO2> Actorfilmography(int actor_code);
	List<HashMap<String, Integer>> actor_like_gender(int actor_code);

}
