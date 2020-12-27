package com.sourcelamdaExpressions3;
import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
	public static void main(String[] args) {
		String[] players = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer"};
		// Sort players by name using lambda expression
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		 
		Arrays.sort(players, sortByName);
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
	}

}
