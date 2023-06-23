package org.example.FinanzÜbersicht.Frontend.Frames;

import org.example.FinanzÜbersicht.Backend.BackendController;
import org.example.FinanzÜbersicht.Backend.Database.User;
import org.example.FinanzÜbersicht.Backend.Entity.UserEntity;
import org.example.FinanzÜbersicht.Backend.Exceptions.SecurityException;
import org.example.FinanzÜbersicht.Backend.Security.SHA256;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static java.awt.Font.*;
import static java.awt.Font.BOLD;
import static java.lang.Short.*;
import static javax.swing.GroupLayout.*;
import static javax.swing.GroupLayout.Alignment.*;
import static javax.swing.JLayeredPane.*;

/**
 * Class LoginFrame.
 * <p>
 *     Part of GUI to login.
 *     (The GUI has been created with Netbeans IDE.)
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see javax.swing.JFrame
 */
public class LoginFrame extends JFrame {
    private final JButton jButton1;
    private final JButton jButton2;
    private final JButton jButton3;
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JLabel jLabel4;
    private final JLabel jLabel5;
    private final JLabel jLabel6;
    private final JLabel jLabel7;
    private final JLayeredPane jLayeredPane1;
    private final JMenu jMenu1;
    private final JPanel jPanel1;
    private final JPasswordField jPasswordField1;
    private final JTextField username;
    private final RegisterFrame registerFrame;
    private final BackendController backendController;
    private final SHA256 sha256;

    /**
     * Constructor LoginFrame.
     * <p>
     *     Creates new form LoginFrame
     * </p>
     */
    public LoginFrame(RegisterFrame registerFrame, BackendController backendController, SHA256 sha256) {
        this.registerFrame = registerFrame;
        this.backendController = backendController;
        this.sha256 = sha256;
        System.out.println("(~) INFO: Initializing components for login frame.");
        jMenu1 = new JMenu();
        jLayeredPane1 = new JLayeredPane();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jLabel7 = new JLabel();
        jButton3 = new JButton();
        jLabel4 = new JLabel();
        username = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton2 = new JButton();
        initComponents();
        System.out.println("(+) INFO: Login frame components initialized.");
    }

