package dindondan;

public class ThVisualizza extends Thread {

    private DatiCondivisi ptrDati;

    public ThVisualizza(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        try {
            while (true) {

                ptrDati.waitSincroVisualizza1();
                
                System.out.println(ptrDati.getRintocco());                
                if(ptrDati.getRintocco().equals("DAN")){
                    System.out.println();
                }
                
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                ptrDati.signalSincroVisualizza2();

            }
        } catch (InterruptedException ex) {
            
        }
    }
}
