package views;
import java.util.Scanner;
import models.Person;
public class View {
    private Scanner scanner = new Scanner(System.in);

    public View(){

    }

    public int showMenu(){
        System.out.println("Seleccione una opción del menú:");
        System.out.println("1. Mostrar personas");
        System.out.println("2. Ingresar personas");
        System.out.println("3. Añadir persona");
        System.out.println("4. Ordenar personas");
        System.out.println("5. Buscar personas");
        System.out.println("6. Salir");
        return validInput(1, 6);
    }

    public Person inputPerson(){
        String name=inputName();
        int age=inputAge();
        return new Person(name, age);
    }

    public int selectSortingMethod(){
        System.out.println("1. Ordenar por nombre por metodo burbuja");
        System.out.println("2. Ordenar por nombre por metodo de seleccion desendente");
        System.out.println("3. Ordenar por edad por metodo de insercion");
        System.out.println("4. Ordenar por nombre por metodo de insercion");

        int res = scanner.nextInt();
        if (res < 1 || res > 4) {
            System.out.println("Opción no válida, por favor intente de nuevo.");
            return selectSortingMethod();
        }
        return res;
    }

    public int selectSearchMethod(){
        System.out.println("1. Buscar nombre por metodo binario");
        System.out.println("2. Buscar edad por metodo binario");
        int res = scanner.nextInt();
        if (res < 1 || res > 2) {
            System.out.println("Opción no válida, por favor intente de nuevo.");
            return selectSearchMethod();
        }
        return res;
    }

    public int selectSearchCriterion() {
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por edad");
        int res = scanner.nextInt();
        if (res < 1 || res > 2) {
            System.out.println("Opción no válida, por favor intente de nuevo.");
            return selectSearchCriterion();
        }
        return res;
    }

    public void displayPersons(Person[] persons){
        System.out.print("[");
        for (Person person : persons) {
            System.out.print(person);
            System.out.print(" ");
        }
        System.out.println("]");

    }

    public void displaySearchResult(Person person){
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("La persona no existe.");
        }

    }

    public int inputAge(){
        System.out.println("Ingresar edad: ");
        int res = scanner.nextInt();
        while (res < 0 || res > 120) {
            System.out.println("La edad debe estar entre 0 y 120. Ingrese nuevamente: ");
            res = scanner.nextInt();
        }
        return res;
    }

    public String inputName(){
        System.out.println("Ingresar nombre: ");
        String res = scanner.next();
        while (res.length() < 3) {
            System.out.println("El nombre debe tener al menos 3 caracteres. Ingrese nuevamente: ");
            res = scanner.next();
        }
        while (res.length() > 20) {
            System.out.println("El nombre no puede tener más de 20 caracteres. Ingrese nuevamente: ");
            res = scanner.next();
        }
        return res;
    }

    public int inputNumberOfPersons() {
        System.out.println("Ingrese el número de personas: ");
        int res = scanner.nextInt();
        while (res <= 0 || res > 100) {
            System.out.println("El número de personas debe ser mayor que 0 y menor a 100. Ingrese nuevamente: ");
            res = scanner.nextInt();
        }
        return res;
    }

    public int validInput(int min, int max) {
        int res = scanner.nextInt();
        while (res < min || res > max) {
            System.out.println("Opción no válida, por favor intente de nuevo.");
            res = scanner.nextInt();
        }
        return res;

    }

}
