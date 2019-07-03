```
import java.sql.*;
public class MyJdbc {
/**
 * @Description:JDBC的Demo
 * 使用到的类有Driver、DriverManager、Connection、PreparedStatement、
 * ResultSet

 * Created by shanzhihong on 2019/07/03-9:50.
 * @version 1.0
 */
    private final String driver = "com.mysql.jdbc.driver";
    private final String url = "jdbc:mysql://localhsot/USREDB?user=root&password=123456";
    public void query() throws SQLException {
        Connection conn = null;
        PreparedStatement pstatem = null;
        ResultSet set = null;
        try {
            conn = this.getConnection(url);
            String sql = "select pwd from user where uname = ?";
            pstatem = conn.prepareStatement(sql);
            pstatem.setString(1,"xiaoli");
            set = pstatem.executeQuery();
            while (set.next()){
                String pwd = set.getString("pwd");
                System.out.println(pwd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            set.close();
            pstatem.close();
            conn.close();
        }
    }
    public Connection getConnection(String url) throws SQLException{
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args){
        MyJdbc myJdbc = new MyJdbc();
        try{
            myJdbc.query();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
```


