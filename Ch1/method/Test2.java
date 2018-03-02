package method;

public class Test2 {
	public static void main(String[] args) {
		Tank Winston = new Tank("Winston");
		Hero Hanzo = new Hero("Hanzo");
		Hero Junkrat = new Hero("Junkrat");

		Winston.attack();
		Winston.attack(Hanzo);
		Winston.attack(Junkrat, Hanzo);

	}

}
