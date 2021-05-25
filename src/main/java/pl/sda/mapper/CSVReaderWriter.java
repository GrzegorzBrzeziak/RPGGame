package pl.sda.mapper;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.LocationModel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CSVReaderWriter {

    private static final String LOCATIONS_CSV_FILE_PATH = "./src/main/resources/locations.csv";

    public void locationCSVReader() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(LOCATIONS_CSV_FILE_PATH));
        CsvToBean<LocationModel> csvToBean = new CsvToBeanBuilder(reader)
                .withType(LocationModel.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<LocationModel> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            LocationModel locationModel = csvUserIterator.next();
            System.out.println("Id : " + locationModel.getId());
            System.out.println("Name : " + locationModel.getLocationName());
            System.out.println("Monster chance : " + locationModel.getMonsterChanceEvent());
            System.out.println("Treasure chance : " + locationModel.getTreasureChanceEvent());
            System.out.println("Encounter chance : " + locationModel.getEncounterChanceEvent());
            System.out.println("==========================");
        }


    }

}
