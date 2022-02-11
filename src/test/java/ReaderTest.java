import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ReaderTest {
    
    private Reader reader;
    private String filename;
    
    @Test
    public void parsesSuccessfully() throws FileNotFoundException, IOException, CsvException {
        filename = "./src/test/resources/prospects.txt";
        reader = new Reader(filename);
        List<String[]> lines = reader.read();
        assertTrue(lines.get(0).length == 4);
    }
    
    @Test
    public void parsingFailsWithWrongFormat() throws FileNotFoundException, IOException, CsvException {
        filename = "./src/test/resources/format.txt";
        reader = new Reader(filename);
        List<String[]> lines = reader.read();
        assertTrue(lines.get(0).length != 4);
    }
}