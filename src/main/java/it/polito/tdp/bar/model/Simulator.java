package it.polito.tdp.bar.model;
import it.polito.tdp.bar.model.Event.EventType;
import java.time.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;



public class Simulator {

	private PriorityQueue<Event> queue = new PriorityQueue<>();
	
	private List<Tavolo> tavoli = new ArrayList<Tavolo>();
	private Duration time= Duration.of(60, ChronoUnit.MINUTES);
	
	
	private int clienti;
	private int clientiInsoddisfatti;
	
	private final LocalTime oraApertura = LocalTime.of(6, 00);
	private final LocalTime oraChiusura = LocalTime.of(22, 00);
	
	public int getClienti() {
		return clienti;
	}

	public int getClientiInsoddisfatti() {
		return clientiInsoddisfatti;
	}

	public void addTavolo(List<Tavolo> tempL) {
		tavoli = new ArrayList<>(tempL);
		Collections.sort(tavoli);
			}
	
	private int numeroPersone() {
		int random = (int) (Math.random()*10);
		if(random==0)
			return 1;
		return random;
	}
	
	private Duration durataCliente() {  // DICE QUANTO RESTA UN CLIENTE
		int random =(int) (Math.random()*60);
		
		return this.time.plus(Duration.of(random, ChronoUnit.MINUTES));
	}
	
	private void rimuoviCliente(Event e) {
		for(Tavolo t:tavoli)
			if(t.getGrandezzaTavolo()==e.getTavolo())
				t.addTavolo();
	}
	
	private Duration getTimeRandom() {  // DICE OGNI QUANTO ARRIVA UN CLIENTE
		int random =(int) (Math.random()*10);
		
		if(random<=1)
			return Duration.of(1, ChronoUnit.MINUTES);
		if(random<=2)
			return Duration.of(2, ChronoUnit.MINUTES);
		if(random<=3)
			return Duration.of(3, ChronoUnit.MINUTES);
		if(random<=4)
			return Duration.of(4, ChronoUnit.MINUTES);
		if(random<=5)
			return Duration.of(5, ChronoUnit.MINUTES);
		if(random<=6)
			return Duration.of(6, ChronoUnit.MINUTES);
		if(random<=7)
		return Duration.of(7, ChronoUnit.MINUTES);
		if(random<=8)
			return Duration.of(8, ChronoUnit.MINUTES);
		if(random<=9)
			return Duration.of(9, ChronoUnit.MINUTES);
		else
			return  Duration.of(10, ChronoUnit.MINUTES);
	}
	private Boolean tavoloNonDisponibile(Event e) {
       Double random = Math.random();
    		   if(random<= e.getTolleranza())
    			   return true;
       return false;
	}
	private Boolean checkDisponibilita(Event e) {
		
		for(Tavolo t:tavoli)
			if(t.checkDisponibilita(e))
				return true;
		return false;
	}
	
	public void run() {
		
		//Preparazione mondo
		this.clienti=0;
		this.clientiInsoddisfatti=0;
		this.queue.clear();
		
		LocalTime oraArrivoCliente = this.oraApertura;
		
		while(oraArrivoCliente.isBefore(oraChiusura)) {
			Duration tempD = this.getTimeRandom();
			
		    Duration tempd= this.durataCliente();
		   
			Event tempE = new Event(this.numeroPersone(), tempd, oraArrivoCliente, EventType.NEW_CLIENT);
			
			this.queue.add(tempE);
			
			oraArrivoCliente = oraArrivoCliente.plus(tempD);
			
		}
		
		//Esecuzione simulazione
		while(!this.queue.isEmpty()) {
			Event tempE = queue.poll();
			
			this.processEvent(tempE);
			System.out.println(tempE);
		}
	}
	
	private void processEvent(Event e) {
		
		switch(e.getType()) {
		case NEW_CLIENT :
			if(this.checkDisponibilita(e)) {
				this.clienti+=e.getNum_persone();
				
				Event tempE = new Event(e.getNum_persone(), e.getDurata(), e.getTime().plus(this.durataCliente()), EventType.END_CLIENT);
				tempE.setTavolo(e.getTavolo());
				queue.add(tempE);
			}
			else {
				if(this.tavoloNonDisponibile(e))
					this.clienti+=e.getNum_persone();
				else
					this.clientiInsoddisfatti+=e.getNum_persone();
			}
			break;
		case END_CLIENT:
			this.rimuoviCliente(e);
			break;
		}
		
	}
}
