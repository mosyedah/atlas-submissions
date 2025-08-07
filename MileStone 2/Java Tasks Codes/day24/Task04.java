package day24;

public class Task04 {

    // Base class
    abstract class HumanBeing {
        private String name;
        public String type;

        public void walk() {
            System.out.println("HumanBeing walking");
        }

        public void see() {
            System.out.println("HumanBeing seeing");
        }

        public void talk() {
            System.out.println("HumanBeing talking");
        }
    }

    // SpiderMan class extends HumanBeing
    class SpiderMan extends HumanBeing {
        public void crawling() {
            System.out.println("SpiderMan crawling");
        }

        public void throwingWeb() {
            System.out.println("SpiderMan throwing web");
        }

        public Object clone() {
            return new SpiderMan();
        }
    }

    // Batman class extends HumanBeing
    class BatMan extends HumanBeing {
        public void superDooperRich() {
            System.out.println("BatMan is super dooper rich");
        }

        public void smart() {
            System.out.println("BatMan is smart");
        }

        public void kindHearted() {
            System.out.println("BatMan is kind-hearted");
        }

        public Object clone() {
            return new BatMan();
        }
    }

    // IronMan class extends HumanBeing
    class IronMan extends HumanBeing {
        public void fly() {
            System.out.println("IronMan flying");
        }

        public void intelligent() {
            System.out.println("IronMan is intelligent");
        }

        public void fireshots() {
            System.out.println("IronMan firing shots");
        }

        public void defendhimself() {
            System.out.println("IronMan defending himself");
        }

        public Object clone() {
            return new IronMan();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Task04 task = new Task04();

        SpiderMan spidey = task.new SpiderMan();
        spidey.walk();
        spidey.throwingWeb();

        BatMan batman = task.new BatMan();
        batman.superDooperRich();
        batman.kindHearted();

        IronMan tony = task.new IronMan();
        tony.fly();
        tony.fireshots();
    }
}
