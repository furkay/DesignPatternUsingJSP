
<%@page import="Tablolar.tblcampaign"%>
<%@page import="models.Menu"%>
<%@page import="models.Meal"%>
<%@page import="models.Dessert"%>
<%@page import="java.util.Map"%>
<%@page import="models.Drink"%>
<%@page import="Islemler.tblproduct_crd"%>
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

                <div class="panel-heading"> Yeni Kampanya</div>
                <div class="panel-body">
                    <form method="post" class="form-horizontal">

                        <div class="form-group">

                            <div class="col-sm-12">



                                <label class="col-md-3 control-label"style="margin-top:15px;"> Menü Adı</label>
                                <div class="col-md-9">
                                    <input type="text" name="txtMenuName" class="form-control" required  style="margin-top:15px;" autofocus/>
                                </div>



                                <label class="col-md-3 control-label"style="margin-top:15px;"> Yemek Seç</label>

                                <div class="col-md-9" style="margin-top: 15px;">

                                    <select name="yemekList" class="btn btn-success" >
                                        <% ResultSet rs = tblproduct_crd.TumKayitlar();
                                            while (rs.next()) {
                                                //  out.print(rs.getString("ProductType"));
                                                if (rs.getString("ProductType").equals("Yemek")) {
                                                    // out.print(rs.getString("ProductName"));
%>

                                        <option  value="<%=rs.getInt("pkProductID")%>"><%=rs.getString("ProductName")%></option>
                                        <% }
                                            } %>

                                    </select> 

                                </div>
                                <label class="col-md-3 control-label"style="margin-top:15px;"> İçecek Seç</label>

                                <div class="col-md-9" style="margin-top: 15px;">

                                    <select name="icecekList" class="btn btn-success" >

                                        <%

                                            ResultSet rs2 = tblproduct_crd.TumKayitlar();
                                            while (rs2.next()) {
                                                if (rs2.getString("ProductType").equals("icecek")) {
                                        %>

                                        <option value="<%=rs2.getInt("pkProductID")%>"><%=rs2.getString("ProductName")%></option>


                                        <% }
                                            } %>

                                    </select> 

                                </div>

                                <label class="col-md-3 control-label"style="margin-top:15px;"> Tatlı Seç</label>

                                <div class="col-md-9" style="margin-top: 15px;">

                                    <select name="tatliList" class="btn btn-success" >
                                        <option  value="yok">yok</option>
                                        <%
                                            ResultSet rs3 = tblproduct_crd.TumKayitlar();

                                            while (rs3.next()) {
                                                if (rs3.getString("ProductType").equals("tatli")) {
                                        %>

                                        <option  value="<%=rs3.getInt("pkProductID")%>"><%=rs3.getString("ProductName")%></option>
                                        <% }
                                            } %>

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
                    String drinkID = request.getParameter("icecekList");
                    String mealID = request.getParameter("yemekList");
                    String dessertID = request.getParameter("tatliList");
                    String menuName = request.getParameter("txtMenuName");

                    tblproduct drink = tblproduct_crd.idyeGoreKayitObjeGetir(Integer.parseInt(drinkID));
                    tblproduct meal = tblproduct_crd.idyeGoreKayitObjeGetir(Integer.parseInt(mealID));

                    Drink drinkObject = new Drink();
                    drinkObject.setProductName(drink.getProductName());
                    drinkObject.setProductPrice(drink.getProductPrice());
                    drinkObject.setProductType(drink.getProductType());

                    Meal mealObject = new Meal();
                    mealObject.setProductName(meal.getProductName());
                    mealObject.setProductPrice(meal.getProductPrice());
                    mealObject.setProductType(meal.getProductType());

                    Menu menu;
                    if (dessertID.equals("yok")) {
                        menu = new Menu.Builder().meal(mealObject).drink(drinkObject).build();
                    } else {
                        tblproduct dessert = tblproduct_crd.idyeGoreKayitObjeGetir(Integer.parseInt(dessertID));
                        Dessert dessertObject = new Dessert();
                        dessertObject.setProductName(dessert.getProductName());
                        dessertObject.setProductPrice(dessert.getProductPrice());
                        dessertObject.setProductType(dessert.getProductType());
                        menu = new Menu.Builder().dessert(dessertObject).meal(mealObject).drink(drinkObject).build();
                    }
                    Tablolar.tblcampaign nesne = new tblcampaign();
                    if (!dessertID.equals("yok")) {
                        nesne.setDessert(menu.getDessert().getProductName());
                    }
                    nesne.setDrink(menu.getDrink().getProductName());
                    nesne.setMeal(menu.getMeal().getProductName());
                    int totalString = Integer.parseInt(menu.getDrink().getProductPrice())
                            + Integer.parseInt(menu.getMeal().getProductPrice());
                    String total = Integer.toString(totalString);
                    nesne.setMenuCurrency(total);
                    nesne.setMenuName(menuName);
                    Islemler.tblcampaign_crd.Kaydet(nesne);
                }
                if (request.getParameter("btnKaydet") != null) {
                    response.sendRedirect("yonetim.jsp");
                }%>



            </form>

            <form>
                <div style="text-align:right;">
                    <a href="campaignList.jsp" name="btnList" class="btn btn-danger"    >Kampanya Listele</a>
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