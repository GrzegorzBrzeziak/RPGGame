package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Level;
import pl.sda.model.Player;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerLevelRepoImpl implements PlayerLevelRepo {

    private static final String LEVELS_CSV_FILE_PATH = "./src/main/resources/levels.csv";

    @Override
    public List<Level> ReadlevelsFromCSV() {
        List<Level> levelsList = new ArrayList<>();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(LEVELS_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Level> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Level.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Level> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            Level level = csvUserIterator.next();
            levelsList.add(new Level(level.getId(), level.getXp()));
        }
        return levelsList;
    }

    @Override
    public Level getLevel(List<Level> levelsList, Player player) {
        return levelsList.get(player.getPlayerLevel());
    }
}
