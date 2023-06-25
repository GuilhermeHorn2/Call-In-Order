package misc;

public class ThreadA implements Runnable{

	private Foo f;
	
	private boolean stop_requested = false;
	
	
	public synchronized void request_stop(){
		stop_requested = true;
	}
	
	public synchronized boolean is_stop_requested(){
		return stop_requested;
	}
	
	ThreadA(Foo f){
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
			if(f.get_permission(0)){
				f.first();
				f.set_permission(true,0,1);
				
				//this.request_stop();
			}
		}
		
	}

}
