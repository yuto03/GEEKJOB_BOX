package org.date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.servlet.http.Cookie;//cookieを使う

/**
 *
 * @author osakayuto
 */
public class cookie extends HttpServlet {

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
        //ユーザー一回目の訪問
        Date time= new Date();
        //cookieのインスタンスを生成
        //cookieは文字列だけ管理している　なのでtime.toString()で文字列として出力
        Cookie cookie = new Cookie("lastlogin",time.toString());
        //クライアントに書き込む
        response.addCookie(cookie);
        //次の訪問で
        Cookie[] cs = request.getCookies();        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>クッキーテスト</title>");            
            out.println("</head>");
            out.println("<body>");
            //初回csに値がなければ"初回ログインは"+timeを出力
            //二回目以降前回登録した値を出力
            if(cs==null){
                out.println("初回ログインは"+time); 
                    }else{
                    //配列cs内の要素数ループする
                    for (int i=0; i<cs.length; i++){
                    //もし配列csの名前が"lastlogin"と等しければ
                    if (cs[i].getName().equals("lastlogin")){
                    //cs内の値を取得し出力
                    out.println("前回ログインは"+cs[i].getValue());
                    break;
                    }
                }
            }
           
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
