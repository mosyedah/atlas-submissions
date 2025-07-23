package fromExceptions;

public class Task014_InheritanceExample  {
    public static void main(String[] args) {
       Manager manager = new Manager("John Doe", 37, "Manager",2733822,2,"SDS");
       System.out.println(manager);
    }
}

class Person{
    String name;
    int age;
    Person(String name , int age){
        this.name = name;
        this.age = age;
    }
}
class Employee extends Person{
    String designation;
    int empID;
    Employee(String name, int age, String designation , int empID){
        super(name,age);
        this.designation = designation;
        this.empID = empID;
    }
}
class Manager extends Employee{
    int experienceYears;
    String team;
    Manager(String name, int age, String designation , int empID,int experienceYears, String team){
        super(name,age,designation,empID);
        this.experienceYears = experienceYears;
        this.team = team;
    }
    
    public String toString(){
       String res =  String.format(" Name :: %s, \n age :: %d \n designation ::  %s, \n empID : %d, \n exp ::  %d , \n team :: %s \n ", name, age, designation,empID,experienceYears,team);
       
       return res;
        }
}


