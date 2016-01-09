In Java a synchronized method such as:

synchronized void someMethod(){ 
   .... // the code to protect
}

is exactly equivalent to:

void someMethod(){ 
  synchronized( this ){
    .... // the code to protect 
  }
}

question
1: Busy Waiting: Explain the term “busy waiting” and how it can be avoided.
2: Producer/Consumer: Write a Producer thread and a Consumer thread that share a fixed- size buffer 
and an index to access the buffer. The Producer should place numbers into the buffer, 
and the Consumer should remove the numbers. 
The order in which the numbers are added or removed is not important.
