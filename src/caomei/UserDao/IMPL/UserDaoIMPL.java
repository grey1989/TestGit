package caomei.UserDao.IMPL;

import caomei.UserDao.UserDao;
import caomei.domain.User;

import java.sql.*;

public class UserDaoIMPL implements UserDao {

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        User user=new User();
        boolean flag=true;
      /*  user.setUsername(username);
        user.setPassword(password);
        return user;*/
        String xx="aaaaaaaaaaaaaa"+user+"aaaaaaaa";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/caomei?serverTimezone=UTC","root","root");
            String sql="select * from user where username= '"+username+"' and password = '"+password+"'";
            //select * from user where username='zhansan' and password='' or 1=1 -- '

            //stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                    user.setUsername(username1);
                    user.setPassword(password1);
                    flag=false;
                System.out.println("yyyyyy");
            }
            if(flag){
                System.out.println("xxxxxx");
                return null;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    System.out.println("ppppppp");
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return user;
    }
}
