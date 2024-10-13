package gui;

import java.awt.Color;
import java.util.logging.*;
import javax.swing.JOptionPane;
import model.MySQL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class MemberSection extends javax.swing.JPanel {

    private static String employeeNic;
    private String memberId;
    private final static Logger logger = Logger.getLogger(MemberSection.class.getName());

    LocalDate date = LocalDate.now();
    /**
     * Creates new form MemberSection
     */
    public MemberSection(String nic) {
        initComponents();
        this.employeeNic = nic;
        setLogger();
        loadOccupations();
        loadTable();
    }

    private void setLogger() {

        try {

            Handler fileHandler = new FileHandler("MemberSection.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, "MemberSection Initialized");

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Failed to Initialize Member Section");
        }
    }

    private void loadOccupations() {
        try {

            ResultSet search = MySQL.exeSearch("SELECT * FROM `occupation`");
            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (search.next()) {
                vector.add(search.getString("Name"));
                DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
                jComboBox2.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Failed to load Occupation Db error");
        }
    }

    private void clearFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jLabel12.setText("");
        jComboBox2.setSelectedItem("Select");
        jComboBox2.setEnabled(true);

        jTextField6.setEditable(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jRadioButton1.setSelected(false);

    }
    
    private void clearSearchFileds(){
        jTextField7.setText("");
        jLabel16.setText("...");
        jLabel16.setBackground(Color.blue);
        jLabel20.setText("...");
        jLabel20.setBackground(Color.GRAY);
        jRadioButton2.setSelected(false);
        
        jButton8.setText("...");
        jButton8.setBackground(Color.GRAY);
        jButton8.setSize(76,27);
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
        
    }
    
    
    private void loadTable(){
  
        try {
            
             String sortInput = String.valueOf(jComboBox3.getSelectedItem());
          
             String query = "SELECT * FROM `member` INNER JOIN `memberstatus` ON `memberstatus`.`ID` = `member`.`MemberStatus_ID` ";
            
             if(sortInput.equals("Name ASC")){
                 query += "ORDER BY `member`.`FirstName` ASC";
          
             }else if(sortInput.equals("Name DESC")){
                 query += "ORDER BY `member`.`FirstName` DESC";
            
             }else if(sortInput.equals("Added Date(Newest First)")){
                 query += "ORDER BY `member`.`RegDate` ASC";
           
             }else if(sortInput.equals("Added Date(Oldest First)")){
                  query += "ORDER BY `member`.`RegDate` DESC";
             }
             
             
             ResultSet search  = MySQL.exeSearch(query);
            
             DefaultTableModel tableModel = (DefaultTableModel)jTable3.getModel();
             tableModel.setRowCount(0);
            
             while(search.next()){
                 
                 Vector<String> vector = new Vector<>();
                 vector.add(search.getString("member.ID"));
                 vector.add(search.getString("member.FirstName") +" " +search.getString("member.Surname"));
                 vector.add(search.getString("member.Contact"));
                 vector.add(search.getString("memberstatus.Status"));
                 tableModel.addRow(vector);
             }
             
             jTable3.setModel(tableModel);
            
            
        } catch (Exception e) {
        e.printStackTrace();
        logger.log(Level.SEVERE,"Failed to load Main Table");
        }
        
        
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(980, 660));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(980, 60));

        jLabel1.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        jLabel1.setText("Member Section");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(804, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 153));
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 153));
        jLabel3.setText("Surname");

        jLabel4.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 153));
        jLabel4.setText("Birth Day");

        jLabel5.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 153));
        jLabel5.setText("Contact");

        jLabel6.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 153));
        jLabel6.setText("E-Mail");

        jLabel8.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 153));
        jLabel8.setText("Occupation");

        jTextField1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jTextField2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField4.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 153));
        jLabel9.setText("Member ID");

        jButton1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 102));
        jButton2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-icon.png"))); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 51));
        jButton4.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        jButton4.setText("Deactive");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 153));
        jLabel10.setText("Registration Fee");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/email-icon.png"))); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel11.setText(" :");

        jLabel12.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 153));
        jLabel12.setText("...");

        jRadioButton1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jRadioButton1.setText("Paid");

        jLabel13.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 204, 153));
        jLabel13.setText("Change Member Status");

        jTextField7.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel14.setText("Member ID or Mobile");

        jButton7.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel15.setText("Current Status :");

        jLabel16.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 204));
        jLabel16.setText("...");

        jTable1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member Id", "Name", "Contact", "E-Mail", "Occupation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel17.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel17.setText("History");

        jTable2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "Reserve Date", "Return Date", "Book ID", "Return Status", "Librarian NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel19.setText("Fee :");

        jLabel20.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("...");

        jRadioButton2.setText("Paid");

        jButton8.setText("....");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addComponent(jLabel17)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addGap(69, 69, 69)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(8, 8, 8)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Find Information", jPanel3);

        jLabel18.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jLabel18.setText("Sort By");

        jComboBox3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", "Added Date(Newest First)", "Added Date(Oldest First)" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Member ID", "Name", "Contact", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("All Data", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3))
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel2)
                        .addComponent(jLabel10)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton6))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton4)))))
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane1)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jRadioButton1))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String firstName = jTextField1.getText();
        String lastName = jTextField2.getText();
        String birthDay = jTextField3.getText();
        String contact = jTextField4.getText();
        String email = jTextField5.getText();
        String memberId = jTextField6.getText();
        int occupation = jComboBox2.getSelectedIndex();

        if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First Name is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField1.grabFocus();

        } else if (lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last Name is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField2.grabFocus();

        } else if (birthDay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "BirthDay is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField3.grabFocus();

        } else if (!birthDay.matches("^(19|20)\\d{2}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12]\\d|3[01])$")) {
            JOptionPane.showMessageDialog(this, "Invalid Birth day format Correct format is - Year-Month-Day ex:2002-01-15", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField3.grabFocus();

        } else if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contact is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField4.grabFocus();

        } else if (!contact.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Contact", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField4.grabFocus();

        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "E-Mail is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField5.grabFocus();

        } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(this, "E-Mail is Invalid", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField5.grabFocus();

        } else if (memberId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Member ID is Empty ", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField5.grabFocus();

        } else if (!(memberId.length() == 8)) {
            JOptionPane.showMessageDialog(this, "Member ID Should be 8 Characters!", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField5.grabFocus();

        } else if (occupation == 0) {
            JOptionPane.showMessageDialog(this, "Select the Occupation!", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField5.grabFocus();

        } else {

            try {

                ResultSet idSearch = MySQL.exeSearch("SELECT `id` FROM `member` WHERE `ID`='" + memberId + "' OR `contact`='" + contact + "' OR `email`='" + email + "'");
                if (idSearch.next()) {
                    JOptionPane.showMessageDialog(this, "Already Registered Member", "Warning", JOptionPane.WARNING_MESSAGE);
                    idSearch.close();
                } else {

                    if (jRadioButton1.isSelected()) {
                        
                        float amount = Float.valueOf(jLabel12.getText());
                        String note = "Registration Fee";

                        MySQL.exeUpdate("INSERT INTO `member` (`ID`,`FirstName`,`Surname`,`BirthDay`,`Contact`,`Email`,`RegDate`,`Occupation_ID`,`MemberStatus_ID`,`Librarian_NIC`)"
                                + " VALUES('" + memberId + "','" + firstName + "','" + lastName + "','" + birthDay + "','" + contact + "','" + email + "',  '"+date+"' , '" + occupation + "','1','" + employeeNic + "') ");
     
                        MySQL.exeUpdate("INSERT INTO `fines` (`Note`,`Amount`,`date`,`Librarian_NIC`,`Member_ID`) VALUES ('" + note + "','" + amount + "', '" + date + "' , '" + employeeNic + "', '" + memberId + "')");
                       
                        JOptionPane.showMessageDialog(this, "Successfully Registered", "Success", JOptionPane.PLAIN_MESSAGE);
                        clearFields();

                    } else {
                        JOptionPane.showMessageDialog(this, "To Complete the Registration Member have to Pay Registration Fee!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.SEVERE,"Failed to Insert New Member");
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Random random = new Random();
        jTextField6.setText(String.valueOf(10000000 + random.nextInt(99999999)));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged

        int occupation = jComboBox2.getSelectedIndex();

        if (occupation != 0) {
            try {

                ResultSet search = MySQL.exeSearch("SELECT `amount` FROM `fees` WHERE `occupation_ID`= '" + occupation + "'");

                if (search.next()) {
                    jLabel12.setText(String.valueOf(search.getString("amount")));
                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, "Faild to load Reg Fee from Db");
            }

        }

    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clearFields();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String memberId = jTextField6.getText();
        String contact = jTextField4.getText();

        if (memberId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Member ID or Mobile to Update Data !", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            try {

                ResultSet search = MySQL.exeSearch("SELECT `FirstName` FROM `member` WHERE `ID`='" + memberId + "' OR `contact`='" + contact + "' ");
                if (search.next()) {
                    search.close();

                    String firstName = jTextField1.getText();
                    String lastName = jTextField2.getText();
                    String birthDay = jTextField3.getText();
                    String email = jTextField5.getText();
                    int occupation = jComboBox2.getSelectedIndex();

                    if (firstName.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "First Name is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField1.grabFocus();

                    } else if (lastName.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Last Name is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField2.grabFocus();

                    } else if (birthDay.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "BirthDay is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField3.grabFocus();

                    } else if (!birthDay.matches("^(19|20)\\d{2}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12]\\d|3[01])$")) {
                        JOptionPane.showMessageDialog(this, "Invalid Birth day format Correct format is - Year-Month-Day ex:2002-01-15", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField3.grabFocus();

                    } else if (contact.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Contact is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField4.grabFocus();

                    } else if (!contact.matches("^07[01245678]{1}[0-9]{7}$")) {
                        JOptionPane.showMessageDialog(this, "Invalid Contact", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField4.grabFocus();

                    } else if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "E-Mail is Empty", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField5.grabFocus();

                    } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                        JOptionPane.showMessageDialog(this, "E-Mail is Invalid", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField5.grabFocus();

                    } else if (memberId.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Member ID is Empty ", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField5.grabFocus();

                    } else if (!(memberId.length() == 8)) {
                        JOptionPane.showMessageDialog(this, "Member ID Should be 8 Characters!", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField5.grabFocus();

                    } else if (occupation == 0) {
                        JOptionPane.showMessageDialog(this, "Select the Occupation!", "Warning", JOptionPane.WARNING_MESSAGE);
                        jTextField5.grabFocus();

                    } else {

                        MySQL.exeUpdate("UPDATE `member` SET `FirstName`='" + firstName + "', `Surname`='" + lastName + "',  `Birthday`='" + birthDay + "',  "
                                + " `Contact`='" + contact + "', `Email`='" + email + "' WHERE `ID`='" + memberId + "'  ");

                        JOptionPane.showMessageDialog(this, "Successfully Registered", "Success", JOptionPane.PLAIN_MESSAGE);
                        clearFields();

                    }

                } else {
                    search.close();
                    JOptionPane.showMessageDialog(this, "Invalid Member ID or Mobile!", "Warning", JOptionPane.WARNING_MESSAGE);

                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, "Failed to Update Member Date Db Error");
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased

        String contact = jTextField4.getText();

        try {

            ResultSet search = MySQL.exeSearch("SELECT * FROM `member` WHERE `Contact`='" + contact + "'");

            if (search.next()) {

                jTextField1.setText(search.getString("FirstName"));
                jTextField2.setText(search.getString("Surname"));
                jTextField3.setText(search.getString("BirthDay"));
                jTextField4.setText(search.getString("Contact"));
                jTextField5.setText(search.getString("Email"));
                jTextField6.setText(search.getString("ID"));
                jComboBox2.setSelectedIndex(search.getInt("Occupation_ID"));

                jTextField6.setEditable(false);
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jRadioButton1.setSelected(true);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Failed to Load member data using Contact");
        }


    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        String memberID = jTextField6.getText();

        try {

            ResultSet search = MySQL.exeSearch("SELECT * FROM `member` WHERE `ID`='" + memberID + "'");

            if (search.next()) {
                jTextField1.setText(search.getString("FirstName"));
                jTextField2.setText(search.getString("Surname"));
                jTextField3.setText(search.getString("BirthDay"));
                jTextField4.setText(search.getString("Contact"));
                jTextField5.setText(search.getString("Email"));
                jComboBox2.setSelectedIndex(search.getInt("Occupation_ID"));

                jTextField6.setEditable(false);
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jRadioButton1.setSelected(true);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Failed to Load member data using Contact");
        }


    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String memberId = jTextField6.getText();
        String contact = jTextField4.getText();

        if (!memberId.isEmpty() || !contact.isEmpty()) {

            try {

                ResultSet seacrh = MySQL.exeSearch("SELECT * FROM `member` WHERE `ID`='" + memberId + "' OR `Contact`='" + contact + "' ");

                if (seacrh.next()) {

                    String id = seacrh.getString("ID");
                    String name = seacrh.getString("FirstName");
                    String secondname = seacrh.getString("Surname");

                    int response = JOptionPane.showConfirmDialog(this, "Do you want to Deactive" +" " + name+" " +secondname +" " + "?", "Warning", JOptionPane.YES_NO_OPTION);

                    if (response == JOptionPane.YES_OPTION) {
                        MySQL.exeUpdate("UPDATE `member` SET `MemberStatus_ID`= '2' WHERE `ID`='"+id+"'");
                        seacrh.close();
                        JOptionPane.showMessageDialog(this, "Success !", "Success", JOptionPane.PLAIN_MESSAGE);
                        clearFields();

                    } else {
                        seacrh.close();
                        clearFields();
                    }

                } else {
                    seacrh.close();
                    JOptionPane.showMessageDialog(this, "Invalid ID or Contact !", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, "Failed to Remove Member Date Db Error");
            }

        } else {

            JOptionPane.showMessageDialog(this, "Enter Member id or Contact to Remove Member !", "Warning", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    
       String ref = jTextField7.getText();
       
       if(ref.isEmpty()){
             JOptionPane.showMessageDialog(this, "User MemberId or Contact to find information !", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextField7.grabFocus();
       }else{
           try {
               
               ResultSet search = MySQL.exeSearch("SELECT * FROM `member` INNER JOIN `occupation` ON `occupation`.`ID` = `member`.`Occupation_ID` "
                       + "  WHERE `member`.`ID`='"+ref+"' OR `member`.`Contact`='"+ref+"'");
               
               if(search.next()){
                  
                   int status = search.getInt("member.MemberStatus_ID");
                    memberId = search.getString("member.ID");
 
                   if(status == 1){
                   
                      jLabel16.setForeground(Color.GREEN);
                      jLabel16.setText("Active");
                       jButton8.setBackground(Color.RED);
                      jButton8.setText("Deactive");
                       
                   }else{
                      
                      jLabel16.setForeground(Color.red);
                      jLabel16.setText("Deactive");
                       ResultSet feeSearch = MySQL.exeSearch("SELECT `amount` FROM `fees` WHERE `ID`='5'");
                       
                       if(feeSearch.next()){
                           jLabel20.setText(feeSearch.getString("amount"));
                           feeSearch.close();
                           jButton8.setBackground(new Color(0,153,102));
                           jButton8.setText("Active");
                       }else{
                           logger.log(Level.SEVERE,"Failed to get amont from db jButton7ActionPerformed ");
                       }
                   }
                   
                   DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();                  
                   tableModel.setRowCount(0);
                   Vector<String> vector = new Vector<>();
                   vector.add(memberId);
                   vector.add(search.getString("member.FirstName") +" " +search.getString("member.Surname"));
                   vector.add(search.getString("member.Contact"));
                   vector.add(search.getString("member.Email"));
                   vector.add(search.getString("occupation.name"));
                   tableModel.addRow(vector);
                   jTable1.setModel(tableModel);
                   search.close();
                   
                   ResultSet historySearch = MySQL.exeSearch("SELECT * FROM `reserve` INNER JOIN `returnstatus` "
                           + "ON `returnstatus`.`ID` = `reserve`.`ReturnStatus_ID` "
                           + "WHERE `reserve`.`Member_ID`='"+memberId+"' ");
                   
                    DefaultTableModel tabModel = (DefaultTableModel) jTable2.getModel();  
                    tabModel.setRowCount(0);
                   
                   while(historySearch.next()){
                       
                             Vector<String> vec = new Vector<>();
                             vec.add(historySearch.getString("ID"));
                             vec.add(historySearch.getString("ReserveDate"));
                             vec.add(historySearch.getString("ReturnDate"));
                             vec.add(historySearch.getString("BookLibrary_ID"));
                             vec.add(historySearch.getString("returnstatus.Status"));
                             vec.add(historySearch.getString("Librarian_NIC"));
                             tabModel.addRow(vec);
                                                    
                   }
                             jTable2.setModel(tabModel);                
                              historySearch.close();
                   
                   
               }else{
                  search.close();
                  JOptionPane.showMessageDialog(this, "Cannot find Member!", "Warning", JOptionPane.WARNING_MESSAGE);
               }
               
               
           } catch (Exception e) {
           e.printStackTrace();
           logger.log(Level.SEVERE, "Failed to find Member Information jButton7Action Db Error!");
           }
       }
       
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       clearSearchFileds();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
                
        String text = jButton8.getText();
        String fee = jLabel20.getText();
        String note = "Membership Renew Fee";
        try {
            
              if(text.equals("Active")){
            
            if(jRadioButton2.isSelected()){
                
                MySQL.exeUpdate("UPDATE `member` SET `MemberStatus_ID`='1' WHERE `ID`='"+memberId+"'");
                MySQL.exeUpdate("INSERT INTO `fines` (`Note`,`Amount`,`date`,`Librarian_NIC`,`Member_ID`) "
                        + "VALUES ('"+note+"', '"+fee+"','"+date+"' , '"+employeeNic+"', '"+memberId+"') ");
                
                JOptionPane.showMessageDialog(this, "Succesfully Membership Activated !", "Success", JOptionPane.PLAIN_MESSAGE);
                clearSearchFileds();
                
            }else{
                JOptionPane.showMessageDialog(this, "Member have to pay Renew charge to Activate Membership !", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
            
        }else{
            
            int response = JOptionPane.showConfirmDialog(this, "Do you want to Deactive Membership !","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(response == JOptionPane.YES_OPTION){
                MySQL.exeUpdate("UPDATE `member` SET `MemberStatus_ID`='2' WHERE `ID`='"+memberId+"'");
                 JOptionPane.showMessageDialog(this, "Succesfully Membership Deactivated !", "Success", JOptionPane.PLAIN_MESSAGE);
                clearSearchFileds();
            }
            
        }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE,"Failed to update Member Status jButton8ActionPerformed Error");
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
       loadTable();
    }//GEN-LAST:event_jComboBox3ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
