import gui.MainFrame;
import controller.Controller;

public class Main {
    public static void main(String[] args) {
        // Creiamo il controller
        Controller controller = new Controller();

        // Passiamo il controller alla finestra
        MainFrame finestra = new MainFrame(controller);

        // Rendiamo visibile l'interfaccia
        finestra.setVisible(true);
    }
}