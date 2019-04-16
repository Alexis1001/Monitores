/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitores;

/**
 *
 * @author PC
 */
public class Monitores {

    public static void main(String[] args) throws InterruptedException {
		Buffer buffer = new Buffer(10);
		
		for (int x=1;x<100;x++) {
			new Productor(buffer,"Pro"+x).start();
			//Thread.sleep((int)(Math.random()*100));
		}
		for (int x=1;x<100;x++) {
			new Consumidor(buffer,"Con"+x).start();
			//Thread.sleep((int)(Math.random()*100));
		}
			
        
        
        
     }
}




    



