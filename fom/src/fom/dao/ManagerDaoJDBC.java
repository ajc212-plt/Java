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
import fom.vo.LiketopActVO;
import fom.vo.LiketopDirVO;
import fom.vo.LiketopMVO;
import fom.vo.MovieVO2;
import fom.vo.WishtopVO;

@Repository
public class ManagerDaoJDBC {
   @Autowired
   JdbcTemplate jdbcTemplate;
   @Autowired
   private SimpleJdbcCall simpleJdbcCall;

   public SimpleJdbcCall createSimpleJdbcCall() {
      return new SimpleJdbcCall(this.jdbcTemplate);
   }

   public boolean actorinsert(ActorVO vo) {

      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("ACTOR_INSERT");
      SqlParameterSource in = new MapSqlParameterSource()
    		.addValue("VACTOR_CODE", vo.getActor_code())
            .addValue("VACTOR_NAME", vo.getName())
            .addValue("VACTOR_THUMBNAIL", vo.getActor_thumbnail());
      Map out = call.execute(in);

      if (out != null) {
         fw = true;
      } else {
         fw = false;
      }
      return fw;
   }

   public boolean actordelete(ActorVO vo) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("ACTOR_DELETE");
      SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_CODE", vo.getActor_code());
      Map out = call.execute(in);
      if (out != null) {
         fw = true;
      } else {
         fw = false;
      }
      return fw;
   }

   public boolean actorupdate(ActorVO vo) {

	      boolean fw = false;
	      SimpleJdbcCall call = createSimpleJdbcCall();
	      call.withProcedureName("ACTOR_UPDATE");
	      SqlParameterSource in = new MapSqlParameterSource().addValue("VACTOR_NAME", vo.getName())
	    		  	.addValue("VACTOR_THUMBNAIL",vo.getActor_thumbnail());

	      Map out = call.execute(in);
	      if (out != null) {
	         fw = true;
	      } else {
	         fw = false;
	      }
	      return fw;
	   }

   public boolean dirinsert(DirectorVO vo) {

      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("DIR_INSERT");
      SqlParameterSource in = new MapSqlParameterSource()
    		.addValue("VDIR_CODE", vo.getDir_code())
            .addValue("VDIR_NAME", vo.getName())
      		.addValue("VDIR_THUMBNAIL",vo.getDir_thumbnail());
      Map out = call.execute(in);

      if (out != null) {
         fw = true;
      } else {
         fw = false;
      }
      return fw;
   }

   public boolean dirdelete(DirectorVO vo) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("DIR_DELETE");
      SqlParameterSource in = new MapSqlParameterSource().addValue("VDIR_CODE", vo.getDir_code());
      Map out = call.execute(in);
      if (out != null) {
         fw = true;
      } else {
         fw = false;
      }
      return fw;
   }

   public boolean dirupdate(DirectorVO vo) {

	      boolean fw = false;
	      SimpleJdbcCall call = createSimpleJdbcCall();
	      call.withProcedureName("DIR_UPDATE");
	      SqlParameterSource in = new MapSqlParameterSource().addValue("VDIR_NAME", vo.getName())
	    		  	.addValue("VDIR_THUMBNAIL", vo.getDir_thumbnail());

	      Map out = call.execute(in);
	      if (out != null) {
	         fw = true;
	      } else {
	         fw = false;
	      }
	      return fw;
	   }

   public boolean movieinsert(MovieVO2 vo) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("MOVIE_INSERT");
      SqlParameterSource in = new MapSqlParameterSource()
    		.addValue("VTITLE", vo.getName())
            .addValue("VOPEN_DATE", vo.getOpen_date())
            .addValue("VGROSS", vo.getGross())
            .addValue("VVIEWER", vo.getViewer())
            .addValue("VCOUNTRY", vo.getCountry())
            .addValue("VDISTRIBUTION", vo.getDistribution())
            .addValue("VLINK", vo.getLink())
            .addValue("VMOVIE_CODE", vo.getMoviecode())
            .addValue("VTHUMBNAIL", vo.getImage())
            .addValue("VPY", vo.getPy())
            .addValue("VDIRECTOR", vo.getDirector())
            .addValue("VGENRES", vo.getGenres())
            .addValue("VEXPERT_SCORE", vo.getExpert_score())
            .addValue("VNETIZEN_SCORE", vo.getNetizen_score())
            .addValue("VSTORY", vo.getStory());

      Map out = call.execute(in);

      if (out != null) {
         fw = true;
      } else {
         fw = false;
      }
      return fw;
   }

   public boolean movieupdate(MovieVO2 vo) {
	   System.out.println(vo.getName());
	   System.out.println(vo.getMoviecode() + "moviecode");

      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("MOVIE_UPDATE");
      SqlParameterSource in = new MapSqlParameterSource().addValue("VTITLE", vo.getName())
            .addValue("VOPEN_DATE", vo.getOpen_date())
            .addValue("VGROSS", vo.getGross())
            .addValue("VVIEWER", vo.getViewer())
            .addValue("VCOUNTRY",vo.getCountry())
            .addValue("VDISTRIBUTION", vo.getDistribution())           
            .addValue("VLINK", vo.getLink())
            .addValue("VMOVIE_CODE", vo.getMoviecode())
            .addValue("VTHUMBNAIL", vo.getImage())
            .addValue("VPY", vo.getPy())
            .addValue("VDIRECTOR", vo.getDirector())
            .addValue("VGENRES", vo.getGenres())
            .addValue("VEXPERT_SCORE", vo.getExpert_score())
            .addValue("VNETIZEN_SCORE", vo.getNetizen_score())
            .addValue("VSTORY", vo.getStory());
      Map out = call.execute(in);
      
      if (out != null) {
         fw = true;
      	} else {
         fw = false;
      	}
      return fw;
   }


   public boolean moviedelete(MovieVO2 vo) {
      boolean fw = false;
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("MOVIE_DELETE");
      SqlParameterSource in = new MapSqlParameterSource().addValue("VMOVIE_CODE", vo.getMoviecode());
      Map out = call.execute(in);
      if (out != null) {
         fw = true;
      } else {
         fw = false;
      }
      return fw;
   }
   
   public List<WishtopVO> RealtimeWishlist(){
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("REALTIME_WISHLIST");
      
      SqlParameterSource in = new MapSqlParameterSource();
      call.returningResultSet("myres", new RowMapper<WishtopVO>() {
         public WishtopVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            WishtopVO vo = new WishtopVO();
            vo.setMovie_code(rs.getInt("MOVIE_CODE"));
            vo.setNum(rs.getInt("COUNT"));
            vo.setThumbnail(rs.getString("THUMBNAIL"));
            return vo;      
      }
      });
      Map<String, Object> out = call.execute(in);
      System.out.println(out);
      List<WishtopVO> all = (List<WishtopVO>) out.get("myres");
      System.out.println(call.getProcedureName());
      
      return all;
   }
   
   public List<LiketopActVO> RealtimeActlike(){
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("REALTIME_ACTLIKE");
      
      SqlParameterSource in = new MapSqlParameterSource();
      call.returningResultSet("myres", new RowMapper<LiketopActVO>() {
         public LiketopActVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            LiketopActVO vo = new LiketopActVO();
            vo.setActor_code(rs.getInt("ACTOR_CODE"));
            vo.setNum(rs.getInt("COUNT"));
            vo.setActor_thumbnail(rs.getString("ACTOR_THUMBNAIL"));
            return vo;      
      }
      });
      Map<String, Object> out = call.execute(in);
      System.out.println(out);
      List<LiketopActVO> all = (List<LiketopActVO>) out.get("myres");
      System.out.println(call.getProcedureName());
      
      return all;
   }
   
   public List<LiketopDirVO> Realtimedirlike(){
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("REALTIME_DIRLIKE");
      
      SqlParameterSource in = new MapSqlParameterSource();
      call.returningResultSet("myres", new RowMapper<LiketopDirVO>() {
         public LiketopDirVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            LiketopDirVO vo = new LiketopDirVO();
            vo.setDir_code(rs.getInt("DIR_CODE"));
            vo.setNum(rs.getInt("COUNT"));
            vo.setDir_thumbnail(rs.getString("DIR_THUMBNAIL"));
            return vo;      
      }
      });
      Map<String, Object> out = call.execute(in);
      System.out.println(out);
      List<LiketopDirVO> all = (List<LiketopDirVO>) out.get("myres");
      System.out.println(call.getProcedureName());
      
      return all;
   }
   
   public List<LiketopMVO> RealtimeMlike(){
      SimpleJdbcCall call = createSimpleJdbcCall();
      call.withProcedureName("REALTIME_MLIKE");
      
      SqlParameterSource in = new MapSqlParameterSource();
      call.returningResultSet("myres", new RowMapper<LiketopMVO>() {
         public LiketopMVO mapRow(ResultSet rs, int rowNum) throws SQLException{
            LiketopMVO vo = new LiketopMVO();
            vo.setMovie_code(rs.getInt("MOVIE_CODE"));
            vo.setNum(rs.getInt("COUNT"));
            vo.setThumbnail(rs.getString("THUMBNAIL"));
            return vo;      
      }
      });
      Map<String, Object> out = call.execute(in);
      System.out.println(out);
      List<LiketopMVO> all = (List<LiketopMVO>) out.get("myres");
      System.out.println(call.getProcedureName());
      
      return all;
   }
   

}