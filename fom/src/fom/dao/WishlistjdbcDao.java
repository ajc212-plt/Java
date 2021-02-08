package fom.dao;

import java.util.List;

import fom.vo.MemberVO;
import fom.vo.MovieVO2;

public interface WishlistjdbcDao {
	public boolean wishlist(String member_id, int movie_code);
	public List<MovieVO2> Wishlistsearch(String member_id);
}
