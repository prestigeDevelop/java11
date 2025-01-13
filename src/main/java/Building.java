class Building {
    Building() {
        System.out.println("Building");
    }

    Building(String name) {
        this();
        System.out.println("building:String Constructor " + name);
    }
}

class House extends Building {
    House() {
        System.out.println("House");
    }

    House(String name) {
        super("dummy");
        System.out.println("house: String Constructor " + name);
    }

    public static void main(String[] args) {
        new House("House");
    }
}
