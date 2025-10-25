package pl.piwowarski.flatMapDemo.streams.CategoriesProducts;

import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Category root = DataLoader.loadSampleData();

        System.out.println("All products in category: " + root.getName());
        getAllProducts(root).forEach(System.out::println);
    }

    public static Stream<String> getAllProducts(Category category) {
        return Stream.concat(category.getProducts().stream(),
                category.getSubcategories().stream()
                        .flatMap(Main::getAllProducts)
        );
    }
}
