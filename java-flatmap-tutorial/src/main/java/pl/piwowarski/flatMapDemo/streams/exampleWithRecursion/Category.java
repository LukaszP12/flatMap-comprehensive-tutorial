package pl.piwowarski.flatMapDemo.streams.exampleWithRecursion;

import java.util.List;

class Category {
    String name;
    List<Category> subCategories;

    Category(String name, List<Category> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }
    public List<Category> getSubCategories() {
        return subCategories;
    }
}
