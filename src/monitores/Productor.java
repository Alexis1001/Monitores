

package monitores;

public class Productor extends Thread{
	Buffer buffer;
	
	public Productor(Buffer buffer,String name) {
	 super(name);
	 this.buffer = buffer;	
	}
	@Override
	public void run() {
		buffer.productor((int)(Math.random() * 100 ) + 1);
	}
}