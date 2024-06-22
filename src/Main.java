import core.CreatingComplexNumber;
import core.CreatingComplexNumberP;
import core.model.MathematicsModel;
import core.model.ModelDivision;
import core.model.ModelMinus;
import core.model.ModelMultiplication;
import core.model.ModelPlus;
import core.presenter.Presenter;
import core.view.ConsoleView;
import core.view.View;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("my.logger");
        log.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        log.addHandler(handler);
        log.fine("Start App");
        View view = new ConsoleView();
        log.fine("field view");
        System.out.println("Complex number calculator");
        MathematicsModel model = new ModelPlus();
        log.fine("field model");
        CreatingComplexNumber creatingComplexNumber = new CreatingComplexNumberP();
        log.fine("field creatingComplexNumber");
        view.Set("Select operation" + "\n"
                + "1. +" + "\n" + "2. -"+ "\n" + "3. *" + "\n" + "4. / \n");
        String sign = "", choise = view.Get();
        switch (choise) {
            case "1":
                model = new ModelPlus();
                sign = "+";
                break;
            case "2":
                model = new ModelMinus();
                sign = "-";
                break;
            case "3":
                model = new ModelMultiplication();
                sign = "*";
                break;
            case "4":
                model = new ModelDivision();
                sign = "/";
                break;
            default:
                break;
        }
        Presenter presenter = new Presenter<>(model, creatingComplexNumber, sign);
        log.fine("field presenter");
        presenter.buttonClick();
        log.fine("buttonClick");
        System.out.println("GoodBye");
    }
}