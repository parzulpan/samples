import 'dart:ffi';

void main(List<String> args) {
  // initializing formal parameters
  Point p = Point(1, 2);
  print('${p.x} ${p.y}');

  // default constructors
  // 如果不声明构造函数，则为您提供默认构造函数。默认构造函数没有参数，并调用父类中的无参数构造函数。

  // constructors aren't inherited
  // 子类不继承父类的构造函数。没有声明构造函数的子类只有默认构造函数(没有参数，没有名称)。

  // named constructors
  Point1 p1 = Point1(2, 3);
  print('${p1.x} ${p1.y}');

  Point1 p11 = Point1.origin();
  print('${p11.x} ${p11.y}');

  // invoking a non-default superclass constructor
  // 构造函数执行顺序：1、初始化列表；2、超类的无参数构造函数；3、主类的无参数构造函数；
  Employee employee = Employee.fromJson({'a': 1, 'b': 2});
  print(employee);

  Vector2d vector2d = Vector2d(1, 2);
  print('${vector2d.x} ${vector2d.y}');

  Vector3d vector3d = Vector3d(11, 22, 33);
  print('${vector3d.x} ${vector3d.y} ${vector3d.z}');

  // 如果超类构造函数调用已经有位置参数，则超类初始化形参不能是位置形参，但它们总是可以命名的
  Vector2d vector2d2 = Vector2d.named(x: 11, y: 22);
  print('${vector2d2.x} ${vector2d2.y}');

  Vector3d vector3d2 = Vector3d.yzPlane(y: 222, z: 333);
  print('${vector3d2.x} ${vector3d2.y} ${vector3d2.z}');

  // initializer list
  Point2 point2 = Point2.fromJson({'x': 1, 'y': 2});
  print('${point2.x} ${point2.y}');

  // redirecting constructors
  // 有时构造函数的唯一目的是重定向到同一类中的另一个构造函数。重定向构造函数的主体为空，构造函数调用(使用this而不是类名)出现在冒号(:)之后。
  Point3 point3 = Point3.alongXAxis(3);
  print('${point3.x} ${point3.y}');

  // constant constructors
  // 如果你的类产生的对象永远不会改变，你可以让这些对象成为编译时常量。为此，定义一个const构造函数，并确保所有实例变量都是final。
  ImmutablePoint origin = ImmutablePoint.origin;
  print('${origin.x} ${origin.y}');

  ImmutablePoint immutablePoint = ImmutablePoint(1, 2);
  print('${immutablePoint.x} ${immutablePoint.y}');

  // factory constructors
  Logger logger = Logger('UI');
  logger.log('Button clicked');

  var logMap = {'name': 'UE'};
  var loggerJson = Logger.fromJson(logMap);
  loggerJson.log("xxx");
}

// --- initializing formal parameters

class Point {
  final double x;
  final double y;

  Point(this.x, this.y);
}

// initializing formal parameters ---

// --- named constructors

const double xOrigin = 1;
const double yOrigin = 1;

class Point1 {
  final double x;
  final double y;

  Point1(this.x, this.y);

  // named constructor
  Point1.origin()
      : x = xOrigin,
        y = yOrigin;
}

// named constructors ---

// --- invoking a non-default superclass constructor

class Person {
  String? firstName;

  Person.fromJson(Map data) {
    print('in Person $data');
  }
}

class Employee extends Person {
  Employee.fromJson(super.data) : super.fromJson() {
    print('in Employee');
  }
}

class Vector2d {
  final double x;
  final double y;

  Vector2d(this.x, this.y);

  // super-initializer
  Vector2d.named({required this.x, required this.y});
}

class Vector3d extends Vector2d {
  final double z;

  Vector3d(super.x, super.y, this.z);

  Vector3d.yzPlane({required super.y, required this.z}) : super.named(x: 0);
}

// invoking a non-default superclass constructor ---

// --- initializer list

class Point2 {
  final double x;
  final double y;

  Point2.fromJson(Map<String, double> json)
      : x = json['x']!,
        y = json['y']! {
    print('In Point.fromJson(): ($x, $y)');
  }
}

// initializer list ---

// --- redirecting constructors

class Point3 {
  double x, y;

  Point3(this.x, this.y);

  Point3.alongXAxis(double x) : this(x, 0);
}

// redirecting constructors ---

// --- constant constructors

class ImmutablePoint {
  static const ImmutablePoint origin = ImmutablePoint(0, 0);

  final double x, y;

  const ImmutablePoint(this.x, this.y);
}

// constant constructors ---

// --- factory constructors

class Logger {
  final String name;
  bool mute = false;

  static final Map<String, Logger> _cache = <String, Logger>{};

  factory Logger(String name) {
    return _cache.putIfAbsent(name, () => Logger._internal(name));
  }

  factory Logger.fromJson(Map<String, Object> json) {
    return Logger(json['name'].toString());
  }

  Logger._internal(this.name);

  void log(String msg) {
    if (!mute) {
      print(msg);
    }
  }
}

// factory constructors ---
