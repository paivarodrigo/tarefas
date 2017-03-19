
public class Esfera extends Circulo implements Volume{

	public Esfera(double raio) {
		super(raio);
	}
	
	public double volume() {
		return (4/3) * Math.PI * Math.pow(raio, 3);
	}

	@Override
	public String toString() {
		return "Esfera [volume()=" + volume() + "]";
	}

}
