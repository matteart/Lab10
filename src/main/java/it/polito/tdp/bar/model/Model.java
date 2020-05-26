package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Simulator s = new Simulator();
   
	public void setParameter(List<Tavolo> tempL ) {
		s.addTavolo(tempL);
	}
	public void runSimulator() {
		System.out.println("INIZIO SIMULAZIONE");
		s.run();
	}
}
