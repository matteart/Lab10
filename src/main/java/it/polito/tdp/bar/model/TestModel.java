package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {
	
	public static void main(String[] args) {
		Tavolo t1 = new Tavolo(10,2);
		Tavolo t2= new Tavolo(8,4);
		Tavolo t3= new Tavolo(6,4);
		Tavolo t4= new Tavolo(4,5);
		List<Tavolo> prova = new ArrayList<>();
		Model m = new Model();
		
		
		prova.add(t1); prova.add(t2); prova.add(t3); prova.add(t4);
		
        m.setParameter(prova);
        m.runSimulator();
	}

}
