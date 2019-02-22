/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Princess Joy Padua
 *
 * @brief Classe per la gestione dei suoni
 *
 *
 */
public class ThSuono extends Thread {

    /**
     * Dichiaro una variabile di tipo int che servirà a scegliere se attivare
     * solo lo sleep oppure sleep+yield.
     *
     */
    private int scelta;
    /**
     * Dichiaro variabile di tipo String che decide quale suono eseguire.
     */
    private String suono;

    /**
     * Creo classe di tipo DatiCondivi che va a contare i suoni effettuati.
     */
    DatiCondivisi ptrdati;

    /**
     * @param p
     * @brief Costruttore con parametri
     *
     * @param x Gli passo il suo da eseguire
     * @param y Scelta opzione
     */
    public ThSuono(String x, DatiCondivisi p) {
        suono = x;
        ptrdati = p;
    }

    /**
     * @brief Metodo per eseguire l'istruzione.
     *
     */
    public void run() {
        boolean verify = true;
        try {
            while (verify == true) {
                ptrdati.aggiungi(suono);
                if (suono.equals("DIN")) {
                    ptrdati.setContaDIN(ptrdati.getContaDIN() + 1);
                }
                if (suono.equals("DON")) {
                    ptrdati.setContaDON(ptrdati.getContaDON() + 1);
                }
                if (suono.equals("DAN")) {
                    ptrdati.setContaDAN(ptrdati.getContaDAN() + 1);
                }

                int min = 100;
                int max = 1000;
                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                sleep(randomNum);

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        } catch (InterruptedException ex) {

        }

        switch (this.suono) {
            case "DIN":
                ptrdati.sDinSignal();
                break;
            case "DON":
                ptrdati.sDonSignal();
                break;
            case "DAN":
                ptrdati.sDanSignal();
                break;

        }
    }
}
