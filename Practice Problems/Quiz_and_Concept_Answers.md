# Week 8 Practice PDF — Quiz and Concept Answers

## Quiz Questions (multiple choice)
1. **C — Polymorphism.** A common TicketProcessor can interact with different event types uniformly.
2. **C — Encapsulation.** `dateOfBirth` is controlled through a validating method rather than direct access.
3. **C — Author 1 --- 1..* Book.** Each book has exactly one author; an author writes one or more books in the stated options.
4. **D — Composition.** CartItems have no independent lifecycle outside the cart.
5. **D — Generalization.** ProgrammingCourse is a specialized kind of Course.
6. **C — Realization.** PdfDocument implements the Printable contract.
7. **B — Association.** Customer and Order are related without strong lifecycle ownership.
8. **C — State diagram.** It models states and permitted transitions.
9. **B — Abstraction.** ReportGenerator hides report-specific implementation details.
10. **C — Sequence diagram.** It shows messages exchanged over time between objects.

## Concept Questions

### 1. Encapsulation in User email
The `email` field should be private and changed only through `changeEmail()`. That method validates format and uniqueness before updating the field. Direct public access could allow malformed or duplicate emails, leaving the object in an invalid state. Encapsulation keeps the data and its validation rules together.

### 2. Inheritance versus composition for reporting capabilities
Inheritance is useful when report types genuinely are specialized kinds of a common report and share stable behavior. Composition is better for optional capabilities such as export and visualization: a report can be given a `DataExport` or `DataVisualization` collaborator only when needed. Putting every capability in one inheritance hierarchy forces unrelated report types to inherit methods they do not need and makes adding features rigid.

### 3. Abstraction, overriding, and runtime polymorphism
Define a `Notification` interface or abstract class with a common send operation. Email, SMS, and push classes implement or override that operation. `NotificationService` accepts the abstraction and invokes `send()`; at runtime Java dispatches to the concrete implementation. Adding `InAppNotification` means adding another implementation, without rewriting the service's main workflow.

### 4. Composition versus aggregation
Organization–Department is composition because departments are described as being dissolved when the organization ceases to exist. Department–Employee is aggregation because employees can outlive a department and move to another one. The employee's lifecycle is not owned by one department.

### 5. Student–Course multiplicity and duplicate enrollment
Student and Course have a many-to-many association: a student can take many courses, and each course can have many students. Multiplicity expresses allowed counts, not uniqueness of a particular pair. Preventing duplicate enrollment needs an additional rule, such as a unique constraint on `(studentId, courseId)` or a check in enrollment logic.
