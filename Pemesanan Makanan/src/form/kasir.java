/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import com.google.zxing.BarcodeFormat;
import com.mysql.cj.jdbc.Blob;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import java.sql.PreparedStatement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import static form.MainPesanPembeli.finalPilihTempatMakan;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.stream.DoubleStream;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author fuada
 */
public class kasir extends javax.swing.JFrame {

    /**
     * Creates new form Promosi
     */
    private String sql;
    
    public static void printPNG(String nomorPesanan) throws PrinterException {
        // Mendefinisikan path file PNG yang akan dicetak
        String filePath = "C:/Users/fuada/OneDrive/Documents/belajar/tugas kuliah/smstr 2/tugas akhir/app/Pemesanan Makanan/src/qr code/" + nomorPesanan + ".png";
        
        // Memanggil method untuk mencetak file PNG
        printImage(filePath);
    }
    
    public static void printImage(String filePath) throws PrinterException {
        // Membaca file PNG menjadi objek BufferedImage
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // Membuat objek Printable untuk mencetak gambar
        Printable printable = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex != 0) {
                    return NO_SUCH_PAGE;
                }
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.drawImage(image, 0, 0, null);
                return PAGE_EXISTS;
            }
        };
        
        // Memilih printer thermal
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        
        // Membuat pekerjaan cetak
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintService(printService);
        printerJob.setPrintable(printable);
        
        // Mencetak file PNG
        try {
            printerJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkIfNumberExistsInTransaksiTable(String nomorPesanan) {
    String query = "SELECT id FROM transaksi WHERE id = ?";

    try (Connection conn = Config.configDB();
         PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setString(1, nomorPesanan);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }
        conn.close();
        statement.close();
        resultSet.close();
    } catch (Exception e) {
            e.printStackTrace();
        }

    return false;
}

    public static String getRandomNumberString() {
        // Membuat objek Random
        Random rand = new Random();

        // Menghasilkan bilangan acak antara 100000000000 dan 999999999999
        long randomNumber = (long) (rand.nextDouble() * 899999999999L) + 100000000000L;

        // Mengonversi bilangan acak menjadi String
        return String.valueOf(randomNumber);
    }
    
    public void tablepembelian(int id, String Nama, int Jumlah, int Harga){
        
        DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
        
         DecimalFormat df = new DecimalFormat();
         int totHarga = Harga * Integer.valueOf(Jumlah);
        
         
         String TotalHarga = df.format(totHarga);
        
        //fungsi agar terjadi deretan kebawah di table pembelian
        for (int row = 0; row < jTable1.getRowCount(); row++){
            
            if (Nama == jTable1.getValueAt(row, 1)){
              
                dt.removeRow(jTable1.convertRowIndexToModel(row));
            } 
        }
        
        Vector v = new Vector();
        
        v.add(id);
        v.add(Nama);
        v.add(Jumlah);
        v.add(TotalHarga);
        
        
        dt.addRow(v);
    }
    
    private void scheduleHideStruk() {
        int delay = 5000; // Penundaan sebelum menjalankan koding (dalam milidetik)

        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Koding untuk menyembunyikan komponen dan menghapus teks struk
                bgstruk.setVisible(false);
                scrollpaneStruk.setVisible(false);
                struk.setText(null);
                printstruk.setEnabled(false);
                pay.setText(null);
                bal1.setText(null);
                bgpesananscan.setVisible(false);
                labelnopesanan.setVisible(false);
            }
        });

        timer.setRepeats(false); // Hanya menjalankan koding sekali setelah 10 detik
        timer.start();
    }
    
    
    //fungsi untuk menghitung total harga
    public void cal() {
        int numOfRow = jTable1.getRowCount();
        int tot = 0;

        for (int i = 0; i < numOfRow; i++) {
            String valueString = jTable1.getValueAt(i, 3).toString();
            valueString = valueString.replace(",", ""); // Menghapus koma dari string
            int value = Integer.parseInt(valueString);

            tot += value;
        }

        DecimalFormat df = new DecimalFormat();
        total.setText(df.format(tot));
    }
    private void settampilkandata(String sql) throws SQLException {
    try {
        this.sql = sql;
        
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        java.sql.ResultSet rs = pstm.executeQuery(sql);

        int numRows = 1;
        while (rs.next()) {
            numRows = rs.getRow();
        }
        //cek jumlah database dan menonaktifkan card 
        for (int range = 21; range > numRows; range--) {
            switch (range) {
                case 1:
                    jmlhmenu1.setVisible(false);
                    datamenu1.setVisible(false);
                    menu1.setVisible(false);
                    displaygambar1.setVisible(false);
                    harga1.setVisible(false);
                    plus1.setVisible(false);
                    minus1.setVisible(false);
                    sold1.setVisible(false);
                    break;
                case 2:
                    jmlhmenu2.setVisible(false);
                    datamenu2.setVisible(false);
                    menu2.setVisible(false);
                    harga2.setVisible(false);
                    displaygambar2.setVisible(false);
                    plus2.setVisible(false);
                    minus2.setVisible(false);
                    sold2.setVisible(false);
                    break;
                case 3:
                    jmlhmenu3.setVisible(false);
                    datamenu3.setVisible(false);
                    menu3.setVisible(false);
                    harga3.setVisible(false);
                    displaygambar3.setVisible(false);
                    plus3.setVisible(false);
                    minus3.setVisible(false);
                    sold3.setVisible(false);
                    break;
                case 4:
                    jmlhmenu4.setVisible(false);
                    datamenu4.setVisible(false);
                    menu4.setVisible(false);
                    harga4.setVisible(false);
                    displaygambar4.setVisible(false);
                    plus4.setVisible(false);
                    minus4.setVisible(false);
                    sold4.setVisible(false);
                    break;
                case 5:
                    jmlhmenu5.setVisible(false);
                    datamenu5.setVisible(false);
                    menu5.setVisible(false);
                    harga5.setVisible(false);
                    displaygambar5.setVisible(false);
                    plus5.setVisible(false);
                    minus5.setVisible(false);
                    sold5.setVisible(false);
                    break;
                case 6:
                    jmlhmenu6.setVisible(false);
                    datamenu6.setVisible(false);
                    menu6.setVisible(false);
                    harga6.setVisible(false);
                    displaygambar6.setVisible(false);
                    minus6.setVisible(false);
                    plus6.setVisible(false);
                    sold6.setVisible(false);
                    break;
                case 7:
                    jmlhmenu7.setVisible(false);
                    datamenu7.setVisible(false);
                    menu7.setVisible(false);
                    harga7.setVisible(false);
                    displaygambar7.setVisible(false);
                    plus7.setVisible(false);
                    minus7.setVisible(false);
                    sold7.setVisible(false);
                    break;
                case 8:
                    jmlhmenu8.setVisible(false);
                    datamenu8.setVisible(false);
                    menu8.setVisible(false);
                    harga8.setVisible(false);
                    displaygambar8.setVisible(false);
                    plus8.setVisible(false);
                    minus8.setVisible(false);
                    sold8.setVisible(false);
                    break;
                case 9:
                    jmlhmenu9.setVisible(false);
                    datamenu9.setVisible(false);
                    menu9.setVisible(false);
                    harga9.setVisible(false);
                    displaygambar9.setVisible(false);
                    plus9.setVisible(false);
                    minus9.setVisible(false);
                    sold9.setVisible(false);
                    break;
                case 10:
                    jmlhmenu10.setVisible(false);
                    datamenu10.setVisible(false);
                    menu10.setVisible(false);
                    harga10.setVisible(false);
                    displaygambar10.setVisible(false);
                    plus10.setVisible(false);
                    minus10.setVisible(false);
                    sold10.setVisible(false);
                    break;
                case 11:
                    jmlhmenu11.setVisible(false);
                    datamenu11.setVisible(false);
                    menu11.setVisible(false);
                    harga11.setVisible(false);
                    displaygambar11.setVisible(false);
                    minus11.setVisible(false);
                    plus11.setVisible(false);
                    sold11.setVisible(false);
                    break;
                case 12:
                    jmlhmenu12.setVisible(false);
                    datamenu12.setVisible(false);
                    menu12.setVisible(false);
                    harga12.setVisible(false);
                    displaygambar12.setVisible(false);
                    minus12.setVisible(false);
                    plus12.setVisible(false);
                    sold12.setVisible(false);
                    break;
                case 13:
                    jmlhmenu13.setVisible(false);
                    datamenu13.setVisible(false);
                    menu13.setVisible(false);
                    harga13.setVisible(false);
                    displaygambar13.setVisible(false);
                    plus13.setVisible(false);
                    minus13.setVisible(false);
                    sold13.setVisible(false);
                    break;
                case 14:
                    jmlhmenu14.setVisible(false);
                    datamenu14.setVisible(false);
                    menu14.setVisible(false);
                    harga14.setVisible(false);
                    displaygambar14.setVisible(false);
                    plus14.setVisible(false);
                    minus14.setVisible(false);
                    sold14.setVisible(false);
                    break;
                case 15:
                    jmlhmenu15.setVisible(false);
                    datamenu15.setVisible(false);
                    menu15.setVisible(false);
                    harga15.setVisible(false);
                    displaygambar15.setVisible(false);
                    displaygambar15.setVisible(false);
                    minus15.setVisible(false);
                    plus15.setVisible(false);
                    sold15.setVisible(false);
                    break;
                case 16:
                    jmlhmenu16.setVisible(false);
                    datamenu16.setVisible(false);
                    menu16.setVisible(false);
                    harga16.setVisible(false);
                    displaygambar16.setVisible(false);
                    minus16.setVisible(false);
                    plus16.setVisible(false);
                    sold16.setVisible(false);
                    break;
                case 17:
                    jmlhmenu17.setVisible(false);
                    datamenu17.setVisible(false);
                    menu17.setVisible(false);
                    harga17.setVisible(false);
                    displaygambar17.setVisible(false);
                    minus17.setVisible(false);
                    plus17.setVisible(false);
                    sold17.setVisible(false);
                    break;
                case 18:
                    jmlhmenu18.setVisible(false);
                    datamenu18.setVisible(false);
                    menu18.setVisible(false);
                    harga18.setVisible(false);
                    displaygambar18.setVisible(false);
                    minus18.setVisible(false);
                    plus18.setVisible(false);
                    sold18.setVisible(false);
                    break;
                case 19:
                    jmlhmenu19.setVisible(false);
                    datamenu19.setVisible(false);
                    menu19.setVisible(false);
                    harga19.setVisible(false);
                    displaygambar19.setVisible(false);
                    minus19.setVisible(false);
                    plus19.setVisible(false);
                    sold19.setVisible(false);
                    break;
                case 20:
                    jmlhmenu20.setVisible(false);
                    datamenu20.setVisible(false);
                    menu20.setVisible(false);
                    harga20.setVisible(false);
                    displaygambar20.setVisible(false);
                    minus20.setVisible(false);
                    plus20.setVisible(false);
                    sold20.setVisible(false);
                    break;
                case 21:
                    jmlhmenu21.setVisible(false);
                    datamenu21.setVisible(false);
                    menu21.setVisible(false);
                    harga21.setVisible(false);
                    displaygambar21.setVisible(false);
                    minus21.setVisible(false);
                    plus21.setVisible(false);
                    sold21.setVisible(false);
                    break;
                
            }
        }
        //cek jumlah database dan set data pada card 
        rs.beforeFirst();
            for (int row = 1; row <= 21; row++) {
                if (rs.next()) {
                    String menu = rs.getString("nama_menu");
                    String harga = rs.getString("harga");
                    String ketersediaan = rs.getString("ketersediaan");

                    Blob gambar = (Blob) rs.getBlob("path_gambar");
                    int ukuran = (int) gambar.length();
                    ImageIcon ic = new ImageIcon(gambar.getBytes(1, ukuran));
                    Image img = ic.getImage().getScaledInstance(displaygambar1.getWidth(), displaygambar1.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(img);
                    switch (row) {
                        case 1:
                            jmlhmenu1.setVisible(true);
                            datamenu1.setVisible(true);
                            datamenu1.setText(menu);
                            harga1.setVisible(true);
                            harga1.setText(harga);
                            menu1.setVisible(true);
                            displaygambar1.setIcon(icon);
                            displaygambar1.setVisible(true);
                            minus1.setVisible(true);
                            plus1.setVisible(true);
                            sold1.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold1.setVisible(true);
                                minus1.setVisible(false);
                                plus1.setVisible(false);
                                jmlhmenu1.setVisible(false);
                            }
                            break;
                        case 2:
                            jmlhmenu2.setVisible(true);
                            datamenu2.setVisible(true);
                            datamenu2.setText(menu);
                            harga2.setVisible(true);
                            harga2.setText(harga);
                            menu2.setVisible(true);
                            displaygambar2.setIcon(icon);
                            displaygambar2.setVisible(true);
                            minus2.setVisible(true);
                            plus2.setVisible(true);
                            sold2.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold2.setVisible(true);
                                minus2.setVisible(false);
                                plus2.setVisible(false);
                                jmlhmenu2.setVisible(false);
                            }
                            break;
                        case 3:
                            jmlhmenu3.setVisible(true);
                            datamenu3.setVisible(true);
                            datamenu3.setText(menu);
                            harga3.setVisible(true);
                            harga3.setText(harga);
                            menu3.setVisible(true);
                            displaygambar3.setIcon(icon);
                            displaygambar3.setVisible(true);
                            minus3.setVisible(true);
                            plus3.setVisible(true);
                            sold3.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold3.setVisible(true);
                                minus3.setVisible(false);
                                plus3.setVisible(false);
                                jmlhmenu3.setVisible(false);
                            }
                            break;
                        case 4:
                            jmlhmenu4.setVisible(true);
                            datamenu6.setVisible(true);
                            datamenu6.setText(menu);
                            harga4.setVisible(true);
                            harga4.setText(harga);
                            menu4.setVisible(true);
                            displaygambar4.setIcon(icon);
                            displaygambar4.setVisible(true);
                            minus4.setVisible(true);
                            plus4.setVisible(true);
                            sold4.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold4.setVisible(true);
                                minus4.setVisible(false);
                                plus4.setVisible(false);
                                jmlhmenu4.setVisible(false);
                            }
                            break;
                        case 5:
                            jmlhmenu5.setVisible(true);
                            datamenu5.setVisible(true);
                            datamenu5.setText(menu);
                            harga5.setVisible(true);
                            harga5.setText(harga);
                            menu5.setVisible(true);
                            displaygambar5.setIcon(icon);
                            displaygambar5.setVisible(true);
                            minus5.setVisible(true);
                            plus5.setVisible(true);
                            sold5.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold5.setVisible(true);
                                minus5.setVisible(false);
                                plus5.setVisible(false);
                                jmlhmenu5.setVisible(false);
                            }
                            break;
                        case 6:
                            jmlhmenu6.setVisible(true);
                            datamenu4.setVisible(true);
                            datamenu4.setText(menu);
                            harga6.setVisible(true);
                            harga6.setText(harga);
                            menu6.setVisible(true);
                            displaygambar6.setIcon(icon);
                            displaygambar6.setVisible(true);
                            minus6.setVisible(true);
                            plus6.setVisible(true);
                            sold6.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold6.setVisible(true);
                                minus6.setVisible(false);
                                plus6.setVisible(false);
                                jmlhmenu6.setVisible(false);
                            }
                            break;
                        case 7:
                            jmlhmenu7.setVisible(true);
                            datamenu7.setVisible(true);
                            datamenu7.setText(menu);
                            harga7.setVisible(true);
                            harga7.setText(harga);
                            menu7.setVisible(true);
                            displaygambar7.setIcon(icon);
                            displaygambar7.setVisible(true);
                            minus7.setVisible(true);
                            plus7.setVisible(true);
                            sold7.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold7.setVisible(true);
                                minus7.setVisible(false);
                                plus7.setVisible(false);
                                jmlhmenu7.setVisible(false);
                            }
                            break;
                        case 8:
                            jmlhmenu8.setVisible(true);
                            datamenu8.setVisible(true);
                            datamenu8.setText(menu);
                            harga8.setVisible(true);
                            harga8.setText(harga);
                            menu8.setVisible(true);
                            displaygambar8.setIcon(icon);
                            displaygambar8.setVisible(true);
                            minus8.setVisible(true);
                            plus8.setVisible(true);
                            sold8.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold8.setVisible(true);
                                minus8.setVisible(false);
                                plus8.setVisible(false);
                                jmlhmenu8.setVisible(false);
                            }
                            break;
                        case 9:
                            jmlhmenu9.setVisible(true);
                            datamenu9.setVisible(true);
                            datamenu9.setText(menu);
                            harga9.setVisible(true);
                            harga9.setText(harga);
                            menu9.setVisible(true);
                            displaygambar9.setIcon(icon);
                            displaygambar9.setVisible(true);
                            minus9.setVisible(true);
                            plus9.setVisible(true);
                            sold9.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold9.setVisible(true);
                                minus9.setVisible(false);
                                plus9.setVisible(false);
                                jmlhmenu9.setVisible(false);
                            }
                            break;
                        case 10:
                            jmlhmenu10.setVisible(true);
                            datamenu10.setVisible(true);
                            datamenu10.setText(menu);
                            harga10.setVisible(true);
                            harga10.setText(harga);
                            menu10.setVisible(true);
                            displaygambar10.setIcon(icon);
                            displaygambar10.setVisible(true);
                            minus10.setVisible(true);
                            plus10.setVisible(true);
                            sold10.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold10.setVisible(true);
                                minus10.setVisible(false);
                                plus10.setVisible(false);
                                jmlhmenu10.setVisible(false);
                            }
                            break;
                        case 11:
                            jmlhmenu11.setVisible(true);
                            datamenu11.setVisible(true);
                            datamenu11.setText(menu);
                            harga11.setVisible(true);
                            harga11.setText(harga);
                            menu11.setVisible(true);
                            displaygambar11.setIcon(icon);
                            displaygambar11.setVisible(true);
                            minus11.setVisible(true);
                            plus11.setVisible(true);
                            sold11.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold11.setVisible(true);
                                minus11.setVisible(false);
                                plus11.setVisible(false);
                                jmlhmenu11.setVisible(false);
                            }
                            break;
                        case 12:
                            jmlhmenu12.setVisible(true);
                            datamenu12.setVisible(true);
                            datamenu12.setText(menu);
                            harga12.setVisible(true);
                            harga12.setText(harga);
                            menu12.setVisible(true);
                            displaygambar12.setIcon(icon);
                            displaygambar12.setVisible(true);
                            minus12 .setVisible(true);
                            plus12.setVisible(true);
                            sold12.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold12.setVisible(true);
                                minus12.setVisible(false);
                                plus12.setVisible(false);
                                jmlhmenu12.setVisible(false);
                            }
                            break;
                        case 13:
                            jmlhmenu13.setVisible(true);
                            datamenu13.setVisible(true);
                            datamenu13.setText(menu);
                            harga13.setVisible(true);
                            harga13.setText(harga);
                            menu13.setVisible(true);
                            displaygambar13.setIcon(icon);
                            displaygambar13.setVisible(true);
                            minus13.setVisible(true);
                            plus13.setVisible(true);
                            sold13.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){ 
                                sold13.setVisible(true);
                                minus13.setVisible(false);
                                plus13.setVisible(false);
                                jmlhmenu13.setVisible(false);
                            }
                            break;
                        case 14:
                            jmlhmenu14.setVisible(true);
                            datamenu14.setVisible(true);
                            datamenu14.setText(menu);
                            harga14.setVisible(true);
                            harga14.setText(harga);
                            menu14.setVisible(true);
                            displaygambar14.setIcon(icon);
                            displaygambar14.setVisible(true);
                            minus14.setVisible(true);
                            plus14.setVisible(true);
                            sold14.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold14.setVisible(true);
                                minus14.setVisible(false);
                                plus14.setVisible(false);
                                jmlhmenu14.setVisible(false);
                            }
                            break;
                        case 15:
                            jmlhmenu15.setVisible(true);
                            datamenu15.setVisible(true);
                            datamenu15.setText(menu);
                            harga15.setVisible(true);
                            harga15.setText(harga);
                            menu15.setVisible(true);
                            displaygambar15.setIcon(icon);
                            displaygambar15.setVisible(true);
                            minus15.setVisible(false);
                            plus15.setVisible(true);
                            sold15.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold15.setVisible(true);
                                minus15.setVisible(false);
                                plus15.setVisible(false);
                                jmlhmenu15.setVisible(false);
                            }
                            break;
                        case 16:
                            jmlhmenu16.setVisible(true);
                            datamenu16.setVisible(true);
                            datamenu16.setText(menu);
                            harga16.setVisible(true);
                            harga16.setText(harga);
                            menu16.setVisible(true);
                            displaygambar16.setIcon(icon);
                            displaygambar16.setVisible(true);
                            minus16.setVisible(false);
                            plus16.setVisible(true);
                            sold16.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold16.setVisible(true);
                                minus16.setVisible(false);
                                plus16.setVisible(false);
                                jmlhmenu16.setVisible(false);
                            }
                            break;
                        case 17:
                            jmlhmenu17.setVisible(true);
                            datamenu17.setVisible(true);
                            datamenu17.setText(menu);
                            harga17.setVisible(true);
                            harga17.setText(harga);
                            menu17.setVisible(true);
                            displaygambar17.setIcon(icon);
                            displaygambar17.setVisible(true);
                            minus17.setVisible(false);
                            plus17.setVisible(true);
                            sold17.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold17.setVisible(true);
                                minus17.setVisible(false);
                                plus17.setVisible(false);
                                jmlhmenu17.setVisible(false);
                            }
                            break;
                        case 18:
                            jmlhmenu18.setVisible(true);
                            datamenu18.setVisible(true);
                            datamenu18.setText(menu);
                            harga18.setVisible(true);
                            harga18.setText(harga);
                            menu18.setVisible(true);
                            displaygambar18.setIcon(icon);
                            displaygambar18.setVisible(true);
                            minus18.setVisible(false);
                            plus18.setVisible(true);
                            sold18.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold18.setVisible(true);
                                minus18.setVisible(false);
                                plus18.setVisible(false);
                                jmlhmenu18.setVisible(false);
                            }
                            break;
                        case 19:
                            jmlhmenu19.setVisible(true);
                            datamenu19.setVisible(true);
                            datamenu19.setText(menu);
                            harga19.setVisible(true);
                            harga19.setText(harga);
                            menu19.setVisible(true);
                            displaygambar19.setIcon(icon);
                            displaygambar19.setVisible(true);
                            minus19.setVisible(false);
                            plus19.setVisible(true);
                            sold19.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold19.setVisible(true);
                                minus19.setVisible(false);
                                plus19.setVisible(false);
                                jmlhmenu19.setVisible(false);
                            }
                            break;
                        case 20:
                            jmlhmenu20.setVisible(true);
                            datamenu20.setVisible(true);
                            datamenu20.setText(menu);
                            harga20.setVisible(true);
                            harga20.setText(harga);
                            menu20.setVisible(true);
                            displaygambar20.setIcon(icon);
                            displaygambar20.setVisible(true);
                            minus20.setVisible(false);
                            plus20.setVisible(true);
                            sold20.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold20.setVisible(true);
                                minus20.setVisible(false);
                                plus20.setVisible(false);
                                jmlhmenu20.setVisible(false);
                            }
                            break;
                        case 21:
                            jmlhmenu21.setVisible(true);
                            datamenu21.setVisible(true);
                            datamenu21.setText(menu);
                            harga21.setVisible(true);
                            harga21.setText(harga);
                            menu21.setVisible(true);
                            displaygambar21.setIcon(icon);
                            displaygambar21.setVisible(true);
                            minus21.setVisible(false);
                            plus21.setVisible(true);
                            sold21.setVisible(false);
                            if(ketersediaan.equals("KOSONG")){
                                sold21.setVisible(true);
                                minus21.setVisible(false);
                                plus21.setVisible(false);
                                jmlhmenu21.setVisible(false);
                            }
                            break;
                          
                        default:
                            break;
                    }
                } else {
                    break;
                }
            }
            conn.close();
        rs.close();
        pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Timer timer; // Deklarasi objek NoTimer
    
    //update pemesananNoFilter
    private void scheduleDataUpdate(String sql) {
            int delay2 = 0; // Penundaan sebelum penjadwalan dimulai
            int interval2 = 15000; // Setiap 10 detik
            timer = new Timer(interval2, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        settampilkandata(sql);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            timer.setInitialDelay(delay2);
            timer.start();
        }
    private void CetakLast() {
        try {
            String separator = "=".repeat(200); // Membuat garis pemisah sepanjang 200 karakter

            struk.setText(String.format("%200s", "WARUNG MIE NGANGENI") + "\n");
            struk.setText(struk.getText() + String.format("%200s", "Barat Lapangan Kemlagi,") + "\n");
            struk.setText(struk.getText() + String.format("%200s", "+62878 4019 9095,") + "\n");
            struk.setText(struk.getText() + separator + "\n");
            struk.setText(struk.getText() + "  Nama                                                                                   Jumlah               Harga" + "\n");
            struk.setText(struk.getText() + separator + "\n");

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String Nama = df.getValueAt(i, 1).toString();
                String Jumlah = df.getValueAt(i, 2).toString();
                String Harga = df.getValueAt(i, 3).toString();

                // Memastikan Nama tidak melebihi lebar printstruk
                if (Nama.length() > 16) {
                    String[] words = Nama.split(" ");
                    String newNama = "";
                    String currentLine = "";
                    for (String word : words) {
                        if (currentLine.length() + word.length() <= 16) {
                            currentLine += word + " ";
                        } else {
                            newNama += currentLine.trim() + "\n";
                            currentLine = word + " ";
                        }
                    }
                    newNama += currentLine.trim();
                    Nama = newNama;
                }

                // Menyesuaikan lebar jumlah dan harga
                String formattedJumlah = String.format("%-15s", Jumlah);
                String formattedHarga = String.format("%-20s", Harga);

                struk.setText(struk.getText() + " " + Nama + "\t\t" + formattedJumlah + "\t\t" + formattedHarga + "\n");
            }

            // Mendapatkan nilai harga1
            String hargaBaru = harga1.getText();

            struk.setText(struk.getText() + separator + "\n");
            struk.setText(struk.getText() + "Sub Total    : " + total.getText() + "\n");
            struk.setText(struk.getText() + "Cash           : " + pay.getText() + "\n");
            struk.setText(struk.getText() + "Kembalian : " + bal1.getText() + "\n");
            struk.setText(struk.getText() + separator + "\n");
            struk.setText(struk.getText() + String.format("%200s", "Terima Kasih Telah Memesan Disini") + "\n");

            struk.print();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public kasir() {
        initComponents();
        scheduleDataUpdate("SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id WHERE kategori_menu.kategori_nama = 'Promosi'");
        pay.setBackground(new java.awt.Color(0,0,0,1));
        printstruk.setEnabled(false);
        bgstruk.setVisible(false);
        scrollpaneStruk.setVisible(false);
        popuppilihTempatMakan.setVisible(false);
        btnBawaPulang.setVisible(false);
        btnMakanDisini.setVisible(false);
        scannik.setVisible(false);
        popupPemindaianBerhasil.setVisible(false);
        popupScanWait.setVisible(false);
        popupPemindaianGagal.setVisible(false);
        bgpesananscan.setVisible(false);
        labelnopesanan.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupPemindaianBerhasil = new javax.swing.JLabel();
        popupPemindaianGagal = new javax.swing.JLabel();
        scannik = new javax.swing.JTextField();
        btnclosepopup = new javax.swing.JPanel();
        popupScanWait = new javax.swing.JLabel();
        btnBawaPulang = new javax.swing.JPanel();
        btnMakanDisini = new javax.swing.JPanel();
        popuppilihTempatMakan = new javax.swing.JLabel();
        scrollpaneStruk = new javax.swing.JScrollPane();
        struk = new javax.swing.JTextArea();
        bgstruk = new javax.swing.JLabel();
        promosimenu = new javax.swing.JPanel();
        printstruk = new javax.swing.JButton();
        bal1 = new javax.swing.JLabel();
        checkout1 = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labeljudulform = new javax.swing.JLabel();
        tablepembelian = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        sold2 = new javax.swing.JLabel();
        sold3 = new javax.swing.JLabel();
        sold4 = new javax.swing.JLabel();
        sold5 = new javax.swing.JLabel();
        sold6 = new javax.swing.JLabel();
        sold7 = new javax.swing.JLabel();
        sold8 = new javax.swing.JLabel();
        sold9 = new javax.swing.JLabel();
        sold10 = new javax.swing.JLabel();
        sold11 = new javax.swing.JLabel();
        sold12 = new javax.swing.JLabel();
        sold13 = new javax.swing.JLabel();
        sold14 = new javax.swing.JLabel();
        sold15 = new javax.swing.JLabel();
        sold16 = new javax.swing.JLabel();
        sold17 = new javax.swing.JLabel();
        sold18 = new javax.swing.JLabel();
        sold19 = new javax.swing.JLabel();
        sold20 = new javax.swing.JLabel();
        sold21 = new javax.swing.JLabel();
        sold1 = new javax.swing.JLabel();
        displaygambar4 = new javax.swing.JLabel();
        displaygambar5 = new javax.swing.JLabel();
        displaygambar6 = new javax.swing.JLabel();
        displaygambar7 = new javax.swing.JLabel();
        displaygambar8 = new javax.swing.JLabel();
        displaygambar9 = new javax.swing.JLabel();
        displaygambar10 = new javax.swing.JLabel();
        displaygambar11 = new javax.swing.JLabel();
        displaygambar12 = new javax.swing.JLabel();
        displaygambar2 = new javax.swing.JLabel();
        displaygambar3 = new javax.swing.JLabel();
        displaygambar1 = new javax.swing.JLabel();
        datamenu7 = new javax.swing.JTextArea();
        harga7 = new javax.swing.JLabel();
        datamenu8 = new javax.swing.JTextArea();
        harga8 = new javax.swing.JLabel();
        datamenu9 = new javax.swing.JTextArea();
        harga9 = new javax.swing.JLabel();
        displaygambar13 = new javax.swing.JLabel();
        displaygambar14 = new javax.swing.JLabel();
        displaygambar15 = new javax.swing.JLabel();
        displaygambar16 = new javax.swing.JLabel();
        displaygambar17 = new javax.swing.JLabel();
        displaygambar18 = new javax.swing.JLabel();
        displaygambar20 = new javax.swing.JLabel();
        displaygambar21 = new javax.swing.JLabel();
        displaygambar19 = new javax.swing.JLabel();
        harga13 = new javax.swing.JLabel();
        datamenu13 = new javax.swing.JTextArea();
        datamenu14 = new javax.swing.JTextArea();
        harga14 = new javax.swing.JLabel();
        datamenu15 = new javax.swing.JTextArea();
        harga15 = new javax.swing.JLabel();
        harga17 = new javax.swing.JLabel();
        harga18 = new javax.swing.JLabel();
        harga16 = new javax.swing.JLabel();
        datamenu16 = new javax.swing.JTextArea();
        datamenu17 = new javax.swing.JTextArea();
        datamenu18 = new javax.swing.JTextArea();
        datamenu21 = new javax.swing.JTextArea();
        harga19 = new javax.swing.JLabel();
        harga20 = new javax.swing.JLabel();
        harga21 = new javax.swing.JLabel();
        datamenu20 = new javax.swing.JTextArea();
        datamenu19 = new javax.swing.JTextArea();
        harga10 = new javax.swing.JLabel();
        datamenu10 = new javax.swing.JTextArea();
        datamenu11 = new javax.swing.JTextArea();
        harga11 = new javax.swing.JLabel();
        datamenu12 = new javax.swing.JTextArea();
        harga12 = new javax.swing.JLabel();
        harga1 = new javax.swing.JLabel();
        datamenu1 = new javax.swing.JTextArea();
        datamenu3 = new javax.swing.JTextArea();
        harga3 = new javax.swing.JLabel();
        datamenu2 = new javax.swing.JTextArea();
        datamenu6 = new javax.swing.JTextArea();
        datamenu5 = new javax.swing.JTextArea();
        datamenu4 = new javax.swing.JTextArea();
        harga4 = new javax.swing.JLabel();
        harga5 = new javax.swing.JLabel();
        harga6 = new javax.swing.JLabel();
        harga2 = new javax.swing.JLabel();
        jmlhmenu1 = new javax.swing.JLabel();
        jmlhmenu2 = new javax.swing.JLabel();
        jmlhmenu3 = new javax.swing.JLabel();
        jmlhmenu4 = new javax.swing.JLabel();
        jmlhmenu5 = new javax.swing.JLabel();
        jmlhmenu6 = new javax.swing.JLabel();
        jmlhmenu7 = new javax.swing.JLabel();
        jmlhmenu8 = new javax.swing.JLabel();
        jmlhmenu9 = new javax.swing.JLabel();
        jmlhmenu10 = new javax.swing.JLabel();
        jmlhmenu11 = new javax.swing.JLabel();
        jmlhmenu12 = new javax.swing.JLabel();
        jmlhmenu13 = new javax.swing.JLabel();
        jmlhmenu14 = new javax.swing.JLabel();
        jmlhmenu15 = new javax.swing.JLabel();
        jmlhmenu16 = new javax.swing.JLabel();
        jmlhmenu17 = new javax.swing.JLabel();
        jmlhmenu18 = new javax.swing.JLabel();
        jmlhmenu19 = new javax.swing.JLabel();
        jmlhmenu20 = new javax.swing.JLabel();
        jmlhmenu21 = new javax.swing.JLabel();
        plus2 = new javax.swing.JPanel();
        minus2 = new javax.swing.JPanel();
        plus1 = new javax.swing.JPanel();
        minus1 = new javax.swing.JPanel();
        plus3 = new javax.swing.JPanel();
        minus3 = new javax.swing.JPanel();
        plus4 = new javax.swing.JPanel();
        minus4 = new javax.swing.JPanel();
        plus5 = new javax.swing.JPanel();
        minus5 = new javax.swing.JPanel();
        plus6 = new javax.swing.JPanel();
        minus6 = new javax.swing.JPanel();
        plus7 = new javax.swing.JPanel();
        minus7 = new javax.swing.JPanel();
        plus8 = new javax.swing.JPanel();
        minus8 = new javax.swing.JPanel();
        plus9 = new javax.swing.JPanel();
        minus9 = new javax.swing.JPanel();
        plus10 = new javax.swing.JPanel();
        minus10 = new javax.swing.JPanel();
        plus11 = new javax.swing.JPanel();
        minus11 = new javax.swing.JPanel();
        plus12 = new javax.swing.JPanel();
        minus12 = new javax.swing.JPanel();
        plus13 = new javax.swing.JPanel();
        minus13 = new javax.swing.JPanel();
        plus14 = new javax.swing.JPanel();
        minus14 = new javax.swing.JPanel();
        plus15 = new javax.swing.JPanel();
        minus15 = new javax.swing.JPanel();
        plus16 = new javax.swing.JPanel();
        minus16 = new javax.swing.JPanel();
        plus17 = new javax.swing.JPanel();
        minus17 = new javax.swing.JPanel();
        plus18 = new javax.swing.JPanel();
        minus18 = new javax.swing.JPanel();
        plus19 = new javax.swing.JPanel();
        minus19 = new javax.swing.JPanel();
        plus20 = new javax.swing.JPanel();
        minus20 = new javax.swing.JPanel();
        plus21 = new javax.swing.JPanel();
        minus21 = new javax.swing.JPanel();
        menu1 = new javax.swing.JLabel();
        menu3 = new javax.swing.JLabel();
        menu2 = new javax.swing.JLabel();
        menu4 = new javax.swing.JLabel();
        menu5 = new javax.swing.JLabel();
        menu6 = new javax.swing.JLabel();
        menu7 = new javax.swing.JLabel();
        menu8 = new javax.swing.JLabel();
        menu9 = new javax.swing.JLabel();
        menu10 = new javax.swing.JLabel();
        menu11 = new javax.swing.JLabel();
        menu12 = new javax.swing.JLabel();
        menu13 = new javax.swing.JLabel();
        menu14 = new javax.swing.JLabel();
        menu15 = new javax.swing.JLabel();
        menu16 = new javax.swing.JLabel();
        menu17 = new javax.swing.JLabel();
        menu18 = new javax.swing.JLabel();
        menu19 = new javax.swing.JLabel();
        menu20 = new javax.swing.JLabel();
        menu21 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btnsnack = new javax.swing.JPanel();
        labelsnack = new javax.swing.JLabel();
        promosi = new javax.swing.JPanel();
        labelpromosi = new javax.swing.JLabel();
        btnmakanan = new javax.swing.JPanel();
        labelmakanan = new javax.swing.JLabel();
        btnminuman = new javax.swing.JPanel();
        labelminuman = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        btnmulaidariawal = new javax.swing.JPanel();
        btncheckout = new javax.swing.JPanel();
        inputsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JPanel();
        btnscan = new javax.swing.JPanel();
        btnlogOut = new javax.swing.JPanel();
        labelnopesanan = new javax.swing.JLabel();
        bgpesananscan = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        Q1 = new javax.swing.JLabel();
        Q3 = new javax.swing.JLabel();
        bal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popupPemindaianBerhasil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/scan qr code berhasil.png"))); // NOI18N
        getContentPane().add(popupPemindaianBerhasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 548, -1, -1));

        popupPemindaianGagal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/scan qr code gagal.png"))); // NOI18N
        getContentPane().add(popupPemindaianGagal, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 548, -1, -1));

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

        popupScanWait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/scanqrcode.png"))); // NOI18N
        getContentPane().add(popupScanWait, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -270, -1, -1));

        btnBawaPulang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBawaPulang.setOpaque(false);
        btnBawaPulang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBawaPulangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnBawaPulangLayout = new javax.swing.GroupLayout(btnBawaPulang);
        btnBawaPulang.setLayout(btnBawaPulangLayout);
        btnBawaPulangLayout.setHorizontalGroup(
            btnBawaPulangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        btnBawaPulangLayout.setVerticalGroup(
            btnBawaPulangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(btnBawaPulang, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 314, 200, 200));

        btnMakanDisini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMakanDisini.setOpaque(false);
        btnMakanDisini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMakanDisiniMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnMakanDisiniLayout = new javax.swing.GroupLayout(btnMakanDisini);
        btnMakanDisini.setLayout(btnMakanDisiniLayout);
        btnMakanDisiniLayout.setHorizontalGroup(
            btnMakanDisiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        btnMakanDisiniLayout.setVerticalGroup(
            btnMakanDisiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        getContentPane().add(btnMakanDisini, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 314, 200, 200));

        popuppilihTempatMakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/opsi tempat makan.png"))); // NOI18N
        getContentPane().add(popuppilihTempatMakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 60, -1, -1));

        struk.setColumns(20);
        struk.setRows(5);
        struk.setOpaque(false);
        struk.setPreferredSize(new java.awt.Dimension(232, 80));
        scrollpaneStruk.setViewportView(struk);

        getContentPane().add(scrollpaneStruk, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 95, 330, 530));

        bgstruk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/bg resi.png"))); // NOI18N
        getContentPane().add(bgstruk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -70, 1230, 930));

        promosimenu.setOpaque(false);
        promosimenu.setPreferredSize(new java.awt.Dimension(1366, 768));
        promosimenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printstruk.setText("print");
        printstruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printstrukActionPerformed(evt);
            }
        });
        promosimenu.add(printstruk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 654, 90, 65));

        bal1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        bal1.setForeground(new java.awt.Color(255, 255, 255));
        promosimenu.add(bal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 590, 190, 40));

        checkout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkout1MouseClicked(evt);
            }
        });
        promosimenu.add(checkout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 656, 260, 62));

        pay.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setBorder(null);
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        promosimenu.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 530, 190, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Rp");
        promosimenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 590, 40, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Rp");
        promosimenu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 530, 40, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Rp");
        promosimenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 460, 40, 40));

        labeljudulform.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        labeljudulform.setText("Promosi");
        promosimenu.add(labeljudulform, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 40, 290, 35));

        tablepembelian.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Jumlah", "Harga"
            }
        ));
        tablepembelian.setViewportView(jTable1);

        promosimenu.add(tablepembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 150, 330, 280));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(702, 2023));
        jPanel1.setPreferredSize(new java.awt.Dimension(703, 2023));
        jPanel1.setLayout(null);

        sold2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold2);
        sold2.setBounds(200, 192, 337, 138);

        sold3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold3);
        sold3.setBounds(430, 192, 337, 138);

        sold4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold4);
        sold4.setBounds(-30, 480, 337, 138);

        sold5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold5);
        sold5.setBounds(200, 480, 337, 138);

        sold6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold6);
        sold6.setBounds(430, 480, 337, 138);

        sold7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold7);
        sold7.setBounds(-30, 760, 337, 138);

        sold8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold8);
        sold8.setBounds(200, 760, 337, 138);

        sold9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold9);
        sold9.setBounds(430, 760, 337, 138);

        sold10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold10);
        sold10.setBounds(-30, 1050, 337, 138);

        sold11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold11);
        sold11.setBounds(200, 1050, 337, 138);

        sold12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold12);
        sold12.setBounds(430, 1050, 337, 138);

        sold13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold13);
        sold13.setBounds(-30, 1340, 337, 138);

        sold14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold14);
        sold14.setBounds(200, 1340, 337, 138);

        sold15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold15);
        sold15.setBounds(430, 1340, 337, 138);

        sold16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold16);
        sold16.setBounds(-30, 1630, 337, 138);

        sold17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold17);
        sold17.setBounds(200, 1630, 337, 138);

        sold18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold18);
        sold18.setBounds(430, 1630, 337, 138);

        sold19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold19);
        sold19.setBounds(-30, 1920, 337, 138);

        sold20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold20);
        sold20.setBounds(200, 1920, 337, 138);

        sold21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold21);
        sold21.setBounds(430, 1920, 337, 138);

        sold1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/SOLD.png"))); // NOI18N
        jPanel1.add(sold1);
        sold1.setBounds(-30, 193, 337, 138);
        jPanel1.add(displaygambar4);
        displaygambar4.setBounds(19, 302, 190, 160);
        jPanel1.add(displaygambar5);
        displaygambar5.setBounds(249, 302, 190, 160);
        jPanel1.add(displaygambar6);
        displaygambar6.setBounds(480, 302, 190, 160);
        jPanel1.add(displaygambar7);
        displaygambar7.setBounds(19, 586, 190, 160);
        jPanel1.add(displaygambar8);
        displaygambar8.setBounds(249, 586, 190, 160);
        jPanel1.add(displaygambar9);
        displaygambar9.setBounds(480, 586, 190, 160);
        jPanel1.add(displaygambar10);
        displaygambar10.setBounds(19, 872, 190, 160);
        jPanel1.add(displaygambar11);
        displaygambar11.setBounds(249, 872, 190, 160);
        jPanel1.add(displaygambar12);
        displaygambar12.setBounds(480, 872, 190, 160);
        jPanel1.add(displaygambar2);
        displaygambar2.setBounds(249, 10, 190, 160);
        jPanel1.add(displaygambar3);
        displaygambar3.setBounds(480, 10, 190, 160);
        jPanel1.add(displaygambar1);
        displaygambar1.setBounds(19, 10, 190, 160);

        datamenu7.setEditable(false);
        datamenu7.setBackground(new java.awt.Color(255, 255, 255));
        datamenu7.setColumns(20);
        datamenu7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu7.setLineWrap(true);
        datamenu7.setRows(2);
        datamenu7.setWrapStyleWord(true);
        datamenu7.setBorder(null);
        datamenu7.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu7);
        datamenu7.setBounds(10, 740, 210, 40);

        harga7.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga7.setText("10.000");
        jPanel1.add(harga7);
        harga7.setBounds(130, 785, 80, 23);

        datamenu8.setEditable(false);
        datamenu8.setBackground(new java.awt.Color(255, 255, 255));
        datamenu8.setColumns(20);
        datamenu8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu8.setLineWrap(true);
        datamenu8.setRows(2);
        datamenu8.setWrapStyleWord(true);
        datamenu8.setBorder(null);
        datamenu8.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu8);
        datamenu8.setBounds(240, 740, 210, 40);

        harga8.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga8.setText("10.000");
        jPanel1.add(harga8);
        harga8.setBounds(360, 785, 80, 23);

        datamenu9.setEditable(false);
        datamenu9.setBackground(new java.awt.Color(255, 255, 255));
        datamenu9.setColumns(20);
        datamenu9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu9.setLineWrap(true);
        datamenu9.setRows(2);
        datamenu9.setWrapStyleWord(true);
        datamenu9.setBorder(null);
        datamenu9.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu9);
        datamenu9.setBounds(470, 740, 210, 40);

        harga9.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga9.setText("10.000");
        jPanel1.add(harga9);
        harga9.setBounds(580, 785, 80, 23);
        jPanel1.add(displaygambar13);
        displaygambar13.setBounds(20, 1160, 190, 160);
        jPanel1.add(displaygambar14);
        displaygambar14.setBounds(250, 1160, 190, 160);
        jPanel1.add(displaygambar15);
        displaygambar15.setBounds(480, 1160, 190, 160);
        jPanel1.add(displaygambar16);
        displaygambar16.setBounds(20, 1450, 190, 160);
        jPanel1.add(displaygambar17);
        displaygambar17.setBounds(250, 1450, 190, 160);
        jPanel1.add(displaygambar18);
        displaygambar18.setBounds(480, 1450, 190, 160);
        jPanel1.add(displaygambar20);
        displaygambar20.setBounds(250, 1740, 190, 160);
        jPanel1.add(displaygambar21);
        displaygambar21.setBounds(480, 1740, 190, 160);
        jPanel1.add(displaygambar19);
        displaygambar19.setBounds(20, 1740, 190, 160);

        harga13.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga13.setText("10.000");
        jPanel1.add(harga13);
        harga13.setBounds(130, 1365, 80, 23);

        datamenu13.setEditable(false);
        datamenu13.setBackground(new java.awt.Color(255, 255, 255));
        datamenu13.setColumns(20);
        datamenu13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu13.setLineWrap(true);
        datamenu13.setRows(2);
        datamenu13.setWrapStyleWord(true);
        datamenu13.setBorder(null);
        datamenu13.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu13);
        datamenu13.setBounds(10, 1320, 210, 40);

        datamenu14.setEditable(false);
        datamenu14.setBackground(new java.awt.Color(255, 255, 255));
        datamenu14.setColumns(20);
        datamenu14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu14.setLineWrap(true);
        datamenu14.setRows(2);
        datamenu14.setWrapStyleWord(true);
        datamenu14.setBorder(null);
        datamenu14.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu14);
        datamenu14.setBounds(240, 1320, 210, 40);

        harga14.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga14.setText("10.000");
        jPanel1.add(harga14);
        harga14.setBounds(360, 1365, 80, 23);

        datamenu15.setEditable(false);
        datamenu15.setBackground(new java.awt.Color(255, 255, 255));
        datamenu15.setColumns(20);
        datamenu15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu15.setLineWrap(true);
        datamenu15.setRows(2);
        datamenu15.setWrapStyleWord(true);
        datamenu15.setBorder(null);
        datamenu15.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu15);
        datamenu15.setBounds(470, 1320, 210, 40);

        harga15.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga15.setText("10.000");
        jPanel1.add(harga15);
        harga15.setBounds(580, 1365, 80, 23);

        harga17.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga17.setText("10.000");
        jPanel1.add(harga17);
        harga17.setBounds(360, 1655, 80, 23);

        harga18.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga18.setText("10.000");
        jPanel1.add(harga18);
        harga18.setBounds(580, 1655, 80, 23);

        harga16.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga16.setText("10.000");
        jPanel1.add(harga16);
        harga16.setBounds(130, 1655, 80, 23);

        datamenu16.setEditable(false);
        datamenu16.setBackground(new java.awt.Color(255, 255, 255));
        datamenu16.setColumns(20);
        datamenu16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu16.setLineWrap(true);
        datamenu16.setRows(2);
        datamenu16.setWrapStyleWord(true);
        datamenu16.setBorder(null);
        datamenu16.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu16);
        datamenu16.setBounds(10, 1610, 210, 40);

        datamenu17.setEditable(false);
        datamenu17.setBackground(new java.awt.Color(255, 255, 255));
        datamenu17.setColumns(20);
        datamenu17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu17.setLineWrap(true);
        datamenu17.setRows(2);
        datamenu17.setWrapStyleWord(true);
        datamenu17.setBorder(null);
        datamenu17.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu17);
        datamenu17.setBounds(240, 1610, 210, 40);

        datamenu18.setEditable(false);
        datamenu18.setBackground(new java.awt.Color(255, 255, 255));
        datamenu18.setColumns(20);
        datamenu18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu18.setLineWrap(true);
        datamenu18.setRows(2);
        datamenu18.setWrapStyleWord(true);
        datamenu18.setBorder(null);
        datamenu18.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu18);
        datamenu18.setBounds(470, 1610, 210, 40);

        datamenu21.setEditable(false);
        datamenu21.setBackground(new java.awt.Color(255, 255, 255));
        datamenu21.setColumns(20);
        datamenu21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu21.setLineWrap(true);
        datamenu21.setRows(2);
        datamenu21.setWrapStyleWord(true);
        datamenu21.setBorder(null);
        datamenu21.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu21);
        datamenu21.setBounds(470, 1900, 210, 40);

        harga19.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga19.setText("10.000");
        jPanel1.add(harga19);
        harga19.setBounds(130, 1945, 80, 23);

        harga20.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga20.setText("10.000");
        jPanel1.add(harga20);
        harga20.setBounds(360, 1945, 80, 23);

        harga21.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga21.setText("10.000");
        jPanel1.add(harga21);
        harga21.setBounds(580, 1945, 80, 23);

        datamenu20.setEditable(false);
        datamenu20.setBackground(new java.awt.Color(255, 255, 255));
        datamenu20.setColumns(20);
        datamenu20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu20.setLineWrap(true);
        datamenu20.setRows(2);
        datamenu20.setWrapStyleWord(true);
        datamenu20.setBorder(null);
        datamenu20.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu20);
        datamenu20.setBounds(240, 1900, 210, 40);

        datamenu19.setEditable(false);
        datamenu19.setBackground(new java.awt.Color(255, 255, 255));
        datamenu19.setColumns(20);
        datamenu19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu19.setLineWrap(true);
        datamenu19.setRows(2);
        datamenu19.setWrapStyleWord(true);
        datamenu19.setBorder(null);
        datamenu19.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu19);
        datamenu19.setBounds(10, 1900, 210, 40);

        harga10.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga10.setText("10.000");
        jPanel1.add(harga10);
        harga10.setBounds(130, 1075, 80, 23);

        datamenu10.setEditable(false);
        datamenu10.setBackground(new java.awt.Color(255, 255, 255));
        datamenu10.setColumns(20);
        datamenu10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu10.setLineWrap(true);
        datamenu10.setRows(2);
        datamenu10.setWrapStyleWord(true);
        datamenu10.setBorder(null);
        datamenu10.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu10);
        datamenu10.setBounds(10, 1030, 210, 40);

        datamenu11.setEditable(false);
        datamenu11.setBackground(new java.awt.Color(255, 255, 255));
        datamenu11.setColumns(20);
        datamenu11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu11.setLineWrap(true);
        datamenu11.setRows(2);
        datamenu11.setWrapStyleWord(true);
        datamenu11.setBorder(null);
        datamenu11.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu11);
        datamenu11.setBounds(240, 1030, 210, 40);

        harga11.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga11.setText("10.000");
        jPanel1.add(harga11);
        harga11.setBounds(360, 1075, 80, 23);

        datamenu12.setEditable(false);
        datamenu12.setBackground(new java.awt.Color(255, 255, 255));
        datamenu12.setColumns(20);
        datamenu12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu12.setLineWrap(true);
        datamenu12.setRows(2);
        datamenu12.setWrapStyleWord(true);
        datamenu12.setBorder(null);
        datamenu12.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu12);
        datamenu12.setBounds(470, 1030, 210, 40);

        harga12.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga12.setText("10.000");
        jPanel1.add(harga12);
        harga12.setBounds(580, 1075, 80, 23);

        harga1.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga1.setText("10.000");
        jPanel1.add(harga1);
        harga1.setBounds(127, 215, 80, 23);

        datamenu1.setEditable(false);
        datamenu1.setBackground(new java.awt.Color(255, 255, 255));
        datamenu1.setColumns(20);
        datamenu1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu1.setLineWrap(true);
        datamenu1.setRows(2);
        datamenu1.setWrapStyleWord(true);
        datamenu1.setBorder(null);
        datamenu1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu1);
        datamenu1.setBounds(10, 170, 210, 40);

        datamenu3.setEditable(false);
        datamenu3.setBackground(new java.awt.Color(255, 255, 255));
        datamenu3.setColumns(20);
        datamenu3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu3.setLineWrap(true);
        datamenu3.setRows(2);
        datamenu3.setWrapStyleWord(true);
        datamenu3.setBorder(null);
        datamenu3.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu3);
        datamenu3.setBounds(470, 170, 210, 40);

        harga3.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga3.setText("10.000");
        jPanel1.add(harga3);
        harga3.setBounds(580, 215, 80, 23);

        datamenu2.setEditable(false);
        datamenu2.setBackground(new java.awt.Color(255, 255, 255));
        datamenu2.setColumns(20);
        datamenu2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu2.setLineWrap(true);
        datamenu2.setRows(2);
        datamenu2.setWrapStyleWord(true);
        datamenu2.setBorder(null);
        datamenu2.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu2);
        datamenu2.setBounds(240, 170, 210, 40);

        datamenu6.setEditable(false);
        datamenu6.setBackground(new java.awt.Color(255, 255, 255));
        datamenu6.setColumns(20);
        datamenu6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu6.setLineWrap(true);
        datamenu6.setRows(2);
        datamenu6.setWrapStyleWord(true);
        datamenu6.setBorder(null);
        datamenu6.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu6);
        datamenu6.setBounds(470, 460, 210, 40);

        datamenu5.setEditable(false);
        datamenu5.setBackground(new java.awt.Color(255, 255, 255));
        datamenu5.setColumns(20);
        datamenu5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu5.setLineWrap(true);
        datamenu5.setRows(2);
        datamenu5.setWrapStyleWord(true);
        datamenu5.setBorder(null);
        datamenu5.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu5);
        datamenu5.setBounds(240, 460, 210, 40);

        datamenu4.setEditable(false);
        datamenu4.setBackground(new java.awt.Color(255, 255, 255));
        datamenu4.setColumns(20);
        datamenu4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        datamenu4.setLineWrap(true);
        datamenu4.setRows(2);
        datamenu4.setWrapStyleWord(true);
        datamenu4.setBorder(null);
        datamenu4.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(datamenu4);
        datamenu4.setBounds(10, 460, 210, 40);

        harga4.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga4.setText("10.000");
        jPanel1.add(harga4);
        harga4.setBounds(130, 505, 80, 23);

        harga5.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga5.setText("10.000");
        jPanel1.add(harga5);
        harga5.setBounds(360, 505, 80, 23);

        harga6.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga6.setText("10.000");
        jPanel1.add(harga6);
        harga6.setBounds(580, 505, 80, 23);

        harga2.setFont(new java.awt.Font("Futura Md BT", 1, 18)); // NOI18N
        harga2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        harga2.setText("10.000");
        jPanel1.add(harga2);
        harga2.setBounds(358, 215, 80, 23);

        jmlhmenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu1.setText("0");
        jPanel1.add(jmlhmenu1);
        jmlhmenu1.setBounds(100, 248, 30, 20);

        jmlhmenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu2.setText("0");
        jPanel1.add(jmlhmenu2);
        jmlhmenu2.setBounds(330, 248, 30, 20);

        jmlhmenu3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu3.setText("0");
        jPanel1.add(jmlhmenu3);
        jmlhmenu3.setBounds(560, 248, 30, 20);

        jmlhmenu4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu4.setText("0");
        jPanel1.add(jmlhmenu4);
        jmlhmenu4.setBounds(100, 538, 30, 20);

        jmlhmenu5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu5.setText("0");
        jPanel1.add(jmlhmenu5);
        jmlhmenu5.setBounds(330, 538, 30, 20);

        jmlhmenu6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu6.setText("0");
        jPanel1.add(jmlhmenu6);
        jmlhmenu6.setBounds(560, 538, 30, 20);

        jmlhmenu7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu7.setText("0");
        jPanel1.add(jmlhmenu7);
        jmlhmenu7.setBounds(100, 818, 30, 20);

        jmlhmenu8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu8.setText("0");
        jPanel1.add(jmlhmenu8);
        jmlhmenu8.setBounds(330, 818, 30, 20);

        jmlhmenu9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu9.setText("0");
        jPanel1.add(jmlhmenu9);
        jmlhmenu9.setBounds(560, 818, 30, 20);

        jmlhmenu10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu10.setText("0");
        jPanel1.add(jmlhmenu10);
        jmlhmenu10.setBounds(100, 1108, 30, 20);

        jmlhmenu11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu11.setText("0");
        jPanel1.add(jmlhmenu11);
        jmlhmenu11.setBounds(330, 1108, 30, 20);

        jmlhmenu12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu12.setText("0");
        jPanel1.add(jmlhmenu12);
        jmlhmenu12.setBounds(560, 1108, 30, 20);

        jmlhmenu13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu13.setText("0");
        jPanel1.add(jmlhmenu13);
        jmlhmenu13.setBounds(100, 1398, 30, 20);

        jmlhmenu14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu14.setText("0");
        jPanel1.add(jmlhmenu14);
        jmlhmenu14.setBounds(330, 1398, 30, 20);

        jmlhmenu15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu15.setText("0");
        jPanel1.add(jmlhmenu15);
        jmlhmenu15.setBounds(560, 1398, 30, 20);

        jmlhmenu16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu16.setText("0");
        jPanel1.add(jmlhmenu16);
        jmlhmenu16.setBounds(100, 1688, 30, 20);

        jmlhmenu17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu17.setText("0");
        jPanel1.add(jmlhmenu17);
        jmlhmenu17.setBounds(330, 1688, 30, 20);

        jmlhmenu18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu18.setText("0");
        jPanel1.add(jmlhmenu18);
        jmlhmenu18.setBounds(560, 1688, 30, 20);

        jmlhmenu19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu19.setText("0");
        jPanel1.add(jmlhmenu19);
        jmlhmenu19.setBounds(100, 1978, 30, 20);

        jmlhmenu20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu20.setText("0");
        jPanel1.add(jmlhmenu20);
        jmlhmenu20.setBounds(330, 1978, 30, 20);

        jmlhmenu21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jmlhmenu21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhmenu21.setText("0");
        jPanel1.add(jmlhmenu21);
        jmlhmenu21.setBounds(560, 1978, 30, 20);

        plus2.setOpaque(false);
        plus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus2Layout = new javax.swing.GroupLayout(plus2);
        plus2.setLayout(plus2Layout);
        plus2Layout.setHorizontalGroup(
            plus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus2Layout.setVerticalGroup(
            plus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus2);
        plus2.setBounds(376, 249, 23, 23);

        minus2.setOpaque(false);
        minus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus2Layout = new javax.swing.GroupLayout(minus2);
        minus2.setLayout(minus2Layout);
        minus2Layout.setHorizontalGroup(
            minus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus2Layout.setVerticalGroup(
            minus2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus2);
        minus2.setBounds(292, 248, 23, 23);

        plus1.setOpaque(false);
        plus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus1Layout = new javax.swing.GroupLayout(plus1);
        plus1.setLayout(plus1Layout);
        plus1Layout.setHorizontalGroup(
            plus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus1Layout.setVerticalGroup(
            plus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus1);
        plus1.setBounds(145, 248, 23, 23);

        minus1.setOpaque(false);
        minus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus1Layout = new javax.swing.GroupLayout(minus1);
        minus1.setLayout(minus1Layout);
        minus1Layout.setHorizontalGroup(
            minus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus1Layout.setVerticalGroup(
            minus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus1);
        minus1.setBounds(62, 248, 23, 23);

        plus3.setOpaque(false);
        plus3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus3Layout = new javax.swing.GroupLayout(plus3);
        plus3.setLayout(plus3Layout);
        plus3Layout.setHorizontalGroup(
            plus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus3Layout.setVerticalGroup(
            plus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus3);
        plus3.setBounds(606, 248, 23, 23);

        minus3.setOpaque(false);
        minus3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus3Layout = new javax.swing.GroupLayout(minus3);
        minus3.setLayout(minus3Layout);
        minus3Layout.setHorizontalGroup(
            minus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus3Layout.setVerticalGroup(
            minus3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus3);
        minus3.setBounds(522, 248, 23, 23);

        plus4.setOpaque(false);
        plus4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus4Layout = new javax.swing.GroupLayout(plus4);
        plus4.setLayout(plus4Layout);
        plus4Layout.setHorizontalGroup(
            plus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus4Layout.setVerticalGroup(
            plus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus4);
        plus4.setBounds(145, 538, 23, 23);

        minus4.setOpaque(false);
        minus4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus4Layout = new javax.swing.GroupLayout(minus4);
        minus4.setLayout(minus4Layout);
        minus4Layout.setHorizontalGroup(
            minus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus4Layout.setVerticalGroup(
            minus4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus4);
        minus4.setBounds(62, 538, 23, 23);

        plus5.setOpaque(false);
        plus5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus5Layout = new javax.swing.GroupLayout(plus5);
        plus5.setLayout(plus5Layout);
        plus5Layout.setHorizontalGroup(
            plus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus5Layout.setVerticalGroup(
            plus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus5);
        plus5.setBounds(376, 538, 23, 23);

        minus5.setOpaque(false);
        minus5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus5Layout = new javax.swing.GroupLayout(minus5);
        minus5.setLayout(minus5Layout);
        minus5Layout.setHorizontalGroup(
            minus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus5Layout.setVerticalGroup(
            minus5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus5);
        minus5.setBounds(292, 538, 23, 23);

        plus6.setOpaque(false);
        plus6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus6Layout = new javax.swing.GroupLayout(plus6);
        plus6.setLayout(plus6Layout);
        plus6Layout.setHorizontalGroup(
            plus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus6Layout.setVerticalGroup(
            plus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus6);
        plus6.setBounds(606, 538, 23, 23);

        minus6.setOpaque(false);
        minus6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus6Layout = new javax.swing.GroupLayout(minus6);
        minus6.setLayout(minus6Layout);
        minus6Layout.setHorizontalGroup(
            minus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus6Layout.setVerticalGroup(
            minus6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus6);
        minus6.setBounds(522, 538, 23, 23);

        plus7.setOpaque(false);
        plus7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus7Layout = new javax.swing.GroupLayout(plus7);
        plus7.setLayout(plus7Layout);
        plus7Layout.setHorizontalGroup(
            plus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus7Layout.setVerticalGroup(
            plus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus7);
        plus7.setBounds(145, 818, 23, 23);

        minus7.setOpaque(false);
        minus7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus7Layout = new javax.swing.GroupLayout(minus7);
        minus7.setLayout(minus7Layout);
        minus7Layout.setHorizontalGroup(
            minus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus7Layout.setVerticalGroup(
            minus7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus7);
        minus7.setBounds(62, 818, 23, 23);

        plus8.setOpaque(false);
        plus8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus8Layout = new javax.swing.GroupLayout(plus8);
        plus8.setLayout(plus8Layout);
        plus8Layout.setHorizontalGroup(
            plus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus8Layout.setVerticalGroup(
            plus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus8);
        plus8.setBounds(376, 818, 23, 23);

        minus8.setOpaque(false);
        minus8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus8Layout = new javax.swing.GroupLayout(minus8);
        minus8.setLayout(minus8Layout);
        minus8Layout.setHorizontalGroup(
            minus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus8Layout.setVerticalGroup(
            minus8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus8);
        minus8.setBounds(292, 818, 23, 23);

        plus9.setOpaque(false);
        plus9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus9Layout = new javax.swing.GroupLayout(plus9);
        plus9.setLayout(plus9Layout);
        plus9Layout.setHorizontalGroup(
            plus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus9Layout.setVerticalGroup(
            plus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus9);
        plus9.setBounds(606, 818, 23, 23);

        minus9.setOpaque(false);
        minus9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus9Layout = new javax.swing.GroupLayout(minus9);
        minus9.setLayout(minus9Layout);
        minus9Layout.setHorizontalGroup(
            minus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus9Layout.setVerticalGroup(
            minus9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus9);
        minus9.setBounds(522, 818, 23, 23);

        plus10.setOpaque(false);
        plus10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus10Layout = new javax.swing.GroupLayout(plus10);
        plus10.setLayout(plus10Layout);
        plus10Layout.setHorizontalGroup(
            plus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus10Layout.setVerticalGroup(
            plus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus10);
        plus10.setBounds(145, 1108, 23, 23);

        minus10.setOpaque(false);
        minus10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus10Layout = new javax.swing.GroupLayout(minus10);
        minus10.setLayout(minus10Layout);
        minus10Layout.setHorizontalGroup(
            minus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus10Layout.setVerticalGroup(
            minus10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus10);
        minus10.setBounds(62, 1108, 23, 23);

        plus11.setOpaque(false);
        plus11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus11Layout = new javax.swing.GroupLayout(plus11);
        plus11.setLayout(plus11Layout);
        plus11Layout.setHorizontalGroup(
            plus11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus11Layout.setVerticalGroup(
            plus11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus11);
        plus11.setBounds(376, 1108, 23, 23);

        minus11.setOpaque(false);
        minus11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus11Layout = new javax.swing.GroupLayout(minus11);
        minus11.setLayout(minus11Layout);
        minus11Layout.setHorizontalGroup(
            minus11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus11Layout.setVerticalGroup(
            minus11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus11);
        minus11.setBounds(292, 1108, 23, 23);

        plus12.setOpaque(false);
        plus12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus12Layout = new javax.swing.GroupLayout(plus12);
        plus12.setLayout(plus12Layout);
        plus12Layout.setHorizontalGroup(
            plus12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus12Layout.setVerticalGroup(
            plus12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus12);
        plus12.setBounds(606, 1108, 23, 23);

        minus12.setOpaque(false);
        minus12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus12Layout = new javax.swing.GroupLayout(minus12);
        minus12.setLayout(minus12Layout);
        minus12Layout.setHorizontalGroup(
            minus12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus12Layout.setVerticalGroup(
            minus12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus12);
        minus12.setBounds(522, 1108, 23, 23);

        plus13.setOpaque(false);
        plus13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus13Layout = new javax.swing.GroupLayout(plus13);
        plus13.setLayout(plus13Layout);
        plus13Layout.setHorizontalGroup(
            plus13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus13Layout.setVerticalGroup(
            plus13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus13);
        plus13.setBounds(145, 1398, 23, 23);

        minus13.setOpaque(false);
        minus13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus13Layout = new javax.swing.GroupLayout(minus13);
        minus13.setLayout(minus13Layout);
        minus13Layout.setHorizontalGroup(
            minus13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus13Layout.setVerticalGroup(
            minus13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus13);
        minus13.setBounds(62, 1398, 23, 23);

        plus14.setOpaque(false);
        plus14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus14Layout = new javax.swing.GroupLayout(plus14);
        plus14.setLayout(plus14Layout);
        plus14Layout.setHorizontalGroup(
            plus14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus14Layout.setVerticalGroup(
            plus14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus14);
        plus14.setBounds(376, 1398, 23, 23);

        minus14.setOpaque(false);
        minus14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus14Layout = new javax.swing.GroupLayout(minus14);
        minus14.setLayout(minus14Layout);
        minus14Layout.setHorizontalGroup(
            minus14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus14Layout.setVerticalGroup(
            minus14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus14);
        minus14.setBounds(292, 1398, 23, 23);

        plus15.setOpaque(false);
        plus15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus15Layout = new javax.swing.GroupLayout(plus15);
        plus15.setLayout(plus15Layout);
        plus15Layout.setHorizontalGroup(
            plus15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus15Layout.setVerticalGroup(
            plus15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus15);
        plus15.setBounds(606, 1398, 23, 23);

        minus15.setOpaque(false);
        minus15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus15Layout = new javax.swing.GroupLayout(minus15);
        minus15.setLayout(minus15Layout);
        minus15Layout.setHorizontalGroup(
            minus15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus15Layout.setVerticalGroup(
            minus15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus15);
        minus15.setBounds(522, 1398, 23, 23);

        plus16.setOpaque(false);
        plus16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus16Layout = new javax.swing.GroupLayout(plus16);
        plus16.setLayout(plus16Layout);
        plus16Layout.setHorizontalGroup(
            plus16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus16Layout.setVerticalGroup(
            plus16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus16);
        plus16.setBounds(145, 1688, 23, 23);

        minus16.setOpaque(false);
        minus16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus16Layout = new javax.swing.GroupLayout(minus16);
        minus16.setLayout(minus16Layout);
        minus16Layout.setHorizontalGroup(
            minus16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus16Layout.setVerticalGroup(
            minus16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus16);
        minus16.setBounds(62, 1688, 23, 23);

        plus17.setOpaque(false);
        plus17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus17Layout = new javax.swing.GroupLayout(plus17);
        plus17.setLayout(plus17Layout);
        plus17Layout.setHorizontalGroup(
            plus17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus17Layout.setVerticalGroup(
            plus17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus17);
        plus17.setBounds(376, 1688, 23, 23);

        minus17.setOpaque(false);
        minus17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus17Layout = new javax.swing.GroupLayout(minus17);
        minus17.setLayout(minus17Layout);
        minus17Layout.setHorizontalGroup(
            minus17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus17Layout.setVerticalGroup(
            minus17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus17);
        minus17.setBounds(292, 1688, 23, 23);

        plus18.setOpaque(false);
        plus18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus18Layout = new javax.swing.GroupLayout(plus18);
        plus18.setLayout(plus18Layout);
        plus18Layout.setHorizontalGroup(
            plus18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus18Layout.setVerticalGroup(
            plus18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus18);
        plus18.setBounds(606, 1688, 23, 23);

        minus18.setOpaque(false);
        minus18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus18Layout = new javax.swing.GroupLayout(minus18);
        minus18.setLayout(minus18Layout);
        minus18Layout.setHorizontalGroup(
            minus18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus18Layout.setVerticalGroup(
            minus18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus18);
        minus18.setBounds(522, 1688, 23, 23);

        plus19.setOpaque(false);
        plus19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus19Layout = new javax.swing.GroupLayout(plus19);
        plus19.setLayout(plus19Layout);
        plus19Layout.setHorizontalGroup(
            plus19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus19Layout.setVerticalGroup(
            plus19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus19);
        plus19.setBounds(145, 1978, 23, 23);

        minus19.setOpaque(false);
        minus19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus19Layout = new javax.swing.GroupLayout(minus19);
        minus19.setLayout(minus19Layout);
        minus19Layout.setHorizontalGroup(
            minus19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus19Layout.setVerticalGroup(
            minus19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus19);
        minus19.setBounds(62, 1978, 23, 23);

        plus20.setOpaque(false);
        plus20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus20Layout = new javax.swing.GroupLayout(plus20);
        plus20.setLayout(plus20Layout);
        plus20Layout.setHorizontalGroup(
            plus20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus20Layout.setVerticalGroup(
            plus20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus20);
        plus20.setBounds(376, 1978, 23, 23);

        minus20.setOpaque(false);
        minus20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus20Layout = new javax.swing.GroupLayout(minus20);
        minus20.setLayout(minus20Layout);
        minus20Layout.setHorizontalGroup(
            minus20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus20Layout.setVerticalGroup(
            minus20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus20);
        minus20.setBounds(292, 1978, 23, 23);

        plus21.setOpaque(false);
        plus21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plus21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plus21Layout = new javax.swing.GroupLayout(plus21);
        plus21.setLayout(plus21Layout);
        plus21Layout.setHorizontalGroup(
            plus21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        plus21Layout.setVerticalGroup(
            plus21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(plus21);
        plus21.setBounds(606, 1978, 23, 23);

        minus21.setOpaque(false);
        minus21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minus21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minus21Layout = new javax.swing.GroupLayout(minus21);
        minus21.setLayout(minus21Layout);
        minus21Layout.setHorizontalGroup(
            minus21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        minus21Layout.setVerticalGroup(
            minus21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel1.add(minus21);
        minus21.setBounds(522, 1978, 23, 23);

        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu1);
        menu1.setBounds(-50, -50, 300, 391);

        menu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu3);
        menu3.setBounds(410, -50, 300, 391);

        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu2);
        menu2.setBounds(180, -50, 300, 391);

        menu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu4);
        menu4.setBounds(-50, 240, 300, 391);

        menu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu5);
        menu5.setBounds(180, 240, 300, 391);

        menu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu6);
        menu6.setBounds(410, 240, 300, 391);

        menu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu7);
        menu7.setBounds(180, 520, 300, 391);

        menu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu8);
        menu8.setBounds(-50, 520, 300, 391);

        menu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu9);
        menu9.setBounds(410, 520, 300, 391);

        menu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu10);
        menu10.setBounds(180, 810, 300, 391);

        menu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu11);
        menu11.setBounds(-50, 810, 300, 391);

        menu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu12);
        menu12.setBounds(410, 810, 300, 391);

        menu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu13);
        menu13.setBounds(410, 1100, 300, 391);

        menu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu14);
        menu14.setBounds(180, 1100, 300, 391);

        menu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu15);
        menu15.setBounds(-50, 1100, 300, 391);

        menu16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu16);
        menu16.setBounds(180, 1390, 300, 391);

        menu17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu17);
        menu17.setBounds(410, 1390, 300, 391);

        menu18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu18);
        menu18.setBounds(-50, 1390, 300, 391);

        menu19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu19);
        menu19.setBounds(410, 1680, 300, 391);

        menu20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu20);
        menu20.setBounds(-50, 1680, 300, 391);

        menu21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pembeli/card menu one.png"))); // NOI18N
        jPanel1.add(menu21);
        menu21.setBounds(180, 1680, 300, 391);

        jScrollPane1.setViewportView(jPanel1);

        promosimenu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 192, 714, 539));

        btn_delete.setText("Delete");
        btn_delete.setMinimumSize(new java.awt.Dimension(60, 23));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        promosimenu.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 430, 330, 20));

        btnsnack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsnack.setOpaque(false);
        btnsnack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsnackMouseClicked(evt);
            }
        });

        labelsnack.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelsnack.setText("Snack");

        javax.swing.GroupLayout btnsnackLayout = new javax.swing.GroupLayout(btnsnack);
        btnsnack.setLayout(btnsnackLayout);
        btnsnackLayout.setHorizontalGroup(
            btnsnackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnsnackLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(labelsnack, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        btnsnackLayout.setVerticalGroup(
            btnsnackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnsnackLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelsnack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        promosimenu.add(btnsnack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        promosi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        promosi.setOpaque(false);
        promosi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                promosiMouseClicked(evt);
            }
        });

        labelpromosi.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelpromosi.setText("Promosi");

        javax.swing.GroupLayout promosiLayout = new javax.swing.GroupLayout(promosi);
        promosi.setLayout(promosiLayout);
        promosiLayout.setHorizontalGroup(
            promosiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, promosiLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(labelpromosi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        promosiLayout.setVerticalGroup(
            promosiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, promosiLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(labelpromosi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        promosimenu.add(promosi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        btnmakanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmakanan.setOpaque(false);
        btnmakanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmakananMouseClicked(evt);
            }
        });

        labelmakanan.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelmakanan.setText("Makanan");

        javax.swing.GroupLayout btnmakananLayout = new javax.swing.GroupLayout(btnmakanan);
        btnmakanan.setLayout(btnmakananLayout);
        btnmakananLayout.setHorizontalGroup(
            btnmakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnmakananLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(labelmakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        btnmakananLayout.setVerticalGroup(
            btnmakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnmakananLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(labelmakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        promosimenu.add(btnmakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        btnminuman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnminuman.setOpaque(false);
        btnminuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnminumanMouseClicked(evt);
            }
        });

        labelminuman.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        labelminuman.setText("Minuman");

        javax.swing.GroupLayout btnminumanLayout = new javax.swing.GroupLayout(btnminuman);
        btnminuman.setLayout(btnminumanLayout);
        btnminumanLayout.setHorizontalGroup(
            btnminumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnminumanLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(labelminuman, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        btnminumanLayout.setVerticalGroup(
            btnminumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnminumanLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelminuman, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        promosimenu.add(btnminuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        total.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        promosimenu.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 460, 190, 40));

        btnmulaidariawal.setBackground(new java.awt.Color(255, 255, 255));
        btnmulaidariawal.setOpaque(false);
        btnmulaidariawal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmulaidariawalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnmulaidariawalLayout = new javax.swing.GroupLayout(btnmulaidariawal);
        btnmulaidariawal.setLayout(btnmulaidariawalLayout);
        btnmulaidariawalLayout.setHorizontalGroup(
            btnmulaidariawalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        btnmulaidariawalLayout.setVerticalGroup(
            btnmulaidariawalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        promosimenu.add(btnmulaidariawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 700, 100, 60));

        btncheckout.setOpaque(false);
        btncheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncheckoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btncheckoutLayout = new javax.swing.GroupLayout(btncheckout);
        btncheckout.setLayout(btncheckoutLayout);
        btncheckoutLayout.setHorizontalGroup(
            btncheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        btncheckoutLayout.setVerticalGroup(
            btncheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        promosimenu.add(btncheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 690, 165, 80));

        inputsearch.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inputsearch.setForeground(new java.awt.Color(102, 102, 102));
        inputsearch.setBorder(null);
        inputsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsearchActionPerformed(evt);
            }
        });
        inputsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputsearchKeyPressed(evt);
            }
        });
        promosimenu.add(inputsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 143, 210, 30));

        btnsearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsearch.setOpaque(false);
        btnsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnsearchLayout = new javax.swing.GroupLayout(btnsearch);
        btnsearch.setLayout(btnsearchLayout);
        btnsearchLayout.setHorizontalGroup(
            btnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        btnsearchLayout.setVerticalGroup(
            btnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        promosimenu.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 140, 40, 38));

        btnscan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnscan.setOpaque(false);
        btnscan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnscanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnscanLayout = new javax.swing.GroupLayout(btnscan);
        btnscan.setLayout(btnscanLayout);
        btnscanLayout.setHorizontalGroup(
            btnscanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        btnscanLayout.setVerticalGroup(
            btnscanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        promosimenu.add(btnscan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 497, 172, 160));

        btnlogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogOut.setOpaque(false);
        btnlogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnlogOutLayout = new javax.swing.GroupLayout(btnlogOut);
        btnlogOut.setLayout(btnlogOutLayout);
        btnlogOutLayout.setHorizontalGroup(
            btnlogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        btnlogOutLayout.setVerticalGroup(
            btnlogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        promosimenu.add(btnlogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 170, 60));

        labelnopesanan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelnopesanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        promosimenu.add(labelnopesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 300, 40));

        bgpesananscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/daftar pesanan after scan.png"))); // NOI18N
        promosimenu.add(bgpesananscan, new org.netbeans.lib.awtextra.AbsoluteConstraints(922, -44, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kasir/tampilannn menuuu.png"))); // NOI18N
        promosimenu.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Q1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Q1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q1.setText("0");
        promosimenu.add(Q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 50));

        Q3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Q3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Q3.setText("0");
        promosimenu.add(Q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 60, 60));

        finalPilihTempatMakan.setPreferredSize(new java.awt.Dimension(200, 16));
        promosimenu.add(finalPilihTempatMakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 620, -1, -1));

        bal.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        bal.setForeground(new java.awt.Color(255, 255, 255));
        promosimenu.add(bal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 570, 190, 50));

        getContentPane().add(promosimenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsnackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsnackMouseClicked
        //refresh tampilan data
        timer.stop();
        scheduleDataUpdate("SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id WHERE kategori_menu.kategori_nama = 'Snack'");
        //reset jmlhMenu
        String jmlhmenu = "jmlhmenu";
        for(int i=1;i<=21;i++){
            String jmlhMenuName = jmlhmenu+i;
            try {
                JLabel jmlhMenu = (JLabel) getClass().getDeclaredField(jmlhMenuName).get(this);
                jmlhMenu.setText("0");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Mengubah gaya font labelPromosi menjadi bold
        Font fontPromosi = labelpromosi.getFont();
        Font boldFontPromosi = fontPromosi.deriveFont(Font.PLAIN);
        labelpromosi.setFont(boldFontPromosi);
        
        // Mengubah gaya font labelMakanan menjadi plain
        Font fontMakanan = labelmakanan.getFont();
        Font plainFontMakanan = fontMakanan.deriveFont(Font.PLAIN);
        labelmakanan.setFont(plainFontMakanan);

        // Mengubah gaya font labelMinuman menjadi plain
        Font fontMinuman = labelminuman.getFont();
        Font plainFontMinuman = fontMinuman.deriveFont(Font.PLAIN);
        labelminuman.setFont(plainFontMinuman);

        // Mengubah gaya font labelSnack menjadi plain
        Font fontSnack = labelsnack.getFont();
        Font plainFontSnack = fontSnack.deriveFont(Font.BOLD);
        labelsnack.setFont(plainFontSnack);
        
        //merubah judul menjadi Promosi
        labeljudulform.setText("Snack");
    }//GEN-LAST:event_btnsnackMouseClicked

    private void btnmakananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmakananMouseClicked
        timer.stop();
        scheduleDataUpdate("SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id WHERE kategori_menu.kategori_nama = 'Makanan'");
        //reset jmlhmenu
        String jmlhmenu = "jmlhmenu";
        for(int i=1;i<=21;i++){
            String jmlhMenuName = jmlhmenu+i;
            try {
                JLabel jmlhMenu = (JLabel) getClass().getDeclaredField(jmlhMenuName).get(this);
                jmlhMenu.setText("0");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Mengubah gaya font labelPromosi menjadi bold
        Font fontPromosi = labelpromosi.getFont();
        Font boldFontPromosi = fontPromosi.deriveFont(Font.PLAIN);
        labelpromosi.setFont(boldFontPromosi);
        
        // Mengubah gaya font labelMakanan menjadi plain
        Font fontMakanan = labelmakanan.getFont();
        Font plainFontMakanan = fontMakanan.deriveFont(Font.BOLD);
        labelmakanan.setFont(plainFontMakanan);

        // Mengubah gaya font labelMinuman menjadi plain
        Font fontMinuman = labelminuman.getFont();
        Font plainFontMinuman = fontMinuman.deriveFont(Font.PLAIN);
        labelminuman.setFont(plainFontMinuman);

        // Mengubah gaya font labelSnack menjadi plain
        Font fontSnack = labelsnack.getFont();
        Font plainFontSnack = fontSnack.deriveFont(Font.PLAIN);
        labelsnack.setFont(plainFontSnack);
        
        //merubah judul menjadi Promosi
        labeljudulform.setText("Makanan");
    }//GEN-LAST:event_btnmakananMouseClicked

    private void btnminumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnminumanMouseClicked
        timer.stop();
        scheduleDataUpdate("SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id WHERE kategori_menu.kategori_nama = 'Minuman'");
        //reset jmlhMenu
        String jmlhmenu = "jmlhmenu";
        for(int i=1;i<=21;i++){
            String jmlhMenuName = jmlhmenu+i;
            try {
                JLabel jmlhMenu = (JLabel) getClass().getDeclaredField(jmlhMenuName).get(this);
                jmlhMenu.setText("0");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Mengubah gaya font labelPromosi menjadi bold
        
        Font fontPromosi = labelpromosi.getFont();
        Font boldFontPromosi = fontPromosi.deriveFont(Font.PLAIN);
        labelpromosi.setFont(boldFontPromosi);
        
        // Mengubah gaya font labelMakanan menjadi plain
        Font fontMakanan = labelmakanan.getFont();
        Font plainFontMakanan = fontMakanan.deriveFont(Font.PLAIN);
        labelmakanan.setFont(plainFontMakanan);

        // Mengubah gaya font labelMinuman menjadi plain
        Font fontMinuman = labelminuman.getFont();
        Font plainFontMinuman = fontMinuman.deriveFont(Font.BOLD);
        labelminuman.setFont(plainFontMinuman);

        // Mengubah gaya font labelSnack menjadi plain
        Font fontSnack = labelsnack.getFont();
        Font plainFontSnack = fontSnack.deriveFont(Font.PLAIN);
        labelsnack.setFont(plainFontSnack);
        
        //merubah judul menjadi Promosi
        labeljudulform.setText("Minuman");
    }//GEN-LAST:event_btnminumanMouseClicked

    private void promosiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_promosiMouseClicked
        timer.stop();
        scheduleDataUpdate("SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id WHERE kategori_menu.kategori_nama = 'Promosi'");
        //reset jmlhMenu
        String jmlhmenu = "jmlhmenu";
        for(int i=1;i<=21;i++){
            String jmlhMenuName = jmlhmenu+i;
            try {
                JLabel jmlhMenu = (JLabel) getClass().getDeclaredField(jmlhMenuName).get(this);
                jmlhMenu.setText("0");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Mengubah gaya font labelPromosi menjadi bold
        Font fontPromosi = labelpromosi.getFont();
        Font boldFontPromosi = fontPromosi.deriveFont(Font.BOLD);
        labelpromosi.setFont(boldFontPromosi);
        
        // Mengubah gaya font labelMakanan menjadi plain
        Font fontMakanan = labelmakanan.getFont();
        Font plainFontMakanan = fontMakanan.deriveFont(Font.PLAIN);
        labelmakanan.setFont(plainFontMakanan);

        // Mengubah gaya font labelMinuman menjadi plain
        Font fontMinuman = labelminuman.getFont();
        Font plainFontMinuman = fontMinuman.deriveFont(Font.PLAIN);
        labelminuman.setFont(plainFontMinuman);

        // Mengubah gaya font labelSnack menjadi plain
        Font fontSnack = labelsnack.getFont();
        Font plainFontSnack = fontSnack.deriveFont(Font.PLAIN);
        labelsnack.setFont(plainFontSnack);
        
        //merubah judul menjadi Promosi
        labeljudulform.setText("Promosi");
    }//GEN-LAST:event_promosiMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        String r = dt.getValueAt(jTable1.getSelectedRow(), 0).toString();
        System.out.println(r);

        // Remove produk
        int rw = jTable1.getSelectedRow();
        dt.removeRow(rw);

        // Remove jumlah
        switch (r) {
            case " 1 ":
                Q1.setText("0");
                break;

            case " 3 ":
                Q3.setText("0");
                break;

            default:
                System.out.println("Over");
        }

        // Mengurangi nilai total dengan harga
        int hargaIndex = 2; // Indeks kolom harga
        double harga = Double.parseDouble(dt.getValueAt(rw, hargaIndex).toString());
        double totalfinal = Double.parseDouble(total.getText());
        totalfinal -= harga;

        // Tetapkan nilai total yang telah dikurangi ke jLabelTotal
        total.setText(Double.toString(totalfinal));

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btnmulaidariawalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmulaidariawalMouseClicked
        this.dispose();
        new PilihTempatMakan().setVisible(true);
    }//GEN-LAST:event_btnmulaidariawalMouseClicked

    private void btncheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncheckoutMouseClicked
        
    }//GEN-LAST:event_btncheckoutMouseClicked

    private void inputsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputsearchActionPerformed

    private void btnsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseClicked
        timer.stop();
        scheduleDataUpdate("SELECT *\n" +
            "FROM menu\n" +
            "INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id\n" +
            "WHERE menu.nama_menu LIKE '%"+inputsearch.getText()+"%'");
    }//GEN-LAST:event_btnsearchMouseClicked

    private void inputsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputsearchKeyPressed

    private void checkout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkout1MouseClicked
        printstruk.setEnabled(true);
        String paycheck = pay.getText(); // Mengambil teks dari JTextField
        int tot = Integer.valueOf(total.getText().replaceAll(",", ""));
        int paid = 0;
        if (!paycheck.isEmpty()) {
            paid = Integer.valueOf(paycheck.replaceAll(",", ""));
            if(tot<paid){
                int balance = paid - tot;

                DecimalFormat df = new DecimalFormat();

                bal1.setText(String.valueOf(df.format(balance)));
                popuppilihTempatMakan.setVisible(true);
                btnBawaPulang.setVisible(true);
                btnMakanDisini.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Pembayaran harus lebih dari total harga pemesanan");
            }
        }else if(paycheck.isEmpty()){
            JOptionPane.showMessageDialog(this, "Masukkan Nominal Pembayaran");
        }
        
        
    }//GEN-LAST:event_checkout1MouseClicked

    private void printstrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printstrukActionPerformed
        timer.stop();
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin memproses pesanan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
                    String nomorPesanan = getRandomNumberString();
                    boolean isExist = checkIfNumberExistsInTransaksiTable(nomorPesanan);

                    while (isExist) {
                        nomorPesanan = getRandomNumberString();
                        isExist = checkIfNumberExistsInTransaksiTable(nomorPesanan);
                    }
                    
                DefaultTableModel modelSementara = (DefaultTableModel) jTable1.getModel();
                int rowCount = modelSementara.getRowCount();

                String queryInsertPrepare = "INSERT INTO transaksi VALUES (?,?,?,?)";
                String queryInsert = "INSERT INTO detail_transaksi (id_transaksi, id_menu, jumlah) VALUES (?, ?, ?)";
                String querySelectIdMenu = "SELECT id_menu FROM menu WHERE nama_menu = ?";

                try (Connection conn = Config.configDB(); 
                     PreparedStatement InsertPrepareStatement = conn.prepareStatement(queryInsertPrepare);
                     PreparedStatement insertStatement = conn.prepareStatement(queryInsert);
                     PreparedStatement selectIdMenuStatement = conn.prepareStatement(querySelectIdMenu)) 
                    {
                         // Mengatur tanggal saat ini
                         LocalDate currentDate = LocalDate.now();
                         Timestamp sqlTimestamp = Timestamp.valueOf(currentDate.atStartOfDay());

                         //convert string nomorpesanan ke long 
                         long nomorPesananLong = Long.parseLong(nomorPesanan);

                         //get PilihTempatMakan
                         String pilihTempatMakan = finalPilihTempatMakan.getText();
                         //insert ke kolom transaksi
                         InsertPrepareStatement.setLong(1, nomorPesananLong);
                         InsertPrepareStatement.setString(2, pilihTempatMakan);
                         InsertPrepareStatement.setTimestamp(3, sqlTimestamp);
                         InsertPrepareStatement.setString(4, "Sedang Dimasak");
                         InsertPrepareStatement.executeUpdate();

                        for (int row = 0; row < rowCount; row++) {
                            String namaMenu = (String) modelSementara.getValueAt(row, 1);
                            int jumlahMenu = (int) modelSementara.getValueAt(row, 2);

                            // Mengambil id_menu berdasarkan nama_menu dari tabel menu
                            selectIdMenuStatement.setString(1, namaMenu);
                            ResultSet resultSet = selectIdMenuStatement.executeQuery();

                            if (resultSet.next()) {
                                int idMenu = resultSet.getInt("id_menu");

                                // Memasukkan data ke tabel detail_transaksi
                                insertStatement.setString(1, nomorPesanan);
                                insertStatement.setInt(2, idMenu);
                                insertStatement.setInt(3, jumlahMenu);

                                insertStatement.executeUpdate();
                            }
                        }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                //tampilkan form struk
                bgstruk.setVisible(true);
                scrollpaneStruk.setVisible(true);
                //kode buat cetak struk
                CetakLast();
                
                //hide popup struk
                scheduleHideStruk();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // Menghapus semua baris dalam JTable

                total.setText(""); // Mengosongkan JLabel
               
            } else {
            // Jika tombol No ditekan, tutup popup konfirmasi
            JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(btncheckout);
            dialog.dispose();
        }
        try {
            Thread.sleep(10000);
            scheduleDataUpdate("SELECT * FROM menu INNER JOIN kategori_menu ON kategori_menu.kategori_id = menu.kategori_id WHERE kategori_menu.kategori_nama = 'Promosi'");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_printstrukActionPerformed

    private void btnMakanDisiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMakanDisiniMouseClicked
        finalPilihTempatMakan.setText("Makan Di Sini");
        popuppilihTempatMakan.setVisible(false);
        btnBawaPulang.setVisible(false);
        btnMakanDisini.setVisible(false);
    }//GEN-LAST:event_btnMakanDisiniMouseClicked

    private void btnBawaPulangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBawaPulangMouseClicked
        finalPilihTempatMakan.setText("Bawa Pulang");
        popuppilihTempatMakan.setVisible(false);
        btnBawaPulang.setVisible(false);
        btnMakanDisini.setVisible(false);
    }//GEN-LAST:event_btnBawaPulangMouseClicked

    private void btnlogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogOutMouseClicked
        this.setVisible(false);
        new MainDisplay().setVisible(true);
    }//GEN-LAST:event_btnlogOutMouseClicked

    private void scannikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scannikActionPerformed
        try {
            String sql = "SELECT detail_transaksi.id_transaksi, detail_transaksi.id_menu, menu.nama_menu, detail_transaksi.jumlah, menu.harga FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu = detail_transaksi.id_menu WHERE detail_transaksi.id_transaksi = ?";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, scannik.getText());
            java.sql.ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                popupPemindaianBerhasil.setVisible(true);
                Thread.sleep(3000);  // Delay for 3 seconds
                popupPemindaianBerhasil.setVisible(false);
            } else {
                popupPemindaianGagal.setVisible(true);
                Thread.sleep(3000);  // Delay for 3 seconds
                popupPemindaianGagal.setVisible(false);
                scannik.setEnabled(true);  // Enable input again
                return;  // Exit the method, don't proceed with the rest of the code
            }

            List<Integer> hargaList = new ArrayList<>();

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("ID Menu");
            tableModel.addColumn("Nama Menu");
            tableModel.addColumn("Jumlah");
            tableModel.addColumn("Harga");

            rs.beforeFirst();  // Move the cursor back to before the first row

            while (rs.next()) {
                String noPesanan = rs.getString("id_transaksi");
                labelnopesanan.setText("No. " + noPesanan);

                String idMenu = rs.getString("id_menu");
                String namaMenu = rs.getString("nama_menu");
                int jumlah = rs.getInt("jumlah");
                int harga = rs.getInt("harga");

                hargaList.add(harga);

                tableModel.addRow(new Object[]{idMenu, namaMenu, jumlah, harga});
            }

            jTable1.setModel(tableModel);

            // Menghitung total harga
            int totalHarga = 0;
            for (int harga : hargaList) {
                totalHarga += harga;
            }

            // Mengatur teks total dengan format angka
            total.setText(String.format("%,d", totalHarga));

            bgpesananscan.setVisible(true);
            labelnopesanan.setVisible(true);
            popupScanWait.setVisible(false);
            scannik.setVisible(false);
            popupPemindaianGagal.setVisible(false);

        } catch (SQLException ex) {
            Logger.getLogger(Login1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Login1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scannikActionPerformed

    private void btnclosepopupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclosepopupMouseClicked
        btnclosepopup.setVisible(false);
        popupPemindaianBerhasil.setVisible(false);
        popupPemindaianGagal.setVisible(false);
        popupScanWait.setVisible(false);
        scannik.setVisible(false);
    }//GEN-LAST:event_btnclosepopupMouseClicked

    private void btnscanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnscanMouseClicked
        btnclosepopup.setVisible(true);
        popupScanWait.setVisible(true);
        scannik.setVisible(true);
        scannik.requestFocus();
    }//GEN-LAST:event_btnscanMouseClicked

    private void plus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus2MouseClicked
        int i = Integer.parseInt(jmlhmenu2.getText());
        i++;
        jmlhmenu2.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu2.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu2.getText(), i, Integer.parseInt(harga2.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu2.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga2.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus2MouseClicked

    private void minus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus2MouseClicked
        int i = Integer.parseInt(jmlhmenu2.getText());
        if (i > 0) {
            i--;
            jmlhmenu2.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu2.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu2.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga2.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }

    }//GEN-LAST:event_minus2MouseClicked

    private void plus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus1MouseClicked
        int i = Integer.parseInt(jmlhmenu1.getText());
        i++;
        jmlhmenu1.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu1.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu1.getText(), i, Integer.parseInt(harga1.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu1.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga1.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();

    }//GEN-LAST:event_plus1MouseClicked

    private void minus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus1MouseClicked
        int i = Integer.parseInt(jmlhmenu1.getText());
        if (i > 0) {
            i--;
            jmlhmenu1.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu1.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu1.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga1.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus1MouseClicked

    private void plus3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus3MouseClicked

        int i = Integer.parseInt(jmlhmenu3.getText());
        i++;
        jmlhmenu3.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu3.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu3.getText(), i, Integer.parseInt(harga3.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu3.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga3.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus3MouseClicked

    private void minus3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus3MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu3.getText());
        if (i > 0) {
            i--;
            jmlhmenu3.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu3.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu3.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga3.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus3MouseClicked

    private void plus4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus4MouseClicked
        int i = Integer.parseInt(jmlhmenu4.getText());
        i++;
        jmlhmenu4.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu4.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu4.getText(), i, Integer.parseInt(harga4.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu4.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga4.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus4MouseClicked

    private void minus4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus4MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu4.getText());
        if (i > 0) {
            i--;
            jmlhmenu4.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu4.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu4.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga4.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus4MouseClicked

    private void plus5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus5MouseClicked
        int i = Integer.parseInt(jmlhmenu5.getText());
        i++;
        jmlhmenu5.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu5.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu5.getText(), i, Integer.parseInt(harga5.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu5.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga5.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus5MouseClicked

    private void minus5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus5MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu5.getText());
        if (i > 0) {
            i--;
            jmlhmenu5.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu5.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu5.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga5.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus5MouseClicked

    private void plus6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus6MouseClicked
        int i = Integer.parseInt(jmlhmenu6.getText());
        i++;
        jmlhmenu6.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu6.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu6.getText(), i, Integer.parseInt(harga6.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu6.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga6.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus6MouseClicked

    private void minus6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus6MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu6.getText());
        if (i > 0) {
            i--;
            jmlhmenu6.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu6.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu6.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga6.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus6MouseClicked

    private void plus7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus7MouseClicked
        int i = Integer.parseInt(jmlhmenu7.getText());
        i++;
        jmlhmenu7.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu7.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu7.getText(), i, Integer.parseInt(harga7.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu7.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga7.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus7MouseClicked

    private void minus7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus7MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu7.getText());
        if (i > 0) {
            i--;
            jmlhmenu7.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu7.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu7.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga7.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus7MouseClicked

    private void plus8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus8MouseClicked
        int i = Integer.parseInt(jmlhmenu8.getText());
        i++;
        jmlhmenu8.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu8.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu8.getText(), i, Integer.parseInt(harga8.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu8.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga8.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus8MouseClicked

    private void minus8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus8MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu8.getText());
        if (i > 0) {
            i--;
            jmlhmenu8.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu8.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu8.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga8.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus8MouseClicked

    private void plus9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus9MouseClicked
        int i = Integer.parseInt(jmlhmenu9.getText());
        i++;
        jmlhmenu9.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu9.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu9.getText(), i, Integer.parseInt(harga9.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu9.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga9.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus9MouseClicked

    private void minus9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus9MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu9.getText());
        if (i > 0) {
            i--;
            jmlhmenu9.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu9.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu9.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga9.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus9MouseClicked

    private void plus10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus10MouseClicked
        int i = Integer.parseInt(jmlhmenu10.getText());
        i++;
        jmlhmenu10.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu10.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu10.getText(), i, Integer.parseInt(harga10.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu10.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga10.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus10MouseClicked

    private void minus10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus10MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu10.getText());
        if (i > 0) {
            i--;
            jmlhmenu10.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu10.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu10.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga10.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus10MouseClicked

    private void plus11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus11MouseClicked
        int i = Integer.parseInt(jmlhmenu11.getText());
        i++;
        jmlhmenu11.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu11.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu11.getText(), i, Integer.parseInt(harga11.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu11.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga11.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus11MouseClicked

    private void minus11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus11MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu11.getText());
        if (i > 0) {
            i--;
            jmlhmenu11.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu11.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu11.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga11.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus11MouseClicked

    private void plus12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus12MouseClicked
        int i = Integer.parseInt(jmlhmenu12.getText());
        i++;
        jmlhmenu12.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu12.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu12.getText(), i, Integer.parseInt(harga12.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu12.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga12.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus12MouseClicked

    private void minus12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus12MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu12.getText());
        if (i > 0) {
            i--;
            jmlhmenu12.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu12.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu12.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga12.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus12MouseClicked

    private void plus13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus13MouseClicked
        int i = Integer.parseInt(jmlhmenu13.getText());
        i++;
        jmlhmenu13.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu13.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu13.getText(), i, Integer.parseInt(harga13.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu13.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga13.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus13MouseClicked

    private void minus13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus13MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu13.getText());
        if (i > 0) {
            i--;
            jmlhmenu13.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu13.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu13.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga13.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus13MouseClicked

    private void plus14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus14MouseClicked
        int i = Integer.parseInt(jmlhmenu14.getText());
        i++;
        jmlhmenu14.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu14.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu14.getText(), i, Integer.parseInt(harga14.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu14.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga14.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus14MouseClicked

    private void minus14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus14MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu14.getText());
        if (i > 0) {
            i--;
            jmlhmenu14.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu14.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu14.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga14.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus14MouseClicked

    private void plus15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus15MouseClicked
        int i = Integer.parseInt(jmlhmenu15.getText());
        i++;
        jmlhmenu15.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu15.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu15.getText(), i, Integer.parseInt(harga15.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu15.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga15.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus15MouseClicked

    private void minus15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus15MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu15.getText());
        if (i > 0) {
            i--;
            jmlhmenu15.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu15.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu15.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga15.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus15MouseClicked

    private void plus16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus16MouseClicked
        int i = Integer.parseInt(jmlhmenu16.getText());
        i++;
        jmlhmenu16.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu16.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu16.getText(), i, Integer.parseInt(harga16.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu1.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga1.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus16MouseClicked

    private void minus16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus16MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu16.getText());
        if (i > 0) {
            i--;
            jmlhmenu16.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu16.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu16.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga16.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus16MouseClicked

    private void plus17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus17MouseClicked
        int i = Integer.parseInt(jmlhmenu17.getText());
        i++;
        jmlhmenu17.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu17.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu17.getText(), i, Integer.parseInt(harga17.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu17.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga17.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus17MouseClicked

    private void minus17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus17MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu17.getText());
        if (i > 0) {
            i--;
            jmlhmenu17.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu17.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu17.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga17.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus17MouseClicked

    private void plus18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus18MouseClicked
        int i = Integer.parseInt(jmlhmenu18.getText());
        i++;
        jmlhmenu18.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu18.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu18.getText(), i, Integer.parseInt(harga18.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu18.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga18.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus18MouseClicked

    private void minus18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus18MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu18.getText());
        if (i > 0) {
            i--;
            jmlhmenu18.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu18.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu18.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga18.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus18MouseClicked

    private void plus19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus19MouseClicked
        int i = Integer.parseInt(jmlhmenu19.getText());
        i++;
        jmlhmenu19.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu19.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu19.getText(), i, Integer.parseInt(harga19.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu19.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga19.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus19MouseClicked

    private void minus19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus19MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu19.getText());
        if (i > 0) {
            i--;
            jmlhmenu19.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu19.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu19.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga19.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus19MouseClicked

    private void plus20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus20MouseClicked
        int i = Integer.parseInt(jmlhmenu20.getText());
        i++;
        jmlhmenu20.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu20.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu20.getText(), i, Integer.parseInt(harga20.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu20.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga20.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus20MouseClicked

    private void minus20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus20MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu20.getText());
        if (i > 0) {
            i--;
            jmlhmenu20.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu20.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu20.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga20.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus20MouseClicked

    private void plus21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plus21MouseClicked
        int i = Integer.parseInt(jmlhmenu21.getText());
        i++;
        jmlhmenu21.setText(String.valueOf(i));

        // Pengecekan apakah baris sudah ada sebelum menambahkannya
        boolean rowExists = false;
        int rowIndex = -1; // Indeks baris yang cocok
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            String menu = jTable1.getValueAt(row, 1).toString();
            if (menu.equals(datamenu21.getText())) {
                rowExists = true;
                rowIndex = row;
                break;
            }
        }

        // Jika baris belum ada, tambahkan ke jTable1
        if (!rowExists) {
            tablepembelian(1, datamenu21.getText(), i, Integer.parseInt(harga21.getText()));
        } else {
            // Jika baris sudah ada, tambahkan i ke nilai jumlah yang ada
            int currentJumlah = Integer.parseInt(jmlhmenu21.getText());
            jTable1.setValueAt(currentJumlah, rowIndex, 2);
            int harga = Integer.parseInt(harga1.getText());
            int updatedHarga = harga * currentJumlah;
            jTable1.setValueAt(updatedHarga, rowIndex, 3);
        }

        cal();
    }//GEN-LAST:event_plus21MouseClicked

    private void minus21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minus21MouseClicked
        //set text pada jmlhmenu3
        int i = Integer.parseInt(jmlhmenu21.getText());
        if (i > 0) {
            i--;
            jmlhmenu21.setText(String.valueOf(i));

            // Pengecekan apakah baris sudah ada sebelum menguranginya
            boolean rowExists = false;
            int rowIndex = -1; // Indeks baris yang cocok
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                String menu = jTable1.getValueAt(row, 1).toString();
                if (menu.equals(datamenu21.getText())) {
                    rowExists = true;
                    rowIndex = row;
                    break;
                }
            }

            // Jika baris belum ada, tidak perlu melakukan apa pun
            // Karena tidak ada yang dikurangi
            if (rowExists) {
                // Jika baris sudah ada, kurangi i dari nilai jumlah yang ada
                int currentJumlah = Integer.parseInt(jmlhmenu21.getText());
                jTable1.setValueAt(currentJumlah, rowIndex, 2);
                int harga = Integer.parseInt(harga21.getText());
                int updatedHarga = harga * currentJumlah;
                jTable1.setValueAt(updatedHarga, rowIndex, 3);

                if (currentJumlah == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(rowIndex);
                }
            }

            cal();
        }
    }//GEN-LAST:event_minus21MouseClicked

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
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Q1;
    private javax.swing.JLabel Q3;
    private javax.swing.JLabel background;
    private javax.swing.JLabel bal;
    private javax.swing.JLabel bal1;
    private javax.swing.JLabel bgpesananscan;
    private javax.swing.JLabel bgstruk;
    private javax.swing.JPanel btnBawaPulang;
    private javax.swing.JPanel btnMakanDisini;
    private javax.swing.JButton btn_delete;
    private javax.swing.JPanel btncheckout;
    private javax.swing.JPanel btnclosepopup;
    private javax.swing.JPanel btnlogOut;
    private javax.swing.JPanel btnmakanan;
    private javax.swing.JPanel btnminuman;
    private javax.swing.JPanel btnmulaidariawal;
    private javax.swing.JPanel btnscan;
    private javax.swing.JPanel btnsearch;
    private javax.swing.JPanel btnsnack;
    private javax.swing.JLabel checkout1;
    private javax.swing.JTextArea datamenu1;
    private javax.swing.JTextArea datamenu10;
    private javax.swing.JTextArea datamenu11;
    private javax.swing.JTextArea datamenu12;
    private javax.swing.JTextArea datamenu13;
    private javax.swing.JTextArea datamenu14;
    private javax.swing.JTextArea datamenu15;
    private javax.swing.JTextArea datamenu16;
    private javax.swing.JTextArea datamenu17;
    private javax.swing.JTextArea datamenu18;
    private javax.swing.JTextArea datamenu19;
    private javax.swing.JTextArea datamenu2;
    private javax.swing.JTextArea datamenu20;
    private javax.swing.JTextArea datamenu21;
    private javax.swing.JTextArea datamenu3;
    private javax.swing.JTextArea datamenu4;
    private javax.swing.JTextArea datamenu5;
    private javax.swing.JTextArea datamenu6;
    private javax.swing.JTextArea datamenu7;
    private javax.swing.JTextArea datamenu8;
    private javax.swing.JTextArea datamenu9;
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
    private javax.swing.JLabel displaygambar21;
    private javax.swing.JLabel displaygambar3;
    private javax.swing.JLabel displaygambar4;
    private javax.swing.JLabel displaygambar5;
    private javax.swing.JLabel displaygambar6;
    private javax.swing.JLabel displaygambar7;
    private javax.swing.JLabel displaygambar8;
    private javax.swing.JLabel displaygambar9;
    public static final javax.swing.JLabel finalPilihTempatMakan = new javax.swing.JLabel();
    private javax.swing.JLabel harga1;
    private javax.swing.JLabel harga10;
    private javax.swing.JLabel harga11;
    private javax.swing.JLabel harga12;
    private javax.swing.JLabel harga13;
    private javax.swing.JLabel harga14;
    private javax.swing.JLabel harga15;
    private javax.swing.JLabel harga16;
    private javax.swing.JLabel harga17;
    private javax.swing.JLabel harga18;
    private javax.swing.JLabel harga19;
    private javax.swing.JLabel harga2;
    private javax.swing.JLabel harga20;
    private javax.swing.JLabel harga21;
    private javax.swing.JLabel harga3;
    private javax.swing.JLabel harga4;
    private javax.swing.JLabel harga5;
    private javax.swing.JLabel harga6;
    private javax.swing.JLabel harga7;
    private javax.swing.JLabel harga8;
    private javax.swing.JLabel harga9;
    private javax.swing.JTextField inputsearch;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jmlhmenu1;
    private javax.swing.JLabel jmlhmenu10;
    private javax.swing.JLabel jmlhmenu11;
    private javax.swing.JLabel jmlhmenu12;
    private javax.swing.JLabel jmlhmenu13;
    private javax.swing.JLabel jmlhmenu14;
    private javax.swing.JLabel jmlhmenu15;
    private javax.swing.JLabel jmlhmenu16;
    private javax.swing.JLabel jmlhmenu17;
    private javax.swing.JLabel jmlhmenu18;
    private javax.swing.JLabel jmlhmenu19;
    private javax.swing.JLabel jmlhmenu2;
    private javax.swing.JLabel jmlhmenu20;
    private javax.swing.JLabel jmlhmenu21;
    private javax.swing.JLabel jmlhmenu3;
    private javax.swing.JLabel jmlhmenu4;
    private javax.swing.JLabel jmlhmenu5;
    private javax.swing.JLabel jmlhmenu6;
    private javax.swing.JLabel jmlhmenu7;
    private javax.swing.JLabel jmlhmenu8;
    private javax.swing.JLabel jmlhmenu9;
    private javax.swing.JLabel labeljudulform;
    private javax.swing.JLabel labelmakanan;
    private javax.swing.JLabel labelminuman;
    private javax.swing.JLabel labelnopesanan;
    private javax.swing.JLabel labelpromosi;
    private javax.swing.JLabel labelsnack;
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
    private javax.swing.JLabel menu21;
    private javax.swing.JLabel menu3;
    private javax.swing.JLabel menu4;
    private javax.swing.JLabel menu5;
    private javax.swing.JLabel menu6;
    private javax.swing.JLabel menu7;
    private javax.swing.JLabel menu8;
    private javax.swing.JLabel menu9;
    private javax.swing.JPanel minus1;
    private javax.swing.JPanel minus10;
    private javax.swing.JPanel minus11;
    private javax.swing.JPanel minus12;
    private javax.swing.JPanel minus13;
    private javax.swing.JPanel minus14;
    private javax.swing.JPanel minus15;
    private javax.swing.JPanel minus16;
    private javax.swing.JPanel minus17;
    private javax.swing.JPanel minus18;
    private javax.swing.JPanel minus19;
    private javax.swing.JPanel minus2;
    private javax.swing.JPanel minus20;
    private javax.swing.JPanel minus21;
    private javax.swing.JPanel minus3;
    private javax.swing.JPanel minus4;
    private javax.swing.JPanel minus5;
    private javax.swing.JPanel minus6;
    private javax.swing.JPanel minus7;
    private javax.swing.JPanel minus8;
    private javax.swing.JPanel minus9;
    private javax.swing.JTextField pay;
    private javax.swing.JPanel plus1;
    private javax.swing.JPanel plus10;
    private javax.swing.JPanel plus11;
    private javax.swing.JPanel plus12;
    private javax.swing.JPanel plus13;
    private javax.swing.JPanel plus14;
    private javax.swing.JPanel plus15;
    private javax.swing.JPanel plus16;
    private javax.swing.JPanel plus17;
    private javax.swing.JPanel plus18;
    private javax.swing.JPanel plus19;
    private javax.swing.JPanel plus2;
    private javax.swing.JPanel plus20;
    private javax.swing.JPanel plus21;
    private javax.swing.JPanel plus3;
    private javax.swing.JPanel plus4;
    private javax.swing.JPanel plus5;
    private javax.swing.JPanel plus6;
    private javax.swing.JPanel plus7;
    private javax.swing.JPanel plus8;
    private javax.swing.JPanel plus9;
    private javax.swing.JLabel popupPemindaianBerhasil;
    private javax.swing.JLabel popupPemindaianGagal;
    private javax.swing.JLabel popupScanWait;
    private javax.swing.JLabel popuppilihTempatMakan;
    private javax.swing.JButton printstruk;
    private javax.swing.JPanel promosi;
    private javax.swing.JPanel promosimenu;
    private javax.swing.JTextField scannik;
    private javax.swing.JScrollPane scrollpaneStruk;
    private javax.swing.JLabel sold1;
    private javax.swing.JLabel sold10;
    private javax.swing.JLabel sold11;
    private javax.swing.JLabel sold12;
    private javax.swing.JLabel sold13;
    private javax.swing.JLabel sold14;
    private javax.swing.JLabel sold15;
    private javax.swing.JLabel sold16;
    private javax.swing.JLabel sold17;
    private javax.swing.JLabel sold18;
    private javax.swing.JLabel sold19;
    private javax.swing.JLabel sold2;
    private javax.swing.JLabel sold20;
    private javax.swing.JLabel sold21;
    private javax.swing.JLabel sold3;
    private javax.swing.JLabel sold4;
    private javax.swing.JLabel sold5;
    private javax.swing.JLabel sold6;
    private javax.swing.JLabel sold7;
    private javax.swing.JLabel sold8;
    private javax.swing.JLabel sold9;
    private javax.swing.JTextArea struk;
    private javax.swing.JScrollPane tablepembelian;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
