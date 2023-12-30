void main(List<String> args) {
  // Lists
  var list = [1, 2, 3];
  var list2 = ['Car', 'Boat', 'Plane'];
  assert(list.length == 3);
  assert(list[1] == 2);
  print(list);
  print(list2);
  list[1] = 1;
  assert(list[1] == 1);
  print(list);

  final list3 = const [1, 2, 3];
  // list3[1] = 1; // This line will cause an error. Cannot modify an unmodifiable list

  // Sets
  var set = {'a', 'c', 'b', 'd'};
  print(set);

  var names = <String>{}; // bet Set<String> names = {}

  var namesMap = {}; // Creates a map, not a set.

  var elements = <String>{};
  elements.add('ff');
  print(elements);
  elements.addAll(list2);
  print(elements);

  assert(elements.length == 4);

  final set2 = const {'ff', 'bb', 'cc'};
  print(set2);
  // set2.add('value'); // This line will cause an error.

  // Maps

  var gifts = {'first': 'pp', 'second': 'tt', 'fifth': 'gol'};
  print(gifts);
  var nobleGases = {2: 'xx', 10: 'aa'};
  print(nobleGases);

  gifts['first'] = 'gr';
  nobleGases[2] = '2';
  print(gifts);
  print(nobleGases);

  final constantMap = const {
    2: 'helium',
    10: 'neon',
    18: 'argon',
  };
  print(constantMap);

  // Spread operators
  var oList = [1, 2, 3];
  var oList2 = [0, ...oList];
  print(oList2);
  assert(oList2.length == 4);

  var oList3;
  // var oList4 = [0, ...oList3]; // type 'Null' is not a subtype of type 'Iterable<dynamic>'
  var oList4 = [0, ...?oList3];
  print(oList4);
  assert(oList4.length == 1);

  // Control-flow operators
  var nav = ['Home', 'GG', 'PP', if (true) 'xx'];
  print(nav);

  var nav2 = ['Home', 'xx', 'ss', if (false case '11') '22'];
  print(nav2);

  var listOfInts = [1, 2, 3];
  var listOfStrings = ['#0', for (var i in listOfInts) '#$i'];
  print(listOfStrings);
  assert(listOfStrings[1] == '#1');
}
