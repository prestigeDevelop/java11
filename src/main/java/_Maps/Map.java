package _Maps;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class _Map {


    private static Map<Integer, Double> marks = new HashMap();
    private static Map<Integer, List<Order>> orders = new HashMap();
    private static Map<String, String> storeToOpco = new HashMap<>();

    private static String getOpcoByStore() {
        return "STTP";
    }

    public static void main(String[] args) {
        List<Order> ordersList = List.of(
                new Order(152566, LocalDateTime.now(), 10, "Chicago"),
                new Order(152567, LocalDateTime.now(), 45, "New York"),
                new Order(152568, LocalDateTime.now(), 55, "Alaska"),
                new Order(1525669, LocalDateTime.now(), 66, "Berlin"));
        orders.put(1, ordersList);
        marks.put(100, 90.3);
        marks.put(99, 90.3);
        marks.put(98, 90.3);
        marks.put(66, 90.3);
        marks.put(85, 90.3);
        marks.put(40, 90.3);

        storeToOpco.put("GKB", "STSH");
        storeToOpco.put("AKB", "MRTN");
        storeToOpco.put("GDN", "STSH");
        String opco = storeToOpco.computeIfPresent("GKB", (key, val) -> val);
        String opco1 = storeToOpco.putIfAbsent("TTT", "PODE");

        String opco2 = storeToOpco.computeIfAbsent("PPP", (k) -> getOpcoByStore());
        opco2 = storeToOpco.computeIfAbsent("PPP", (k) -> getOpcoByStore());

// i don't want this line
        Double grade = marks.computeIfPresent(100, (key, val) -> val + 100);
        // print new mapping
        System.out.println("HashMap after operation :\n "
                + marks);
        marks.replace(40, 500.6);
        marks.values().stream().filter(item -> item > 100).forEach(System.out::println);
        marks.entrySet().stream().forEach(System.out::println);

        marks.compute(40, (k, v) -> (v == null) ? v - 1 : v + 1);
        //marks.computeIfAbsent(10,  (s -> s),50.36);
        System.out.println("HashMap after operation :\n " + marks);
        List<Order> r = orders.values().stream().flatMap(i -> i.stream().filter(k -> k.getItems() == 45)).collect(Collectors.toList());
        r.stream().forEach(i -> System.out.println(i));
        Order ordtyu = orders.values().stream().flatMap(i -> i.stream().filter(k -> k.getItems() == 45)).map(l -> {
            Order ord = new Order(123, l.getCreatedDate(), l.getItems(), l.getOrderLocation());
            return ord;
        }).findAny().orElse(null);
        System.out.println(ordtyu);
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today.toString());
    }
}
