void main(List<String> args) {
  // declaring simple enums
  // 所有枚举都会自动扩展类。它们也是密封的，这意味着它们不能被子类化、实现、混合或以其他方式显式实例化。
  // 抽象类和 mixin 可以显式实现或扩展，但除非它们随后由枚举声明实现或混合到枚举声明中，否则任何对象都无法实际实现该类或 mixin 的类型。
  // 若要声明简单的枚举类型，使用关键字 enum
  print(Color.red.name);
  print(Color.red.index);

  // declaring enhanced enums
  // 还允许枚举声明使用字段、方法和常量构造函数来声明类，这些类仅限于固定数量的已知常量实例。
  print(Vehicle.car.carbonPerKilometer);
  print(Vehicle.bus.carbonPerKilometer);
  print(Vehicle.bus.carbonFootprint);
  print(Vehicle.bicycle.isTwoWheeled);
  print(Vehicle.car.carbonFootprint);
  print(Vehicle.bus.carbonFootprint);
  print(Vehicle.car.compareTo(Vehicle.bus));

  // using enums
  // 像访问任何其他静态变量一样访问枚举值
}

// --- declaring simple enums

enum Color {
  red,
  green,
  blue;
}

// declaring simple enums ---

// --- declaring enhanced enums

enum Vehicle implements Comparable<Vehicle> {
  car(tires: 4, passengers: 5, carbonPerKilometer: 400),
  bus(tires: 6, passengers: 50, carbonPerKilometer: 800),
  bicycle(tires: 2, passengers: 1, carbonPerKilometer: 0);

  const Vehicle({
    required this.tires,
    required this.passengers,
    required this.carbonPerKilometer,
  });

  final int tires;
  final int passengers;
  final int carbonPerKilometer;

  int get carbonFootprint => (carbonPerKilometer / passengers).round();

  bool get isTwoWheeled => this == Vehicle.bicycle;

  @override
  int compareTo(Vehicle other) => carbonFootprint - other.carbonFootprint;
}

// declaring enhanced enums ---
