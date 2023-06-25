package misc;

public class Foo {
	
	private boolean[] permission = {true,false,false};
	
	public synchronized void set_permission(boolean setter,int i,int j){
		
		//i is the thread that is calling this method and j is the next allowed thread
		
		permission[i] = false;
		permission[j] = setter;
	}
	
	public boolean get_permission(int i) {
		return permission[i];
	}
	
	
	public void first(){
		System.out.println("--1--");
	}
	public void second(){
		System.out.println("--2--");
	}
	public void third() {
		System.out.println("--3--");
	}

}
