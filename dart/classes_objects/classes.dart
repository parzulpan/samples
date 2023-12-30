import 'dart:math';

void main(List<String> args) {
  // using class members
  // Objects have members consisting of functions and data (methods and instance variables, respectively). When you call a method, you invoke it on an object: the method has access to that object’s functions and data.
  // Use ?. instead of . to avoid an exception when the leftmost operand is null:
  var p1 = Point(2, 2);
  assert(p1.y == 2);

  var distanceTo = p1.distanceTo(Point(4, 4));
  print(distanceTo);

  var p2 = null;
  var y = p2?.y;
  print(y);

  // using constructors
  // You can create an object using a constructor. Constructor names can be either ClassName or ClassName.identifier.

  // getting an object's type
  print('the type of a is ${p1.runtimeType}');

  // instance variables
  var point1 = Point1();
  point1.x = 2;
  print(point1.x);
  print(point1.y);
  print(point1.z);

  var profileMark = ProfileMark("mark");
  print(profileMark.name);
  print(profileMark.start);

  // implicit interfaces
  print(greetBob(Person('pan')));
  print(greetBob(Impostor()));

  // static variables
  assert(Queue.initialCapacity == 16);

  // static methods
  var a = PointStatic(2, 2);
  var b = PointStatic(4, 4);
  var ans = PointStatic.distanceTo(a, b);
  print(ans);
}

// --- using class members

class Point {
  var x;
  var y;

  Point(this.x, this.y) {}

  double distanceTo(Point p) {
    return sqrt(pow(x - p.x, 2) + pow(y - p.y, 2));
  }
}

// using class members ---

// --- instance variables

class Point1 {
  double? x;
  double? y;
  double z = 0;
}

class ProfileMark {
  final String name;
  final DateTime start = DateTime.now();

  ProfileMark(this.name);
  ProfileMark.unnamed() : name = '';
}

// instance variables ---

// --- implicit interfaces

class Person {
  final String _name;

  Person(this._name);

  String greet(String who) => 'Hello, $who. I am $_name';
}

class Impostor implements Person {
  @override
  String get _name => '';

  @override
  String greet(String who) => 'Hi $who. Do you know who I am?';
}

String greetBob(Person person) => person.greet('Bob');

// implicit interfaces ---

// --- static variables

class Queue {
  static const initialCapacity = 16;
}

// static variables ---

// --- static methods

class PointStatic {
  double x, y;
  PointStatic(this.x, this.y);

  static double distanceTo(PointStatic a, PointStatic b) {
    return sqrt(pow(a.x - b.x, 2) + pow(a.x - b.y, 2));
  }
}

// static methods ---