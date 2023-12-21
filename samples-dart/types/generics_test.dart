void main(List<String> args) {
  var names = <String>[];
  names.addAll(['iterable', 'xxx']);
  // names.add(42); // error. List<String>
  print(names);

  // using collection literals
  var nameList = <String>['A', 'B', 'C'];
  var nameSet = <String>{'A', 'B', 'C'};
  var nameMap = <String, String>{'a': 'A', 'b': 'B', 'c': 'C'};
  print(nameList);
  print(nameSet);
  print(nameMap);

  // using parameterized types with constructors
  var nameSet1 = Set<String>.from(nameList);
  print(nameSet1);

  // generic colletions and the types they contain
  var nameList2 = <String>[];
  nameList2.addAll(['1', '2', '3']);
  print(names is List<String>);

  // restricting the parameterized type
  var someBaseClassFoo = Foo<SomeBaseClass>();
  print(someBaseClassFoo);
  var extenderFoo = Foo<Extender>();
  print(extenderFoo);

  // using generic methods
  print(first(nameList));
  var nameList3 = <int>[1, 2, 3];
  print(first(nameList3));
}

abstract class Cache<T> {
  T getByKey(String key);
  void setByKey(String key, T value);
}

class SomeBaseClass {
  //
}

class Foo<T extends Object> {
  //
}

class Foo1<T extends SomeBaseClass> {
  String toString() => "Instance of 'Foo1<$T>'";
}

class Extender extends SomeBaseClass {
  //
}

T first<T>(List<T> ts) {
  T tmp = ts[0];
  return tmp;
}
