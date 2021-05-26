package pl.sda.repository;

import pl.sda.model.Location;

import java.io.IOException;
import java.util.List;

public interface LocationRepo {

    public List<Location> ReadLocationsFromCSV() throws IOException;

    public void PrintLocationList(List<Location> locationList);

    public Location getRandomLocation(List<Location> locationList);

}
