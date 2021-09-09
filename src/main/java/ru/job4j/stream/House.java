package ru.job4j.stream;

public class House {
    private int age;
    private String address;
    private String owner;
    private String materialOfWall;
    private int price;
    private String discount;

    static class Builder {
        private int age;
        private String address;
        private String owner;
        private String materialOfWall;
        private int price;
        private String discount;

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildAddress(String address) {
            this.address = address;
            return this;
        }

        Builder buildMaterialOfWall(String materialOfWall) {
            this.materialOfWall = materialOfWall;
            return this;
        }

        Builder buildPrice(int price) {
            this.price = price;
            return this;
        }

        Builder buildOwner(String owner) {
            this.owner = owner;
            return this;
        }

        Builder buildDiscount(String discount) {
            this.discount = discount;
            return this;
        }

        House build() {
            House house = new House();
            house.age = age;
            house.address = address;
            house.owner = owner;
            house.materialOfWall = materialOfWall;
            house.price = price;
            house.discount = discount;
            return house;
        }

    }

    @Override
    public String toString() {
        return "Builder{"
                + "age=" + age
                + ", address='" + address + '\''
                + ", owner='" + owner + '\''
                + ", materialOfWall='" + materialOfWall + '\''
                + ", price=" + price
                + ", discount='" + discount + '\'' + '}';
    }

    public static void main(String[] args) {
        House home = new Builder().buildAge(10)
                .buildAddress("Barnaul, Lenina 12")
                .buildOwner("Elena Ivanova")
                .buildMaterialOfWall("Bricks")
                .buildPrice(2500000)
                .buildDiscount("10%")
                .build();
        System.out.println(home);
    }
}
