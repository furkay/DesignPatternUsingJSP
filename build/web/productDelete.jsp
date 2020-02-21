<%@page import="Tablolar.tblproduct"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
int id=Integer.parseInt(request.getParameter("id"));
Islemler.tblproduct_crd.Sil(id);
  response.sendRedirect("productList.jsp");
 
%>