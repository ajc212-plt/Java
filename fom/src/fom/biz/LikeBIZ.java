package fom.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fom.dao.LikeDaoImple;
import fom.vo.ActorVO;
import fom.vo.DirectorVO;
import fom.vo.MovieVO2;

@Service
public class LikeBIZ {

	@Autowired
	private LikeDaoImple likeDaoImple;

	public boolean member_movieinsert(String member_id, int movie_code) {
		return likeDaoImple.member_movieinsert(member_id, movie_code);
	}

	public boolean member_actorinsert(String member_id, int actor_code) {
		return likeDaoImple.member_actorinsert(member_id, actor_code);
	}

	public boolean member_dirinsert(String member_id, int dir_code) {
		return likeDaoImple.member_dirinsert(member_id, dir_code);
	}

	public List<ActorVO> member_actor_like(String member_id) {
		return likeDaoImple.member_actor_like(member_id);
	}

	public List<MovieVO2> member_movie_like(String member_id) {
		return likeDaoImple.member_movie_like(member_id);
	}

	public List<DirectorVO> member_dir_like(String member_id) {
		return likeDaoImple.member_dir_like(member_id);
	}

}
