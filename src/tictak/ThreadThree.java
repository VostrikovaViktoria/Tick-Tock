package tictak;

public class ThreadThree implements Runnable{
	private Thread thread;
	Monitor monitor;
    public Thread getThread () {
        return thread;
    }
    
    
    public ThreadThree (Monitor monitor) {
        this.monitor = monitor;
        thread = new Thread (this);
      }
    
    public void run() {
        try {
        	int i = 0;
        	Thread.sleep(1);
        	while (i < TicTak.num) {        		 
        		synchronized (monitor) {     
        			if (monitor.numPotok == 2) {
            			System.out.println(3);
            			i++;
            			monitor.numPotok = 3;
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
