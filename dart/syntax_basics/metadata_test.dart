void main(List<String> args) {
  // 使用元数据提供有关代码的附加信息。元数据 注释以字符 @ 开头，后跟引用 编译时常量（例如 deprecated）或调用 常量构造函数。
  // 四个注释可用于所有 Dart 代码： @Deprecated、@deprecated、@override 和 @pragma
  // 元数据可以出现在库、类、typedef、类型参数之前， 构造函数、工厂、函数、字段、参数或变量 声明和进口或出口指令之前。
}

class Tv {
  @Deprecated('Use turnOn instead')
  void activate() {
    turnOn();
  }

  void turnOn() {}
}
