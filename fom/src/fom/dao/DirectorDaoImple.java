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
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import fom.vo.DirectorVO;
import fom.vo.MovieVO2;

@Repository
public class DirectorDaoImple implements DirectorjdbcDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	// 검색 배우 리스트 조회
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbctemplate);
	}
	/*
	 * public List<DirectorVO> Directorlistsearch(String dir_name) {
	 * List<DirectorVO> directors = jdbctemplate.query("select dir_name, dir_code "+
	 * "from director " + "where dir_name = ? ", new Object[] {
	 * String.valueOf(dir_name) }, new RowMapper<DirectorVO>() { public DirectorVO
	 * mapRow(ResultSet rs, int rowNum) throws SQLException { DirectorVO director =
	 * new DirectorVO(); director.setDir_code(rs.getInt("dir_code"));
	 * director.setDir_name(rs.getString("dir_name")); return director; } }); return
	 * directors; }
	 */
	@Override
	public List<DirectorVO> Directorlistsearch(String name) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("DIR_LIST");
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("VDIR_NAME", name);
		
		// System.out.println(out);
		call.returningResultSet("myres01", new RowMapper<DirectorVO>() {
			public DirectorVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				DirectorVO dir = new DirectorVO();
				dir.setDir_code(rs.getInt("DIR_CODE"));
				dir.setName(rs.getString("DIR_NAME"));
				dir.setDir_thumbnail(rs.getString("DIR_THUMBNAIL"));
				return dir;
			}
		});
		Map<String, Object> out = call.execute(in);
		System.out.println(out);
		List<DirectorVO> all = (List<DirectorVO>) out.get("myres01");
		
		return all;
	}

	/*
	 * public DirectorVO DirectorSpecificsearch(int dir_code) { simpleJdbcCall
	 * .withProcedureName("DIR_PROFILE"); SqlParameterSource in = new
	 * MapSqlParameterSource() .addValue("VDIR_CODE", dir_code); Map<String, Object>
	 * out = simpleJdbcCall.execute(in);
	 * 
	 * simpleJdbcCall.returningResultSet("directorVO", new RowMapper<DirectorVO>() {
	 * public DirectorVO mapRow(ResultSet rs, int rowNum) throws SQLException{
	 * DirectorVO VO= new DirectorVO(); VO.setDir_code(rs.getInt("DIR_CODE"));
	 * VO.setDir_name(rs.getString("DIR_NAME")); return VO; } });
	 * 
	 * DirectorVO all = (DirectorVO) out.get("MYRES"); return all; }
	 */
	@Override
	public DirectorVO DirectorSpecificsearch(int dir_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("DIR_PROFILE");
		SqlParameterSource in = new MapSqlParameterSource().addValue("VDIR_CODE", dir_code);
		System.out.println("dasfsd");
		Map out = call.execute(in);
		System.out.println(out);

		DirectorVO VO = new DirectorVO();
		//int code = Integer.parseInt(String.valueOf(out.get("DIR_CODE")));
		VO.setDir_code(Integer.parseInt(String.valueOf(out.get("DIR_CODE"))));
		VO.setName(((String) out.get("DIR_NAME")));
		VO.setDir_thumbnail((String) out.get("DIR_THUMBNAIL"));
		return VO;

	}
	 @Override
	   public List<MovieVO2> DirectorFilmography(int dir_code) {
	      SimpleJdbcCall call = createSimpleJdbcCall();
	      call.withProcedureName("FILMOGRAPHY_DIR");
	      System.out.println(dir_code);
	      SqlParameterSource in = new MapSqlParameterSource()
	            .addValue("VDIR_CODE", dir_code);
	      call.returningResultSet("myres", new RowMapper<MovieVO2>() {
	         public MovieVO2 mapRow(ResultSet rs, int rowNum) throws SQLException{
	            MovieVO2 vo = new MovieVO2();
	            vo.setName(rs.getString("TITLE"));
	            vo.setOpen_date(rs.getString("OPEN_DATE"));
	            vo.setGross(rs.getLong("GROSS"));
	            vo.setViewer(rs.getLong("VIEWER"));
	            vo.setMoviecode(rs.getInt("MOVIE_CODE"));
	            vo.setNetizen_score(rs.getString("NETIZEN_SCORE"));
	            vo.setExpert_score(rs.getString("EXPERT_SCORE"));
	            vo.setDir_code(rs.getInt("DIR_CODE"));
	            return vo;
	         }
	      });
	      Map<String, Object> out = call.execute(in);
	      
	      System.out.println(out);
	      List<MovieVO2> all = (List<MovieVO2>) out.get("myres");
	      System.out.println(all);
	      return all;
	   }
	 
	@Override 
	public List<HashMap<String, Integer>> dir_like_gender(int dir_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("dir_like_gender");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VDIR_CODE", dir_code);

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
	
	public List<DirectorVO> DirectorAll(){
		 SimpleJdbcCall call = createSimpleJdbcCall();
		 call.withProcedureName("DIR_ALL");
		 
		 SqlParameterSource in = new MapSqlParameterSource();
		 call.returningResultSet("myres", new RowMapper<DirectorVO>() {
			 public DirectorVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				 DirectorVO vo = new DirectorVO();
				 vo.setDir_code(rs.getInt("DIR_CODE"));
				 vo.setName(rs.getString("DIR_NAME"));
				 vo.setDir_thumbnail(rs.getString("DIR_THUMBNAIL"));
				 return vo;
			 }
		 });
		 Map<String, Object> out = call.execute(in);
		 System.out.println(out);
		 List<DirectorVO> all = (List<DirectorVO>) out.get("myres");
		 System.out.println(call.getProcedureName());
		 
		 return all;
	 }
	public DirectorVO DirectorUpdateSearch(String dir_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("DIR_UPDATE_SEARCH");
		SqlParameterSource in = new MapSqlParameterSource().addValue("VDIR_CODE", Integer.parseInt(dir_code));
		Map out = call.execute(in);
		
		DirectorVO vo = new DirectorVO();
		
		vo.setDir_code(Integer.parseInt(String.valueOf(out.get("DIR_CODE"))));
		vo.setName((String)out.get("DIR_NAME"));
		vo.setDir_thumbnail((String)out.get("DIR_THUMBNAIL"));
		
		return vo;
	}

	/*
	 * public DirectorVO DirectorSpecificsearch(int dir_code) { DirectorVO directors
	 * = jdbctemplate.queryForObject("select dir_name, dir_code "+ "from director "+
	 * "where dir_code= ? ", new Object[] { String.valueOf(dir_code) }, new
	 * RowMapper<DirectorVO>() { public DirectorVO mapRow(ResultSet rs, int rowNum)
	 * throws SQLException { DirectorVO director = new DirectorVO();
	 * director.setDir_code(rs.getInt("dir_code"));
	 * director.setDir_name(rs.getString("dir_name")); return director; } }); return
	 * directors; }
	 */

	/*
	 * @Override public MovieVO2 Actorfilmography(int actor_code) { MovieVO2 movies
	 * = this.getJdbcTemplate().queryForObject("call filmography_actor(?)", new
	 * Object[] { String.valueOf(actor_name) }, new RowMapper<ActorVO>() { public
	 * ActorVO mapRow(ResultSet rs, int rowNum) throws SQLException { ActorVO actor
	 * = new ActorVO(); actor.setActor_code(rs.getInt("actor_code"));
	 * actor.setActor_name(rs.getString("actor_name")); return actor; } }); return
	 * actors; }
	 */
}
