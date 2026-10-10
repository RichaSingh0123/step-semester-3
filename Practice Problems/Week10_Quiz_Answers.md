# Week 10 — Part B: Quiz Answer Key

1. **B** — `protected age` and `public getName()` are accessible in `Student`; `private name` is not directly accessible.
2. **C** — Diagram 3 attempts multiple class inheritance, which is invalid in a single-class-inheritance language.
3. **B** — Constructors execute from the top of the inheritance chain: `Person -> Employee -> Manager`.
4. **C** — A derived class can directly access a protected member. It cannot access private members or override a final method.
5. **B** — Dynamic dispatch invokes `Bus.fare()` for a `Bus` object.
6. **B** — Same method name with different parameter lists is overloading; redefining the same signature in a subclass is overriding.
7. **A** — A `Shape` reference directly exposes members declared in `Shape`, not `Circle`-specific members such as `radius`.
8. **C** — Runtime dispatch calls `Circle.area()` and `Square.area()` for their respective objects.
9. **B** — Casting a `Current` object to `Current` succeeds; casting it to sibling type `Savings` fails at runtime.
10. **B** — Polymorphism processes subtype objects through a common base reference without explicit type checks.
11. **A** — `printDocument()` is the public essential behavior; the buffer and internal helper methods are implementation details.
12. **B** — A `Vehicle` reference can refer to a `Car` object, but an abstract `Vehicle` cannot be instantiated directly.
13. **B** — A concrete subclass must implement inherited abstract methods or itself be abstract.
14. **B** — A concrete `MonthlyReport` that omits `generateBody()` causes a compilation error (unless it is declared abstract).
15. **A** — An interface specifies a contract; it does not define per-object instance state or require a particular implementation.
16. **B** — Interface methods are implicitly public and abstract when declared without a body; interface fields are public static final.
17. **C** — `DataProcessor` must implement both `serialize()` and `reset()` unless it is abstract.
18. **C** — An interface is suited to a common protocol for otherwise unrelated classes.
19. **B** — `Dog` IS-A `Animal` (generalization); `Eagle` CAN-DO `Flyable` (realization).
20. **A** — `equals()`, `hashCode()`, and `toString()` are common root-object methods in Java.
