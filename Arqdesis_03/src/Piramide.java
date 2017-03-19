
public class Piramide extends Triangulo implements Volume{

	public Piramide(double base, double altura) {
		super(base, altura);
	}
	
	public double volume() {
		return (base * base * altura) / 3;
	}

	@Override
	public String toString() {
		return "Piramide [volume()=" + volume() + "]";
	}

}
