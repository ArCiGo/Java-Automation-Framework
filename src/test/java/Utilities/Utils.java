package Utilities;

import Models.CsvBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {
    /*
     * Here goes your custom methods to use in your tests,
     * like random generator of numbers/strings/alphanumerics
     * etcetera
     */

    public static List<CsvBean> readDataLineByLine(String path, Class classModel) {
        try {
            CsvTransfer csvTransfer = new CsvTransfer();
            Reader reader = Files.newBufferedReader(Paths.get(path));

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(classModel)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            csvTransfer.setCsvList(csvToBean.parse());
            reader.close();

            return csvTransfer.getCsvList();
        } catch(Exception ex) {
            Log.error(ex.toString());
            return null;
        }
    }
}
