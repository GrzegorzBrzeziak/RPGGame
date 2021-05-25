package pl.sda.repository;

import pl.sda.model.Location;

import java.util.List;

public interface LocationRepo {

    public List<Location> ReadLocationsFromCSV();

    public void PrintLocationList();

    public Location getRandomLocation();

}
