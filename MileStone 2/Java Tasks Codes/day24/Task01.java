package day24;

public class Task01{

    // Product Interface
    interface Pizza {
        void prepare();
        void bake();
        void cut();
        void boxIt();
    }

    // Concrete Product: CheezyPizza
    static class CheezyPizza implements Pizza {
        @Override
        public void prepare() {
            System.out.println("Preparing Cheezy Pizza");
        }

        @Override
        public void bake() {
            System.out.println("Baking Cheezy Pizza");
        }

        @Override
        public void cut() {
            System.out.println("Cutting Cheezy Pizza");
        }

        @Override
        public void boxIt() {
            System.out.println("Boxing Cheezy Pizza");
        }
    }

    // Concrete Product: PepperoniPizza
    static class PepperoniPizza implements Pizza {
        @Override
        public void prepare() {
            System.out.println("Preparing Pepperoni Pizza");
        }

        @Override
        public void bake() {
            System.out.println("Baking Pepperoni Pizza");
        }

        @Override
        public void cut() {
            System.out.println("Cutting Pepperoni Pizza");
        }

        @Override
        public void boxIt() {
            System.out.println("Boxing Pepperoni Pizza");
        }
    }

    // Creator Abstract Class
    static abstract class PizzaFactory {
        public abstract Pizza createPizza();
    }

    // Concrete Creator: CheezyPizzaFactory
    static class CheezyPizzaFactory extends PizzaFactory {
        @Override
        public Pizza createPizza() {
            return new CheezyPizza();
        }
    }

    // Concrete Creator: PepperoniPizzaFactory
    static class PepperoniPizzaFactory extends PizzaFactory {
        @Override
        public Pizza createPizza() {
            return new PepperoniPizza();
        }
    }

    // Driver Method
    public static void main(String[] args) {
        PizzaFactory factory;

        factory = new CheezyPizzaFactory();
        Pizza pizza1 = factory.createPizza();
        pizza1.prepare();
        pizza1.bake();
        pizza1.cut();
        pizza1.boxIt();

        System.out.println("----");

        factory = new PepperoniPizzaFactory();
        Pizza pizza2 = factory.createPizza();
        pizza2.prepare();
        pizza2.bake();
        pizza2.cut();
        pizza2.boxIt();
    }
}

