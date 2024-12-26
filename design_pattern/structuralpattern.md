# Structural Design Pattern
- [Adapter](#adapter)


## Adapter
- An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly. The main goal for this pattern is to convert an existing interface into another one the client expects.
- Adapter patterns involved three key component.
   - **Target Interface** -> Interface that client code understand and expect.
   - **Adaptee** -> Class or Interface you want to addapt on the target interface. Its existing Component with an InCompatiable interface
   - **Adapter**-> Implements the target interface and wraps an instance of Adaptee

### java library example
- Enumeration, and Iterator
