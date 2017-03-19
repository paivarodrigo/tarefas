
public class Cubo extends Quadrado implements Volume {

	private double profundidade;
	
	public Cubo(double lado) {
		super(lado);
		this.profundidade = lado;
	}
	
	public double volume() {
		return area() * profundidade;
	}

	@Override
	public String toString() {
		return "Cubo [volume()=" + volume() + "]";
	}
}
