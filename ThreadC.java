package misc;

public class ThreadC implements Runnable{

	private Foo f;

	
	private boolean stop_requested = false;
	
	
	public synchronized void request_stop(){
		stop_requested = true;
	}
	
	public synchronized boolean is_stop_requested(){
		return stop_requested;
	}
	
	ThreadC(Foo f){
		this.f = f;
		
	}
	

	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		while(!stop_requested) {
			if(f.get_permission(2)){
				f.third();
				f.set_permission(true,2,0);
				
				//this.request_stop();
			}
		}
		
	}

}
