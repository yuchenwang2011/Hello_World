//your brain should be clear. First think about the question, there is a int buffer, a producer and a consumer.
//so you need three classes. And a main method to init them and start them.
//As in the buffer, there should be an add method and a remove method.
//As in the producer, it should be created when given a existing buffer, same as a consumer.
//producer should just add and consumer should just remove, to themselves, the method is just called run.
public class IntBuffer{
  private int index;
  private int buffer = new int[8];
  public synchronized int remove(){
    while(index == 0) {
      try{
        wait(); 
      } catch (InterruptedException e ) {
        ...//do whatever
      }
    }
    int result = buffer[index];
    index--;
    notifyAll();
    return result;
  }
  public synchronized void add(int num) {
    while(index == buffer.length-1) {
      try{
        wait(); 
      } catch(InterruptedException e) {
        ...//do whatever 
      }
    }
    buffer[index] = num;
    index++;
    NotifyAll();
  }

  public static void main(String[] args) {
    IntBuffer myBuffer = new IntBuffer();
    Producer myProducer = new Producer(myBuffer);
    Consumer myConsumer = new Consumer(myBuffer);
    myProducer.start();
    myConsumer.start();
  }
}

public class Producer{
  private IntBuffer buffer;
  public Producer(IntBuffer buffer) {
     this.buffer = buffer;
  }
  public void run() {
    Random r = new Random();
    while(true) {
      int num = r.nextInt();
      buffer.add(num);
    }
  }
}

public class Consumer{
  private IntBuffer buffer;
  public Consumer(IntBuffer buffer) {
    this.buffer = buffer;
  }
  public run() {
    while(true) {
      int num = buffer.remove(); 
    }
  }
}

