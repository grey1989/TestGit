package caomei.service.IMPL;

import caomei.UserDao.IMPL.UserDaoIMPL;
import caomei.UserDao.UserDao;
import caomei.domain.User;
import caomei.service.UserService;

public class UserServiceIMPL implements UserService {
    UserDao dao=new UserDaoIMPL();
    @Override
    public User login(User user) {
        User loginuser=dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        return loginuser;
    }
}
