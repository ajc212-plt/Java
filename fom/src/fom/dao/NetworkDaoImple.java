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
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import fom.vo.ActorVO;
import fom.vo.NetworkVO;
import fom.vo.Network_DIRVO;

@Repository
public class NetworkDaoImple implements NetworkjdbcDao
{
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private SimpleJdbcCall simpleJdbcCall;
	
	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbctemplate);
	}

	@Override
	public List<NetworkVO> networkGraph(int actor_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("NETWORK_ACTOR");
		
		System.out.println(actor_code);
		
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("VACTOR_CODE", actor_code);
		
		
		System.out.println("networkgraph???");
		
		call.returningResultSet("myres", new RowMapper<NetworkVO>() {
			//networkVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public NetworkVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				NetworkVO vo = new NetworkVO();
				vo.setSearch_name(rs.getString("source_NAME"));
				vo.setActor_code(rs.getInt("source_CODE"));
				vo.setName(rs.getString("NAME"));
				vo.setCode(rs.getInt("CODE"));
				vo.setCount(rs.getInt("COUNT"));
				vo.setJob(rs.getInt("JOB"));
				return vo;
			}
		});
		
		Map<String, Object> out = call.execute(in);
		
		System.out.println(out);
		List<NetworkVO> all = (List<NetworkVO>) out.get("myres");
		System.out.println(all);
		return all;
	}
	
	
	
	public Object dirnetworkGraph(int dir_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("NETWORK_DIR");
		
		System.out.println(dir_code);
		
		SqlParameterSource in = new MapSqlParameterSource()
                .addValue("VDIR_CODE", dir_code);
		
		
		System.out.println("dir_networkgraph???");
		
		call.returningResultSet("myres", new RowMapper<Network_DIRVO>() {
			//networkVO는 시스템내에서 자동으로 생성되는 객체 이름이다.
			public Network_DIRVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				Network_DIRVO vo = new Network_DIRVO();
				vo.setSearch_name(rs.getString("source_NAME"));
				vo.setDir_code(rs.getInt("source_CODE"));
				vo.setName(rs.getString("NAME"));
				vo.setCode(rs.getInt("CODE"));
				vo.setCount(rs.getInt("COUNT"));
				vo.setJob(rs.getInt("JOB"));
				return vo;
			}
		});
		
		Map<String, Object> out = call.execute(in);
		
		System.out.println(out);
		List<Network_DIRVO> all = (List<Network_DIRVO>) out.get("myres");
		System.out.println(all);
		return all;
	}
	
	
}
