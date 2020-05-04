package cf.garageon.app.DAO;

import cf.garageon.app.VO.UserVo;

public interface UserDAO {

	//회원 등록
	public void register(UserVo vo) throws Exception;
	
	public UserVo login(UserVo vo) throws Exception;
}
