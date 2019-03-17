package GameOOP;

import java.awt.*;

public class MVC {
    public MVC() {
        super();
        Model model = new Model(3);
        Controller controller = new Controller(model);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MVC mvc = new MVC();
        });
    }

}
