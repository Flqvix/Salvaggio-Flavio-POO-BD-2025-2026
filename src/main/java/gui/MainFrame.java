package gui;

import controller.Controller;
import model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JTextField txtNome;
    private JButton btnAggiungi;
    private JTextField txtCognome;
    private JTextField txtCF;
    private JTextField txtEmail;
    private JTable tabellaClienti;
    private JTextField txtEsercizio;
    private JSpinner spinSerie;
    private JSpinner spinRipetizioni;
    private JTextField txtCarico;
    private JButton btnSalva;
    private JTextArea txtAreaLog;
    private JTextField txtCertificato;

    private DefaultTableModel tableModel;
    private Controller controller;

    public MainFrame(Controller controller) {
        this.controller = controller;

        initUI();

        // INIZIALIZZAZIONE TABELLA
        String[] colonne = {"Nome", "Cognome", "Email", "Codice Fiscale", "Scadenza Cert."};
        tableModel = new DefaultTableModel(colonne, 0);
        tabellaClienti.setModel(tableModel);

        // Carica i dati finti creati nel controller (compreso il certificato) e mostra tutto nella tabella
        aggiornaTabella();

        // REGISTRAZIONE CLIENTE
        btnAggiungi.addActionListener(e -> {
            String nome = txtNome.getText();
            String cognome = txtCognome.getText();
            String cf = txtCF.getText();
            String email = txtEmail.getText();
            String dataCertificatoStr = txtCertificato.getText(); // <-- Adesso legge il campo vero!

            // Controllo base
            if (nome.trim().isEmpty() || cognome.trim().isEmpty() || dataCertificatoStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Errore: Nome, Cognome e Data Certificato sono obbligatori.", "Dati mancanti", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Trasforma il testo in una data vera e propria. Se l'utente scrive male da errore.
            java.time.LocalDate scadenzaCertificato;
            try {
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                scadenzaCertificato = java.time.LocalDate.parse(dataCertificatoStr, formatter);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Formato data errato! Usa: gg/mm/aaaa (es: 25/10/2026)", "Errore Data", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Valori di default per i parametri fisici mancanti nell'interfaccia
            double altezzaDefault = 1.75;
            double pesoDefault = 70.0;

            controller.registraNuovoCliente(nome, cognome, email, cf, altezzaDefault, pesoDefault, scadenzaCertificato);

            aggiornaTabella();

            JOptionPane.showMessageDialog(this, "Cliente " + nome + " registrato con successo!");

            // Svuota tutti i campi, incluso il certificato
            txtNome.setText("");
            txtCognome.setText("");
            txtCF.setText("");
            txtEmail.setText("");
            txtCertificato.setText("");
        });

        // AREA ALLENAMENTO
        btnSalva.addActionListener(e -> {
            try {
                String esercizio = txtEsercizio.getText();
                int serie = (int) spinSerie.getValue();
                int ripetizioni = (int) spinRipetizioni.getValue();
                double carico = Double.parseDouble(txtCarico.getText());

                controller.salvaSchedaDaGUI(esercizio, serie, ripetizioni, carico);
                txtAreaLog.append("-> Salvato: " + esercizio + " | " + serie + "x" + ripetizioni + " con " + carico + "kg\n");

                txtEsercizio.setText("");
                txtCarico.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Inserisci un numero valido per il carico (es: 20.5)", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // METODO PER RICARICARE LA TABELLA
    private void aggiornaTabella() {
        tableModel.setRowCount(0);

        List<Cliente> lista = controller.getListaClienti();

        for (Cliente c : lista) {
            Object[] riga = {
                    c.getNome(),
                    c.getCognome(),
                    c.getEmail(),
                    c.getCodiceFiscale(),
                    c.getScadenzaCertificatoMedico()
            };
            tableModel.addRow(riga);
        }
    }

    // METODO DEDICATO ALL'ESTETICA DELLA FINESTRA
    private void initUI() {
        setTitle("Gestione FitProgress");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Imposta l'icona pescando dalla cartella resources
        java.net.URL imgURL = getClass().getResource("/icona.png");
        if (imgURL != null) {
            ImageIcon iconaProgramma = new ImageIcon(imgURL);
            setIconImage(iconaProgramma.getImage());
        } else {
            System.err.println("Attenzione: File icona.png non trovato nella cartella resources.");
        }

        // IMPOSTA LA GRANDEZZA DELLA FINESTRA (Larghezza, Altezza)
        setSize(1100, 600);

        setLocationRelativeTo(null);
    }
}