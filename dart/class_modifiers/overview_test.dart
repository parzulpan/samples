import 'abs_vehicle.dart';
import 'base_vehicle.dart';
import 'final_vehicle.dart';
import 'interface_vehicle.dart';

void main(List<String> args) {
  // no class modifier
  // 若要允许不受限制地允许从任何库构造或子类型，请使用不带修饰符的 class 或者 mixin 声明

  // abstract
  // 若要定义不需要其整个接口的完整、具体实现的类，请使用 abstract 修饰符。
  // 如果希望抽象类看起来是可实例化的，请定义一个工厂构造函数。
  // ERROR: Cannot be constructed
  // AbsVehicle av = AbsVehicle();

  // base
  // 要强制继承类或 mixin 的实现，请使用 base 修饰符。基类不允许在其自己的库之外实现。这保证了：
  // 1. 每当创建类的子类型的实例时，都会调用基类构造函数。
  // 2. 所有已实现的私有成员都存在于子类型中。
  // 3. base 类中新实现的成员不会中断子类型，因为所有子类型都继承新成员。
  // Can be constructed
  var baseVehicle = BaseVehicle();
  print(baseVehicle);

  // interface
  // 若要定义接口，请使用 interface 修饰符。接口自己的定义库之外的库可以实现接口，但不能扩展它。
  // Can be constructed
  var interfaceVehicle = InterfaceVehicle();
  print(interfaceVehicle);

  // final
  // Can be constructed
  var finalVehicle = FinalVehicle();
  print(finalVehicle);

  // sealed
  // 若要创建一组已知的、可枚举的子类型，请使用 sealed 修饰符。这允许您创建这些子类型的切换，静态确保详尽无遗。

  // combining modifier
  // 可以组合一些修饰符以实现分层限制。类声明可以按顺序：
  // 1. abstract ，描述类是否可以包含抽象成员并阻止实例化。
  // 2. base 、 interface final 或 sealed 之一，描述对子类型化该类的其他库的限制。
  // 3. mixin ，描述声明是否可以混入。
  // 4. class 关键字本身。
  // 不能组合某些修饰符，因为它们是矛盾的、冗余的或相互排斥的：
  // 1. abstract 和 sealed 密封类始终是隐式抽象的。
  // 2. interface sealed 或 final mixin 这些访问修饰符可防止混入。
}

// --- abstract

// Can be extended
class Car1 extends AbsVehicle {
  int passengers = 4;

  @override
  void moveForward(int meters) {}
}

// Can be implemented
class MockVehicle1 implements AbsVehicle {
  @override
  void moveForward(int meters) {}
}

// abstract ---

// --- base

// Can be extended
base class Car2 extends BaseVehicle {
  int passengers = 4;
}

// // ERROR: Cannot be implemented
// base class MockVehicle2 implements BaseVehicle {
//   @override
//   void moveForward(int meters) {}
// }

// base ---

// --- interface
// ERROR: Cannot be inherited
// class Car3 extends InterfaceVehicle {
//   int passengers = 4;
// }

// Can be implemented
class MockVehicle3 implements InterfaceVehicle {
  @override
  void moveForward(int meters) {}
}

// interface ---

// --- final
// ERROR: Cannot be inherited
// class Car4 extends FinalVehicle {
//   int passengers = 4;
// }

// class MockVehicle4 implements FinalVehicle {
//   // ERROR: Cannot be implemented
//   @override
//   void moveForward(int meters) {
//     // ...
//   }
// }

// final ---