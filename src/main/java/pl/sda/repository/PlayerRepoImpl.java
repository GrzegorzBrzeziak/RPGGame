package pl.sda.repository;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import pl.sda.model.Player;
import pl.sda.model.Treasure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerRepoImpl implements PlayerRepo{

    private static final String PLAYER_CSV_FILE_PATH = "./src/main/resources/player.csv";


    @Override
    public Player createNewPlayer() {
        return new Player(100, 10, 0);
    }

    @Override
    public List<Player> loadPlayer() {

        List<Player> playerList = new ArrayList<>();
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

        return playerList;

    }

    @Override
    public void savePlayer(List<Player> playerList) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        Writer writer  = new FileWriter(PLAYER_CSV_FILE_PATH);

        StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();



        sbc.write(playerList);
        writer.close();
    }
}
