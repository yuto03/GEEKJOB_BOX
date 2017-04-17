/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author osakayuto
 */
public class processRequest6 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //データベースへの接続を管理する
        //Connectionクラスの変数 データベースの結果をconnectionで受け取る
        PrintWriter out = response.getWriter();
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/challeng_db", "challeng1", "pass");
            db_st = db_con.prepareStatement("delete from user where userID = 6 ");
            //insert delet したらexecuteUpdate()メソッドで更新する
            db_st.executeUpdate();
                db_st = db_con.prepareStatement("select * from user ");
//            mysqlから受け取った値をexecuteQueryで実行

                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.print("ID："+db_data.getInt("userID")) ;
                    out.print("名前："+db_data.getString("name"));
                    out.print("電話番号："+db_data.getString("tell"));
                    out.print("年齢："+db_data.getInt("age"));
                    out.print("誕生日："+db_data.getString("birthday"));
                    out.print("departmentID："+db_data.getInt("departmentID"));
                    out.print("stationID："+db_data.getInt("stationID")+"<br>");
                }

            db_data.close();
            db_st.close();
            db_con.close();
            //エラーハンドリング
            //例外処理をしないとどうなるか：エラーが発生しても自分たちのシステム全体が狂って欲しく無いから
            //trycatch tryの中で起きた内容をcatchで処理する。
        } catch (SQLException e_sql) {
            out.println("接続にエラーが発生しました:" + e_sql.toString());
            //Exceptionクラス　なんでも扱えるクラス
        } catch (Exception e) {
            out.println("接続にエラーが発生しました:" + e.toString());
            //finallyで最終的な終了する
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.print(e_con.getMessage());
                }
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
