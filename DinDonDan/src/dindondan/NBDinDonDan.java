package dindondan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NBDinDonDan {

    /**
     * @brief Main per la gestione dei suoni.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Scanner scegli = new Scanner(System.in);
        
        try {
            System.out.println("Per iniziare premere un tasto.");           
            System.out.println("Per terminare premere un tasto.");
            
            String interruzione = "";
            while (true) {
                interruzione = console.readLine();
                if (interruzione.equals("")) {
                    break;
                }
            }
            
            DatiCondivisi dati = new DatiCondivisi();

            ThSuono th1 = new ThSuono("DIN", dati);
            ThSuono th2 = new ThSuono("DON", dati);
            ThSuono th3 = new ThSuono("DAN", dati);
            ThVisualizza tv = new ThVisualizza(dati);

            //tv.start();
            th1.start();
            th2.start();
            th3.start();

            interruzione = "";
            while (true) {
                interruzione = console.readLine();
                if (interruzione.equals("")) {
                    break;
                }
            }
            if (interruzione.equals("")) {
                th1.interrupt();
                th2.interrupt();
                th3.interrupt();
            }
            dati.waitSDin();
            dati.waitSDon();
            dati.waitSDan();
            /*
            if (ThVisualizza.currentThread().isAlive()) {
                dati.signalSincroVisualizza1();
                tv.interrupt();
            }*/

            System.out.println("Ci vediamo la prossima volta");

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(NBDinDonDan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
