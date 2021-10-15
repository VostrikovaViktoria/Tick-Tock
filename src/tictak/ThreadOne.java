package tictak;

public class ThreadOne extends Thread {
	Monitor monitor;
    
	public ThreadOne(Monitor monitor) {
	    this.monitor = monitor;
	  }


	public void run () {
        try 
        {      
        	int i = 0;
        	monitor.numPotok = 3;
        	while (i < TicTak.num) {   		
                synchronized (monitor) {               	
                	 if (monitor.numPotok == 3) {
                     	System.out.print(1+" - ");  
                     	i++;
                     	monitor.numPotok = 1;
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
