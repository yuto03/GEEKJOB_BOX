package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserDataBeans;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    HttpSession hs = request.getSession();
    hs.invalidate();
            /*
    巨大なソース修正１　課題7
    topに戻ってきた際session("udb")を削除を行いセッションをクリアしています。
    */
    //トップへ戻ってきた際にセッションを破棄します。
    //セッションを削除しなければ前回insert.jspのフォームで記入した情報が残った状態であるためremoveAttribute()でセッションを破棄しています。
    if((UserDataBeans)hs.getAttribute("udb") !=null){
        hs.removeAttribute("udb");
    }   


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>JUMSトップ</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>ユーザー情報管理トップ</h1><br>\n");
      out.write("    <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、s\n");
      out.write("        付随して修正や削除を行うことができます</h3><br>\n");
      out.write("    <a href=\"insert\">新規登録</a><br>\n");
      out.write("    \n");
      out.write("    <a href=\"\">検索(修正・削除)</a><br>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
