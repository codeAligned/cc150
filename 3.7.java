An animal shelter holds only dogs and cats. "first in, first out"
People can only select oldest or oldest of a type
Create data structure to maintain the system and implement operations such as enqueue, dequeueAny, dequeueDog, dequeueCat

solutions:
1 maintain a single queue. This would make dequeueAny easy, but dequeueDog and dequeueCat would require iteration through
the queue and find the first dog or cat.

2 use separate queues for dogs and cats, and to place them within a wrapper class called AnimalQueue. Store timestamp to
mark when each animal was enqueued. For dequeueAny, we peek at the heads of both the dog and cat queue and return the oldest.

public abstract class Animal {
	private int order;
	protected String name;

	public Animal(String n) {
		this.name = n;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return order<a.getOrder();
	}
}


public class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

public class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}


public class AnimalQueue {
	Queue<Dog> dogs = new LinkedList<Dog>();
	Queue<Cat> cats = new LinkedList<Cat>();

	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Dog)
			dogs.addLast((Dog)a);
		else if(a instanceof Cat)
			cats.addLast((Cat)a);
	}

	public Animal dequeueAny() {
		if(dogs.size()==0)
			return dequeueCat();
		else if(cats.size()==0)
			return dequeueDog();

		Dog d = dogs.peek();
		Cat c = cats.peek();
		if(dog.isOlderThan(c))
			return dequeueDog();
		else
			return dequeueCat();
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}
}