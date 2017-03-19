
public class Quadrado extends Poligono implements Diagonal {
	
	public Quadrado(double lado) {
		this.base = lado;
		this.altura = lado;
	}
	
	@Override
	public double area() {
		return Math.pow(base, 2);
	}
	
	@Override
	public double diagonal() {
		return base * Math.sqrt(2);
	}
	
	@Override
	public double perimetro() {
		return 4 * base;
	}

	public double getLado() {
		return base;
	}

	public void setLado(double lado) {
		this.base = lado;
		this.altura = lado;
	}

	@Override
	public String toString() {
		return "Quadrado [area()=" + area() + ", diagonal()=" + diagonal() + ", perimetro()=" + perimetro() + "]";
	}

}
