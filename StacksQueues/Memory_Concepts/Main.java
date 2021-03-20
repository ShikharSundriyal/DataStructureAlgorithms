import java.util.*;

//Memory Concepts
public class Main{
    
    public static class Person{
        String name;
        int age;
        
        public void saysHi(){
            System.out.println(name + "[" + age + "]" + "saysHi");
        }
    }
    
    public static void main(String[] args){
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();
        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.saysHi();
        swap3(p1,p2);
        p1.saysHi();
        p2.saysHi();
    }
    
    public static void swap(Person p1, Person p2){
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
    
    public static void swap1(Person p1, Person p2){
        int temp = p1.age;
        p1.age = p2.age;
        p2.age = temp;
        
        String t = p1.name;
        p1.name = p2.name;
        p2.name = t;
    }
    
    public static void swap2(Person a1, Person a2){
        int temp = a1.age;
        a1.age = a2.age;
        a2.age = temp;
        
        a1 = new Person();
        String t = a1.name;
        a1.name = a2.name;
        a2.name = t;
    }
    
    public static void swap3(Person a1, Person a2){
        a2 = new Person();
        int temp = a1.age;
        a1.age = a2.age;
        a2.age = temp;
        
        a1 = new Person();
        String t = a1.name;
        a1.name = a2.name;
        a2.name = t;
		//A 0 b20 
    }
    
    public static void swap4(Person a1, Person a2){
        a2 = new Person();
        int temp = a1.age;
        a1.age = a2.age;
        a2.age = temp;
        
        String t = a1.name;
        a1.name = a2.name;
        a2.name = t;
        a1 = new Person();
		//NULL 0 b 20
    }
    
    public static void swap5(Person a1, Person a2){
       
        int temp = a1.age;
        a1.age = a2.age;
        a2 = new Person();
        a2.age = temp;
        
        String t = a1.name;
        a1.name = a2.name;
        a2.name = t;
        a1 = new Person();
		// null 20, B 20
    }
    
}