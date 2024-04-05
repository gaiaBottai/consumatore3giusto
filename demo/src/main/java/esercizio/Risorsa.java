package esercizio;



public class Risorsa {
    private int val;
   

    public synchronized void produci(int val) {
        this.val = val;
    }

    public int consuma() {
        return this.val;
    }

    
}
