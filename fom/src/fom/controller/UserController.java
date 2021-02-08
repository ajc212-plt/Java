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

@Controller //(value="/user")
@SessionAttributes("user")
public class UserController {

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
	
	/*
	 * @RequestMapping("/login.do") public void dologin(@ModelAttribute MemberVO
	 * avo) { System.out.println(avo.toString());
	 * 
	 * }
	 */

	@RequestMapping("/movielistsearch.do")
	public String movielistsearch(@ModelAttribute("mvo") MovieVO2 mvo, Model model) {
		List<MovieVO2> res = movieBIZ.Movielistsearch(mvo.getName());
		model.addAttribute("movlist", res);
		return "/fom/movview";
	}

	@RequestMapping("/actorlistsearch.do")
	public String Actorlistsearch(@ModelAttribute("vo") ActorVO vo, 
									@ModelAttribute("dvo") DirectorVO dvo,
									@ModelAttribute("mvo") MovieVO2 mvo, 
									Model model) {
		// System.out.println(actorBIZ.Actorlistsearch(vo.getActor_name()).get(0));
		List<ActorVO> res = actorBIZ.Actorlistsearch(vo.getName());
		model.addAttribute("actlist", res);
		model.addAttribute("dirlist", directorBIZ.Directorlistsearch(dvo.getName()));
		model.addAttribute("movielist", movieBIZ.Movielistsearch(mvo.getName()));
		System.out.println(res);
		return "/fom/search/multiname";
	}

	@RequestMapping("/directorlistsearch.do")
	public String Directorlistsearch(@ModelAttribute("dvo") DirectorVO dvo, Model model) {
		List<DirectorVO> res = directorBIZ.Directorlistsearch(dvo.getName());
		model.addAttribute("dirlist", res);
		// System.out.println(actorvo.getActor_name());
		// System.out.println(actorvo.getActor_code());
		return "/fom/search/multiname";
	}

	@RequestMapping("/actorSpecificsearch.do")
	public String ActorSpecificsearch(@ModelAttribute("avo") ActorVO avo, @ModelAttribute("afvo") MovieVO2 afvo,
			@ModelAttribute("nvo") NetworkVO nvo, Model model) {
		model.addAttribute("actresearch", actorBIZ.ActorSpecificsearch(avo.getActor_code()));
		List<MovieVO2> res = actorBIZ.Actorfilmography(afvo.getActor_code());
		model.addAttribute("actfilmo", res);
		model.addAttribute("networkgraph", networkBIZ.networkGraph(nvo.getActor_code()));
		List<HashMap<String, Integer>> gender_map = actorBIZ.actor_like_gender(nvo.getActor_code());
		model.addAttribute("gender_map", gender_map);
		return "/fom/search/resultactor";
	}

	@RequestMapping("/directorSpecificsearch.do")
	public String DirectorSpecificsearch(@ModelAttribute("dsvo") DirectorVO dsvo, @ModelAttribute("dfvo") MovieVO2 dfvo,
			@ModelAttribute("dnvo") Network_DIRVO dnvo, Model model) {
		DirectorVO res = directorBIZ.DirectorSpecificsearch(dsvo.getDir_code());
		model.addAttribute("dirsearch", res);
		List<MovieVO2> res2 = directorBIZ.DirectorFilmography(dfvo.getDir_code());
		model.addAttribute("dirfilmo", res2);
		model.addAttribute("dir_networkgraph", networkBIZ.dirNetworkGraph(dnvo.getDir_code()));
		List<HashMap<String, Integer>> gender_map = directorBIZ.dir_like_gender(dnvo.getDir_code());
		model.addAttribute("gender_map", gender_map);
		return "/fom/search/resultdirector";
	}

	@RequestMapping("/movieSpecificsearch.do")
	public String MovieSpecificsearch(@ModelAttribute("dfvo") MovieVO2 dfvo, Model model) {
		MovieVO2 res = movieBIZ.MovieSpecificsearch(dfvo.getMoviecode());
		model.addAttribute("moviesearch", res);	
		List<HashMap<String, Integer>> gender_map = movieBIZ.Wishmem_Gender(dfvo.getMoviecode());
		model.addAttribute("gender_map", gender_map);	
		List<HashMap<String, Integer>> likes_gender_map = movieBIZ.movie_like_gender(dfvo.getMoviecode());
		model.addAttribute("likes_gender_map", likes_gender_map);	
		return "/fom/search/resultmovie";
	}

	@RequestMapping("/actorfilmography.do")
	public String ActorFilmography(@ModelAttribute("afvo") MovieVO2 afvo, Model model) {
		// DirectorVO res = directorBIZ.DirectorSpecificsearch(dsvo.getDir_code());
		List<MovieVO2> res = actorBIZ.Actorfilmography(afvo.getActor_code());
		System.out.println(res);
		model.addAttribute("actfilmo", res);
		return "/fom/actorfilmography";
	}

	@RequestMapping("/directorfilmography.do")
	public String DirectorFilmography(@ModelAttribute("dfvo") MovieVO2 dfvo, Model model) {
		// DirectorVO res = directorBIZ.DirectorSpecificsearch(dsvo.getDir_code());
		List<MovieVO2> res = directorBIZ.DirectorFilmography(dfvo.getDir_code());
		System.out.println(res);
		model.addAttribute("dirfilmo", res);
		return "/fom/dirfilmography";
	}

	@RequestMapping("/privatemembersearch.do")
	public ModelAndView privatemembersearch(@RequestParam("member_code") int member_code) {
		MemberVO vo = memberBIZ.privatemembersearch(member_code);
		ModelAndView mav = new ModelAndView("fom/memberview", "vo", vo);
		return mav;
	}

