package optionals;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws IOException {
        Object value = Optional.ofNullable(null).orElseGet(() -> "default value");
        System.out.println(value);

        Supplier<IOException> ioExceptionSupplier = () -> new IOException("File is missing");
        Object error = Optional.ofNullable("default value").orElseThrow(ioExceptionSupplier);
        System.out.println(error);

        Consumer<Object> objectConsumer = msg-> System.out.println("Printing message :"+msg);
        Optional.ofNullable("Print me").ifPresent(objectConsumer);
        
        Optional.ofNullable(null).ifPresentOrElse(msg -> System.out.println("Printing message :" + msg), () -> {
            System.out.println("Cannot print message");
        });
    }
}
