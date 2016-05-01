package Thead_Synchronized;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Produce_Consumer_Wait_Nofiy {
      
	public static void main(String[] args){
		Vector theQueue = new Vector();
		int size = 5;
		Thread produce_Thread = new Thread(new Producer(theQueue, size), "Producer");
		Thread consumer_Thread = new Thread(new Consumer(theQueue, size), "Consumer");
		produce_Thread.start();
		consumer_Thread.start();
	}
}
	
	class Producer implements Runnable{
        
		private final Vector theQueue;
		private final int size;
		
		public Producer(Vector queue, int size){
			theQueue = queue;
			this.size = size;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 0; i < 9; i++){
				System.out.println(theQueue + "number of" + i);
			
			try{
				producer(i);
			}catch (InterruptedException ex){
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, "some errors", ex);
			}
		}
		}
		
		private void producer(int i) throws InterruptedException{
			while(theQueue.size() == size){
				synchronized (theQueue){
					System.out.println("theQueue is fully filled" + Thread.currentThread().getName() + "is waiting for lock released" + theQueue.size());;
				    theQueue.wait();
				}
			}
			
			synchronized (theQueue){
				theQueue.add(i);
				theQueue.notifyAll();
			}
		}
	}
		
		class Consumer implements Runnable {
            
			private final Vector theQueue;
			private final int size;
			
			public Consumer(Vector theQueue, int size){
				this.theQueue = theQueue;
				this.size = size;
			}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try{
						System.out.println("Consumer is activing with ID :" + consumer());
					}catch(InterruptedException ex) {
						Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, "Interupted", ex);
					}
				}
			}
			
			private int consumer() throws InterruptedException{
				
					  while(theQueue.isEmpty()){
						  synchronized(theQueue){
							  System.out.println("System is empty, " + Thread.currentThread().getName() + "is waiting for new task, size is :" + size);
					          theQueue.wait();
						  }
				}
					  synchronized (theQueue){
						  theQueue.notifyAll();
						  return (Integer) theQueue.remove(0);
					  }
			}
			
		}
		
	

