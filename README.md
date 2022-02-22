# Dependency Injection in Android

# Intro
A self-explanatory proof of concept of Dependency Injection in Android development.

It is one of the 5 SOLID software design principles. The ultimate goal is to improve the reusability of code.
It also aim to reduce the frequency with which you need to change a class. Dependency injection supports these goals by decoupling the creation of the usage of an object.
That enables you to replace dependencies without changing the class that uses them.
It also reduces the risk that you have to change a class just because one of its dependencies changed.

# Technique
You can introduce interfaces to break the dependencies between higher and lower level classes.
If you do that, both classes depend on the interface and no longer on each other.

# Goal
The goal of the dependency injection technique is to remove this dependency by separating the usage from the creation of the object. 
This reduces the amount of required boilerplate code and improves flexibility.
