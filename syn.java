
class callme{
	 synchronized public void call(String msg){
		System.out.print("[ "+msg);
	try{
		Thread.sleep(1000);
		System.out.println("]");
		
	}
	catch(Exception e){
		System.out.println("exception1");
	}
	}
}

class call1 implements Runnable{
	Thread t;
	Thread t1;
	callme obj;
	String s;
	call1(callme o,String str)
	{
		obj=o;
		s=str;
		t=new Thread(this);
		t1=new Thread(this);
		t.start();
		t1.start();
	}
	public void run()
	{
		obj.call(s);
	}
}


public class syn {

	
	public static void main(String[] args) {
		
		callme obj=new callme();
		call1 obj1=new call1(obj,"hello");
		call1 obj2=new call1(obj,"synchronised");
		call1 obj3=new call1(obj,"world");
		try{
			obj1.t.join();
			
			
			obj2.t.join();
			
			obj3.t.join();
			
			
		}
		catch(Exception e){
		
		}
	}

}
