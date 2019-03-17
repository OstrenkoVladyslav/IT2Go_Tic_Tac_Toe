package GameOOP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladyslav on 14.08.17.
 */
public class Controller implements ActionListener {
    private Model model;
    private View view;

    public Controller(Model model){
        this.model = model;
        view = new View(this, model);
        view.createView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
