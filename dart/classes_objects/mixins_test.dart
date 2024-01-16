void main(List<String> args) {
  // Mixins 是 Dart 语言中一个非常强大的特性，它们提供了一种灵活的方式来重用代码，同时避免了传统多重继承可能带来的复杂性和问题。
  //通过使用 Mixins，你可以构建出功能丰富、高度模块化的 Dart 程序。

  // Dart 的 Mixins 是一种在多个类层次结构中重用类代码的方法，而无需传统的继承。
  // 它们是一种在多个类之间共享行为的方式，而不需要继承这些类。
  // Mixins 允许你将多个类的代码组合到一个类中，但与多重继承不同，Mixins 有自己的特殊规则和限制。

  // 要使用 Mixins，你可以创建一个或多个普通的 Dart 类（不继承其他类），然后使用 with 关键字将它们混入另一个类。这里有一些关键点：
  /**
   * 1. Mixins 使用 with 关键字混入。
   * 2. 一个 Mixin 可以使用所有的对象方法，但不能声明构造函数。
   * 3. 一个类可以混入多个 Mixins。
   * 4. Mixins 可以使用 on 关键字来指定它们可以混入哪些类。
   */
  var advancedClass = AdvancedClass();
  advancedClass.doSomething();
  advancedClass.advancedAction();
}

// 定义一个 Mixin，它提供了一个工具方法
mixin Utilities {
  String encode(String data) {
    return 'encoded $data';
  }

  String decode(String data) {
    return 'decoded $data';
  }
}

// 另一个 =Mixin，提供日志功能
mixin Logger {
  void log(String msg) {
    print('Log: $msg');
  }
}

// 定义一个基类
class BaseClass {
  void doSomething() {
    print('Doing something in the BaseClass');
  }
}

// 使用 Mixins 创建一个新类
// 该类使用了 Utilities 和 Logger 的功能
class AdvancedClass extends BaseClass with Utilities, Logger {
  void advancedAction() {
    log(encode('Advanced Action'));
  }
}
