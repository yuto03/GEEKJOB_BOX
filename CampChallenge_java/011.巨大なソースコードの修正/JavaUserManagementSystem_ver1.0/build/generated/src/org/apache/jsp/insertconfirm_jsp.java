package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserDataBeans;
import java.util.Enumeration;
import jums.JumsHelper;
import javax.servlet.http.HttpSession;

public final class insertconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    HttpSession value_empty = request.getSession();
    //UserDataBeans udb = new UserDataBeans();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");
/*
       巨大なソース修正１　課題タスク4
　　　　　if(!hs.getAttribute("name").equals(""))でif条件分岐を行うとinsert.jspから受け取ったnameの値が入っていれば他の要素が未入力でも通過してしまいます。
　　　　　if条件としてセッションvalue_emptyの要素の有無により分岐させています。
　　　　　.セッションvalue_emptyに要素がなければ登録確認画面へ
        .セッションvalue_emptyに要素があれば入力が不完全な部分を表示し指摘しています。
    */
      out.write("\n");
      out.write("\n");
      out.write("    <h1>登録確認</h1>\n");
      out.write("    ");
 if(value_empty.getAttribute("value_empty") == null){ 
      out.write("\n");
      out.write("            \n");
      out.write("        名前:");
      out.print( udb.getName());
      out.write("<br>\n");
      out.write("        生年月日:");
      out.print( udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日");
      out.write("<br>\n");
      out.write("        種別:");
      out.print( udb.getType());
      out.write("<br>\n");
      out.write("        電話番号:");
      out.print( udb.getTell());
      out.write("<br>\n");
      out.write("        自己紹介:");
      out.print( udb.getComment());
      out.write("<br>\n");
      out.write("\n");
      out.write("        上記の内容で登録します。よろしいですか？\n");
      out.write("        <form action=\"insertresult\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\"><!--不正アクセス防止用セッションの取得-->\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("        </form>\n");
      out.write("    ");
 }else{ 
      out.write("\n");
      out.write("        \n");
      out.write("        <h1>入力が不完全です</h1>\n");
      out.write("        ");
if(udb.getName().equals("")){
      out.write("\n");
      out.write("        <p>お名前を入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(udb.getStYear().equals("")){
      out.write("\n");
      out.write("        <p>生年月日：年を入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(udb.getStMonth().equals("")){
      out.write("\n");
      out.write("        <p>生年月日：月を入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(udb.getStDay().equals("")){
      out.write("\n");
      out.write("        <p>生年月日：日を入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(udb.getType().equals("")){
      out.write("\n");
      out.write("        <p>職種を入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(udb.getTell().equals("")){
      out.write("\n");
      out.write("        <p>電話番号を入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("        ");
if(udb.getComment().equals("")){
      out.write("\n");
      out.write("        <p>コメントを入力してください。</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"insert\" method=\"POST\">\n");
      out.write("        <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
      out.write("        </form>\n");
      out.write("<!--        巨大なソース修正　開発タスク１修正-->\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </body>\n");
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
