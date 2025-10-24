package pl.piwowarski.flatMapDemo.streams.examples3;

import java.util.List;
import java.util.stream.Collectors;

class Demo {
    public static void main(String[] args) {
        User john = new User("John", List.of());
        User jane = new User("Jane", List.of());
        User emma = new User("Emma", List.of(john, jane));
        User mike = new User("Mike", List.of(john));
        User lucas = new User("Lucas", List.of(emma, mike));

        List<User> users = List.of(john, jane, emma, mike, lucas);

        List<String> userNames = users.stream()
                .flatMap(user -> user.getFriends().stream())
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("userNames" + userNames);

        List<String> allFriendNames = users.stream()
                .map(User::getFriends)
                .flatMap(List::stream)
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("allFriendNames: ");
        allFriendNames.forEach(System.out::println);
    }
}
