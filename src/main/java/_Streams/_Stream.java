package _Streams;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("John", 20, Gender.MALE),
                new Person("Alice", 20, Gender.FEMALE),
                new Person("Becki", 20, Gender.FEMALE),
                new Person("Jack", 21, Gender.MALE));


        persons.stream().map(getGender).collect(Collectors.toSet()).forEach(System.out::println);
        persons.stream().map(getNames).collect(Collectors.toSet()).forEach(System.out::println);
        OptionalDouble avg=persons.stream().mapToInt(p->p.getAge()).average();
        System.out.println("Average age is: "+avg.getAsDouble());
        int count=0;
//       for(Person person:persons){
//           count +=person.getAge();
//       }
//        System.out.println(count);

        count=persons.stream().filter(p->p.getAge()!=null).mapToInt(p->p.getAge()).sum();
        System.out.println(count);
       count=persons.stream().mapToInt(p->p.getAge()).sum();
        System.out.println(count);
        String policy="dasdasd";
        validatePolicy.test(policy);
        persons.stream().filter(person->person.getName().startsWith("A") &&person.getName().length()>3 ).collect(Collectors.toList()).forEach(x -> System.out.println(x.getName()));
    }

    private static boolean validatePolicy ( String policy ) {
        return ( null != policy && policy.trim().length() > 2 );
    }
   static Predicate<String> validatePolicy=policy->{
       return policy!=null && policy.trim().length()>2;
   };
   static Function<Person,Gender> getGender= person->person.getGender();
    static Function<Person,String> getNames= person->person.getName();
    static Function<Person,Integer> getAge= person->person.getAge();

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
        public Person(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }



    }
}
