/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

import java.util.concurrent.ThreadLocalRandom;

public class ThSuono extends Thread {

    private int scelta;
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

                //ptrDati.waitSincroVisualizza2();
                
                switch (this.suono) {
                    case "DIN":
                        ptrDati.waitSincro1();
                        //ptrDati.setRintocco(suono);
                        System.out.println(suono);
                        ptrDati.signalSincro2();
                        break;
                    case "DON":
                        ptrDati.waitSincro2();
                        //ptrDati.setRintocco(suono);
                        System.out.println(suono);
                        ptrDati.signalSincro3();
                        break;
                    case "DAN":
                        ptrDati.waitSincro3();
                        //ptrDati.setRintocco(suono);
                        System.out.println(suono);
                        ptrDati.signalSincro1();
                        break;
                }
                
                //ptrDati.signalSincroVisualizza1();

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
}
