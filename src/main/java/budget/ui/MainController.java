package budget.ui;

import budget.core.BudgetService;
import budget.core.Category;
import budget.core.Expense;
import budget.core.Money;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class MainController {

    private final BudgetService service = new BudgetService();

    @FXML
    private Label totalLabel;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField amountField;

    @FXML
    private void initialize() {
        updateTotalLabel();
    }

    @FXML
    private void handleAddSample() {
        //long amountInCents = 5000;
        String amountText = amountField.getText();
        String description = descriptionField.getText();
        Expense expense = new Expense(Money.parse(amountText), Category.FOOD, LocalDate.now(), description);
        service.addExpense(expense);
        updateTotalLabel();
    }

    private void updateTotalLabel() {
        totalLabel.setText("Total: " + Money.format(service.getTotal()));
    }
}
