Final
Variable: The value cannot be changed once initialized.
Method: The method cannot be overriden by a subclass.
Class: The class cannot be subclassed.


Finally
used in association with a try/catch block and guarantees that a section of code will be executed even if an exception
is thrown. It will be executed after the try/catch blocks, but before control transfers back to its origin.

Note: Finally will still get executed even there is return statement in the catch block. It will be executed before return
see example in cc150


finalize method
The automatic garbage collector calls the finalize() method just before actually destroying the object. A class can therefore
override the finalize() method from the Object class in order to define custom behavior during garbage collection.
protected void finalize() throws Throwable {
	/* Close open files, release resources*/
}



Overloading vs Overriding
Overloading describes when two methods have the same name but differ in the type or number of arguments.
public double computerArea(Circle c) {...}
public double computerArea（Square s) {...}

Overriding, however, occurs when a method shares the same name and function signature as another method in its super clas.
public abstract class Shape {
	public void printMe() {
		System.out.println("I am a shape");
	}
	public abstract double computeArea();
}

public class Circle extends Shape {
	private double rad = 5;
	public void printMe() {
		System.out.println("I am a circle.");
	}

	public double computeArea() {
		return rad * rad * 3.14;
	}
}


Collection Framework
ArrayList vs. Vector
A vector is similar to ArrayList except it is synchronized

LinkedList
LinkedList<String> myLinkedList = new LinkedList<String>();
myLinkedList.add("two");
myLinkedList.addFirst("one");
Iterator<String> iter = myLinkedList.iterator();
while(iter.hasNext())
	System.out.println(iter.next());


HashMap


Additional Questions: 1.4, 8.10, 16.3