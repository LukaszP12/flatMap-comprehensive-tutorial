package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

class Department {
    String name;
    List<Team> teams;
    Department(String name,List<Team> teams) {
        this.name = name;
        this.teams = teams; }
    List<Team> getTeams() { return teams; }

    @Override
    public String toString() {
        return name;
    }
}
