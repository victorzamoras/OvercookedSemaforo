package view;

import java.util.concurrent.Semaphore;

import controller.CozinhaController;

public class Main {

	public static void main(String[] args) {		
		final int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int id = 1; id < 6; id++) {
			Thread t = new CozinhaController(id, semaforo);
			t.start();
		}
	}
}
