package action.users;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;

import action.DatabaseHelper;
import model.Person;

public class Update extends ActionSupport implements SessionAware {
    Person personBean;
    DatabaseHelper db;
    String username;

    private Map<String, Object> userSession;
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";
    private static final String USER_ACCESS = "userAccess";

    private int userId;

    public String execute() throws Exception{
        try {

            int isAdmin = (Integer) userSession.get(USER_ACCESS);
            if(isAdmin == 0) {
                userId = (Integer) userSession.get(USER_ID);
            }

            db = new DatabaseHelper();

            String query = "Insert into logs(contactName, userId, operation) values (" +"'" + personBean.getName()  + "'," + userSession.get(USER_ID) + ",'update')" ;
            db.stmt.executeUpdate(query);

            query = "Update contacts set phone=" +personBean.getMobile()+ ", email='" + personBean.getEmail() + "', age=" + personBean.getAge() +" Where name ='" + personBean.getName() + "' and userId = " + userId;
            db.stmt.executeUpdate(query);

            System.out.println(getPersonBean());
            System.out.println(query);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError:\n\n\n " + ex.getErrorCode());

            return ERROR;
        }
        return SUCCESS;
    }

    public Person getPersonBean() {

        return personBean;
    }

    public void setPersonBean(Person person) {

        this.personBean = person;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSession(Map<String, Object> session) {

        userSession = session;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
