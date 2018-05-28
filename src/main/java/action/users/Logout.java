package action.users;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Logout extends ActionSupport implements SessionAware {

    private Map<String, Object> userSession;
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";
    private static final String USER_ACCESS = "userAccess";

    public String execute() throws Exception {

       // setSessionParameters();
        userSession.remove(USERNAME);
        userSession.remove(USER_ID);
        userSession.remove(USER_ACCESS);

        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {

        userSession = session;
    }

    void setSessionParameters() {
        userSession.put(USERNAME, "");
        userSession.put(USER_ID, -1);
        userSession.put(USER_ACCESS, -1);
    }
}
