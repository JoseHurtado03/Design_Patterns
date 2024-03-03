package memento;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una calificación: ");
        int calificacion = scanner.nextInt();

        Memento memento = new Memento(calificacion);
        Originator originator = new Originator(calificacion);
        CareTaker careTaker = new CareTaker(originator, memento);

        System.out.print("¿Desea actualizar el valor? (y/n): ");
        char updateChoice = scanner.next().charAt(0);

        if (updateChoice == 'y' || updateChoice == 'Y') {
            System.out.print("Ingrese el nuevo valor de la calificación: ");
            int newCalificacion = scanner.nextInt();
            originator.setCurrentValue(newCalificacion);
            careTaker.setCurrentValue(originator);
        }
        System.out.println("El valor actual de la calificación es: " + careTaker.getCurrentValue().getCurrentValue());

        System.out.print("¿Desea deshacer el cambio? (y/n): ");
        char undoChoice = scanner.next().charAt(0);

        if (undoChoice == 'y' || undoChoice == 'Y') {
            careTaker.undo();
        }
        System.out.println("El valor actual de la calificación es: " + careTaker.getCurrentValue().getCurrentValue());

        scanner.close();
    }
}
