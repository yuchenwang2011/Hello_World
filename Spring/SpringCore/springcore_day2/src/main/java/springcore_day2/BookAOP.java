package springcore_day2;

import org.aspectj.lang.ProceedingJoinPoint;

public class BookAOP {
	public void printBefore() {
		System.out.println("Print before info");
	}
	
	public void printAfter() {
		System.out.println("Print after info");
	}
	
	public void printAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("=======Around start=========");
		System.out.println("PrintAround, before");
		jp.proceed();
		System.out.println("PrintAround, after");
		System.out.println("=======Around after=========");
	}
}
