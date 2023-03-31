public class Exercise2405 {
	public static void main(String[] args) {
		// Create a queue
		GenericQueue<String> queue = new GenericQueue<>();
		
		// Add elements to the queue
		queue.enqueue("Tom"); // Add it to the queue
		System.out.println("(1) " + queue);
		
		queue.enqueue("Susan"); // Add it to the queue
		System.out.println("(2) " + queue);
		
		queue.enqueue("Kim"); // Add it to the queue
		queue.enqueue("Michael"); // Add it to the queue
		System.out.println("(3) " + queue);
		
		// Remove elements from the queue
		System.out.println("(4) " + queue.dequeue());
		System.out.println("(5) " + queue.dequeue());
		System.out.println("(6) " + queue);
	}
}


class GenericQueue<E> extends java.util.LinkedList<E> {

	public void enqueue(E e) {
		addLast(e);
	}

	public E dequeue() {
		return removeFirst();
	}

	public int getSize() {
		return size();
	}
}