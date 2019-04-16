

package monitores;



public class Buffer {
	private int[] buffer;
	private int numeroElementos;
	private int elementosLlenos;
	private int elementosVacios;
	
	public Buffer() {}
	
	public Buffer(int elementos) {
		numeroElementos = elementos;
		elementosLlenos = 0;
		elementosVacios = numeroElementos;
		buffer = new int[numeroElementos];

	}
	
	public synchronized void productor(int valor) {
		int indice = 0;
		
		while (elementosVacios == 0)// si ya no hay elementos vacios para seguir produciendo
			try {
                         System.out.println("productor bloqueado");   
		         wait();
			} catch(Exception e) {;}
		System.out.println(Thread.currentThread().getName());
		while (buffer[indice] != 0)
			indice++;
		buffer[indice] = valor;
		elementosVacios--; 
		elementosLlenos++; 
		notifyAll();
	}
	
	public synchronized void consumidor() {
		int indice = 0;
		
		while (elementosLlenos == 0) // si  ya no hay elementos que consumir  se bloquea
			try {
                            System.out.println("bloqueando consumidor");
		            wait();
			} catch(Exception e) {;}
		System.out.println(Thread.currentThread().getName());

		while (buffer[indice] == 0)
			indice++;
		buffer[indice] = 0;
		elementosVacios++;
		elementosLlenos--;
		notifyAll();
	}
}
