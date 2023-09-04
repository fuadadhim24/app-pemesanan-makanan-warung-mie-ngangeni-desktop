/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.Dates;
import com.raven.datechooser.Months;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fuada
 */
public class AdminPesanan extends javax.swing.JFrame {

    /**
     * Creates new form PenjualanAdmin
     */
    //menyesuaikan tampilan data dengan filter button
    
    public void rubahDesainJTable() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Color backgroundColor = Color.decode("#F3F3F3"); // Warna latar belakang
        Color textColor = Color.decode("#333333"); // Warna teks
        Color gridColor = Color.decode("#CCCCCC"); // Warna garis pemisah
        Color highlightColor = Color.decode("#FFD700"); // Warna sorotan
        Color whiteColor = Color.decode("#FFFFFF"); // Warna putih

        // Buat objek font yang sesuai dengan preferensi Anda
        Font headerFont = new Font("Helvetica", Font.BOLD, 12);
        Font cellFont = new Font("Helvetica", Font.PLAIN, 12);

        for (int range = 1; range <= 12; range++) {
            String jScrollPaneName = "jScrollPane" + range;
            JScrollPane jScrollPane = (JScrollPane) getClass().getDeclaredField(jScrollPaneName).get(this);

            String jTableColumnName = "jTable" + range;
            JTable jTable = (JTable) getClass().getDeclaredField(jTableColumnName).get(this);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    cellComponent.setBackground(backgroundColor);
                    cellComponent.setForeground(textColor);
                    table.setGridColor(gridColor);
                    cellComponent.setFont(headerFont);
                    setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // Set perataan teks header ke tengah

                    return cellComponent;
                }
            };

            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    cellComponent.setBackground(row % 2 == 0 ? whiteColor : backgroundColor); // Teks baris bergantian dengan latar belakang
                    cellComponent.setForeground(textColor);
                    table.setGridColor(gridColor);
                    cellComponent.setFont(cellFont);
                    setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // Set perataan teks sel ke tengah

                    if (isSelected) {
                        cellComponent.setBackground(highlightColor); // Warna sorotan saat dipilih
                        cellComponent.setForeground(textColor);
                    }

                    return cellComponent;
                }
            };

            jScrollPane.getViewport().setBackground(backgroundColor); // Atur latar belakang JScrollPane
            jTable.setBackground(backgroundColor); // Atur latar belakang JTable

            // Mengatur renderer untuk semua kolom dan baris pada jTable
            for (int i = 0; i < jTable.getColumnCount(); i++) {
                jTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
                jTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }
        }
    }
    public void tampilkanData(String sql) throws SQLException, InterruptedException {
        try {
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(sql);

            Set<BigInteger> displayedIds = new HashSet<>();

            for (int range = 1; range <= 12; range++) {
                String labelNoPesananName = "labelnopesanan" + range;
                String dataTablePesananName = "jTable" + range;
                String datapesananname = "datapesanan" + range;
                String btnCancelName = "btn_cancel" + range;
                String btnCeklisName = "btn_ceklis" + range;
                String cardName = "jScrollPane" + range;
                String panelPilihTempatMakanName = "panelPilihTempatMakan" + range;
                String labelPilihTempatMakanName = "pilihTempatMakan" + range;

                JLabel labelNoPesanan = (JLabel) getClass().getDeclaredField(labelNoPesananName).get(this);
                JTable dataTablePesanan = (JTable) getClass().getDeclaredField(dataTablePesananName).get(this);
                JLabel panel = (JLabel) getClass().getDeclaredField(datapesananname).get(this);
                JLabel btnCancel = (JLabel) getClass().getDeclaredField(btnCancelName).get(this);
                JLabel btnCeklis = (JLabel) getClass().getDeclaredField(btnCeklisName).get(this);
                JScrollPane card = (JScrollPane) getClass().getDeclaredField(cardName).get(this);
                JLabel labelPilihTempatMakan = (JLabel) getClass().getDeclaredField(labelPilihTempatMakanName).get(this);
                JPanel panelPilihTempatMakan = (JPanel) getClass().getDeclaredField(panelPilihTempatMakanName).get(this);

                labelNoPesanan.setVisible(false);
                dataTablePesanan.setVisible(false);
                panel.setVisible(false);
                btnCancel.setVisible(false);
                btnCeklis.setVisible(false);
                card.setVisible(false);
                labelPilihTempatMakan.setVisible(false);
                panelPilihTempatMakan.setVisible(false);
            }

            while (rs.next()) {
                long idTransaksi = rs.getLong("id");
                String pilihTempatMakanValue = rs.getString("pilihTempatMakan");
                BigInteger bigIntegerId = BigInteger.valueOf(idTransaksi);

                if (!displayedIds.contains(bigIntegerId)) {
                    int row = displayedIds.size() + 1;

                    String labelNoPesananName = "labelnopesanan" + row;
                    String dataTablePesananName = "jTable" + row;
                    String datapesananname = "datapesanan" + row;
                    String btnCancelName = "btn_cancel" + row;
                    String btnCeklisName = "btn_ceklis" + row;
                    String cardName = "jScrollPane" + row;
                    String panelPilihTempatMakanName = "panelPilihTempatMakan" + row;
                    String labelPilihTempatMakanName = "pilihTempatMakan" + row;

                    JLabel labelNoPesanan = (JLabel) getClass().getDeclaredField(labelNoPesananName).get(this);
                    JTable dataTablePesanan = (JTable) getClass().getDeclaredField(dataTablePesananName).get(this);
                    JLabel panel = (JLabel) getClass().getDeclaredField(datapesananname).get(this);
                    JLabel btnCancel = (JLabel) getClass().getDeclaredField(btnCancelName).get(this);
                    JLabel btnCeklis = (JLabel) getClass().getDeclaredField(btnCeklisName).get(this);
                    JScrollPane card = (JScrollPane) getClass().getDeclaredField(cardName).get(this);
                    JLabel labelPilihTempatMakan = (JLabel) getClass().getDeclaredField(labelPilihTempatMakanName).get(this);
                    JPanel panelPilihTempatMakan = (JPanel) getClass().getDeclaredField(panelPilihTempatMakanName).get(this);

                    labelNoPesanan.setText("No. "+bigIntegerId.toString());
                    labelPilihTempatMakan.setText(pilihTempatMakanValue);
                    displayedIds.add(bigIntegerId);

                    String sqlDetail = "SELECT nama_menu, jumlah FROM detail_transaksi JOIN menu ON detail_transaksi.id_menu = menu.id_menu WHERE id_transaksi = ?";
                    java.sql.PreparedStatement stmtDetail = conn.prepareStatement(sqlDetail);
                    stmtDetail.setLong(1, idTransaksi);
                    ResultSet rsDetail = stmtDetail.executeQuery();

                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Nama Menu");
                    tableModel.addColumn("Jumlah");

                    while (rsDetail.next()) {
                        String namaMenu = rsDetail.getString("nama_menu");
                        int jumlah = rsDetail.getInt("jumlah");
                        tableModel.addRow(new Object[]{namaMenu, jumlah});
                    }

                    dataTablePesanan.setModel(tableModel);

                    labelNoPesanan.setVisible(true);
                    dataTablePesanan.setVisible(true);
                    panel.setVisible(true);
                    btnCancel.setVisible(true);
                    btnCeklis.setVisible(true);
                    card.setVisible(true);
                    labelPilihTempatMakan.setVisible(true);
                    panelPilihTempatMakan.setVisible(true);

                    // Atur warna latar belakang panel berdasarkan nilai pilihTempatMakan
                    if (pilihTempatMakanValue.equalsIgnoreCase("Makan Di Sini")) {
                        panelPilihTempatMakan.setBackground(new Color(0x4CB963));
                    } else if (pilihTempatMakanValue.equalsIgnoreCase("Bawa Pulang")) {
                        panelPilihTempatMakan.setBackground(new Color(0xFFD34F));
                    }

                }
            }
            rubahDesainJTable();
            conn.close();
            statement.close();
            rs.close();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void filterTampilkanData() throws SQLException, InterruptedException {
        String currentDate = getCurrentDate();
        System.out.println(currentDate);
        String query = "";
        String statusClick = status.getText();
        System.out.println(statusClick);
        if (statusClick.equals("Selesai")) {
            query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Selesai' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi DESC";
            cbFilter.setSelectedIndex(0);
            tampilkanData(query);
        } else if (statusClick.equals("Perlu Konfirmasi Pembayaran")) {
            query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Perlu Konfirmasi Pembayaran' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi ASC";
            cbFilter.setSelectedIndex(1);
            tampilkanData(query);
        } else if (statusClick.equals("Pesanan Siap Diantar")) {
            query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Pesanan Siap Diantar' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi ASC";
            cbFilter.setSelectedIndex(1);
            tampilkanData(query);
        } else if (statusClick.equals("Sedang Dimasak")) {
            query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Sedang Dimasak' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi ASC";
            cbFilter.setSelectedIndex(1);
            tampilkanData(query);
        }

        // Memeriksa apakah hasil query mengembalikan data
        boolean pesanan = pilihTempatMakan1.getText()==null;
        if (pesanan) {
            JOptionPane.showMessageDialog(null, "Tidak ada data pemesanan hari ini.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void updateJam() {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            Calendar cal = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                            String jam = sdf.format(cal.getTime());
                            labelJam.setText(jam);

                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            thread.start();
        }
    private Timer timerNoFilter; // Deklarasi objek NoTimer
    
    //update pemesananNoFilter
    private void scheduleDataUpdateNoFilter(String sqlFirst) {
            int delay2 = 0; // Penundaan sebelum penjadwalan dimulai
            int interval2 = 10000; // Setiap 15 detik
            timerNoFilter = new Timer(interval2, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        tampilkanData(sqlFirst);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    try {
                        filterTampilkanData();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            timerNoFilter.setInitialDelay(delay2);
            timerNoFilter.start();
        }
    public String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }
    public String getCurrentDateYestrday() {
        // Mendapatkan tanggal hari ini
        LocalDate currentDate = LocalDate.now();
        // Mengurangi 1 hari dari tanggal hari ini
        LocalDate yesterday = currentDate.minusDays(1);
        
        // Mengubah format tanggal menjadi 'yyyy-MM-dd'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return yesterday.format(formatter);
    }
    
    public void setCurrentDateWeek(String urutkan) {
        // Mengubah inputDate menjadi LocalDate
        LocalDate date = LocalDate.parse(inputDate.getText());

        // Mendapatkan tanggal awal dalam 1 minggu
        LocalDate startDate = date.minusDays(date.getDayOfWeek().getValue() - 1);

        // Mendapatkan tanggal akhir dalam 1 minggu
        LocalDate endDate = date.plusDays(7 - date.getDayOfWeek().getValue());

        // Mengubah format tanggal menjadi 'yyyy-MM-dd'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDateFormatted = startDate.format(formatter);
        String endDateFormatted = endDate.format(formatter);
        // Menggunakan startDateFormatted dan endDateFormatted dalam query
        String query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = '"+status.getText()+"' AND DATE(transaksi.tanggalTransaksi) >= '" + startDateFormatted + "' AND DATE(transaksi.tanggalTransaksi) <= '" + endDateFormatted + "' ORDER BY tanggalTransaksi "+urutkan+"";
        scheduleDataUpdateNoFilter(query);
    }
    public void setCurrentDateMonth(String urutkan) {
        // Mengubah inputDate menjadi LocalDate
        LocalDate date = LocalDate.parse(inputDate.getText());

        // Mendapatkan tahun dan bulan dari inputDate
        int year = date.getYear();
        int month = date.getMonthValue();

        // Membuat objek YearMonth dari tahun dan bulan
        YearMonth yearMonth = YearMonth.of(year, month);

        // Mendapatkan tanggal awal dalam satu bulan
        LocalDate startDate = yearMonth.atDay(1);

        // Mendapatkan tanggal akhir dalam satu bulan
        LocalDate endDate = yearMonth.atEndOfMonth();

        // Mengubah format tanggal menjadi 'yyyy-MM-dd'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDateFormatted = startDate.format(formatter);
        String endDateFormatted = endDate.format(formatter);

        // Menggunakan startDateFormatted dan endDateFormatted dalam query
        String query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = '"+status.getText()+"' AND DATE(transaksi.tanggalTransaksi) >= '" + startDateFormatted + "' AND DATE(transaksi.tanggalTransaksi) <= '" + endDateFormatted + "' ORDER BY tanggalTransaksi "+urutkan+"";
        scheduleDataUpdateNoFilter(query);
    }
    public void setCurrentDateYear(String urutkan) {
        // Mengubah inputDate menjadi LocalDate
        LocalDate date = LocalDate.parse(inputDate.getText());

        // Mendapatkan tahun dari inputDate
        int year = date.getYear();

        // Membuat objek Year dari tahun
        Year yearObj = Year.of(year);

        // Mendapatkan tanggal awal dalam satu tahun
        LocalDate startDate = yearObj.atDay(1);

        // Mendapatkan tanggal akhir dalam satu tahun
        LocalDate endDate = yearObj.atDay(yearObj.length());

        // Mengubah format tanggal menjadi 'yyyy-MM-dd'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDateFormatted = startDate.format(formatter);
        String endDateFormatted = endDate.format(formatter);

        // Menggunakan startDateFormatted dan endDateFormatted dalam query
        String query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = '"+status.getText()+"' AND DATE(transaksi.tanggalTransaksi) >= '" + startDateFormatted + "' AND DATE(transaksi.tanggalTransaksi) <= '" + endDateFormatted + "' ORDER BY tanggalTransaksi "+urutkan+"";
        scheduleDataUpdateNoFilter(query);
    }
    
    public AdminPesanan() throws SQLException, InterruptedException {
        initComponents();
        updateJam();
        status.setText("Selesai");
        btnfilterselesai.enable(false);
        popuptutup.setVisible(false);
        popuplabel.setVisible(false);
        jPanel7.setVisible(false);    
        jPanel8.setVisible(false);    
        jPanel9.setVisible(false);    
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
        String currentDate = getCurrentDate();
        scheduleDataUpdateNoFilter("SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Selesai' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi DESC");
        
        popupFilter.setVisible(false);
        infofilter.setVisible(false);
        inputDate.setVisible(false);
        btnKemarin.setVisible(false);
        btnHariIni.setVisible(false);
        btnBulan.setVisible(false);
        btnMinggu.setVisible(false);
        btnTahun.setVisible(false);
        btnClosePopUpHistory.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        popuptutup = new javax.swing.JPanel();
        popuplabel = new javax.swing.JLabel();
        popup = new javax.swing.JPanel();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        groupFilterHistory = new javax.swing.ButtonGroup();
        btnClosePopUpHistory = new javax.swing.JPanel();
        btnterapkan = new javax.swing.JPanel();
        inputDate = new javax.swing.JTextField();
        infofilter = new javax.swing.JLabel();
        btnHariIni = new javax.swing.JRadioButton();
        btnKemarin = new javax.swing.JRadioButton();
        btnMinggu = new javax.swing.JRadioButton();
        btnBulan = new javax.swing.JRadioButton();
        btnTahun = new javax.swing.JRadioButton();
        popupFilter = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        judulForm = new javax.swing.JLabel();
        btnhistory = new javax.swing.JPanel();
        cbFilter = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JPanel();
        inputsearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        labelJam = new javax.swing.JLabel();
        scrollcard = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        labelnopesanan2 = new javax.swing.JLabel();
        labelnopesanan3 = new javax.swing.JLabel();
        labelnopesanan4 = new javax.swing.JLabel();
        labelnopesanan5 = new javax.swing.JLabel();
        labelnopesanan6 = new javax.swing.JLabel();
        labelnopesanan7 = new javax.swing.JLabel();
        labelnopesanan8 = new javax.swing.JLabel();
        labelnopesanan9 = new javax.swing.JLabel();
        labelnopesanan10 = new javax.swing.JLabel();
        labelnopesanan11 = new javax.swing.JLabel();
        labelnopesanan12 = new javax.swing.JLabel();
        labelnopesanan1 = new javax.swing.JLabel();
        btn_cancel12 = new javax.swing.JLabel();
        btn_ceklis12 = new javax.swing.JLabel();
        btn_cancel11 = new javax.swing.JLabel();
        btn_ceklis11 = new javax.swing.JLabel();
        btn_cancel10 = new javax.swing.JLabel();
        btn_ceklis10 = new javax.swing.JLabel();
        btn_cancel9 = new javax.swing.JLabel();
        btn_ceklis9 = new javax.swing.JLabel();
        btn_cancel8 = new javax.swing.JLabel();
        btn_ceklis8 = new javax.swing.JLabel();
        btn_ceklis7 = new javax.swing.JLabel();
        btn_cancel7 = new javax.swing.JLabel();
        btn_ceklis6 = new javax.swing.JLabel();
        btn_cancel6 = new javax.swing.JLabel();
        btn_cancel5 = new javax.swing.JLabel();
        btn_ceklis5 = new javax.swing.JLabel();
        btn_cancel4 = new javax.swing.JLabel();
        btn_ceklis4 = new javax.swing.JLabel();
        btn_cancel3 = new javax.swing.JLabel();
        btn_ceklis3 = new javax.swing.JLabel();
        btn_cancel2 = new javax.swing.JLabel();
        btn_ceklis2 = new javax.swing.JLabel();
        btn_ceklis1 = new javax.swing.JLabel();
        btn_cancel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelPilihTempatMakan2 = new javax.swing.JPanel();
        pilihTempatMakan2 = new javax.swing.JLabel();
        panelPilihTempatMakan3 = new javax.swing.JPanel();
        pilihTempatMakan3 = new javax.swing.JLabel();
        panelPilihTempatMakan4 = new javax.swing.JPanel();
        pilihTempatMakan4 = new javax.swing.JLabel();
        panelPilihTempatMakan5 = new javax.swing.JPanel();
        pilihTempatMakan5 = new javax.swing.JLabel();
        panelPilihTempatMakan6 = new javax.swing.JPanel();
        pilihTempatMakan6 = new javax.swing.JLabel();
        panelPilihTempatMakan7 = new javax.swing.JPanel();
        pilihTempatMakan7 = new javax.swing.JLabel();
        panelPilihTempatMakan8 = new javax.swing.JPanel();
        pilihTempatMakan8 = new javax.swing.JLabel();
        panelPilihTempatMakan9 = new javax.swing.JPanel();
        pilihTempatMakan9 = new javax.swing.JLabel();
        panelPilihTempatMakan10 = new javax.swing.JPanel();
        pilihTempatMakan10 = new javax.swing.JLabel();
        panelPilihTempatMakan11 = new javax.swing.JPanel();
        pilihTempatMakan11 = new javax.swing.JLabel();
        panelPilihTempatMakan12 = new javax.swing.JPanel();
        pilihTempatMakan12 = new javax.swing.JLabel();
        panelPilihTempatMakan1 = new javax.swing.JPanel();
        pilihTempatMakan1 = new javax.swing.JLabel();
        datapesanan3 = new javax.swing.JLabel();
        datapesanan1 = new javax.swing.JLabel();
        datapesanan5 = new javax.swing.JLabel();
        datapesanan2 = new javax.swing.JLabel();
        datapesanan4 = new javax.swing.JLabel();
        datapesanan6 = new javax.swing.JLabel();
        datapesanan7 = new javax.swing.JLabel();
        datapesanan8 = new javax.swing.JLabel();
        datapesanan9 = new javax.swing.JLabel();
        datapesanan10 = new javax.swing.JLabel();
        datapesanan11 = new javax.swing.JLabel();
        datapesanan12 = new javax.swing.JLabel();
        btnfiltermenunggupembayaran = new javax.swing.JButton();
        btnfilterDimasak = new javax.swing.JButton();
        btnfilterdiantar = new javax.swing.JButton();
        btnfilterselesai = new javax.swing.JButton();
        status = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        txtFilterHistory = new javax.swing.JTextField();

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

        popuplabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popuppesanan.png"))); // NOI18N

        labelnama1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelnama1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelnama1.setToolTipText("");
        labelnama1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

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
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(btnClosePopUpHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 215, 48, 40));

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

        groupFilterHistory.add(btnHariIni);
        btnHariIni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHariIni.setText("Hari Ini");
        btnHariIni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHariIniMouseClicked(evt);
            }
        });
        getContentPane().add(btnHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        groupFilterHistory.add(btnKemarin);
        btnKemarin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnKemarin.setText("Kemarin");
        btnKemarin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKemarinMouseClicked(evt);
            }
        });
        getContentPane().add(btnKemarin, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, -1, -1));

        groupFilterHistory.add(btnMinggu);
        btnMinggu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMinggu.setText("Minggu");
        btnMinggu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMingguMouseClicked(evt);
            }
        });
        getContentPane().add(btnMinggu, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, -1, -1));

        groupFilterHistory.add(btnBulan);
        btnBulan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBulan.setText("Bulan");
        btnBulan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBulanMouseClicked(evt);
            }
        });
        getContentPane().add(btnBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, -1, -1));

        groupFilterHistory.add(btnTahun);
        btnTahun.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTahun.setText("Tahun");
        btnTahun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTahunMouseClicked(evt);
            }
        });
        getContentPane().add(btnTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, -1, -1));

        popupFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/popupfilterpesanan.png"))); // NOI18N
        getContentPane().add(popupFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judulForm.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 52)); // NOI18N
        judulForm.setText("PESANAN HARI INI");
        jPanel1.add(judulForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 12, -1, -1));

        btnhistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhistory.setOpaque(false);
        btnhistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhistoryLayout = new javax.swing.GroupLayout(btnhistory);
        btnhistory.setLayout(btnhistoryLayout);
        btnhistoryLayout.setHorizontalGroup(
            btnhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        btnhistoryLayout.setVerticalGroup(
            btnhistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel1.add(btnhistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 146, 46));

        cbFilter.setFont(new java.awt.Font("Swis721 BT", 0, 12)); // NOI18N
        cbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terbaru", "Terlama" }));
        cbFilter.setSelectedIndex(1);
        cbFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbFilter.setPreferredSize(new java.awt.Dimension(77, 22));
        cbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFilterActionPerformed(evt);
            }
        });
        jPanel1.add(cbFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 100, 90, 22));

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
            .addGap(0, 43, Short.MAX_VALUE)
        );
        btnsearchLayout.setVerticalGroup(
            btnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jPanel1.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 93, 43, 42));

        inputsearch.setForeground(new java.awt.Color(102, 102, 102));
        inputsearch.setText("Cari No. Pesanan...");
        inputsearch.setBorder(null);
        inputsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputsearchMouseClicked(evt);
            }
        });
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
        jPanel1.add(inputsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 101, 240, 23));

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

        labelJam.setFont(new java.awt.Font("Swis721 WGL4 BT", 1, 36)); // NOI18N
        labelJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJam.setText("08.30");
        jPanel1.add(labelJam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 230, 50));

        scrollcard.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollcard.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel12.setBackground(new java.awt.Color(245, 244, 244));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelnopesanan2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 70, 330, 50));

        labelnopesanan3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 330, 50));

        labelnopesanan4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1295, 70, 330, 50));

        labelnopesanan5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 70, 330, 50));

        labelnopesanan6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2125, 70, 330, 50));

        labelnopesanan7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2540, 70, 330, 50));

        labelnopesanan8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2955, 70, 330, 50));

        labelnopesanan9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan9.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3370, 70, 330, 50));

        labelnopesanan10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan10.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3785, 70, 330, 50));

        labelnopesanan11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan11.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4200, 70, 330, 50));

        labelnopesanan12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan12.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4615, 70, 330, 50));

        labelnopesanan1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel12.add(labelnopesanan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 330, 50));

        btn_cancel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel12MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4570, 20, 50, 40));

        btn_ceklis12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis12MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4940, 20, 40, 40));

        btn_cancel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel11MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4160, 20, 50, 40));

        btn_ceklis11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis11MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4530, 20, 40, 40));

        btn_cancel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel10MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3740, 20, 50, 40));

        btn_ceklis10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis10MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis10, new org.netbeans.lib.awtextra.AbsoluteConstraints(4110, 20, 40, 40));

        btn_cancel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel9MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3330, 20, 50, 40));

        btn_ceklis9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis9MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3700, 20, 40, 40));

        btn_cancel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel8MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2910, 20, 50, 40));

        btn_ceklis8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis8MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis8, new org.netbeans.lib.awtextra.AbsoluteConstraints(3280, 20, 40, 40));

        btn_ceklis7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis7MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2870, 20, 40, 40));

        btn_cancel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel7MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2500, 20, 50, 40));

        btn_ceklis6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis6MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2450, 20, 40, 40));

        btn_cancel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel6MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2080, 20, 50, 40));

        btn_cancel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel5MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 20, 50, 40));

        btn_ceklis5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis5MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2040, 20, 40, 40));

        btn_cancel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel4MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, 50, 40));

        btn_ceklis4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis4MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 20, 40, 40));

        btn_cancel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel3MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 50, 40));

        btn_ceklis3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis3MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, 50, 40));

        btn_cancel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel2MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 17, 44, 44));

        btn_ceklis2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis2MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 40, 40));

        btn_ceklis1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis1MouseClicked(evt);
            }
        });
        jPanel12.add(btn_ceklis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 50, 40));

        btn_cancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel1MouseClicked(evt);
            }
        });
        jPanel12.add(btn_cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 43, 41));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable2.setShowVerticalLines(true);
        jScrollPane2.setViewportView(jTable2);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 146, 385, 390));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable3.setShowVerticalLines(true);
        jScrollPane3.setViewportView(jTable3);

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 146, 385, 390));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable4.setShowVerticalLines(true);
        jScrollPane4.setViewportView(jTable4);

        jPanel12.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1267, 146, 385, 390));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable5.setShowVerticalLines(true);
        jScrollPane5.setViewportView(jTable5);

        jPanel12.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1682, 146, 385, 390));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable6.setShowVerticalLines(true);
        jScrollPane6.setViewportView(jTable6);

        jPanel12.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2097, 146, 385, 390));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable7.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable7.setShowVerticalLines(true);
        jScrollPane7.setViewportView(jTable7);

        jPanel12.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2512, 146, 385, 390));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable8.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable8.setShowVerticalLines(true);
        jScrollPane8.setViewportView(jTable8);

        jPanel12.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2927, 146, 385, 390));

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable9.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable9.setShowVerticalLines(true);
        jScrollPane9.setViewportView(jTable9);

        jPanel12.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3342, 146, 385, 390));

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable10.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable10.setShowVerticalLines(true);
        jScrollPane10.setViewportView(jTable10);

        jPanel12.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3757, 146, 385, 390));

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable11.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable11.setShowVerticalLines(true);
        jScrollPane11.setViewportView(jTable11);

        jPanel12.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4172, 146, 385, 390));

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable12.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable12.setShowVerticalLines(true);
        jScrollPane12.setViewportView(jTable12);

        jPanel12.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4588, 146, 385, 390));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel12.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 146, 385, 390));

        pilihTempatMakan2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan2.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan2.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan2.add(pilihTempatMakan2);

        jPanel12.add(panelPilihTempatMakan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 250, 30));

        pilihTempatMakan3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan3.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan3.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan3.add(pilihTempatMakan3);

        jPanel12.add(panelPilihTempatMakan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 250, 30));

        pilihTempatMakan4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan4.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan4.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan4.add(pilihTempatMakan4);

        jPanel12.add(panelPilihTempatMakan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 250, 30));

        pilihTempatMakan5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan5.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan5.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan5.add(pilihTempatMakan5);

        jPanel12.add(panelPilihTempatMakan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1748, 20, 250, 30));

        pilihTempatMakan6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan6.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan6.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan6.add(pilihTempatMakan6);

        jPanel12.add(panelPilihTempatMakan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2162, 20, 250, 30));

        pilihTempatMakan7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan7.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan7.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan7.add(pilihTempatMakan7);

        jPanel12.add(panelPilihTempatMakan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2574, 20, 250, 30));

        pilihTempatMakan8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan8.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan8.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan8.add(pilihTempatMakan8);

        jPanel12.add(panelPilihTempatMakan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2994, 20, 250, 30));

        pilihTempatMakan9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan9.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan9.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan9.add(pilihTempatMakan9);

        jPanel12.add(panelPilihTempatMakan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3410, 20, 250, 30));

        pilihTempatMakan10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan10.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan10.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan10.add(pilihTempatMakan10);

        jPanel12.add(panelPilihTempatMakan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3828, 20, 250, 30));

        pilihTempatMakan11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan11.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan11.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan11.add(pilihTempatMakan11);

        jPanel12.add(panelPilihTempatMakan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4656, 20, 250, 30));

        pilihTempatMakan12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan12.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan12.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan12.add(pilihTempatMakan12);

        jPanel12.add(panelPilihTempatMakan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4240, 20, 250, 30));

        pilihTempatMakan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan1.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan1.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan1.add(pilihTempatMakan1);

        jPanel12.add(panelPilihTempatMakan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 250, 30));

        datapesanan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 460, 530));

        datapesanan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, 460, 530));

        datapesanan5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 10, 460, 530));

        datapesanan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 10, 460, 530));

        datapesanan4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 10, 460, 530));

        datapesanan6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2035, 10, 460, 530));

        datapesanan7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2450, 10, 460, 530));

        datapesanan8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2865, 10, 460, 530));

        datapesanan9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3280, 10, 460, 530));

        datapesanan10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3695, 10, 460, 530));

        datapesanan11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4110, 10, 460, 530));

        datapesanan12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel12.add(datapesanan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4525, 10, 460, 530));

        scrollcard.setViewportView(jPanel12);

        jPanel1.add(scrollcard, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 150, 1256, 570));

        btnfiltermenunggupembayaran.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        btnfiltermenunggupembayaran.setText("Menunggu Pembayaran");
        btnfiltermenunggupembayaran.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfiltermenunggupembayaran.setPreferredSize(new java.awt.Dimension(160, 20));
        btnfiltermenunggupembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltermenunggupembayaranActionPerformed(evt);
            }
        });
        jPanel1.add(btnfiltermenunggupembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 102, 190, 20));

        btnfilterDimasak.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        btnfilterDimasak.setText("Dimasak");
        btnfilterDimasak.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfilterDimasak.setPreferredSize(new java.awt.Dimension(80, 20));
        btnfilterDimasak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfilterDimasakActionPerformed(evt);
            }
        });
        jPanel1.add(btnfilterDimasak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1141, 102, 90, 20));

        btnfilterdiantar.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        btnfilterdiantar.setText("Diantar");
        btnfilterdiantar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfilterdiantar.setPreferredSize(new java.awt.Dimension(80, 20));
        btnfilterdiantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfilterdiantarActionPerformed(evt);
            }
        });
        jPanel1.add(btnfilterdiantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 102, 90, 20));

        btnfilterselesai.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        btnfilterselesai.setText("SELESAI");
        btnfilterselesai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfilterselesai.setPreferredSize(new java.awt.Dimension(80, 20));
        btnfilterselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfilterselesaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnfilterselesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(829, 102, 100, 20));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(764, 0, 150, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADMIN MIE NGANGENI/4.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelnama2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelnama2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelnama2.setToolTipText("");
        labelnama2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(labelnama2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 8, 670, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(txtFilterHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 160, -1));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.setVisible(false);
        try {
            new AdminPesanan().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        this.setVisible(false);
        new AdminMenu().setVisible(true);
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        this.setVisible(false);
        new AdminPenjualan().setVisible(true);
        
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        this.setVisible(false);
        new AdminKaryawan().setVisible(true);
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        this.setVisible(false);
        new MainDisplay().setVisible(true);
        
    }//GEN-LAST:event_jPanel6MouseClicked

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
            Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btn_ceklis1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis1MouseClicked
        timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan1.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis1MouseClicked

    private void btn_cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel1MouseClicked
        timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan1.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel1MouseClicked

    private void btnfiltermenunggupembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltermenunggupembayaranActionPerformed
        timerNoFilter.stop();
        btnfiltermenunggupembayaran.setEnabled(false);
        btnfilterselesai.setEnabled(true);
        btnfilterDimasak.setEnabled(true);
        btnfilterdiantar.setEnabled(true);
        status.setText(null);
        status.setText("Perlu Konfirmasi Pembayaran");
        String currentDate = getCurrentDate();
        String query = "";
        query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Perlu Konfirmasi Pembayaran' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi ASC";
        cbFilter.setSelectedIndex(1);
        scheduleDataUpdateNoFilter(query);
    }//GEN-LAST:event_btnfiltermenunggupembayaranActionPerformed

    private void btnfilterdiantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfilterdiantarActionPerformed
        timerNoFilter.stop();
        btnfilterdiantar.setEnabled(false);
        btnfilterselesai.setEnabled(true);
        btnfilterDimasak.setEnabled(true);
        btnfiltermenunggupembayaran.setEnabled(true);
        status.setText(null);
        status.setText("Pesanan Siap Diantar");
        String currentDate = getCurrentDate();
        String query = "";
        query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Pesanan Siap Diantar' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi ASC";
        cbFilter.setSelectedIndex(1);
        scheduleDataUpdateNoFilter(query);
    }//GEN-LAST:event_btnfilterdiantarActionPerformed

    private void btnfilterselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfilterselesaiActionPerformed
        timerNoFilter.stop();
        btnfilterselesai.setEnabled(false);
        btnfilterDimasak.setEnabled(true);
        btnfilterdiantar.setEnabled(true);
        btnfiltermenunggupembayaran.setEnabled(true);
        status.setText(null);
        status.setText("Selesai");
        String currentDate = getCurrentDate();
        String query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Selesai' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi DESC";
        cbFilter.setSelectedIndex(0);
        scheduleDataUpdateNoFilter(query);
    }//GEN-LAST:event_btnfilterselesaiActionPerformed

    private void cbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFilterActionPerformed
           
    }//GEN-LAST:event_cbFilterActionPerformed

    private void inputsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearchActionPerformed

    }//GEN-LAST:event_inputsearchActionPerformed

    private void inputsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            timerNoFilter.stop();
            cbFilter.setSelectedIndex(0);
            try {
                scheduleDataUpdateNoFilter("SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.id LIKE '%"+inputsearch.getText()+"%' AND DATE(transaksi.tanggalTransaksi) = '"+getCurrentDate()+"' ORDER BY transaksi.tanggalTransaksi DESC;");
                
                String sql2="SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.id LIKE '%"+inputsearch.getText()+"%' AND DATE(transaksi.tanggalTransaksi) = '"+getCurrentDate()+"' ORDER BY transaksi.tanggalTransaksi DESC;";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement statement2 = conn.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs2 = statement2.executeQuery(sql2);
                if(rs2.next()){
                    String status = rs2.getString("status");
                    System.out.println(status);
                    if(status.equals("Selesai")){
                        btnfilterselesai.setEnabled(false);
                        btnfilterDimasak.setEnabled(true);
                        btnfilterdiantar.setEnabled(true);
                        btnfiltermenunggupembayaran.setEnabled(true);
                    }else if(status.equals("Sedang Dimasak")){
                        btnfilterselesai.setEnabled(true);
                        btnfilterDimasak.setEnabled(false);
                        btnfilterdiantar.setEnabled(true);
                        btnfiltermenunggupembayaran.setEnabled(true);
                    }else if(status.equals("Perlu Konfirmasi Pembayaran")){
                        btnfilterselesai.setEnabled(true);
                        btnfilterDimasak.setEnabled(true);
                        btnfilterdiantar.setEnabled(true);
                        btnfiltermenunggupembayaran.setEnabled(false);                        
                    }else if(status.equals("Pesanan Siap Diantar")){
                        btnfilterselesai.setEnabled(true);
                        btnfilterDimasak.setEnabled(true);
                        btnfilterdiantar.setEnabled(false);
                        btnfiltermenunggupembayaran.setEnabled(true);                        
                    }
                }
                conn.close();
            statement2.close();
            rs2.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }//GEN-LAST:event_inputsearchKeyPressed

    private void btnsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseClicked
        timerNoFilter.stop();
            cbFilter.setSelectedIndex(0);
            try {
                scheduleDataUpdateNoFilter("SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.id LIKE '%"+inputsearch.getText()+"%' AND DATE(transaksi.tanggalTransaksi) = '"+getCurrentDate()+"' ORDER BY transaksi.tanggalTransaksi DESC;");
                
                String sql2="SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.id LIKE '%"+inputsearch.getText()+"%' AND DATE(transaksi.tanggalTransaksi) = '"+getCurrentDate()+"' ORDER BY transaksi.tanggalTransaksi DESC;";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement statement2 = conn.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs2 = statement2.executeQuery(sql2);
                if(rs2.next()){
                    String status = rs2.getString("status");
                    System.out.println(status);
                    if(status.equals("Selesai")){
                        btnfilterselesai.setEnabled(false);
                        btnfilterDimasak.setEnabled(true);
                        btnfilterdiantar.setEnabled(true);
                        btnfiltermenunggupembayaran.setEnabled(true);
                    }else if(status.equals("Sedang Dimasak")){
                        btnfilterselesai.setEnabled(true);
                        btnfilterDimasak.setEnabled(false);
                        btnfilterdiantar.setEnabled(true);
                        btnfiltermenunggupembayaran.setEnabled(true);
                    }else if(status.equals("Perlu Konfirmasi Pembayaran")){
                        btnfilterselesai.setEnabled(true);
                        btnfilterDimasak.setEnabled(true);
                        btnfilterdiantar.setEnabled(true);
                        btnfiltermenunggupembayaran.setEnabled(false);                        
                    }else if(status.equals("Pesanan Siap Diantar")){
                        btnfilterselesai.setEnabled(true);
                        btnfilterDimasak.setEnabled(true);
                        btnfilterdiantar.setEnabled(false);
                        btnfiltermenunggupembayaran.setEnabled(true);                        
                    }
                }
                conn.close();
                statement2.close();
                rs2.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnsearchMouseClicked

    private void btnfilterDimasakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfilterDimasakActionPerformed
        timerNoFilter.stop();
        btnfilterDimasak.setEnabled(false);
        btnfilterselesai.setEnabled(true);
        btnfilterdiantar.setEnabled(true);
        btnfiltermenunggupembayaran.setEnabled(true);
        status.setText(null);
        status.setText("Sedang Dimasak");
        String currentDate = getCurrentDate();
        String query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Sedang Dimasak' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi ASC";
        scheduleDataUpdateNoFilter(query);
        cbFilter.setSelectedIndex(1);
    }//GEN-LAST:event_btnfilterDimasakActionPerformed

    private void inputsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputsearchMouseClicked
        inputsearch.setText(null);
    }//GEN-LAST:event_inputsearchMouseClicked

    private void btnterapkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnterapkanMouseClicked
        timerNoFilter.stop();
        String pilihanFilter = txtFilterHistory.getText();
        String urutkan = (String) cbFilter.getSelectedItem();
        String currentDate = getCurrentDate();
        String currentDateYesterday = getCurrentDateYestrday();
        String query;
        System.err.println(urutkan);
        if(urutkan == "Terbaru"){
            urutkan = "DESC";
        }else if(urutkan == "Terlama"){
            urutkan = "ASC";
        }
        switch(pilihanFilter){
            case "Hari Ini":
                    query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = '"+status.getText()+"' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi "+urutkan+"";
                    scheduleDataUpdateNoFilter(query);
                break;
            case "Kemarin":
                    query = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = '"+status.getText()+"' AND DATE(transaksi.tanggalTransaksi) = '" + currentDateYesterday + "' ORDER BY tanggalTransaksi "+urutkan+"";
                    scheduleDataUpdateNoFilter(query);
                break;
            case "Minggu":
                    setCurrentDateWeek(urutkan);
                break;    
            case "Bulan":
                    setCurrentDateMonth(urutkan);
                break; 
            case "Tahun":
                    setCurrentDateYear(urutkan);
                break;
        }
        popupFilter.setVisible(false);
        infofilter.setVisible(false);
        inputDate.setVisible(false);
        btnKemarin.setVisible(false);
        btnHariIni.setVisible(false);
        btnBulan.setVisible(false);
        btnMinggu.setVisible(false);
        btnTahun.setVisible(false);
        btnClosePopUpHistory.setVisible(false);
    }//GEN-LAST:event_btnterapkanMouseClicked

    private void btnHariIniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHariIniMouseClicked
        txtFilterHistory.setText("Hari Ini");
        inputDate.setVisible(false);
    }//GEN-LAST:event_btnHariIniMouseClicked

    private void btnKemarinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKemarinMouseClicked
        txtFilterHistory.setText("Kemarin");
        inputDate.setVisible(false);
    }//GEN-LAST:event_btnKemarinMouseClicked

    private void btnMingguMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMingguMouseClicked
        txtFilterHistory.setText("Minggu");
        inputDate.setVisible(true);
    }//GEN-LAST:event_btnMingguMouseClicked

    private void btnBulanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBulanMouseClicked
        txtFilterHistory.setText("Bulan");
        inputDate.setVisible(true);
    }//GEN-LAST:event_btnBulanMouseClicked

    private void btnTahunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTahunMouseClicked
        txtFilterHistory.setText("Tahun");
        inputDate.setVisible(true);
    }//GEN-LAST:event_btnTahunMouseClicked

    private void btnhistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhistoryMouseClicked
        timerNoFilter.stop();
        btnClosePopUpHistory.setVisible(true);
        popupFilter.setVisible(true);
        infofilter.setVisible(true);
        btnKemarin.setVisible(true);
        btnHariIni.setVisible(true);
        btnBulan.setVisible(true);
        btnMinggu.setVisible(true);
        btnTahun.setVisible(true);
        inputDate.setVisible(false);
    }//GEN-LAST:event_btnhistoryMouseClicked

    private void btnClosePopUpHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClosePopUpHistoryMouseClicked
        btnClosePopUpHistory.setVisible(false);
        popupFilter.setVisible(false);
        infofilter.setVisible(false);
        inputDate.setVisible(false);
        btnKemarin.setVisible(false);
        btnHariIni.setVisible(false);
        btnBulan.setVisible(false);
        btnMinggu.setVisible(false);
        btnTahun.setVisible(false);
        String currentDate = getCurrentDate();
        scheduleDataUpdateNoFilter("SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Selesai' AND DATE(transaksi.tanggalTransaksi) = '" + currentDate + "' ORDER BY tanggalTransaksi DESC");
        btnfilterDimasak.setEnabled(true);
        btnfilterselesai.setEnabled(false);
        btnfilterdiantar.setEnabled(true);
        btnfiltermenunggupembayaran.setEnabled(true);
    }//GEN-LAST:event_btnClosePopUpHistoryMouseClicked

    private void btn_ceklis2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis2MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan2.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();        
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis2MouseClicked

    private void btn_ceklis3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis3MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan3.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();            
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis3MouseClicked

    private void btn_ceklis4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis4MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan4.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis4MouseClicked

    private void btn_ceklis5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis5MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan5.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis5MouseClicked

    private void btn_ceklis6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis6MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan6.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis6MouseClicked

    private void btn_ceklis7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis7MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan7.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis7MouseClicked

    private void btn_ceklis8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis8MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan8.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis8MouseClicked

    private void btn_ceklis9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis9MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan9.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis9MouseClicked

    private void btn_ceklis10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis10MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan10.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis10MouseClicked

    private void btn_ceklis11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis11MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan11.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis11MouseClicked

    private void btn_ceklis12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis12MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        //mendapatkan info no pesanan
        String labelnopesanan = labelnopesanan12.getText();
        String newnopesanan = labelnopesanan.substring(4);
        
        //update status pesanan selesai tidak bisa dirubah
        if(status.getText().equals("Selesai")){
            try{
                JOptionPane.showMessageDialog(this, "Status Pesanan Mencapai Akhir");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            btnfilterselesai.setEnabled(false);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
        //update status pesanan Perlu Konfirmasi Pembayaran ke status sedang dimasak
        else if(status.getText().equals("Perlu Konfirmasi Pembayaran")){
            try {
                //
                String sql="UPDATE `transaksi` SET `status` = 'Sedang Dimasak' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                
                scheduleDataUpdateFilter();
                rubahDesainJTable();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(false);
            btnfilterDimasak.setEnabled(true);
        }
        //update status sedang dimasak ke status diantar
        else if(status.getText().equals("Sedang Dimasak")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.executeUpdate();
                scheduleDataUpdateFilter();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(true);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(false);
        }
        //update status peszanan sedang diantar ke status selesai
        else if(status.getText().equals("Pesanan Siap Diantar")){
            try {
                String sql="UPDATE `transaksi` SET `status` = 'Selesai' WHERE `transaksi`.`id` = "+newnopesanan+";";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                scheduleDataUpdateFilter();
                pstm.executeUpdate();
                cbFilter.setSelectedIndex(1);
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnfilterselesai.setEnabled(true);
            btnfilterdiantar.setEnabled(false);
            btnfiltermenunggupembayaran.setEnabled(true);
            btnfilterDimasak.setEnabled(true);
        }
    }//GEN-LAST:event_btn_ceklis12MouseClicked

    private void btn_cancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel2MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan2.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel2MouseClicked

    private void btn_cancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel3MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan3.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel3MouseClicked

    private void btn_cancel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel4MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan4.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel4MouseClicked

    private void btn_cancel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel5MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan5.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel5MouseClicked

    private void btn_cancel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel6MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan6.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel6MouseClicked

    private void btn_cancel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel7MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan7.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel7MouseClicked

    private void btn_cancel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel8MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan8.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel8MouseClicked

    private void btn_cancel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel9MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan9.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel9MouseClicked

    private void btn_cancel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel10MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan10.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel10MouseClicked

    private void btn_cancel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel11MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan11.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel11MouseClicked

    private void btn_cancel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel12MouseClicked
        // TODO add your handling code here:
         timerNoFilter.stop();
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try{
                String labelnopesanan = labelnopesanan12.getText();
                String newnopesanan = labelnopesanan.substring(4);
                String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                scheduleDataUpdateFilter();
                conn.close();
                pstm.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_cancel12MouseClicked

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
            java.util.logging.Logger.getLogger(AdminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminPesanan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AdminPesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JRadioButton btnBulan;
    private javax.swing.JPanel btnClosePopUpHistory;
    private javax.swing.JRadioButton btnHariIni;
    private javax.swing.JRadioButton btnKemarin;
    private javax.swing.JRadioButton btnMinggu;
    private javax.swing.JRadioButton btnTahun;
    private javax.swing.JLabel btn_cancel1;
    private javax.swing.JLabel btn_cancel10;
    private javax.swing.JLabel btn_cancel11;
    private javax.swing.JLabel btn_cancel12;
    private javax.swing.JLabel btn_cancel2;
    private javax.swing.JLabel btn_cancel3;
    private javax.swing.JLabel btn_cancel4;
    private javax.swing.JLabel btn_cancel5;
    private javax.swing.JLabel btn_cancel6;
    private javax.swing.JLabel btn_cancel7;
    private javax.swing.JLabel btn_cancel8;
    private javax.swing.JLabel btn_cancel9;
    private javax.swing.JLabel btn_ceklis1;
    private javax.swing.JLabel btn_ceklis10;
    private javax.swing.JLabel btn_ceklis11;
    private javax.swing.JLabel btn_ceklis12;
    private javax.swing.JLabel btn_ceklis2;
    private javax.swing.JLabel btn_ceklis3;
    private javax.swing.JLabel btn_ceklis4;
    private javax.swing.JLabel btn_ceklis5;
    private javax.swing.JLabel btn_ceklis6;
    private javax.swing.JLabel btn_ceklis7;
    private javax.swing.JLabel btn_ceklis8;
    private javax.swing.JLabel btn_ceklis9;
    private javax.swing.JButton btnfilterDimasak;
    private javax.swing.JButton btnfilterdiantar;
    private javax.swing.JButton btnfiltermenunggupembayaran;
    private javax.swing.JButton btnfilterselesai;
    private javax.swing.JPanel btnhistory;
    private javax.swing.JPanel btnsearch;
    private javax.swing.JPanel btnterapkan;
    private javax.swing.JComboBox<String> cbFilter;
    private javax.swing.JLabel datapesanan1;
    private javax.swing.JLabel datapesanan10;
    private javax.swing.JLabel datapesanan11;
    private javax.swing.JLabel datapesanan12;
    private javax.swing.JLabel datapesanan2;
    private javax.swing.JLabel datapesanan3;
    private javax.swing.JLabel datapesanan4;
    private javax.swing.JLabel datapesanan5;
    private javax.swing.JLabel datapesanan6;
    private javax.swing.JLabel datapesanan7;
    private javax.swing.JLabel datapesanan8;
    private javax.swing.JLabel datapesanan9;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.ButtonGroup groupFilterHistory;
    private javax.swing.JLabel infofilter;
    private javax.swing.JTextField inputDate;
    private javax.swing.JTextField inputsearch;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JLabel judulForm;
    private javax.swing.JLabel labelJam;
    public static final javax.swing.JLabel labelnama1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel labelnama2 = new javax.swing.JLabel();
    private javax.swing.JLabel labelnopesanan1;
    private javax.swing.JLabel labelnopesanan10;
    private javax.swing.JLabel labelnopesanan11;
    private javax.swing.JLabel labelnopesanan12;
    private javax.swing.JLabel labelnopesanan2;
    private javax.swing.JLabel labelnopesanan3;
    private javax.swing.JLabel labelnopesanan4;
    private javax.swing.JLabel labelnopesanan5;
    private javax.swing.JLabel labelnopesanan6;
    private javax.swing.JLabel labelnopesanan7;
    private javax.swing.JLabel labelnopesanan8;
    private javax.swing.JLabel labelnopesanan9;
    private javax.swing.JPanel panelPilihTempatMakan1;
    private javax.swing.JPanel panelPilihTempatMakan10;
    private javax.swing.JPanel panelPilihTempatMakan11;
    private javax.swing.JPanel panelPilihTempatMakan12;
    private javax.swing.JPanel panelPilihTempatMakan2;
    private javax.swing.JPanel panelPilihTempatMakan3;
    private javax.swing.JPanel panelPilihTempatMakan4;
    private javax.swing.JPanel panelPilihTempatMakan5;
    private javax.swing.JPanel panelPilihTempatMakan6;
    private javax.swing.JPanel panelPilihTempatMakan7;
    private javax.swing.JPanel panelPilihTempatMakan8;
    private javax.swing.JPanel panelPilihTempatMakan9;
    private javax.swing.JLabel pilihTempatMakan1;
    private javax.swing.JLabel pilihTempatMakan10;
    private javax.swing.JLabel pilihTempatMakan11;
    private javax.swing.JLabel pilihTempatMakan12;
    private javax.swing.JLabel pilihTempatMakan2;
    private javax.swing.JLabel pilihTempatMakan3;
    private javax.swing.JLabel pilihTempatMakan4;
    private javax.swing.JLabel pilihTempatMakan5;
    private javax.swing.JLabel pilihTempatMakan6;
    private javax.swing.JLabel pilihTempatMakan7;
    private javax.swing.JLabel pilihTempatMakan8;
    private javax.swing.JLabel pilihTempatMakan9;
    private javax.swing.JPanel popup;
    private javax.swing.JLabel popupFilter;
    private javax.swing.JLabel popuplabel;
    private javax.swing.JPanel popuptutup;
    private javax.swing.JScrollPane scrollcard;
    private javax.swing.JTextField status;
    private javax.swing.JTextField txtFilterHistory;
    // End of variables declaration//GEN-END:variables
}
