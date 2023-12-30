void main(List<String> args) {
  // arithmetic operators
  assert(2 + 3 == 5);
  assert(2 - 3 == -1);
  assert(2 * 3 == 6);
  assert(5 / 2 == 2.5);
  assert(5 ~/ 2 == 2);
  assert(5 % 2 == 1);

  assert('5/2 = ${5 ~/ 2} r ${5 % 2}' == '5/2 = 2 r 1');

  int a;
  int b;

  a = 0;
  b = ++a;
  assert(a == b);

  a = 0;
  b = a++;
  assert(a != b);

  a = 0;
  b = --a;
  assert(a == b);

  a = 0;
  b = a--;
  assert(a != b);

  // equality and relational operators
  assert(2 == 2);
  assert(2 != 3);
  assert(3 > 2);
  assert(2 < 3);
  assert(3 >= 3);
  assert(2 <= 3);

  // type test operators
  /**
   * as 类型转换（也用于指定库前缀）
   * is 如果对象具有指定类型，则为 True
   * is! 如果对象没有指定的类型，则为 True
   */

  // assignment operators
  var aa = 2;
  aa *= 3;
  assert(aa == 6);

  // logocal operators
  var done = false;
  var col = 3;
  if (!done && (col == 0 || col == 3)) {
    //
  }

  // bitwise and shift operators
  final value = 0x22;
  final bitmask = 0x0f;
  assert((value & bitmask) == 0x02); // AND
  assert((value & ~bitmask) == 0x20); // AND NOT
  assert((value | bitmask) == 0x2f); // OR
  assert((value ^ bitmask) == 0x2d); // XOR

  assert((value << 4) == 0x220); // Shift left
  assert((value >> 4) == 0x02); // Shift right

  // Shift right example that results in different behavior on web
  // because the operand value changes when masked to 32 bits:
  assert((-value >> 4) == -0x03);

  assert((value >>> 4) == 0x02); // Unsigned shift right
  assert((-value >>> 4) > 0); // Unsigned shift right

  // conditional expressions
  /**
   * 如果 条件 为 true，则计算 expr1（并且返回其值）； 否则，计算并返回 expr2 的值
   * condition ? expr1 : expr2
   * 
   * 如果 expr1 非空，则返回其值； 否则，计算并返回 expr2 的值
   * expr1 ?? expr2
   */

  // cascade notation
  /**
   * 
    var paint = Paint()
      ..color = Colors.black
      ..strokeCap = StrokeCap.round
      ..strokeWidth = 5.0;
      
    等价于

    var paint = Paint();
    paint.color = Colors.black;
    paint.strokeCap = StrokeCap.round;
    paint.strokeWidth = 5.0;

    ---

    querySelector('#confirm') // Get an object.
      ?..text = 'Confirm' // Use its members.
      ..classes.add('important')
      ..onClick.listen((e) => window.alert('Confirmed!'))
      ..scrollIntoView();

    等价于

    var button = querySelector('#confirm');
    button?.text = 'Confirm';
    button?.classes.add('important');
    button?.onClick.listen((e) => window.alert('Confirmed!'));
    button?.scrollIntoView();
   * 
   * 
   */
}
