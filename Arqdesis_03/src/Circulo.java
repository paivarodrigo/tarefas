
public class Circulo extends Figura {

	protected double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}

	@Override
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	@Override
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}

	@Override
	public String toString() {
		return "Circulo [perimetro()=" + perimetro() + ", area()=" + area() + "]";
	}

}
