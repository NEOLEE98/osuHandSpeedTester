import javax.swing.JOptionPane;

public class osuHandSpeedTester {

	public static void main(String args) 
	{
		int time=Integer.valueOf(Window.t1.getText()).intValue();
		
		
		Window.o1("Hit z and x as fast as possible in "+time+" seconds!");
		
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		for(int cd=5;cd>0;cd--)
		{
			Window.o1(cd+" sec before start"); 
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		Window.o1("START!!");
		Window.t2.setText("");
		Window.t2.setEditable(true);
		
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Window.t2.setEditable(false);

		
		
		String zx=Window.t2.getText();
		if (zx.length()==0){
			dio("No input");
			Window.rst();
			return;
		}
		int fchk=0;
		while(fchk<zx.length())
		{
			if(zx.charAt(fchk)=='z'||zx.charAt(fchk)=='x')
			{
				fchk++;
			}
			else
			{
				dio("Your input is invalid!");
				Window.rst();
				return;
			}
		}
			if (zx.charAt(0)=='z')
			{
				int schk=1;
				for (;schk<zx.length();)
				{
					if(zx.charAt(schk)=='x')
					{
						schk++;
					}
					else
					{
						dio("Your input is unstable and will cause misses!");
						dio("You are able to deal with long stream combos at "+calc(zx.length(),time,"Unstable")+"BPM!");
						Window.rst();
						return;
					}
					if(schk<zx.length())
					{
						if(zx.charAt(schk)=='z')
						{
							schk++;
						}
						else
						{
							dio("Your input is unstable and will cause misses!");
							dio("You are able to deal with long stream combos at "+calc(zx.length(),time,"Unstable")+"BPM!");
							Window.rst();
							return;
						}
					}
				}
			}
			else if (zx.charAt(0)=='x')
			{
				int tchk=1;
				for (;tchk<zx.length();)
				{
					if(zx.charAt(tchk)=='z')
					{
						tchk++;
					}
					else
					{
						dio("Your input is unstable and will cause misses!");
						dio("You are able to deal with long stream combos at "+calc(zx.length(),time,"Unstable")+"BPM!");
						Window.rst();
						return;
					}
					if(tchk<zx.length())
					{
						if(zx.charAt(tchk)=='x')
						{
							tchk++;
						}
						else
						{
							dio("Your input is unstable and will cause misses!");
							dio("You are able to deal with long stream combos at "+calc(zx.length(),time,"Unstable")+"BPM!");
							Window.rst();
							return;
						}
					}
				}
			}
		dio("You are able to deal with long stream combos at "+calc(zx.length(),time)+"BPM!");
		Window.rst();
		return;
	}

	
	
	private static double calc(double length,int time,String unstable) 
	{
		double BPM=length/time*60/4*0.9;
		return BPM;
	}
	
	private static double calc(double length,int time) 
	{
		double BPM=length/time*60/4;
		return BPM;
	}

	private static void dio(String a){
		JOptionPane.showMessageDialog(null, a,"System",JOptionPane.PLAIN_MESSAGE);
	}
}
