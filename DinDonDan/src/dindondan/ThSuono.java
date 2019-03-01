/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

public class ThSuono extends Thread {
    
    private String suono;

    DatiCondivisi ptrDati;

    public ThSuono(String x, DatiCondivisi p) {
        suono = x;
        ptrDati = p;
    }

    public void run() {
        boolean verify = true;
        try {
            while (verify == true) {

                switch (this.suono) {
                    case "DIN":
                        ptrDati.waitSincro1();
                        continua();
                        ptrDati.signalSincro2();
                        break;
                        
                    case "DON":
                        ptrDati.waitSincro2();
                        continua();
                        ptrDati.signalSincro3();
                        break;
                        
                    case "DAN":
                        ptrDati.waitSincro3();
                        continua();
                        ptrDati.signalSincro1();
                        break;
                }

                Thread.sleep((int) (Math.random() * 10));

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        } catch (InterruptedException ex) {

        }
        switch (this.suono) {
            case "DIN":
                ptrDati.signalSDin();
                break;
            case "DON":
                ptrDati.signalSDon();
                break;
            case "DAN":
                ptrDati.signalSDan();
                break;

        }
    }

    public void continua() {
        try {
            
            ptrDati.waitSincroVisualizza2();
            ptrDati.setRintocco(suono);
            ptrDati.signalSincroVisualizza1();
            
        } catch (InterruptedException ex) {

        }
    }
}
