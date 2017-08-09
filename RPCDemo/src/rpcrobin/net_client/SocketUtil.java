package rpcrobin.net_client;


import rpcrobin.net_common.NetConstant;
import rpcrobin.net_common.Request;
import rpcrobin.net_common.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Created by robin on 2017/8/9.
 */
public class SocketUtil {
    public static Response remoteCall(Request request){

        try {
            System.out.println("写入的request为："+request);
            Socket socket = new Socket("127.0.0.1", NetConstant.PORT);
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            socket.getOutputStream());
            Thread.sleep(1000);
            oos.writeObject(request);

            ObjectInputStream ios =
                    new ObjectInputStream(
                            socket.getInputStream());
            Response response = (Response)ios.readObject();

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
