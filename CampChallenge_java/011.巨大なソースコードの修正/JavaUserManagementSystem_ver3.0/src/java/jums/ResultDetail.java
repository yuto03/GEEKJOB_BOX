package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*巨大なソース修正2 
     (2) -> Integer.parseInt(request.getParameter("id"))でリクエストパラメータを取得しsetUserIDへ値を入れています。
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            HttpSession session= request.getSession();
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();            
            searchData.setUserID(Integer.parseInt(request.getParameter("id")));
            System.out.print(searchData.getUserID()+"--------------getID--------------------");
            
            //URL id直書き　直リンク防止
            System.out.print(session.getAttribute("setid")+"--------------getAttribute--------------------");
            if(session.getAttribute("setid")==null){
                 
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.print(id+"--------------intid--------------------");
            session.setAttribute("setid", id);
            }
            int idchk = (Integer)session.getAttribute("setid");
            System.out.print(idchk+"-----------------------チェック----------------");
            if(idchk != searchData.getUserID() ){
                session.removeAttribute("setid");
                throw new Exception("不正なアクセスです");
            }
            
            //session.removeAttribute("setid");
            UserDataDTO resultData = UserDataDAO .getInstance().searchByID(searchData);
            request.setAttribute("resultData", resultData);

            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
