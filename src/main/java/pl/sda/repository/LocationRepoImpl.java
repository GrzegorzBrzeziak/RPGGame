package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Location;
import pl.sda.model.Player;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LocationRepoImpl implements LocationRepo {

    private static final String LOCATIONS_CSV_FILE_PATH = "./src/main/resources/locations.csv";


    @Override
    public List<Location> ReadLocationsFromCSV() {
        List<Location> locationList = new ArrayList<>();
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
            locationList.add(new Location(location.getId(), location.getLocationName(), location.getMonsterChance(), location.getTreasureChance(), location.getEncounterChance(), location.getLocationDifficulty(), location.getMonsterId1(), location.getMonsterId1Chance(), location.getMonsterId2(), location.getMonsterId2Chance(), location.getMonsterId3(), location.getMonsterId3Chance(), location.getMonsterId4(), location.getMonsterId4Chance()));
        }


        return locationList;
    }

    @Override
    public void PrintLocationList(List<Location> locationList) {
        locationList.forEach(System.out::println);
    }


    @Override
    public Location getRandomLocationBoundedByPlayerLevel(List<Location> locationList, Player player) {

        int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, locationList.size());

        while (true){
            if((player.getPlayerLevel() + 2) >= locationList.get(boundedRandomValue).getLocationDifficulty()) {
                break;
            } else{
                boundedRandomValue = ThreadLocalRandom.current().nextInt(0, locationList.size());
            }
        }

        Location randomLocation = locationList.get(boundedRandomValue);

        return new Location(randomLocation.getId(), randomLocation.getLocationName(), randomLocation.getMonsterChance(), randomLocation.getTreasureChance(), randomLocation.getEncounterChance(), randomLocation.getLocationDifficulty(), randomLocation.getMonsterId1(),randomLocation.getMonsterId1Chance(),randomLocation.getMonsterId2(),randomLocation.getMonsterId2Chance(),randomLocation.getMonsterId3(),randomLocation.getMonsterId3Chance(),randomLocation.getMonsterId4(),randomLocation.getMonsterId4Chance());
    }
}
