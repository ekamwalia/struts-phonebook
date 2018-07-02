package action.users;


import action.DatabaseHelper;
import model.User;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

public class Register extends ActionSupport{
    private User userBean;
    private DatabaseHelper db;

    public String execute() throws Exception {
        try {
            db = new DatabaseHelper();
            String query = "Insert into users(username,password) values (" +"'" + userBean.getUsername()  +"','" + userBean.getPassword() + "')";
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


    public User getUserBean() {

        return userBean;
    }

    public void setUserBean(User user) {
        this.userBean = user;
    }


    public void validate() {
        if (userBean.getUsername() == null || userBean.getUsername().trim().equals("")) {
            addFieldError("userBean.username","The name is required");
        } else if(userBean.getUsername().indexOf('@') == -1 || userBean.getUsername().indexOf('.') == -1 ) {
            addFieldError("userBean.username","Invalid Email Address");
        }

        if (userBean.getPassword().trim().length() < 6 || userBean.getPassword().trim().length() > 20) {
            addFieldError("userBean.password","Length of password should be 6 to 20 characters");
        }
    }
}
