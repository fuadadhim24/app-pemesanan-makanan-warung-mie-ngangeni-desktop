/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Desktop;
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
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author fuada
 */
public class AdminKaryawan extends javax.swing.JFrame {
    
    private String filename;
    private File f;
    private String data1[];
    private String data2[];
    private String data3[];
    private String data4[];
    private String data5[];
    private String data6[];
    private String data7[];
    private String data8[];
    private String data9[];
    private String data10[];
    private String data11[];
    private String data12[];
    private String data13[];
    private String data14[];
    private String data15[];
    private String data16[];
    private String data17[];
    private String data18[];
    private String data19[];
    private String data20[];
    String s;
    
    /**
     * Creates new form PenjualanAdmin
     */
    
    // Membentuk link WhatsApp direct
    private void openWhatsAppDirectLink() {
        String inputText = popuptxtnowa.getText();
        // Menghilangkan "No WA: " dari teks input
        String phoneNumber = inputText.replace("No WA: ", "");
        
        // Menghapus spasi tambahan (jika ada)
        phoneNumber = phoneNumber.trim();

        if (phoneNumber.startsWith("08")) {
            // Mengganti "08" dengan "+62"
            phoneNumber = "+62" + phoneNumber.substring(1);
        } else if (phoneNumber.startsWith("628")) {
            // Mengganti "628" dengan "+62"
            phoneNumber = "+62" + phoneNumber.substring(2);
        }
        String url = "https://wa.me/" + phoneNumber;

        try {
            // Membuka browser dengan link WhatsApp direct
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
        }
    }
    
