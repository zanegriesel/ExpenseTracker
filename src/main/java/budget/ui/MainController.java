package budget.ui;

import budget.core.BudgetService;
import budget.core.Money;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    private final BudgetService service = new BudgetService();

    @FXML
    private Label totalLabel;

    @FXML
    private void initialize(){
        totalLabel.setText("Total: " + Money.format(service.getTotal()));
    }
}
