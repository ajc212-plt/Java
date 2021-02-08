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
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import fom.vo.MemberVO;

@Repository
public class MemberDaoJDBC {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;

	public SimpleJdbcCall createSimpleJdbcCall() {
		return new SimpleJdbcCall(this.jdbctemplate);
	}

	public MemberVO privatemembersearch(int member_code) {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MEMBER_SELECT");

		SqlParameterSource in = new MapSqlParameterSource().addValue("V_MCODE", member_code);
		Map out = call.execute(in);
		MemberVO vo = new MemberVO();
		vo.setMember_code(Integer.parseInt(String.valueOf(out.get("MEMBER_CODE"))));
		vo.setMember_id(((String) out.get("MEMBER_ID")));
		vo.setAge(Integer.parseInt(String.valueOf(out.get("AGE"))));
		vo.setGender((String) out.get("GENDER"));
		call.compile();
		return vo;
	}

	public boolean memberinsert(MemberVO vo) {

		boolean fw = false;
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MEMBER_INSERT");
		SqlParameterSource in = new MapSqlParameterSource().addValue("V_ID", vo.getMember_id())
				.addValue("V_PW", vo.getPassword()).addValue("V_AGE", vo.getAge()).addValue("V_GENDER", vo.getGender());
		Map out = call.execute(in);

		if (out != null) {
			fw = true;
		} else {
			fw = false;
		}
		return fw;
	}

	public boolean memberdelete(MemberVO vo) {
		boolean fw = false;
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MEMBER_DELETE");
		SqlParameterSource in = new MapSqlParameterSource().addValue("VMEMBER_ID", vo.getMember_id());
		Map out = call.execute(in);
		if (out != null) {
			fw = true;
		} else {
			fw = false;
		}
		return fw;
	}

	public boolean memberupdate(MemberVO vo) {

		boolean fw = false;
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MEMBER_UPDATE");
		SqlParameterSource in = new MapSqlParameterSource().addValue("VMEMBER_ID", vo.getMember_id()).addValue("V_PW",
				vo.getPassword());
		Map out = call.execute(in);
		if (out != null) {
			fw = true;
		} else {
			fw = false;
		}
		return fw;
	}

	public boolean memberLogin(MemberVO vo) {
		boolean fw = false;
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withFunctionName("MEMBER_LOGIN");
		SqlParameterSource in = new MapSqlParameterSource().addValue("VID", vo.getMember_id()).addValue("VPW",
				vo.getPassword());
		Map out = call.execute(in);
		if (out != null) {
			fw = true;
		} else {
			fw = false;
		}
		return fw;
	}

	public List<MemberVO> MemberAll() {
		SimpleJdbcCall call = createSimpleJdbcCall();
		call.withProcedureName("MEMBER_ALL");

		SqlParameterSource in = new MapSqlParameterSource();
		call.returningResultSet("myres", new RowMapper<MemberVO>() {
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO vo = new MemberVO();
				vo.setMember_code(rs.getInt("MEMBER_CODE"));
				vo.setMember_id(rs.getString("MEMBER_ID"));
				vo.setGender(rs.getString("GENDER"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setAge(rs.getInt("AGE"));
				return vo;
			}
		});
		Map<String, Object> out = call.execute(in);
		System.out.println(out);
		List<MemberVO> all = (List<MemberVO>) out.get("myres");
		System.out.println(call.getProcedureName());

		return all;
	}

}
