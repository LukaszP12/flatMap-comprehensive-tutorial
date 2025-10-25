package pl.piwowarski.flatMapDemo.streams.CategoriesProducts;

import java.util.List;

class DataLoader {
    public static Category loadSampleData() {
        Category laptops = new Category(
                "Laptops",
                List.of("MacBook Air", "Dell XPS", "Lenovo ThinkPad"),
                List.of()
        );

        Category desktops = new Category(
                "Desktops",
                List.of("HP Envy Desktop"),
                List.of()
        );

        Category computers = new Category(
                "Computers",
                List.of(),
                List.of(laptops, desktops)
        );


        Category phones = new Category(
                "Phones",
                List.of("iPhone 14", "Samsung Galaxy S22"),
                List.of()
        );

        Category electronics = new Category(
                "Electronics",
                List.of(),
                List.of(computers, phones)
        );

        return electronics;
    }
}
