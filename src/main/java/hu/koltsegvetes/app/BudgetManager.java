// BudgetManager.java

package hu.koltsegvetes.app;

public class BudgetManager {
    
    private double budget;

    public BudgetManager(double initialBudget) {
        this.budget = initialBudget;
    }

    public void addExpense(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        budget -= amount;
    }

    public void addIncome(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        budget += amount;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Current budget: " + budget;
    }
}