
public abstract class Poligono extends Figura {

	public double base;
	public double altura;
	
	@Override
	public double area() {
		return base * altura;
	};

}
