Interfaces specify only what the class is doing, not how it is doing it.
The problem with multiple inheritance is that two classes may define different ways 
of doing the same thing, and the subclass can't choose which one to pick.

Suppose I have one class, which is a Toaster, and another class, which is NuclearBomb. 
They both might have a "darkness" setting. They both have an on() method. (One has an off(), 
the other doesn't.) If I want to create a class that's a subclass of both of these...
as you can see, this is a problem that could really blow up in my face here.
