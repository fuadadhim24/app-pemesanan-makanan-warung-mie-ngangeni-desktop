/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import raven.chart.ModelChart;

/**
 *
 * @author fuada
 */
public class AdminPenjualan extends javax.swing.JFrame {

    /**
     * Creates new form PenjualanAdmin
     */
    
    private void ranking(){
        try {
        labelrank1.setText(null);
            String sql = "SELECT menu.nama_menu, SUM(detail_transaksi.jumlah) as TOTAL from menu JOIN detail_transaksi ON menu.id_menu = detail_transaksi.id_menu " +
                          "LIMIT 1";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            
            if(rs.next()){
                this.labelrank1.setText(rs.getString(1));
            }
            
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
        labelrank2.setText(null);
            String sql = "SELECT menu.nama_menu, SUM(detail_transaksi.jumlah) as TOTAL from menu JOIN detail_transaksi ON menu.id_menu = detail_transaksi.id_menu GROUP BY menu.nama_menu LIMIT 1,1";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            
            if(rs.next()){
                this.labelrank2.setText(rs.getString(1));
            }
            
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
        labelrank3.setText(null);
            String sql = "SELECT menu.nama_menu, SUM(detail_transaksi.jumlah) as TOTAL from menu JOIN detail_transaksi ON menu.id_menu = detail_transaksi.id_menu GROUP BY menu.nama_menu LIMIT 2,1";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs= pst.executeQuery(sql);
            
            if(rs.next()){
                this.labelrank3.setText(rs.getString(1));
            }
            
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private Timer timerNoFilter; // Deklarasi objek NoTimer
    
    private void nominalpemasukanDefaultHariIni(){
    try {
        labelpemasukan.setText(null);
            
            // Mengambil tanggal hari ini
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String todayString = today.format(formatter);
                
            // Menghitung tanggal awal minggu ini
            LocalDate firstDayOfWeek = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
            String firstDayOfWeekString = firstDayOfWeek.format(formatter);
            
            // Menghitung tanggal akhir minggu ini
            LocalDate lastDayOfWeek = today.with(TemporalAdjusters.next(java.time.DayOfWeek.SUNDAY));
            String lastDayOfWeekString = lastDayOfWeek.format(formatter);

            // Menghitung tanggal awal bulan ini
            LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
            String firstDayOfMonthString = firstDayOfMonth.format(formatter);
            
            // Menghitung tanggal akhir bulan ini
            LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());
            String lastDayOfMonthString = lastDayOfMonth.format(formatter);

            // Menghitung tanggal awal tahun ini
            LocalDate firstDayOfYear = today.with(TemporalAdjusters.firstDayOfYear());
            String firstDayOfYearString = firstDayOfYear.format(formatter);
            
            // Menghitung tanggal akhir tahun ini
            LocalDate lastDayOfYear = today.withDayOfYear(today.lengthOfYear());
            String lastDayOfYearString = lastDayOfYear.format(formatter);

            
            String hariSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) AS TOTAL FROM transaksi JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu = detail_transaksi.id_menu WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi LIKE ?";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(hariSql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, "%" + todayString + "%");
            java.sql.ResultSet hariRs = pst.executeQuery();

            if (hariRs.next()) {
                String totalPemasukan = hariRs.getString("TOTAL");
                if (totalPemasukan == null) {
                    this.labelpemasukan.setText("Rp. 0");
                } else {
                    this.labelpemasukan.setText("Rp. " + totalPemasukan);
                }
            }
            
            
            hariRs.close();
            

            
            // Query SQL untuk menghitung pemasukan minggu ini
            String mingguSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) as TOTAL " +
                    "FROM transaksi " +
                    "JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi " +
                    "JOIN menu ON menu.id_menu = detail_transaksi.id_menu " +
                    "WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi >= ? AND transaksi.tanggalTransaksi <= '"+lastDayOfWeekString+"'";
            
            java.sql.PreparedStatement mingguPst = conn.prepareStatement(mingguSql);
            mingguPst.setString(1, firstDayOfWeekString);
            ResultSet mingguRs = mingguPst.executeQuery();
            
            if (mingguRs.next()) {
                int mingguPemasukan = mingguRs.getInt("TOTAL");
                labelpemasukanminggu.setText("Rp. " + mingguPemasukan);
            }
            
            
            mingguRs.close();
            // Query SQL untuk menghitung pemasukan bulan ini
            String bulanSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) as TOTAL " +
                    "FROM transaksi " +
                    "JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi " +
                    "JOIN menu ON menu.id_menu = detail_transaksi.id_menu " +
                    "WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi >= ? AND transaksi.tanggalTransaksi <= '"+lastDayOfMonthString+"'";
            
