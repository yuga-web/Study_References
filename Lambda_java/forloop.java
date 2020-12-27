package com.source.lamdaExpressions1;
import java.util.Arrays;
import java.util.List;

public class forloop {
	public static void main(String[] args) {
	String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka"};
	List<String> players =  Arrays.asList(atp);
	       
	// Old looping
	for (String player : players) {
	     System.out.print(player + "; ");
	}
	       
	// Using lambda expression and functional operations
	 players.forEach((player) -> System.out.print(player + "; "));
	 
	// Using double colon operator in Java 8
	players.forEach(System.out::println);

}
}
