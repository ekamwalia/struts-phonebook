package action;

import model.Person;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;

public class Update extends ActionSupport {
    Person personBean;
    DatabaseHelper db;
    String username;

    public String execute() throws Exception{
        try {

            db = new DatabaseHelper();
            String query = "Update contacts set mobile=" +personBean.getMobile()+ ", email='" + personBean.getEmail() + "', age=" + personBean.getAge() +" Where name ='" + personBean.getName() + "'";
            db.stmt.executeUpdate(query);

            System.out.println("WELL WELL WELL ---------------------------------------\n\n\n");

            System.out.println(getPersonBean());
            System.out.println(query);

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
