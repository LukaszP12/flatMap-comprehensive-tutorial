package pl.piwowarski.flatMapDemo.streams.CategoriesProducts;

import java.util.List;

class Category {
    private String name;
    private List<String> products;
    private List<Category> subcategories;

    public Category(String name, List<String> products, List<Category> subcategories) {
        this.name = name;
        this.products = products;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public List<String> getProducts() {
        return products;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        return name;
    }
}
