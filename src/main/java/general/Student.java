package general;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Student {

    Integer id;
    String name ;
    List<Integer> deptIds;
    //// All the departments with atleast two students
    public static void main(String[] args) {
        List<Student> studentList = studentInit();
        List<Department> departmentList =departmentInit();

       // findAllDepartmentsWithAtLeastTwoStudents(studentList, departmentList);
        countAllDepartmentsWithAtLeastTwoStudents(studentList, departmentList);
        Map<String, Integer> stringLength = new HashMap<>();
        long john = stringLength.computeIfAbsent("John", s -> s.length());
        john = stringLength.compute("John",(key, val)
                -> (val == null)
                ? 1
                : val + 1);


    }

    private static void findAllDepartmentsWithAtLeastTwoStudents(List<Student> studentList, List<Department> departmentList) {
        boolean[] hitMap= new boolean[6];
        for (Student student : studentList){
            for (Integer dep:student.getDeptIds()){
                if(hitMap[dep]==true) {
                    System.out.println(dep);
                }else {
                    if(departmentList.stream().anyMatch(dt->dt.getDepartmentId().equals(dep))){
                        hitMap[dep] = true;
                    }
                }
            }
        }
    }

    private static List<Student> studentInit(){
        List<Student> studentList = new ArrayList<>();
        List<Integer> deptIds = Arrays.asList(1,2,3);
        Student s1= new Student(101,"student1",deptIds);
        studentList.add(s1);
        deptIds = Arrays.asList(1,3);
        Student s2= new Student(102,"student2",deptIds);
        studentList.add(s2);
        deptIds = Arrays.asList(5);
        Student s3= new Student(103,"student3",deptIds);
        studentList.add(s3);
        deptIds = Arrays.asList(4);
        Student s4= new Student(104,"student4",deptIds);
        studentList.add(s4);
        deptIds = Arrays.asList(1,2,3,4);
        Student s5= new Student(105,"student5",deptIds);
        studentList.add(s5);
        return studentList;
    }
    private static List<Department> departmentInit() {
        List<Department> departmentList = new ArrayList<>();
        Department d1=new Department(1,"Math");//3
        Department d2=new Department(2,"English");//2
        Department d3=new Department(3,"Sience");//3
        Department d4=new Department(4,"Arts");//2
        Department d5=new Department(5,"Cinema");//1
        departmentList.add(d1);
        departmentList.add(d2);
        departmentList.add(d3);
        departmentList.add(d4);
        departmentList.add(d5);
        return departmentList;
    }
    private static void countAllDepartmentsWithAtLeastTwoStudents(List<Student> studentList, List<Department> departmentList) {
        Map<Integer,Integer> depCount = new HashMap<>();
        for (Student student : studentList){
            for (Integer dep:student.getDeptIds()){
                Integer key=dep;
                depCount.compute(key,(k,v)->(v==null)?1:v+1);
                }
            }
        }

}
//// All the departments with atleast two students
