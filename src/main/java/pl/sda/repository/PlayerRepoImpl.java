package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Player;
import pl.sda.model.Treasure;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class PlayerRepoImpl implements PlayerRepo{

    private static final String PLAYER_CSV_FILE_PATH = "./src/main/resources/player.csv";
    private List<Player> playerList;

    @Override
    public Player createNewPlayer() {
        return new Player(100, 10, 0);
    }

    @Override
    public Player loadPlayer() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(PLAYER_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Player> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Player.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Player> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            Player player = csvUserIterator.next();
            playerList.add(player);
        }

        return playerList.get(0);

    }

    @Override
    public void savePlayer() {

    }
}
