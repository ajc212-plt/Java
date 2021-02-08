package fom.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fom.dao.ActorDaoImple;
import fom.dao.ActorjdbcDao;
import fom.dao.NetworkDaoImple;
import fom.vo.ActorVO;
import fom.vo.NetworkVO;



@Service //명시를 반드시 해야 시스템이 인식한다.
public class NetworkBIZ {

	@Autowired
	private NetworkDaoImple networkDaoImple;
	
	public List<NetworkVO> networkGraph(int actor_code) {
		return networkDaoImple.networkGraph(actor_code);
	}
	

	public Object dirNetworkGraph(int dir_code) {
		return networkDaoImple.dirnetworkGraph(dir_code);
	}
	
}
