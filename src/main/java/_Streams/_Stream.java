package _Streams;

import entity.Person;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Configuration
public class _Stream {

private static Short test;

    public  Short getTest() {
        return test;
    }

    public void setTest(Short test) {
        this.test = test;
    }

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
       EmployeeRecord emp=new EmployeeRecord("avi",123);
        System.out.println(emp);
        Pattern number = null;
        //boolean v= number.matches("[0-9]{3}-[0-9]{4}");
        Pattern pppt = Pattern.compile("[0-9]{3}-[0-9]{4}");//. represents single character
        Matcher m = pppt.matcher("111-1111");
        boolean bbb = m.matches();
        boolean rert= Pattern.matches("[0-9]{3}-[0-9]{4}", "111-1111");
        BigDecimal cib=BigDecimal.ONE;
        System.out.println(String.format("big decimal %.2f  ",cib) );
        String qwe = "12345677889";

        System.out.println(qwe.substring(5));
        List<Person> persons = getPersonListForTest();
        Person ppp123 =new Person("test",null,Gender.MALE);

        Comparator<Person> c = Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed();
        Collections.sort(persons,c);
        //handle null
        persons.add(ppp123);
        persons.sort(Comparator.comparing(Person::getAge ,Comparator.nullsFirst(Comparator.naturalOrder())));
        Set<Integer> sffffffweere= new HashSet<>() ;

        String name=persons.stream().filter(p->p.getAge()!=null && p.getAge()==40).map(Person::getName).findFirst().orElse(null);
        boolean b=validatePolicy("Abc",s->s.toLowerCase(Locale.ROOT).contains("a"));
        List<Person> persons1 = new ArrayList<>();
        persons1.stream().sorted(Comparator.comparing(Person::getName));
        Person ppp = persons.stream().filter(p -> p.getAge() > 25).parallel().findAny().get();
        System.out.println(test);
        tryTosetLocalVariable(getPersonListForTest());
        Short st = null;
        System.out.println(test);
        ppp.setStNumber(Optional.ofNullable(st).orElse((short) 0));
        //1. sort the list by last name
        Comparator<Person> sortByName = Comparator.comparing(Person::getName);
        //Comparator<Person> sortByName1= (p1,p2)->p1.getName().compareTo(p2.getName());
        persons.sort(sortByName);
        persons.sort(Comparator.comparing(Person::getAge, Comparator.nullsFirst(Comparator.naturalOrder())).thenComparing(Person::getName).reversed());
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
        int[] resultArr = new int[0];
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
        Function<Integer,String> mapCity= age -> {
            if (age == 50){
            return  "New York";
             }else{
                return "";
            }

        };
       persons = getPersonListForTest().stream().map(per->{
          per.setCity(mapCity.apply(per.getAge()));

            return per;
        }).collect(Collectors.toList());

        System.out.println(persons);
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
          return new ArrayList<>(Arrays.asList(
                new Person("John", 50, Gender.MALE),
                new Person("Alice", 40, Gender.FEMALE),
                new Person("Becki", 30, Gender.FEMALE),
                new Person("Jack", 21, Gender.MALE),
                new Person("jo", 22, Gender.MALE),
                new Person("benni", 27, Gender.MALE),
                new Person("gigi", 29, Gender.FEMALE)));
    }

    private static void tryTosetLocalVariable(List<Person> list){
        for (Person p:list) {
            if(p.getAge()>40) {
                test= Short.valueOf("5");
                break;
            }
        };
    }

}
