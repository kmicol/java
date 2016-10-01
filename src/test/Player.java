package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
		public String country;
		public Double pop;
		public Double gdp;
		public double gdpG;
		
		public Player(String a, double x, double y, double z) {
			country = a;
			pop = x;
			gdp = y;
			gdpG = z;
	
	}
		public Double getpop() {
			return pop;
		}
		public Double getgdp() {
			return gdp;
		}
		public Double getgdpG() {
			return gdpG;
		}
		
			public String toString() {
				
				
				return country + " " +pop+ " million $"+gdp+" billion "+gdpG + "%\n" ;
			}
}
