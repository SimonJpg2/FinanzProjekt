package org.example.FinanzÜbersicht.Frontend.Frames;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Backend.Database.User;
import org.example.FinanzÜbersicht.Backend.Entity.UserEntity;
import org.example.FinanzÜbersicht.Backend.Exceptions.SecurityException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static java.awt.Font.*;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.JLayeredPane.*;

/**
 * Class RegisterFrame.
 * <p>
 *     Part of GUI to register a new user.
 *     (The GUI has been created with Netbeans IDE.)
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class RegisterFrame extends JFrame {
    private final JButton jButton1;
    private final JButton jButton2;
    private final JLabel jLabel1;
    private final JLabel jLabel10;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JLabel jLabel7;
    private final JLayeredPane jLayeredPane1;
    private final JPanel jPanel1;
    private final JPasswordField jPasswordField2;
    private final JPasswordField jPasswordField3;
    private final JTextField jTextField1;
    private final JTextField username;
    private LoginFrame loginFrame;
    private final BackendController backendController;


    /**
     * Creates new form LoginFrame
     */
    public RegisterFrame(BackendController backendController) {
        this.backendController = backendController;
        System.out.println("(~) Initializing components for registration frame.");
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        username = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jPasswordField2 = new JPasswordField();
        jButton2 = new JButton();
        jLabel10 = new JLabel();
        jPasswordField3 = new JPasswordField();
        jTextField1 = new JTextField();
        jLayeredPane1 = new JLayeredPane();
        initComponents();
        System.out.println("(+) Registration frame components initialized.");
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new Color(41, 129, 186));

        jPanel1.setBackground(new Color(41, 129, 186));

        jLabel1.setFont(new Font("Arial Black", BOLD, 18)); // NOI18N
        jLabel1.setText("Login Finanzübersicht");

        jLabel2.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel2.setText("Du hast bereits einen Account?");
        jLabel2.setToolTipText("Du benötigst einen Account, um das Programm zu verwenden");

        jLabel3.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jLabel3.setText("Jetzt anmelden");

        jButton1.setBackground(new Color(41, 129, 186));
        jButton1.setFont(new Font("Arial Black", BOLD, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.setToolTipText("Wechsel zum Login");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(this::signIn);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel1)
                                .addContainerGap(82, MAX_VALUE))
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE)
                                .addComponent(jLabel3, PREFERRED_SIZE, 90, PREFERRED_SIZE)
                                .addGap(137, 137, 137))
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(57, 57, 57))
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton1, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addContainerGap(179, MAX_VALUE))
        );

        jLabel4.setFont(new Font("Arial Black", BOLD, 24)); // NOI18N
        jLabel4.setText("Registrieren");

        username.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        username.setToolTipText("Benutzername für deinen Account");

        jLabel5.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel5.setText("Benutzername");

        jLabel6.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel6.setText("Emailadresse");

        jLabel7.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel7.setText("Passwort");

        jPasswordField2.setToolTipText("Wähle ein starkes Passwort");

        jButton2.setBackground(new Color(41, 129, 186));
        jButton2.setFont(new Font("Arial Black", BOLD, 18)); // NOI18N
        jButton2.setText("Sign in");
        jButton2.setToolTipText("Zum Bestätigen drücken");
        jButton2.setFocusPainted(false);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(this::register);

        jLabel10.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel10.setText("Passwort wiederholen");

        jPasswordField3.setToolTipText("Wähle ein starkes Passwort");

        jTextField1.setFont(new Font("Arial", PLAIN, 14)); // NOI18N

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, DEFAULT_LAYER);
        jLayeredPane1.setLayer(username, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField3, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField1, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, MAX_VALUE)
                                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                        .addGroup(TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4, PREFERRED_SIZE, 250, PREFERRED_SIZE)
                                                                .addGap(205, 205, 205))
                                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(TRAILING)
                                                                                .addGroup(LEADING, jLayeredPane1Layout.createParallelGroup(TRAILING, false)
                                                                                        .addComponent(jLabel10, LEADING, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                                                        .addComponent(jPasswordField3, LEADING)
                                                                                        .addComponent(jPasswordField2, LEADING, PREFERRED_SIZE, 300, PREFERRED_SIZE))
                                                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                                                                                .addComponent(jLabel5, PREFERRED_SIZE, 155, PREFERRED_SIZE)
                                                                                                .addComponent(jLabel7, PREFERRED_SIZE, 300, PREFERRED_SIZE))
                                                                                        .addGap(89, 89, 89)))
                                                                        .addGroup(jLayeredPane1Layout.createParallelGroup(TRAILING, false)
                                                                                .addComponent(jTextField1, LEADING)
                                                                                .addComponent(jLabel6, LEADING, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                                                .addComponent(username, LEADING, DEFAULT_SIZE, 300, MAX_VALUE)))
                                                                .addContainerGap(138, MAX_VALUE))))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(jButton2, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(0, 0, MAX_VALUE))))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel5, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField2, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField3, PREFERRED_SIZE, 36, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                        .addComponent(jPanel1, TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
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
    }

    /**
     * Method register.
     * <p>
     *     Registers new user for login.
     * </p>
     * @param e {@link java.awt.ActiveEvent} of JButton.
     */
    private void register(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }
        // Variables for faster access.
        String usernameOfTextField = username.getText();
        String email = jTextField1.getText();
        String password = Arrays.toString(jPasswordField2.getPassword());

        // check if username is empty
        if (usernameOfTextField.isEmpty()) {
            username.setText("Bitte geben Sie einen Benutzernamen an.");
            return;
        }
        // check if email is empty
        if (email.isEmpty()) {
            jTextField1.setText("Bitte geben Sie eine E-Mail-Adresse an");
            return;
        }
        // check if password is empty
        if (Arrays.toString(jPasswordField2.getPassword()).isEmpty() || Arrays.toString(jPasswordField3.getPassword()).isEmpty()) {
            username.setText("Bitte geben Sie ein Passwort an.");
            return;
        }
        // check if email is valid
        if (!email.contains("@")) {
            jTextField1.setText("Bitte geben Sie eine gültige E-Mail-Adresse an.");
            return;
        }
        // double check password
        if (!password.equalsIgnoreCase(Arrays.toString(jPasswordField3.getPassword()))) {
            username.setText("Die Passwörter stimmen nicht überein.");
            return;
        }
        User service = backendController.getUserService();
        // try to create new user
        try {
            if (!service.select().isEmpty()) {
                throw new SecurityException("Es gibt bereits einen Benutzer, versuchen Sie sich stattdessen anzumelden.");
            }
            service.create(new UserEntity(usernameOfTextField, email, password));
            username.setText("Versuchen Sie sich nun anzumelden.");
        } catch (NullPointerException unused) {
            System.err.println("(!) Registering user failed because UserService is null.");
            unused.printStackTrace();
        } catch (SecurityException ex) {
            System.err.printf("(!) Registering user failed. %n%s%n", ex.getMessage());
            username.setText(ex.getMessage());
        }
    }

    /**
     * Method signIn.
     * <p>
     *     Changes current frame to sing in frame.
     * </p>
     * @param e ActionEvent of JFrame.
     */
    private void signIn(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }
        setVisible(false);
        loginFrame.setVisible(true);
    }

    public void setLoginFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }
}
