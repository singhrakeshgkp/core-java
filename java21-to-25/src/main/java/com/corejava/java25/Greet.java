void main() {
  System.out.println("hello world");  // OR
  IO.println("hello world using IO class");
// Read name using IO
  IO.println("Enter name");
  var name = IO.readln(); // instead of scanner we can use IO to read
  IO.println("Entered name is %s ".formatted(name));

}