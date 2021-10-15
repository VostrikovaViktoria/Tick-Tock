package tictak;

public class ThreadTwo implements Runnable
{
    private Thread thread;
	Monitor monitor;
    public Thread getThread () {
        return thread;
    }
    
    
    public ThreadTwo(Monitor monitor) {
        this.monitor = monitor;
        thread = new Thread (this);
      }
    
    public void run() {
        try {
        	int i = 0;
            Thread.sleep(1);                   
            while (i < TicTak.num) {    		 
        		synchronized (monitor) {  
        			if (monitor.numPotok == 1) {
            			System.out.print(2+" - ");
            			i++;
            			monitor.numPotok = 2;
            		}             		
            		monitor.notify(); 
            		if (i < TicTak.num-1) {
            			monitor.wait();
            		}                     
        		}
        		
        	}                                               
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
