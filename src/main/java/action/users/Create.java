package action.users;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;

import action.DatabaseHelper;
import model.Person;


public class Create extends ActionSupport implements SessionAware {
    private Person personBean;
    private DatabaseHelper db;

    private Map<String, Object> userSession;
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";
    private static final String USER_ACCESS = "userAccess";

    private int userId;

    public String execute() throws Exception {
        try {
            int isAdmin = (Integer) userSession.get(USER_ACCESS);
            if(isAdmin == 0) {
                userId = (Integer) userSession.get(USER_ID);
            }

            db = new DatabaseHelper();
            String query = "Insert into contacts(name, phone, email, age, userId) values (" +"'" + personBean.getName()  +"'," + personBean.getMobile() +",'" + personBean.getEmail()  +"'," + personBean.getAge() + "," + userId + ")" ;
            db.stmt.executeUpdate(query);

            query = "Insert into logs(contactName, userId, operation) values (" +"'" + personBean.getName()  + "'," + userSession.get(USER_ID) + ",'create')" ;
            db.stmt.executeUpdate(query);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            return ERROR;
        } catch(Exception e) {
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

    public void setSession(Map<String, Object> session) {

        userSession = session;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void validate() {
        if (personBean.getName() == null || personBean.getName().trim().equals("")) {
            addFieldError("personBean.name","The name is required");
        } else if(!personBean.getName().matches("[a-zA-Z\\s\'\"]+")) {
            addFieldError("personBean.name","Name should not have special characters");
        }

        String mobileStr = Long.toString(personBean.getMobile());

        if (mobileStr.length() != 10) {
            addFieldError("personBean.mobile","Mobile number should be 10 digits long");
        } else if(mobileStr.charAt(0) != '9' && mobileStr.charAt(0) != '8' && mobileStr.charAt(0) != '7') {
            addFieldError("personBean.mobile","Mobile number should start with 9, 8 or 7");
        }

        if (personBean.getEmail() == null || personBean.getEmail().trim().equals("")) {
            addFieldError("personBean.username","The name is required");
        } else if(personBean.getEmail().indexOf('@') == -1 || personBean.getEmail().indexOf('.') == -1 ) {
            addFieldError("personBean.email","Invalid Email Address");
        }


    }

}