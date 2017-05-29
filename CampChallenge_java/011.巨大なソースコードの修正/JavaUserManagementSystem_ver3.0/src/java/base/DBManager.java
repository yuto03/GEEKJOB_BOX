package base;
/**
 *
 * @author hayashi-s
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8889/challenge_db","challenge1","y114");
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            System.out.println("デーダベースの接続が確認できませんでした。サーバー接続してください。");
            throw new IllegalMonitorStateException();
            
        }
    }
}
