
public class Losango extends Poligono {

	public Losango(double lado) {
		this.base = lado;
		this.altura = lado;
	}
	
	@Override
	public double perimetro() {
		return base * 4;
	}

	@Override
	public String toString() {
		return "Losango [perimetro()=" + perimetro() + ", area()=" + area() + "]";
	}

	

}
