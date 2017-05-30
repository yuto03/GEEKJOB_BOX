package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */

/*
*巨大なソース修正2修正点
*複合検索用メソッド　ComplexSearch()の追加
*更新用メソッド　Update()の追加
*削除用メソッド　Delete()の追加
*
*/
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
     /**
     * データの複合検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> ComplexSearch(UserDataDTO ud) throws SQLException{
        Connection con  = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            String sql = "SELECT * FROM user_t ";            
            boolean flag = false;
            int i = 0;
            if(!ud.getName().equals("")){
            sql += "WHERE name like ?";
            map.put("Name",map.size()+1);
            flag = true;
            }else{
            flag = false;
            }
            
            if(ud.getBirthday()!=null){
            if(!flag){
            sql += "WHERE birthday like ?";
            map.put("Birthday",map.size()+1);
            flag = true;
            }else{
            sql += "and birthday like ?";
            map.put("Birthday",map.size()+1);
            
            }
            }

            if(ud.getType()!=0){
            if(!flag){
            sql += "WHERE type like ?";
            map.put("Type",map.size()+1);
            }else{
            sql +="and type like ?";
            map.put("Type",map.size()+1);
            
            }
            }


            st =  con.prepareStatement(sql);
            if(map.get("Name")!=null){ st.setString(map.get("Name"),"%"+ud.getName()+"%"); }
            if(map.get("Birthday")!=null){ st.setString(map.get("Birthday"),"%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%"); }
            if(map.get("Type")!=null){ st.setInt(map.get("Type"),ud.getType()); }

            ResultSet rs = st.executeQuery();
            ArrayList<UserDataDTO>sqlresult = new ArrayList<UserDataDTO>();
            while(rs.next()){
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            sqlresult.add(resultUd);
            i+=1;
            }
            System.out.println("Complexsearch completed");

            return sqlresult;
            }catch(SQLException e){

            System.out.println(e.getMessage());
            throw new SQLException(e);

            }finally{
            if(con != null)
            {
            con.close();
            }

            }
            }//-----------------ComplexSearch()end-----------------------------------------
         /**
     * データの削除処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void Delete(UserDataDTO ud)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "DELETE FROM user_t  WHERE userID = ?"; 
            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            st.executeUpdate();
            System.out.println("Delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }//-----------------Delete()end-----------------------------------------//
    
     /**
     * データの更新処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 更新結果
     */
    public UserDataDTO UpDate(UserDataDTO ud) throws SQLException{
        Connection con  = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE user_t Set name = ? ,birthday = ?  ,tell = ? ,type = ? ,comment = ? ,newDate = ? WHERE userID = ?";

            st =  con.prepareStatement(sql);
            
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());
            
            st.executeUpdate();
            st = con.prepareStatement("select * from user_t WHERE userID = ?");
            st.setInt(1, ud.getUserID());
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            System.out.println("Update completed");

            return resultUd;
            }catch(SQLException e){

            System.out.println(e.getMessage());
            throw new SQLException(e);

            }finally{
            if(con != null)
            {
            con.close();
            }

            }
    }//-----------------Update()end-----------------------------------------//
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t";
            
            boolean flag = false;
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                
                flag = true;
            }else{
                flag = false;
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                sql += " WHERE birthday like ?";
                flag = true;
                }else{
                sql += " and birthday like ?";
                }
            }
            if (ud.getType()!=0) {
                if(!flag){
                sql += " WHERE type like ?";
                }else{
                sql += " and type like ?";
                }
            }
            //プリコンパイルされた SQL 文を表すオブジェクト           
            st =  con.prepareStatement(sql);
            st.setString(1, "%"+ud.getName()+"%");
            st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
            st.setInt(3, ud.getType());
            //検索結果をDTO　resultUdに格納　serachメソッドを使うとresultUdをreturnします。
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("search completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

    
}