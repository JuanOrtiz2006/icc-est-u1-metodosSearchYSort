import controllers.Controller;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de personas.");
        Controller controller = new Controller();
        controller.start();
    }
}
