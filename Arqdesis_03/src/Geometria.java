import java.util.ArrayList;

public class Geometria {
	
	public ArrayList<Figura> figuras = new ArrayList<>();
	
	public Geometria() {
		figuras.add(new Quadrado(5.0));
		figuras.add(new Retangulo(4.0,7.8));
		figuras.add(new Triangulo(3.0,9.6));
		figuras.add(new Losango(7.2));
		figuras.add(new Cubo(8.9));
		figuras.add(new Esfera(5.0));
		figuras.add(new Cilindro(10.0, 13.4));
		figuras.add(new Piramide(5.6, 12.0));
	}
	
	public void imprimirAreas() {
		for(Figura fig : figuras) {
			System.out.println(fig.toString());
		}
	}
}