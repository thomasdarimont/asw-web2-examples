package de.asw.java.training2016.di;

public class ManualDependenciesExample {
	
	static class Komponente1{
		//...
		Komponente2 komponente2;

		public Komponente2 getKomponente2() {
			return komponente2;
		}

		public void setKomponente2(Komponente2 komponente2) {
			this.komponente2 = komponente2;
		}
		
		void someOperation(){
			System.out.println("ManualDependenciesExample.Komponente1.someOperation()");
			System.out.println("Komponente2: " + komponente2.toString());
		}
	}
	
	static class Komponente2{
		//...
	}
	
	public static void main(String[] args) {
		
		Komponente1 k1 = new Komponente1();
		k1.setKomponente2(new Komponente2());
		k1.someOperation();
	}
}
