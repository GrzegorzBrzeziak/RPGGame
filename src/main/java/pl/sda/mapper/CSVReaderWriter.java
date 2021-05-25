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
import java.util.List;

public class CSVReaderWriter {

    private static final String LOCATIONS_CSV_FILE_PATH = "./src/main/resources/locations.csv";
    private List<LocationModel> locationList;


    public void locationCSVReader() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(LOCATIONS_CSV_FILE_PATH));
        CsvToBean<LocationModel> csvToBean = new CsvToBeanBuilder(reader)
                .withType(LocationModel.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<LocationModel> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            LocationModel locationModel = csvUserIterator.next();
            locationList.add(new LocationModel(locationModel.getId(), locationModel.getLocationName(), locationModel.getMonsterChanceEvent(), locationModel.getTreasureChanceEvent(), locationModel.getEncounterChanceEvent()));
        }

    }

}
