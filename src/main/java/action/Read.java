package action;

import model.Person;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;


public class Read extends ActionSupport {
    Person personBean;
    DatabaseHelper db;
    String username;

    public String execute() throws Exception{
        try {

            db = new DatabaseHelper();
            String query = "Select * from contacts Where name ='" + username + "'";
            db.rs = db.stmt.executeQuery(query);

            System.out.println("HERE ----------------- Vdsveedv -------------------\n\n\n");

            while(db.rs.next()) {
                personBean = new Person();
                personBean.setName(db.rs.getString("name"));
                personBean.setEmail(db.rs.getString("email"));
                personBean.setAge(db.rs.getInt("age"));
                personBean.setMobile(db.rs.getLong("mobile"));
            }

            System.out.println(getPersonBean());

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError:\n\n\n " + ex.getErrorCode());
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
}