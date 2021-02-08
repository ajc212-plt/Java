package fom.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fom.dao.ManagerDaoJDBC;
import fom.vo.ActorVO;
import fom.vo.DirectorVO;
import fom.vo.LiketopActVO;
import fom.vo.LiketopDirVO;
import fom.vo.LiketopMVO;
import fom.vo.MovieVO2;
import fom.vo.WishtopVO;

@Service
public class ManagerBIZ {

   @Autowired
   private ManagerDaoJDBC managerDaoJDBC;

   public boolean actorinsert(ActorVO vo) {
      return managerDaoJDBC.actorinsert(vo);
   }

   public boolean actordelete(ActorVO vo) {
      return managerDaoJDBC.actordelete(vo);
   }

   public boolean actorupdate(ActorVO vo) {
      return managerDaoJDBC.actorupdate(vo);
   }

   public boolean dirinsert(DirectorVO vo) {
      return managerDaoJDBC.dirinsert(vo);
   }

   public boolean dirdelete(DirectorVO vo) {
      return managerDaoJDBC.dirdelete(vo);
   }

   public boolean dirupdate(DirectorVO vo) {
      return managerDaoJDBC.dirupdate(vo);
   }

   public boolean movieinsert(MovieVO2 vo) {
      return managerDaoJDBC.movieinsert(vo);
   }

   public boolean movieupdate(MovieVO2 vo) {
      return managerDaoJDBC.movieupdate(vo);
   }

   public boolean moviedelete(MovieVO2 vo) {
      return managerDaoJDBC.moviedelete(vo);
   }

   public List<WishtopVO> RealtimeWishlist() {
      return managerDaoJDBC.RealtimeWishlist();
   }
   
   public List<LiketopActVO> RealtimeActlike(){
      return managerDaoJDBC.RealtimeActlike();
   }

   public List<LiketopDirVO> Realtimedirlike(){
      return managerDaoJDBC.Realtimedirlike();
   }
   public List<LiketopMVO> RealtimeMlike(){
      return managerDaoJDBC.RealtimeMlike();
   }
}