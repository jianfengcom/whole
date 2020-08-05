<%@page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%
    //    https://priceparity.pconline.com.cn/load.jsp?pmid=ec8bc3444e678458bbdf6ca0f87255d8#ad=8714
//    http://localhost/woodpecker/load.jsp?link=ec8bc3444e678458bbdf6ca0f87255d8#ad=8714

    String location = request.getParameter("location");
//    System.out.println(location);//ad7f17c6c92e0cce39772db813552b19
    String link = "//chinallwx.udesk.cn/im_client/?web_plugin_id=87842";
    pageContext.setAttribute("link", link);

//    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.sendRedirect(link);
%>