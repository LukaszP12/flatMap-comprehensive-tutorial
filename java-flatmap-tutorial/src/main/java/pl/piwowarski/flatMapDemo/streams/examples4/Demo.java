package pl.piwowarski.flatMapDemo.streams.examples4;

import java.util.List;
import java.util.stream.Collectors;


class Demo {

    public static void main(String[] args) {
//        ✅ Example 2: Country → Cities → Streets
        List<Country> countries = List.of(
                new Country(List.of(
                        new City(List.of(new Street("1st Ave"), new Street("2nd Ave")))
                )),
                new Country(List.of(
                        new City(List.of(new Street("3rd Ave"), new Street("4th Ave")))
                ))
        );

        List<String> streets = countries.stream()
                .flatMap(country -> country.cities.stream())
                .flatMap(city -> city.streets.stream())
                .distinct()
                .map(Street::getName)
                .collect(Collectors.toList());
        System.out.println("streets");
        streets.forEach(System.out::println);
    }
}
