package fom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import org.springframework.stereotype.Repository;

import fom.vo.ActorVO;
import fom.vo.Actor_MovieVO;
import fom.vo.MovieVO2;


@Repository
public class ActorDaoImple implements ActorjdbcDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private SimpleJdbcCall simpleJdbcCall; // static 상태이다 -> 그렇기때문에 계속 프로시저가 계속 돈다
	// 검색 배우 리스트 조회

	public SimpleJdbcCall createSimpleJdbcCall() { // simplejdbccall의 객체를 생성하여 리턴단계를 명시하여 복귀점을 만들었다.
		// query for(jdbctemplate)은 자동 소멸된다.
		// 주소가 계속 하나였다 -> single tone(static) -> scope = "prototype"
		return new SimpleJdbcCall(this.jdbctemplate);
	}
	// 중요 -> client - dao - db

	// jdbctemplate(datasoruce)

	/*
	 * public List<ActorVO> Actorlistsearch(String actor_name) { List<ActorVO>
	 * actors = jdbctemplate.query("select actor_name, actor_code "+ "from actor " +
	 * "where actor_name = ? ", new Object[] { String.valueOf(actor_name) }, new
	 * RowMapper<ActorVO>() { public ActorVO mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { ActorVO actor = new ActorVO();
	 * actor.setActor_code(rs.getInt("actor_code"));
	 * actor.setActor_name(rs.getString("actor_name")); return actor; } }); return
	 * actors; }
	 */
	@Override
	public List<ActorVO> Actorlistsearch(String name) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ACTOR_LIST");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_NAME", name);

		call.returningResultSet("myres", new RowMapper<ActorVO>() {
			// actorVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public ActorVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ActorVO vo = new ActorVO();
				vo.setActor_code(rs.getInt("ACTOR_CODE"));
				vo.setName(rs.getString("ACTOR_NAME"));
				vo.setActor_thumbnail(rs.getString("ACTOR_THUMBNAIL"));
				return vo;
			}
		});
		Map<String, Object> out = call.execute(in);

		System.out.println(out);
		List<ActorVO> all = (List<ActorVO>) out.get("myres");
		System.out.println(call.getProcedureName());

		return all;
	}
	
	@Override
	public List<MovieVO2> Actorfilmography(int actor_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("FILMOGRAPHY_ACTOR");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_CODE", actor_code);

		call.returningResultSet("myres", new RowMapper<MovieVO2>() {
			// actorVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public MovieVO2 mapRow(ResultSet rs, int rowNum) throws SQLException {
				MovieVO2 vo = new MovieVO2();
	            vo.setName(rs.getString("TITLE"));
	            vo.setOpen_date(rs.getString("OPEN_DATE"));
	            vo.setGross(rs.getLong("GROSS"));
	            vo.setViewer(rs.getLong("VIEWER"));
	            vo.setMoviecode(rs.getInt("MOVIE_CODE"));
	            vo.setNetizen_score(rs.getString("NETIZEN_SCORE"));
	            vo.setExpert_score(rs.getString("EXPERT_SCORE"));
	            vo.setActor_code(rs.getInt("ACTOR_CODE"));
	            return vo;
	      

			}
		});
		Map<String, Object> out = call.execute(in);

		System.out.println(out);
		List<MovieVO2> all = (List<MovieVO2>) out.get("myres");
		System.out.println(call.getProcedureName());

		return all;
	}

	@Override
	public ActorVO ActorSpecificsearch(int actor_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ACTOR_PROFILE");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_CODE", actor_code);
		Map out = call.execute(in);

		ActorVO VO = new ActorVO();
		VO.setActor_code(Integer.parseInt(String.valueOf(out.get("ACTOR_CODE"))));
		VO.setName(((String) out.get("ACTOR_NAME")));
		VO.setActor_thumbnail((String) out.get("ACTOR_THUMBNAIL"));
		System.out.println(call.getProcedureName());

		return VO;
	}
	/*
	 * public ActorVO ActorSpecificsearch(int actor_code) { ActorVO actors =
	 * jdbctemplate.queryForObject("select actor_name, actor_code "+ "from actor "+
	 * "where actor_code= ? ", new Object[] { String.valueOf(actor_code) }, new
	 * RowMapper<ActorVO>() { public ActorVO mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { ActorVO actor = new ActorVO();
	 * actor.setActor_code(rs.getInt("actor_code"));
	 * actor.setActor_name(rs.getString("actor_name")); return actor; } }); return
	 * actors; }
	 */

	@Override
	public List<HashMap<String, Integer>> actor_like_gender(int actor_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("actor_like_gender");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_CODE", actor_code);

		call.returningResultSet("myres", new RowMapper<HashMap<String, Integer>>() {
			// actorVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public HashMap<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
				HashMap<String, Integer> mymap = new HashMap<String, Integer>();
				mymap.put(rs.getString("GENDER"), rs.getInt("COUNT(GENDER)"));
				return mymap;
			}
		});
		Map<String, Object> out = call.execute(in);

		System.out.println(out);
		List<HashMap<String, Integer>> all = (List<HashMap<String, Integer>>) out.get("myres");
		System.out.println(call.getProcedureName());
		System.out.println("myres : " + all);
		return all;
	}
	public List<ActorVO> ActorAll() {
		SimpleJdbcCall call = createSimpleJdbcCall();
	      call.withProcedureName("ACTOR_ALL");
	      
	      SqlParameterSource in = new MapSqlParameterSource();
	      call.returningResultSet("myres", new RowMapper<ActorVO>() {
	         public ActorVO mapRow(ResultSet rs, int rowNum) throws SQLException{
	        	 ActorVO vo = new ActorVO();
	            vo.setActor_code(rs.getInt("ACTOR_CODE"));
	            vo.setName(rs.getString("ACTOR_NAME"));
	            vo.setActor_thumbnail(rs.getString("ACTOR_THUMBNAIL"));
	            return vo;      
	      }
	      });
	      Map<String, Object> out = call.execute(in);
	      System.out.println(out);
	      List<ActorVO> all = (List<ActorVO>) out.get("myres");
	      System.out.println(call.getProcedureName());
	      
	      return all;
	   }
	
	public ActorVO ActorUpdateSearch(String actor_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ACT_UPDATE_SEARCH");
		SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_CODE", Integer.parseInt(actor_code));
		Map out = call.execute(in);
		
		ActorVO vo = new ActorVO();
		
		vo.setActor_code(Integer.parseInt(String.valueOf(out.get("ACTOR_CODE"))));
		vo.setName((String)out.get("ACTOR_NAME"));
		vo.setActor_thumbnail((String)out.get("ACTOR_THUMBNAIL"));
		
		return vo;
	}
	

}
