package fom.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fom.biz.ActorBIZ;
import fom.biz.DirectorBIZ;
import fom.biz.LikeBIZ;
import fom.biz.ManagerBIZ;
import fom.biz.MemberBIZ;
import fom.biz.MovieBIZ;
import fom.biz.NetworkBIZ;
import fom.biz.WishlistBIZ;
import fom.vo.ActorVO;
import fom.vo.Actor_MovieVO;
import fom.vo.DirectorVO;
import fom.vo.LiketopActVO;
import fom.vo.LiketopDirVO;
import fom.vo.LiketopMVO;
import fom.vo.MemberVO;
import fom.vo.MovieVO2;
import fom.vo.NetworkVO;
import fom.vo.Network_DIRVO;
import fom.vo.WishtopVO;

@Controller
//@SessionAttributes("user")
public class PagemoveController {

	@Autowired
	MovieBIZ movieBIZ;

	@Autowired
	MemberBIZ memberBIZ;

	@Autowired
	ActorBIZ actorBIZ;

	@Autowired
	DirectorBIZ directorBIZ;

	@Autowired
	NetworkBIZ networkBIZ;

	@Autowired
	LikeBIZ likeBIZ;

	@Autowired
	WishlistBIZ wishlistBIZ;

	@Autowired
	ManagerBIZ managerBIZ;

	// 회원가입 페이지 이동
	@RequestMapping("/membersign.do")
	public String signpage() {
		return "fom/member/sign";

	}

	// 마이페이지 이동
	@RequestMapping("/mypage.do")
	public String mypage() {
		return "fom/member/mypage";

	}

	@RequestMapping("/movielist.do")
	public String movielistpage() {
		return "fom/board/allmovie";

	}

	@RequestMapping("/actorlist.do")
	public String actorlistpage() {
		return "fom/board/allactor";

	}

	@RequestMapping("/directorlist.do")
	public String movepage() {
		return "fom/board/alldirector";

	}

	@RequestMapping("/manager.do")
	public String movemanager() {
		return "fom/management/management";
	}

	@RequestMapping("/management_member.do")
	public String movemanagement_member() {
		return "fom/management/management_member";
	}

	@RequestMapping("/management_actor.do")
	public String movemanagement_actor() {
		return "fom/management/management_actor";
	}

	@RequestMapping("/management_director.do")
	public String movemanagement_director() {
		return "fom/management/management_director";
	}

	@RequestMapping("/actorInsertmove.do")
	public String actorinsertmove() {
		return "fom/management/actor_insert";

	}

	@RequestMapping("/dirInsertmove.do")
	public String dirinsertmove() {
		return "fom/management/dir_insert";

	}

	@RequestMapping("/mInsertmove.do")
	public String minsertmove() {
		return "fom/management/m_insert";

	}

	@RequestMapping("/mdeletemove.do")
	public String mdeletemove() {
		return "fom/management/m_delete";

	}

	@RequestMapping("/actordeletemove.do")
	public String actordeletemove() {
		return "fom/management/actor_delete";

	}

	@RequestMapping("/dirdeletemove.do")
	public String dirdeletemove() {
		return "fom/management/dir_delete";

	}

	@RequestMapping("/memberdeletemove.do")
	public String memberdeletemove() {
		return "fom/management/member_delete";

	}
	
	@RequestMapping("/mupdatemove.do")
	public String mupdatemove() {
		return "fom/management/management_movieupdate";

	}
	
	@RequestMapping("/aupdatemove.do")
	public String aupdatemove() {
		return "fom/management/management_actupdate";

	}
	
	@RequestMapping("/dupdatemove.do")
	public String dupdatemove() {
		return "fom/management/management_dirupdate";

	}
	
	@RequestMapping("/dmainsearch.do")
	public String dmainsearch() {
		return "fom/search/mainsearch";

	}

}