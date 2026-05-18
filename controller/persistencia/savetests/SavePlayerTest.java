package controller.persistencia.savetests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.lang.foreign.AddressLayout;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import controller.persistencia.savecontroller.SaveObject;
import model.modelo.Jogador;

class SavePlayerTest {
	
	Jogador p1 = new Jogador("Felipe");
	Jogador p2 = new Jogador("João Victor");
	SaveObject save;
	File arquivo = new File("SaveJogador.json");
	
	public SavePlayerTest() throws IOException {
		save = new SaveObject(arquivo.getName());
	}
	
	@Test
	void TesteSave() throws IOException {
		ArrayList<Jogador> lista = new ArrayList<Jogador>();
		lista.add(p1);
		lista.add(p2);
		save.salvarLista(lista);
		
	}
	
	@Test
	void TestRead() {
		try {
			ArrayList<Jogador> lista2 = (ArrayList<Jogador>) save.lerLista(Jogador.class);
			Jogador jogador1 = lista2.get(0);
			Jogador jogador2 = lista2.get(1);
			assertEquals(p1.getNome(), jogador1.getNome());
			assertEquals(p2.getNome(), jogador2.getNome());
			
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Falhou depois aqui:\n" + e.toString());
		} finally {
			System.out.println("Código finalizado");
		}
	}
}
