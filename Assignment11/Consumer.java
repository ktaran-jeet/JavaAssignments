package assignment11;

class Consumer extends Thread {
	private Item item;
	private int number;
	
	public Consumer(Item c, int number) {
	item = c;
	this.number = number;
	   }
	//Override run method to call get method of item class to consume an item
	public void run() {
	int value = 0;
	for (int i = 0; i< 10; i++) {
			value = item.get();
	         System.out.println("Consumer " + this.number + " Consumed item: " + value);
	      }
	   }
}
