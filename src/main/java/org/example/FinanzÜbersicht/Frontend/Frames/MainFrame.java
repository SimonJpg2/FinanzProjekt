package org.example.FinanzÜbersicht.Frontend.Frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

public class MainFrame extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    public MainFrame() {
        initComponents();
        System.out.println("(+) MainFrame initialized successfully.");
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jLabel4 = new JLabel();
        jButton2 = new JButton();
        jTextField4 = new JTextField();
        jButton3 = new JButton();
        jLabel5 = new JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("FinanzApp");
        setPreferredSize(new Dimension(1480, 740));
        setResizable(false);

        jPanel1.setBackground(new Color(0, 66, 118));
        jPanel1.setPreferredSize(new Dimension(125, 740));

        jLabel1.setFont(new Font("Arial Black", PLAIN, 14)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Finanz-App");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(19, MAX_VALUE)
                                .addComponent(jLabel1, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addContainerGap(709, MAX_VALUE))
        );

        jPanel2.setBackground(new Color(85, 129, 163));
        jPanel2.setPreferredSize(new Dimension(1058, 540));

        // Model properties for JTable.
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "ID", "Datum", "Transaktionen", "Budget"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class, String.class, Double.class, Double.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            // Get the type of the specified column
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            // Check if the specified column should be allowed to be edited.
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        // disallow table reordering.
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jLabel2.setText("Transaktion hinzufügen");

        jTextField1.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jTextField1.setText("Betrag");

        jButton1.setBackground(new Color(0, 66, 118));
        jButton1.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Bestätigen");
        jButton1.setFocusPainted(false);

        jLabel3.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jLabel3.setText("Transaktion bearbeiten");

        jTextField2.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jTextField2.setText("ID");

        jTextField3.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jTextField3.setText("Betrag");

        jLabel4.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jLabel4.setText("Transaktion löschen");

        jButton2.setBackground(new Color(0, 66, 118));
        jButton2.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Bestätigen");
        jButton2.setFocusPainted(false);

        jTextField4.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jTextField4.setText("ID");

        jButton3.setBackground(new Color(0, 66, 118));
        jButton3.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Bestätigen");
        jButton3.setFocusPainted(false);

        jLabel5.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jLabel5.setText("Transaktionen sortieren");

        jComboBox1.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(LEADING, false)
                                        .addComponent(jLabel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jTextField1)
                                        .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jLabel3, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jTextField2)
                                        .addComponent(jTextField3)
                                        .addComponent(jLabel4, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jButton2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jTextField4)
                                        .addComponent(jButton3, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jLabel5, DEFAULT_SIZE, 290, MAX_VALUE)
                                        .addComponent(jComboBox1, 0, DEFAULT_SIZE, MAX_VALUE))
                                .addPreferredGap(RELATED, 89, MAX_VALUE)
                                .addComponent(jScrollPane1, PREFERRED_SIZE, 890, PREFERRED_SIZE)
                                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(40, MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(LEADING)
                                        .addComponent(jScrollPane1, PREFERRED_SIZE, 620, PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel2, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel3, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField3, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel4, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel5, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                .addGap(80, 80, 80))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(0, 0, MAX_VALUE)
                                .addComponent(jPanel2, PREFERRED_SIZE, 1359, PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jPanel2, PREFERRED_SIZE, 740, PREFERRED_SIZE))
                                .addGap(0, 12, MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
}
