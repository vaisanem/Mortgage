import java.text.DecimalFormat;

public class Customer {
    
    private String name;
    private float loan;
    private float interest;
    private int years;
    
    public Customer(String name, float loan, float interest, int years) {
        this.name = name;
        this.loan = loan;
        this.interest = interest / 100;
        this.years = years;
    }
    
    public Customer(String[] values) {
        this.name = values[0];
        this.loan = Float.parseFloat(values[1]);
        this.interest = Float.parseFloat(values[2]) / 100;
        this.years = Integer.parseInt(values[3]);
    }

    public String getName() {
        return name;
    }

    public float getLoan() {
        return loan;
    }

    public int getYears() {
        return years;
    }
    
    public double getMonthlyPayment() {
        int months = years * 12;
        double monthlyInterest = interest / 12;
        double result = loan * monthlyInterest
                * (Math.pow(1 + monthlyInterest, months) 
                / (Math.pow(1 + monthlyInterest, months) - 1));
        DecimalFormat format = new DecimalFormat("#.##");
        String round = format.format(result).replace(",", ".");
        return Double.parseDouble(round);
    }
}