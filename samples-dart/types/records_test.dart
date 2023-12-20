void main(List<String> args) {
  // record 是一种匿名的不可变聚合类型，类似于 Map 和 List，但是 record 固定大小，组合更灵活，并且支持不同类型存储。

  // record syntax
  var record = ('first', a: 2, b: true, 'last');
  print(record);

  var record1 = (1, 2);
  var record2 = swap(record1);
  print(record1);
  print(record2);

  (String, int) record3;
  record3 = ('A string', 123);
  print(record3);

  ({int a, bool b}) record4;
  record4 = (a: 123, b: true);
  print(record4);

  ({int a, int b}) recordAB = (a: 1, b: 2);
  ({int x, int y}) recordXY = (x: 3, y: 4);
  // recordAB = recordXY; // error

  (int a, int b) recordAB1 = (1, 2);
  (int x, int y) recordXY1 = (3, 4);
  recordAB1 = recordXY1; // not error

  // record fields
  print(record.$1);
  print(record.$2);
  print(record.a);
  print(record.b);

  // record types
  (num, Object) pair = (42, 'a');
  var first = pair.$1; // Static type `num`, runtime type `int`.
  var second = pair.$2; // Static type `Object`, runtime type `String`.
  print(first.runtimeType);
  print(second.runtimeType);

  // record equality
  (int x, int y, int z) point = (1, 2, 3);
  (int r, int g, int b) color = (1, 2, 3);
  print(point == color); // true

  ({int x, int y, int z}) point1 = (x: 1, y: 2, z: 3);
  ({int r, int g, int b}) color1 = (r: 1, g: 2, b: 3);
  print(point1 == color1); // Prints 'false'. Lint: Equals on unrelated types.

  // Dart 中 (int x, int y, int z) point 和 ({int x, int y, int z}) point 的区别在于：
  /**
  (int x, int y, int z) point 使用的是 位置参数，而 ({int x, int y, int z}) point 使用的是 命名参数。
  (int x, int y, int z) point 的属性名是 x、y、z，而 ({int x, int y, int z}) point 的属性名可以自定义。

  位置参数 是指在函数或构造函数中，参数的顺序决定了属性名。例如，在 (int x, int y, int z) point 中，第一个参数 x 对应属性名 x，第二个参数 y 对应属性名 y，第三个参数 z 对应属性名 z。
  命名参数 是指在函数或构造函数中，参数的名字决定了属性名。例如，在 ({int x, int y, int z}) point 中，参数 x 对应属性名 x，参数 y 对应属性名 y，参数 z 对应属性名 z。
   */

  // multiple returns
  // 记录允许函数返回捆绑在一起的多个值
  final json = <String, dynamic>{'name': 'Dash', 'age': 10, 'color': 'blue'};
  (String, int) rt = userInfo(json);
  print(rt.$1);
  print(rt.$2);
  var (name, age) = userInfo(json);
  print(name);
  print(age);
}

(int, int) swap((int, int) record) {
  var (a, b) = record;
  return (b, a);
}

(String, int) userInfo(Map<String, dynamic> json) {
  return (json['name'] as String, json['age'] as int);
}
