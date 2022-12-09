package _Streams;

import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Configuration
public class _Stream {


    //   static Predicate<String> validatePolicy=policy->{
//       return policy!=null && policy.trim().length()>2;
//   };
    static Function<Person, Gender> getGender = person -> person.getGender();
    static Function<Person, String> getNames = person -> person.getName();
    static Function<Person, Integer> getAge = person -> person.getAge();

    public static void printAll(List<Person> persons) {
        persons.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {

        List<Person> persons = getPersonListForTest();

        List<Person> persons1 = new ArrayList<>();
        persons1.stream().sorted(Comparator.comparing(Person::getName));
        Person ppp = persons.stream().filter(p -> p.age > 25).parallel().findAny().get();
        Short st = null;
        ppp.setStNumber(Optional.ofNullable(st).orElse((short) 0));
        //1. sort the list by last name
        Comparator<Person> sortByName = Comparator.comparing(Person::getName);
        //Comparator<Person> sortByName1= (p1,p2)->p1.getName().compareTo(p2.getName());
        persons.sort(sortByName);
        persons.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed());
        /// 2. print all
        printAll(persons);
        persons.stream().forEach(p -> System.out.println(p.getGender().get()));

        /// 2. print all names starts with J
        persons.stream().filter(p -> p.getName().startsWith("J")).forEach(p -> System.out.println(p.getName()));
        System.out.println(
                Stream.of("a", "b", "c")
                        .flatMap(s -> Stream.of(s + ".", s, s))
                        .collect(Collectors.toList())
        );
        int[] arr = {1, 5, 6};
        Set<Integer> set = IntStream.of(arr).boxed().collect(Collectors.toSet());

        persons.stream().map(person -> person.getAge()).collect(Collectors.toSet()).forEach(System.out::println);
        persons.stream().map(getNames).collect(Collectors.toSet()).forEach(System.out::println);
        OptionalDouble avg = persons.stream().mapToInt(Person::getAge).average();
        System.out.println("Average age is: " + avg.getAsDouble());
        int count = 0;
//       for(Person person:persons){
//           count +=person.getAge();
//       }
//        System.out.println(count);

        count = persons.stream().filter(p -> p.getAge() != null).mapToInt(p -> p.getAge()).sum();
        System.out.println(count);
        count = persons.stream().mapToInt(p -> p.getAge()).sum();
        System.out.println("line 44 " + count);
        String policy = "dasdasd";
        System.out.println(validatePolicy(policy, p -> p != null && p.trim().length() > 9));
        isNullOrEmpty(policy, p -> p != null && p.toString().length() > 0);
        persons.stream().filter(person -> person.getName().startsWith("A") && person.getName().length() > 3).collect(Collectors.toList()).forEach(x -> System.out.println(x.getName()));

    }

    //    private static boolean validatePolicy ( String policy ) {
//        return ( null != policy && policy.trim().length() > 2 );
//    }
    private static boolean validatePolicy(String policy, Predicate<String> policyTest) {
        return policyTest.test(policy);
    }

    private static boolean isNullOrEmpty(Object obj, Predicate<Object> tester) {
        return tester.test(obj);
    }

    static List<Person> getPersonListForTest() {
        return Arrays.asList(
                new Person("John", 50, Gender.MALE),
                new Person("Alice", 40, Gender.FEMALE),
                new Person("Becki", 30, Gender.FEMALE),
                new Person("Jack", 21, Gender.MALE),
                new Person("jo", 22, Gender.MALE),
                new Person("benni", 27, Gender.MALE),
                new Person("gigi", 29, Gender.FEMALE));
    }

    static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        private Integer age;
        private Gender gender;
        private short stNumber;

        public Person(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public short getStNumber() {
            return stNumber;
        }

        public void setStNumber(short stNumber) {

            this.stNumber = stNumber;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}
