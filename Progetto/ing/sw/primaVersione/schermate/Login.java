package Progetto.ing.sw.primaVersione.schermate;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true); // Finestra senza bordi
        setOpacity(0.97f); // Per la trasparenza

        schermataAvvio(); // Mostra la schermata iniziale
        setVisible(true);
    }

    private void schermataAvvio() {
        getContentPane().removeAll();//Pulisce la finestra così non abbiamo sovrapposizioni
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(44, 62, 80), getWidth(), getHeight(), new Color(52, 152, 219));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout()); // Centra tutto
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Spazio tra gli elementi
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel benvenuto = new JLabel("Benvenuto nel sistema");
        benvenuto.setFont(new Font("Arial", Font.BOLD, 22));
        benvenuto.setForeground(Color.WHITE);

        JButton iscriviti = createStyledButton("Iscriviti", new Color(52, 152, 219), new Color(41, 128, 185));
        JButton login = createStyledButton("Login", new Color(46, 204, 113), new Color(39, 174, 96));


        // Eventi per cambiare schermata
        login.addActionListener(e -> schermataLogin());
        iscriviti.addActionListener(e -> schermataDefault());

        panel.add(benvenuto, gbc);
        gbc.gridy++;
        panel.add(iscriviti, gbc);
        gbc.gridy++;
        panel.add(login, gbc);

        setContentPane(panel); // Imposta il nuovo pannello come contenuto principale
        revalidate(); // Ricarica il layout
        repaint(); // Ridisegna la finestra
    }

    private JButton createStyledButton(String text, Color baseColor, Color hoverColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                super.paintComponent(g);
                g2.dispose();
            }
        };

        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setBorder(BorderFactory.createLineBorder(baseColor.darker(), 3));
        button.setPreferredSize(new Dimension(200, 60)); // Bottoni più grandi
        button.setFont(new Font("Arial", Font.BOLD, 18));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(baseColor);
            }
        });

        return button;
    }

    private void schermataLogin() {
        getContentPane().removeAll(); // Pulisce la finestra
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Inserisci le credenziali:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        messageLabel = new JLabel(""); // Inizializza il messaggio

        login = createStyledButton("Accedi", new Color(46, 204, 113), new Color(39, 174, 96));
        indietro = createStyledButton("Indietro", new Color(231, 76, 60), new Color(192, 57, 43)); // Pulsante per tornare indietro


        // Evento per il login (da implementare)
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
