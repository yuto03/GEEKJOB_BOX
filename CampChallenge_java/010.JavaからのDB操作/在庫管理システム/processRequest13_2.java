/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osakayuto
 */
public class processRequest13_2 extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        String name = request.getParameter("name");
        int num = Integer.parseInt(request.getParameter("num"));
        int price = Integer.parseInt(request.getParameter("price"));
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/challeng_db", "challeng1", "pass");
            db_st = db_con.prepareStatement("insert into ItemProfile(itemID,name,num,price)values(?,?,?,?)" );
            db_st.setInt(1,itemID);
            db_st.setString(2,name);
            db_st.setInt(3,num);
            db_st.setInt(4,price);
//            
            db_st.executeUpdate();
            //////////////////////////////////////
            db_st = db_con.prepareStatement("select * from ItemProfile where itemID =? ");

            db_data= db_st.executeQuery();
            if(db_data.next()==true){
            out.println("登録が完了いたしました。");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登録ページ</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p><a href=\"processRequest13_3\">商品一覧へ</a></p>");
            out.println("<p><a href=\"iteminfo.jsp\">商品登録ページへ</a></p>");
            out.println("</body>");
            out.println("</html>");
            }else{
            out.println("登録に失敗しました。");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登録ページ</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p><a href=\"processRequest13_3\">商品一覧へ</a></p>");
            out.println("<p><a href=\"iteminfo.jsp\">商品登録ページへ</a></p>");
            out.println("</body>");
            out.println("</html>");
            }



            
            
            db_data.close();
            db_st.close();
            db_con.close();
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
