package org.example.FinanzÜbersicht.Frontend.Frames;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity;
import org.example.FinanzÜbersicht.Backend.Service.FinanzService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

/**
 * Class MainFrame.
 * <p>
 *     JFrame to display finance data.
 *     (The GUI has been created with Netbeans IDE.)
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class MainFrame extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private DefaultTableModel tableModel;
    private final BackendController backendController;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(BackendController backendController) {
        this.backendController = backendController;
        initComponents();
        appendEntities();
        System.out.println("(+) INFO: MainFrame initialized successfully.");
    }

    /**
     * Method initComponents.
     * <p>
     *     Initializes components for MainFrame.
     * </p>
     */
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JPanel jPanel2 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        JLabel jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        JLabel jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        JLabel jLabel4 = new JLabel();
        jButton2 = new JButton();
        jTextField4 = new JTextField();
        jButton3 = new JButton();
        JLabel jLabel5 = new JLabel();
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
                },
                new String [] {
                        "ID", "Datum", "Transaktionen", "Budget"
                }
        ) {
            final Class[] types = new Class [] {
                    Integer.class, String.class, Double.class, Double.class
            };
            final boolean[] canEdit = new boolean [] {
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
        jButton1.addActionListener(this::addFinanzEntity);

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
        jButton2.addActionListener(this::updateFinanzEntity);

        jTextField4.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jTextField4.setText("ID");

        jButton3.setBackground(new Color(0, 66, 118));
        jButton3.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Bestätigen");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(this::deleteFinanzEntity);

        jLabel5.setFont(new Font("Arial", BOLD, 14)); // NOI18N
        jLabel5.setText("Transaktionen sortieren");

        jComboBox1.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Alles", "Monat", "Heute"}));
        jComboBox1.addActionListener(this::comboBoxItemChanged);

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

    /**
     * Method appendEntities.
     * <p>
     *     Fills JTable with data of the database.
     * </p>
     */
    private void appendEntities() {
        // avoid NullPointerException.
        if (backendController.getFinanzService() == null) {
            System.err.println("(!) ERROR: Displaying data failed because finanzService is not initialized.");
            return;
        }

        // get references for service and entities.
        FinanzService service = backendController.getFinanzService();
        List<FinanzEntity> entities = service.select();

        // get table model and date formatter.
        tableModel = (DefaultTableModel) jTable1.getModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < entities.size(); i++) {
            // fill JTable with data.
            tableModel.addRow(new Object[]{
                    entities.get(i).getId(),
                    simpleDateFormat.format(entities.get(i).getDate()),
                    entities.get(i).getValue(),
                    entities.stream()
                            .mapToDouble(FinanzEntity::getValue)
                            .sum() // Java stream to calculate current budget.
            });
        }
    }

    /**
     * Method appendEntitiesOfMonth
     * <p>
     *     Appends data of the last month to the JTable.
     * </p>
     */

    private void appendEntitiesOfMonth() {
        // avoid NullPointerException.
        if (backendController.getFinanzService() == null) {
            System.err.println("(!) ERROR: Displaying data failed because finanzService is not initialized.");
            return;
        }

        // current Month
        int currentMonth = new Date(System.currentTimeMillis()).getMonth();

        // get references for service and entities.
        FinanzService service = backendController.getFinanzService();
        List<FinanzEntity> entitiesOfDB = service.select();

        List<FinanzEntity> entities = entitiesOfDB
                .stream()
                .filter(e -> currentMonth - e.getDate().getMonth() < 2)
                .toList(); // Java stream to filter the last month.

        // get table model and date formatter.
        tableModel = (DefaultTableModel) jTable1.getModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (FinanzEntity entity : entities) {
            // fill JTable with data.
            tableModel.addRow(new Object[]{
                    entity.getId(),
                    simpleDateFormat.format(entity.getDate()),
                    entity.getValue(),
                    entitiesOfDB.stream()
                                .mapToDouble(FinanzEntity::getValue)
                                .sum() // Java stream to calculate current budget.
            });
        }
    }

    /**
     * Method appendEntitiesOfToday.
     * <p>
     *     Appends data of today to the JTable.
     * </p>
     */
    private void appendEntitiesOfToday() {
        // avoid NullPointerException.
        if (backendController.getFinanzService() == null) {
            System.err.println("(!) ERROR: Displaying data failed because finanzService is not initialized.");
            return;
        }

        // get table model and date formatter.
        tableModel = (DefaultTableModel) jTable1.getModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // current date
        String currentDate = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        // get references for service and entities.
        FinanzService service = backendController.getFinanzService();
        List<FinanzEntity> entitiesOfDB = service.select();

        List<FinanzEntity> entities = entitiesOfDB
                .stream()
                .filter(entity -> simpleDateFormat.format(entity.getDate()).equals(currentDate))
                .toList(); // Java stream to filter current entities.

        for (FinanzEntity entity : entities) {
            // fill JTable with data.
            tableModel.addRow(new Object[]{
                    entity.getId(),
                    simpleDateFormat.format(entity.getDate()),
                    entity.getValue(),
                    entitiesOfDB.stream()
                                .mapToDouble(FinanzEntity::getValue)
                                .sum() // Java stream to calculate current budget.
            });
        }
    }

    /**
     * Method removeTableData
     *
     * <p>
     *     Deletes each row of the JTable.
     * </p>
     */
    private void removeTableData() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        if (defaultTableModel.getRowCount() > 0) {
            for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
                defaultTableModel.removeRow(i);
            }
        }
        System.out.println("(+) INFO: Table data removed");
    }

    /**
     * Method comboBoxItemChanged.
     * <p>
     *     Prints correct data on JTable.
     * </p>
     * @param e ActionEvent of JComboBox
     */
    private void comboBoxItemChanged(ActionEvent e) {
        if (e.getSource() != jComboBox1) {
            return;
        }

        String selectedItem = (String) jComboBox1.getSelectedItem();

        // Avoid NullPointerException.
        if (selectedItem == null) {
            System.err.println("(!) WARNING: Item of JComboBox not changed because item is null.");
            return;
        }

        // Check which item has been selected.
        if (selectedItem.equals("Alles")) {
            removeTableData();
            appendEntities();
            System.out.println("(+) INFO: Item of JComboBox changed to \"Alles\".");
        } else if (selectedItem.equals("Monat")) {
            removeTableData();
            appendEntitiesOfMonth();
            System.out.println("(+) INFO: Item of JComboBox changed to \"Monat\".");
        } else {
            removeTableData();
            appendEntitiesOfToday();
            System.out.println("(+) INFO: Item of JComboBox changed to \"Heute\".");
        }
        // Fire Event that data of JTable changed.
        AbstractTableModel abstractTableModel = (AbstractTableModel) jTable1.getModel();
        abstractTableModel.fireTableDataChanged();
    }

    /**
     * Method addFinanzEntity.
     *
     * <p>
     *     Method to store finanzEntity on MySQL database.
     * </p>
     * @param e ActionEvent of JButton.
     */
    private void addFinanzEntity(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }

        // create new entry on database
        try {
            double valueToAdd = Double.parseDouble(jTextField1.getText());
            backendController.getFinanzService().create(new FinanzEntity(valueToAdd));
        } catch (NumberFormatException ex) {
            jTextField1.setText("Format: 100.50");
            System.err.println("(!) WARNING: Incorrect format used.");
            return;
        }

        // Reset jComboBox to default.
        jComboBox1.setSelectedItem("Alles");
        System.out.println("(+) INFO: Entry added successfully.");
    }

    /**
     * Method updateFinanzEntity.
     * <p>
     *     updates FinanzEntity of database and refills JTable with data.
     * </p>
     * @param e ActionEvent of JButton
     */
    private void updateFinanzEntity(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }

        try {
            int id = Integer.parseInt(jTextField2.getText());
            double value = Double.parseDouble(jTextField3.getText());
            backendController.getFinanzService().update(id, new FinanzEntity(value));
        } catch (NumberFormatException ex) {
            jTextField2.setText("Format: 1");
            jTextField3.setText("Format: 100.50");
            System.err.println("(!) WARNING: Incorrect format used.");
            return;
        }

        // Reset jComboBox to default.
        jComboBox1.setSelectedItem("Alles");
        System.out.println("(+) INFO: Entry updated successfully.");
    }

    /**
     * Method deleteFinanzEntity.
     * <p>
     *     deletes FinanzEntity from database.
     * </p>
     * @param e ActionEvent of JButton.
     */
    private void deleteFinanzEntity(ActionEvent e) {
        if (e.getSource() != jButton3) {
            return;
        }

        try {
            var id = Integer.parseInt(jTextField4.getText());
            backendController.getFinanzService().delete(id);
        } catch (NumberFormatException ex) {
            jTextField4.setText("Format: 1");
            System.err.println("(!) WARNING: Incorrect format used.");
            return;
        }

        // Reset jComboBox to default.
        jComboBox1.setSelectedItem("Alles");
        System.out.println("(+) INFO: Entry deleted successfully.");
    }
}
