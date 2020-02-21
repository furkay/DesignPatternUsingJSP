
package Islemler;
import java.sql.*;
import Tablolar.*;
import java.util.*;
import models.DbCon;

    public class tblcampaign_crd
           {

                              public static String Kaydet(tblcampaign nesne) {

                                    String Mesaj = null;
                                    try {

                                        Connection conn =DbCon.getInstance().getConnection();
                                        String sql="insert into tblcampaign(MenuName,Meal,Drink,Dessert,MenuCurrency) values(?,?,?,?,?)";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setString(1,nesne.getMenuName());
                                        par.setString(2,nesne.getMeal());
                                        par.setString(3,nesne.getDrink());
                                        par.setString(4,nesne.getDessert());
                                        par.setString(5,nesne.getMenuCurrency());
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

                              public static String Duzelt(tblcampaign nesne) {

                                    String Mesaj = null;
                                    try {

                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="update tblcampaign set MenuName=?,Meal=?,Drink=?,Dessert=?,MenuCurrency=? where pkCampaignID=?";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setString(1,nesne.getMenuName());
                                        par.setString(2,nesne.getMeal());
                                        par.setString(3,nesne.getDrink());
                                        par.setString(4,nesne.getDessert());
                                        par.setString(5,nesne.getMenuCurrency());
                                        par.setInt(6,nesne.getpkCampaignID());
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

                              public static String Sil(int pkCampaignID) {

                                    String Mesaj = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String sql="delete from tblcampaign where pkCampaignID=?";
                                        PreparedStatement par;
                                        par = conn.prepareStatement(sql);
                                        par.setInt(1,pkCampaignID);
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
                                        String SQL="select * from tblcampaign order by pkCampaignID DESC";
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
                                        String SQL="select pkCampaignID from tblcampaign order by pkCampaignID DESC limit 1";
                                        Connection conn =DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next())
                                             {
                                                id = kayitlar.getInt("pkCampaignID");
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

                              public static ResultSet idyeGoreKayitRsGetir(int pkCampaignID) {

                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblcampaign where  pkCampaignID="+pkCampaignID;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         kayitlar =null;
                                         }
                                         return kayitlar;

                                     }

                              public static tblcampaign idyeGoreKayitObjeGetir(int pkCampaignID) {

                                    tblcampaign kisi = new tblcampaign();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        String SQL="select * from tblcampaign where  pkCampaignID="+pkCampaignID;
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkCampaignID(kayitlar.getInt("pkCampaignID"));
                                        kisi.setMenuName(kayitlar.getString("MenuName"));
                                        kisi.setMeal(kayitlar.getString("Meal"));
                                        kisi.setDrink(kayitlar.getString("Drink"));
                                        kisi.setDessert(kayitlar.getString("Dessert"));
                                        kisi.setMenuCurrency(kayitlar.getString("MenuCurrency"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }

                              public static tblcampaign SorguObjeGetir(String SQL) {

                                    tblcampaign kisi = new tblcampaign();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn =DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                        kisi.setpkCampaignID(kayitlar.getInt("pkCampaignID"));
                                        kisi.setMenuName(kayitlar.getString("MenuName"));
                                        kisi.setMeal(kayitlar.getString("Meal"));
                                        kisi.setDrink(kayitlar.getString("Drink"));
                                        kisi.setDessert(kayitlar.getString("Dessert"));
                                        kisi.setMenuCurrency(kayitlar.getString("MenuCurrency"));
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return kisi;

                                     }

                              public static List<tblcampaign> ListTumKayitlar() {

                                    List<tblcampaign> liste = new ArrayList();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn =DbCon.getInstance().getConnection();
                                        String SQL="select * from tblcampaign order by pkCampaignID DESC";
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                         tblcampaign kisi = new tblcampaign();
                                       kisi.setpkCampaignID(kayitlar.getInt("pkCampaignID"));
                                       kisi.setMenuName(kayitlar.getString("MenuName"));
                                       kisi.setMeal(kayitlar.getString("Meal"));
                                       kisi.setDrink(kayitlar.getString("Drink"));
                                       kisi.setDessert(kayitlar.getString("Dessert"));
                                       kisi.setMenuCurrency(kayitlar.getString("MenuCurrency"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }

                              public static List<tblcampaign> ListSorguKayitlar(String SQL) {

                                    List<tblcampaign> liste = new ArrayList();
                                    ResultSet kayitlar = null;
                                    try {
                                        Connection conn = DbCon.getInstance().getConnection();
                                        Statement komut = conn.createStatement();
                                        kayitlar = komut.executeQuery(SQL);
                                        while (kayitlar.next()) {
                                         tblcampaign kisi = new tblcampaign();
                                       kisi.setpkCampaignID(kayitlar.getInt("pkCampaignID"));
                                       kisi.setMenuName(kayitlar.getString("MenuName"));
                                       kisi.setMeal(kayitlar.getString("Meal"));
                                       kisi.setDrink(kayitlar.getString("Drink"));
                                       kisi.setDessert(kayitlar.getString("Dessert"));
                                       kisi.setMenuCurrency(kayitlar.getString("MenuCurrency"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }

                              public static List<tblcampaign> RsToList(ResultSet kayitlar) {

                                    List<tblcampaign> liste = new ArrayList();
                                    try {
                                        while (kayitlar.next()) {
                                         tblcampaign kisi = new tblcampaign();
                                       kisi.setpkCampaignID(kayitlar.getInt("pkCampaignID"));
                                       kisi.setMenuName(kayitlar.getString("MenuName"));
                                       kisi.setMeal(kayitlar.getString("Meal"));
                                       kisi.setDrink(kayitlar.getString("Drink"));
                                       kisi.setDessert(kayitlar.getString("Dessert"));
                                       kisi.setMenuCurrency(kayitlar.getString("MenuCurrency"));
                                        liste.add(kisi);
                                                      }
                                              
                                         }
                                    catch (SQLException hata) {
                                         System.out.println(hata.getMessage());
                                         }
                                         return liste;

                                     }



            }
