package pl.piwowarski.flatMapDemo.streams.examples3;

import java.util.List;

class User {
    String name;
    List<User> friends;

    User(String name, List<User> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() { return name; }
    public List<User> getFriends() { return friends; }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
