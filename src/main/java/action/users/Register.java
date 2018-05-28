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
            System.out.println("HERE -------------------------------------------------------------------------------------------\n\n\n\n\n\n" + userBean.toString());
            db.stmt.executeUpdate(query);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("HERE -------------------------------------------------------------------------------------------\n\n\n\n\n\n");
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
}
