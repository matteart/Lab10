package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;



public class Event implements Comparable<Event>{
	
	public enum EventType{
		NEW_CLIENT, END_CLIENT
	}
	
	



	private int num_persone;
	private Duration durata;
	private LocalTime time;
	private double tolleranza;
	private EventType type;
	
	
	
	public Event(int num_persone, Duration durata, LocalTime time, EventType type) {
		super();
		this.num_persone = num_persone;
		this.durata = durata;
		this.time = time;
		this.tolleranza= Math.random();
		this.type=type;
	}



	public double getTolleranza() {
		return tolleranza;
	}



	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}

	

	public EventType getType() {
		return type;
	}



	public void setType(EventType type) {
		this.type = type;
	}



	public void setDurata(Duration durata) {
		this.durata = durata;
	}


	private int tavolo;
	public int getTavolo() {
		return tavolo;
	}



	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	
	
	public int getNum_persone() {
		return num_persone;
	}



	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}



	public Duration getDurata() {
		return durata;
	}



	



	public LocalTime getTime() {
		return time;
	}



	public void setTime(LocalTime time) {
		this.time = time;
	}



	@Override
	public int compareTo(Event e) {
	
		return this.time.compareTo(e.getTime());
	}
	
	@Override
	public String toString() {
		
		if(this.type==EventType.NEW_CLIENT)
			return "Sono arrivati "+this.num_persone+" clienti nel bar alle ore: " +this.time+". Gli viene assegnato il tavolo di grandezza: "+this.tavolo+" per una durata di: "+ this.durata;
			
		else
		   return "Hanno finito di consumare "+ this.num_persone+ "clienti alle ore: "+ this.time;
	}
	
}
