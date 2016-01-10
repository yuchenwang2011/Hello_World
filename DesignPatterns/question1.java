public class Logger{
   //create and store the singleton.
   private static final Logger instance = new Logger();
   private Logger(){
   //this prevents anyone else from creating this class.
   }

   public static Logger getInstance() {return instance;}
  
   public void log (String msg) {
      System.out.println(msg);
   }
}
