package org.example.FinanzÜbersicht.Frontend.Frames;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Backend.Entity.UserEntity;
import org.example.FinanzÜbersicht.Backend.Security.BadCharacters;
import org.example.FinanzÜbersicht.Backend.Service.UserService;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.JLayeredPane.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static org.example.FinanzÜbersicht.Backend.Security.BadCharacters.*;

public class ResetFrame extends JFrame {
    private JButton jButton1;
    private JLabel jLabel4;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private final UserService userService;

    public ResetFrame(UserService userService) {
        this.userService = userService;
        initComponents();
        System.out.println("(+) ResetFrame initialized successfully.");
    }

    /**
     * Method initComponents.
     *
     * <p>
     *     Initializes swing and awt components.
     * </p>
     */

    private void initComponents() {
        JLayeredPane jLayeredPane1 = new JLayeredPane();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        jButton1 = new JButton();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();
        jLabel4 = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new Color(41, 129, 186));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGap(0, 100, MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGap(0, 0, MAX_VALUE)
        );

        jLabel1.setFont(new Font("Arial Black", BOLD, 18)); // NOI18N
        jLabel1.setText("Wiederherstellung");

        jLabel2.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel2.setText("Passwort");

        jLabel3.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel3.setText("Passwort wiederholen");

        jButton1.setFont(new Font("Arial Black", PLAIN, 12)); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(this::changePassword);

        jLabel4.setFont(new Font("Arial", BOLD, 12)); // NOI18N

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING, false)
                                                .addComponent(jLabel2, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(jLabel3, DEFAULT_SIZE, 280, MAX_VALUE)
                                                .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(jLabel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(jPasswordField1)
                                                .addComponent(jPasswordField2))
                                        .addComponent(jLabel4, PREFERRED_SIZE, 80, PREFERRED_SIZE))
                                .addGap(0, 51, MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel4, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jLabel2, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jPasswordField1, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, PREFERRED_SIZE, 24, PREFERRED_SIZE)
                                .addPreferredGap(RELATED)
                                .addComponent(jPasswordField2, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                .addGap(12, 12, 12))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addComponent(jLayeredPane1)
        );

        pack();
        setLocationRelativeTo(null);
        setTitle("Passwort zurücksetzen");
    }

    /**
     * Method changePassword.
     *
     * <p>
     *     Method to change password of the account from the client.
     * </p>
     * @param e ActionEvent triggered by JButton.
     *
     */
    private void changePassword(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }
        String password1 = new String(jPasswordField1.getPassword());
        String password2 = new String(jPasswordField2.getPassword());

        // check for SQL Injection.
        for (String s : FORBIDDEN) {
            if (password1.contains(s) || password2.contains(s)) {
                jLabel4.setText("Failed");
                System.err.println("(!) Reset password failed, chars of password could lead to SQL-I.");
                return;
            }
        }

        // check if password is given by the client
        if (password1.isEmpty()) {
            jLabel4.setText("Passwort angeben.");
            System.err.println("(!) Reset password failed because no new password was set.");
            return;
        }

        if (!password1.equals(password2)) {
            jLabel4.setText("Passwörter ungleich.");
            System.err.println("(!) Reset password failed because passwords aren't equal");
            return;
        }
        List<UserEntity> users = userService.select();
        UserEntity userToUpdate = users.get(0);

        userService.updateById(userToUpdate.getId(),
                new UserEntity(
                        userToUpdate.getUsername(),
                        userToUpdate.getEmail(),
                        new String(jPasswordField1.getPassword())
                ));
        jLabel4.setText("Success");
    }
}
