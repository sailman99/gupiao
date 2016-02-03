package com.gupiao.socket;





import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gupiao.model.dao.GupiaoDAO;
import com.example.share.Gpsclientdata;




public class MyProtocolHandler extends IoHandlerAdapter {
	
    private final static Logger LOGGER = LoggerFactory.getLogger(MyProtocolHandler.class);

    private final Set<IoSession> sessions = Collections
            .synchronizedSet(new HashSet<IoSession>());

    
    
    
    private GupiaoDAO gupiaoDAO;	
	public void setGupiaoDAO(GupiaoDAO gupiaoDAO) {
		this.gupiaoDAO = gupiaoDAO;
	}
	
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        LOGGER.warn("Unexpected exception.", cause);
        // Close connection when unexpected exception is caught.
        session.close(true);
    }

   

    @SuppressWarnings("unchecked")
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// TODO Auto-generated method stub    
    	if(message instanceof List<?>){    		
    		gupiaoDAO.updateGpsclientdata((List<Gpsclientdata>)message);    		
    	}
		super.messageReceived(session, message);		
	}



	public void broadcast(String message) {
        synchronized (sessions) {
            for (IoSession session : sessions) {
                if (session.isConnected()) {
                    session.write(message);
                }
            }
        }
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
    	System.out.print("sessionOpened");
    	Date date = new Date(); 
    	//format对象是用来以指定的时间格式格式化时间的 
    	SimpleDateFormat from = new SimpleDateFormat( 
    	"yyyy-MM-dd HH:mm:ss"); //这里的格式可以自己设置 
    	//format()方法是用来格式化时间的方法 
    	String times = from.format(date); 
    	System.out.println(times); 
    	sessions.add(session);    	
    }
    @Override
    public void sessionClosed(IoSession session) throws Exception {    
    	System.out.print("sessionClosed");
    	Date date = new Date(); 
    	//format对象是用来以指定的时间格式格式化时间的 
    	SimpleDateFormat from = new SimpleDateFormat( 
    	"yyyy-MM-dd HH:mm:ss"); //这里的格式可以自己设置 
    	//format()方法是用来格式化时间的方法 
    	String times = from.format(date); 
    	System.out.println(times); 
        sessions.remove(session);
    }

  
}
