package action;

import model.Person;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;


public class Create extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private Person personBean;
    private DatabaseHelper db;

    public String execute() throws Exception {
        try {

            db = new DatabaseHelper();
            String query = "Insert into contacts values (" +"'" + personBean.getName()  +"'," + personBean.getMobile() +",'" + personBean.getEmail()  +"'," + personBean.getAge() + ")";
            db.stmt.executeUpdate(query);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return SUCCESS;
    }


    public Person getPersonBean() {

        return personBean;
    }

    public void setPersonBean(Person person) {

        this.personBean = person;
    }
}