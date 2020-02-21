
package Islemler;
import Tablolar.tblproduct;
import java.sql.*;

import java.util.*;
import models.DbCon;

    public class tblproduct_crd
           {
        
        
        
        
                             public static String TumunuSil() {

                                    String Mesaj = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="delete from tblproduct";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        
                                        par.execute();
                                        Mesaj="1";

                                        conn.close();

                                        Mesaj="1";

                                         }

                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         Mesaj ="0";
                                     }

                                    return Mesaj;

                                     }

                          
                              public static String Kaydet(tblproduct nesne) {

                                    String Mesaj = null;
                                    try {

                                        Connection conn =DbCon.getInstance().getConnection();
                                        String sql="insert into tblproduct(ProductName,ProductPrice,ProductType) values(?,?,?)";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setString(1,nesne.getProductName());
                                        par.setString(2,nesne.getProductPrice());
                                        par.setString(3,nesne.getProductType());
                                        par.execute();
                                        conn.close();

                                        Mesaj="1";

                                         }

                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         Mesaj ="0";
                                     }

                                    return Mesaj;

                                     }

                              public static String Duzelt(tblproduct nesne) {

                                    String Mesaj = null;
                                    try {

                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="update tblproduct set ProductName=?,ProductPrice=?,ProductType=? where pkProductID=?";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setString(1,nesne.getProductName());
                                        par.setString(2,nesne.getProductPrice());
                                        par.setString(3,nesne.getProductType());
                                        par.setInt(4,nesne.getpkProductID());
                                        par.execute();
                                        conn.close();

                                        Mesaj="1";

                                         }

                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         Mesaj ="0";
                                     }

                                    return Mesaj;

                                     }

                              public static String Sil(int pkProductID) {

                                    String Mesaj = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="delete from tblproduct where pkProductID=?";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setInt(1,pkProductID);
                                        par.execute();
                                        Mesaj="1";

                                        conn.close();

                                        Mesaj="1";

                                         }

                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         Mesaj ="0";
                                     }

                                    return Mesaj;

                                     }

                              public static ResultSet TumKayitlar() {

                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn =DbCon.getInstance().getConnection();
                                        String SQL="select * from tblproduct order by pkProductID DESC";
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                     }

                                    return kayitlar;

                                     }

                              public static int SorguKayitSayi(String SQL) {

                                    int KayitSayi =0;
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn =DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                         while(kayitlar.next()){KayitSayi++;}
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                     }

                                    return KayitSayi;

                                     }

                              public static int ToplamKayitSayisi() throws SQLException {

                                        int KayitSayi =0;
                                        ResultSet gelen=TumKayitlar();
                                         while(gelen.next()){KayitSayi++;}
                                        return KayitSayi;

                                     }

                              public static int RsKayitSayisi(ResultSet rs) throws SQLException {

                                        int KayitSayi =0;
                                         while(rs.next()){KayitSayi++;}
                                          rs.beforeFirst();
                                        return KayitSayi;

                                     }

                              public static int SonKayitID() {

                                    int id = -1;
                                    ResultSet kayitlar = null;
                                    try {
                                        String SQL="select pkProductID from tblproduct order by pkProductID DESC limit 1";
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next())
                                             {
                                                id = kayitlar.getInt("pkProductID");
                                             }
                                        conn.close();

                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                     }

                                    return id;

                                     }

                              public static ResultSet VeriKumesi(String SQL) {


                                    String Mesaj = null;
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn =DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                         }
                                    catch (SQLException e) {kayitlar =null;}return kayitlar;

                                     }

                              public static String KomutIslet(String SQL) {

                                    String Mesaj = null;
                                    try {
                                        Connection conn =DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        int s=komut.executeUpdate(SQL);
                                        Mesaj = String.valueOf(s);
                                        conn.close();
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         Mesaj="0";                                     }

                                    return Mesaj;

                                     }

                              public static ResultSet idyeGoreKayitRsGetir(int pkProductID) {

                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblproduct where  pkProductID="+pkProductID;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         kayitlar =null;
                                         }
                                         return kayitlar;

                                     }

                              public static tblproduct idyeGoreKayitObjeGetir(int pkProductID) {

                                    tblproduct kisi = new tblproduct();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblproduct where  pkProductID="+pkProductID;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkProductID(kayitlar.getInt("pkProductID"));
                                        kisi.setProductName(kayitlar.getString("ProductName"));
                                        kisi.setProductPrice(kayitlar.getString("ProductPrice"));
                                        kisi.setProductType(kayitlar.getString("ProductType"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }

                              public static tblproduct SorguObjeGetir(String SQL) {

                                    tblproduct kisi = new tblproduct();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkProductID(kayitlar.getInt("pkProductID"));
                                        kisi.setProductName(kayitlar.getString("ProductName"));
                                        kisi.setProductPrice(kayitlar.getString("ProductPrice"));
                                        kisi.setProductType(kayitlar.getString("ProductType"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }

                              public static List<tblproduct> ListTumKayitlar() {

                                    List<tblproduct> liste = new ArrayList();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblproduct order by pkProductID DESC";
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                         tblproduct kisi = new tblproduct();
                                       kisi.setpkProductID(kayitlar.getInt("pkProductID"));
                                       kisi.setProductName(kayitlar.getString("ProductName"));
                                       kisi.setProductPrice(kayitlar.getString("ProductPrice"));
                                       kisi.setProductType(kayitlar.getString("ProductType"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }

                              public static List<tblproduct> ListSorguKayitlar(String SQL) {

                                    List<tblproduct> liste = new ArrayList();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                         tblproduct kisi = new tblproduct();
                                       kisi.setpkProductID(kayitlar.getInt("pkProductID"));
                                       kisi.setProductName(kayitlar.getString("ProductName"));
                                       kisi.setProductPrice(kayitlar.getString("ProductPrice"));
                                       kisi.setProductType(kayitlar.getString("ProductType"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }

                              public static List<tblproduct> RsToList(ResultSet kayitlar) {

                                    List<tblproduct> liste = new ArrayList();
                                    try {
                                        while (kayitlar.next()) {
                                         tblproduct kisi = new tblproduct();
                                       kisi.setpkProductID(kayitlar.getInt("pkProductID"));
                                       kisi.setProductName(kayitlar.getString("ProductName"));
                                       kisi.setProductPrice(kayitlar.getString("ProductPrice"));
                                       kisi.setProductType(kayitlar.getString("ProductType"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }


            }
