import java.io.FileNotFoundException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Reader {

    private CSVReader reader;

    public Reader(String filename) throws FileNotFoundException {
        this.reader = new CSVReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)));
    }
    
    public List<String[]> read() throws IOException, CsvException {
        return reader.readAll();
    }
}