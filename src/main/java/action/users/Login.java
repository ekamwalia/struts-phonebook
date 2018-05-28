package action.users;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;

import action.DatabaseHelper;
import model.User;

public class Login extends ActionSupport implements SessionAware {
    private User userBean;
    private User userData;
    private DatabaseHelper db;

    private Map<String, Object> userSession;
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";
    private static final String USER_ACCESS = "userAccess";

    public String execute() throws Exception {
        try {
            db = new DatabaseHelper();
            String query = "Select * from users Where username ='" + userBean.getUsername() + "'";
            db.rs = db.stmt.executeQuery(query);

            if (!db.rs.next() ) {
                System.out.println("HERE-------------------------------------------------------------------------------------------\n\n\n\n\n\n" + "ERROR HAI");
                return ERROR;
            } else {

                    userData = new User();

                    userData.setId(db.rs.getInt("id"));
                    userData.setUsername(db.rs.getString("username"));
                    userData.setPassword(db.rs.getString("password"));
                    userData.setAdmin(db.rs.getInt("admin"));

                    if(userData.getPassword().equals( userBean.getPassword()))
                        setSessionParameters();
                    else {
                        System.out.println("HERE-------------------------------------------------------------------------------------------\n\n\n\n\n\n" + "Password dont match");
                        System.out.println(userData.getPassword() + "  and   " + userBean.getPassword());
                        return ERROR;
                    }
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("HERE-------------------------------------------------------------------------------------------\n\n\n\n\n\n");
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            return ERROR;

        }

        return SUCCESS;
    }


    public User getUserBean() {

        return userBean;
    }

    public void setUserBean(User user) {

        this.userBean = user;
    }

    public void setSession(Map<String, Object> session) {

        userSession = session;
    }

    void setSessionParameters() {
        userSession.put(USERNAME, userData.getUsername());
        userSession.put(USER_ID, userData.getId());
        userSession.put(USER_ACCESS, userData.getAdmin());
    }
}
