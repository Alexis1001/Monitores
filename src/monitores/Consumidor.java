

package monitores;


public class Consumidor extends Thread {
	Buffer buffer;
	
	public Consumidor(Buffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}
	
	@Override
	public void run()  {
		buffer.consumidor();
		
	}
}