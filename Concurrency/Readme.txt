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
