package _Streams;

import java.util.HashSet;
import java.util.Set;

public record EmployeeRecord(String name, int number){

        public String display() {


            return "Employee[name=" + name + ", number=" + number + "]";
        }
    }

