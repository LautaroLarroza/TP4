import java.util.Scanner;

public class ArrayDePuntos {

    public static void main(String[] args) {
        Punto[] puntos = new Punto[6];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Ingrese las coordenadas del punto " + (i + 1) + ":");
            System.out.print("Coordenada X: ");
            double x = scanner.nextDouble();
            System.out.print("Coordenada Y: ");
            double y = scanner.nextDouble();
            
            puntos[i] = new Punto(x, y);
        }

        System.out.println("\nCoordenadas de los puntos:");
        for (int i = 0; i < puntos.length; i++) {
            System.out.println("Punto " + (i + 1) + ": " + puntos[i].coordenadas());
        }

        System.out.println("\nDistancias entre puntos consecutivos:");
        for (int i = 0; i < puntos.length - 1; i++) {
            double distancia = calcularDistancia(puntos[i], puntos[i + 1]);
            System.out.println("Distancia entre Punto " + (i + 1) + " y Punto " + (i + 2) + ": " + distancia);
        }

        scanner.close();
    }

    public static double calcularDistancia(Punto p1, Punto p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
