package cf.garageon.app.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cf.garageon.app.DAO.UserDAO;
import cf.garageon.app.VO.UserVo;


@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;

	

	@Override
	public void register(UserVo vo) throws Exception {
		// TODO Auto-generated method stub
		dao.register(vo);
	}



	@Override
	public UserVo login(UserVo vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	

	
	
}
