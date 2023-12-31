void main(List<String> args) {
  // overriding members
  // 用于 extends 创建子类，并 super 引用超类
  // 子类可以覆盖实例方法（包括运算符）、getter 和 setter。可以使用注释 @override 来指示有意覆盖成员
  var television = Television();
  television.turnOn();

  var smartTelevision = SmartTelevision();
  smartTelevision.turnOn();

  // noSuchMethod()
  // 若要在代码尝试使用不存在的方法或实例变量时进行检测或响应，可以覆盖 noSuchMethod()
  var a = A();
}

// --- overriding members

class Television {
  void turnOn() {
    print('Television');
  }

  set contrast(int value) {}

  // ...
}

class SmartTelevision extends Television {
  void turnOn() {
    super.turnOn();
    print('SmartTelevision');
  }

  @override
  set contrast(num value) {}
}

// overriding members ---

// --- noSuchMethod()

class A {
  @override
  void noSuchMethod(Invocation invocation) {
    print('You tried to use a non-existent member: '
        '${invocation.memberName}');
  }
}

// noSuchMethod() ---