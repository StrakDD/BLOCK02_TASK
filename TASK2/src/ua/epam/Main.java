package ua.epam;

/**
 * Created by Denis Starovoitenko on 19.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        //Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //Invoke task execution
        controller.processRun();
    }
}
