package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Log;
import action.DatabaseHelper;

public class ViewAllLogs extends ActionSupport{
    private DatabaseHelper db;
    Log logs[];

    public String execute() throws Exception{
        try {

            ArrayList<Log> rowValues = new ArrayList<Log>();

            db = new DatabaseHelper();
            String query = "Select * from logs ";
            db.rs = db.stmt.executeQuery(query);


            while(db.rs.next()) {

                System.out.println("HERE in the result set!!!! -----------------------\n");

                Log tempLog = new Log();
                tempLog.setId(db.rs.getInt("id"));
                tempLog.setContactName(db.rs.getString("contactName"));
                tempLog.setUserId(db.rs.getInt("userId"));
                tempLog.setOperation(db.rs.getString("operation"));
                System.out.println(tempLog.toString());
                rowValues.add(tempLog);
            }

            logs = rowValues.toArray(new Log[rowValues.size()]);

            System.out.println("HERE !!!! -----------------------\n\n\n\n\n\n\n\n");
            for(int i=0,n=logs.length;i<n;i++) {
                System.out.println(logs[i].toString());
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

    public Log[] getLogs() {
        return logs;
    }
}
