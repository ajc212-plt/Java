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

@Controller //("admin")
//@SessionAttributes("admin")
public class AdminController {

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
	
	@RequestMapping("/movlistall.do")
	public String MovieAll(@ModelAttribute("movall") MovieVO2 movall, Model model) {
		List<MovieVO2> res = movieBIZ.MovieAll();
		model.addAttribute("movlistall", res);

		return "/fom/management/management_movie";
	}

	@RequestMapping("/actorInsert.do")
	public ModelAndView actorinsert(ActorVO vo) {
		boolean result = managerBIZ.actorinsert(vo);
		ModelAndView mav = new ModelAndView("/fom/management/insert_finish","actorinsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/actorDelete.do")
	public ModelAndView actordelete(@RequestParam("actor_code") int actor_code) {
		ActorVO actorvo = new ActorVO();
		actorvo.setActor_code(actor_code);
		boolean result = managerBIZ.actordelete(actorvo);
		ModelAndView mav = new ModelAndView("/fom/management/delete_finish", "actordelete", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/actorUpdate.do")
	public ModelAndView actorupdate(@ModelAttribute("actupdate") ActorVO actupdate) {	
		boolean result = managerBIZ.actorupdate(actupdate);
		ModelAndView mav = new ModelAndView("fom/management/actupdatefinish", "actupdatefinish", result);
		
		return mav;
	}

	@RequestMapping("/dirInsert.do")
	public ModelAndView dirinsert(DirectorVO vo) {
		boolean result = managerBIZ.dirinsert(vo);
		ModelAndView mav = new ModelAndView("/fom/management/insert_finish", "dirinsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/dirDelete.do")
	public ModelAndView dirdelete(@RequestParam("dir_code")int dir_code) {
		DirectorVO directorvo = new DirectorVO();
		directorvo.setDir_code(dir_code);
		boolean result = managerBIZ.dirdelete(directorvo);
		ModelAndView mav = new ModelAndView("/fom/management/delete_finish", "dirdelete", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/dirUpdate.do")
	public ModelAndView dirupdate(@ModelAttribute("dirupdate") DirectorVO dirupdate) {
		boolean result = managerBIZ.dirupdate(dirupdate);
		ModelAndView mav = new ModelAndView("fom/management/dirupdatefinish", "dirupdatefinish", result);
		
		return mav;
	}

	@RequestMapping("/movieInsert.do")
	public ModelAndView movieinsert(MovieVO2 vo) {
		boolean result = managerBIZ.movieinsert(vo);
		ModelAndView mav = new ModelAndView("/fom/management/insert_finish", "minsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/movieDelete.do")
	public ModelAndView moviedelete(@RequestParam("moviecode") int moviecode) {
		System.out.println("moviecode" + moviecode);
		MovieVO2 movievo2 = new MovieVO2();
		movievo2.setMoviecode(moviecode);
		boolean result = managerBIZ.moviedelete(movievo2);
		ModelAndView mav = new ModelAndView("/fom/management/delete_finish", "mdelete", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/movieUpdate.do")
	public ModelAndView movieupdate(@ModelAttribute("movievo02") MovieVO2 movievo02) {
		System.out.println(movievo02);
		boolean result = managerBIZ.movieupdate(movievo02);
		ModelAndView mav = new ModelAndView("fom/management/movieupdatefinish", "movieupdatefinish", result);
		
		return mav;
	}

	@RequestMapping("/realtimelist.do")
	public String realtimewishlist(@ModelAttribute("rtwl") WishtopVO wtvo, @ModelAttribute("rtall") LiketopActVO ltavo,
			@ModelAttribute("rtdll") LiketopDirVO ltdvo, @ModelAttribute("rtmll") LiketopMVO ltmvo, Model model) {
		List<WishtopVO> res01 = managerBIZ.RealtimeWishlist();
		model.addAttribute("realtimewishlist", res01);
		List<LiketopActVO> res02 = managerBIZ.RealtimeActlike();
		model.addAttribute("realtimeactlikelist", res02);
		List<LiketopDirVO> res03 = managerBIZ.Realtimedirlike();
		model.addAttribute("realtimedirlikelist", res03);
		List<LiketopMVO> res04 = managerBIZ.RealtimeMlike();
		model.addAttribute("realtimemlikelist", res04);

		return "/fom/test";
	}
	
	
	
	@RequestMapping("/dirlistall.do")
	public String DirectorAll(@ModelAttribute("dirall") DirectorVO dirall, Model model) {
		List<DirectorVO> res = directorBIZ.DirectorAll();
		model.addAttribute("dirlistall", res);

		return "/fom/management/management_director";
	}

	@RequestMapping("/actall.do")
	public String actall(@ModelAttribute("aa") ActorVO vo, Model model) {
		List<ActorVO> res = actorBIZ.ActorAll();
		model.addAttribute("actall", res);

		return "/fom/management/management_actor";
	}
	
	@RequestMapping("/memberall.do")
	public String memberall(@ModelAttribute("ma") MemberVO vo, Model model) {
		List<MemberVO> res = memberBIZ.MemberAll();
		model.addAttribute("memberall", res);

		return "/fom/management/management_member";
	}
	
	@RequestMapping("/adminmemberDelete.do")
	public ModelAndView adminmemberdelete(String member_id) {
		MemberVO mymember = new MemberVO();
		mymember.setMember_id(member_id);
		boolean result = memberBIZ.memberdelete(mymember);
		ModelAndView mav = new ModelAndView("/fom/management/delete_finish", "memberdelete", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}
	
	@RequestMapping("/movieUpdateSearch.do")
	public String MovieUpdateSearch(@RequestParam("moviecode") String moviecode, Model model) {
		
		MovieVO2 res = movieBIZ.MovieUpdateSearch(moviecode);
		System.out.println("search:" + res.getMoviecode());
		model.addAttribute("movieupdatesearch", res);
		return "/fom/management/movieupdate"; 
	}
	
	@RequestMapping("/actorUpdateSearch.do")
	public String ActorUpdateSearch(@RequestParam("actor_code") String actor_code, Model model) {
		
		ActorVO res = actorBIZ.ActorUpdateSearch(actor_code);
		model.addAttribute("actorupdatesearch", res);
		return "/fom/management/actorupdate"; 
	}
	
	@RequestMapping("/directorUpdateSearch.do")
	public String DirectorUpdateSearch(@RequestParam("dir_code") String dir_code, Model model) {
		
		DirectorVO res = directorBIZ.DirectorUpdateSearch(dir_code);
		model.addAttribute("directorupdatesearch", res);
		return "/fom/management/directorupdate"; 
	}

}