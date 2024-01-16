import 'dart:math';

void main(List<String> args) {
  // instance methods
  // Instance methods on objects can access instance variables and this.
  Point p1 = Point(1, 2);
  Point p2 = Point(3, 4);
  var distanceTo = p1.distanceTo(p2);
  print(distanceTo);

  // operators
  final v = Vector(2, 3);
  final w = Vector(2, 2);
  assert(v + w == Vector(4, 5));
  assert(v - w == Vector(0, 1));

  // getters and setters
  var rect = Rectangle(3, 4, 20, 15);
  assert(rect.left == 3);
  rect.right = 12;
  assert(rect.left == -8);

  // abstract methods
  // 实例、getter 和 setter 方法可以是抽象的，定义一个接口，但将其实现留给其他类。抽象方法只能存在于抽象类或mixin中。
  EffectiveDoer effectiveDoer = EffectiveDoer();
  effectiveDoer.doSomething();
}

// --- instance methods

class Point {
  final double x;
  final double y;

  Point(this.x, this.y);

  double distanceTo(Point other) {
    var dx = x - other.x;
    var dy = y - other.y;

    return sqrt(dx * dx + dy * dy);
  }
}

// instance methods ---

// --- operators

class Vector {
  final int x, y;

  Vector(this.x, this.y);

  Vector operator +(Vector v) => Vector(x + v.x, y + v.y);
  Vector operator -(Vector v) => Vector(x - v.x, y - v.y);

  bool operator ==(Object other) =>
      other is Vector && x == other.x && y == other.y;
}

// operators ---

// --- getters and setters

class Rectangle {
  double left, top, width, height;

  Rectangle(this.left, this.top, this.width, this.height);

  double get right => left + width;
  set right(double value) => left = value - width;
  double get bottom => top + height;
  set bottom(double value) => top = value - height;
}

// getters and setters ---

// --- abstract methods

abstract class Doer {
  void doSomething();
}

class EffectiveDoer extends Doer {
  void doSomething() {
    print('EffectiveDoer');
  }
}

// abstract methods ---