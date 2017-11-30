public class Employee {
   public String firstName;
   public String lastName;
  
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
     Employee e1 = new Employee("zhou","jielun");
     Employee e2 = new Employee("sun","yanzi");
     Employee e3 = new Employee("zhou","jieba");
     Employee e4 = new Employee("a","ya");
     Employee[] testData = new Employee[]{e2, e1, e3,e4};
     MultipleKeySorting mySort = new MultipleKeySorting();
     mySort.sort(testData);
     System.out.println(testData[0].lastName + " " + testData[0].firstName);
     System.out.println(testData[1].lastName + " " + testData[1].firstName);
     System.out.println(testData[2].lastName + " " + testData[2].firstName);
     System.out.println(testData[3].lastName + " " + testData[3].firstName);
    }
}

