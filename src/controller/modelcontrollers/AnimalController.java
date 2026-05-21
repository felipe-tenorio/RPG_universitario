package controller.modelcontrollers;

import model.modelo.Animal;
import model.modelo.Local;

public class AnimalController {
	private Animal animal;
	
	public AnimalController(String nome, Local local, String tipo) {
		animal = new Animal(nome, local, tipo);
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}