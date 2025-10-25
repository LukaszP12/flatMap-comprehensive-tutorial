package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

public class Department {
    String name;
    List<Team> teams;
    public Department(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams; }

    public String getName() {
        return name;
    }

    public List<Team> getTeams() { return teams; }

    @Override
    public String toString() {
        return name;
    }
}
