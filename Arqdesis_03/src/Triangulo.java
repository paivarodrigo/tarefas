
public class Triangulo extends Poligono {

	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
		@Override
	public double area() {
		return super.area() / 2;
	}
	
	@Override
	public double perimetro() {
		double hip = Math.sqrt(Math.pow(base/2, 2) + Math.pow(altura, 2));
		return base + (2 * hip);
	}

	@Override
	public String toString() {
		return "Triangulo [area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}
	
	
}
