package process;

import model.MySQL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class LibrarySection extends javax.swing.JPanel {

    private static String employeeNic;
    HashMap<String, Integer> catMap = new HashMap<>();
    HashMap<String, Integer> sectionMap = new HashMap<>();
    HashMap<String, Integer> locationMap = new HashMap<>();

    public LibrarySection(String nic) {
        initComponents();
        loadLocations();
        loadSections();
        loadCategories();
        defaultConfigure();
        loadTable();
        this.employeeNic = nic;
    }

    private void loadCategories() {

        try {

            ResultSet catSearch = MySQL.exeSearch("SELECT * FROM `bookcat`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (catSearch.next()) {

                vector.add(catSearch.getString("CatName"));
                catMap.put(catSearch.getString("CatName"), catSearch.getInt("ID"));
                DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(vector);
                jComboBox1.setModel(comboBoxModel);
            }

            catSearch.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadSections() {
        try {

            ResultSet search = MySQL.exeSearch("SELECT * FROM `section`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (search.next()) {
                vector.add(search.getString("Section"));
                sectionMap.put(search.getString("Section"), search.getInt("ID"));
                DefaultComboBoxModel boxModel = new DefaultComboBoxModel(vector);
                jComboBox2.setModel(boxModel);
            }

            search.close();

        } catch (Exception e) {
        }
    }

    private void loadLocations() {
        try {

            ResultSet search = MySQL.exeSearch("SELECT * FROM `cupboard`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (search.next()) {
                vector.add(search.getString("Cupboard"));
                locationMap.put(search.getString("Cupboard"), search.getInt("ID"));
                DefaultComboBoxModel boxModel = new DefaultComboBoxModel(vector);
                jComboBox3.setModel(boxModel);
            }

            search.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFeilds() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedItem("Select");
        jComboBox2.setSelectedItem("Select");
        jComboBox3.setSelectedItem("Select");
        jTextField5.setEditable(true);
        jTextField3.setEditable(true);

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);

    }

    private void defaultConfigure() {
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
    }
    
    private void loadTable(){
        
        try {
            
            String sortInput = String.valueOf(jComboBox4.getSelectedItem());
            
            String query = "SELECT `booklibrary`.`ID`, `booklibrary`.`Name`, `booklibrary`.`Author`, `booklibrary`.`Date_Added`, `bookcat`.`CatName` "
                    + "FROM `booklibrary` INNER JOIN `bookcat` ON `bookcat`.`ID` = `booklibrary`.`BookCat_ID`";
            
            if(sortInput.equals("Name ASC")){
                query += "ORDER BY `booklibrary`.`Name` ASC";
            
            }else if(sortInput.equals("Name DESC")){
                query +="ORDER BY `booklibrary`.`Name` DESC";
        
            }else if(sortInput.equals("Added Date (Newest First)")){
                query +="ORDER BY `booklibrary`.`Date_Added` ASC";
         
            }else if(sortInput.equals("Added Date(Old First)")){
                query +="ORDER BY `booklibrary`.`Date_Added` DESC";
            }
            
            ResultSet search = MySQL.exeSearch(query);
            
            DefaultTableModel tableModel = (DefaultTableModel)jTable3.getModel();
            tableModel.setRowCount(0);
            
            while(search.next()){
                Vector<String> vector = new Vector<>();
                vector.add(search.getString("booklibrary.ID"));
                vector.add(search.getString("booklibrary.Name"));
                vector.add(search.getString("booklibrary.Author"));
                vector.add(search.getString("booklibrary.Date_Added"));
                vector.add(search.getString("bookcat.CatName"));
                tableModel.addRow(vector);
            }
            jTable3.setModel(tableModel);
            
        } catch (Exception e) {
           e.printStackTrace();
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(980, 660));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 60));

        jLabel1.setFont(new java.awt.Font("Gotham", 0, 18)); // NOI18N
        jLabel1.setText("Library Section");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(838, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(340, 451));

        jLabel2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 153));
        jLabel2.setText("Book Name");

        jLabel3.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 153));
        jLabel3.setText("Author");

        jLabel4.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 153));
        jLabel4.setText("Added Date");

        jLabel5.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 153));
        jLabel5.setText("Category");

        jLabel6.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 153));
        jLabel6.setText("Book ID");

        jTextField1.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jTextField2.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField3.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField5.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jButton1.setText("Today");
        jButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jButton2.setText("Generate");
        jButton2.setPreferredSize(new java.awt.Dimension(85, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-icon.png"))); // NOI18N
        jButton3.setText("Add");
        jButton3.setPreferredSize(new java.awt.Dimension(98, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jButton4.setText("Update");
        jButton4.setPreferredSize(new java.awt.Dimension(98, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 0, 0));
        jButton5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        jButton5.setText("Remove");
        jButton5.setPreferredSize(new java.awt.Dimension(98, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 153));
        jLabel7.setText("Add Location");

        jTextField4.setFont(new java.awt.Font("Gotham", 0, 15)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 153));
        jLabel8.setText("Add Section");

        jLabel9.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 153));
        jLabel9.setText("Add Cupboard");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-icon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Enter Book ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jButton6)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton11)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9)))))
                        .addGap(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.LINE_START);

        jLabel10.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 153));
        jLabel10.setText("Find Information");

        jLabel11.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel11.setText("Enter Book ID or Name");

        jTextField6.setFont(new java.awt.Font("Gotham", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Author", "Added Date", "Category", "Added By"
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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Section", "Cupboard"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Cupboard");
        }

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 153));
        jLabel12.setText("All Books ");

        jLabel13.setFont(new java.awt.Font("Gotham", 0, 12)); // NOI18N
        jLabel13.setText("Sort By");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name ASC", "Name DESC", "Added Date (Newest First)", "Added Date(Old First)" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Category"
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

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LocalDate today = LocalDate.now();
        jTextField3.setText(today.format(DateTimeFormatter.ofPattern("yyy-dd-MM")));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Random random = new Random();
        jTextField5.setText(String.valueOf(100000 + random.nextInt(999999)));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String name = jTextField1.getText();
        String author = jTextField2.getText();
        String date = jTextField3.getText();
        String bookId = jTextField5.getText();
        String cat = String.valueOf(jComboBox1.getSelectedItem());

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is Empty !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField1.grabFocus();

        } else if (author.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Author is Empty !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField2.grabFocus();

        } else if (date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Date is Empty !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField3.grabFocus();

        } else if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book Id is Empty !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.grabFocus();

        } else if (!(bookId.length() == 6)) {
            JOptionPane.showMessageDialog(this, "Book id Should be 6 Characters !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.grabFocus();

        } else if (cat.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Select the Book Category !", "Warning", JOptionPane.ERROR_MESSAGE);

        } else {

            int catid = catMap.get(cat);

            try {
                MySQL.exeUpdate("INSERT INTO `booklibrary` (`ID`,`Name`,`Author`,`Date_Added`,`BookCat_ID`,`Librarian_NIC`) "
                        + "VALUES ('" + bookId + "','" + name + "','" + author + "','" + date + "','" + catid + "','" + employeeNic + "')");
                   loadTable();
                JOptionPane.showMessageDialog(this, "Succesfully Registered ! Use clear button to Clear Fields.", date, HEIGHT);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String bookid = jTextField5.getText();

        try {

            if (bookid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter your Book ID to Update!", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField5.grabFocus();

            } else {
                String name = jTextField1.getText();
                String author = jTextField2.getText();
                String cat = String.valueOf(jComboBox1.getSelectedItem());

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name is Empty !", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField1.grabFocus();

                } else if (author.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Author is Empty !", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField2.grabFocus();

                } else if (cat.equals("Select")) {
                    JOptionPane.showMessageDialog(this, "Select the Book Category !", "Warning", JOptionPane.ERROR_MESSAGE);

                } else {

                    int catid = catMap.get(cat);

                    MySQL.exeUpdate("UPDATE `booklibrary` SET `Name`='" + name + "', `Author`='" + author + "',`BookCat_ID`='" + catid + "', "
                            + " `Librarian_NIC`='" + employeeNic + "' WHERE `ID`='" + bookid + "' ");

                    jTextField5.setEditable(true);
                    jTextField3.setEditable(true);

                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                    jButton3.setEnabled(true);
                    loadTable();
                    JOptionPane.showMessageDialog(this, "Succesfully Registered ! Use clear button to Clear Fields.", "Success", JOptionPane.PLAIN_MESSAGE);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased

        String bookid = jTextField5.getText();

        try {
            ResultSet search = MySQL.exeSearch("SELECT * FROM `booklibrary` WHERE `ID` = '" + bookid + "'");
            if (search.next()) {

                jTextField1.setText(search.getString("Name"));
                jTextField2.setText(search.getString("Author"));
                jTextField3.setText(search.getString("Date_Added"));
                jComboBox1.setSelectedIndex(search.getInt("BookCat_ID"));

                jTextField5.setEditable(false);
                jTextField3.setEditable(false);

                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);

                search.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String bookid = jTextField5.getText();

        if (bookid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter your Book ID to Update!", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField5.grabFocus();
        } else {

            try {

                ResultSet searchBook = MySQL.exeSearch("SELECT * FROM `booklibrary` WHERE `ID` ='" + bookid + "'");

                if (searchBook.next()) {
                    String name = searchBook.getString("Name");
                    String author = searchBook.getString("Author");

                    int response = JOptionPane.showConfirmDialog(this, "Do you want to Remove" + name + "From" + author, "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {

                        MySQL.exeUpdate("DELETE FROM `booklibrary` WHERE `ID`='" + bookid + "'");
                        loadTable();
                        JOptionPane.showMessageDialog(this, "Successfully Removed" + name + "!", "Success", JOptionPane.PLAIN_MESSAGE);

                    }

                    searchBook.close();

                } else {
                    JOptionPane.showMessageDialog(this, "Enter your Book ID to Update!", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField5.grabFocus();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        clearFeilds();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String bookid = jTextField4.getText();

        if (bookid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter your Book ID to Update!", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();
        } else {

            try {

                ResultSet booksearch = MySQL.exeSearch("SELECT * FROM `booklibrary` WHERE `ID` = '" + bookid + "'");

                if (booksearch.next()) {
                    booksearch.close();

                    ResultSet search = MySQL.exeSearch("SELECT `section`.`Section`, `cupboard`.`Cupboard` FROM `location` "
                            + " INNER JOIN `section` ON `section`.`ID` = `location`.`Section_ID` "
                            + " INNER JOIN `cupboard` ON `cupboard`.`ID` = `location`.`Cupboard_ID` "
                            + " WHERE `location`.`BookLibrary_ID`='" + bookid + "' ");

                    if (search.next()) {

                        String sectionName = search.getString("section.Section");
                        String locationName = search.getString("cupboard.Cupboard");

                        if (!(sectionName == null)) {
                            jComboBox2.setSelectedItem(sectionName);
                            jButton8.setEnabled(false);
                            jButton9.setEnabled(false);

                        }

                        if (!(locationName == null)) {
                            jComboBox3.setSelectedItem(locationName);
                            jButton8.setEnabled(false);
                            jButton9.setEnabled(false);
                        }

                        search.close();

                    } else {
                        jComboBox2.setSelectedItem("Select");
                        jComboBox3.setSelectedItem("Select");
                        jButton7.setEnabled(true);
                        jButton8.setEnabled(true);
                        jButton9.setEnabled(true);

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Cannot find the book !", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField4.grabFocus();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String section = String.valueOf(jComboBox2.getSelectedItem());
        String cupboard = String.valueOf(jComboBox3.getSelectedItem());
        String bookid = jTextField4.getText();

        try {

            int secID;
            int cupKey;

            if (section.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Select the Section", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (!section.equals("Select") && !cupboard.equals("Select")) {

                    ResultSet search = MySQL.exeSearch("SELECT `Section_ID` FROM `location` WHERE `BookLibrary_ID` ='" + bookid + "' ");

                    if (search.next()) {
                        search.close();

                        cupKey = locationMap.get(cupboard);

                        MySQL.exeUpdate("UPDATE `location` SET `Cupboard_ID` = '" + cupKey + "' WHERE `BookLibrary_ID`='" + bookid + "' ");

                        JOptionPane.showMessageDialog(this, "Successfuly Added Cupboard !", "Success", JOptionPane.PLAIN_MESSAGE);
                    } else {

                        secID = sectionMap.get(section);
                        cupKey = locationMap.get(cupboard);

                        MySQL.exeUpdate("INSERT INTO `location` (`BookLibrary_ID`,`Section_ID`,`Cupboard_ID`) VALUES ('" + bookid + "', '" + secID + "', '" + cupKey + "' ) ");
                        JOptionPane.showMessageDialog(this, "Successfuly Added Section and Cupboard !", "Success", JOptionPane.PLAIN_MESSAGE);

                    }

                } else if (cupboard.equals("Select") && !section.equals("Select")) {

                    secID = sectionMap.get(section);

                    MySQL.exeUpdate("INSERT INTO `location` (`BookLibrary_ID`,`Section_ID`) VALUES ('" + bookid + "', '" + secID + "') ");
                    JOptionPane.showMessageDialog(this, "Successfuly Added Section !", "Success", JOptionPane.PLAIN_MESSAGE);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String bookid = jTextField4.getText();
        if (bookid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Bookid to Remove location !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();

        } else {

            try {

                ResultSet search = MySQL.exeSearch("SELECT `booklibrary`.`Name` FROM `location` INNER JOIN `booklibrary` ON `booklibrary`.`ID` = `location`.`BookLibrary_ID` "
                        + "WHERE `BookLibrary_ID` = '" + bookid + "' ");

                if (search.next()) {
                    String name = search.getString("booklibrary.Name");

                    int response = JOptionPane.showConfirmDialog(this, "Do you want to remove " + name + "!", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {

                        MySQL.exeUpdate("DELETE FROM `location` WHERE `BookLibrary_ID` = '" + bookid + "'");
                        JOptionPane.showMessageDialog(this, "Successfully Removed!", "Success", JOptionPane.PLAIN_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Book id or Already Removed !", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField4.grabFocus();
                    search.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String bookid = jTextField4.getText();
        String section = String.valueOf(jComboBox2.getSelectedItem());
        String cupboard = String.valueOf(jComboBox3.getSelectedItem());
        int secKey;
        int cupKey;

        if (bookid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Bookid to Update location !", "Warning", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();
        } else {

            try {
                ResultSet search = MySQL.exeSearch("SELECT `ID` FROM `location` WHERE `BookLibrary_ID` = '" + bookid + "'");

                if (search.next()) {
                    int id = search.getInt("ID");

                    if (!section.equals("Select") && !cupboard.equals("Select")) {

                        secKey = sectionMap.get(section);
                        cupKey = locationMap.get(cupboard);
                        MySQL.exeUpdate("UPDATE `location` SET `Section_ID`= '" + secKey + "', `Cupboard_ID` ='" + cupKey + "' WHERE `ID` = '" + id + "' ");
                        JOptionPane.showMessageDialog(this, "Successfully Updated  !", "Success", JOptionPane.PLAIN_MESSAGE);
                        search.close();

                    } else if (!section.equals("Select") && cupboard.equals("Select")) {

                        secKey = sectionMap.get(section);
                        MySQL.exeUpdate("UPDATE `location` SET `Section_ID` ='" + secKey + "' WHERE `ID`='" + id + "' ");
                        JOptionPane.showMessageDialog(this, "Successfully Updated Section !", "Success", JOptionPane.PLAIN_MESSAGE);
                        search.close();

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Cannot find the book or didnt added location !", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField4.grabFocus();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String bookid = jTextField6.getText();

        try {

            if (bookid.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Book id or Name to find the location !", "Warning", JOptionPane.ERROR_MESSAGE);
                jTextField6.grabFocus();

            } else {

                ResultSet check = MySQL.exeSearch("SELECT * FROM `booklibrary` WHERE `ID`='" + bookid + "'");
                if (check.next()) {

                    check.close();

                    ResultSet search = MySQL.exeSearch("SELECT * FROM `booklibrary` "
                            + "INNER JOIN `bookcat` ON `bookcat`.`ID` = `booklibrary`.`BookCat_ID` WHERE `booklibrary`.`ID`= '" + bookid + "'");

                    DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
                    tableModel1.setRowCount(0);

                    while (search.next()) {
                        Vector<String> vector = new Vector<>();
                        vector.add(search.getString("booklibrary.Name"));
                        vector.add(search.getString("booklibrary.Author"));
                        vector.add(search.getString("booklibrary.Date_Added"));
                        vector.add(search.getString("bookcat.CatName"));
                        vector.add(search.getString("booklibrary.Librarian_NIC"));
                        tableModel1.addRow(vector);

                    }
                    jTable1.setModel(tableModel1);
                    

                    ResultSet locationSearch = MySQL.exeSearch("SELECT `section`.`Section`, `cupboard`.`Cupboard` FROM `location`"
                            + " INNER JOIN `section` ON `section`.`ID` = `location`.`Section_ID`"
                            + " INNER JOIN `cupboard` ON `cupboard`.`ID` = `location`.`Cupboard_ID` "
                            + "  WHERE `location`.`BookLibrary_ID`= '" + bookid + "' ");
               
                    DefaultTableModel tableModel2 = (DefaultTableModel) jTable2.getModel();
                        tableModel2.setRowCount(0);

                    while (locationSearch.next()) {
                            Vector<String> locationVector = new Vector<>();
                            locationVector.add(locationSearch.getString("section.Section"));
                            locationVector.add(locationSearch.getString("cupboard.Cupboard"));
                            tableModel2.addRow(locationVector);
                    }
                     jTable2.setModel(tableModel2);
                     
                     
                     ResultSet returnSearch = MySQL.exeSearch("SELECT `returnstatus`.`Status` FROM `reserve` "
                             + "INNER JOIN `returnstatus` ON `reserve`.`ReturnStatus_ID` = `returnstatus`.`ID` "
                             + "WHERE `reserve`.`BookLibrary_ID` = '"+bookid+"'  ");
                     
                     DefaultTableModel tableModel3 = (DefaultTableModel) jTable4.getModel();
                     tableModel3.setRowCount(0);
                     
                     while(returnSearch.next()){
                         Vector<String> returnVector = new Vector<>();
                         returnVector.add(returnSearch.getString("returnstatus.Status"));
                         tableModel3.addRow(returnVector);
                     }
                     jTable4.setModel(tableModel3);
                     search.close();
                     locationSearch.close();
                     returnSearch.close();

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Book Id !", "Warning", JOptionPane.ERROR_MESSAGE);
                    jTextField6.grabFocus();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       jTextField6.setText("");
       ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
       ((DefaultTableModel) jTable2.getModel()).setRowCount(0);
       ((DefaultTableModel) jTable4.getModel()).setRowCount(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        loadTable();
    }//GEN-LAST:event_jComboBox4ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
