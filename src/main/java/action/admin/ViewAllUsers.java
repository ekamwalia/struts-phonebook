package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import action.DatabaseHelper;

public class ViewAllUsers extends ActionSupport{
    private DatabaseHelper db;
    User users[];

    public String execute() throws Exception{
        try {

            ArrayList<User> rowValues = new ArrayList<User>();

            db = new DatabaseHelper();
            String query = "Select * from users ";
            db.rs = db.stmt.executeQuery(query);


            while(db.rs.next()) {

                System.out.println("HERE in the result set!!!! -----------------------\n");
                User tempUser = new User();
                tempUser.setId(db.rs.getInt("id"));
                tempUser.setUsername(db.rs.getString("username"));
                tempUser.setAdmin(db.rs.getInt("admin"));

                rowValues.add(tempUser);
            }

            users = rowValues.toArray(new User[rowValues.size()]);

            System.out.println("HERE !!!! -----------------------\n\n\n\n\n\n\n\n");
            for(int i=0,n=users.length;i<n;i++) {
                System.out.println(users[i].toString());
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError:\n\n\n " + ex.getErrorCode());

            return ERROR;
        }

        return SUCCESS;
    }

    public User[] getUsers() {
        return users;
    }
}
