package general;

public class Test {
    private String[] arr = new String[]{"1", "2"};
    private String name = "avishay";

    public String getName() {
        return name;
    }

    public String[] getArr() {
        return arr.clone();
    }
}
