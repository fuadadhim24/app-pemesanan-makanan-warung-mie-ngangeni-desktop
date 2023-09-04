/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.Timer;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fuada
 */
public class AdminMenu extends javax.swing.JFrame {

    /**
     * Creates new form PenjualanAdmin
     */
    private void popupopen(){
        popupdisplaygambar.setVisible(true);
        popuptxtmenu.setVisible(true);
        popuptxtharga.setVisible(true);
        popuptxtkategori.setVisible(true);
        popuptxtketersediaan.setVisible(true);
        popupinfomenu.setVisible(true);
        backpopup.setVisible(true);
    }
    private void popupclose(){
        popupdisplaygambar.setVisible(false);
        popuptxtmenu.setVisible(false);
        popuptxtharga.setVisible(false);
        popuptxtkategori.setVisible(false);
        popuptxtketersediaan.setVisible(false);
        popupinfomenu.setVisible(false);
        backpopup.setVisible(false);
    }
    private void tampilanbtnviewfalse(){
        btnview1.setVisible(false);
        btnview2.setVisible(false);
        btnview3.setVisible(false);
        btnview4.setVisible(false);
        btnview5.setVisible(false);
        btnview6.setVisible(false);
        btnview7.setVisible(false);
        btnview8.setVisible(false);
        btnview9.setVisible(false);
        btnview10.setVisible(false);
        btnview11.setVisible(false);
        btnview12.setVisible(false);
        btnview13.setVisible(false);
        btnview14.setVisible(false);
        btnview15.setVisible(false);
        btnview16.setVisible(false);
        btnview17.setVisible(false);
        btnview18.setVisible(false);
        btnview19.setVisible(false);
        btnview20.setVisible(false);
    }
    
