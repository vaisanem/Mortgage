import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
        final String filename = "prospects.txt";
        ArrayList<Customer> customers = getCustomers(filename);
        for (int i = 1; i <= customers.size(); i++) {
            Customer one = customers.get(i-1);
            System.out.println("Prospect " + i + ": " + one.getName() 
                    + " wants to borrow " + one.getLoan() 
                    + " € for a period of " + one.getYears()
                    + " years and pay " + one.getMonthlyPayment()
                    + " € each month");
        }   
    }
    
    public static ArrayList<Customer> getCustomers(String filename) throws FileNotFoundException, IOException, CsvException {
        Reader reader = new Reader(filename);
        ArrayList<Customer> customers = new ArrayList<>();
        List<String[]> lines = reader.read();
        for (int i = 1; i < lines.size(); i++) {
            try {
                String[] line = lines.get(i);
                customers.add(new Customer(line));
            } catch(ArrayIndexOutOfBoundsException e) {
                //System.out.println("There was an error with the format of the input file.");
            } catch(NumberFormatException e) {
                System.out.println("There was an error with the values of the input file.");
            }
        }
        return customers;
    }
}
