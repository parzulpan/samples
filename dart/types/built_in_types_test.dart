void main(List<String> args) {
  // Numbers
  var x = 1;
  var hex = 0xDEADBEEF;
  print(x);
  print(hex);

  var y = 1.1;
  var exponents = 1.42e5;
  print(y);
  print(exponents);

  num x1 = 1;
  x1 += 2.5;
  print(x1);

  double z = 1;
  print(z);

  var one = int.parse('1'); // String -> int
  assert(one == 1);

  var onePointOne = double.parse('1.1'); // String -> double
  assert(onePointOne == 1.1);

  String oneAsString = 1.toString(); // int -> String
  assert(oneAsString == '1');

  String piAsString = 3.14159.toStringAsFixed(2); // double -> String
  assert(piAsString == '3.14');

  assert((3 << 1) == 6); // 0011 << 1 == 0110
  assert((3 | 4) == 7); // 0011 | 0100 == 0111
  assert((3 & 4) == 0); // 0011 & 0100 == 0000

  const msPerSecond = 1000;
  const secondsUntilRetry = 5;
  const msUntilRetry = secondsUntilRetry * msPerSecond;
  print(msUntilRetry);

  // Strings
  var s1 = 'Single quotes work well for string literals.';
  var s2 = "Double quotes work just as well.";
  var s3 = 'It\'s easy to escape the string delimiter.';
  var s4 = "It's even easier to use the other delimiter.";
  print(s1);
  print(s2);
  print(s3);
  print(s4);

  var s = 'string interpolation';
  assert('Dart has $s, which is very handy.' ==
      'Dart has string interpolation, '
          'which is very handy.');
  assert('That deserves all caps. '
          '${s.toUpperCase()} is very handy!' ==
      'That deserves all caps. '
          'STRING INTERPOLATION is very handy!');

  var s11 = 'String '
      'concatenation'
      " works even over line breaks.";
  assert(s11 ==
      'String concatenation works even over '
          'line breaks.');

  var s22 = 'The + operator ' + 'works, as well.';
  assert(s22 == 'The + operator works, as well.');

  // Booleans
  var fullName = '';
  assert(fullName.isEmpty);

  var hitPoints = 0;
  assert(hitPoints <= 0);

  var unicorn = null;
  assert(unicorn == null);

  var iMeantToDoThis = 0 / 0;
  assert(iMeantToDoThis.isNaN);

  // Runes and grapheme clusters
  var hi = 'Hi 🇩🇰';
  print(hi);
  print('The end of the string: ${hi.substring(hi.length - 1)}');

  // Symbols
}
