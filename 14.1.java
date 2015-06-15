What is the effect of keeping a constructor private?

The only way to create an instance of class is to provie a static public method, as is done when using Factory Method pattern.
Additionally, because the constructor is private, the class cannot be inherited.