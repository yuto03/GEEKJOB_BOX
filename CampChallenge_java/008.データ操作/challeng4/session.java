/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.date;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osakayuto
 */
public class session extends HttpServlet {

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
        
        //
        //今回参考にしたサイト
        //https://www.javadrive.jp/servlet/session/index2.html
        //
        //
        response.setContentType("text/html;charset=UTF-8");
            Date time = new Date();
            //初回にログインしたか確認するため値をfalse
            HttpSession hs = request.getSession(false);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet session</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //初回hsのfalse　2回目はhsにキャッシュデータがあるので、確認するときはブラウザの履歴を消去する
            if(hs == null){
                //セッションを取得
                hs = request.getSession(true);
                
                out.println("初回のログインは"+time);
                //セッションにログイン時刻を登録
                hs.setAttribute("LastLogin", time.toString());
            }else{
                //前回ログインし登録した時刻データをセッションから取得
               out.println("前回のログインは,"+hs.getAttribute("LastLogin"));
               //比較のため一応今回の時刻を出力
               out.println("<br>"+"今回のログインは"+time+"です");
               //今回のログインした時刻をセッションに登録
                hs.setAttribute("LastLogin", time.toString());
                
            }
           
            out.println("<h1>Servlet session at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
