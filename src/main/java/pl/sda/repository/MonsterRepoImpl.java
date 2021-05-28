package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Monster;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MonsterRepoImpl implements MonsterRepo{

    private static final String MONSTERS_CSV_FILE_PATH = "./src/main/resources/monsters.csv";

    @Override
    public List<Monster> ReadMonstersFromCSV() {

        List<Monster> monstersList = new ArrayList<>();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(MONSTERS_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Monster> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Monster.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Monster> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            Monster monster = csvUserIterator.next();
            monstersList.add(new Monster(monster.getId(), monster.getName(), monster.getHp(), monster.getMinAttack(), monster.getMaxAttack(), monster.getArmor(), monster.getCriticalChance(), monster.getCriticalMultiplayer(), monster.getAccuracy(), monster.getDodge(), monster.getLootChance()));
        }

        return monstersList;
    }

    @Override
    public void PrintMonstersList(List<Monster> monstersList) {
        monstersList.forEach(System.out::println);

    }

    @Override
    public Monster getRandomMonster(List<Monster> monstersList) {
        Random rand = new Random();

        int randomIndex = rand.nextInt(monstersList.size());

        return monstersList.get(randomIndex);
    }
}
