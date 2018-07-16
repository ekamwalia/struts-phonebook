package controllers;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;

import action.DatabaseHelper;
import model.Person;


public class PersonController extends ActionSupport implements SessionAware {
    private Person personBean;
    private DatabaseHelper db;
    String username;

    private Map<String, Object> userSession;
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";
    private static final String USER_ACCESS = "userAccess";

    private int userId;

    Person persons[];

    public String addPerson() throws Exception {
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

    public String viewPerson() throws Exception{
        try {

            int isAdmin = (Integer) userSession.get(USER_ACCESS);
            if(isAdmin == 0) {
                userId = (Integer) userSession.get(USER_ID);
            }

            db = new DatabaseHelper();
            String query = "Insert into logs(contactName, userId, operation) values (" +"'" + username + "'," + userSession.get(USER_ID) + ",'read')" ;
            db.stmt.executeUpdate(query);

            query = "Select * from contacts Where name ='" + username + "' and userId = " + userId;
            db.rs = db.stmt.executeQuery(query);


            while(db.rs.next()) {
                personBean = new Person();
                personBean.setName(db.rs.getString("name"));
                personBean.setEmail(db.rs.getString("email"));
                personBean.setAge(db.rs.getInt("age"));
                personBean.setMobile(db.rs.getLong("phone"));
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

    public String updatePerson() throws Exception{
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

        } catch(Exception e) {
            return ERROR;
        }

        return SUCCESS;
    }

    public String deletePerson() throws Exception{
        try {

            int isAdmin = (Integer) userSession.get(USER_ACCESS);
            if(isAdmin == 0) {
                userId = (Integer) userSession.get(USER_ID);
            }

            db = new DatabaseHelper();

            String query = "Insert into logs(contactName, userId, operation) values (" +"'" + username  + "'," + userSession.get(USER_ID) + ",'delete')" ;
            db.stmt.executeUpdate(query);

            query = "Delete from contacts Where name ='" + username + "' and userId = " + userId;
            db.stmt.executeUpdate(query);

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

    public String viewUsersContacts() throws Exception {
        try {

            ArrayList<Person> rowValues = new ArrayList<Person>();

            db = new DatabaseHelper();
            String query = "Select * from contacts where userId = " + userId;
            db.rs = db.stmt.executeQuery(query);

            System.out.println("HERE----------------------------\n\n\n" + username);
            while(db.rs.next()) {

                Person tempPerson = new Person();
                tempPerson.setName(db.rs.getString("name"));
                tempPerson.setEmail(db.rs.getString("email"));
                tempPerson.setAge(db.rs.getInt("age"));
                tempPerson.setMobile(db.rs.getLong("phone"));
                rowValues.add(tempPerson);
            }

            persons = rowValues.toArray(new Person[rowValues.size()]);

            for(int i=0,n=persons.length;i<n;i++) {
                System.out.println(persons[i].toString());
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

    public Person[] getPersons() {
        return persons;
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
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}