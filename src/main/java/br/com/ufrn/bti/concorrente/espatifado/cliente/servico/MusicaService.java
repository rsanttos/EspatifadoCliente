package br.com.ufrn.bti.concorrente.espatifado.cliente.servico;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Musica;

public class MusicaService {

	public MusicaService(){
		
	}
	
	public List<Musica> populaMusicas(){
		Musica m1 = new Musica(1, "m1", "c2", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m2 = new Musica(2, "m2", "c3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m3 = new Musica(3, "m3", "c4", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m4 = new Musica(4, "m4", "c5", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m5 = new Musica(5, "m5", "c6", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m6 = new Musica(6, "m6", "c7", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m7 = new Musica(7, "m7", "c8", (double) Math.random() * 100, (double) Math.random() * 10000);
		
		List<Musica> musicas = new ArrayList<Musica>();
		
		musicas.add(m1);
		musicas.add(m2);
		musicas.add(m3);
		musicas.add(m4);
		musicas.add(m5);
		musicas.add(m6);
		musicas.add(m7);
		
		return musicas;
		
	}
	
}
