package fom.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fom.vo.ActorVO;
import fom.vo.NetworkVO;

@Repository
public interface NetworkjdbcDao {
	public List<NetworkVO> networkGraph(int actor_code);

}
