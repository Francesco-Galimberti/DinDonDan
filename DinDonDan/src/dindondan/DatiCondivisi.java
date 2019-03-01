/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

import java.util.concurrent.Semaphore;

public class DatiCondivisi {

    private String rintocco;

    private Semaphore sDin;
    private Semaphore sDon;
    private Semaphore sDan;

    private Semaphore sincro1;
    private Semaphore sincro2;
    private Semaphore sincro3;
    private Semaphore sincroVisualizza1;
    private Semaphore sincroVisualizza2;

    public DatiCondivisi() {
        sDin = new Semaphore(0);
        sDon = new Semaphore(0);
        sDan = new Semaphore(0);

        sincroVisualizza1 = new Semaphore(0);
        sincroVisualizza2 = new Semaphore(1);
        
        sincro1 = new Semaphore(1);
        sincro2 = new Semaphore(0);
        sincro3 = new Semaphore(0);
    }

    public void waitSincroVisualizza1() throws InterruptedException {
        sincroVisualizza1.acquire();
    }

    public void signalSincroVisualizza1() {
        sincroVisualizza1.release();
    }

    public void waitSincroVisualizza2() throws InterruptedException {
        sincroVisualizza2.acquire();
    }

    public void signalSincroVisualizza2() {
        sincroVisualizza2.release();
    }

    public void waitSincro1() throws InterruptedException {
        sincro1.acquire();
    }

    public void signalSincro1() {
        sincro1.release();
    }

    public void waitSincro2() throws InterruptedException {
        sincro2.acquire();
    }

    public void signalSincro2() {
        sincro2.release();
    }

    public void waitSincro3() throws InterruptedException {
        sincro3.acquire();
    }

    public void signalSincro3() {
        sincro3.release();
    }

    public void waitSDin() throws InterruptedException {
        sDin.acquire();
    }

    public void signalSDin() {
        sDin.release();
    }

    public void waitSDon() throws InterruptedException {
        sDon.acquire();
    }

    public void signalSDon() {
        sDon.release();
    }

    public void waitSDan() throws InterruptedException {
        sDan.acquire();
    }

    public void signalSDan() {
        sDan.release();
    }

    public synchronized void setRintocco(String x) {
        rintocco = x;
    }
    public synchronized String getRintocco() {
        return rintocco;
    }
}