	@RequestMapping("/memberInsert.do")
	public ModelAndView memberinsert(MemberVO vo) {
		boolean result = memberBIZ.memberinsert(vo);
		ModelAndView mav = new ModelAndView("fom/memberinsertresult", "memberinsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/memberDelete.do")
	public ModelAndView memberdelete(String member_id) {
		MemberVO mymember = new MemberVO();
		mymember.setMember_id(member_id);
		boolean result = memberBIZ.memberdelete(mymember);
		ModelAndView mav = new ModelAndView("fom/memberdeleteresult", "memberdelete", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/memberUpdate.do")
	public ModelAndView memberupdate(String member_id, String password) {
		MemberVO mymember = new MemberVO();
		mymember.setMember_id(member_id);
		mymember.setPassword(password);
		boolean result = memberBIZ.memberupdate(mymember);
		ModelAndView mav = new ModelAndView("fom/memberupdateresult", "memberupdate", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}
	
	@RequestMapping("/wishlistInsert.do")
	public ModelAndView wishlistinsert(String member_id, int movie_code) {
		boolean result = wishlistBIZ.wishlist(member_id, movie_code);
		ModelAndView mav = new ModelAndView("fom/wishlistinsertresult", "wishlistinsert", result);
		mav.addObject("message", "위시리스트 추가되었습니다");
	    return mav;

		/*
		 * ModelAndView mav = new ModelAndView("fom/wishlistinsertresult",
		 * "wishlistinsert", result); // 출력파일 : result.jsp // 리턴할
		 * 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result] return mav;
		 */
	}
	
	@RequestMapping("/wishlistSearch.do")
	public String wishlistsearch(@ModelAttribute("wivo") MovieVO2 wivo, 
			@ModelAttribute("mal") ActorVO avo,
			@ModelAttribute("mml") MovieVO2 mvo,
			@ModelAttribute("mdls") DirectorVO dvo,
			Model model) {
		// DirectorVO res = directorBIZ.DirectorSpecificsearch(dsvo.getDir_code());
		List<MovieVO2> res = wishlistBIZ.Wishlistsearch(wivo.getMember_id());
		System.out.println("res :" + res);
		model.addAttribute("wlistsearch", res);
		List<ActorVO> res1 = likeBIZ.member_actor_like(avo.getMember_id());
		model.addAttribute("memberlikeact", res1);
		List<DirectorVO> res2 = likeBIZ.member_dir_like(dvo.getMember_id());
	    model.addAttribute("memberlikedir", res2);
		List<MovieVO2> res3 = likeBIZ.member_movie_like(mvo.getMember_id());
		model.addAttribute("memberlikemovie", res3);
		return "/fom/member/mypage";
	}

	

	@RequestMapping("/m_movieInsert.do")
	public ModelAndView member_movieinsert(String member_id, int movie_code) {
		boolean result = likeBIZ.member_movieinsert(member_id, movie_code);
		ModelAndView mav = new ModelAndView("fom/wishlistinsertresult", "m_movieinsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/m_actorInsert.do")
	public ModelAndView member_actorinsert(String member_id, int actor_code) {
		boolean result = likeBIZ.member_actorinsert(member_id, actor_code);
		ModelAndView mav = new ModelAndView("fom/wishlistinsertresult", "m_actorinsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}

	@RequestMapping("/m_dirInsert.do")
	public ModelAndView member_dirinsert(String member_id, int dir_code) {
		boolean result = likeBIZ.member_dirinsert(member_id, dir_code);
		ModelAndView mav = new ModelAndView("fom/wishlistinsertresult", "m_dirinsert", result);
		// 출력파일 : result.jsp
		// 리턴할 객체명(request객체):myresult, 전송할 객체명 : result [ myresult = result]
		return mav;
	}
	
	@RequestMapping("/memberlogin.do")
	   public ModelAndView memberlogin(@ModelAttribute MemberVO vo) {
	      boolean result = memberBIZ.memberlogin(vo);
	      ModelAndView mav = new ModelAndView();
	       if (result) {
	         System.out.println(vo.getMember_id() + "님이 로그인했습니다.");
	         mav.addObject("user", vo);
	         mav.setViewName("fom/search/mainsearch");
	         if (vo.getMember_id().equals("big5")) {
	            mav.setViewName("fom/management/management");
	         }
	      }
	      return mav;
	   }

	
	
	@RequestMapping("/memberlikeact.do")
	public String member_actor_like(@ModelAttribute("mal") ActorVO vo, Model model) {
		List<ActorVO> res = likeBIZ.member_actor_like(vo.getMember_id());
		model.addAttribute("memberlikeact", res);
		return "/fom/movview";
	}
	
	@RequestMapping("/memberlikemovie.do")
	public String member_movie_like(@ModelAttribute("mml") MovieVO2 vo, Model model) {
		List<MovieVO2> res = likeBIZ.member_movie_like(vo.getMember_id());
		model.addAttribute("memberlikemovie", res);
		return "/fom/movview";
	}
	
	@RequestMapping("/memberdirlikeSearch.do")
    public String member_dir_like(@ModelAttribute("mdls") DirectorVO mdls, Model model) {
       // DirectorVO res = directorBIZ.DirectorSpecificsearch(dsvo.getDir_code());
       List<DirectorVO> res = likeBIZ.member_dir_like(mdls.getMember_id());
       System.out.println("res :" + res);
       model.addAttribute("mdls", res);
       return "/fom/member/mypage";
    }

}