package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Encounter;
import pl.sda.model.Treasure;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TreasureRepoImpl implements TreasureRepo {
    private static final String TREASURES_CSV_FILE_PATH = "./src/main/resources/treasures.csv";
    private List<Treasure> treasuresList;

    @Override
    public List<Treasure> ReadTreasuresFromCSV() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(TREASURES_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Treasure> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Treasure.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Treasure> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            Treasure treasure = csvUserIterator.next();
            treasuresList.add(new Treasure(treasure.getId(), treasure.getName(), treasure.getHp(), treasure.getAttack(), treasure.getArmor()));
        }

        return treasuresList;

    }

    @Override
    public void PrintTreasuresList() {
        treasuresList.forEach(System.out::println);

    }

    @Override
    public Treasure getRandomTreasure(List<Treasure> treasuresList) {

        Random rand = new Random();


        int randomIndex = rand.nextInt(treasuresList.size());

        return treasuresList.get(randomIndex);
    }

}
