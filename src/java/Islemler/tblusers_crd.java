 /* Yusuf AKG�L   19 Ocak 2020 Pazar  21:42:39  */

package Islemler;
import Tablolar.tblusers;
import java.sql.*;

import java.util.*;
import models.DbCon;

    public class tblusers_crd
           {

                              public static String Kaydet(tblusers nesne) {

                                    String Mesaj = null;
                                    try {

                                        Connection conn =DbCon.getInstance().getConnection();
                                        String sql="insert into tblusers(UserName,Password,Level) values(?,?,?)";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setString(1,nesne.getUserName());
                                        par.setString(2,nesne.getPassword());
                                        par.setString(3,nesne.getLevel());
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

                              public static String Duzelt(tblusers nesne) {

                                    String Mesaj = null;
                                    try {

                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="update tblusers set UserName=?,Password=?,Level=? where pkUserID=?";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setString(1,nesne.getUserName());
                                        par.setString(2,nesne.getPassword());
                                        par.setString(3,nesne.getLevel());
                                        par.setInt(4,nesne.getpkUserID());
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

                              public static String Sil(int pkUserID) {

                                    String Mesaj = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="delete from tblusers where pkUserID=?";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setInt(1,pkUserID);
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
                                        String SQL="select * from tblusers order by pkUserID DESC";
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
                                        String SQL="select pkUserID from tblusers order by pkUserID DESC limit 1";
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next())
                                             {
                                                id = kayitlar.getInt("pkUserID");
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

                              public static ResultSet idyeGoreKayitRsGetir(int pkUserID) {

                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblusers where  pkUserID="+pkUserID;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         kayitlar =null;
                                         }
                                         return kayitlar;

                                     }

                              public static tblusers idyeGoreKayitObjeGetir(int pkUserID) {

                                    tblusers kisi = new tblusers();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblusers where  pkUserID="+pkUserID;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkUserID(kayitlar.getInt("pkUserID"));
                                        kisi.setUserName(kayitlar.getString("UserName"));
                                        kisi.setPassword(kayitlar.getString("Password"));
                                        kisi.setLevel(kayitlar.getString("Level"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }

                               public static tblusers ismeGoreKayitObjeGetir(String userName) {

                                    tblusers kisi = new tblusers();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblusers where  UserName="+userName;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkUserID(kayitlar.getInt("pkUserID"));
                                        kisi.setUserName(kayitlar.getString("UserName"));
                                        kisi.setPassword(kayitlar.getString("Password"));
                                        kisi.setLevel(kayitlar.getString("Level"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }
                              public static tblusers SorguObjeGetir(String SQL) {

                                    tblusers kisi = new tblusers();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkUserID(kayitlar.getInt("pkUserID"));
                                        kisi.setUserName(kayitlar.getString("UserName"));
                                        kisi.setPassword(kayitlar.getString("Password"));
                                        kisi.setLevel(kayitlar.getString("Level"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }

                              public static List<tblusers> ListTumKayitlar() {

                                    List<tblusers> liste = new ArrayList();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblusers order by pkUserID DESC";
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                         tblusers kisi = new tblusers();
                                       kisi.setpkUserID(kayitlar.getInt("pkUserID"));
                                       kisi.setUserName(kayitlar.getString("UserName"));
                                       kisi.setPassword(kayitlar.getString("Password"));
                                       kisi.setLevel(kayitlar.getString("Level"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }

                              public static List<tblusers> ListSorguKayitlar(String SQL) {

                                    List<tblusers> liste = new ArrayList();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                         tblusers kisi = new tblusers();
                                       kisi.setpkUserID(kayitlar.getInt("pkUserID"));
                                       kisi.setUserName(kayitlar.getString("UserName"));
                                       kisi.setPassword(kayitlar.getString("Password"));
                                       kisi.setLevel(kayitlar.getString("Level"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }

                              public static List<tblusers> RsToList(ResultSet kayitlar) {

                                    List<tblusers> liste = new ArrayList();
                                    try {
                                        while (kayitlar.next()) {
                                         tblusers kisi = new tblusers();
                                       kisi.setpkUserID(kayitlar.getInt("pkUserID"));
                                       kisi.setUserName(kayitlar.getString("UserName"));
                                       kisi.setPassword(kayitlar.getString("Password"));
                                       kisi.setLevel(kayitlar.getString("Level"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }



            }
