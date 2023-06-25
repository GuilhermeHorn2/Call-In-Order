package misc;



public class main {

	public static void main(String[] args) {
		
		Foo f = new Foo();
		
		ThreadA run_a = new ThreadA(f);
		ThreadB run_b = new ThreadB(f);
		ThreadC run_c = new ThreadC(f);
		
		Thread a = new Thread(run_a);
		Thread b = new Thread(run_b);
		Thread c = new Thread(run_c);
		
		a.start();
		b.start();
		c.start();
		
		//the terminal is cutting the start,but the sequence reapitng 1->2->3 is clear.
		
		try {
			Thread.sleep(10);//puts mains thread to sleep
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		run_a.request_stop();
		run_b.request_stop();
		run_c.request_stop();
		
		
		
		
	
}
	
	
}	
