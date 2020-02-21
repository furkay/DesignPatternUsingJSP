<%@page import="Tablolar.tblproduct"%>
<%@page import="Tablolar.tblusers"%>
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
           <link rel="shortcut icon" href="Images/gdg.png" />
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
        <link href="css/style.css" rel="stylesheet"/>
        <!-- ================== END BASE CSS STYLE ================== -->
    </head>
    <body>


    <script>
        function myFunction() {
            // Get the snackbar DIV
            var x = document.getElementById("snackbar");
            // Add the "show" class to DIV
            x.className = "show";
            // After 3 seconds, remove the show class from DIV
            setTimeout(function () {
                x.className = x.className.replace("show", "");
            }, 3000);
        }
    </script>


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

            <div class="panel panel-primary">

                <div class="panel-heading"> Yeni Ürün</div>
                <div class="panel-body">
                    <form method="post" class="form-horizontal">

                        <div class="form-group">

                            <div class="col-sm-12">

                                <label class="col-md-3 control-label"style="margin-top:15px;"> Ürün Adı</label>
                                <div class="col-md-9">
                                    <input type="text" name="txtProductName" class="form-control" required  style="margin-top:15px;" autofocus/>
                                </div>
                                  <label class="col-md-3 control-label"style="margin-top:15px;"> Ürün Fiyatı</label>
                                <div class="col-md-9">
                                    <input type="text" name="txtProductPrice" class="form-control" required  style="margin-top:15px;" autofocus/>
                                </div>
                                  <label class="col-md-3 control-label"style="margin-top:15px;"></label>
                                  <div class="col-md-9" style="margin-top: 15px;">
                            
                                    <select name="thelist" class="btn btn-success" >
                                      <option>Yemek</option>
                                      <option value="atistirmalik">Atıştırmalık</option>
                                       <option value="icecek">İçecek</option>
                                      <option value="tatli">Tatlı</option>
                                    </select> 

                                </div>
                                <div class="col-md-12 text-right">
                                <button type="submit" name="btnKaydet" class="btn btn-success" onclick="myFunction()" style="width:150px; margin-top:15px; ">KAYDET</button>

                                </div>
                            </div>

                        </div>     
                        <div class="form-group">

                            <div class="col-md-6" style="text-align:center;">


                            </div>
                            <div class="col-md-6" style="text-align:center;">

                               
                            </div>
                        </div>  
                   </div> 
            </div>     



            <%  request.setCharacterEncoding("utf-8");
                if (request.getParameter("btnKaydet") != null) {
                        
                    String ProductName = request.getParameter("txtProductName");
                    String ProductPrice = request.getParameter("txtProductPrice");
                    String ProductType = request.getParameter("thelist");
                   
                       
                    Tablolar.tblproduct nesne = new tblproduct();
                    nesne.setProductName(ProductName);
                    nesne.setProductPrice(ProductPrice);
                    nesne.setProductType(ProductType);
                    Islemler.tblproduct_crd.Kaydet(nesne);
                 response.sendRedirect("productAdd.jsp");
                
     }
            if (request.getParameter("btnList") != null) {
                   response.sendRedirect("productList.jsp");
              }
               
            %>



            </form>
             
            <form>
                <div style="text-align:right;">
                  <button type="submit" name="btnList" class="btn btn-danger" >Ürünleri Listele</button>
                </div>
            </form>
        </div>

    </div>

</div>

<a href="javascript:;" class="btn btn-icon btn-circle btn-success btn-scroll-to-top fade" data-click="scroll-top"><i class="fa fa-angle-up"></i></a>
<div id="snackbar">Başarıyla Kaydedildi...</div>

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