# Structural Design Pattern
- [Adapter](#adapter)


## Adapter
- An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly. The main goal for this pattern is to convert an existing interface into another one the client expects.
- Adapter patterns involved three key component.
   - **Target Interface** -> Interface that client code understand and expect.
   - **Adaptee** -> Class or Interface you want to addapt on the target interface. Its existing Component with an InCompatiable interface. Adaptee class contains the main functionality that a client is expecting. 
   - **Adapter**-> Implements the target interface and wraps an instance of Adaptee to make it compitable with the target interface.
```
client--> ITarget(+Operation())<--------- Adapter(Operation())------------->Adaptee(+specific Operation())

ex. 1
 ClassA(Returning data in XML format)---->ClassB(Processing data) xml format------X----> thirdParty class (this need data in json)
 Note--> Communication between these ClassB and thrid party is not possible. to make it happens we need to include Adapter class
ClassA(Returning data in XML format)---->ClassB(Processing data) xml format<-----ClassC Adapter class convert XML to Json------------>thirdParty class (this need data in json)

ex. 2

Programmer-->IwindowsIntellij(windowsShortKey())-------X-->IMacIntellij(handleMacShortKey())
since windows user/programmer is only aware of shortcut of intellij running on windows machine, not on mac so he can not use shortcuts on Intellij running on mac. To make it compatiable we have to include adapter patter.
Programmer-->IwindowsIntellij(windowsShortKey())<------implements-----MacIntellijAdapter-----uses----->IMacIntellij(handleMacShortKey())

IwindowsIntellij ---> ITargetInterface
MacIntellijAdapter---> Adapter
IMacIntellij-----> Adaptee
Programmer--->Client.

refer MainclassAdapter.java file
```
### java library example
- Enumeration, and Iterator