            java.sql.PreparedStatement bulanPst = conn.prepareStatement(bulanSql);
            bulanPst.setString(1, firstDayOfMonthString);
            ResultSet bulanRs = bulanPst.executeQuery();

            if (bulanRs.next()) {
                int bulanPemasukan = bulanRs.getInt("TOTAL");
                labelpemasukanbulan.setText("Rp. " + bulanPemasukan);
            }
            
            
            bulanRs.close();
            // Query SQL untuk menghitung pemasukan tahun ini
            String tahunSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) as TOTAL " +
                    "FROM transaksi " +
                    "JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi " +
                    "JOIN menu ON menu.id_menu = detail_transaksi.id_menu " +
                    "WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi >= ? AND transaksi.tanggalTransaksi <= '"+lastDayOfYearString+"'";
            
            java.sql.PreparedStatement tahunPst = conn.prepareStatement(tahunSql);
            tahunPst.setString(1, firstDayOfYearString);
            ResultSet tahunRs = tahunPst.executeQuery();

            if (tahunRs.next()) {
                int tahunPemasukan = tahunRs.getInt("TOTAL");
                labelpemasukantahun.setText("Rp. " + tahunPemasukan);
            }
            
            
            tahunRs.close();
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    private void nominalpemasukanFilter(){
    try {
        labelpemasukan.setText(null);
            
            // Mengambil tanggal input date
            LocalDate date = LocalDate.parse(inputDate.getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String todayString = date.format(formatter);
                
            // Menghitung tanggal awal minggu ini
            LocalDate firstDayOfWeek = date.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
            String firstDayOfWeekString = firstDayOfWeek.format(formatter);
            
            // Menghitung tanggal akhir minggu ini
            LocalDate lastDayOfWeek = date.with(TemporalAdjusters.next(java.time.DayOfWeek.SUNDAY));
            String lastDayOfWeekString = lastDayOfWeek.format(formatter);

            // Menghitung tanggal awal bulan ini
            LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
            String firstDayOfMonthString = firstDayOfMonth.format(formatter);
            
            // Menghitung tanggal akhir bulan ini
            LocalDate lastDayOfMonth = date.withDayOfMonth(date.lengthOfMonth());
            String lastDayOfMonthString = lastDayOfMonth.format(formatter);

            // Menghitung tanggal awal tahun ini
            LocalDate firstDayOfYear = date.with(TemporalAdjusters.firstDayOfYear());
            String firstDayOfYearString = firstDayOfYear.format(formatter);
            
            // Menghitung tanggal akhir tahun ini
            LocalDate lastDayOfYear = date.withDayOfYear(date.lengthOfYear());
            String lastDayOfYearString = lastDayOfYear.format(formatter);

            
            String hariSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) AS TOTAL FROM transaksi JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu = detail_transaksi.id_menu WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi LIKE ?";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(hariSql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pst.setString(1, "%" + todayString + "%");
            java.sql.ResultSet hariRs = pst.executeQuery();

            if (hariRs.next()) {
                String totalPemasukan = hariRs.getString("TOTAL");
                if (totalPemasukan == null) {
                    this.labelpemasukan.setText("Rp. 0");
                } else {
                    this.labelpemasukan.setText("Rp. " + totalPemasukan);
                }
            }
            
            
            hariRs.close();

            
            // Query SQL untuk menghitung pemasukan minggu ini
            String mingguSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) as TOTAL " +
                    "FROM transaksi " +
                    "JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi " +
                    "JOIN menu ON menu.id_menu = detail_transaksi.id_menu " +
                    "WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi >= ? AND transaksi.tanggalTransaksi <= '"+lastDayOfWeekString+"'";
            
            java.sql.PreparedStatement mingguPst = conn.prepareStatement(mingguSql);
            mingguPst.setString(1, firstDayOfWeekString);
            ResultSet mingguRs = mingguPst.executeQuery();
            
            if (mingguRs.next()) {
                int mingguPemasukan = mingguRs.getInt("TOTAL");
                labelpemasukanminggu.setText("Rp. " + mingguPemasukan);
            }
            
            
            mingguRs.close();
            
            // Query SQL untuk menghitung pemasukan bulan ini
            String bulanSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) as TOTAL " +
                    "FROM transaksi " +
                    "JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi " +
                    "JOIN menu ON menu.id_menu = detail_transaksi.id_menu " +
                    "WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi >= ? AND transaksi.tanggalTransaksi <= '"+lastDayOfMonthString+"'";
            
            java.sql.PreparedStatement bulanPst = conn.prepareStatement(bulanSql);
            bulanPst.setString(1, firstDayOfMonthString);
            ResultSet bulanRs = bulanPst.executeQuery();

            if (bulanRs.next()) {
                int bulanPemasukan = bulanRs.getInt("TOTAL");
                labelpemasukanbulan.setText("Rp. " + bulanPemasukan);
            }
            
            
            bulanRs.close();
            // Query SQL untuk menghitung pemasukan tahun ini
            String tahunSql = "SELECT SUM(detail_transaksi.jumlah * menu.harga) as TOTAL " +
                    "FROM transaksi " +
                    "JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi " +
                    "JOIN menu ON menu.id_menu = detail_transaksi.id_menu " +
                    "WHERE transaksi.status = 'Selesai' AND transaksi.tanggalTransaksi >= ? AND transaksi.tanggalTransaksi <= '"+lastDayOfYearString+"'";
            
            java.sql.PreparedStatement tahunPst = conn.prepareStatement(tahunSql);
            tahunPst.setString(1, firstDayOfYearString);
            ResultSet tahunRs = tahunPst.executeQuery();

            if (tahunRs.next()) {
                int tahunPemasukan = tahunRs.getInt("TOTAL");
                labelpemasukantahun.setText("Rp. " + tahunPemasukan);
            }
            
            
            tahunRs.close();
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    
    //pemasukan
    private void scheduleDataUpdatePemasukanHariIni() {
            int delay2 = 0; // Penundaan sebelum penjadwalan dimulai
            int interval2 = 10000; // Setiap 15 detik
            timerNoFilter = new Timer(interval2, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nominalpemasukanDefaultHariIni();
                }
            });

            timerNoFilter.setInitialDelay(delay2);
            timerNoFilter.start();
        }
    private void scheduleDataUpdateFilter() {
            int delay2 = 0; // Penundaan sebelum penjadwalan dimulai
            int interval2 = 10000; // Setiap 15 detik
            timerNoFilter = new Timer(interval2, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    nominalpemasukanFilter();
                }
            });

            timerNoFilter.setInitialDelay(delay2);
            timerNoFilter.start();
        }
    public AdminPenjualan() {
        initComponents();
        //popup
        popuptutup.setVisible(false);
        popuplabel.setVisible(false);
        jPanel7.setVisible(false);    
        jPanel8.setVisible(false);    
        jPanel9.setVisible(false);    
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
        scheduleDataUpdatePemasukanHariIni();
        popupFilter.setVisible(false);
        infofilter.setVisible(false);
        inputDate.setVisible(false);
        btnHariIni.setVisible(false);
        txtFilterHistory.setVisible(false);
        btnClosePopUpHistory.setVisible(false);
        btncustom.setVisible(false);
        ranking();
        
        //chart
        chart.addLegend("Pendapatan", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Pengeluaran", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Keuntungan", Color.decode("#0099F7"), Color.decode("#F11712"));
        test();
    }
    

    //chart
    private void setData() {
    try {
        List<ModelData> lists = new ArrayList<>();
        String sql = "SELECT COALESCE(SUM(detail_transaksi.jumlah * menu.harga), 0) AS Total, CASE "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 1 THEN 'Januari' "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 2 THEN 'Februari' "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 3 THEN 'Maret' "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 4 THEN 'April' "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 5 THEN 'Mei' "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 6 THEN 'Juni' "+
                "WHEN MONTH(transaksi.tanggalTransaksi) = 7 THEN 'Juli' "+
            "END AS Bulan "+
        "FROM "+
            "transaksi "+
            "LEFT JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi "+
            "LEFT JOIN menu ON menu.id_menu = detail_transaksi.id_menu "+
          "WHERE transaksi.status = 'Selesai' "+
        "GROUP BY "+
            "MONTH(transaksi.tanggalTransaksi) "+
        "ORDER BY "+
            "MONTH(transaksi.tanggalTransaksi); ";
        java.sql.Connection conn=(Connection)Config.configDB();
        PreparedStatement p = conn.prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int randomNumberfirst = generateRandomNumber();
            int randomNumberlast = generateRandomNumber();
            double convertedNumberfirst = (double) randomNumberfirst;
            double convertedNumberlast = (double) randomNumberlast;
            String month = r.getString("Bulan");
            double amount = r.getDouble("Total");
            lists.add(new ModelData(month, amount, convertedNumberfirst, convertedNumberlast));
        }
        r.close();
        p.close();
        // Add Data to chart
        for (int i = lists.size() - 1; i >= 0; i--) {
            ModelData d = lists.get(i);
            int randomNumberthird = generateRandomNumber();
            int randomNumberfour = generateRandomNumber();
            double convertedNumberthird = (double) randomNumberthird;
            double convertedNumberfour = (double) randomNumberfour;
            chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), convertedNumberthird, convertedNumberfour}));
        }
        // Start to show data with animation
        chart.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static int generateRandomNumber() {
    Random random = new Random();
    int result = random.nextInt(900) + 100; // Menghasilkan angka dalam rentang 100-999
    return result;
}

    private void test() {
        chart.clear();
        chart.addData(new ModelChart("January", new double[]{500, 50, 100}));
        chart.addData(new ModelChart("February", new double[]{600, 300, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 50, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 700, 100}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 500}));
        chart.addData(new ModelChart("June", new double[]{450, 800, 100}));
        chart.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnpopuptahun = new javax.swing.JPanel();
        btnpopupbulan = new javax.swing.JPanel();
        btnpopupminggu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        popuptutup = new javax.swing.JPanel();
        popuplabel = new javax.swing.JLabel();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        groupFilterHistory = new javax.swing.ButtonGroup();
        btnClosePopUpHistory = new javax.swing.JPanel();
        btnterapkan = new javax.swing.JPanel();
        inputDate = new javax.swing.JTextField();
        infofilter = new javax.swing.JLabel();
        btncustom = new javax.swing.JRadioButton();
        btnHariIni = new javax.swing.JRadioButton();
        popupFilter = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnFilter = new javax.swing.JPanel();
        labelpemasukantahun = new javax.swing.JLabel();
        labelpemasukanbulan = new javax.swing.JLabel();
        labelpemasukanminggu = new javax.swing.JLabel();
        popup = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        labelrank2 = new javax.swing.JLabel();
        labelrank1 = new javax.swing.JLabel();
        labelrank3 = new javax.swing.JLabel();
        labelpemasukan = new javax.swing.JLabel();
        panelChart = new javax.swing.JPanel();
        chart = new raven.chart.CurveLineChart();
        background = new javax.swing.JLabel();
        txtFilterHistory = new javax.swing.JTextField();

        btnpopuptahun.setOpaque(false);
        btnpopuptahun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpopuptahunMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnpopuptahunLayout = new javax.swing.GroupLayout(btnpopuptahun);
        btnpopuptahun.setLayout(btnpopuptahunLayout);
        btnpopuptahunLayout.setHorizontalGroup(
            btnpopuptahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        btnpopuptahunLayout.setVerticalGroup(
            btnpopuptahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        btnpopupbulan.setOpaque(false);
        btnpopupbulan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpopupbulanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnpopupbulanLayout = new javax.swing.GroupLayout(btnpopupbulan);
        btnpopupbulan.setLayout(btnpopupbulanLayout);
        btnpopupbulanLayout.setHorizontalGroup(
            btnpopupbulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        btnpopupbulanLayout.setVerticalGroup(
            btnpopupbulanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        btnpopupminggu.setOpaque(false);
        btnpopupminggu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnpopupmingguAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnpopupminggu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpopupmingguMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnpopupmingguLayout = new javax.swing.GroupLayout(btnpopupminggu);
        btnpopupminggu.setLayout(btnpopupmingguLayout);
        btnpopupmingguLayout.setHorizontalGroup(
            btnpopupmingguLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        btnpopupmingguLayout.setVerticalGroup(
            btnpopupmingguLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

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

        popuplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popuppenjualan.png"))); // NOI18N

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        dateChooser1.setTextRefernce(inputDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClosePopUpHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClosePopUpHistory.setOpaque(false);
        btnClosePopUpHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClosePopUpHistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnClosePopUpHistoryLayout = new javax.swing.GroupLayout(btnClosePopUpHistory);
        btnClosePopUpHistory.setLayout(btnClosePopUpHistoryLayout);
        btnClosePopUpHistoryLayout.setHorizontalGroup(
            btnClosePopUpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        btnClosePopUpHistoryLayout.setVerticalGroup(
            btnClosePopUpHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        getContentPane().add(btnClosePopUpHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 215, 48, 39));

        btnterapkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnterapkan.setOpaque(false);
        btnterapkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnterapkanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnterapkanLayout = new javax.swing.GroupLayout(btnterapkan);
        btnterapkan.setLayout(btnterapkanLayout);
        btnterapkanLayout.setHorizontalGroup(
            btnterapkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );
        btnterapkanLayout.setVerticalGroup(
            btnterapkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        getContentPane().add(btnterapkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 585, 322, 55));
        getContentPane().add(inputDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 210, -1));

        infofilter.setBackground(new java.awt.Color(204, 204, 204));
        infofilter.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        infofilter.setForeground(new java.awt.Color(102, 102, 102));
        infofilter.setText("tentukan tanggal untuk melihat history sesuai yang ditentukan");
        getContentPane().add(infofilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        groupFilterHistory.add(btncustom);
        btncustom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btncustom.setText("Custom");
        btncustom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncustomMouseClicked(evt);
            }
        });
        getContentPane().add(btncustom, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, -1, -1));

        groupFilterHistory.add(btnHariIni);
        btnHariIni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHariIni.setText("Hari Ini");
        btnHariIni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHariIniMouseClicked(evt);
            }
        });
        getContentPane().add(btnHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        popupFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popupfilterpesanan.png"))); // NOI18N
        getContentPane().add(popupFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.setOpaque(false);
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 325, 180, 30));

        btnFilter.setOpaque(false);
        btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFilterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnFilterLayout = new javax.swing.GroupLayout(btnFilter);
        btnFilter.setLayout(btnFilterLayout);
        btnFilterLayout.setHorizontalGroup(
            btnFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        btnFilterLayout.setVerticalGroup(
            btnFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 85, 144, 34));

        labelpemasukantahun.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        labelpemasukantahun.setForeground(new java.awt.Color(0, 74, 173));
        labelpemasukantahun.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(labelpemasukantahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 222, 200, 30));

        labelpemasukanbulan.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        labelpemasukanbulan.setForeground(new java.awt.Color(0, 74, 173));
        labelpemasukanbulan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelpemasukanbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 222, 192, 30));

        labelpemasukanminggu.setFont(new java.awt.Font("Microsoft Tai Le", 0, 24)); // NOI18N
        labelpemasukanminggu.setForeground(new java.awt.Color(0, 74, 173));
        labelpemasukanminggu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(labelpemasukanminggu, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 222, 220, 30));

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

        jPanel1.add(popup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 56, 48));

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setOpaque(false);

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 288, 56, 48));

        labelrank2.setFont(new java.awt.Font("Dubai Medium", 0, 30)); // NOI18N
        labelrank2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(labelrank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 220, 30));

        labelnama1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelnama1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelnama1.setToolTipText("");
        labelnama1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(labelnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 8, 670, 20));

        labelrank1.setFont(new java.awt.Font("Dubai Medium", 0, 36)); // NOI18N
        labelrank1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelrank1.setText("cek");
        jPanel1.add(labelrank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 350, 30));

        labelrank3.setFont(new java.awt.Font("Dubai Medium", 0, 28)); // NOI18N
        labelrank3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(labelrank3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 230, 30));

        labelpemasukan.setBackground(new java.awt.Color(255, 255, 255));
        labelpemasukan.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        labelpemasukan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelpemasukan.setText("Rp. 500000");
        labelpemasukan.setOpaque(true);
        jPanel1.add(labelpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 620, 100));

        panelChart.setBackground(new java.awt.Color(255, 255, 255));
        panelChart.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        jPanel1.add(panelChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 830, 290));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/1.png"))); // NOI18N
        background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(txtFilterHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        this.setVisible(false);
        new AdminMenu().setVisible(true);
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        this.setVisible(false);
        new AdminKaryawan().setVisible(true);
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.setVisible(false);
        new MainDisplay().setVisible(true);
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        this.dispose();
        try {
            new AdminPesanan().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void popupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popupMouseClicked
        popuplabel.setVisible(true);
        popup.setVisible(false);
        popuptutup.setVisible(true);
        popuplabel.setOpaque(false);
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

    private void popuptutupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popuptutupMouseClicked
        popuplabel.setVisible(false);
        popuptutup.setVisible(false);
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
            Logger.getLogger(AdminPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        this.setVisible(false);
        new MainDisplay().setVisible(true);
        
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        this.setVisible(false);
        new AdminPenjualan().setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void btnpopupmingguMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpopupmingguMouseClicked
    
    }//GEN-LAST:event_btnpopupmingguMouseClicked

    private void btnpopupbulanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpopupbulanMouseClicked

    }//GEN-LAST:event_btnpopupbulanMouseClicked

    private void btnpopuptahunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpopuptahunMouseClicked

    }//GEN-LAST:event_btnpopuptahunMouseClicked

    private void btnpopupmingguAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnpopupmingguAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpopupmingguAncestorAdded

    private void btnFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMouseClicked
        btnClosePopUpHistory.setVisible(true);
        popupFilter.setVisible(true);
        btncustom.setVisible(true);
        infofilter.setVisible(true);
        inputDate.setVisible(false);
        btnHariIni.setVisible(true);
    }//GEN-LAST:event_btnFilterMouseClicked

    private void btnterapkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnterapkanMouseClicked
        timerNoFilter.stop();
        String pilihanFilter = txtFilterHistory.getText();
        switch(pilihanFilter){
            case "Hari Ini":
                scheduleDataUpdatePemasukanHariIni();
            break;
            case "Custom":
                scheduleDataUpdateFilter();
            break;
        }
        popupFilter.setVisible(false);
        infofilter.setVisible(false);
        inputDate.setVisible(false);
        btnHariIni.setVisible(false);
        btncustom.setVisible(false);
        btnClosePopUpHistory.setVisible(false);
    }//GEN-LAST:event_btnterapkanMouseClicked

    private void btnHariIniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHariIniMouseClicked
        txtFilterHistory.setText("Hari Ini");
        inputDate.setVisible(false);
    }//GEN-LAST:event_btnHariIniMouseClicked

    private void btncustomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncustomMouseClicked
        txtFilterHistory.setText("Custom");
        inputDate.setVisible(true);
    }//GEN-LAST:event_btncustomMouseClicked

    private void btnClosePopUpHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClosePopUpHistoryMouseClicked
        btnClosePopUpHistory.setVisible(false);
        popupFilter.setVisible(false);
        btncustom.setVisible(false);
        infofilter.setVisible(false);
        inputDate.setVisible(false);
        btnHariIni.setVisible(false);
    }//GEN-LAST:event_btnClosePopUpHistoryMouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
         try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("report1.jasper"), null, Config.configDB());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jPanel12MouseClicked

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
            java.util.logging.Logger.getLogger(AdminPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JPanel btnClosePopUpHistory;
    private javax.swing.JPanel btnFilter;
    private javax.swing.JRadioButton btnHariIni;
    private javax.swing.JRadioButton btncustom;
    private javax.swing.JPanel btnpopupbulan;
    private javax.swing.JPanel btnpopupminggu;
    private javax.swing.JPanel btnpopuptahun;
    private javax.swing.JPanel btnterapkan;
    private raven.chart.CurveLineChart chart;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.ButtonGroup groupFilterHistory;
    private javax.swing.JLabel infofilter;
    private javax.swing.JTextField inputDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static final javax.swing.JLabel labelnama1 = new javax.swing.JLabel();
    private javax.swing.JLabel labelpemasukan;
    private javax.swing.JLabel labelpemasukanbulan;
    private javax.swing.JLabel labelpemasukanminggu;
    private javax.swing.JLabel labelpemasukantahun;
    private javax.swing.JLabel labelrank1;
    private javax.swing.JLabel labelrank2;
    private javax.swing.JLabel labelrank3;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel popup;
    private javax.swing.JLabel popupFilter;
    private javax.swing.JLabel popuplabel;
    private javax.swing.JPanel popuptutup;
    private javax.swing.JTextField txtFilterHistory;
    // End of variables declaration//GEN-END:variables
}
