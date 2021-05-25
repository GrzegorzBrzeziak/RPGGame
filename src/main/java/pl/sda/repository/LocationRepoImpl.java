package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Location;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LocationRepoImpl implements LocationRepo{

    private static final String LOCATIONS_CSV_FILE_PATH = "./src/main/resources/locations.csv";
    private List<Location> locationList;

    @Override
    public List<Location> ReadLocationsFromCSV() {

        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(LOCATIONS_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Location> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Location.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Location> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            Location location = csvUserIterator.next();
            locationList.add(new Location(location.getId(), location.getLocationName(), location.getMonsterChanceEvent(), location.getTreasureChanceEvent(), location.getEncounterChanceEvent()));
        }

        return locationList;
    }

    @Override
    public void PrintLocationList() {
        locationList.forEach(System.out::println);
    }


    @Override
    public Location getRandomLocation() {

        Random rand = new Random();

            int randomIndex = rand.nextInt(locationList.size());

        return locationList.get(randomIndex);
    }
}
