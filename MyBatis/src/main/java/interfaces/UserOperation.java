package interfaces;

import model.User;

import java.util.List;

/**
 * Created by robin on 2017/7/31.
 */
public interface UserOperation {
    public User selectUserByID(int id);
    public List selectUsers(String userName);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);

}