package pl.sda.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pl.sda.model.Encounter;
import pl.sda.model.Location;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class EncounterRepoImpl implements EncounterRepo {

    private static final String ENCOUNTERS_CSV_FILE_PATH = "./src/main/resources/encounters.csv";
    private List<Encounter> encountersList;

    @Override
    public List<Encounter> ReadEncountersFromCSV() {


        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(ENCOUNTERS_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Encounter> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Encounter.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        Iterator<Encounter> csvUserIterator = csvToBean.iterator();

        while (csvUserIterator.hasNext()) {
            Encounter encounter = csvUserIterator.next();
            encountersList.add(new Encounter(encounter.getId(), encounter.getName(), encounter.getHp(), encounter.getAttack(), encounter.getArmor()));
        }

        return encountersList;

    }

    @Override
    public void PrintEncountersList() {
        encountersList.forEach(System.out::println);
    }

    @Override
    public Encounter getRandomEncounter(List<Encounter> encountersList) {
        Random rand = new Random();

        int randomIndex = rand.nextInt(encountersList.size());

        return encountersList.get(randomIndex);
    }
}