    private void popupopen(){
        popupdisplaygambar.setVisible(true);
        popuptxtjabatan.setVisible(true);
        popuptxtnama.setVisible(true);
        popuptxtnik.setVisible(true);
        popuptxtnowa.setVisible(true);
        popuptxtusername.setVisible(true);
        popupinfokaryawan.setVisible(true);
        popupclose.setVisible(true);
        backpopup.setVisible(true);
    }
    private void popupclose(){
        popupdisplaygambar.setVisible(false);
        popuptxtjabatan.setVisible(false);
        popuptxtnama.setVisible(false);
        popuptxtnik.setVisible(false);
        popuptxtnowa.setVisible(false);
        popuptxtusername.setVisible(false);
        popupinfokaryawan.setVisible(false);
        popupclose.setVisible(false);
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
        labelnamakaryawan.setVisible(false);
        labelnik.setVisible(false);
        labelnowa.setVisible(false);
        labelusername.setVisible(false);
        inputnik.setFocusable(true);
        btnCancelInEdit.setVisible(false);
        btnEditIniEdit.setVisible(false);
        PopUpEdit.setVisible(false);
        submit.setVisible(true);
    }
    private void labelhelpeditbuka(){
        labelnamakaryawan.setVisible(true);
        labelnik.setVisible(true);
        labelnowa.setVisible(true);
        labelusername.setVisible(true);
        submit.setVisible(false);
        btnCancelInEdit.setVisible(true);
        btnEditIniEdit.setVisible(true);
        PopUpEdit.setVisible(true);
    }    
    private void tampilkandata() {
    try {
        String sql = "SELECT *\n" +
                "FROM akun\n" +
                "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
                "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter');";
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
                    datakaryawan1.setVisible(false);
                    krywn1.setVisible(false);
                    displaygambar1.setVisible(false);
                    btnedit1.setVisible(false);
                    btnview1.setVisible(false);
                    btnhapus1.setVisible(false);
                    break;
                case 2:
                    datakaryawan2.setVisible(false);
                    krywn2.setVisible(false);
                    displaygambar2.setVisible(false);
                    btnedit2.setVisible(false);
                    btnview2.setVisible(false);
                    btnhapus2.setVisible(false);
                    break;
                case 3:
                    datakaryawan3.setVisible(false);
                    krywn3.setVisible(false);
                    displaygambar3.setVisible(false);
                    btnedit3.setVisible(false);
                    btnview3.setVisible(false);
                    btnhapus3.setVisible(false);
                    break;
                case 4:
                    datakaryawan4.setVisible(false);
                    krywn4.setVisible(false);
                    displaygambar4.setVisible(false);
                    btnedit4.setVisible(false);
                    btnview4.setVisible(false);
                    btnhapus4.setVisible(false);
                    break;
                case 5:
                    datakaryawan5.setVisible(false);
                    krywn5.setVisible(false);
                    displaygambar5.setVisible(false);
                    btnedit5.setVisible(false);
                    btnview5.setVisible(false);
                    btnhapus5.setVisible(false);
                    break;
                case 6:
                    datakaryawan6.setVisible(false);
                    krywn6.setVisible(false);
                    displaygambar6.setVisible(false);
                    btnview6.setVisible(false);
                    btnedit6.setVisible(false);
                    btnhapus6.setVisible(false);
                    break;
                case 7:
                    datakaryawan7.setVisible(false);
                    krywn7.setVisible(false);
                    displaygambar7.setVisible(false);
                    btnedit7.setVisible(false);
                    btnview7.setVisible(false);
                    btnhapus7.setVisible(false);
                    break;
                case 8:
                    datakaryawan8.setVisible(false);
                    krywn8.setVisible(false);
                    displaygambar8.setVisible(false);
                    btnedit8.setVisible(false);
                    btnview8.setVisible(false);
                    btnhapus8.setVisible(false);
                    break;
                case 9:
                    datakaryawan9.setVisible(false);
                    krywn9.setVisible(false);
                    displaygambar9.setVisible(false);
                    btnedit9.setVisible(false);
                    btnview9.setVisible(false);
                    btnhapus9.setVisible(false);
                    break;
                case 10:
                    datakaryawan10.setVisible(false);
                    krywn10.setVisible(false);
                    displaygambar10.setVisible(false);
                    btnedit10.setVisible(false);
                    btnview10.setVisible(false);
                    btnhapus10.setVisible(false);
                    break;
                case 11:
                    datakaryawan11.setVisible(false);
                    krywn11.setVisible(false);
                    displaygambar11.setVisible(false);
                    btnview11.setVisible(false);
                    btnedit11.setVisible(false);
                    btnhapus11.setVisible(false);
                    break;
                case 12:
                    datakaryawan12.setVisible(false);
                    krywn12.setVisible(false);
                    displaygambar12.setVisible(false);
                    btnview12.setVisible(false);
                    btnedit12.setVisible(false);
                    btnhapus12.setVisible(false);
                    break;
                case 13:
                    datakaryawan13.setVisible(false);
                    krywn13.setVisible(false);
                    displaygambar13.setVisible(false);
                    btnedit13.setVisible(false);
                    btnhapus13.setVisible(false);
                    btnview13.setVisible(false);
                    break;
                case 14:
                    datakaryawan14.setVisible(false);
                    krywn14.setVisible(false);
                    displaygambar14.setVisible(false);
                    btnedit14.setVisible(false);
                    btnview14.setVisible(false);
                    btnhapus14.setVisible(false);
                    break;
                case 15:
                    datakaryawan15.setVisible(false);
                    krywn15.setVisible(false);
                    displaygambar15.setVisible(false);
                    btnview15.setVisible(false);
                    btnedit15.setVisible(false);
                    btnhapus15.setVisible(false);
                    break;
                case 16:
                    datakaryawan16.setVisible(false);
                    krywn16.setVisible(false);
                    displaygambar16.setVisible(false);
                    btnview16.setVisible(false);
                    btnedit16.setVisible(false);
                    btnhapus16.setVisible(false);
                    break;
                case 17:
                    datakaryawan17.setVisible(false);
                    krywn17.setVisible(false);
                    displaygambar17.setVisible(false);
                    btnview17.setVisible(false);
                    btnedit17.setVisible(false);
                    btnhapus17.setVisible(false);
                    break;
                case 18:
                    datakaryawan18.setVisible(false);
                    krywn18.setVisible(false);
                    displaygambar18.setVisible(false);
                    btnview18.setVisible(false);
                    btnedit18.setVisible(false);
                    btnhapus18.setVisible(false);
                    break;
                case 19:
                    datakaryawan19.setVisible(false);
                    krywn19.setVisible(false);
                    displaygambar19.setVisible(false);
                    btnview19.setVisible(false);
                    btnedit19.setVisible(false);
                    btnhapus19.setVisible(false);
                    break;
                case 20:
                    datakaryawan20.setVisible(false);
                    krywn20.setVisible(false);
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
                    String nama = rs.getString("nama");
                    String hakAkses = rs.getString("hak_akses");
                    String nik = rs.getString("nik/id");
                    String nowa = rs.getString("no_wa");
                    String username = rs.getString("username");

                    Blob gambar = (Blob) rs.getBlob("foto");
                    int ukuran = (int) gambar.length();
                    ImageIcon ic = new ImageIcon(gambar.getBytes(1, ukuran));
                    Image img = ic.getImage().getScaledInstance(103, 130, Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(img);
                    switch (row) {
                        case 1:
                            datakaryawan1.setVisible(true);
                            datakaryawan1.setText(hakAkses + " :  " + nama);
                            krywn1.setVisible(true);
                            displaygambar1.setIcon(icon);
                            displaygambar1.setVisible(true);
                            btnview1.setVisible(true);
                            btnedit1.setVisible(true);
                            btnhapus1.setVisible(true);
                            break;
                        case 2:
                            datakaryawan2.setVisible(true);
                            datakaryawan2.setText(hakAkses + " :  " + nama);
                            krywn2.setVisible(true);
                            displaygambar2.setIcon(icon);
                            displaygambar2.setVisible(true);
                            btnview2.setVisible(true);
                            btnedit2.setVisible(true);
                            btnhapus2.setVisible(true);
                            break;
                        case 3:
                            datakaryawan3.setVisible(true);
                            datakaryawan3.setText(hakAkses + " :  " + nama);
                            krywn3.setVisible(true);
                            displaygambar3.setIcon(icon);
                            displaygambar3.setVisible(true);
                            btnview3.setVisible(true);
                            btnedit3.setVisible(true);
                            btnhapus3.setVisible(true);
                            break;
                        case 4:
                            datakaryawan4.setVisible(true);
                            datakaryawan4.setText(hakAkses + " :  " + nama);
                            krywn4.setVisible(true);
                            displaygambar4.setIcon(icon);
                            displaygambar4.setVisible(true);
                            btnview4.setVisible(true);
                            btnedit4.setVisible(true);
                            btnhapus4.setVisible(true);
                            break;
                        case 5:
                            datakaryawan5.setVisible(true);
                            datakaryawan5.setText(hakAkses + " :  " + nama);
                            krywn5.setVisible(true);
                            displaygambar5.setIcon(icon);
                            displaygambar5.setVisible(true);
                            btnview5.setVisible(true);
                            btnedit5.setVisible(true);
                            btnhapus5.setVisible(true);
                            break;
                        case 6:
                            datakaryawan6.setVisible(true);
                            datakaryawan6.setText(hakAkses + " :  " + nama);
                            krywn6.setVisible(true);
                            displaygambar6.setIcon(icon);
                            displaygambar6.setVisible(true);
                            btnview6.setVisible(true);
                            btnedit6.setVisible(true);
                            btnhapus6.setVisible(true);
                            break;
                        case 7:
                            datakaryawan7.setVisible(true);
                            datakaryawan7.setText(hakAkses + " :  " + nama);
                            krywn7.setVisible(true);
                            displaygambar7.setIcon(icon);
                            displaygambar7.setVisible(true);
                            btnview7.setVisible(true);
                            btnedit7.setVisible(true);
                            btnhapus7.setVisible(true);
                            break;
                        case 8:
                            datakaryawan8.setVisible(true);
                            datakaryawan8.setText(hakAkses + " :  " + nama);
                            krywn8.setVisible(true);
                            displaygambar8.setIcon(icon);
                            displaygambar8.setVisible(true);
                            btnview8.setVisible(true);
                            btnedit8.setVisible(true);
                            btnhapus8.setVisible(true);
                            break;
                        case 9:
                            datakaryawan9.setVisible(true);
                            datakaryawan9.setText(hakAkses + " :  " + nama);
                            krywn9.setVisible(true);
                            displaygambar9.setIcon(icon);
                            displaygambar9.setVisible(true);
                            btnview9.setVisible(true);
                            btnedit9.setVisible(true);
                            btnhapus9.setVisible(true);
                            break;
                        case 10:
                            datakaryawan10.setVisible(true);
                            datakaryawan10.setText(hakAkses + " :  " + nama);
                            krywn10.setVisible(true);
                            displaygambar10.setIcon(icon);
                            displaygambar10.setVisible(true);
                            btnview10.setVisible(true);
                            btnedit10.setVisible(true);
                            btnhapus10.setVisible(true);
                            break;
                        case 11:
                            datakaryawan11.setVisible(true);
                            datakaryawan11.setText(hakAkses + " :  " + nama);
                            krywn11.setVisible(true);
                            displaygambar11.setIcon(icon);
                            displaygambar11.setVisible(true);
                            btnview11.setVisible(true);
                            btnedit11.setVisible(true);
                            btnhapus11.setVisible(true);
                            break;
                        case 12:
                            datakaryawan12.setVisible(true);
                            datakaryawan12.setText(hakAkses + " :  " + nama);
                            krywn12.setVisible(true);
                            displaygambar12.setIcon(icon);
                            displaygambar12.setVisible(true);
                            btnview12 .setVisible(true);
                            btnedit12.setVisible(true);
                            btnhapus12.setVisible(true);
                            break;
                        case 13:
                            datakaryawan13.setVisible(true);
                            datakaryawan13.setText(hakAkses + " :  " + nama);
                            krywn13.setVisible(true);
                            displaygambar13.setIcon(icon);
                            displaygambar13.setVisible(true);
                            btnview13.setVisible(true);
                            btnedit13.setVisible(true);
                            btnhapus13.setVisible(true);
                            break;
                        case 14:
                            datakaryawan14.setVisible(true);
                            datakaryawan14.setText(hakAkses + " :  " + nama);
                            krywn14.setVisible(true);
                            displaygambar14.setIcon(icon);
                            displaygambar14.setVisible(true);
                            btnview14.setVisible(true);
                            btnedit14.setVisible(true);
                            btnhapus14.setVisible(true);
                            break;
                        case 15:
                            datakaryawan15.setVisible(true);
                            datakaryawan15.setText(hakAkses + " :  " + nama);
                            krywn15.setVisible(true);
                            displaygambar15.setIcon(icon);
                            displaygambar15.setVisible(true);
                            btnview15.setVisible(false);
                            btnedit15.setVisible(true);
                            btnhapus15.setVisible(true);
                            break;
                        case 16:
                            datakaryawan16.setVisible(true);
                            datakaryawan16.setText(hakAkses + " :  " + nama);
                            krywn16.setVisible(true);
                            displaygambar16.setIcon(icon);
                            displaygambar16.setVisible(true);
                            btnview16.setVisible(false);
                            btnedit16.setVisible(true);
                            btnhapus16.setVisible(true);
                            break;
                        case 17:
                            datakaryawan17.setVisible(true);
                            datakaryawan17.setText(hakAkses + " :  " + nama);
                            krywn17.setVisible(true);
                            displaygambar17.setIcon(icon);
                            displaygambar17.setVisible(true);
                            btnview17.setVisible(false);
                            btnedit17.setVisible(true);
                            btnhapus17.setVisible(true);
                            break;
                        case 18:
                            datakaryawan18.setVisible(true);
                            datakaryawan18.setText(hakAkses + " :  " + nama);
                            krywn18.setVisible(true);
                            displaygambar18.setIcon(icon);
                            displaygambar18.setVisible(true);
                            btnview18.setVisible(false);
                            btnedit18.setVisible(true);
                            btnhapus18.setVisible(true);
                            break;
                        case 19:
                            datakaryawan19.setVisible(true);
                            datakaryawan19.setText(hakAkses + " :  " + nama);
                            krywn19.setVisible(true);
                            displaygambar19.setIcon(icon);
                            displaygambar19.setVisible(true);
                            btnview19.setVisible(false);
                            btnedit19.setVisible(true);
                            btnhapus19.setVisible(true);
                            break;
                        case 20:
                            datakaryawan20.setVisible(true);
                            datakaryawan20.setText(hakAkses + " :  " + nama);
                            krywn20.setVisible(true);
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
            
           
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void kosongkanform(){
        
        inputnama.setText("NAMA KARYAWAN");
        inputnik.setText("NIK/ID");
        inputnowa.setText("NO WHATSAPP");
        inputusername.setText("USERNAME");
        btnjabatan.setText("    J A B A T A N");
        displaygambar.setIcon(null);
        displaygambar.setVisible(false);
    }
    private void removeFocusFromAllObjects(Container container) {
    container.setFocusable(false);
    for (Component child : container.getComponents()) {
        if (child instanceof Container) {
            removeFocusFromAllObjects((Container) child);
        } else {
            child.setFocusable(false);
        }
    }
}
    
    
    
    public AdminKaryawan() {
        initComponents();
        popupclose();
        verifikatorScanRfId.setText("0");
        scannik.setVisible(false);
        popupScanWait.setVisible(false);
        btnclosepopup.setVisible(false);
        labelhelpedittutup();
        tampilanbtneditfalse();
        tampilanbtnhapusfalse();
        btnEditIniEdit.setVisible(false);
        btnCancelInEdit.setVisible(false);
        PopUpEdit.setVisible(false);
        displaygambar1.setVisible(false);
        displaygambar2.setVisible(false);
        displaygambar3.setVisible(false);
        displaygambar4.setVisible(false);
        displaygambar5.setVisible(false);
        displaygambar6.setVisible(false);
        displaygambar7.setVisible(false);
        displaygambar8.setVisible(false);
        displaygambar9.setVisible(false);
        displaygambar10.setVisible(false);
        displaygambar11.setVisible(false);
        displaygambar12.setVisible(false);
        displaygambar13.setVisible(false);
        displaygambar14.setVisible(false);
        displaygambar15.setVisible(false);
        displaygambar16.setVisible(false);
        displaygambar17.setVisible(false);
        displaygambar18.setVisible(false);
        displaygambar19.setVisible(false);
        displaygambar20.setVisible(false);
        popuptutup.setVisible(false);
        popuplabel.setVisible(false);
        jPanel7.setVisible(false);    
        jPanel8.setVisible(false);    
        btnjabatanclose.setVisible(false);
        jPanel9.setVisible(false);    
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
        displaygambar.setVisible(false);
        popupjabatan.setVisible(false);
        btnwaiter.setVisible(false);
        btnkasir.setVisible(false);
        btnkoki.setVisible(false);
        krywn1.setVisible(false);
        krywn2.setVisible(false);
        krywn3.setVisible(false);
        krywn4.setVisible(false);
        krywn5.setVisible(false);
        krywn6.setVisible(false);
        krywn7.setVisible(false);
        krywn8.setVisible(false);
        krywn9.setVisible(false);
        krywn10.setVisible(false);
        krywn11.setVisible(false);
        krywn12.setVisible(false);
        krywn13.setVisible(false);
        krywn14.setVisible(false);
        krywn15.setVisible(false);
        krywn16.setVisible(false);
        krywn17.setVisible(false);
        krywn18.setVisible(false);
        krywn19.setVisible(false);
        krywn20.setVisible(false);
        datakaryawan1.setVisible(false);
        datakaryawan2.setVisible(false);
        datakaryawan3.setVisible(false);
        datakaryawan4.setVisible(false);
        datakaryawan5.setVisible(false);
        datakaryawan6.setVisible(false);
        datakaryawan7.setVisible(false);
        datakaryawan8.setVisible(false);
        datakaryawan9.setVisible(false);
        datakaryawan10.setVisible(false);
        datakaryawan11.setVisible(false);
        datakaryawan12.setVisible(false);
        datakaryawan13.setVisible(false);
        datakaryawan14.setVisible(false);
        datakaryawan15.setVisible(false);
        datakaryawan16.setVisible(false);
        datakaryawan17.setVisible(false);
        datakaryawan18.setVisible(false);
        datakaryawan19.setVisible(false);
        datakaryawan20.setVisible(false);
        submit.setVisible(true);
        tampilkandata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scannik = new javax.swing.JTextField();
        btnclosepopup = new javax.swing.JPanel();
        popupScanWait = new javax.swing.JLabel();
        btnDirectWA = new javax.swing.JPanel();
        popupclose = new javax.swing.JPanel();
        popuptxtnama = new javax.swing.JLabel();
        popuptxtnik = new javax.swing.JLabel();
        popuptxtnowa = new javax.swing.JLabel();
        popuptxtusername = new javax.swing.JLabel();
        popuptxtjabatan = new javax.swing.JLabel();
        popupdisplaygambar = new javax.swing.JLabel();
        popupinfokaryawan = new javax.swing.JLabel();
        backpopup = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        popuptutup = new javax.swing.JPanel();
        popuplabel = new javax.swing.JLabel();
        popup = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        displaygambar = new javax.swing.JLabel();
        labelnamakaryawan = new javax.swing.JLabel();
        labelnik = new javax.swing.JLabel();
        labelusername = new javax.swing.JLabel();
        labelnowa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        inputusername = new javax.swing.JTextField();
        inputnama = new javax.swing.JTextField();
        inputnowa = new javax.swing.JTextField();
        inputnik = new javax.swing.JTextField();
        btnwaiter = new javax.swing.JPanel();
        btnkasir = new javax.swing.JPanel();
        btnkoki = new javax.swing.JPanel();
        btnjabatanclose = new javax.swing.JPanel();
        btnEditIniEdit = new javax.swing.JPanel();
        btnCancelInEdit = new javax.swing.JPanel();
        popupjabatan = new javax.swing.JLabel();
        labelTambahRfId = new javax.swing.JLabel();
        btnjabatan = new javax.swing.JLabel();
        btnjabatan2 = new javax.swing.JPanel();
        PopUpEdit = new javax.swing.JLabel();
        submit = new javax.swing.JPanel();
        pilihgambar = new javax.swing.JPanel();
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
        datakaryawan2 = new javax.swing.JLabel();
        datakaryawan3 = new javax.swing.JLabel();
        datakaryawan4 = new javax.swing.JLabel();
        datakaryawan5 = new javax.swing.JLabel();
        datakaryawan6 = new javax.swing.JLabel();
        datakaryawan7 = new javax.swing.JLabel();
        datakaryawan8 = new javax.swing.JLabel();
        datakaryawan9 = new javax.swing.JLabel();
        datakaryawan10 = new javax.swing.JLabel();
        datakaryawan11 = new javax.swing.JLabel();
        datakaryawan12 = new javax.swing.JLabel();
        datakaryawan13 = new javax.swing.JLabel();
        datakaryawan14 = new javax.swing.JLabel();
        datakaryawan15 = new javax.swing.JLabel();
        datakaryawan16 = new javax.swing.JLabel();
        datakaryawan17 = new javax.swing.JLabel();
        datakaryawan18 = new javax.swing.JLabel();
        datakaryawan19 = new javax.swing.JLabel();
        datakaryawan20 = new javax.swing.JLabel();
        datakaryawan1 = new javax.swing.JLabel();
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
        krywn20 = new javax.swing.JLabel();
        krywn19 = new javax.swing.JLabel();
        krywn18 = new javax.swing.JLabel();
        krywn17 = new javax.swing.JLabel();
        krywn16 = new javax.swing.JLabel();
        krywn15 = new javax.swing.JLabel();
        krywn14 = new javax.swing.JLabel();
        krywn13 = new javax.swing.JLabel();
        krywn12 = new javax.swing.JLabel();
        krywn11 = new javax.swing.JLabel();
        krywn10 = new javax.swing.JLabel();
        krywn9 = new javax.swing.JLabel();
        krywn8 = new javax.swing.JLabel();
        krywn7 = new javax.swing.JLabel();
        krywn6 = new javax.swing.JLabel();
        krywn5 = new javax.swing.JLabel();
        krywn4 = new javax.swing.JLabel();
        krywn3 = new javax.swing.JLabel();
        krywn2 = new javax.swing.JLabel();
        krywn1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        gambarTextField = new javax.swing.JLabel();
        inputRfID = new javax.swing.JTextField();
        verifikatorScanRfId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scannik.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scannik.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        scannik.setHighlighter(null);
        scannik.setSelectionColor(new java.awt.Color(255, 255, 255));
        scannik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scannikActionPerformed(evt);
            }
        });
        getContentPane().add(scannik, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 220, -1));

        btnclosepopup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclosepopup.setOpaque(false);
        btnclosepopup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclosepopupMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnclosepopupLayout = new javax.swing.GroupLayout(btnclosepopup);
        btnclosepopup.setLayout(btnclosepopupLayout);
        btnclosepopupLayout.setHorizontalGroup(
            btnclosepopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        btnclosepopupLayout.setVerticalGroup(
            btnclosepopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(btnclosepopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 110, 70, 70));

        popupScanWait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login/menunggu scan.png"))); // NOI18N
        getContentPane().add(popupScanWait, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -270, -1, -1));

        btnDirectWA.setOpaque(false);
        btnDirectWA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDirectWAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnDirectWALayout = new javax.swing.GroupLayout(btnDirectWA);
        btnDirectWA.setLayout(btnDirectWALayout);
        btnDirectWALayout.setHorizontalGroup(
            btnDirectWALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        btnDirectWALayout.setVerticalGroup(
            btnDirectWALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        getContentPane().add(btnDirectWA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 532, 60, 62));

        popupclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popupclose.setOpaque(false);
        popupclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popupcloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout popupcloseLayout = new javax.swing.GroupLayout(popupclose);
        popupclose.setLayout(popupcloseLayout);
        popupcloseLayout.setHorizontalGroup(
            popupcloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        popupcloseLayout.setVerticalGroup(
            popupcloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(popupclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 240, 40, 40));

        popuptxtnama.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtnama.setText("Nama: Fuad Adhim Al Hasan");
        getContentPane().add(popuptxtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 321, -1, -1));

        popuptxtnik.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtnik.setText("NIK: 351231293122");
        getContentPane().add(popuptxtnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 385, -1, -1));

        popuptxtnowa.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtnowa.setText("No WA: 08784012931");
        getContentPane().add(popuptxtnowa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        popuptxtusername.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtusername.setText("Username: fuadadhim24");
        getContentPane().add(popuptxtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, -1, -1));

        popuptxtjabatan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        popuptxtjabatan.setText("Jabatan: KASIR");
        getContentPane().add(popuptxtjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 513, -1, -1));
        getContentPane().add(popupdisplaygambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 372, 150, 200));

        popupinfokaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popup info karyawan.png"))); // NOI18N
        getContentPane().add(popupinfokaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, -40, -1, -1));

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

        getContentPane().add(backpopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 770));

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

        popuplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popupkaryawan.png"))); // NOI18N
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
            .addGap(0, 50, Short.MAX_VALUE)
        );
        popupLayout.setVerticalGroup(
            popupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(popup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(null);
        jPanel1.add(displaygambar);
        displaygambar.setBounds(250, 130, 100, 130);

        labelnamakaryawan.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 13)); // NOI18N
        labelnamakaryawan.setText("Nama Karyawan");
        labelnamakaryawan.setOpaque(true);
        jPanel1.add(labelnamakaryawan);
        labelnamakaryawan.setBounds(400, 330, 109, 18);

        labelnik.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 13)); // NOI18N
        labelnik.setText("NIK/ID");
        labelnik.setOpaque(true);
        jPanel1.add(labelnik);
        labelnik.setBounds(400, 390, 44, 18);

        labelusername.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 13)); // NOI18N
        labelusername.setText("Username");
        labelusername.setOpaque(true);
        jPanel1.add(labelusername);
        labelusername.setBounds(400, 450, 67, 18);

        labelnowa.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 13)); // NOI18N
        labelnowa.setText("No Whatsapp");
        labelnowa.setOpaque(true);
        jPanel1.add(labelnowa);
        labelnowa.setBounds(400, 510, 91, 18);

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

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 70, 56, 48);

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setOpaque(false);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

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

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 145, 56, 48);

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setOpaque(false);

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

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 220, 56, 48);

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

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 288, 56, 48);

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

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 690, 56, 48);

        inputusername.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        inputusername.setForeground(new java.awt.Color(255, 102, 102));
        inputusername.setText("USERNAME");
        inputusername.setBorder(null);
        inputusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputusernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputusernameFocusLost(evt);
            }
        });
        inputusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputusernameMouseClicked(evt);
            }
        });
        inputusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputusernameActionPerformed(evt);
            }
        });
        jPanel1.add(inputusername);
        inputusername.setBounds(140, 440, 310, 40);

        inputnama.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        inputnama.setForeground(new java.awt.Color(255, 102, 102));
        inputnama.setText("NAMA KARYAWAN");
        inputnama.setBorder(null);
        inputnama.setName(""); // NOI18N
        inputnama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputnamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputnamaFocusLost(evt);
            }
        });
        inputnama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputnamaMouseClicked(evt);
            }
        });
        inputnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputnamaActionPerformed(evt);
            }
        });
        jPanel1.add(inputnama);
        inputnama.setBounds(140, 320, 310, 40);

        inputnowa.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        inputnowa.setForeground(new java.awt.Color(255, 102, 102));
        inputnowa.setText("NO WHATSAPP");
        inputnowa.setBorder(null);
        inputnowa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputnowaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputnowaFocusLost(evt);
            }
        });
        inputnowa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputnowaMouseClicked(evt);
            }
        });
        inputnowa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputnowaActionPerformed(evt);
            }
        });
        jPanel1.add(inputnowa);
        inputnowa.setBounds(140, 500, 320, 40);

        inputnik.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 16)); // NOI18N
        inputnik.setForeground(new java.awt.Color(255, 102, 102));
        inputnik.setText("NIK/ID");
        inputnik.setBorder(null);
        inputnik.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputnikFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputnikFocusLost(evt);
            }
        });
        inputnik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputnikMouseClicked(evt);
            }
        });
        inputnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputnikActionPerformed(evt);
            }
        });
        jPanel1.add(inputnik);
        inputnik.setBounds(140, 380, 310, 40);

        labelnama1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelnama1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelnama1.setToolTipText("");
        labelnama1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(labelnama1);
        labelnama1.setBounds(440, 8, 670, 20);

        btnwaiter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnwaiter.setOpaque(false);
        btnwaiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnwaiterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnwaiterLayout = new javax.swing.GroupLayout(btnwaiter);
        btnwaiter.setLayout(btnwaiterLayout);
        btnwaiterLayout.setHorizontalGroup(
            btnwaiterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        btnwaiterLayout.setVerticalGroup(
            btnwaiterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.add(btnwaiter);
        btnwaiter.setBounds(122, 650, 350, 28);

        btnkasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnkasir.setOpaque(false);
        btnkasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkasirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnkasirLayout = new javax.swing.GroupLayout(btnkasir);
        btnkasir.setLayout(btnkasirLayout);
        btnkasirLayout.setHorizontalGroup(
            btnkasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        btnkasirLayout.setVerticalGroup(
            btnkasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.add(btnkasir);
        btnkasir.setBounds(122, 593, 350, 28);

        btnkoki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnkoki.setOpaque(false);
        btnkoki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkokiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnkokiLayout = new javax.swing.GroupLayout(btnkoki);
        btnkoki.setLayout(btnkokiLayout);
        btnkokiLayout.setHorizontalGroup(
            btnkokiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        btnkokiLayout.setVerticalGroup(
            btnkokiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.add(btnkoki);
        btnkoki.setBounds(122, 622, 350, 27);

        btnjabatanclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnjabatanclose.setOpaque(false);
        btnjabatanclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjabatancloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnjabatancloseLayout = new javax.swing.GroupLayout(btnjabatanclose);
        btnjabatanclose.setLayout(btnjabatancloseLayout);
        btnjabatancloseLayout.setHorizontalGroup(
            btnjabatancloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        btnjabatancloseLayout.setVerticalGroup(
            btnjabatancloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(btnjabatanclose);
        btnjabatanclose.setBounds(122, 558, 350, 30);

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
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(btnEditIniEdit);
        btnEditIniEdit.setBounds(300, 664, 180, 60);

        btnCancelInEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelInEdit.setOpaque(false);
        btnCancelInEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelInEditMouseClicked(evt);
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
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(btnCancelInEdit);
        btnCancelInEdit.setBounds(110, 664, 180, 60);

        popupjabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popupjabatan.png"))); // NOI18N
        jPanel1.add(popupjabatan);
        popupjabatan.setBounds(23, 455, 550, 323);

        labelTambahRfId.setText("ingin menambahkan rf id?");
        labelTambahRfId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelTambahRfId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelTambahRfIdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelTambahRfIdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelTambahRfIdMouseExited(evt);
            }
        });
        jPanel1.add(labelTambahRfId);
        labelTambahRfId.setBounds(225, 618, 270, 16);

        btnjabatan.setBackground(new java.awt.Color(255, 255, 255));
        btnjabatan.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        btnjabatan.setForeground(new java.awt.Color(255, 102, 102));
        btnjabatan.setText("    J A B A T A N");
        btnjabatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnjabatan.setOpaque(true);
        btnjabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjabatanMouseClicked(evt);
            }
        });
        jPanel1.add(btnjabatan);
        btnjabatan.setBounds(126, 560, 310, 30);

        btnjabatan2.setOpaque(false);
        btnjabatan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnjabatan2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnjabatan2Layout = new javax.swing.GroupLayout(btnjabatan2);
        btnjabatan2.setLayout(btnjabatan2Layout);
        btnjabatan2Layout.setHorizontalGroup(
            btnjabatan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        btnjabatan2Layout.setVerticalGroup(
            btnjabatan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel1.add(btnjabatan2);
        btnjabatan2.setBounds(437, 557, 35, 37);

        PopUpEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/button edit karyawan.png"))); // NOI18N
        jPanel1.add(PopUpEdit);
        PopUpEdit.setBounds(50, 645, 501, 80);

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
            .addGap(0, 180, Short.MAX_VALUE)
        );
        submitLayout.setVerticalGroup(
            submitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(submit);
        submit.setBounds(210, 660, 180, 60);

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
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pilihgambar);
        pilihgambar.setBounds(130, 270, 340, 30);

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

        datakaryawan2.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan2.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan2.setOpaque(true);
        jPanel13.add(datakaryawan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 470, 40));

        datakaryawan3.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan3.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan3.setOpaque(true);
        jPanel13.add(datakaryawan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 161, 470, 40));

        datakaryawan4.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan4.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan4.setOpaque(true);
        jPanel13.add(datakaryawan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 232, 470, 40));

        datakaryawan5.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan5.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan5.setOpaque(true);
        jPanel13.add(datakaryawan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 303, 470, 40));

        datakaryawan6.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan6.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan6.setOpaque(true);
        jPanel13.add(datakaryawan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 374, 470, 40));

        datakaryawan7.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan7.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan7.setOpaque(true);
        jPanel13.add(datakaryawan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 445, 470, 40));

        datakaryawan8.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan8.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan8.setOpaque(true);
        jPanel13.add(datakaryawan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 516, 470, 40));

        datakaryawan9.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan9.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan9.setOpaque(true);
        jPanel13.add(datakaryawan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 587, 470, 40));

        datakaryawan10.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan10.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan10.setOpaque(true);
        jPanel13.add(datakaryawan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 658, 470, 40));

        datakaryawan11.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan11.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan11.setOpaque(true);
        jPanel13.add(datakaryawan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 729, 470, 40));

        datakaryawan12.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan12.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan12.setOpaque(true);
        jPanel13.add(datakaryawan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 800, 470, 40));

        datakaryawan13.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan13.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan13.setOpaque(true);
        jPanel13.add(datakaryawan13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 871, 470, 40));

        datakaryawan14.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan14.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan14.setOpaque(true);
        jPanel13.add(datakaryawan14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 942, 470, 40));

        datakaryawan15.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan15.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan15.setOpaque(true);
        jPanel13.add(datakaryawan15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1013, 470, 40));

        datakaryawan16.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan16.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan16.setOpaque(true);
        jPanel13.add(datakaryawan16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1084, 470, 40));

        datakaryawan17.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan17.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan17.setOpaque(true);
        jPanel13.add(datakaryawan17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1155, 470, 40));

        datakaryawan18.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan18.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan18.setOpaque(true);
        jPanel13.add(datakaryawan18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1226, 470, 40));

        datakaryawan19.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan19.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan19.setOpaque(true);
        jPanel13.add(datakaryawan19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1297, 470, 40));

        datakaryawan20.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan20.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan20.setOpaque(true);
        jPanel13.add(datakaryawan20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1368, 470, 40));

        datakaryawan1.setBackground(new java.awt.Color(255, 255, 255));
        datakaryawan1.setFont(new java.awt.Font("TeXGyreAdventor", 0, 28)); // NOI18N
        datakaryawan1.setOpaque(true);
        jPanel13.add(datakaryawan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 18, 470, 40));

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

        krywn20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1249, -1, -1));

        krywn19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1178, -1, -1));

        krywn18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1107, -1, -1));

        krywn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1036, -1, -1));

        krywn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 965, -1, -1));

        krywn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 894, -1, -1));

        krywn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 823, -1, -1));

        krywn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 752, -1, -1));

        krywn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 681, -1, -1));

        krywn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 610, -1, -1));

        krywn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 539, -1, -1));

        krywn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 468, -1, -1));

        krywn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 397, -1, -1));

        krywn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 326, -1, -1));

        krywn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 255, -1, -1));

        krywn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 184, -1, -1));

        krywn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 113, -1, -1));

        krywn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 42, -1, -1));

        krywn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listuniversalkaryawan.png"))); // NOI18N
        jPanel13.add(krywn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -29, -1, -1));

        krywn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/listadminkaryawan.png"))); // NOI18N
        jPanel13.add(krywn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -100, -1, -1));

        jScrollPane1.setViewportView(jPanel13);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(550, 170, 795, 550);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/3.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1366, 768);
        jPanel1.add(gambarTextField);
        gambarTextField.setBounds(700, 230, 140, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        inputRfID.setText("jTextField1");
        inputRfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRfIDActionPerformed(evt);
            }
        });
        getContentPane().add(inputRfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        verifikatorScanRfId.setText("jTextField1");
        getContentPane().add(verifikatorScanRfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        this.setVisible(false);
        new AdminPenjualan().setVisible(true);
        
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        this.setVisible(false);
        new AdminMenu().setVisible(true);
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.setVisible(false);
        try {
            new AdminPesanan().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        this.setVisible(false);
        new MainDisplay().setVisible(true);
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void inputnamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputnamaFocusGained
        
    }//GEN-LAST:event_inputnamaFocusGained

    private void inputnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputnamaActionPerformed

    private void inputnowaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputnowaFocusGained
        inputnowa.setText(null);
    }//GEN-LAST:event_inputnowaFocusGained

    private void inputnowaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputnowaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputnowaActionPerformed

    private void inputnikFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputnikFocusGained
        inputnik.setText(null);
        inputnik.setForeground(Color.BLUE);
    }//GEN-LAST:event_inputnikFocusGained

    private void inputnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputnikActionPerformed
    
    }//GEN-LAST:event_inputnikActionPerformed

    private void inputusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputusernameActionPerformed

    private void inputusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputusernameFocusGained
        inputusername.setText(null);
    }//GEN-LAST:event_inputusernameFocusGained

    private void inputnamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputnamaMouseClicked
        inputnama.setText(null);
        inputnama.setForeground(Color.BLUE);
    }//GEN-LAST:event_inputnamaMouseClicked

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

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        this.setVisible(false);
        new AdminPenjualan().setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
    boolean checkRfId = labelTambahRfId.getText()=="ingin menambahkan rf id?";
        if(checkRfId==true){
            java.sql.Connection conn = null;
            try {
            // Baca data dari JTextField
            String nik = inputnik.getText();
            String nama = inputnama.getText();
            String username = inputusername.getText();
            String noWa = inputnowa.getText();
            String jabatan = btnjabatan.getText();
            String tanpaspasijabatan = jabatan.replaceAll("\\s+", "");
            String filename = gambarTextField.getText();

            // Memeriksa apakah semua kolom telah diisi
            if (nik.isEmpty() || nama.isEmpty() || username.isEmpty() || noWa.isEmpty() || filename.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi.");
                return; // Keluar dari metode jika ada kolom yang kosong
            }


            // Baca file gambar ke dalam byte array
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageBytes = new byte[(int) file.length()];
            fis.read(imageBytes);
            fis.close();

            // Koneksi ke database
            conn = (Connection)Config.configDB();

            // Memulai transaksi
            conn.setAutoCommit(false);

            // Siapkan statement untuk insert data ke tabel
            String sql = "INSERT INTO `akun` (`nik/id`, `username`, `password`, `hak_akses`) VALUES ('"+nik+"', '"+username+"', NULL, '"+tanpaspasijabatan+"');";
            String sql1 = "INSERT INTO `detail_akun` (`nik/id`, `nama`, `no_wa`, `foto`) VALUES (?, ?, ?, ?);";

            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setString(1, nik);
            pstm1.setString(2, nama);
            pstm1.setString(3, noWa);
            pstm1.setBytes(4, imageBytes);

            // Jalankan statement
            pstm.executeUpdate();
            pstm1.executeUpdate();

            // Commit transaksi jika tidak ada kesalahan
            conn.commit();

            JOptionPane.showMessageDialog(null, "Data berhasil diupload ke database");
            kosongkanform();
            tampilkandata();

            pstm1.close();
            pstm.close();

        } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminKaryawan.class.getName()).log(Level.SEVERE, null, ex);
                }
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
        }else if(checkRfId==false){
            java.sql.Connection conn = null;
            try {
            // Baca data dari JTextField
            String nik = inputnik.getText();
            String nama = inputnama.getText();
            String username = inputusername.getText();
            String noWa = inputnowa.getText();
            String jabatan = btnjabatan.getText();
            String tanpaspasijabatan = jabatan.replaceAll("\\s+", "");
            String filename = gambarTextField.getText();
            String rfId = null;
            rfId = inputRfID.getText();

            // Memeriksa apakah semua kolom telah diisi
            if (nik.isEmpty() || nama.isEmpty() || username.isEmpty() || noWa.isEmpty() || filename.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi.");
                return; // Keluar dari metode jika ada kolom yang kosong
            }


            // Baca file gambar ke dalam byte array
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageBytes = new byte[(int) file.length()];
            fis.read(imageBytes);
            fis.close();

            // Koneksi ke database
            conn = (Connection)Config.configDB();

            // Memulai transaksi
            conn.setAutoCommit(false);

            // Siapkan statement untuk insert data ke tabel
            String sql = "INSERT INTO `akun` (`nik/id`, `username`, `password`, `hak_akses`) VALUES ('"+nik+"', '"+username+"', NULL, '"+tanpaspasijabatan+"');";
            String sql1 = "INSERT INTO `detail_akun` (`nik/id`, `nama`, `no_wa`, `foto`,`rf_id`) VALUES (?, ?, ?, ?);";

            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.setString(1, nik);
            pstm1.setString(2, nama);
            pstm1.setString(3, noWa);
            pstm1.setBytes(4, imageBytes);
            pstm1.setString(5, rfId);

            // Jalankan statement
            pstm.executeUpdate();
            pstm1.executeUpdate();

            // Commit transaksi jika tidak ada kesalahan
            conn.commit();

            JOptionPane.showMessageDialog(null, "Data berhasil diupload ke database");
            kosongkanform();
            tampilkandata();

            pstm1.close();
            pstm.close();

        } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminKaryawan.class.getName()).log(Level.SEVERE, null, ex);
                }
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
            
        }

    }//GEN-LAST:event_submitMouseClicked

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

    private void btnjabatancloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjabatancloseMouseClicked
        popupjabatan.setVisible(false);
        btnjabatan.setVisible(true);
        btnjabatanclose.setVisible(false);
        btnkasir.setVisible(false);
        btnkoki.setVisible(false);
        btnwaiter.setVisible(false);
    }//GEN-LAST:event_btnjabatancloseMouseClicked

    private void btnjabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjabatanMouseClicked
        if(btnjabatan.getText()==" ADMIN"){
            JOptionPane.showMessageDialog(this, "Jabatan Admin tidak dapat dirubah");
        }else{
        popupjabatan.setVisible(true);
        btnjabatanclose.setVisible(true);
        btnjabatan.setVisible(false);
        btnjabatan2.setVisible(false);
        btnkasir.setVisible(true);
        btnkoki.setVisible(true);
        btnwaiter.setVisible(true);}
        
        
    }//GEN-LAST:event_btnjabatanMouseClicked

    private void btnkasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkasirMouseClicked
        btnjabatan.setText("    K A S I R");
        popupjabatan.setVisible(false);
        btnjabatan.setVisible(true);
        btnjabatanclose.setVisible(false);
        btnkasir.setVisible(false);
        btnkoki.setVisible(false);
        btnwaiter.setVisible(false);
    }//GEN-LAST:event_btnkasirMouseClicked

    private void btnkokiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkokiMouseClicked
        btnjabatan.setText("    K O K I");
        popupjabatan.setVisible(false);
        btnjabatan.setVisible(true);
        btnjabatanclose.setVisible(false);
        btnkasir.setVisible(false);
        btnkoki.setVisible(false);
        btnwaiter.setVisible(false);
    }//GEN-LAST:event_btnkokiMouseClicked

    private void btnwaiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnwaiterMouseClicked
        btnjabatan.setText("    W A I T E R");
        popupjabatan.setVisible(false);
        btnjabatan.setVisible(true);
        btnjabatanclose.setVisible(false);
        btnkasir.setVisible(false);
        btnkoki.setVisible(false);
        btnwaiter.setVisible(false);
    }//GEN-LAST:event_btnwaiterMouseClicked

    private void btnedit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit1MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        inputnik.setFocusable(false);
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                btnjabatan.setText(" ADMIN");   
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }//GEN-LAST:event_btnedit1MouseClicked

    private void btnedit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit2MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    
        
    }//GEN-LAST:event_btnedit2MouseClicked

    private void btnedit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit3MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 2;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    
        
    }//GEN-LAST:event_btnedit3MouseClicked

    private void btnCancelInEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelInEditMouseClicked
        kosongkanform();
        labelhelpedittutup();
        PopUpEdit.setVisible(false);
        btnEditIniEdit.setVisible(false);
        btnCancelInEdit.setVisible(false);
        scannik.setText(null);
        labelTambahRfId.setText(null);
        labelTambahRfId.setText("ingin menambahkan rf id?");
        inputRfID.setText(null);
    }//GEN-LAST:event_btnCancelInEditMouseClicked

    private void btnEditIniEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditIniEditMouseClicked
    boolean checkRfId = labelTambahRfId.getText()=="ingin menambahkan rf id?";
    if(checkRfId==true){
        try {
            String jabatan = btnjabatan.getText();
            String tanpaspasijabatan = jabatan.replaceAll("\\s+", "");
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
            String sql = "UPDATE `akun` SET `username` = '"+inputusername.getText()+"', `hak_akses` = '" + tanpaspasijabatan + "' WHERE `akun`.`nik/id` = '" + inputnik.getText() + "';";
            String sql1 = "UPDATE `detail_akun` SET `nama` = '" + inputnama.getText() + "', `no_wa` = '" + inputnowa.getText() + "', `foto` = ? WHERE `detail_akun`.`nik/id` = '" + inputnik.getText() + "';";  
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);

            // Mengatur parameter untuk gambar sebagai byte array
            pstm1.setBytes(1, fotoBytes);

            // Menjalankan perintah update
            pstm.executeUpdate();
            pstm1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil...");

            labelhelpedittutup();

            tampilkandata();
            kosongkanform();


            pstm1.close();
            scannik.setText(null);
            inputRfID.setText(null);
            labelTambahRfId.setText(null);
            labelTambahRfId.setText("ingin menambahkan rf id?");
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }}else if(checkRfId==false){
        try {
            String jabatan = btnjabatan.getText();
            String tanpaspasijabatan = jabatan.replaceAll("\\s+", "");
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
            String sql = "UPDATE `akun` SET `username` = '"+inputusername.getText()+"', `hak_akses` = '" + tanpaspasijabatan + "' WHERE `akun`.`nik/id` = '" + inputnik.getText() + "';";
            String sql1 = "UPDATE `detail_akun` SET `rf_id` ='"+inputRfID.getText()+"', `nama` = '" + inputnama.getText() + "', `no_wa` = '" + inputnowa.getText() + "', `foto` = ? WHERE `detail_akun`.`nik/id` = '" + inputnik.getText() + "';";  
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);

            // Mengatur parameter untuk gambar sebagai byte array
            pstm1.setBytes(1, fotoBytes);

            // Menjalankan perintah update
            pstm.executeUpdate();
            pstm1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil...");

            labelhelpedittutup();

            tampilkandata();
            kosongkanform();


            pstm1.close();
            scannik.setText(null);
            inputRfID.setText(null);
            labelTambahRfId.setText(null);
            labelTambahRfId.setText("ingin menambahkan rf id?");
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
        
    }
    }//GEN-LAST:event_btnEditIniEditMouseClicked

    private void inputnikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputnikMouseClicked
        if (!inputnik.isFocusable()) {
            JOptionPane.showMessageDialog(null, "NIK tidak dapat dirubah. Silahkan buat data karyawan baru.");
        }
    }//GEN-LAST:event_inputnikMouseClicked

    private void inputnamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputnamaFocusLost
        inputnama.setForeground(Color.red);
        if (inputnama.getText() == null || inputnama.getText().isEmpty()) {
                
                inputnama.setText("NAMA KARYAWAN");
            }
        
    }//GEN-LAST:event_inputnamaFocusLost

    private void inputnikFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputnikFocusLost
        inputnik.setForeground(Color.red);
        if (inputnik.getText() == null || inputnik.getText().isEmpty()) {
                
                inputnik.setText("NIK/ID");
            }
        
    }//GEN-LAST:event_inputnikFocusLost

    private void inputusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputusernameFocusLost
        inputusername.setForeground(Color.red);
        if (inputusername.getText() == null || inputusername.getText().isEmpty()) {
                
                inputusername.setText("USERNAME");
            }
        
    }//GEN-LAST:event_inputusernameFocusLost

    private void inputnowaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputnowaFocusLost
        inputnowa.setForeground(Color.red); 
        if (inputnowa.getText() == null || inputnowa.getText().isEmpty()) {
                
                inputnowa.setText("NO WHATSAPP");
            }
        
    }//GEN-LAST:event_inputnowaFocusLost

    private void btnhapus3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus3MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 2;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus3MouseClicked

    private void btnhapus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus2MouseClicked
        
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
            pstmdel.close();
            pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus2MouseClicked

    private void btnhapus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus1MouseClicked
        JOptionPane.showMessageDialog(this, "akun admin tidak dapat dihapus");
    }//GEN-LAST:event_btnhapus1MouseClicked

    private void btnedit4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit4MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 3;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit4MouseClicked

    private void btnedit5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit5MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 4;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit5MouseClicked

    private void btnedit6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit6MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 5;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit6MouseClicked

    private void btnedit7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit7MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 6;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit7MouseClicked

    private void btnedit8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit8MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 7;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit8MouseClicked

    private void btnedit9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit9MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 8;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit9MouseClicked

    private void btnedit10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit10MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 9;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit10MouseClicked

    private void btnedit11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit11MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 10;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit11MouseClicked

    private void btnedit12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit12MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 11;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit12MouseClicked

    private void btnedit13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit13MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 12;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit13MouseClicked

    private void btnedit14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit14MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 13;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit14MouseClicked

    private void btnedit15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit15MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 14;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit15MouseClicked

    private void btnedit16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit16MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 15;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit16MouseClicked

    private void btnedit17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit17MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 16;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit17MouseClicked

    private void btnedit18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit18MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 17;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit18MouseClicked

    private void btnedit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit19MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 18;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit19MouseClicked

    private void btnedit20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnedit20MouseClicked
        kosongkanform();
        labelhelpeditbuka();
        
        //set nik false focusable
        
        try {
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') " +
            "LIMIT 1 OFFSET 19;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                inputnik.setText(rs.getString(1));
                inputusername.setText(rs.getString(2));
                btnjabatan.setText(rs.getString(4));
                inputnama.setText(rs.getString(6));
                inputnowa.setText(rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(displaygambar.getWidth(), displaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                displaygambar.setIcon(ic);
                displaygambar.setVisible(true);
                
            }
            
            
           

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnedit20MouseClicked

    private void btnhapus4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus4MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 3;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus4MouseClicked

    private void btnhapus5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus5MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 4;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus5MouseClicked

    private void btnhapus6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus6MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 5;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus6MouseClicked

    private void btnhapus7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus7MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 6;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus7MouseClicked

    private void btnhapus8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus8MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 7;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus8MouseClicked

    private void btnhapus9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus9MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 8;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus9MouseClicked

    private void btnhapus10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus10MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 9;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus10MouseClicked

    private void btnhapus11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus11MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 10;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus11MouseClicked

    private void btnhapus12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus12MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 11;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
            
           
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus12MouseClicked

    private void btnhapus13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus13MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 12;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus13MouseClicked

    private void btnhapus14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus14MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 13;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus14MouseClicked

    private void btnhapus15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus15MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 14;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus15MouseClicked

    private void btnhapus16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus16MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 15;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus16MouseClicked

    private void btnhapus17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus17MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 16;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus17MouseClicked

    private void btnhapus18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus18MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 17;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus18MouseClicked

    private void btnhapus19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus19MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 18;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus19MouseClicked

    private void btnhapus20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapus20MouseClicked
        try{
            String nik = null;
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter')\n" +
            "LIMIT 1 OFFSET 19;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                nik=rs.getString(1);
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus akun ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

            // Hapus data pada tabel detail_akun
                String sqldel="DELETE FROM detail_akun WHERE `detail_akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel = conn.prepareStatement(sqldel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel.execute();

            // Hapus data pada tabel akun
                String sqldel2="DELETE FROM akun WHERE `akun`.`nik/id` = '"+nik+"'";
                java.sql.PreparedStatement pstmdel2 = conn.prepareStatement(sqldel2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstmdel2.execute();
            // Tampilkan pesan berhasil dihapus
                JOptionPane.showMessageDialog(this, "Akun telah dihapus");
                tampilkandata();
                pstmdel.close();
                pstmdel2.close();
            }
            
           
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapus20MouseClicked

    private void btnview20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview20MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 19;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview20MouseClicked

    private void btnview19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview19MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 18;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
                
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview19MouseClicked

    private void btnview18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview18MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 17;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
                
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview18MouseClicked

    private void btnview17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview17MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 16;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
                
                
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview17MouseClicked

    private void btnview16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview16MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 15;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview16MouseClicked

    private void btnview15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview15MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 14;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview15MouseClicked

    private void btnview14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview14MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 13;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview14MouseClicked

    private void btnview13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview13MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 12;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview13MouseClicked

    private void btnview12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview12MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 11;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview12MouseClicked

    private void btnview11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview11MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 10;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview11MouseClicked

    private void btnview10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview10MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 9;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview10MouseClicked

    private void btnview9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview9MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 8;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview9MouseClicked

    private void btnview8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview8MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 7;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview8MouseClicked

    private void btnview7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview7MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 6;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview7MouseClicked

    private void btnview6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview6MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 5;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview6MouseClicked

    private void btnview5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview5MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 4;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview5MouseClicked

    private void btnview4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview4MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 3;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview4MouseClicked

    private void btnview3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview3MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 2;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview3MouseClicked

    private void btnview2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview2MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1 OFFSET 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }//GEN-LAST:event_btnview2MouseClicked

    private void btnview1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnview1MouseClicked
        try {
            popupopen();
            String sql = "SELECT *\n" +
            "FROM akun\n" +
            "INNER JOIN detail_akun ON akun.`nik/id` = detail_akun.`nik/id`\n" +
            "ORDER BY FIELD(hak_akses, 'admin', 'kasir', 'koki', 'waiter') LIMIT 1;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs = pstm.executeQuery(sql);

            while (rs.next()) {
                popuptxtnik.setText("NIK/ID: "+rs.getString(1));
                popuptxtusername.setText("Username: "+rs.getString(2));
                popuptxtjabatan.setText("Jabatan: "+rs.getString(4));
                popuptxtnama.setText("Nama: "+rs.getString(6));
                popuptxtnowa.setText("No WA: "+rs.getString(7));
                byte[] fotoBytes = rs.getBytes(8);
                //gambarTextField.setText(filename);
                ImageIcon icon = new ImageIcon(fotoBytes);
                //convert image
                Image img = icon.getImage().getScaledInstance(popupdisplaygambar.getWidth(), popupdisplaygambar.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);

                popupdisplaygambar.setIcon(ic);
                btnjabatan.setText(" ADMIN");
                
            }
            
           
            

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnview1MouseClicked

    private void popupcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popupcloseMouseClicked
        popupclose();
    }//GEN-LAST:event_popupcloseMouseClicked

    private void inputusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputusernameMouseClicked
        inputusername.setForeground(Color.BLUE);
    }//GEN-LAST:event_inputusernameMouseClicked

    private void inputnowaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputnowaMouseClicked
        inputnowa.setForeground(Color.BLUE);
    }//GEN-LAST:event_inputnowaMouseClicked

    private void btnDirectWAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDirectWAMouseClicked
        openWhatsAppDirectLink();
    }//GEN-LAST:event_btnDirectWAMouseClicked

    private void btnjabatan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnjabatan2MouseClicked
        if(btnjabatan.getText()==" ADMIN"){
            JOptionPane.showMessageDialog(this, "Jabatan Admin tidak dapat dirubah");
        }else{
        popupjabatan.setVisible(true);
        btnjabatanclose.setVisible(true);
        btnjabatan.setVisible(false);
        btnjabatan2.setVisible(false);
        btnkasir.setVisible(true);
        btnkoki.setVisible(true);
        btnwaiter.setVisible(true);}
    }//GEN-LAST:event_btnjabatan2MouseClicked

    private void labelTambahRfIdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTambahRfIdMouseEntered
        int nilai = Integer.parseInt(verifikatorScanRfId.getText());
        if(nilai==0){    
            labelTambahRfId.setFont(labelTambahRfId.getFont().deriveFont(Font.BOLD)); // Mengatur font dengan garis bawah saat hover        
        }
    }//GEN-LAST:event_labelTambahRfIdMouseEntered

    private void labelTambahRfIdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTambahRfIdMouseExited
        int nilai = Integer.parseInt(verifikatorScanRfId.getText());
        if(nilai==0){    
            labelTambahRfId.setFont(labelTambahRfId.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_labelTambahRfIdMouseExited

    private void labelTambahRfIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelTambahRfIdMouseClicked
        verifikatorScanRfId.setText("1");
        removeFocusFromAllObjects(inputnama);
        removeFocusFromAllObjects(inputnik);
        removeFocusFromAllObjects(inputnowa);
        removeFocusFromAllObjects(inputusername);
        removeFocusFromAllObjects(labelTambahRfId);
        labelTambahRfId.setFont(labelTambahRfId.getFont().deriveFont(Font.PLAIN)); // Mengembalikan ke font awal setelah keluar dari hover
        
        scannik.setVisible(true);
        popupScanWait.setVisible(true);
        btnclosepopup.setVisible(true);
        
        
    }//GEN-LAST:event_labelTambahRfIdMouseClicked

    private void btnclosepopupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclosepopupMouseClicked
            labelTambahRfId.setText(null);
            labelTambahRfId.setText("ingin menambahkan rf id?");
            inputRfID.setText(null);
            scannik.setVisible(false);
            popupScanWait.setVisible(false);
            btnclosepopup.setVisible(false);
            scannik.setText(null);
            inputusername.setFocusable(true);
            inputnik.setFocusable(true);
            inputnowa.setFocusable(true);
            inputnama.setFocusable(true);
            labelTambahRfId.setFocusable(true);
            verifikatorScanRfId.setText("0");
    }//GEN-LAST:event_btnclosepopupMouseClicked

    private void scannikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scannikActionPerformed
        if(scannik.getText()!=null){
            labelTambahRfId.setText(null);
            labelTambahRfId.setText("Rf Id :" +scannik.getText()+"     Tekan Untuk Ubah");
            inputRfID.setText(null);
            inputRfID.setText(scannik.getText());
            scannik.setVisible(false);
            popupScanWait.setVisible(false);
            btnclosepopup.setVisible(false);
            scannik.setText(null);
        }else if(scannik.getText()==null){
            labelTambahRfId.setText(null);
            labelTambahRfId.setText("ingin menambahkan rf id?");
            inputRfID.setText(null);
            scannik.setVisible(false);
            popupScanWait.setVisible(false);
            btnclosepopup.setVisible(false);
            scannik.setText(null);
        }
        inputusername.setFocusable(true);
        inputnik.setFocusable(true);
        inputnowa.setFocusable(true);
        inputnama.setFocusable(true);
        labelTambahRfId.setFocusable(true);
        
    }//GEN-LAST:event_scannikActionPerformed

    private void inputRfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputRfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputRfIDActionPerformed

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
            java.util.logging.Logger.getLogger(AdminKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PopUpEdit;
    private javax.swing.JLabel background;
    private javax.swing.JPanel backpopup;
    private javax.swing.JPanel btnCancelInEdit;
    private javax.swing.JPanel btnDirectWA;
    private javax.swing.JPanel btnEditIniEdit;
    private javax.swing.JPanel btnclosepopup;
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
    private javax.swing.JLabel btnjabatan;
    private javax.swing.JPanel btnjabatan2;
    private javax.swing.JPanel btnjabatanclose;
    private javax.swing.JPanel btnkasir;
    private javax.swing.JPanel btnkoki;
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
    private javax.swing.JPanel btnwaiter;
    private javax.swing.JLabel datakaryawan1;
    private javax.swing.JLabel datakaryawan10;
    private javax.swing.JLabel datakaryawan11;
    private javax.swing.JLabel datakaryawan12;
    private javax.swing.JLabel datakaryawan13;
    private javax.swing.JLabel datakaryawan14;
    private javax.swing.JLabel datakaryawan15;
    private javax.swing.JLabel datakaryawan16;
    private javax.swing.JLabel datakaryawan17;
    private javax.swing.JLabel datakaryawan18;
    private javax.swing.JLabel datakaryawan19;
    private javax.swing.JLabel datakaryawan2;
    private javax.swing.JLabel datakaryawan20;
    private javax.swing.JLabel datakaryawan3;
    private javax.swing.JLabel datakaryawan4;
    private javax.swing.JLabel datakaryawan5;
    private javax.swing.JLabel datakaryawan6;
    private javax.swing.JLabel datakaryawan7;
    private javax.swing.JLabel datakaryawan8;
    private javax.swing.JLabel datakaryawan9;
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
    private javax.swing.JTextField inputRfID;
    private javax.swing.JTextField inputnama;
    private javax.swing.JTextField inputnik;
    private javax.swing.JTextField inputnowa;
    private javax.swing.JTextField inputusername;
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
    private javax.swing.JLabel krywn1;
    private javax.swing.JLabel krywn10;
    private javax.swing.JLabel krywn11;
    private javax.swing.JLabel krywn12;
    private javax.swing.JLabel krywn13;
    private javax.swing.JLabel krywn14;
    private javax.swing.JLabel krywn15;
    private javax.swing.JLabel krywn16;
    private javax.swing.JLabel krywn17;
    private javax.swing.JLabel krywn18;
    private javax.swing.JLabel krywn19;
    private javax.swing.JLabel krywn2;
    private javax.swing.JLabel krywn20;
    private javax.swing.JLabel krywn3;
    private javax.swing.JLabel krywn4;
    private javax.swing.JLabel krywn5;
    private javax.swing.JLabel krywn6;
    private javax.swing.JLabel krywn7;
    private javax.swing.JLabel krywn8;
    private javax.swing.JLabel krywn9;
    private javax.swing.JLabel labelTambahRfId;
    public static final javax.swing.JLabel labelnama1 = new javax.swing.JLabel();
    private javax.swing.JLabel labelnamakaryawan;
    private javax.swing.JLabel labelnik;
    private javax.swing.JLabel labelnowa;
    private javax.swing.JLabel labelusername;
    private javax.swing.JPanel pilihgambar;
    private javax.swing.JPanel popup;
    private javax.swing.JLabel popupScanWait;
    private javax.swing.JPanel popupclose;
    private javax.swing.JLabel popupdisplaygambar;
    private javax.swing.JLabel popupinfokaryawan;
    private javax.swing.JLabel popupjabatan;
    private javax.swing.JLabel popuplabel;
    private javax.swing.JPanel popuptutup;
    private javax.swing.JLabel popuptxtjabatan;
    private javax.swing.JLabel popuptxtnama;
    private javax.swing.JLabel popuptxtnik;
    private javax.swing.JLabel popuptxtnowa;
    private javax.swing.JLabel popuptxtusername;
    private javax.swing.JTextField scannik;
    private javax.swing.JPanel submit;
    private javax.swing.JTextField verifikatorScanRfId;
    // End of variables declaration//GEN-END:variables
}
