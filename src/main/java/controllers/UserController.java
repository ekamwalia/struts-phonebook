package controllers;


import action.DatabaseHelper;
import model.User;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController extends ActionSupport{
    private User userBean;
    private DatabaseHelper db;

    private int userId;

    public String grantAdminAccess() throws Exception {
        try {
            db = new DatabaseHelper();
            String query = "Update users set admin = 1 where id = " + userId;
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

    public String revokeAdminAccess() throws Exception {
        try {
            db = new DatabaseHelper();
            String query = "Update users set admin = 0 where id = " + userId;
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

    User users[];

    public String viewAllUsers() throws Exception{
        try {

            ArrayList<User> rowValues = new ArrayList<User>();

            db = new DatabaseHelper();
            String query = "Select * from users ";
            db.rs = db.stmt.executeQuery(query);


            while(db.rs.next()) {

                User tempUser = new User();
                tempUser.setId(db.rs.getInt("id"));
                tempUser.setUsername(db.rs.getString("username"));
                tempUser.setAdmin(db.rs.getInt("admin"));

                rowValues.add(tempUser);
            }

            users = rowValues.toArray(new User[rowValues.size()]);

            for(int i=0,n=users.length;i<n;i++) {
                System.out.println(users[i].toString());
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError:\n\n\n " + ex.getErrorCode());

            return ERROR;
        } catch(Exception e) {
            return ERROR;
        }

        return SUCCESS;
    }

    public User[] getUsers() {
        return users;
    }

    public User getUserBean() {

        return userBean;
    }

    public void setUserBean(User user) {
        this.userBean = user;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
