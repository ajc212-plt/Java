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

import fom.vo.MemberVO;
import fom.vo.MovieVO2;

@Repository
public class WishlistDaoImple implements WishlistjdbcDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbctemplate);
	}
	
	@Override
	public boolean wishlist(String member_id, int movie_code) {
		boolean fw = false;
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("WISHLIST_RG");
		SqlParameterSource in = new MapSqlParameterSource().addValue("V_MEMBERID",member_id)
					.addValue("V_MOVIECODE",movie_code);
		Map out = call.execute(in);
		
		if(out!= null) {
			fw=true;
		}else {
			fw=false;
		}
		return fw;
	}
	
	@Override
	public List<MovieVO2> Wishlistsearch(String member_id){
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("WISHLIST_MEMBER");
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("VMEMBER_ID", member_id);
		call.returningResultSet("myres", new RowMapper<MovieVO2>() {
			public MovieVO2 mapRow(ResultSet rs, int rowNum) throws SQLException{
				MovieVO2 vo = new MovieVO2();
				vo.setName(rs.getString("TITLE"));
				vo.setOpen_date(rs.getString("OPEN_DATE"));
				vo.setImage(rs.getString("thumbnail"));
				vo.setNetizen_score(rs.getString("NETIZEN_SCORE"));
				return vo;
				
		}
		});
		Map<String, Object> out = call.execute(in);
		System.out.println(out);
		List<MovieVO2> all = (List<MovieVO2>) out.get("myres");
		System.out.println(call.getProcedureName());
		
		return all;
	}
}
