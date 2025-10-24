package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Category tree = new Category("Electronics", List.of(
                new Category("Phones", List.of(
                        new Category("Android", List.of()),
                        new Category("iPhone", List.of())
                )),
                new Category("Laptops", List.of(
                        new Category("Gaming", List.of()),
                        new Category("Business", List.of())
                ))
        ));

        List<String> names = flatten(tree)
                .map(Category::getName)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    public static Stream<Category> flatten(Category category) {
        return Stream.concat(
                Stream.of(category),
                category.subCategories.stream()
                        .flatMap(Main::flatten)
        );
    }
}
