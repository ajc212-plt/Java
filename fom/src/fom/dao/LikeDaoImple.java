package fom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import fom.vo.DirectorVO;
import fom.vo.MemberVO;
import fom.vo.MovieVO2;


@Repository
public class LikeDaoImple implements LikejdbcDAO {
   @Autowired
   private JdbcTemplate jdbctemplate;
   
   @Autowired
   private SimpleJdbcCall simpleJdbcCall;
   
   public SimpleJdbcCall createSimpleJdbcCall() {
      return new SimpleJdbcCall(this.jdbctemplate);
   }
   
   @Override
   public boolean member_movieinsert(String member_id, int movie_code) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("MOVIE_LIKE_RG");
      SqlParameterSource in = new MapSqlParameterSource().addValue("V_MEMBERID",member_id)
               .addValue("V_MOVIECODE",movie_code);
      Map out = call.execute(in);
      
      if(out != null) {
         fw=true;
      }else {
         fw=false;
      }
      return fw;
   }
   
   @Override
   public boolean member_actorinsert(String member_id, int actor_code) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("ACT_LIKE_RG");
      SqlParameterSource in = new MapSqlParameterSource().addValue("V_MEMBERID",member_id)
               .addValue("V_ACTORCODE", actor_code);
      Map out = call.execute(in);
      
      if(out != null) {
         fw=true;
      }else {
         fw=false;
      }
      return fw;
   }
   
   @Override
   public boolean member_dirinsert(String member_id, int dir_code) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("DIR_LIKE_RG");
      SqlParameterSource in = new MapSqlParameterSource().addValue("V_MEMBERID",member_id)
               .addValue("V_DIRECTORCODE", dir_code);
      Map out = call.execute(in);
      
      if(out != null) {
         fw=true;
      }else {
         fw=false;
      }
      return fw;
   }
   @Override
   public List<ActorVO> member_actor_like(String member_id) {
	   SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("ACTLIKE_MEMBER");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VMEMBER_ID", member_id);

		call.returningResultSet("myres", new RowMapper<ActorVO>() {
			// actorVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public ActorVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ActorVO vo = new ActorVO();
				vo.setMember_id(rs.getString("MEMBER_ID"));
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
   public List<MovieVO2> member_movie_like(String member_id) {
	   SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MOVLIKE_MEMBER");

		SqlParameterSource in = new MapSqlParameterSource().addValue("VMEMBER_ID", member_id);

		call.returningResultSet("myres", new RowMapper<MovieVO2>() {
			// actorVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public MovieVO2 mapRow(ResultSet rs, int rowNum) throws SQLException {
				MovieVO2 vo = new MovieVO2();
				vo.setMember_id(rs.getString("MEMBER_ID"));
				vo.setName(rs.getString("TITLE"));
				vo.setMoviecode(rs.getInt("MOVIE_CODE"));
				vo.setImage(rs.getString("THUMBNAIL"));
				
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
   public List<DirectorVO> member_dir_like(String member_id){
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("DIRLIKE_MEMBER");
      
      SqlParameterSource in = new MapSqlParameterSource().addValue("VMEMBER_ID", member_id);
      call.returningResultSet("myres", new RowMapper<DirectorVO>() {
        public DirectorVO mapRow(ResultSet rs, int rowNum) throws SQLException{
           DirectorVO vo = new DirectorVO();
           vo.setMember_id(rs.getString("MEMBER_ID"));
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
   
   
}