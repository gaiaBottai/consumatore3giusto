package esercizio;

public class Consumatore extends Thread{
    private Risorsa r;
    private boolean running;
    

    Consumatore(Risorsa r, String name) {
        super(name);
        this.r = r;
        running = true;
    }

 

    public synchronized void run() {
        String name = Thread.currentThread().getName();
        try {
            while (! running) {
               System.out.println(name +" e' in attesa di consumare la risorsa");
                /*int val = r.consuma();
                System.out.println(name + " consuma:  " + val);*/
               wait();
               
            }
            running=false;
            System.out.println(name+"Consuma la risorsa per "+(t/100)+"secondi");
            Thread.sleep(t);

        } catch (InterruptedException e) {
            /*e.printStackTrace();*/
        }
    }
    public synchronized void arresta() {
       /*running = false;*/
       String name=Thread.currentThread().getName();
       System.out.println(name +"esce dal bagno");
       running=true;
       notifyAll();
    }
}
