package pl.sda.repository;

import pl.sda.model.Location;
import pl.sda.model.Player;

import java.io.IOException;
import java.util.List;

public interface LocationRepo {

    public List<Location> ReadLocationsFromCSV() throws IOException;

    public void PrintLocationList(List<Location> locationList);

    public Location getRandomLocationBoundedByPlayerLevel(List<Location> locationList, Player pLayer);

}
