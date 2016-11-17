package br.com.ufrn.bti.concorrente.espatifado.cliente.servico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Musica;
import br.com.ufrn.bti.concorrente.espatifado.cliente.util.JSONProcessor;

public class MusicaService {

	public MusicaService(){
		
	}
	
	public List<Musica> populaMusicas(String json) throws JSONException, IOException{

		List<Musica> musicas = new ArrayList<Musica>();		
		musicas = JSONProcessor.toList(json, Musica.class);		
		return musicas;
		
	}
	
	public List<Musica> simulaMusicas(){		
		
		
		Musica m1 = new Musica(1, "m1", "c2", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/1.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m2 = new Musica(2, "m2", "c3", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/2.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m3 = new Musica(3, "m3", "c4", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/3.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m4 = new Musica(4, "m4", "c5", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/4.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m5 = new Musica(5, "m5", "c6", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/5.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m6 = new Musica(6, "m6", "c7", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/6.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m7 = new Musica(7, "m7", "c8", "/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/7.mp3", (double) Math.random() * 100, (double) Math.random() * 10000);
		
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
