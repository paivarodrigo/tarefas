
public class Cilindro extends Retangulo implements Volume{

	public Cilindro(double base, double altura) {
		super(base, altura);
	}
	
	public double volume() {
		return Math.PI * Math.pow(base/2, 3) * altura;
	}

	@Override
	public String toString() {
		return "Cilindro [volume()=" + volume() + "]";
	};

}
