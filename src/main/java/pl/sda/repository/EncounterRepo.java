package pl.sda.repository;

import pl.sda.model.Encounter;
import pl.sda.model.Location;

import java.util.List;

public interface EncounterRepo {
    public List<Encounter> ReadEncountersFromCSV();

    public void PrintEncountersList(List<Encounter> encountersList);

    public Encounter getRandomEncounter(List<Encounter> encountersList);
}
