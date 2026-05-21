package controller;

import java.util.ArrayList;
import java.util.List;

import controller.modelcontrollers.*;
import controller.persistencia.*;
import view.ViewTerminal;

public class MainController {
	private ViewTerminal view;
	private List<? extends Object> objetosJogo;
	
	public MainController() {
		view = new ViewTerminal();
		objetosJogo = new ArrayList<Object>();
	}
	
	public ViewTerminal getView() {
		return view;
	}
	
	public void setView(ViewTerminal view) {
		this.view = view;
	}

	public List<? extends Object> getObjetosJogo() {
		return objetosJogo;
	}

	public void setObjetosJogo(List<? extends Object> objetosJogo) {
		this.objetosJogo = objetosJogo;
	}

	
	
	public static void main(String[] args) {
		MainController controleGeral = new MainController();
		ViewTerminal view = controleGeral.getView();
		int opcao = view.mostrarMenuPrincipal();
		
		if(opcao == 1) {
			
		}
		
	}
}
