package fom.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fom.dao.WishlistDaoImple;
import fom.vo.MemberVO;
import fom.vo.MovieVO2;

@Service
public class WishlistBIZ {

	@Autowired
	private WishlistDaoImple wishlistDaoImple;
	
	public boolean wishlist(String member_id, int movie_code) {
		return wishlistDaoImple.wishlist(member_id, movie_code);
	}
	
	public List<MovieVO2> Wishlistsearch(String member_id){
		return wishlistDaoImple.Wishlistsearch(member_id);
	}
}
