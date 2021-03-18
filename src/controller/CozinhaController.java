package controller;

import java.util.concurrent.Semaphore;

public class CozinhaController extends Thread{

	private int sopat;
	private int lasat;
	private int id;
	private Semaphore semaforo;
	private int tempo;
	private String comida;
	public CozinhaController(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
}
	@Override
	public void run() {
	cozimento();
	try {
		semaforo.acquire();
		System.out.println("O prato "+ id+" "+ comida + " foi entregue");
		sleep(500);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}finally{
		semaforo.release();
	}
	
}
	public void cozimento() {
			if (id %2 == 1) {
				tempo = (int) (Math.random()* 300 + 500);
				comida = "Sopa de Cebola";
				int t = tempo/100;
				System.out.println("O prato "+ id+" é uma "+ comida + " e será feita em 0." + t + " segundos");
						while (sopat <100) {
							try {
								sleep(100);
							sopat += tempo/100;
							System.out.println("O prato "+id+": "+ comida +  " está " + sopat + "% concluída");
							if (sopat > 90) {
								System.out.println("O prato " + id +  " está concluído");
								break;
							}
						}catch (InterruptedException e) {
							e.printStackTrace();
						}
						}
					}else {
						tempo = (int) (Math.random()* 600 + 600);
						comida = "Lasanha";
						double t = tempo/100;
						System.out.println("O prato "+ id+" é uma "+ comida + " e será feita em " + t/10 + " segundos");
						while (lasat <100) {
							try {
							sleep(100);
							lasat += tempo/100;
							System.out.println("O prato "+id+": "+ comida + " está " + lasat + "% concluída");
							if (lasat > 90) {
								System.out.println("O prato " + id +  " está concluído");
								break;
									}
								}
						 catch (InterruptedException e) {
							e.printStackTrace();
							}
					}	
	}
	}
}
