
public class Run{
	

	public static class aaa extends Thread{
		public void run(){
			Window.main(null);
		}
	}
	
	public static class bbb extends Thread{
		public void run(){
			osuHandSpeedTester.main(null);
		}
	}
	public static void main(String[] args) {
		aaa a = new aaa();
		Thread t1 = new Thread(a);
		t1.start();
		

	}
	
	public static void mainr(){
		bbb b = new bbb();
		Thread t2 = new Thread(b);
		t2.start();
	}
	
}


