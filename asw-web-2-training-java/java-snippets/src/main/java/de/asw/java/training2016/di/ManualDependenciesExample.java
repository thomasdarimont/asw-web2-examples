package de.asw.java.training2016.di;

class Komponente1 {

	Komponente2 komponente2;

	public Komponente2 getKomponente2() {
		return komponente2;
	}

	public void setKomponente2(Komponente2 komponente2) {
		this.komponente2 = komponente2;
	}

	void someOperation() {
		System.out.println("Komponente1.someOperation()");
		System.out.println("Komponente2: " + komponente2.toString());
	}
}

class Komponente2 {
	// ...
}

public class ManualDependenciesExample {

	public static void main(String[] args) {

		// Manuelle Instanziierung von Komponente1
		Komponente1 k1 = new Komponente1();

		// Manuelle Instanziierung von Komponente2
		Komponente2 k2 = new Komponente2();

		// Manuelle Konfiguration von Komponente1
		k1.setKomponente2(k2);

		// Komponente1 ist jetzt verwendbar
		k1.someOperation();
	}
}
