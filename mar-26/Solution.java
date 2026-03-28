interface Animal{
  public void show();
}
// abstract class Animal{
//   abstract void show();
// }
// class car extends Animal{
//   void show(){
//     System.out.print("Hello");
//   }
// }

class Dog implements Animal{
  public void show(){
     System.out.print("Hello");
  }
}
public class Solution{
public static void main(String[] args){
  Animal a = new Dog();
  a.show();
  String s = "Hello";
s.concat(" World"); // Does not change original
System.out.println("String: "+s+" "+s.concat(" World"));
}}