    /**
     * Method initComponents.
     * <p>
     *     Initializes components for the GUI.
     * </p>
     */
    private void initComponents() {
        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sign in Finanzübersicht");

        jLayeredPane1.setBackground(new Color(41, 129, 186));

        jPanel1.setBackground(new Color(41, 129, 186));

        jLabel1.setFont(new Font("Arial Black", BOLD, 18)); // NOI18N
        jLabel1.setText("Sign in Finanzübersicht");

        jLabel2.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel2.setText("Du hast noch keinen Account?");
        jLabel2.setToolTipText("Du brauchst einen Account, um das Programm zu benutzen");

        jLabel3.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jLabel3.setText("Jetzt registrieren");

        jButton1.setBackground(new Color(41, 129, 186));
        jButton1.setFont(new Font("Arial Black", BOLD, 14)); // NOI18N
        jButton1.setText("Sign up");
        jButton1.setToolTipText("Wechsel zum Registrieren");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(this::signUp);

        jLabel7.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jLabel7.setText("Du hast deinen Benutzernamen oder dein Passwort vergessen?");

        jButton3.setBackground(new Color(41, 129, 186));
        jButton3.setFont(new Font("Arial", PLAIN, 12)); // NOI18N
        jButton3.setText("Send Email");
        jButton3.setToolTipText("Klicken, um die Daten zurückzusetzen.");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(this::sendMail);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addGroup(jPanel1Layout.createParallelGroup(TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jButton1, PREFERRED_SIZE, 223, PREFERRED_SIZE))
                                                .addGap(0, 0, MAX_VALUE))
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(23, MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                                        .addComponent(jLabel7, PREFERRED_SIZE, 365, PREFERRED_SIZE)
                                                        .addComponent(jButton3, PREFERRED_SIZE, 350, PREFERRED_SIZE))))
                                .addContainerGap())
                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(LEADING)
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, PREFERRED_SIZE, 90, PREFERRED_SIZE)
                                                .addGap(149, 149, 149))
                                        .addGroup(TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, PREFERRED_SIZE, 223, PREFERRED_SIZE)
                                                .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel7, PREFERRED_SIZE, 25, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addContainerGap(62, MAX_VALUE))
        );

        jLabel4.setFont(new Font("Arial Black", BOLD, 24)); // NOI18N
        jLabel4.setText("Anmelden");

        username.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        username.setToolTipText("Dein Benutzername");

        jLabel5.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel5.setText("Benutzername");

        jLabel6.setFont(new Font("Arial", PLAIN, 14)); // NOI18N
        jLabel6.setText("Passwort");

        jPasswordField1.setToolTipText("Dein Passwort");

        jButton2.setBackground(new Color(41, 129, 186));
        jButton2.setFont(new Font("Arial Black", BOLD, 18)); // NOI18N
        jButton2.setText("Login");
        jButton2.setToolTipText("Zum Bestätigen drücken");
        jButton2.setFocusPainted(false);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(this::login);

        jLayeredPane1.setLayer(jPanel1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, DEFAULT_LAYER);
        jLayeredPane1.setLayer(username, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPasswordField1, DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, DEFAULT_LAYER);

        GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(LEADING)
                        .addGroup(TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addComponent(jLabel5, PREFERRED_SIZE, 155, PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, PREFERRED_SIZE, 300, PREFERRED_SIZE)
                                        .addComponent(jLabel6, PREFERRED_SIZE, 90, PREFERRED_SIZE)
                                        .addGroup(TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                .addComponent(username, PREFERRED_SIZE, 300, PREFERRED_SIZE)
                                                .addGap(196, 196, 196))))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(228, 228, 228)
                                                .addComponent(jButton2, PREFERRED_SIZE, 223, PREFERRED_SIZE))
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addGap(264, 264, 264)
                                                .addComponent(jLabel4, PREFERRED_SIZE, 150, PREFERRED_SIZE)))
                                .addContainerGap(235, MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, PREFERRED_SIZE, 22, PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, PREFERRED_SIZE, 35, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, PREFERRED_SIZE, 45, PREFERRED_SIZE)
                                .addContainerGap(DEFAULT_SIZE, MAX_VALUE))
                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
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
     * Method login.
     * <p>
     *     Performs login
     * </p>
     * @param e an ActionEvent instance.
     */
    private void login(ActionEvent e) {
        if (e.getSource() != jButton2) {
            return;
        }
        // Variables for faster access.
        String usernameOfTextField = username.getText();
        String password = Arrays.toString(jPasswordField1.getPassword());

        // check if username is empty
        if (usernameOfTextField.isEmpty()) {
            username.setText("Bitte geben Sie einen Benutzernamen an.");
            System.err.println("(!) WARNING: No username available.");
            return;
        }

        //check if password is empty
        if (password.isEmpty()) {
            username.setText("Bitte geben Sie ein Passwort an.");
            System.err.println("(!) WARNING: No password available.");
            return;
        }

        User service = backendController.getUserService();

        // try to validate credentials
        try {
            if (service.select().isEmpty()) {
                throw new SecurityException("Es gibt noch keinen Benutzer, versuchen Sie einen anzulegen.");
            }
            UserEntity existingUser = service.select().get(0);
            String existingUsername = existingUser.getUsername();
            String hashedPassword = existingUser.getPassword();

            if (usernameOfTextField.equals(existingUsername) && hashedPassword.equals(sha256.hash(password))) {
                System.out.println("(~) INFO: Initializing MainFrame.");
                new MainFrame(backendController).setVisible(true);
                dispose();
                return;
            }
            System.err.println("(!) WARNING: Login failed because of wrong credentials");
            username.setText("Falsches Passwort.");
        } catch (NullPointerException unused) {
            System.err.println("(!) ERROR: Login failed because userService is null.");
        } catch (SecurityException ex) {
            System.err.printf("(!) ERROR: Login failed.%n%s%n", ex.getMessage());
            username.setText(ex.getMessage());
        }
    }

    /**
     * Method sendMail.
     * <p>
     *     Method to send email with verification code.
     * </p>
     * @param e ActionEvent of JButton.
     */
    private void sendMail(ActionEvent e) {
        System.out.println("(~) INFO: Initializing VerificationFrame.");
        new VerificationFrame(backendController.getUserService(), sha256).setVisible(true);
        System.out.println("(+) INFO: VerificationFrame initialized successfully.");
    }

    /**
     * Method signUp.
     * <p>
     *     Changes current frame to sing up frame.
     * </p>
     * @param e ActionEvent of JFrame.
     */
    private void signUp(ActionEvent e) {
        if (e.getSource() != jButton1) {
            return;
        }
        setVisible(false);
        registerFrame.setVisible(true);
    }
}