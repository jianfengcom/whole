<%@page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%
//    https://priceparity.pconline.com.cn/load.jsp?pmid=ad7f17c6c92e0cce39772db813552b19#ad=8715
//    http://localhost/woodpecker/hello.jsp?link=ec8bc3444e678458bbdf6ca0f87255d8#ad=8714
    String location = request.getParameter("location");

    String link = "//chinallwx.udesk.cn/im_client/?web_plugin_id=87842";
    pageContext.setAttribute("link", link);


    pageContext.setAttribute("refer", request.getHeader("Referer"));
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.sendRedirect(link);
%>

<script type="text/javascript">
    console.log(location.hash);
    console.log("<%=refer%>");
    /*var url = "<%=link%>";
    window.open(url).location;
    window.location.replace(url);*/
</script>

<%--<meta http-equiv="refresh" content="0.3;URL=${link}" />--%>