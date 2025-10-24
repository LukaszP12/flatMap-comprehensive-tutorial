package pl.piwowarski.flatMapDemo.streams.examples5;

class OrderItem {
    Product product;

    OrderItem(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
