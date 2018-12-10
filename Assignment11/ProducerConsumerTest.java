package assignment11;

public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		
	Item item = new Item();
	      Producer p1 = new Producer(item, 1);
	      Consumer c1 = new Consumer(item, 1);
	p1.start(); 
	c1.start();
	
	   }
}
