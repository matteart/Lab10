package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo>{

	private int grandezzaTavolo;
	private int numeroTavoli;
	
	public Tavolo(int grandezzaTavolo, int numeroTavoli) {
		super();
		this.grandezzaTavolo = grandezzaTavolo;
		this.numeroTavoli = numeroTavoli;
	}
	public int getGrandezzaTavolo() {
		return grandezzaTavolo;
	}
	public void setGrandezzaTavolo(int grandezzaTavolo) {
		this.grandezzaTavolo = grandezzaTavolo;
	}
	public int getNumeroTavoli() {
		return numeroTavoli;
	}
	public void setNumeroTavoli(int numeroTavoli) {
		this.numeroTavoli = numeroTavoli;
	}
  public void addTavolo() {
	  this.numeroTavoli++;
  }
	public Boolean checkDisponibilita(Event e) {
		if(e.getNum_persone()<=grandezzaTavolo || numeroTavoli >0) {
			e.setTavolo(this.grandezzaTavolo);
			numeroTavoli--;
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(Tavolo t) {
		// TODO Auto-generated method stub
		return this.grandezzaTavolo-t.getGrandezzaTavolo();
	}
	
}
