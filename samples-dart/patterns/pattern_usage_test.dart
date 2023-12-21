import '../types/records_test.dart';

void main(List<String> args) {
  // Patterns 是 Dart 语言中的语法类别，就像语句和表达式一样。Patterns 表示一组值的形状，它可以与实际值相匹配。
  // 在 Dart 中，patterns 允许你在多种场景中，如 switch 语句、if 语句、或者变量赋值时，根据对象的结构和属性进行匹配和提取值

  // what patterns do
  var number = 1;
  switch (number) {
    case 1:
      print('one');
  }

  const a = 'a';
  const b = 'b';
  var obj = [a, b];
  switch (obj) {
    case [a, b]:
      print('$a, $b');
  }

  var numList = [1, 2, 3];
  var [x, y, z] = numList;
  print(x + y + z);

  // places patterns can appear
  var (aa, [bb, cc]) = ('str', [1, 2]);
  print(aa);
  print(bb);
  print(cc);

  var (a1, b1) = ('left', 'right');
  print('$a1 $b1');
  (b1, a1) = (a1, b1);
  print('$a1 $b1');

  Map<String, int> hist = {'a': 23, 'b': 100};
  for (var MapEntry(key: key, value: count) in hist.entries) {
    print('$key occurred $count times');
  }

  // use cases for patterns
  // 解构多重回报
  final json = <String, dynamic>{'name': 'Dash', 'age': 10, 'color': 'blue'};
  var info = userInfo(json);
  var name = info.$1;
  var age = info.$2;
  print('$name $age');
  var (name1, age1) = userInfo(json);
  print('$name1 $age1');

  // 解构类实例
}
