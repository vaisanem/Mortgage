import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.List;

public class Reader {

    private CSVReader reader;

    public Reader(String filename) throws FileNotFoundException {
        File file = new File(filename);
        this.reader = new CSVReader(new FileReader(file));
    }
    
    public List<String[]> read() throws IOException, CsvException {
        return reader.readAll();
    }
}