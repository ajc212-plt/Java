package fom.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fom.vo.ActorVO;
import fom.vo.DirectorVO;
import fom.vo.MemberVO;
import fom.vo.MovieVO2;

@Repository
public interface LikejdbcDAO {
	boolean member_movieinsert(String member_id, int movie_code);

	boolean member_actorinsert(String member_id, int actor_code);

	boolean member_dirinsert(String member_id, int dir_code);

	List<ActorVO> member_actor_like(String member_id);

	List<MovieVO2> member_movie_like(String member_id);

	List<DirectorVO> member_dir_like(String member_id);
}
