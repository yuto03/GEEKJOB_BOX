package jums;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import jums.UserDataBeans;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            HttpSession hs = request.getSession();
            HttpSession value_empty = request.getSession();
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }

            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String type = request.getParameter("type");
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");

            
            //セッションに格納
            session.setAttribute("name", name);
            session.setAttribute("year", year);
            session.setAttribute("month",month);
            session.setAttribute("day", day);
            session.setAttribute("type", type);
            session.setAttribute("tell", tell);
            session.setAttribute("comment", comment);
            System.out.println("Session updated!!");
            
            
            UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            //For input string: ""エラー回避のための条件文
            if(!year.equals("")&&!month.equals("")&&!day.equals("")){
            udb.setYear(Integer.parseInt(year));
            udb.setMonth(Integer.parseInt(month));
            udb.setDay(Integer.parseInt(day));
            }
            udb.setName(name);
            udb.setStYear(year);
            udb.setStMonth(month);
            udb.setStDay(day);
            udb.setType(type);
            udb.setTell(tell);
            udb.setComment(comment);
            session.setAttribute("udb", udb);
            /*
            巨大なソース修正１ 開発タスク4
            セッションhs内の要素が空であるかを判定し""であればセッションvalue_emptyに要素をsetしています。
            insertconfirmにて要素の有無によるif条件分岐をしています。
            */
            
            Enumeration e = session.getAttributeNames();
            while(e.hasMoreElements()) {
            String key = (String)e.nextElement();
            System.out.println(session.getAttribute(key));
            if(session.getAttribute(key).equals("")){
            value_empty.setAttribute("value_empty",true);
            
            }     
            }
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);//"/insertconfirm.jsp"
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
