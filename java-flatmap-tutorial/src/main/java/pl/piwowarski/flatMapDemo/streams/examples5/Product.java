package pl.piwowarski.flatMapDemo.streams.examples5;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
