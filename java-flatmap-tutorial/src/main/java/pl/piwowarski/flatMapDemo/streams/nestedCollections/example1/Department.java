package pl.piwowarski.flatMapDemo.streams.nestedCollections.example1;

import java.util.List;

class Department {
    List<Team> teams;
    Department(List<Team> teams) { this.teams = teams; }
    List<Team> getTeams() { return teams; }
}
