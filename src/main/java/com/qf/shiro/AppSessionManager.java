package com.qf.shiro;

import com.qf.exception.AppException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

public class AppSessionManager extends DefaultWebSessionManager {

    private final String SESSION_KEY = "shiro-session-key";
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        if (sessionId == null){
            return null;
        }
        //强转
        WebSessionKey webSessionKey = null;
        if (sessionKey instanceof WebSessionKey){
             webSessionKey = (WebSessionKey) sessionKey;
        }
        //通过websessionkey获取request对象
        ServletRequest req = webSessionKey.getServletRequest();
        //去req域中
        Session session = (Session) req.getAttribute(SESSION_KEY);
        if (session != null){
            return session;
        }else {
            session = retrieveSessionFromDataSource(sessionId);
            if (session == null){
                String msg = "Could not find a session with ID ["+sessionId+"]";
                throw new UnknownSessionException(msg);
            }
            req.setAttribute(SESSION_KEY,session);
        }
        return session;
    }
}
