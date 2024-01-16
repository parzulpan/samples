import '../common/my_fancy_list.dart';
import '../common/string_apis.dart';

void main(List<String> args) {
  // overview
  print(int.parse('42'));
  print('43'.parseInt());
  print('43'.padLeft(5));

  // using extension methods
  // 不能对 类型的 dynamic 变量调用扩展方法，
  // 原因是：扩展方法是针对接收器的静态类型解析的。由于扩展方法是静态解析的，因此它们与调用静态函数一样快。
  dynamic d = '2';
  // print(d.parseInt());
  // 适用于 Dart 的类型推断
  var v = '2';
  print(v.parseInt());

  // 如果扩展成员与接口或其他扩展成员冲突，则有几个选项：
  // 1. 一种选择是更改导入冲突扩展的方式，使用 show 或 hide 限制公开的 API
  /**
   * import 'string_apis.dart';
   * import 'string_apis_2.dart' hide NumberParsing2;
   */
  // 2. 显式应用扩展
  /**
   * import 'string_apis.dart';
   * import 'string_apis_3.dart' as rad;
   * print(NumberParsing('42').parseInt());
   * print(rad.NumberParsing('42').parseInt());
   */

  // implementing extension methods
  // 扩展的成员可以是方法、getter、setter 或运算符。
  // 扩展还可以具有静态字段和静态帮助程序方法。若要访问扩展声明外部的静态成员，请通过声明名称（如类变量和方法）调用它们。
  // 使用以下语法创建扩展：
  /**
   * extension <extension name>? on <type> {
       (<member definition>)*
     }
   */
  print(NumberParsing('42').parseInt());

  // implementing generic extensions
  // 扩展可以具有泛型类型参数
  List<String> list = <String>["1,2", "3,4,5", "6,7,8,9"];
  print(list);
  print(-list);
  print(list.length);
  print(list.doubleLength);
  print(list.split(1));
}
