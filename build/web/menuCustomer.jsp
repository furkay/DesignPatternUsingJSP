<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="nav">
    <li class="nav-header">Menü</li>
    <li><a href="customer.jsp"><i class="fa fa-home"></i> <span>Ana Sayfa</span></a></li>
   
    <li class="has-sub">
        <a href="javascript:;">
            <b class="caret pull-right" ></b>
            <i class="fa fa-laptop"></i>
            <span>Ürün İşlemleri</span>
        </a>
        <ul class="sub-menu">
             <li><a href="productSell.jsp">Satış</a></li>
         </ul>
    </li>
  
 
   <li><a href="index.jsp?q=1"><i class="fa fa-times-circle"></i> <span>Güvenli Çıkış</span></a></li>

    <!-- begin sidebar minify button -->
    <li><a href="javascript:;" class="sidebar-minify-btn" data-click="sidebar-minify"><i class="fa fa-angle-double-left"></i></a></li>
    <!-- end sidebar minify button -->
</ul>