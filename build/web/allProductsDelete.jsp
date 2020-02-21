
<%@page import="Tablolar.tblproduct"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
Islemler.tblproduct_crd.TumunuSil();
  response.sendRedirect("productList.jsp");
 
%>