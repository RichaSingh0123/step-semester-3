# Week 10 — Part C: Concept Answers

## 1. Method overloading vs. overriding
**Overloading** means declaring methods with the same name but different parameter lists, usually in the same class. The compiler selects the overload at compile time. **Overriding** means a subclass supplies a new implementation with the same signature as an inherited instance method. The implementation is selected at runtime according to the actual object's type.

## 2. Constructor invocation
When a derived object is created, the base-class constructor runs before the derived-class constructor. For `Manager extends Employee extends Person`, the order is `Person`, `Employee`, then `Manager`. In Java, a derived constructor passes values to its direct base constructor using `super(arguments)` as the first constructor statement.

## 3. Concrete classes, abstract classes, and interfaces
A **concrete class** can be instantiated and can hold state and implemented behavior. An **abstract class** cannot be instantiated directly; it can hold instance fields, constructors, concrete methods, and abstract methods. An **interface** defines a contract that classes can implement, making it useful for common capabilities across unrelated classes. Use concrete classes for complete objects, abstract classes for shared base state/behavior, and interfaces for capabilities or protocols.

## 4. Same abstract method in two interfaces
If two interfaces declare an abstract method with the same signature, one compatible public implementation in the implementing class satisfies both contracts. This demonstrates that a class can implement multiple interfaces and provide one implementation for a shared operation. If the signatures or return types conflict incompatibly, the class must resolve the conflict or compilation fails.

## 5. `equals()` and `hashCode()`
When defining content equality, override `equals()` to compare the relevant fields and `hashCode()` consistently so equal objects produce the same hash code. Hash-based collections use hash codes to locate buckets and `equals()` to distinguish entries. If `equals()` is overridden but `hashCode()` is not, logically equal objects may be placed in different buckets, causing failed lookups or duplicate entries.

## 6. Shallow copy vs. deep copy
A shallow copy duplicates the outer object but shares references to nested mutable objects. If two copied shopping-cart objects share the same mutable item list, changing the list through one cart also changes what the other sees. A deep copy recursively copies the nested mutable objects so the copies can be changed independently.

## 7. Inner class vs. static nested class
A non-static **inner class** is associated with an instance of its enclosing class, can access that instance's members (including private members), and normally needs an enclosing object to be instantiated. A **static nested class** does not require an enclosing instance and can directly access only static members of the enclosing class. Use an inner class when it needs the outer object's state; use a static nested class for a helper type logically grouped with the outer class but independent of a particular outer instance.

## 8. Array operation complexity
Accessing an array element by index is **O(1)** because the address is computed directly from the base address and index. Inserting or deleting in the middle of a fixed-size array is **O(n)** because later elements must be shifted to make room or fill the gap. A fixed-size array also cannot grow without creating a different array.

## 9. Processing derived objects through a base reference
An array of a base type can store instances of its subclasses. A loop can call an overridden method through each base-type reference, and dynamic dispatch invokes the implementation belonging to each object's runtime type. This allows uniform processing without a chain of explicit type checks.

## 10. IS-A vs. CAN-DO
Use inheritance for an **IS-A** relationship, where a subtype can be treated as a specialized form of its base type (for example, `Bus` is a `Vehicle`). Use an interface for a **CAN-DO** capability that may apply to unrelated classes. For example, `Bird` and `Drone` could both implement `Flyable` without one inheriting from the other.
