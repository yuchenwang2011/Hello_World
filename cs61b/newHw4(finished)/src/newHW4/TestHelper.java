package newHW4;

public class TestHelper {
	  static void verify(boolean invariant, String message) {
		    if (!invariant) {
		      System.out.println("*** ERROR:  " + message);
		      Thread.dumpStack();
		    }
		  }
}
