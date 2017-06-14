package zucc.edu.cn.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import zucc.edu.cn.DAO.UserThread;
import zucc.edu.cn.DAO.Usercheck;

public class PcClientServer {
	public static void main(String[] args) throws IOException {
		//PC端Socket连接
	    ServerSocket ss = new ServerSocket(10000);
	    
	    while(true){
	    	Socket s = ss.accept();
	    	System.out.println("成功连接");
	    	Thread conn = new Thread(new UserThread(s));
	    	conn.start();
	    }
	    
	    
	}
	
}
