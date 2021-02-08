package fom.biz;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fom.dao.ActorDaoImple;

import fom.vo.ActorVO;
import fom.vo.Actor_MovieVO;
import fom.vo.MovieVO2;

@Transactional(rollbackFor = Exception.class)
@Service
public class ActorBIZ {

	@Autowired
	private ActorDaoImple actorDaoImple;

	public List<ActorVO> Actorlistsearch(String name) {
		return actorDaoImple.Actorlistsearch(name);
	}

	public ActorVO ActorSpecificsearch(int actor_code) {
		return actorDaoImple.ActorSpecificsearch(actor_code);
	}

	public List<MovieVO2> Actorfilmography(int actor_code) {
		return actorDaoImple.Actorfilmography(actor_code);
	}
	
	public List<HashMap<String, Integer>> actor_like_gender(int actor_code){
			return actorDaoImple.actor_like_gender(actor_code);
		}
	public List<ActorVO> ActorAll() {
		return actorDaoImple.ActorAll();
	}
	
	public ActorVO ActorUpdateSearch(String actor_code) {
		return actorDaoImple.ActorUpdateSearch(actor_code);
	}

}
