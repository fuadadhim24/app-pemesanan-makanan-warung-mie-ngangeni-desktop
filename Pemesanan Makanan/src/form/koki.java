/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Set;
import java.util.TimerTask;

/**
 *
 * @author fuada
 */
public class koki extends javax.swing.JFrame {

    /**
     * Creates new form koki
     */
    // Getter untuk displayGambarAkun


    private Timer timer; // Deklarasi objek Timer
    
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

    public void tampilkanData() throws SQLException, InterruptedException {
        String sql = "SELECT * FROM `transaksi` JOIN detail_transaksi ON transaksi.id = detail_transaksi.id_transaksi JOIN menu ON menu.id_menu=detail_transaksi.id_menu WHERE transaksi.status = 'Sedang Dimasak' ORDER BY tanggalTransaksi ASC";

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

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //update pemesanan
    private void scheduleDataUpdate() {
            int delay = 0; // Penundaan sebelum penjadwalan dimulai
            int interval = 5000; // Setiap 5 detik

            timer = new Timer(interval, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        tampilkanData();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } 
           });

            timer.setInitialDelay(delay);
            timer.start();
        }

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



    public koki() throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InterruptedException {
        initComponents();
        tampilkanData();
        updateJam();
        scheduleDataUpdate();
        rubahDesainJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelJam = new javax.swing.JLabel();
        scrollcard = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
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
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 20, 230, 60));

        labelJam.setFont(new java.awt.Font("Swis721 WGL4 BT", 1, 48)); // NOI18N
        labelJam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJam.setText("08.30");
        getContentPane().add(labelJam, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 10, 880, 60));

        displaygambarakun.setOpaque(true);
        getContentPane().add(displaygambarakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 12, 66, 66));

        labelnama.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        getContentPane().add(labelnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 320, 30));

        scrollcard.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollcard.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(245, 244, 244));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelnopesanan2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 70, 330, 50));

        labelnopesanan3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 330, 50));

        labelnopesanan4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1295, 70, 330, 50));

        labelnopesanan5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1710, 70, 330, 50));

        labelnopesanan6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2125, 70, 330, 50));

        labelnopesanan7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2540, 70, 330, 50));

        labelnopesanan8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2955, 70, 330, 50));

        labelnopesanan9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan9.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3370, 70, 330, 50));

        labelnopesanan10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan10.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3785, 70, 330, 50));

        labelnopesanan11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan11.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4200, 70, 330, 50));

        labelnopesanan12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan12.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4615, 70, 330, 50));

        labelnopesanan1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        labelnopesanan1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelnopesanan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 330, 50));

        btn_cancel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel12MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4570, 20, 50, 40));

        btn_ceklis12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis12MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4940, 20, 40, 40));

        btn_cancel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel11MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4160, 20, 50, 40));

        btn_ceklis11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis11MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4530, 20, 40, 40));

        btn_cancel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel10MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3740, 20, 50, 40));

        btn_ceklis10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis10MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis10, new org.netbeans.lib.awtextra.AbsoluteConstraints(4110, 20, 40, 40));

        btn_cancel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel9MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3330, 20, 50, 40));

        btn_ceklis9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis9MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3700, 20, 40, 40));

        btn_cancel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel8MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2910, 20, 50, 40));

        btn_ceklis8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis8MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis8, new org.netbeans.lib.awtextra.AbsoluteConstraints(3280, 20, 40, 40));

        btn_ceklis7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis7MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2870, 20, 40, 40));

        btn_cancel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel7MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2500, 20, 50, 40));

        btn_ceklis6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis6MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2450, 20, 40, 40));

        btn_cancel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel6MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2080, 20, 50, 40));

        btn_cancel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel5MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 20, 50, 40));

        btn_ceklis5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis5MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2040, 20, 40, 40));

        btn_cancel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel4MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, 50, 40));

        btn_ceklis4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis4MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 20, 40, 40));

        btn_cancel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel3MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 60, 40));

        btn_ceklis3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis3MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, 50, 40));

        btn_cancel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel2MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 50, 40));

        btn_ceklis2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis2MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 40, 40));

        btn_ceklis1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ceklis1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ceklis1MouseClicked(evt);
            }
        });
        jPanel1.add(btn_ceklis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 50, 40));

        btn_cancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancel1MouseClicked(evt);
            }
        });
        jPanel1.add(btn_cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 43, 41));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 146, 385, 390));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 146, 385, 390));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1267, 146, 385, 390));

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

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1682, 146, 385, 390));

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

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2097, 146, 385, 390));

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

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2512, 146, 385, 390));

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

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2927, 146, 385, 390));

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

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3342, 146, 385, 390));

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

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3757, 146, 385, 390));

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

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4172, 146, 385, 390));

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

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4588, 146, 385, 390));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 146, 385, 390));

        pilihTempatMakan2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan2.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan2.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan2.add(pilihTempatMakan2);

        jPanel1.add(panelPilihTempatMakan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 250, 30));

        pilihTempatMakan3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan3.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan3.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan3.add(pilihTempatMakan3);

        jPanel1.add(panelPilihTempatMakan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 250, 30));

        pilihTempatMakan4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan4.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan4.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan4.add(pilihTempatMakan4);

        jPanel1.add(panelPilihTempatMakan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, 250, 30));

        pilihTempatMakan5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan5.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan5.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan5.add(pilihTempatMakan5);

        jPanel1.add(panelPilihTempatMakan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1748, 20, 250, 30));

        pilihTempatMakan6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan6.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan6.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan6.add(pilihTempatMakan6);

        jPanel1.add(panelPilihTempatMakan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2162, 20, 250, 30));

        pilihTempatMakan7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan7.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan7.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan7.add(pilihTempatMakan7);

        jPanel1.add(panelPilihTempatMakan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2574, 20, 250, 30));

        pilihTempatMakan8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan8.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan8.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan8.add(pilihTempatMakan8);

        jPanel1.add(panelPilihTempatMakan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2994, 20, 250, 30));

        pilihTempatMakan9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan9.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan9.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan9.add(pilihTempatMakan9);

        jPanel1.add(panelPilihTempatMakan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3410, 20, 250, 30));

        pilihTempatMakan10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan10.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan10.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan10.add(pilihTempatMakan10);

        jPanel1.add(panelPilihTempatMakan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3828, 20, 250, 30));

        pilihTempatMakan11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan11.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan11.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan11.add(pilihTempatMakan11);

        jPanel1.add(panelPilihTempatMakan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4656, 20, 250, 30));

        pilihTempatMakan12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan12.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan12.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan12.add(pilihTempatMakan12);

        jPanel1.add(panelPilihTempatMakan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4240, 20, 250, 30));

        pilihTempatMakan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pilihTempatMakan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pilihTempatMakan1.setMinimumSize(new java.awt.Dimension(25, 20));
        pilihTempatMakan1.setPreferredSize(new java.awt.Dimension(220, 20));
        panelPilihTempatMakan1.add(pilihTempatMakan1);

        jPanel1.add(panelPilihTempatMakan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 250, 30));

        datapesanan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 460, 530));

        datapesanan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, 460, 530));

        datapesanan5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 10, 460, 530));

        datapesanan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 10, 460, 530));

        datapesanan4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 10, 460, 530));

        datapesanan6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2035, 10, 460, 530));

        datapesanan7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan7, new org.netbeans.lib.awtextra.AbsoluteConstraints(2450, 10, 460, 530));

        datapesanan8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2865, 10, 460, 530));

        datapesanan9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan9, new org.netbeans.lib.awtextra.AbsoluteConstraints(3280, 10, 460, 530));

        datapesanan10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan10, new org.netbeans.lib.awtextra.AbsoluteConstraints(3695, 10, 460, 530));

        datapesanan11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan11, new org.netbeans.lib.awtextra.AbsoluteConstraints(4110, 10, 460, 530));

        datapesanan12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/card pesanan.png"))); // NOI18N
        jPanel1.add(datapesanan12, new org.netbeans.lib.awtextra.AbsoluteConstraints(4525, 10, 460, 530));

        scrollcard.setViewportView(jPanel1);

        getContentPane().add(scrollcard, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 103, 1256, 570));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/koki/8.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.dispose();
        new MainDisplay().setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void btn_ceklis1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis1MouseClicked
        try{
            String labelnopesanan = labelnopesanan1.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis1MouseClicked

    private void btn_cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel1MouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan1.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel1MouseClicked

    private void btn_ceklis2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis2MouseClicked
        try{
            String labelnopesanan = labelnopesanan2.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis2MouseClicked

    private void btn_ceklis3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis3MouseClicked
        try{
            String labelnopesanan = labelnopesanan3.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis3MouseClicked

    private void btn_ceklis4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis4MouseClicked
         try{
            String labelnopesanan = labelnopesanan4.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis4MouseClicked

    private void btn_ceklis5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis5MouseClicked
         try{
            String labelnopesanan = labelnopesanan5.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis5MouseClicked

    private void btn_ceklis6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis6MouseClicked
         try{
            String labelnopesanan = labelnopesanan6.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis6MouseClicked

    private void btn_ceklis7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis7MouseClicked
         try{
            String labelnopesanan = labelnopesanan7.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis7MouseClicked

    private void btn_ceklis8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis8MouseClicked
         try{
            String labelnopesanan = labelnopesanan8.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis8MouseClicked

    private void btn_ceklis9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis9MouseClicked
         try{
            String labelnopesanan = labelnopesanan9.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis9MouseClicked

    private void btn_ceklis10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis10MouseClicked
         try{
            String labelnopesanan = labelnopesanan10.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis10MouseClicked

    private void btn_ceklis11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis11MouseClicked
         try{
            String labelnopesanan = labelnopesanan11.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis11MouseClicked

    private void btn_ceklis12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ceklis12MouseClicked
         try{
            String labelnopesanan = labelnopesanan12.getText();
            String newnopesanan = labelnopesanan.substring(4);
            String sql="UPDATE `transaksi` SET `status` = 'Pesanan Siap Diantar' WHERE `transaksi`.`id` = "+newnopesanan+";";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.executeUpdate();
            tampilkanData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_ceklis12MouseClicked

    private void btn_cancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel2MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan2.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel2MouseClicked

    private void btn_cancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel3MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan3.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel3MouseClicked

    private void btn_cancel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel4MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan4.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel4MouseClicked

    private void btn_cancel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel5MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan5.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel5MouseClicked

    private void btn_cancel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel6MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan6.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel6MouseClicked

    private void btn_cancel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel7MouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan7.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel7MouseClicked

    private void btn_cancel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel8MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan8.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel8MouseClicked

    private void btn_cancel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel9MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan9.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel9MouseClicked

    private void btn_cancel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel10MouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan10.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel10MouseClicked

    private void btn_cancel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel11MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan11.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
            }
    }//GEN-LAST:event_btn_cancel11MouseClicked

    private void btn_cancel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancel12MouseClicked
         int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus pesanan ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                    try{
                        String labelnopesanan = labelnopesanan12.getText();
                        String newnopesanan = labelnopesanan.substring(4);
                        String sql="DELETE FROM transaksi WHERE `transaksi`.`id` = "+newnopesanan+"";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                        pstm.execute();
                        tampilkanData();
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
            java.util.logging.Logger.getLogger(koki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(koki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(koki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(koki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new koki().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(koki.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(koki.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(koki.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(koki.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(koki.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
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
    public static final javax.swing.JLabel displaygambarakun = new javax.swing.JLabel();
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JLabel labelJam;
    public static final javax.swing.JLabel labelnama = new javax.swing.JLabel();
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
    private javax.swing.JScrollPane scrollcard;
    // End of variables declaration//GEN-END:variables
}
