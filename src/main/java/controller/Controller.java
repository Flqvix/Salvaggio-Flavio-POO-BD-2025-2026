package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Cliente> listaClienti;
    private List<Istruttore> listaIstruttori;

    public Controller() {
        this.listaClienti = new ArrayList<>();
        this.listaIstruttori = new ArrayList<>();
        // Inseriamo un cliente finto
        creaDatiDiProva();
    }

    private void creaDatiDiProva() {
        Cliente c1 = new Cliente("Flavio", "Salvaggio", "f.salvaggio@studenti.unina.it", "FLSALA09A06N5B1A", 1.80, 70.5, LocalDate.of(2027, 12, 31));
        listaClienti.add(c1);
    }

    // METODI PER LA GUI

    // 1. Restituisce tutti i clienti
    public List<Cliente> getListaClienti() {
        return listaClienti;
    }

    // 2. Metodo per registrare un nuovo cliente dalla GUI
    public void registraNuovoCliente(String nome, String cognome, String email, String cf, double altezza, double peso, LocalDate scadenza) {
        Cliente nuovoCliente = new Cliente(nome, cognome, email, cf, altezza, peso, scadenza);
        listaClienti.add(nuovoCliente);
        System.out.println("Cliente " + nome + " " + cognome + " registrato con successo nel sistema FitProgress!");
    }

    // METODI DI BUSINESS E CONTROLLO VINCOLI

    public void eseguiRegistrazioneSessione(Cliente cliente, SchedaAllenamento scheda, LocalDate dataEsecuzione, int durataMinuti) {
        // Vincolo 1: Il cliente deve avere un certificato medico valido
        if (LocalDate.now().isAfter(cliente.getScadenzaCertificatoMedico())) {
            System.out.println("Accesso negato: Certificato medico scaduto. Rinnova il certificato per poter registrare nuove sessioni di allenamento.");
            return; // Il controller blocca l'operazione
        }

        // Vincolo 2: La data di esecuzione della sessione non può essere precedente alla data di creazione della scheda
        if (dataEsecuzione.isBefore(scheda.getDataCreazione())) {
            System.out.println("Errore: Impossibile registrare una sessione eseguita prima della creazione della scheda.");
            return;
        }

        SessioneAllenamento nuovaSessione = new SessioneAllenamento(dataEsecuzione, durataMinuti, scheda);
        cliente.registraSessione(nuovaSessione);
        System.out.println("Sessione registrata con successo.");
    }

    public void aggiungiRisultatoEsercizio(SessioneAllenamento sessione, Esercizio esercizio, double carico, int serie, int ripetizioni) {
        // Vincolo 3: Carichi negativi o ripetizioni a zero non consentiti
        if (carico < 0 || serie <= 0 || ripetizioni <= 0) {
            System.out.println("Errore di inserimento: Carichi negativi o ripetizioni a zero non consentiti.");
            return;
        }

        RisultatoEsercizio risultato = new RisultatoEsercizio(carico, serie, ripetizioni, esercizio);
        sessione.aggiungiRisultato(risultato);
        System.out.println("Risultato dell'esercizio validato e aggiunto alla sessione.");
    }

    // Metodo ponte per l'interfaccia grafica
    public void salvaSchedaDaGUI(String nomeEsercizio, int serie, int ripetizioni, double carico) {
        // Per ora simula l'inserimento dei dati e la creazione di un risultato di esercizio
        System.out.println("Dati ricevuti dalla GUI: " + nomeEsercizio + " " + serie + "x" + ripetizioni + " " + carico + "kg");
    }
}