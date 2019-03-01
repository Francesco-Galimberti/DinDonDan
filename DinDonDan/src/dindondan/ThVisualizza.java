package dindondan;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThVisualizza extends Thread {

    private DatiCondivisi ptrDati;

    public ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        try {
            while (true) {

                ptrDati.waitSincroVisualizza1();

                ptrDati.getRintocco();
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                ptrDati.signalSincroVisualizza2();

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
