
public class Retangulo extends Poligono implements Diagonal{

	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double diagonal() {
		return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
	}
	
	@Override
	public double perimetro() {
		return 2 * (base + altura);
	}

	@Override
	public String toString() {
		return "Retangulo [diagonal()=" + diagonal() + ", area()=" + area() + ", perimetro()=" + perimetro() + "]";
	}

}
