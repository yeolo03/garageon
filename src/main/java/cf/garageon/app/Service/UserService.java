package cf.garageon.app.Service;

import cf.garageon.app.VO.UserVo;


public interface UserService {

	//회원 등록
		public void register(UserVo vo) throws Exception;
		
		public UserVo login(UserVo vo) throws Exception;
	}
