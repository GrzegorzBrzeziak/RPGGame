package pl.sda.repository;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import pl.sda.model.Player;

import java.io.IOException;
import java.util.List;

public interface PlayerRepo {

    public Player createNewPlayer();

    public Player loadPlayer();

    public void savePlayer(Player player) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
}