    private void tampilanbtneditfalse(){
        btnedit1.setVisible(false);
        btnedit2.setVisible(false);
        btnedit3.setVisible(false);
        btnedit4.setVisible(false);
        btnedit5.setVisible(false);
        btnedit6.setVisible(false);
        btnedit7.setVisible(false);
        btnedit8.setVisible(false);
        btnedit9.setVisible(false);
        btnedit10.setVisible(false);
        btnedit11.setVisible(false);
        btnedit12.setVisible(false);
        btnedit13.setVisible(false);
        btnedit14.setVisible(false);
        btnedit15.setVisible(false);
        btnedit16.setVisible(false);
        btnedit17.setVisible(false);
        btnedit18.setVisible(false);
        btnedit19.setVisible(false);
        btnedit20.setVisible(false);
    }
    private void tampilanbtnhapusfalse(){
        btnhapus1.setVisible(false);
        btnhapus2.setVisible(false);
        btnhapus3.setVisible(false);
        btnhapus4.setVisible(false);
        btnhapus5.setVisible(false);
        btnhapus6.setVisible(false);
        btnhapus7.setVisible(false);
        btnhapus8.setVisible(false);
        btnhapus9.setVisible(false);
        btnhapus10.setVisible(false);
        btnhapus11.setVisible(false);
        btnhapus12.setVisible(false);
        btnhapus13.setVisible(false);
        btnhapus14.setVisible(false);
        btnhapus15.setVisible(false);
        btnhapus16.setVisible(false);
        btnhapus17.setVisible(false);
        btnhapus18.setVisible(false);
        btnhapus19.setVisible(false);
        btnhapus20.setVisible(false);
    }
    private void labelhelpedittutup(){
        backdisplaygambar.setVisible(false);
        inputharga.setVisible(false);
        inputmenu.setVisible(false);
        btnketersediaan.setFocusable(false);
        btnkategori.setFocusable(false);
        btnCancelInEdit.setVisible(false);
        btnEditIniEdit.setVisible(false);
        PopUpEdit.setVisible(false);
        submit.setVisible(true);
    }
    private void labelhelpeditbuka(){
        backdisplaygambar.setVisible(true);
        inputharga.setVisible(true);
        inputmenu.setVisible(true);
        btnketersediaan.setFocusable(true);
        btnkategori.setFocusable(true);
        btnCancelInEdit.setVisible(true);
        btnEditIniEdit.setVisible(true);
        PopUpEdit.setVisible(true);
        submit.setVisible(false);
    }
    private void tampilkandata() {
    try {
        String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack');";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        java.sql.ResultSet rs = pstm.executeQuery(sql);

        int numRows = 1;
        while (rs.next()) {
            numRows = rs.getRow();
        }
        for (int range = 20; range > numRows; range--) {
            switch (range) {
                case 1:
                    datamenu1.setVisible(false);
                    menu1.setVisible(false);
                    displaygambar1.setVisible(false);
                    btnedit1.setVisible(false);
                    btnview1.setVisible(false);
                    btnhapus1.setVisible(false);
                    break;
                case 2:
                    datamenu2.setVisible(false);
                    menu2.setVisible(false);
                    displaygambar2.setVisible(false);
                    btnedit2.setVisible(false);
                    btnview2.setVisible(false);
                    btnhapus2.setVisible(false);
                    break;
                case 3:
                    datamenu3.setVisible(false);
                    menu3.setVisible(false);
                    displaygambar3.setVisible(false);
                    btnedit3.setVisible(false);
                    btnview3.setVisible(false);
                    btnhapus3.setVisible(false);
                    break;
                case 4:
                    datamenu4.setVisible(false);
                    menu4.setVisible(false);
                    displaygambar4.setVisible(false);
                    btnedit4.setVisible(false);
                    btnview4.setVisible(false);
                    btnhapus4.setVisible(false);
                    break;
                case 5:
                    datamenu5.setVisible(false);
                    menu5.setVisible(false);
                    displaygambar5.setVisible(false);
                    btnedit5.setVisible(false);
                    btnview5.setVisible(false);
                    btnhapus5.setVisible(false);
                    break;
                case 6:
                    datamenu6.setVisible(false);
                    menu6.setVisible(false);
                    displaygambar6.setVisible(false);
                    btnview6.setVisible(false);
                    btnedit6.setVisible(false);
                    btnhapus6.setVisible(false);
                    break;
                case 7:
                    datamenu7.setVisible(false);
                    menu7.setVisible(false);
                    displaygambar7.setVisible(false);
                    btnedit7.setVisible(false);
                    btnview7.setVisible(false);
                    btnhapus7.setVisible(false);
                    break;
                case 8:
                    datamenu8.setVisible(false);
                    menu8.setVisible(false);
                    displaygambar8.setVisible(false);
                    btnedit8.setVisible(false);
                    btnview8.setVisible(false);
                    btnhapus8.setVisible(false);
                    break;
                case 9:
                    datamenu9.setVisible(false);
                    menu9.setVisible(false);
                    displaygambar9.setVisible(false);
                    btnedit9.setVisible(false);
                    btnview9.setVisible(false);
                    btnhapus9.setVisible(false);
                    break;
                case 10:
                    datamenu10.setVisible(false);
                    menu10.setVisible(false);
                    displaygambar10.setVisible(false);
                    btnedit10.setVisible(false);
                    btnview10.setVisible(false);
                    btnhapus10.setVisible(false);
                    break;
                case 11:
                    datamenu11.setVisible(false);
                    menu11.setVisible(false);
                    displaygambar11.setVisible(false);
                    btnview11.setVisible(false);
                    btnedit11.setVisible(false);
                    btnhapus11.setVisible(false);
                    break;
                case 12:
                    datamenu12.setVisible(false);
                    menu12.setVisible(false);
                    displaygambar12.setVisible(false);
                    btnview12.setVisible(false);
                    btnedit12.setVisible(false);
                    btnhapus12.setVisible(false);
                    break;
                case 13:
                    datamenu13.setVisible(false);
                    menu13.setVisible(false);
                    displaygambar13.setVisible(false);
                    btnedit13.setVisible(false);
                    btnhapus13.setVisible(false);
                    btnview13.setVisible(false);
                    break;
                case 14:
                    datamenu14.setVisible(false);
                    menu14.setVisible(false);
                    displaygambar14.setVisible(false);
                    btnedit14.setVisible(false);
                    btnview14.setVisible(false);
                    btnhapus14.setVisible(false);
                    break;
                case 15:
                    datamenu15.setVisible(false);
                    menu15.setVisible(false);
                    displaygambar15.setVisible(false);
                    btnview15.setVisible(false);
                    btnedit15.setVisible(false);
                    btnhapus15.setVisible(false);
                    break;
                case 16:
                    datamenu16.setVisible(false);
                    menu16.setVisible(false);
                    displaygambar16.setVisible(false);
                    btnview16.setVisible(false);
                    btnedit16.setVisible(false);
                    btnhapus16.setVisible(false);
                    break;
                case 17:
                    datamenu17.setVisible(false);
                    menu17.setVisible(false);
                    displaygambar17.setVisible(false);
                    btnview17.setVisible(false);
                    btnedit17.setVisible(false);
                    btnhapus17.setVisible(false);
                    break;
                case 18:
                    datamenu18.setVisible(false);
                    menu18.setVisible(false);
                    displaygambar18.setVisible(false);
                    btnview18.setVisible(false);
                    btnedit18.setVisible(false);
                    btnhapus18.setVisible(false);
                    break;
                case 19:
                    datamenu19.setVisible(false);
                    menu19.setVisible(false);
                    displaygambar19.setVisible(false);
                    btnview19.setVisible(false);
                    btnedit19.setVisible(false);
                    btnhapus19.setVisible(false);
                    break;
                case 20:
                    datamenu20.setVisible(false);
                    menu20.setVisible(false);
                    displaygambar20.setVisible(false);
                    btnview20.setVisible(false);
                    btnedit20.setVisible(false);
                    btnhapus20.setVisible(false);
                    break;
            }
        }
        rs.beforeFirst();
            for (int row = 1; row <= 20; row++) {
                if (rs.next()) {
                    String menu = rs.getString("nama_menu");
                    String harga = rs.getString("harga");
                    String kategoriNama = rs.getString("kategori_nama");
                    
                    Blob gambar = (Blob) rs.getBlob("path_gambar");
                    int ukuran = (int) gambar.length();
                    ImageIcon ic = new ImageIcon(gambar.getBytes(1, ukuran));
                    Image img = ic.getImage().getScaledInstance(103, 130, Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(img);
                    switch (row) {
                        case 1:
                            datamenu1.setVisible(true);
                            datamenu1.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu1.setVisible(true);
                            displaygambar1.setIcon(icon);
                            displaygambar1.setVisible(true);
                            btnview1.setVisible(true);
                            btnedit1.setVisible(true);
                            btnhapus1.setVisible(true);
                            break;
                        case 2:
                            datamenu2.setVisible(true);
                            datamenu2.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu2.setVisible(true);
                            displaygambar2.setIcon(icon);
                            displaygambar2.setVisible(true);
                            btnview2.setVisible(true);
                            btnedit2.setVisible(true);
                            btnhapus2.setVisible(true);
                            break;
                        case 3:
                            datamenu3.setVisible(true);
                            datamenu3.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu3.setVisible(true);
                            displaygambar3.setIcon(icon);
                            displaygambar3.setVisible(true);
                            btnview3.setVisible(true);
                            btnedit3.setVisible(true);
                            btnhapus3.setVisible(true);
                            break;
                        case 4:
                            datamenu4.setVisible(true);
                            datamenu4.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu4.setVisible(true);
                            displaygambar4.setIcon(icon);
                            displaygambar4.setVisible(true);
                            btnview4.setVisible(true);
                            btnedit4.setVisible(true);
                            btnhapus4.setVisible(true);
                            break;
                        case 5:
                            datamenu5.setVisible(true);
                            datamenu5.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu5.setVisible(true);
                            displaygambar5.setIcon(icon);
                            displaygambar5.setVisible(true);
                            btnview5.setVisible(true);
                            btnedit5.setVisible(true);
                            btnhapus5.setVisible(true);
                            break;
                        case 6:
                            datamenu6.setVisible(true);
                            datamenu6.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu6.setVisible(true);
                            displaygambar6.setIcon(icon);
                            displaygambar6.setVisible(true);
                            btnview6.setVisible(true);
                            btnedit6.setVisible(true);
                            btnhapus6.setVisible(true);
                            break;
                        case 7:
                            datamenu7.setVisible(true);
                            datamenu7.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu7.setVisible(true);
                            displaygambar7.setIcon(icon);
                            displaygambar7.setVisible(true);
                            btnview7.setVisible(true);
                            btnedit7.setVisible(true);
                            btnhapus7.setVisible(true);
                            break;
                        case 8:
                            datamenu8.setVisible(true);
                            datamenu8.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu8.setVisible(true);
                            displaygambar8.setIcon(icon);
                            displaygambar8.setVisible(true);
                            btnview8.setVisible(true);
                            btnedit8.setVisible(true);
                            btnhapus8.setVisible(true);
                            break;
                        case 9:
                            datamenu9.setVisible(true);
                            datamenu9.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu9.setVisible(true);
                            displaygambar9.setIcon(icon);
                            displaygambar9.setVisible(true);
                            btnview9.setVisible(true);
                            btnedit9.setVisible(true);
                            btnhapus9.setVisible(true);
                            break;
                        case 10:
                            datamenu10.setVisible(true);
                            datamenu10.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu10.setVisible(true);
                            displaygambar10.setIcon(icon);
                            displaygambar10.setVisible(true);
                            btnview10.setVisible(true);
                            btnedit10.setVisible(true);
                            btnhapus10.setVisible(true);
                            break;
                        case 11:
                            datamenu11.setVisible(true);
                            datamenu11.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu11.setVisible(true);
                            displaygambar11.setIcon(icon);
                            displaygambar11.setVisible(true);
                            btnview11.setVisible(true);
                            btnedit11.setVisible(true);
                            btnhapus11.setVisible(true);
                            break;
                        case 12:
                            datamenu12.setVisible(true);
                            datamenu12.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu12.setVisible(true);
                            displaygambar12.setIcon(icon);
                            displaygambar12.setVisible(true);
                            btnview12 .setVisible(true);
                            btnedit12.setVisible(true);
                            btnhapus12.setVisible(true);
                            break;
                        case 13:
                            datamenu13.setVisible(true);
                            datamenu13.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu13.setVisible(true);
                            displaygambar13.setIcon(icon);
                            displaygambar13.setVisible(true);
                            btnview13.setVisible(true);
                            btnedit13.setVisible(true);
                            btnhapus13.setVisible(true);
                            break;
                        case 14:
                            datamenu14.setVisible(true);
                            datamenu14.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu14.setVisible(true);
                            displaygambar14.setIcon(icon);
                            displaygambar14.setVisible(true);
                            btnview14.setVisible(true);
                            btnedit14.setVisible(true);
                            btnhapus14.setVisible(true);
                            break;
                        case 15:
                            datamenu15.setVisible(true);
                            datamenu15.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu15.setVisible(true);
                            displaygambar15.setIcon(icon);
                            displaygambar15.setVisible(true);
                            btnview15.setVisible(false);
                            btnedit15.setVisible(true);
                            btnhapus15.setVisible(true);
                            break;
                        case 16:
                            datamenu16.setVisible(true);
                            datamenu16.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu16.setVisible(true);
                            displaygambar16.setIcon(icon);
                            displaygambar16.setVisible(true);
                            btnview16.setVisible(false);
                            btnedit16.setVisible(true);
                            btnhapus16.setVisible(true);
                            break;
                        case 17:
                            datamenu17.setVisible(true);
                            datamenu17.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu17.setVisible(true);
                            displaygambar17.setIcon(icon);
                            displaygambar17.setVisible(true);
                            btnview17.setVisible(false);
                            btnedit17.setVisible(true);
                            btnhapus17.setVisible(true);
                            break;
                        case 18:
                            datamenu18.setVisible(true);
                            datamenu18.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu18.setVisible(true);
                            displaygambar18.setIcon(icon);
                            displaygambar18.setVisible(true);
                            btnview18.setVisible(false);
                            btnedit18.setVisible(true);
                            btnhapus18.setVisible(true);
                            break;
                        case 19:
                            datamenu19.setVisible(true);
                            datamenu19.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu19.setVisible(true);
                            displaygambar19.setIcon(icon);
                            displaygambar19.setVisible(true);
                            btnview19.setVisible(false);
                            btnedit19.setVisible(true);
                            btnhapus19.setVisible(true);
                            break;
                        case 20:
                            datamenu20.setVisible(true);
                            datamenu20.setText(kategoriNama + ": " + menu +": Rp."+harga);
                            menu20.setVisible(true);
                            displaygambar20.setIcon(icon);
                            displaygambar20.setVisible(true);
                            btnview20.setVisible(false);
                            btnedit20.setVisible(true);
                            btnhapus20.setVisible(true);
                            break;
                        default:
                            break;
                    }
                } else {
                    break;
                }
            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void kosongkanform(){
        
        inputmenu.setText("NAMA MENU");
        inputharga.setText("HARGA");
        btnkategori.setText("    KATEGORI");
        btnketersediaan.setText("    KETERSEDIAAN");
        displaygambar.setIcon(null);
        displaygambar.setVisible(false);
    }
    
    private void closepopupkategori(){
        btnkategori.setVisible(true);
        popupkategori.setVisible(false);
        btnclosekategori.setVisible(false);
        btnmakanan.setVisible(false);
        btnminuman.setVisible(false);
        btnpromosi.setVisible(false);
        btnsnack.setVisible(false);
    }
    
    private void closepopupketersediaan(){
        btntersedia.setVisible(false);
        btnkosong.setVisible(false);
        btncloseketersediaan.setVisible(false);
        popupketersediaan.setVisible(false);
        btnketersediaan.setVisible(true);
    }
    public AdminMenu() {
        initComponents();
        popupclose();
        labelhelpedittutup();
        tampilanbtneditfalse();
        tampilanbtnhapusfalse();
        tampilkandata();
        backdisplaygambar.setVisible(false);
        btnEditIniEdit.setVisible(false);
        btnCancelInEdit.setVisible(false);
        PopUpEdit.setVisible(false);
        closepopupkategori();
        closepopupketersediaan();
        popuptutup.setVisible(false);
        popuplabel.setVisible(false);
        inputmenu.setVisible(true);
        inputharga.setVisible(true);
        jPanel7.setVisible(false);    
        jPanel8.setVisible(false);    
        jPanel9.setVisible(false);    
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popuptxtketersediaan = new javax.swing.JLabel();
        popuptxtharga = new javax.swing.JLabel();
        popuptxtkategori = new javax.swing.JLabel();
        popuptxtmenu = new javax.swing.JLabel();
        popupcloseinfomenu = new javax.swing.JPanel();
        popuptutup = new javax.swing.JPanel();
        popupdisplaygambar = new javax.swing.JLabel();
        popupinfomenu = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        backpopup = new javax.swing.JPanel();
        popuplabel = new javax.swing.JLabel();
        popup = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        btnview20 = new javax.swing.JPanel();
        btnview19 = new javax.swing.JPanel();
        btnview18 = new javax.swing.JPanel();
        btnview17 = new javax.swing.JPanel();
        btnview16 = new javax.swing.JPanel();
        btnview15 = new javax.swing.JPanel();
        btnview14 = new javax.swing.JPanel();
        btnview13 = new javax.swing.JPanel();
        btnview12 = new javax.swing.JPanel();
        btnview11 = new javax.swing.JPanel();
        btnview10 = new javax.swing.JPanel();
        btnview9 = new javax.swing.JPanel();
        btnview8 = new javax.swing.JPanel();
        btnview7 = new javax.swing.JPanel();
        btnview6 = new javax.swing.JPanel();
        btnview5 = new javax.swing.JPanel();
        btnview4 = new javax.swing.JPanel();
        btnview3 = new javax.swing.JPanel();
        btnview2 = new javax.swing.JPanel();
        btnview1 = new javax.swing.JPanel();
        btnedit20 = new javax.swing.JPanel();
        btnedit19 = new javax.swing.JPanel();
        btnedit18 = new javax.swing.JPanel();
        btnedit17 = new javax.swing.JPanel();
        btnedit16 = new javax.swing.JPanel();
        btnedit15 = new javax.swing.JPanel();
        btnedit14 = new javax.swing.JPanel();
        btnedit13 = new javax.swing.JPanel();
        btnedit12 = new javax.swing.JPanel();
        btnedit11 = new javax.swing.JPanel();
        btnedit10 = new javax.swing.JPanel();
        btnedit9 = new javax.swing.JPanel();
        btnedit8 = new javax.swing.JPanel();
        btnedit7 = new javax.swing.JPanel();
        btnedit6 = new javax.swing.JPanel();
        btnedit5 = new javax.swing.JPanel();
        btnedit4 = new javax.swing.JPanel();
        btnedit3 = new javax.swing.JPanel();
        btnedit2 = new javax.swing.JPanel();
        btnedit1 = new javax.swing.JPanel();
        displaygambar2 = new javax.swing.JLabel();
        displaygambar3 = new javax.swing.JLabel();
        displaygambar4 = new javax.swing.JLabel();
        displaygambar5 = new javax.swing.JLabel();
        displaygambar6 = new javax.swing.JLabel();
        displaygambar7 = new javax.swing.JLabel();
        displaygambar8 = new javax.swing.JLabel();
        displaygambar9 = new javax.swing.JLabel();
        displaygambar10 = new javax.swing.JLabel();
        displaygambar11 = new javax.swing.JLabel();
        displaygambar12 = new javax.swing.JLabel();
        displaygambar13 = new javax.swing.JLabel();
        displaygambar14 = new javax.swing.JLabel();
        displaygambar15 = new javax.swing.JLabel();
        displaygambar16 = new javax.swing.JLabel();
        displaygambar17 = new javax.swing.JLabel();
        displaygambar18 = new javax.swing.JLabel();
        displaygambar19 = new javax.swing.JLabel();
        displaygambar20 = new javax.swing.JLabel();
        displaygambar1 = new javax.swing.JLabel();
        datamenu2 = new javax.swing.JLabel();
        datamenu3 = new javax.swing.JLabel();
        datamenu4 = new javax.swing.JLabel();
        datamenu5 = new javax.swing.JLabel();
        datamenu6 = new javax.swing.JLabel();
        datamenu7 = new javax.swing.JLabel();
        datamenu8 = new javax.swing.JLabel();
        datamenu9 = new javax.swing.JLabel();
        datamenu10 = new javax.swing.JLabel();
        datamenu11 = new javax.swing.JLabel();
        datamenu12 = new javax.swing.JLabel();
        datamenu13 = new javax.swing.JLabel();
        datamenu14 = new javax.swing.JLabel();
        datamenu15 = new javax.swing.JLabel();
        datamenu16 = new javax.swing.JLabel();
        datamenu17 = new javax.swing.JLabel();
        datamenu18 = new javax.swing.JLabel();
        datamenu19 = new javax.swing.JLabel();
        datamenu20 = new javax.swing.JLabel();
        datamenu1 = new javax.swing.JLabel();
        btnhapus20 = new javax.swing.JPanel();
        btnhapus19 = new javax.swing.JPanel();
        btnhapus18 = new javax.swing.JPanel();
        btnhapus17 = new javax.swing.JPanel();
        btnhapus16 = new javax.swing.JPanel();
        btnhapus15 = new javax.swing.JPanel();
        btnhapus14 = new javax.swing.JPanel();
        btnhapus13 = new javax.swing.JPanel();
        btnhapus12 = new javax.swing.JPanel();
        btnhapus11 = new javax.swing.JPanel();
        btnhapus10 = new javax.swing.JPanel();
        btnhapus9 = new javax.swing.JPanel();
        btnhapus8 = new javax.swing.JPanel();
        btnhapus7 = new javax.swing.JPanel();
        btnhapus6 = new javax.swing.JPanel();
        btnhapus5 = new javax.swing.JPanel();
        btnhapus4 = new javax.swing.JPanel();
        btnhapus3 = new javax.swing.JPanel();
        btnhapus2 = new javax.swing.JPanel();
        btnhapus1 = new javax.swing.JPanel();
        menu20 = new javax.swing.JLabel();
        menu19 = new javax.swing.JLabel();
        menu18 = new javax.swing.JLabel();
        menu17 = new javax.swing.JLabel();
        menu16 = new javax.swing.JLabel();
        menu15 = new javax.swing.JLabel();
        menu14 = new javax.swing.JLabel();
        menu13 = new javax.swing.JLabel();
        menu12 = new javax.swing.JLabel();
        menu11 = new javax.swing.JLabel();
        menu10 = new javax.swing.JLabel();
        menu9 = new javax.swing.JLabel();
        menu8 = new javax.swing.JLabel();
        menu7 = new javax.swing.JLabel();
        menu6 = new javax.swing.JLabel();
        menu5 = new javax.swing.JLabel();
        menu4 = new javax.swing.JLabel();
        menu3 = new javax.swing.JLabel();
        menu2 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        displaygambar = new javax.swing.JLabel();
        backdisplaygambar = new javax.swing.JPanel();
        pilihgambar = new javax.swing.JPanel();
        inputmenu = new javax.swing.JTextField();
        inputharga = new javax.swing.JTextField();
        btncloseketersediaan = new javax.swing.JPanel();
        btntersedia = new javax.swing.JPanel();
        btnkosong = new javax.swing.JPanel();
        popupketersediaan = new javax.swing.JLabel();
        btnmakanan = new javax.swing.JPanel();
        btnminuman = new javax.swing.JPanel();
        btnsnack = new javax.swing.JPanel();
        btnpromosi = new javax.swing.JPanel();
        btnclosekategori = new javax.swing.JPanel();
        popupkategori = new javax.swing.JLabel();
        btnketersediaan = new javax.swing.JLabel();
        btnkategori = new javax.swing.JLabel();
        btnEditIniEdit = new javax.swing.JPanel();
        btnCancelInEdit = new javax.swing.JPanel();
        PopUpEdit = new javax.swing.JLabel();
        submit = new javax.swing.JPanel();
        background = new javax.swing.JLabel();
        label_id_menu = new javax.swing.JLabel();
        gambarTextField = new javax.swing.JLabel();
        label_id_kategori = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popuptxtketersediaan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtketersediaan.setText("Username: fuadadhim24");
        getContentPane().add(popuptxtketersediaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, -1, -1));

        popuptxtharga.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtharga.setText("Harga: 351231293122");
        getContentPane().add(popuptxtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        popuptxtkategori.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtkategori.setText("No WA: 08784012931");
        getContentPane().add(popuptxtkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));

        popuptxtmenu.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtmenu.setText("Nama: Fuad Adhim Al Hasan");
        getContentPane().add(popuptxtmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, -1, -1));

        popupcloseinfomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popupcloseinfomenu.setOpaque(false);
        popupcloseinfomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popupcloseinfomenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout popupcloseinfomenuLayout = new javax.swing.GroupLayout(popupcloseinfomenu);
        popupcloseinfomenu.setLayout(popupcloseinfomenuLayout);
        popupcloseinfomenuLayout.setHorizontalGroup(
            popupcloseinfomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        popupcloseinfomenuLayout.setVerticalGroup(
            popupcloseinfomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(popupcloseinfomenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 240, 50, 40));

        popuptutup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popuptutup.setOpaque(false);
        popuptutup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popuptutupMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout popuptutupLayout = new javax.swing.GroupLayout(popuptutup);
        popuptutup.setLayout(popuptutupLayout);
        popuptutupLayout.setHorizontalGroup(
            popuptutupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        popuptutupLayout.setVerticalGroup(
            popuptutupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(popuptutup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));
        getContentPane().add(popupdisplaygambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 150, 200));

        popupinfomenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popup info menu.png"))); // NOI18N
        getContentPane().add(popupinfomenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -40, -1, -1));

        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.setOpaque(false);
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 170, 48));

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.setOpaque(false);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 220, 48));

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.setOpaque(false);
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 145, 220, 48));

        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.setOpaque(false);
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, 48));

        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.setOpaque(false);
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 288, 220, 48));

        backpopup.setOpaque(false);

        javax.swing.GroupLayout backpopupLayout = new javax.swing.GroupLayout(backpopup);
        backpopup.setLayout(backpopupLayout);
        backpopupLayout.setHorizontalGroup(
            backpopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        backpopupLayout.setVerticalGroup(
            backpopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        getContentPane().add(backpopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        popuplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popupmenu.png"))); // NOI18N
        getContentPane().add(popuplabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-460, -100, -1, -1));

        popup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.setOpaque(false);
        popup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popupMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout popupLayout = new javax.swing.GroupLayout(popup);
        popup.setLayout(popupLayout);
        popupLayout.setHorizontalGroup(
            popupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        popupLayout.setVerticalGroup(
            popupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(popup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        labelnama1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelnama1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelnama1.setToolTipText("");
        labelnama1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(labelnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 8, 670, 20));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnview20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview20.setOpaque(false);
        btnview20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview20Layout = new javax.swing.GroupLayout(btnview20);
        btnview20.setLayout(btnview20Layout);
        btnview20Layout.setHorizontalGroup(
            btnview20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview20Layout.setVerticalGroup(
            btnview20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview20, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 1370, 38, 39));

        btnview19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview19.setOpaque(false);
        btnview19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview19Layout = new javax.swing.GroupLayout(btnview19);
        btnview19.setLayout(btnview19Layout);
        btnview19Layout.setHorizontalGroup(
            btnview19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview19Layout.setVerticalGroup(
            btnview19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview19, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 1300, 38, 39));

        btnview18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview18.setOpaque(false);
        btnview18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview18Layout = new javax.swing.GroupLayout(btnview18);
        btnview18.setLayout(btnview18Layout);
        btnview18Layout.setHorizontalGroup(
            btnview18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview18Layout.setVerticalGroup(
            btnview18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview18, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 1230, 38, 39));

        btnview17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview17.setOpaque(false);
        btnview17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview17Layout = new javax.swing.GroupLayout(btnview17);
        btnview17.setLayout(btnview17Layout);
        btnview17Layout.setHorizontalGroup(
            btnview17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview17Layout.setVerticalGroup(
            btnview17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview17, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 1150, 38, 39));

        btnview16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview16.setOpaque(false);
        btnview16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview16Layout = new javax.swing.GroupLayout(btnview16);
        btnview16.setLayout(btnview16Layout);
        btnview16Layout.setHorizontalGroup(
            btnview16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview16Layout.setVerticalGroup(
            btnview16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview16, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 1080, 38, 39));

        btnview15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview15.setOpaque(false);
        btnview15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview15Layout = new javax.swing.GroupLayout(btnview15);
        btnview15.setLayout(btnview15Layout);
        btnview15Layout.setHorizontalGroup(
            btnview15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview15Layout.setVerticalGroup(
            btnview15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview15, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 1020, 38, 39));

        btnview14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview14.setOpaque(false);
        btnview14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview14Layout = new javax.swing.GroupLayout(btnview14);
        btnview14.setLayout(btnview14Layout);
        btnview14Layout.setHorizontalGroup(
            btnview14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview14Layout.setVerticalGroup(
            btnview14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview14, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 940, 38, 39));

        btnview13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview13.setOpaque(false);
        btnview13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview13Layout = new javax.swing.GroupLayout(btnview13);
        btnview13.setLayout(btnview13Layout);
        btnview13Layout.setHorizontalGroup(
            btnview13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview13Layout.setVerticalGroup(
            btnview13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview13, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 870, 38, 39));

        btnview12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview12.setOpaque(false);
        btnview12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview12Layout = new javax.swing.GroupLayout(btnview12);
        btnview12.setLayout(btnview12Layout);
        btnview12Layout.setHorizontalGroup(
            btnview12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview12Layout.setVerticalGroup(
            btnview12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview12, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 800, 38, 39));

        btnview11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview11.setOpaque(false);
        btnview11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview11Layout = new javax.swing.GroupLayout(btnview11);
        btnview11.setLayout(btnview11Layout);
        btnview11Layout.setHorizontalGroup(
            btnview11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview11Layout.setVerticalGroup(
            btnview11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview11, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 730, 38, 39));

        btnview10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview10.setOpaque(false);
        btnview10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview10Layout = new javax.swing.GroupLayout(btnview10);
        btnview10.setLayout(btnview10Layout);
        btnview10Layout.setHorizontalGroup(
            btnview10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview10Layout.setVerticalGroup(
            btnview10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview10, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 660, 38, 39));

        btnview9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview9.setOpaque(false);
        btnview9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview9Layout = new javax.swing.GroupLayout(btnview9);
        btnview9.setLayout(btnview9Layout);
        btnview9Layout.setHorizontalGroup(
            btnview9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview9Layout.setVerticalGroup(
            btnview9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview9, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 590, 38, 39));

        btnview8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview8.setOpaque(false);
        btnview8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview8Layout = new javax.swing.GroupLayout(btnview8);
        btnview8.setLayout(btnview8Layout);
        btnview8Layout.setHorizontalGroup(
            btnview8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview8Layout.setVerticalGroup(
            btnview8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview8, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 520, 38, 39));

        btnview7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview7.setOpaque(false);
        btnview7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview7Layout = new javax.swing.GroupLayout(btnview7);
        btnview7.setLayout(btnview7Layout);
        btnview7Layout.setHorizontalGroup(
            btnview7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview7Layout.setVerticalGroup(
            btnview7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview7, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 440, 38, 39));

        btnview6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview6.setOpaque(false);
        btnview6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview6Layout = new javax.swing.GroupLayout(btnview6);
        btnview6.setLayout(btnview6Layout);
        btnview6Layout.setHorizontalGroup(
            btnview6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview6Layout.setVerticalGroup(
            btnview6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview6, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 370, 38, 39));

        btnview5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview5.setOpaque(false);
        btnview5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview5Layout = new javax.swing.GroupLayout(btnview5);
        btnview5.setLayout(btnview5Layout);
        btnview5Layout.setHorizontalGroup(
            btnview5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview5Layout.setVerticalGroup(
            btnview5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview5, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 300, 38, 39));

        btnview4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview4.setOpaque(false);
        btnview4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview4Layout = new javax.swing.GroupLayout(btnview4);
        btnview4.setLayout(btnview4Layout);
        btnview4Layout.setHorizontalGroup(
            btnview4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview4Layout.setVerticalGroup(
            btnview4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview4, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 230, 38, 39));

        btnview3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview3.setOpaque(false);
        btnview3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview3Layout = new javax.swing.GroupLayout(btnview3);
        btnview3.setLayout(btnview3Layout);
        btnview3Layout.setHorizontalGroup(
            btnview3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview3Layout.setVerticalGroup(
            btnview3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview3, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 160, 38, 39));

        btnview2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview2.setOpaque(false);
        btnview2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview2Layout = new javax.swing.GroupLayout(btnview2);
        btnview2.setLayout(btnview2Layout);
        btnview2Layout.setHorizontalGroup(
            btnview2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview2Layout.setVerticalGroup(
            btnview2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview2, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 91, 38, 39));

        btnview1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnview1.setOpaque(false);
        btnview1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnview1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnview1Layout = new javax.swing.GroupLayout(btnview1);
        btnview1.setLayout(btnview1Layout);
        btnview1Layout.setHorizontalGroup(
            btnview1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnview1Layout.setVerticalGroup(
            btnview1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnview1, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 19, 38, 39));

        btnedit20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit20.setOpaque(false);
        btnedit20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit20Layout = new javax.swing.GroupLayout(btnedit20);
        btnedit20.setLayout(btnedit20Layout);
        btnedit20Layout.setHorizontalGroup(
            btnedit20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit20Layout.setVerticalGroup(
            btnedit20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit20, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 1370, 38, 39));

        btnedit19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit19.setOpaque(false);
        btnedit19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit19Layout = new javax.swing.GroupLayout(btnedit19);
        btnedit19.setLayout(btnedit19Layout);
        btnedit19Layout.setHorizontalGroup(
            btnedit19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit19Layout.setVerticalGroup(
            btnedit19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit19, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 1300, 38, 39));

        btnedit18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit18.setOpaque(false);
        btnedit18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit18Layout = new javax.swing.GroupLayout(btnedit18);
        btnedit18.setLayout(btnedit18Layout);
        btnedit18Layout.setHorizontalGroup(
            btnedit18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit18Layout.setVerticalGroup(
            btnedit18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit18, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 1230, 38, 39));

        btnedit17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit17.setOpaque(false);
        btnedit17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit17Layout = new javax.swing.GroupLayout(btnedit17);
        btnedit17.setLayout(btnedit17Layout);
        btnedit17Layout.setHorizontalGroup(
            btnedit17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit17Layout.setVerticalGroup(
            btnedit17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit17, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 1150, 38, 39));

        btnedit16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit16.setOpaque(false);
        btnedit16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit16Layout = new javax.swing.GroupLayout(btnedit16);
        btnedit16.setLayout(btnedit16Layout);
        btnedit16Layout.setHorizontalGroup(
            btnedit16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit16Layout.setVerticalGroup(
            btnedit16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit16, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 1080, 38, 39));

        btnedit15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit15.setOpaque(false);
        btnedit15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit15Layout = new javax.swing.GroupLayout(btnedit15);
        btnedit15.setLayout(btnedit15Layout);
        btnedit15Layout.setHorizontalGroup(
            btnedit15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit15Layout.setVerticalGroup(
            btnedit15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit15, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 1020, 38, 39));

        btnedit14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit14.setOpaque(false);
        btnedit14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit14Layout = new javax.swing.GroupLayout(btnedit14);
        btnedit14.setLayout(btnedit14Layout);
        btnedit14Layout.setHorizontalGroup(
            btnedit14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit14Layout.setVerticalGroup(
            btnedit14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit14, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 940, 38, 39));

        btnedit13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit13.setOpaque(false);
        btnedit13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit13Layout = new javax.swing.GroupLayout(btnedit13);
        btnedit13.setLayout(btnedit13Layout);
        btnedit13Layout.setHorizontalGroup(
            btnedit13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit13Layout.setVerticalGroup(
            btnedit13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit13, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 870, 38, 39));

        btnedit12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit12.setOpaque(false);
        btnedit12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit12Layout = new javax.swing.GroupLayout(btnedit12);
        btnedit12.setLayout(btnedit12Layout);
        btnedit12Layout.setHorizontalGroup(
            btnedit12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit12Layout.setVerticalGroup(
            btnedit12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit12, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 800, 38, 39));

        btnedit11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit11.setOpaque(false);
        btnedit11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit11Layout = new javax.swing.GroupLayout(btnedit11);
        btnedit11.setLayout(btnedit11Layout);
        btnedit11Layout.setHorizontalGroup(
            btnedit11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit11Layout.setVerticalGroup(
            btnedit11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 730, 38, 39));

        btnedit10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit10.setOpaque(false);
        btnedit10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit10Layout = new javax.swing.GroupLayout(btnedit10);
        btnedit10.setLayout(btnedit10Layout);
        btnedit10Layout.setHorizontalGroup(
            btnedit10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit10Layout.setVerticalGroup(
            btnedit10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 660, 38, 39));

        btnedit9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit9.setOpaque(false);
        btnedit9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit9Layout = new javax.swing.GroupLayout(btnedit9);
        btnedit9.setLayout(btnedit9Layout);
        btnedit9Layout.setHorizontalGroup(
            btnedit9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit9Layout.setVerticalGroup(
            btnedit9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 590, 38, 39));

        btnedit8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit8.setOpaque(false);
        btnedit8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit8Layout = new javax.swing.GroupLayout(btnedit8);
        btnedit8.setLayout(btnedit8Layout);
        btnedit8Layout.setHorizontalGroup(
            btnedit8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit8Layout.setVerticalGroup(
            btnedit8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 520, 38, 39));

        btnedit7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit7.setOpaque(false);
        btnedit7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit7Layout = new javax.swing.GroupLayout(btnedit7);
        btnedit7.setLayout(btnedit7Layout);
        btnedit7Layout.setHorizontalGroup(
            btnedit7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit7Layout.setVerticalGroup(
            btnedit7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 440, 38, 39));

        btnedit6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit6.setOpaque(false);
        btnedit6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit6Layout = new javax.swing.GroupLayout(btnedit6);
        btnedit6.setLayout(btnedit6Layout);
        btnedit6Layout.setHorizontalGroup(
            btnedit6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit6Layout.setVerticalGroup(
            btnedit6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 370, 38, 39));

        btnedit5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit5.setOpaque(false);
        btnedit5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit5Layout = new javax.swing.GroupLayout(btnedit5);
        btnedit5.setLayout(btnedit5Layout);
        btnedit5Layout.setHorizontalGroup(
            btnedit5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit5Layout.setVerticalGroup(
            btnedit5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 300, 38, 39));

        btnedit4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit4.setOpaque(false);
        btnedit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit4Layout = new javax.swing.GroupLayout(btnedit4);
        btnedit4.setLayout(btnedit4Layout);
        btnedit4Layout.setHorizontalGroup(
            btnedit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit4Layout.setVerticalGroup(
            btnedit4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 230, 38, 39));

        btnedit3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit3.setOpaque(false);
        btnedit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit3Layout = new javax.swing.GroupLayout(btnedit3);
        btnedit3.setLayout(btnedit3Layout);
        btnedit3Layout.setHorizontalGroup(
            btnedit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit3Layout.setVerticalGroup(
            btnedit3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 160, 38, 39));

        btnedit2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit2.setOpaque(false);
        btnedit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit2Layout = new javax.swing.GroupLayout(btnedit2);
        btnedit2.setLayout(btnedit2Layout);
        btnedit2Layout.setHorizontalGroup(
            btnedit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit2Layout.setVerticalGroup(
            btnedit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 91, 38, 39));

        btnedit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit1.setOpaque(false);
        btnedit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnedit1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnedit1Layout = new javax.swing.GroupLayout(btnedit1);
        btnedit1.setLayout(btnedit1Layout);
        btnedit1Layout.setHorizontalGroup(
            btnedit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnedit1Layout.setVerticalGroup(
            btnedit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnedit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 19, 38, 39));
        jPanel13.add(displaygambar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 103, 67));
        jPanel13.add(displaygambar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 144, 103, 67));
        jPanel13.add(displaygambar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 216, 103, 67));
        jPanel13.add(displaygambar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 286, 103, 67));
        jPanel13.add(displaygambar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 356, 103, 67));
        jPanel13.add(displaygambar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 428, 103, 67));
        jPanel13.add(displaygambar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 498, 103, 67));
        jPanel13.add(displaygambar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 103, 67));
        jPanel13.add(displaygambar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 103, 67));
        jPanel13.add(displaygambar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 712, 103, 67));
        jPanel13.add(displaygambar12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 782, 103, 67));
        jPanel13.add(displaygambar13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 854, 103, 67));
        jPanel13.add(displaygambar14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 926, 103, 67));
        jPanel13.add(displaygambar15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 996, 103, 67));
        jPanel13.add(displaygambar16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1066, 103, 67));
        jPanel13.add(displaygambar17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1138, 103, 67));
        jPanel13.add(displaygambar18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1208, 103, 67));
        jPanel13.add(displaygambar19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1280, 103, 67));
        jPanel13.add(displaygambar20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1350, 103, 67));
        jPanel13.add(displaygambar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 103, 67));

        datamenu2.setBackground(new java.awt.Color(255, 255, 255));
        datamenu2.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu2.setOpaque(true);
        jPanel13.add(datamenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 470, 40));

        datamenu3.setBackground(new java.awt.Color(255, 255, 255));
        datamenu3.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu3.setOpaque(true);
        jPanel13.add(datamenu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 161, 470, 40));

        datamenu4.setBackground(new java.awt.Color(255, 255, 255));
        datamenu4.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu4.setOpaque(true);
        jPanel13.add(datamenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 232, 470, 40));

        datamenu5.setBackground(new java.awt.Color(255, 255, 255));
        datamenu5.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu5.setOpaque(true);
        jPanel13.add(datamenu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 303, 470, 40));

        datamenu6.setBackground(new java.awt.Color(255, 255, 255));
        datamenu6.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu6.setOpaque(true);
        jPanel13.add(datamenu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 374, 470, 40));

        datamenu7.setBackground(new java.awt.Color(255, 255, 255));
        datamenu7.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu7.setOpaque(true);
        jPanel13.add(datamenu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 445, 470, 40));

        datamenu8.setBackground(new java.awt.Color(255, 255, 255));
        datamenu8.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu8.setOpaque(true);
        jPanel13.add(datamenu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 516, 470, 40));

        datamenu9.setBackground(new java.awt.Color(255, 255, 255));
        datamenu9.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu9.setOpaque(true);
        jPanel13.add(datamenu9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 587, 470, 40));

        datamenu10.setBackground(new java.awt.Color(255, 255, 255));
        datamenu10.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu10.setOpaque(true);
        jPanel13.add(datamenu10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 658, 470, 40));

        datamenu11.setBackground(new java.awt.Color(255, 255, 255));
        datamenu11.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu11.setOpaque(true);
        jPanel13.add(datamenu11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 729, 470, 40));

        datamenu12.setBackground(new java.awt.Color(255, 255, 255));
        datamenu12.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu12.setOpaque(true);
        jPanel13.add(datamenu12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 800, 470, 40));

        datamenu13.setBackground(new java.awt.Color(255, 255, 255));
        datamenu13.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu13.setOpaque(true);
        jPanel13.add(datamenu13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 871, 470, 40));

        datamenu14.setBackground(new java.awt.Color(255, 255, 255));
        datamenu14.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu14.setOpaque(true);
        jPanel13.add(datamenu14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 942, 470, 40));

        datamenu15.setBackground(new java.awt.Color(255, 255, 255));
        datamenu15.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu15.setOpaque(true);
        jPanel13.add(datamenu15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1013, 470, 40));

        datamenu16.setBackground(new java.awt.Color(255, 255, 255));
        datamenu16.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu16.setOpaque(true);
        jPanel13.add(datamenu16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1084, 470, 40));

        datamenu17.setBackground(new java.awt.Color(255, 255, 255));
        datamenu17.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu17.setOpaque(true);
        jPanel13.add(datamenu17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1155, 470, 40));

        datamenu18.setBackground(new java.awt.Color(255, 255, 255));
        datamenu18.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu18.setOpaque(true);
        jPanel13.add(datamenu18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1226, 470, 40));

        datamenu19.setBackground(new java.awt.Color(255, 255, 255));
        datamenu19.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu19.setOpaque(true);
        jPanel13.add(datamenu19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1297, 470, 40));

        datamenu20.setBackground(new java.awt.Color(255, 255, 255));
        datamenu20.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu20.setOpaque(true);
        jPanel13.add(datamenu20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1368, 470, 40));

        datamenu1.setBackground(new java.awt.Color(255, 255, 255));
        datamenu1.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datamenu1.setOpaque(true);
        jPanel13.add(datamenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 18, 470, 40));

        btnhapus20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus20.setOpaque(false);
        btnhapus20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus20Layout = new javax.swing.GroupLayout(btnhapus20);
        btnhapus20.setLayout(btnhapus20Layout);
        btnhapus20Layout.setHorizontalGroup(
            btnhapus20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus20Layout.setVerticalGroup(
            btnhapus20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus20, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1370, 38, 39));

        btnhapus19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus19.setOpaque(false);
        btnhapus19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus19Layout = new javax.swing.GroupLayout(btnhapus19);
        btnhapus19.setLayout(btnhapus19Layout);
        btnhapus19Layout.setHorizontalGroup(
            btnhapus19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus19Layout.setVerticalGroup(
            btnhapus19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1300, 38, 39));

        btnhapus18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus18.setOpaque(false);
        btnhapus18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus18Layout = new javax.swing.GroupLayout(btnhapus18);
        btnhapus18.setLayout(btnhapus18Layout);
        btnhapus18Layout.setHorizontalGroup(
            btnhapus18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus18Layout.setVerticalGroup(
            btnhapus18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1230, 38, 39));

        btnhapus17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus17.setOpaque(false);
        btnhapus17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus17Layout = new javax.swing.GroupLayout(btnhapus17);
        btnhapus17.setLayout(btnhapus17Layout);
        btnhapus17Layout.setHorizontalGroup(
            btnhapus17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus17Layout.setVerticalGroup(
            btnhapus17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus17, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1150, 38, 39));

        btnhapus16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus16.setOpaque(false);
        btnhapus16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus16Layout = new javax.swing.GroupLayout(btnhapus16);
        btnhapus16.setLayout(btnhapus16Layout);
        btnhapus16Layout.setHorizontalGroup(
            btnhapus16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus16Layout.setVerticalGroup(
            btnhapus16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1080, 38, 39));

        btnhapus15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus15.setOpaque(false);
        btnhapus15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus15Layout = new javax.swing.GroupLayout(btnhapus15);
        btnhapus15.setLayout(btnhapus15Layout);
        btnhapus15Layout.setHorizontalGroup(
            btnhapus15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus15Layout.setVerticalGroup(
            btnhapus15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1020, 38, 39));

        btnhapus14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus14.setOpaque(false);
        btnhapus14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus14Layout = new javax.swing.GroupLayout(btnhapus14);
        btnhapus14.setLayout(btnhapus14Layout);
        btnhapus14Layout.setHorizontalGroup(
            btnhapus14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus14Layout.setVerticalGroup(
            btnhapus14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 940, 38, 39));

        btnhapus13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus13.setOpaque(false);
        btnhapus13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus13Layout = new javax.swing.GroupLayout(btnhapus13);
        btnhapus13.setLayout(btnhapus13Layout);
        btnhapus13Layout.setHorizontalGroup(
            btnhapus13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus13Layout.setVerticalGroup(
            btnhapus13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 870, 38, 39));

        btnhapus12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus12.setOpaque(false);
        btnhapus12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus12Layout = new javax.swing.GroupLayout(btnhapus12);
        btnhapus12.setLayout(btnhapus12Layout);
        btnhapus12Layout.setHorizontalGroup(
            btnhapus12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus12Layout.setVerticalGroup(
            btnhapus12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 800, 38, 39));

        btnhapus11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus11.setOpaque(false);
        btnhapus11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus11Layout = new javax.swing.GroupLayout(btnhapus11);
        btnhapus11.setLayout(btnhapus11Layout);
        btnhapus11Layout.setHorizontalGroup(
            btnhapus11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus11Layout.setVerticalGroup(
            btnhapus11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 730, 38, 39));

        btnhapus10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus10.setOpaque(false);
        btnhapus10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus10Layout = new javax.swing.GroupLayout(btnhapus10);
        btnhapus10.setLayout(btnhapus10Layout);
        btnhapus10Layout.setHorizontalGroup(
            btnhapus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus10Layout.setVerticalGroup(
            btnhapus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 660, 38, 39));

        btnhapus9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus9.setOpaque(false);
        btnhapus9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus9Layout = new javax.swing.GroupLayout(btnhapus9);
        btnhapus9.setLayout(btnhapus9Layout);
        btnhapus9Layout.setHorizontalGroup(
            btnhapus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus9Layout.setVerticalGroup(
            btnhapus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 38, 39));

        btnhapus8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus8.setOpaque(false);
        btnhapus8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus8Layout = new javax.swing.GroupLayout(btnhapus8);
        btnhapus8.setLayout(btnhapus8Layout);
        btnhapus8Layout.setHorizontalGroup(
            btnhapus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus8Layout.setVerticalGroup(
            btnhapus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, 38, 39));

        btnhapus7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus7.setOpaque(false);
        btnhapus7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus7Layout = new javax.swing.GroupLayout(btnhapus7);
        btnhapus7.setLayout(btnhapus7Layout);
        btnhapus7Layout.setHorizontalGroup(
            btnhapus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus7Layout.setVerticalGroup(
            btnhapus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 38, 39));

        btnhapus6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus6.setOpaque(false);
        btnhapus6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus6Layout = new javax.swing.GroupLayout(btnhapus6);
        btnhapus6.setLayout(btnhapus6Layout);
        btnhapus6Layout.setHorizontalGroup(
            btnhapus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus6Layout.setVerticalGroup(
            btnhapus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 38, 39));

        btnhapus5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus5.setOpaque(false);
        btnhapus5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus5Layout = new javax.swing.GroupLayout(btnhapus5);
        btnhapus5.setLayout(btnhapus5Layout);
        btnhapus5Layout.setHorizontalGroup(
            btnhapus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus5Layout.setVerticalGroup(
            btnhapus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 38, 39));

        btnhapus4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus4.setOpaque(false);
        btnhapus4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus4Layout = new javax.swing.GroupLayout(btnhapus4);
        btnhapus4.setLayout(btnhapus4Layout);
        btnhapus4Layout.setHorizontalGroup(
            btnhapus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus4Layout.setVerticalGroup(
            btnhapus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 38, 39));

        btnhapus3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus3.setOpaque(false);
        btnhapus3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus3Layout = new javax.swing.GroupLayout(btnhapus3);
        btnhapus3.setLayout(btnhapus3Layout);
        btnhapus3Layout.setHorizontalGroup(
            btnhapus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus3Layout.setVerticalGroup(
            btnhapus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 38, 39));

        btnhapus2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus2.setOpaque(false);
        btnhapus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus2Layout = new javax.swing.GroupLayout(btnhapus2);
        btnhapus2.setLayout(btnhapus2Layout);
        btnhapus2Layout.setHorizontalGroup(
            btnhapus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus2Layout.setVerticalGroup(
            btnhapus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 91, 38, 39));

        btnhapus1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhapus1.setOpaque(false);
        btnhapus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapus1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhapus1Layout = new javax.swing.GroupLayout(btnhapus1);
        btnhapus1.setLayout(btnhapus1Layout);
        btnhapus1Layout.setHorizontalGroup(
            btnhapus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );
        btnhapus1Layout.setVerticalGroup(
            btnhapus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel13.add(btnhapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 19, 38, 39));

        menu20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu20, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1249, -1, -1));

        menu19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1178, -1, -1));

        menu18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1107, -1, -1));

        menu17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1036, -1, -1));

        menu16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 965, -1, -1));

        menu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 894, -1, -1));

        menu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 823, -1, -1));

        menu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 752, -1, -1));

        menu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 681, -1, -1));

        menu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 610, -1, -1));

        menu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 539, -1, -1));

        menu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 468, -1, -1));

        menu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 397, -1, -1));

        menu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 326, -1, -1));

        menu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 255, -1, -1));

        menu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 184, -1, -1));

        menu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 113, -1, -1));

        menu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 42, -1, -1));

        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -29, -1, -1));

        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -100, -1, -1));

        jScrollPane1.setViewportView(jPanel13);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 795, 550));

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 56, 48));

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 145, 56, 48));

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setOpaque(false);
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 56, 48));

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 288, 56, 48));

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.setOpaque(false);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 56, 48));
        jPanel1.add(displaygambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 180, 200));

        backdisplaygambar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout backdisplaygambarLayout = new javax.swing.GroupLayout(backdisplaygambar);
        backdisplaygambar.setLayout(backdisplaygambarLayout);
        backdisplaygambarLayout.setHorizontalGroup(
            backdisplaygambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        backdisplaygambarLayout.setVerticalGroup(
            backdisplaygambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        jPanel1.add(backdisplaygambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 260, 210));

        pilihgambar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pilihgambar.setOpaque(false);
        pilihgambar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pilihgambarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pilihgambarLayout = new javax.swing.GroupLayout(pilihgambar);
        pilihgambar.setLayout(pilihgambarLayout);
        pilihgambarLayout.setHorizontalGroup(
            pilihgambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        pilihgambarLayout.setVerticalGroup(
            pilihgambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(pilihgambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 340, 32));

        inputmenu.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        inputmenu.setForeground(new java.awt.Color(255, 102, 102));
        inputmenu.setText("MENU MAKANAN");
        inputmenu.setBorder(null);
        inputmenu.setName(""); // NOI18N
        inputmenu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputmenuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputmenuFocusLost(evt);
            }
        });
        inputmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputmenuMouseClicked(evt);
            }
        });
        inputmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputmenuActionPerformed(evt);
            }
        });
        jPanel1.add(inputmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 390, 310, 40));

        inputharga.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        inputharga.setForeground(new java.awt.Color(255, 102, 102));
        inputharga.setText("HARGA");
        inputharga.setBorder(null);
        inputharga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputhargaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputhargaFocusLost(evt);
            }
        });
        inputharga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputhargaMouseClicked(evt);
            }
        });
        inputharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputhargaActionPerformed(evt);
            }
        });
        jPanel1.add(inputharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 450, 310, 40));

        btncloseketersediaan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncloseketersediaan.setOpaque(false);
        btncloseketersediaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncloseketersediaanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btncloseketersediaanLayout = new javax.swing.GroupLayout(btncloseketersediaan);
        btncloseketersediaan.setLayout(btncloseketersediaanLayout);
        btncloseketersediaanLayout.setHorizontalGroup(
            btncloseketersediaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btncloseketersediaanLayout.setVerticalGroup(
            btncloseketersediaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(btncloseketersediaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 560, 346, 32));

        btntersedia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntersedia.setOpaque(false);
        btntersedia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntersediaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btntersediaLayout = new javax.swing.GroupLayout(btntersedia);
        btntersedia.setLayout(btntersediaLayout);
        btntersediaLayout.setHorizontalGroup(
            btntersediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btntersediaLayout.setVerticalGroup(
            btntersediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(btntersedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 598, 346, 27));

        btnkosong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnkosong.setOpaque(false);
        btnkosong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkosongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnkosongLayout = new javax.swing.GroupLayout(btnkosong);
        btnkosong.setLayout(btnkosongLayout);
        btnkosongLayout.setHorizontalGroup(
            btnkosongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btnkosongLayout.setVerticalGroup(
            btnkosongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel1.add(btnkosong, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 628, 346, 25));

        popupketersediaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popupketersediaan.png"))); // NOI18N
        jPanel1.add(popupketersediaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 459, 510, -1));

        btnmakanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmakanan.setOpaque(false);
        btnmakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmakananMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmakananMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout btnmakananLayout = new javax.swing.GroupLayout(btnmakanan);
        btnmakanan.setLayout(btnmakananLayout);
        btnmakananLayout.setHorizontalGroup(
            btnmakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btnmakananLayout.setVerticalGroup(
            btnmakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(btnmakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 567, 346, 27));

        btnminuman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnminuman.setOpaque(false);
        btnminuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminumanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnminumanLayout = new javax.swing.GroupLayout(btnminuman);
        btnminuman.setLayout(btnminumanLayout);
        btnminumanLayout.setHorizontalGroup(
            btnminumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btnminumanLayout.setVerticalGroup(
            btnminumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel1.add(btnminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 597, 346, 25));

        btnsnack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsnack.setOpaque(false);
        btnsnack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsnackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnsnackLayout = new javax.swing.GroupLayout(btnsnack);
        btnsnack.setLayout(btnsnackLayout);
        btnsnackLayout.setHorizontalGroup(
            btnsnackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btnsnackLayout.setVerticalGroup(
            btnsnackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(btnsnack, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 630, 346, 27));

        btnpromosi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpromosi.setOpaque(false);
        btnpromosi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpromosiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnpromosiLayout = new javax.swing.GroupLayout(btnpromosi);
        btnpromosi.setLayout(btnpromosiLayout);
        btnpromosiLayout.setHorizontalGroup(
            btnpromosiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btnpromosiLayout.setVerticalGroup(
            btnpromosiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(btnpromosi, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 547, 346, 27));

        btnclosekategori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclosekategori.setOpaque(false);
        btnclosekategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclosekategoriMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnclosekategoriLayout = new javax.swing.GroupLayout(btnclosekategori);
        btnclosekategori.setLayout(btnclosekategoriLayout);
        btnclosekategoriLayout.setHorizontalGroup(
            btnclosekategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        btnclosekategoriLayout.setVerticalGroup(
            btnclosekategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(btnclosekategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 346, 32));

        popupkategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popup kategori.png"))); // NOI18N
        jPanel1.add(popupkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 457, -1, -1));

        labelnama.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelnama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelnama.setToolTipText("");
        labelnama.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(labelnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 510, 20));

        btnketersediaan.setBackground(new java.awt.Color(255, 255, 255));
        btnketersediaan.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        btnketersediaan.setForeground(new java.awt.Color(255, 102, 102));
        btnketersediaan.setText("    KETERSEDIAAN");
        btnketersediaan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnketersediaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnketersediaanMouseClicked(evt);
            }
        });
        jPanel1.add(btnketersediaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 560, 345, 36));

        btnkategori.setBackground(new java.awt.Color(255, 255, 255));
        btnkategori.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        btnkategori.setForeground(new java.awt.Color(255, 102, 102));
        btnkategori.setText("    KATEGORI");
        btnkategori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnkategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkategoriMouseClicked(evt);
            }
        });
        jPanel1.add(btnkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 510, 345, 36));

        btnEditIniEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditIniEdit.setOpaque(false);
        btnEditIniEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditIniEditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnEditIniEditLayout = new javax.swing.GroupLayout(btnEditIniEdit);
        btnEditIniEdit.setLayout(btnEditIniEditLayout);
        btnEditIniEditLayout.setHorizontalGroup(
            btnEditIniEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        btnEditIniEditLayout.setVerticalGroup(
            btnEditIniEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(btnEditIniEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 660, 180, 70));

        btnCancelInEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelInEdit.setOpaque(false);
        btnCancelInEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelInEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelInEditMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout btnCancelInEditLayout = new javax.swing.GroupLayout(btnCancelInEdit);
        btnCancelInEdit.setLayout(btnCancelInEditLayout);
        btnCancelInEditLayout.setHorizontalGroup(
            btnCancelInEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        btnCancelInEditLayout.setVerticalGroup(
            btnCancelInEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(btnCancelInEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 660, 180, 70));

        PopUpEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/button edit karyawan.png"))); // NOI18N
        jPanel1.add(PopUpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.setOpaque(false);
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout submitLayout = new javax.swing.GroupLayout(submit);
        submit.setLayout(submitLayout);
        submitLayout.setHorizontalGroup(
            submitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );
        submitLayout.setVerticalGroup(
            submitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 663, 182, 60));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/2.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        label_id_menu.setText("jLabel1");
        getContentPane().add(label_id_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        gambarTextField.setText("jLabel1");
        getContentPane().add(gambarTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        label_id_kategori.setText("jLabel1");
        getContentPane().add(label_id_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, -1, -1));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        this.setVisible(false);
        new AdminPenjualan().setVisible(true);
        
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        this.setVisible(false);
        new AdminKaryawan().setVisible(true);
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.setVisible(false);
        try {
            new AdminPesanan().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        this.setVisible(false);
        new MainDisplay().setVisible(true);
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void popupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popupMouseClicked
        popuplabel.setVisible(true);
        popup.setVisible(false);
        popuptutup.setVisible(true);
        popuplabel.setOpaque(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        jPanel7.setVisible(true);
        jPanel8.setVisible(true);
        jPanel9.setVisible(true);
        jPanel10.setVisible(true);
        jPanel11.setVisible(true);
    }//GEN-LAST:event_popupMouseClicked

    private void btnkategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkategoriMouseClicked
        popupkategori.setVisible(true);
        btnpromosi.setVisible(true);
        btnmakanan.setVisible(true);
        btnminuman.setVisible(true);
        btnsnack.setVisible(true);
        btnclosekategori.setVisible(true);
        btnkategori.setVisible(false);
    }//GEN-LAST:event_btnkategoriMouseClicked

    private void btnketersediaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnketersediaanMouseClicked
        popupketersediaan.setVisible(true);
        btnkosong.setVisible(true);
        btntersedia.setVisible(true);
        btncloseketersediaan.setVisible(true);
        btnketersediaan.setVisible(false);
    }//GEN-LAST:event_btnketersediaanMouseClicked

    private void btnpromosiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpromosiMouseClicked
        btnkategori.setText("    PROMOSI");
        label_id_kategori.setText("1");
        closepopupkategori();
    }//GEN-LAST:event_btnpromosiMouseClicked

    private void btnclosekategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclosekategoriMouseClicked
        closepopupkategori();
    }//GEN-LAST:event_btnclosekategoriMouseClicked

    private void btnmakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmakananMouseClicked
        btnkategori.setText("    MAKANAN");
        label_id_kategori.setText("2");
        closepopupkategori();
    }//GEN-LAST:event_btnmakananMouseClicked

    private void btnminumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminumanMouseClicked
        btnkategori.setText("    MINUMAN");
        label_id_kategori.setText("3");
        closepopupkategori();
    }//GEN-LAST:event_btnminumanMouseClicked

    private void btnsnackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsnackMouseClicked
        btnkategori.setText("    SNACK");
        label_id_kategori.setText("4");
        closepopupkategori();
    }//GEN-LAST:event_btnsnackMouseClicked

    private void btncloseketersediaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncloseketersediaanMouseClicked
        closepopupketersediaan();
    }//GEN-LAST:event_btncloseketersediaanMouseClicked

    private void btntersediaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntersediaMouseClicked
        btnketersediaan.setText("    TERSEDIA");
        closepopupketersediaan();
    }//GEN-LAST:event_btntersediaMouseClicked

    private void btnkosongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkosongMouseClicked
        btnketersediaan.setText("    KOSONG");
        closepopupketersediaan();
    }//GEN-LAST:event_btnkosongMouseClicked

    private void pilihgambarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pilihgambarMouseClicked
        try{
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif","png");
            chooser.addChoosableFileFilter(filter);
            int result = chooser.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                String filename = file.getAbsolutePath();
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(file.toString());
                gambarTextField.setText(filename);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);
                //set icon
                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }else if(result == JFileChooser.CANCEL_OPTION){
                System.out.println("No Data");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_pilihgambarMouseClicked

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        try {
            char kategori = 0;
            switch(btnkategori.getText()){
            case "    MAKANAN":
                    kategori='2';
                break;
            case "    PROMOSI":
                    kategori='1';
                break;
            case "    MINUMAN": 
                    kategori='3';
                break;
            case "    SNACK":
                    kategori='4';
                break;
            }
            
            String kategoriString = Character.toString(kategori);
            // Baca data dari JTextField
            String menu = inputmenu.getText();
            String harga = inputharga.getText();
            String ketersediaan = btnketersediaan.getText();
            String tanpaspasiketersediaan = ketersediaan.replaceAll("\\s+", "");
            String filename = gambarTextField.getText();

            // Baca file gambar ke dalam byte array
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageBytes = new byte[(int) file.length()];
            fis.read(imageBytes);
            fis.close();

            // Siapkan statement untuk insert data ke tabel
            String sql = "INSERT INTO `menu` (`id_menu`, `nama_menu`, `kategori_id`, `harga`, `ketersediaan`, `path_gambar`) VALUES (NULL, ?, ?, ?, ?, ?);";
            
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, menu);
            pstm.setString(2, kategoriString);
            pstm.setString(3, harga);
            pstm.setString(4, tanpaspasiketersediaan);
            pstm.setBytes(5, imageBytes);
            // Jalankan statement
            pstm.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Data berhasil diupload ke database");
            kosongkanform();
            tampilkandata();
            conn.close();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_submitMouseClicked

    private void btnview20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview20MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 19;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview20MouseClicked

    private void btnview19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview19MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 18;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview19MouseClicked

    private void btnview18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview18MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 17;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview18MouseClicked

    private void btnview17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview17MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 16;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview17MouseClicked

    private void btnview16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview16MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 15;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview16MouseClicked

    private void btnview15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview15MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 14;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview15MouseClicked

    private void btnview14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview14MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 13;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview14MouseClicked

    private void btnview13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview13MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 12;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview13MouseClicked

    private void btnview12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview12MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 11;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview12MouseClicked

    private void btnview11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview11MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 10;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview11MouseClicked

    private void btnview10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview10MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 9;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview10MouseClicked

    private void btnview9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview9MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 8;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview9MouseClicked

    private void btnview8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview8MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 7;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview8MouseClicked

    private void btnview7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview7MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 6;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview7MouseClicked

    private void btnview6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview6MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 5;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview6MouseClicked

    private void btnview5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview5MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 4;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview5MouseClicked

    private void btnview4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview4MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 3;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview4MouseClicked

    private void btnview3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview3MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 2;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview3MouseClicked

    private void btnview2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview2MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview2MouseClicked

    private void btnview1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview1MouseClicked
        try {
            popupopen();
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') LIMIT 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtharga.setText("Harga: "+rs.getString(4));
                popuptxtketersediaan.setText("Ketersediaan: "+rs.getString(5));
                
                popuptxtmenu.setText("Menu: "+rs.getString(2));
                popuptxtkategori.setText("Kategori: "+rs.getString(8));
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview1MouseClicked

    private void btnedit20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit20MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 19;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit20MouseClicked

    private void btnedit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit19MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 18;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit19MouseClicked

    private void btnedit18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit18MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 17;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit18MouseClicked

    private void btnedit17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit17MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 16;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit17MouseClicked

    private void btnedit16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit16MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 15;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit16MouseClicked

    private void btnedit15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit15MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 14;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit15MouseClicked

    private void btnedit14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit14MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 13;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit14MouseClicked

    private void btnedit13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit13MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 12;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit13MouseClicked

    private void btnedit12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit12MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 11;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit12MouseClicked

    private void btnedit11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit11MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 10;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit11MouseClicked

    private void btnedit10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit10MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 9;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit10MouseClicked

    private void btnedit9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit9MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 8;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit9MouseClicked

    private void btnedit8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit8MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 7;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit8MouseClicked

    private void btnedit7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit7MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 6;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit7MouseClicked

    private void btnedit6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit6MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 5;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit6MouseClicked

    private void btnedit5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit5MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 4;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit5MouseClicked

    private void btnedit4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit4MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 3;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit4MouseClicked

    private void btnedit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit3MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 2;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_btnedit3MouseClicked

    private void btnedit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit2MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_btnedit2MouseClicked

    private void btnedit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit1MouseClicked
        kosongkanform();
        labelhelpeditbuka();

        //set nik false focusable
        try {
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') "+
            "LIMIT 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputmenu.setText(rs.getString(2));
                inputharga.setText(rs.getString(4));
                btnkategori.setText("    "+rs.getString(8));
                btnketersediaan.setText("    "+rs.getString(5));
                String id_menu = rs.getString("id_menu");
                label_id_menu.setText(id_menu);
                
                byte[] fotoBytes = rs.getBytes(6);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);

            }
            conn.close();
            pstm.close();
            rs.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_btnedit1MouseClicked

    private void btnhapus20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus20MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack') " +
            "LIMIT 1 OFFSET 19;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus20MouseClicked

    private void btnhapus19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus19MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 18;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus19MouseClicked

    private void btnhapus18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus18MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 17;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus18MouseClicked

    private void btnhapus17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus17MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 16;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus17MouseClicked

    private void btnhapus16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus16MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 15;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus16MouseClicked

    private void btnhapus15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus15MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 14;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus15MouseClicked

    private void btnhapus14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus14MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 13;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus14MouseClicked

    private void btnhapus13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus13MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 12;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus13MouseClicked

    private void btnhapus12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus12MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 11;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus12MouseClicked

    private void btnhapus11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus11MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 10;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus11MouseClicked

    private void btnhapus10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus10MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 9;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus10MouseClicked

    private void btnhapus9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus9MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 8;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus9MouseClicked

    private void btnhapus8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus8MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 7;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus8MouseClicked

    private void btnhapus7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus7MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 6;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus7MouseClicked

    private void btnhapus6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus6MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 5;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus6MouseClicked

    private void btnhapus5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus5MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 4;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus5MouseClicked

    private void btnhapus4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus4MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 3;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus4MouseClicked

    private void btnhapus3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus3MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 2;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus3MouseClicked

    private void btnhapus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus2MouseClicked

        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus2MouseClicked

    private void btnhapus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus1MouseClicked
        try{
            String id_menu = null;
            String sql = "SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id "
                + "ORDER BY FIELD(kategori_menu.kategori_nama, 'Promosi', 'Makanan', 'Minuman', 'Snack')\n" +
            "LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                id_menu=rs.getString(1);
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus menu ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM menu WHERE `id_menu` = '"+id_menu+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

                // Hapus data pada tabel akun
                
                
                
                // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Menu telah dihapus");
                tampilkandata();
            }
            conn.close();
            pstm.close();
            rs.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus1MouseClicked

    private void btnEditIniEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditIniEditMouseClicked
        
        try {
            char kategori = 0;
            switch(btnkategori.getText()){
            case "    Makanan":
                    kategori='2';
                break;
            case "    Promosi":
                    kategori='1';
                break;
            case "    Minuman": 
                    kategori='3';
                break;
            case "    Snack":
                    kategori='4';
                break;
            }
            String kategoriString = Character.toString(kategori);
            
            // Baca data dari JTextField
            String menu = inputmenu.getText();
            String harga = inputharga.getText();
            String ketersediaan = btnketersediaan.getText();
            String tanpaspasiketersediaan = ketersediaan.replaceAll("\\s+", "");
            ImageIcon imageIcon = (ImageIcon) displaygambar.getIcon();
            Image image = imageIcon.getImage();

            // Mengubah gambar menjadi format byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] fotoBytes = baos.toByteArray();

            // Membuat query SQL untuk mengupdate data di database
            String sql = "UPDATE `menu` SET `nama_menu` = '"+inputmenu.getText()+"', `kategori_id` = '"+kategoriString+"', `harga` = '"+inputharga.getText()+"', `ketersediaan` = '"+tanpaspasiketersediaan+"', `path_gambar` =? WHERE `menu`.`id_menu` = "+label_id_menu.getText()+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

            // Mengatur parameter untuk gambar sebagai byte array
            pstm.setBytes(1, fotoBytes);
            // Menjalankan perintah update
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil...");

            labelhelpedittutup();

            tampilkandata();
            kosongkanform();
            conn.close();
            pstm.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnEditIniEditMouseClicked

    private void btnCancelInEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelInEditMouseClicked
        kosongkanform();
        labelhelpedittutup();
        PopUpEdit.setVisible(false);
        btnEditIniEdit.setVisible(false);
        btnCancelInEdit.setVisible(false);
        inputharga.setFocusable(true);
    }//GEN-LAST:event_btnCancelInEditMouseClicked

    private void btnmakananMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmakananMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmakananMouseEntered

    private void inputmenuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputmenuFocusGained

    }//GEN-LAST:event_inputmenuFocusGained

    private void inputmenuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputmenuFocusLost
        inputmenu.setForeground(Color.red);
        if (inputmenu.getText() == null || inputmenu.getText().isEmpty()) {

            inputmenu.setText("MENU MAKANAN");
        }

    }//GEN-LAST:event_inputmenuFocusLost

    private void inputmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputmenuMouseClicked
        inputmenu.setText(null);
        inputmenu.setForeground(Color.BLUE);
    }//GEN-LAST:event_inputmenuMouseClicked

    private void inputmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputmenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputmenuActionPerformed

    private void inputhargaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputhargaFocusGained
        inputharga.setText(null);
        inputharga.setForeground(Color.BLUE);
    }//GEN-LAST:event_inputhargaFocusGained

    private void inputhargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputhargaFocusLost
        inputharga.setForeground(Color.red);
        if (inputharga.getText() == null || inputharga.getText().isEmpty()) {

            inputharga.setText("HARGA");
        }

    }//GEN-LAST:event_inputhargaFocusLost

    private void inputhargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputhargaMouseClicked
        if (!inputharga.isFocusable()) {
            JOptionPane.showMessageDialog(null, "NIK tidak dapat dirubah. Silahkan buat data karyawan baru.");
        }
    }//GEN-LAST:event_inputhargaMouseClicked

    private void inputhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputhargaActionPerformed

    }//GEN-LAST:event_inputhargaActionPerformed

    private void btnCancelInEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelInEditMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelInEditMouseEntered

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        this.setVisible(false);
        new AdminPenjualan().setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        this.setVisible(false);
        new AdminMenu().setVisible(true);

    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        this.setVisible(false);
        new AdminKaryawan().setVisible(true);

    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        this.setVisible(false);
        try {
            new AdminPesanan().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jPanel10MouseClicked

    private void popuptutupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popuptutupMouseClicked
        popuplabel.setVisible(false);
        popuptutup.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
        jPanel4.setVisible(true);
        jPanel5.setVisible(true);
        jPanel6.setVisible(true);
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
        popup.setVisible(true);
    }//GEN-LAST:event_popuptutupMouseClicked

    private void popupcloseinfomenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popupcloseinfomenuMouseClicked
        labelhelpedittutup();
    }//GEN-LAST:event_popupcloseinfomenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PopUpEdit;
    private javax.swing.JPanel backdisplaygambar;
    private javax.swing.JLabel background;
    private javax.swing.JPanel backpopup;
    private javax.swing.JPanel btnCancelInEdit;
    private javax.swing.JPanel btnEditIniEdit;
    private javax.swing.JPanel btnclosekategori;
    private javax.swing.JPanel btncloseketersediaan;
    private javax.swing.JPanel btnedit1;
    private javax.swing.JPanel btnedit10;
    private javax.swing.JPanel btnedit11;
    private javax.swing.JPanel btnedit12;
    private javax.swing.JPanel btnedit13;
    private javax.swing.JPanel btnedit14;
    private javax.swing.JPanel btnedit15;
    private javax.swing.JPanel btnedit16;
    private javax.swing.JPanel btnedit17;
    private javax.swing.JPanel btnedit18;
    private javax.swing.JPanel btnedit19;
    private javax.swing.JPanel btnedit2;
    private javax.swing.JPanel btnedit20;
    private javax.swing.JPanel btnedit3;
    private javax.swing.JPanel btnedit4;
    private javax.swing.JPanel btnedit5;
    private javax.swing.JPanel btnedit6;
    private javax.swing.JPanel btnedit7;
    private javax.swing.JPanel btnedit8;
    private javax.swing.JPanel btnedit9;
    private javax.swing.JPanel btnhapus1;
    private javax.swing.JPanel btnhapus10;
    private javax.swing.JPanel btnhapus11;
    private javax.swing.JPanel btnhapus12;
    private javax.swing.JPanel btnhapus13;
    private javax.swing.JPanel btnhapus14;
    private javax.swing.JPanel btnhapus15;
    private javax.swing.JPanel btnhapus16;
    private javax.swing.JPanel btnhapus17;
    private javax.swing.JPanel btnhapus18;
    private javax.swing.JPanel btnhapus19;
    private javax.swing.JPanel btnhapus2;
    private javax.swing.JPanel btnhapus20;
    private javax.swing.JPanel btnhapus3;
    private javax.swing.JPanel btnhapus4;
    private javax.swing.JPanel btnhapus5;
    private javax.swing.JPanel btnhapus6;
    private javax.swing.JPanel btnhapus7;
    private javax.swing.JPanel btnhapus8;
    private javax.swing.JPanel btnhapus9;
    private javax.swing.JLabel btnkategori;
    private javax.swing.JLabel btnketersediaan;
    private javax.swing.JPanel btnkosong;
    private javax.swing.JPanel btnmakanan;
    private javax.swing.JPanel btnminuman;
    private javax.swing.JPanel btnpromosi;
    private javax.swing.JPanel btnsnack;
    private javax.swing.JPanel btntersedia;
    private javax.swing.JPanel btnview1;
    private javax.swing.JPanel btnview10;
    private javax.swing.JPanel btnview11;
    private javax.swing.JPanel btnview12;
    private javax.swing.JPanel btnview13;
    private javax.swing.JPanel btnview14;
    private javax.swing.JPanel btnview15;
    private javax.swing.JPanel btnview16;
    private javax.swing.JPanel btnview17;
    private javax.swing.JPanel btnview18;
    private javax.swing.JPanel btnview19;
    private javax.swing.JPanel btnview2;
    private javax.swing.JPanel btnview20;
    private javax.swing.JPanel btnview3;
    private javax.swing.JPanel btnview4;
    private javax.swing.JPanel btnview5;
    private javax.swing.JPanel btnview6;
    private javax.swing.JPanel btnview7;
    private javax.swing.JPanel btnview8;
    private javax.swing.JPanel btnview9;
    private javax.swing.JLabel datamenu1;
    private javax.swing.JLabel datamenu10;
    private javax.swing.JLabel datamenu11;
    private javax.swing.JLabel datamenu12;
    private javax.swing.JLabel datamenu13;
    private javax.swing.JLabel datamenu14;
    private javax.swing.JLabel datamenu15;
    private javax.swing.JLabel datamenu16;
    private javax.swing.JLabel datamenu17;
    private javax.swing.JLabel datamenu18;
    private javax.swing.JLabel datamenu19;
    private javax.swing.JLabel datamenu2;
    private javax.swing.JLabel datamenu20;
    private javax.swing.JLabel datamenu3;
    private javax.swing.JLabel datamenu4;
    private javax.swing.JLabel datamenu5;
    private javax.swing.JLabel datamenu6;
    private javax.swing.JLabel datamenu7;
    private javax.swing.JLabel datamenu8;
    private javax.swing.JLabel datamenu9;
    private javax.swing.JLabel displaygambar;
    private javax.swing.JLabel displaygambar1;
    private javax.swing.JLabel displaygambar10;
    private javax.swing.JLabel displaygambar11;
    private javax.swing.JLabel displaygambar12;
    private javax.swing.JLabel displaygambar13;
    private javax.swing.JLabel displaygambar14;
    private javax.swing.JLabel displaygambar15;
    private javax.swing.JLabel displaygambar16;
    private javax.swing.JLabel displaygambar17;
    private javax.swing.JLabel displaygambar18;
    private javax.swing.JLabel displaygambar19;
    private javax.swing.JLabel displaygambar2;
    private javax.swing.JLabel displaygambar20;
    private javax.swing.JLabel displaygambar3;
    private javax.swing.JLabel displaygambar4;
    private javax.swing.JLabel displaygambar5;
    private javax.swing.JLabel displaygambar6;
    private javax.swing.JLabel displaygambar7;
    private javax.swing.JLabel displaygambar8;
    private javax.swing.JLabel displaygambar9;
    private javax.swing.JLabel gambarTextField;
    private javax.swing.JTextField inputharga;
    private javax.swing.JTextField inputmenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_id_kategori;
    private javax.swing.JLabel label_id_menu;
    public static final javax.swing.JLabel labelnama = new javax.swing.JLabel();
    public static final javax.swing.JLabel labelnama1 = new javax.swing.JLabel();
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu10;
    private javax.swing.JLabel menu11;
    private javax.swing.JLabel menu12;
    private javax.swing.JLabel menu13;
    private javax.swing.JLabel menu14;
    private javax.swing.JLabel menu15;
    private javax.swing.JLabel menu16;
    private javax.swing.JLabel menu17;
    private javax.swing.JLabel menu18;
    private javax.swing.JLabel menu19;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menu20;
    private javax.swing.JLabel menu3;
    private javax.swing.JLabel menu4;
    private javax.swing.JLabel menu5;
    private javax.swing.JLabel menu6;
    private javax.swing.JLabel menu7;
    private javax.swing.JLabel menu8;
    private javax.swing.JLabel menu9;
    private javax.swing.JPanel pilihgambar;
    private javax.swing.JPanel popup;
    private javax.swing.JPanel popupcloseinfomenu;
    private javax.swing.JLabel popupdisplaygambar;
    private javax.swing.JLabel popupinfomenu;
    private javax.swing.JLabel popupkategori;
    private javax.swing.JLabel popupketersediaan;
    private javax.swing.JLabel popuplabel;
    private javax.swing.JPanel popuptutup;
    private javax.swing.JLabel popuptxtharga;
    private javax.swing.JLabel popuptxtkategori;
    private javax.swing.JLabel popuptxtketersediaan;
    private javax.swing.JLabel popuptxtmenu;
    private javax.swing.JPanel submit;
    // End of variables declaration//GEN-END:variables
}
