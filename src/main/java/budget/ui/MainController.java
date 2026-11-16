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
    private Label amountErrorLabel;

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
        try {
            amountErrorLabel.setVisible(false);
            String amountText = amountField.getText();
            String description = descriptionField.getText();
            Expense expense = new Expense(Money.parse(amountText), Category.FOOD, LocalDate.now(), description);
            service.addExpense(expense);
            updateTotalLabel();
        } catch (NumberFormatException e) {
            showAmountError("Only numbers");
        } catch (IllegalArgumentException e) {
            showAmountError("Positive numbers only");
        }
    }

    private void showAmountError(String message) {
        amountErrorLabel.setVisible(true);
        amountErrorLabel.setText(message);
        amountField.requestFocus();
        amountField.selectAll();
    }

    private void updateTotalLabel() {
        totalLabel.setText("Total: " + Money.format(service.getTotal()));
    }
}
