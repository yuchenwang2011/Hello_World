A thread lets another thread to complete a task. 
The first thread needs to keep waiting for the second thread to finish its work. 
Code Example:
   Thread task = new TheTask();
   task.start();
   while (task.isAlive()) {
     ; //do nothing
   }

To solve this issue:

   class TheTask extends Thread{
     public void run(){
        synchronized (this) {
          ....//do whatever
          this.notify();
        }
     }
   }

   Thread task = new TheTask();
   synchronized(task) {
     task.start();
     try{
        task.wait();
     } catch (InterrruptedException e) {
      ...//do whatever 
     }
   }
