package rpcrobin_.local;


import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public interface UserDao {
    public User logon(int id, String password) throws IdPassException;
    public List<User> getAllUsers();
    public String getNameById(int id);
}
