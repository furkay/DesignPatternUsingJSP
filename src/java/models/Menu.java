package models;

public class Menu {
    private Dessert dessert;
    private Drink drink;
    private Meal meal;

    public Dessert getDessert() {
        return dessert;
    }
    public Drink getDrink() {
        return drink;
    }
    public Meal getMeal() {
        return meal;
    }
    public Menu(Builder builder) {
        this.dessert = builder.dessert;
        this.drink = builder.drink;
        this.meal = builder.meal;
    }
    public static class Builder {
        private Dessert dessert;
        private Drink drink;
        private Meal meal;
        public Builder dessert(Dessert dessert) {
            this.dessert = dessert;
            return this;
        }
        public Builder drink(Drink drink) {
            this.drink = drink;
            return this;
        }
        public Builder meal(Meal meal) {
            this.meal = meal;
            return this;
        }
        public Menu build() {
            return new Menu(this);
        }
    }
}
