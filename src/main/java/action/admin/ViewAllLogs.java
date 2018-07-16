package action.admin;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Log;
import action.DatabaseHelper;

public class ViewAllLogs extends ActionSupport{
    private DatabaseHelper db;
    Log logs[];
    LogsChart chartData[];

    public String execute() throws Exception{
        try {

            ArrayList<Log> rowValues = new ArrayList<Log>();

            db = new DatabaseHelper();
            String query = "Select * from logs order by id desc ";
            db.rs = db.stmt.executeQuery(query);


            while(db.rs.next()) {


                Log tempLog = new Log();
                tempLog.setId(db.rs.getInt("id"));
                tempLog.setContactName(db.rs.getString("contactName"));
                tempLog.setUserId(db.rs.getInt("userId"));
                tempLog.setOperation(db.rs.getString("operation"));
                System.out.println(tempLog.toString());
                rowValues.add(tempLog);
            }

            logs = rowValues.toArray(new Log[rowValues.size()]);

            for(int i=0,n=logs.length;i<n;i++) {
                System.out.println(logs[i].toString());
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

    public String makeChart() throws Exception {
        try {

            ArrayList<LogsChart> rowValues = new ArrayList<LogsChart>();

            db = new DatabaseHelper();
            String query = "select username, count(*) as count from logs inner join users on logs.userId = users.id group by username;";
            db.rs = db.stmt.executeQuery(query);

            System.out.println("Here!----------------\n\n\n\n completed query");
            while(db.rs.next()) {

                LogsChart tempLog = new LogsChart();
                System.out.println("Username: " + db.rs.getString("username") + "  " + db.rs.getInt("count"));
                tempLog.setUsername(db.rs.getString("username"));
                tempLog.setCount(db.rs.getInt("count"));
                System.out.println("ANOTHER ENTRY" + tempLog.toString());
                rowValues.add(tempLog);
            }

            chartData = rowValues.toArray(new LogsChart[rowValues.size()]);

            System.out.println("chartData= \n ");
            for(int i=0,n=chartData.length;i<n;i++) {
                System.out.println("Element" + i+1 +  chartData[i].toString());
            }


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException:\n\n\n " + ex.getMessage());
            System.out.println("SQLState:\n\n\n " + ex.getSQLState());
            System.out.println("VendorError:\n\n\n " + ex.getErrorCode());

            return ERROR;
        } catch(Exception e) {
            System.out.println("Exception:\n\n\n " + e);
            return ERROR;
        }

        return SUCCESS;
    }

    public Log[] getLogs() {
        return logs;
    }

    public LogsChart[] getChartData() {
        return chartData;
    }

    public void setChartData(LogsChart[] chartData) {
        this.chartData = chartData;
    }
}

class LogsChart {
    String username;
    int count = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}