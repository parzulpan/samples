void main(List<String> args) {
  var name = 'Bob';
  Object name1 = 'Bob1';
  String name2 = 'Bob2';

  // null safety
  String? nameNullable;
  String nameNonNullable;

  // late variables
  late String description;
  description = 'Ge';
  print(description);

  // final and const
  final nameFinal = 'BobFinal';
  final String nickname = 'Bobby';
  const bar = 10000;
  const double atm = 1.01325 * bar;
  print(nameFinal);
  print(nickname);
  print(bar);
  print(atm);

  const Object i = 3;
  const list = [i as int];
  const map = {if (i is int) i: 'int'};
  const set = {if (list is List<int>) ...list};
  print(list);
  print(map);
  print(set);
}
