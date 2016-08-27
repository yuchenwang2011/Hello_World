1. Singleton Mode: 
    Singleton's purpose is to control object creation, limiting the number of obejcts to one only. 
    public class ClassicSingleton{
        private static ClassicSingleton instance = null;
        private ClassicStingleton{
            //private constructor to prevent instantiation
        }
        public static ClassicSingleton getInstance(){
            if(instance == null) {
                instance = new ClassicSingleton();
            }
            return instance;
        }
    }
    There is another easy way to implement singleton, using enum
    public enum EasySingleton{
        instance;
    }
    You can use EasySingleton.instance to use it.
    
2. Simple Factory Mode: 
    Before industrial revolution, when you need a BMW, you need to new one by yourself. After industrial revolution, 
    there are factories, so when you want a BMW, you let factory new it and return it to you. 
    
3. Factory Method mode: 
    It's more advanced. That every method is a factory. There are BMW 323, 325, 328. You can't make all of them in 
    one factory, so you have many BWM factories, the 323 factory, 325 factory and 328 factory. 
    Each news a BWM and return to you. But you need an abstract class "BMW Factory"

4. Template Pattern
public abstract class Game {
   abstract void initialize();
   abstract void startPlay();
   abstract void endPlay();

   public final void play(){    //the final here is necessary for the template not to be overriden,
      initialize();
      startPlay();
      endPlay();
   }
}

5. Command mode: 
    (command is an object) this example written by myself
    public abstract class Shape{}
    public class Circle extends Shape(){
      public void move(){}
      public void moveback(){}
    }
    public abstract class Command(){
      public void execute();
    }
    public class Move implements Command{
      private Shape s;
      public Move(Shape shape){
        this.s = shape;
      }
      public void move(){
        s.move();
      }
      public void unmove(){
        s.unmove();
      }
    }
    public class Canvas{
      Circle c = new Circle();
      Command m = new Move(c);
      m.execute();
      m.unexecute();
    }
