<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //index.jsp ye uğramadan doğrudan bu sayfa açılırsa...tekrar index.jsp
    //geri gönderir.... illa oturum açılacak.....
    if (session.getAttribute("Oturum") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="tr">
    <!--<![endif]-->
    <head>
           <link rel="shortcut icon" href="" />
        <meta charset="utf-8" />
    <title>Elite Cafe</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <!-- ================== BEGIN BASE CSS STYLE ================== -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&subset=latin,latin-ext" rel="stylesheet">
        <link href="assets/plugins/jquery-ui-1.10.4/themes/base/minified/jquery-ui.min.css" rel="stylesheet" />
        <link href="assets/plugins/bootstrap-3.2.0/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/plugins/font-awesome-4.2.0/css/font-awesome.min.css" rel="stylesheet" />
        <link href="assets/css/animate.min.css" rel="stylesheet" />
        <link href="assets/css/style.min.css" rel="stylesheet" />
        <link href="assets/css/style-responsive.min.css" rel="stylesheet" />
        <link href="assets/css/theme/default.css" rel="stylesheet" id="theme" />
        <!-- ================== END BASE CSS STYLE ================== -->

        <script>
          
           
             function Goster2()
            {
               
                $('#Mesaj2').modal();
                
            }
            function Sil2()
            {
                var id = document.getElementById("btnSil2").value;
                var sifre = document.getElementById("txtGuvenlik").value;
           if(sifre=="admin"){
                $.post(
                        "allProductsDelete.jsp",
                        
                        function (data2) {
                            //alert("Response: " + data);
                            window.open("productList.jsp","_self");
                        }
                );
        }
            }
        </script>
    </head>
    <body>

    <div id="page-loader" class="fade in"><span class="spinner"></span></div>

    <div id="page-container" class="fade page-sidebar-fixed page-header-fixed">


        <%@include file="header.jsp"%>
        <div id="sidebar" class="sidebar">

            <div data-scrollbar="true" data-height="100%">

                <ul class="nav">
                    <li class="nav-profile">

                        <div class="info">
                            <%= session.getAttribute("kullaniciadi")%>
                            
                        </div>
                    </li>
                </ul>

                <!--MENÜ BURADA OLACAK....-->

                <%@include file="menu.jsp"%>

            </div>

        </div>
        <div class="sidebar-bg"></div>


        <div id="content" class="content">

            <div class="modal fade" id="Mesaj" role="dialog">
                 <div class="modal-dialog">

                    
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">SİL</h4>
                        </div>
                     <div class="modal-body">
                            <p>SİLMEK İSTEDİĞİNİZDEN EMİN MİSİNİZ ?.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-Success" onclick="Sil();">Evet</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Hayır</button>
                        </div>
                    </div>

                </div> 
            </div>
            <div class="modal fade" id="Mesaj2" role="dialog">
                 <div class="modal-dialog">

                    
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Tümünü SİL</h4>
                        </div>
                     <div class="modal-body">
                            <p>SİLMEK İSTEDİĞİNİZDEN EMİN MİSİNİZ ?.</p>
                        </div>
                        <div class="modal-footer">
                         <input type="password"  class="form-control" name="txtGuvenlikSifresi" id="txtGuvenlik" placeholder="Güvenlik Şifresini Giriniz!"/> 
                            <button type="button" class="btn btn-Success" onclick="Sil2();">Evet</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Hayır</button>
                        </div>
                    </div>

                </div> 
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading"> Tüm Ürünler</div>
                <div class="panel-body">

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>S.N</th>
                                <th>Ürün Adı</th>
                                 <th>Ürün Fiyatı</th>
                                
                                <th style="width:90px;"> <a type="button"class="btn btn-primary" href="productAdd.jsp"> EKLE </a> </th>
                                <th style="width:90px;"><button type="button" id="btnSil2" class="btn btn-danger" onclick="Goster2()"> TÜMÜNÜ SİL </button> </th>
                            </tr>
                        </thead>
                        <tbody>
                            
                        <form method = "POST">


                            <% ResultSet rs = Islemler.tblproduct_crd.TumKayitlar(); %>
                            <% int SiraNo = 1;
                                while (rs.next()) {%>
                            <tr>
                                <td><%= SiraNo%></td>
                                <td><%= rs.getString("ProductName")%></td>
                                <td><%= rs.getString("ProductPrice")%></td>
                                
                               
                                <td style="width:90px;"><a href="productEdit.jsp?id=<%= rs.getInt("pkProductID") %>" class="btn btn-success"> DÜZELT</a></td>
                                <td style="width:90px;"><a href="productDelete.jsp?id=<%= rs.getInt("pkProductID") %>" id="btnSil" class="btn btn-danger"  name="btnSil" >SİL</a></td>
                            </tr>
                            
                            <%  SiraNo++;
                                }%>
                        </form>
                     
                        </tbody>
                    </table>

                </div>                
            </div>

        </div>

        <a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>

    </div>


    <!-- ================== BEGIN BASE JS ================== -->
    <script src="assets/plugins/jquery-1.8.2/jquery-1.8.2.min.js"></script>
    <script src="assets/plugins/jquery-ui-1.10.4/ui/minified/jquery-ui.min.js"></script>
    <script src="assets/plugins/bootstrap-3.2.0/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
            <script src="assets/crossbrowserjs/html5shiv.js"></script>
            <script src="assets/crossbrowserjs/respond.min.js"></script>
            <script src="assets/crossbrowserjs/excanvas.min.js"></script>
    <![endif]-->
    <script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="assets/plugins/jquery-cookie/jquery.cookie.js"></script>
    <!-- ================== END BASE JS ================== -->

    <!-- ================== BEGIN PAGE LEVEL JS ================== -->
    <script src="assets/js/apps.min.js"></script>
    <!-- ================== END PAGE LEVEL JS ================== -->
    <script>
                                    $(document).ready(function () {
                                        App.init();
                                    });
    </script>
</body>
</html>