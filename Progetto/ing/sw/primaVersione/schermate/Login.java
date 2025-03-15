package Progetto.ing.sw.primaVersione.schermate;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private static final String FILE_CONFIGURATORE = "configuratori.ser";
    private static final String DEFAULT_USERNAME = "user";
    private static final String DEFAULT_PASSWORD = "123";

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    private JButton iscriviti;
    private JButton login;
    private JButton indietro;

    public Login() {
        setTitle("Login Configuratore");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inizializza pulsanti
        login = new JButton("Login");
        iscriviti = new JButton("Iscriviti");
        login = new JButton("Login");
        indietro = new JButton("Indietro");

        schermataAvvio(); // Mostra la schermata iniziale
        setVisible(true);
    }

    private void schermataAvvio() {
        getContentPane().removeAll(); // Pulisce la finestra
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel benvenuto = new JLabel("Benvenuto nel sistema di configurazione");
        benvenuto.setAlignmentX(Component.CENTER_ALIGNMENT);

        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        iscriviti.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Eventi per cambiare schermata
        login.addActionListener(e -> schermataLogin());
        iscriviti.addActionListener(e -> schermataDefault());

        panel.add(Box.createVerticalStrut(20));
        panel.add(benvenuto);
        panel.add(Box.createVerticalStrut(20));
        panel.add(iscriviti);
        panel.add(Box.createVerticalStrut(10));
        panel.add(login);

        add(panel);
        revalidate();
        repaint();
    }

    private void schermataLogin() {
        getContentPane().removeAll(); // Pulisce la finestra
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Inserisci le credenziali:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        messageLabel = new JLabel(""); // Inizializza il messaggio

        // Evento per il login
        //login.addActionListener(e -> handleLogin());

        // Evento per tornare alla schermata principale
        indietro.addActionListener(e -> schermataAvvio());

        panel.add(label);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(login);
        panel.add(indietro);
        panel.add(messageLabel); // Aggiunge il messaggio

        add(panel);
        revalidate();
        repaint();
    }

    private void schermataRegistrazione(){

    }

    private void schermataDefault() {
        getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Registrazione: inserisci le credenziali di default");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        messageLabel = new JLabel("");



        // Evento per tornare indietro
        indietro.addActionListener(e -> schermataAvvio());

        panel.add(label);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(login);
        panel.add(indietro);
        panel.add(messageLabel);

        add(panel);
        revalidate();
        repaint();

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
