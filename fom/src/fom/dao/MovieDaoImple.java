package fom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import fom.vo.MovieVO2;

@Repository
public class MovieDaoImple implements MoviejdbcDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbctemplate);
	}
	
	@Override
	public List<MovieVO2> Movielistsearch(String title){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MOVIE_LIST");
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("VTITLE", title);
		
		call.returningResultSet("myres", new RowMapper<MovieVO2>(){
			public MovieVO2 mapRow(ResultSet rs, int rowNum) throws SQLException{
				MovieVO2 vo = new MovieVO2();
				vo.setName(rs.getString("TITLE"));
				vo.setOpen_date(rs.getString("OPEN_DATE"));
				vo.setGross(rs.getLong("GROSS"));
				vo.setViewer(rs.getLong("VIEWER"));
				vo.setCountry(rs.getString("COUNTRY"));
				vo.setDistribution(rs.getString("DISTRIBUTION"));
				vo.setMoviecode(rs.getInt("MOVIE_CODE"));
				vo.setImage(rs.getString("THUMBNAIL"));
				vo.setPy(rs.getInt("PY"));
				vo.setDirector(rs.getString("DIRECTOR"));
				vo.setGenres(rs.getString("GENRES"));
				vo.setExpert_score(rs.getString("EXPERT_SCORE"));
				vo.setNetizen_score(rs.getString("NETIZEN_SCORE"));
				vo.setStory(rs.getString("STORY"));
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
    public MovieVO2 MovieSpecificsearch(int moviecode) {
       SimpleJdbcCall call = createSimpleJdbcCall();
       call.withProcedureName("MOVIE_PROFILE");
       SqlParameterSource in = new MapSqlParameterSource().addValue("VMOVIE_CODE", moviecode);
       Map out = call.execute(in);
       System.out.println(out);

       MovieVO2 vo = new MovieVO2();
       //int code = Integer.parseInt(String.valueOf(out.get("DIR_CODE")));
       vo.setName((String) out.get("TITLE"));
       vo.setOpen_date((String) out.get("OPEN_DATE"));
       vo.setGross(Long.parseLong(String.valueOf(out.get("GROSS"))));
       vo.setViewer(Long.parseLong(String.valueOf(out.get("VIEWER"))));
       vo.setCountry((String) out.get("COUNTRY"));
       vo.setDistribution((String) out.get("DISTRIBUTION"));
       vo.setMoviecode(Integer.parseInt(String.valueOf(out.get("MOVIE_CODE"))));
       vo.setImage((String) out.get("THUMBNAIL"));
       vo.setPy(Integer.parseInt(String.valueOf(out.get("PY"))));
       vo.setDirector((String) out.get("DIRECTOR"));
       vo.setGenres((String) out.get("GENRES"));
       vo.setExpert_score(String.valueOf(out.get("EXPERT_SCORE")));
       vo.setNetizen_score(String.valueOf(out.get("NETIZEN_SCORE")));
       vo.setStory(((String) out.get("STORY")));
       
       return vo;

    }
	
	
	@Override
	public List<HashMap<String, Integer>> Wishmem_Gender(int movie_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("wishmem_gender");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VMOVIE_CODE", movie_code);

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
	
	@Override
	public List<HashMap<String, Integer>> movie_like_gender(int movie_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("movie_like_gender");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VMOVIE_CODE", movie_code);

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
	
	@Override
	public List<MovieVO2> MovieAll() {
		SimpleJdbcCall call = createSimpleJdbcCall();
	      call.withProcedureName("MOVIE_ALL");
	      
	      SqlParameterSource in = new MapSqlParameterSource();
	      call.returningResultSet("myres", new RowMapper<MovieVO2>() {
	         public MovieVO2 mapRow(ResultSet rs, int rowNum) throws SQLException{
	        	 MovieVO2 vo = new MovieVO2();
	        	 	vo.setName(rs.getString("TITLE"));
					vo.setOpen_date(rs.getString("OPEN_DATE"));
					vo.setGross(rs.getLong("GROSS"));
					vo.setViewer(rs.getLong("VIEWER"));
					vo.setCountry(rs.getString("COUNTRY"));
					vo.setDistribution(rs.getString("DISTRIBUTION"));
					vo.setMoviecode(rs.getInt("MOVIE_CODE"));
					vo.setImage(rs.getString("THUMBNAIL"));
					vo.setPy(rs.getInt("PY"));
					vo.setDirector(rs.getString("DIRECTOR"));
					vo.setGenres(rs.getString("GENRES"));
					vo.setExpert_score(rs.getString("EXPERT_SCORE"));
					vo.setNetizen_score(rs.getString("NETIZEN_SCORE"));
					vo.setStory(rs.getString("STORY"));
					return vo;    
	      }
	      });
	      Map<String, Object> out = call.execute(in);
	      System.out.println(out);
	      List<MovieVO2> all = (List<MovieVO2>) out.get("myres");
	      System.out.println(call.getProcedureName());
	      
	      return all;
	   }
	public MovieVO2 MovieUpdateSearch(String moviecode) {
	       SimpleJdbcCall call = createSimpleJdbcCall();
	       call.withProcedureName("MOVIE_UPDATE_SEARCH");
	       SqlParameterSource in = new MapSqlParameterSource().addValue("VMOVIE_CODE", Integer.parseInt(moviecode));
	       Map out = call.execute(in);
	       

	       MovieVO2 vo = new MovieVO2();
	       //int code = Integer.parseInt(String.valueOf(out.get("DIR_CODE")));
	       vo.setName((String) out.get("TITLE"));
	       vo.setOpen_date((String) out.get("OPEN_DATE"));
	       vo.setGross(Long.parseLong(String.valueOf(out.get("GROSS"))));
	       vo.setViewer(Long.parseLong(String.valueOf(out.get("VIEWER"))));
	       vo.setCountry((String) out.get("COUNTRY"));
	       vo.setDistribution((String) out.get("DISTRIBUTION"));
	       vo.setLink((String)out.get("LINK"));
	       vo.setMoviecode(Integer.parseInt(String.valueOf(out.get("MOVIE_CODE"))));
	       vo.setImage((String) out.get("THUMBNAIL"));
	       vo.setPy(Integer.parseInt(String.valueOf(out.get("PY"))));
	       vo.setDirector((String) out.get("DIRECTOR"));
	       vo.setGenres((String) out.get("GENRES"));
	       vo.setExpert_score(String.valueOf(out.get("EXPERT_SCORE")));
	       vo.setNetizen_score(String.valueOf(out.get("NETIZEN_SCORE")));
	       vo.setStory(((String) out.get("STORY")));
	       
	       return vo;

	    }
}
