package rpcrobin.net_client;

import rpcrobin.local.IdPassException;
import rpcrobin.local.User;
import rpcrobin.local.UserService;
import rpcrobin.net_common.Request;
import rpcrobin.net_common.Response;

import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public class UserServiceClientProxy implements UserService {
    @Override
    public User logon(int id, String password) throws IdPassException {
        Request request=new Request("logon",new Class[]{int.class,String.class},new Object[]{id,password});
        Response response=SocketUtil.remoteCall(request);
        if(response.isSuccess())
            return (User)response.getObj();
        throw new IdPassException(response.getException().getMessage());
    }

    @Override
    public List<User> getAllUsers() {
        Request request=new Request("getAllUsers",new Class[]{},new Object[]{});
        Response response=SocketUtil.remoteCall(request);
        if(response.isSuccess())
            return (List<User>)response.getObj();
        return null;
    }

    @Override
    public String getNameById(int id) {
        Request request=new Request("getNameById",new Class[]{int.class},new Object[]{id});
        Response response=SocketUtil.remoteCall(request);
        if(response.isSuccess())
            return (String)response.getObj();
        return null;
    }
}
