package lambdaAndStreams;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class _Streams {
    public static void main(String[] args) {
        String response = "{\n" +
                "    \"args\": {\n" +
                "        \"test\": \"123\"\n" +
                "    },\n" +
                "    \"headers\": {\n" +
                "        \"x-forwarded-proto\": \"https\",\n" +
                "        \"x-forwarded-port\": \" 443 \",\n" +
                "        \"host\": \"postman-echo.com 443 \",\n" +
                "        \"x-amzn-trace-id\": \"Root=1-61e9e641-2b5b4f7c0de25023027c8445\",\n" +
                "        \"user-agent\": \"PostmanRuntime/7.28.4 443 \",\n" +
                "        \"accept\": \"*/*\",\n" +
                "        \"cache-control\": \"no-cache\",\n" +
                "        \"postman-token\": \"7574cd18-4ea5-421f-b9f2-281d934ce5bd 443 443 443 \",\n" +
                "        \"accept-encoding\": \"gzip, deflate, br\"\n" +
                "    },\n" +
                "    \"url\": \"https://postman-echo.com/get?test=123 443 \"\n" +
                "}";


        String gg = extracted(response).orElseThrow(() -> new IllegalStateException("no version found"));
        System.out.println(gg);

        AtomicInteger counter = new AtomicInteger();
        String s = Arrays.stream(response.split("\n")).filter(line -> line.contains("postman-token"))
                .map(l -> {

                    if (l.contains("7574cd18")) {
                        counter.getAndIncrement();
                        return "8";
                    } else {
                        return "10";
                    }
                }).findFirst().get();

        // solution 2 
        Optional<String> result = null;
        if (Arrays.stream(response.split("\n")).filter(line -> line.contains("postman-token")).findAny().get().contains("7574cd18")) {
            result = Optional.of("7574cd18");
        }
        // System.out.println(count(response));
    }

    private static Optional<String> extracted(String response) {

        Optional<String> v8 = Arrays.stream(response.split("\n")).
                filter(line -> line.contains("x-forwarded-port")).
                map(m -> m.toLowerCase(Locale.ROOT)).
                map(e -> {
                    if (e.contains("4143t")) {
                        return "v10";
                    } else {
                        return "v8";
                    }
                }).findFirst();
        return v8;
    }

    public static AtomicInteger count(String response) {
        AtomicInteger counter = new AtomicInteger();

        Arrays.stream(response.split("\n")).
                filter(line -> line.contains("443"))
                .forEach(line -> {
                    Arrays.stream(line.split(" ")).forEach(word ->
                    {
                        if (word.equalsIgnoreCase("443")) {
                            counter.getAndIncrement();
                        }
                    });
                });
        return counter;
    }
}
