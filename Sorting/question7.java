public class Employee {
   public String firstName;
   public String lastName;
   public int order;
  
   public Employee(String lastName, String firstName){
     this.firstName = firstName;
     this.lastName = lastName;
   }
}

import java.util.Comparator;
public class EmployeeComparator implements Comparator<Employee>{
    public int compare(Employee e1, Employee e2){
      int result = e1.lastName.compareToIgnoreCase(e2.lastName);
      if (result == 0) {
        result = e1.firstName.compareToIgnoreCase(e2.firstName);
      }
      if (result == 0) {
        if(e1.order < e2.order) {
          result = -1;
        }
        else {
          result = 1;
        }
      }
      return result;
  } 
}

import java.util.Arrays;

public class MultipleKeySorting {
   public Employee[] sort(Employee[] data) {
     Arrays.sort(data, new EmployeeComparator());
     return data;
   }  
  
   public static void main(String[] args) {
     Employee e1 = new Employee("zhou","jielun"); e1.order = 1;
     Employee e2 = new Employee("sun","yanzi");   e2.order = 2;
     Employee e3 = new Employee("zhou","jieba");  e3.order = 3;
     Employee e4 = new Employee("a","ya");        e4.order = 4;
     Employee e5 = new Employee("a","ya");        e5.order = 5;
     Employee[] testData = new Employee[]{e2, e5, e3,e4,e1};
     MultipleKeySorting mySort = new MultipleKeySorting();
     mySort.sort(testData);
     System.out.println(testData[0].lastName + " " + testData[0].firstName + " " + testData[0].order);
     System.out.println(testData[1].lastName + " " + testData[1].firstName + " " + testData[1].order);
     System.out.println(testData[2].lastName + " " + testData[2].firstName + " " + testData[2].order);
     System.out.println(testData[3].lastName + " " + testData[3].firstName + " " + testData[3].order);
     System.out.println(testData[4].lastName + " " + testData[4].firstName + " " + testData[4].order);
    }
}


