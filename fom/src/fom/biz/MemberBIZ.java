package fom.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fom.dao.MemberDaoJDBC;
import fom.vo.MemberVO;

@Service
public class MemberBIZ {
	
	@Autowired
	private MemberDaoJDBC memberdaojdbc;
	
	public MemberVO privatemembersearch(int member_code) {
		return memberdaojdbc.privatemembersearch(member_code);
	}
	
	public boolean memberinsert(MemberVO vo) {
	      return memberdaojdbc.memberinsert(vo);
	   }
	
	public boolean memberdelete(MemberVO vo) {
	      return memberdaojdbc.memberdelete(vo);
	   }
	
	public boolean memberupdate(MemberVO vo) {
		return memberdaojdbc.memberupdate(vo);
		
	}
	
	public boolean memberlogin(MemberVO vo) {
	      return memberdaojdbc.memberLogin(vo);
	   }
	public List<MemberVO> MemberAll() {
		return memberdaojdbc.MemberAll();
	}
}
