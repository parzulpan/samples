import 'abs_vehicle.dart';
import 'base_vehicle.dart';

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
  // // Can be constructed
  var baseVehicle = BaseVehicle();

  // interface

  // final

  // sealed

  // combining modifier
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

