import de.uni_potsdam.hpi.*;
import java.lang.*;

public class DequePerformance {
	public static void main(String[] args) throws Exception {
		//ArrayDeque
		ArrayDeque q = new ArrayDeque(1000);
		
		long ArrayFillTime = System.nanoTime();
		
		for (int i = 0; i <= 500; i++) 
			q.addLast("...");
		
		ArrayFillTime = System.nanoTime() - ArrayFillTime;
		
		long ArrayWorkTime = System.nanoTime();
		
		for (int i = 0; i <= 700; i++){
			q.removeLast();
			q.addLast("");
		}
		
		ArrayWorkTime = System.nanoTime() - ArrayWorkTime;
		
		//LinkedDeque
		LinkedDeque p = new LinkedDeque(1000);
		
		long LinkedFillTime = System.nanoTime();
		
		for (int i = 0; i <= 500; i++)
			p.addLast("...");
		
		LinkedFillTime = System.nanoTime() - LinkedFillTime;
		
		long LinkedWorkTime = System.nanoTime();
		
		for (int i = 0; i <= 700; i++){
			p.removeLast();
			p.addLast("");
		}
		
		LinkedWorkTime = System.nanoTime();
		
		System.out.println("Array: Fill= " + ArrayFillTime + "; Work= " + ArrayWorkTime);
		System.out.println("Linked: Fill= " + LinkedFillTime + "; Work= " + LinkedWorkTime);
	}
}