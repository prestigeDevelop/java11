package optionals;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    record Shape(int x,int y){};
    public static void main(String[] args) throws IOException {
        Object value = Optional.ofNullable(null).orElseGet(() -> "default value");
        System.out.println(value);
        System.out.println(new Shape(1,5));
        Supplier<IOException> ioExceptionSupplier = () -> new IOException("File is missing");
        Object error = Optional.ofNullable(getFile()).orElseThrow(ioExceptionSupplier);
        System.out.println(error);

        Consumer<Object> objectConsumer = msg-> System.out.println("Printing message :"+msg);
        Optional.ofNullable("Print me").ifPresent(objectConsumer);
        
        Optional.ofNullable(null).ifPresentOrElse(msg -> System.out.println("Printing message :" + msg), () -> {
            System.out.println("Cannot print message");
        });

        var numbers = List.of(1,2,3,4,5,6);
        numbers.stream().filter(num->num%2==0).map(n->n*2).forEach(System.out::println);

    }

    private static Object getFile() {
        return "text.txt";
    }
}
