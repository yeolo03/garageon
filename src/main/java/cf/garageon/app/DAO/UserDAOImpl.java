package cf.garageon.app.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cf.garageon.app.VO.UserVo;

@Repository
public class UserDAOImpl implements UserDAO {
    @Inject
	SqlSession sqlSession;
    


	@Override
	public void register(UserVo vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("Usermapper.register",vo);
	}



	@Override
	public UserVo login(UserVo vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Usermapper.login",vo);
	}

}
