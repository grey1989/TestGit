package caomei.UserDao;

import caomei.domain.User;

public interface UserDao {

    User findUserByUsernameAndPassword(String username, String password);
}
