import java.util.LinkedList;
import java.util.Queue;

 class Producer extends Thread {
     private Queue<Integer> queue;
     private int maxSize;
     public Producer(Queue<Integer> queue, int maxSize){
         this.queue = queue;
         this.maxSize = maxSize;
     }
     int num = 0;
     @Override
     public void run() {
         while (true) {
             synchronized (queue) {
                 while (queue.size() == maxSize) {
                     try {
                         System.out .println("Producer thread waiting " );
                         queue.wait();
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
                 }
                 System.out.println("Producing value : " + num);
                 queue.add(num++);
                 queue.notifyAll();

                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

             }
         }
     }
 }

 class Consumer extends Thread {
     private Queue<Integer> queue;
     private int maxSize;
     public Consumer(Queue<Integer> queue, int maxSize){
         this.queue = queue;
         this.maxSize = maxSize;
     }
     @Override
     public void run() {
         while (true) {
             synchronized (queue) {
                 while (queue.isEmpty()) {
                     System.out.println("Consumer thread is waiting" );
                     try {
                         queue.wait();
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
                 }
                 System.out.println("Consuming value : " + queue.remove());
                 queue.notifyAll();
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
 }

public class App {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 3;
        Thread producer = new Producer(queue, maxSize);
        Thread consumer = new Consumer(queue, maxSize);
        producer.start();
        consumer.start();
    }
}
