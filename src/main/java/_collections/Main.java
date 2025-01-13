package _collections;


import _Streams.Gender;
import entity.Person;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = getPersonListForTest();
        System.out.println("Before sorting: ");
        personList.forEach(System.out::println);
       // Collections.sort(personList,(p1, p2) -> p1.getAge() - p2.getAge());

        Comparator<Person> sortByAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        };
        Comparator<Person> sortByGender = Comparator.comparing(Person::getGender);
        Collections.sort(personList,sortByAge);
        Collections.sort(personList,sortByGender);
        System.out.println("After sorting: ");
        personList.forEach(System.out::println);
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
}
