package exercice1;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FIFO<E> {
	
	private LinkedList<E> file; 
	private int numberPassengers;
	
	public FIFO() {
		file = new LinkedList<E>();
		numberPassengers = 0;
	}
	
	public FIFO<E> enfiler(E passenger){
		file.addLast(passenger);
		numberPassengers++;
		return this;
	}
	
	public E teteDeFile(){
		E passenger = null;
		try {
			passenger = file.getFirst();
		} catch (NoSuchElementException nse) {}
		return passenger;
	}
	
	public E defiler(){
		E passenger = null;
		try {
			passenger = file.removeFirst();
			numberPassengers--;
		} catch (NoSuchElementException nse) {}
		return passenger;
	}
	
	public static void main(String[] args) {
		FIFO<String> file = new FIFO<String>();
		boolean shopIsOpen = true;
		int numberInsertion = 0;
		do{
			System.out.println("Menu :\n");
			System.out.println("1 - Insérer un nouveau passager.\n");
			if(file.numberPassengers > 0) System.out.println("2 - Supprimer le prochain passager.\n");
			if(file.numberPassengers > 0) System.out.println("3 - Afficher le prochain passager.\n");
			System.out.println("Choix :");
			Scanner sc = new Scanner(System.in);
			int reponse = Integer.parseInt(sc.nextLine());
			switch (reponse) {
			case 1:
				file.enfiler("Passenger "+ ++numberInsertion);
				break;
			case 2:
				file.defiler();
				break;
			case 3:
				System.out.println(file.teteDeFile());
				break;
			default:
				shopIsOpen = false;
				break;
			}
		} while(shopIsOpen);
		System.out.println("Il y a "+file.numberPassengers+" passagers restant dans la file à la fermeture.");
	}
}
