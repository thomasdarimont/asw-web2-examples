package de.asw.java.training2016.basics;

public interface SomeApi {

	void someOperation1();

	String someOperation2(String string);
}

class ApiUser {

	// primitive typen...
	int i;
	float f;
	double d;
	long l;
	short s;
	byte b;
	char c;
	boolean bool;

	public static void main(String[] args) {

		SomeApi api = //
				new SomeImpl() //
		// new AnotherImpl()
		;
		api.someOperation1();

	}
}

class AnotherImpl implements SomeApi {

	@Override
	public void someOperation1() {
		System.out.println("AnotherImpl.someOperation1()");
	}

	@Override
	public String someOperation2(String string) {
		System.out.println("AnotherImpl.someOperation2()");
		return null;
	}

}

class SomeImpl implements SomeApi {

	void internalOperation() {
		System.out.println("internal");
	}

	@Override
	public void someOperation1() {
		internalOperation();
		System.out.println("SomeImpl.someOperation1()");
	}

	@Override
	public String someOperation2(String string) {
		internalOperation();
		System.out.println("SomeImpl.someOperation2()");
		return "Hallo" + System.currentTimeMillis();
	}

}
