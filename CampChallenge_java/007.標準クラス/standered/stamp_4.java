/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osakayuto
 */
public class stamp_4 extends HttpServlet {

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
                Date date = new Date();    
        Calendar cal = Calendar.getInstance();//カレンダーを作る
        cal.set(2015,0,1,0,0,0);//cal.setで年月日時をsetする
        Date past = cal.getTime();//Date past2にsetしたタイムスタンプ型を入れる


     //-------------------------------c------------------------------------------
        Date date_2 = new Date();    
        Calendar cal_2 = Calendar.getInstance();//カレンダーを作る
        cal_2.set(2015,11,31,23,59,59);//cal_2.setで年月日時をsetする
        Date past_2 = cal_2.getTime();//Date past2にsetしたタイムスタンプ型を入れる
        //long型
        long date1 = past.getTime();
        long date2 = past_2.getTime();
        long timeDiffelence =(date2 - date1);

        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet stamp_4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(date1);
            out.println("<br>"+date2);
            out.println("計算結果"+"<br>"+timeDiffelence);
            out.println("<h1>Servlet stamp_4 at " + request.getContextPath() + "</h1>");
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
