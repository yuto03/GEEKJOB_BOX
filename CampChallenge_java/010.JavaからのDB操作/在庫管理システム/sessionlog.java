package dbaccess;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osakayuto
 */
public class sessionlog extends HttpServlet {

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
        
        
        //データベースへの接続を管理する
        //Connectionクラスの変数 データベースの結果をconnectionで受け取る
           PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>ログインページ</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>ユーザー名とパスワードを入力してログインして下さい。</p>");

        HttpSession session = request.getSession(true);

        /* 認証失敗から呼び出されたのかどうか */
        Object status = session.getAttribute("status");
////////////////////////////////////////////////////////////////
        if (status != null){
            out.println("<p>認証に失敗しました</p>");
            out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");

            session.setAttribute("status", null);
        }

        out.println("<form method=\"POST\" action=\"processRequest13\" name=\"loginform\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>ユーザー名</td>");
        out.println("<td><input type=\"text\" name=\"userID\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>パスワード</td>");
        out.println("<td><input type=\"password\" name=\"password\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"login\"></td>");
        out.println("<td><input type=\"reset\" value=\"reset\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
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
