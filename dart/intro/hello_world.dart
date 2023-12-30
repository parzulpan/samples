import 'dart:io';

void main(List<String> args) {
  // hello
  print('hello world!');

  // variables
  var name = 'VV';
  var year = 1997;
  var antDiameter = 3.7;
  var flyByObjects = ['A', 'B', 'C', 'D'];
  var image = {
    'tags': ['s'],
    'url': '//path/ss.jpg'
  };
  print(name);
  print(year);
  print(antDiameter);
  print(flyByObjects);
  print(image);

  // control flow statements
  if (year >= 2001) {
    print('21st century');
  } else if (year >= 1901) {
    print('20th century');
  }

  flyByObjects.forEach((element) {
    print(element);
  });
  for (final obj in flyByObjects) {
    print(obj);
  }

  for (int month = 1; month <= 12; month++) {
    print(month);
  }

  while (year < 2016) {
    print(year);
    year += 1;
  }

  // functions
  var result = fib(20);
  print(result);

  flyByObjects.where((element) => (element.contains('A'))).forEach(print);

  // classes
  var vayager = Spacecraft('Voyager I', DateTime(1997, 9, 5));
  vayager.describe();
  var vayager3 = Spacecraft.unlaunched('Voyager III');
  vayager3.describe();

  // enums
  var yourPlanet = Planet.mercury;
  if (!yourPlanet.isGiant) {
    print('Your planet is not a "giant planet".');
  }

  // inheritance

  // mixins

  // interfaces and abstract classes

  // async

  // exception
  var astronauts = 0;
  if (astronauts == 0) {
    throw StateError('No astronauts.');
  }

  // important concepts
  /**
   * 1. Everything you can place in a variable is an object, and every object is an instance of a class. Even numbers, functions, and null are objects. With the exception of null (if you enable sound null safety), all objects inherit from the Object class.
   * 2. Although Dart is strongly typed, type annotations are optional because Dart can infer types. In var number = 101, number is inferred to be of type int.
   * 3. If you enable null safety, variables can’t contain null unless you say they can. You can make a variable nullable by putting a question mark (?) at the end of its type. For example, a variable of type int? might be an integer, or it might be null. If you know that an expression never evaluates to null but Dart disagrees, you can add ! to assert that it isn’t null (and to throw an exception if it is). An example: int x = nullableButNotNullInt!
   * 4. When you want to explicitly say that any type is allowed, use the type Object? (if you’ve enabled null safety), Object, or—if you must defer type checking until runtime—the special type dynamic.
   * 5. Dart supports generic types, like List<int> (a list of integers) or List<Object> (a list of objects of any type).
   * 6. Dart supports top-level functions (such as main()), as well as functions tied to a class or object (static and instance methods, respectively). You can also create functions within functions (nested or local functions).
   * 7. Similarly, Dart supports top-level variables, as well as variables tied to a class or object (static and instance variables). Instance variables are sometimes known as fields or properties.
   * 8. Unlike Java, Dart doesn’t have the keywords public, protected, and private. If an identifier starts with an underscore (_), it’s private to its library. For details, see Libraries and imports.
   * 9. Identifiers can start with a letter or underscore (_), followed by any combination of those characters plus digits.
   * 10. Dart has both expressions (which have runtime values) and statements (which don’t). For example, the conditional expression condition ? expr1 : expr2 has a value of expr1 or expr2. Compare that to an if-else statement, which has no value. A statement often contains one or more expressions, but an expression can’t directly contain a statement.
   * 11. Dart tools can report two kinds of problems: warnings and errors. Warnings are just indications that your code might not work, but they don’t prevent your program from executing. Errors can be either compile-time or run-time. A compile-time error prevents the code from executing at all; a run-time error results in an exception being raised while the code executes.
   * 
   */
}

int fib(int n) {
  if (n == 0 || n == 1) return n;
  return fib(n - 1) + fib(n - 2);
}

class Spacecraft {
  String name;
  DateTime? launchDate;

  int? get launchYear => launchDate?.year;

  Spacecraft(this.name, this.launchDate) {
    //
  }

  Spacecraft.unlaunched(String name) : this(name, null);

  void describe() {
    print('Spacecraft: $name');
    var launchDate = this.launchDate;
    if (launchDate != null) {
      int years = DateTime.now().difference(launchDate).inDays ~/ 365;
      print('Launched: $launchYear ($years years ago)');
    } else {
      print('Unlaunched');
    }
  }
}

enum PlanetType { terrestrial, gas, ice }

enum Planet {
  mercury(planetType: PlanetType.terrestrial, moons: 0, hasRings: false),
  venus(planetType: PlanetType.terrestrial, moons: 0, hasRings: false),
  // ···
  uranus(planetType: PlanetType.ice, moons: 27, hasRings: true),
  neptune(planetType: PlanetType.ice, moons: 14, hasRings: true);

  const Planet(
      {required this.planetType, required this.moons, required this.hasRings});

  final PlanetType planetType;
  final int moons;
  final bool hasRings;

  bool get isGiant =>
      planetType == PlanetType.gas || planetType == PlanetType.ice;
}

// Dart has single inheritance.
class Orbiter extends Spacecraft {
  double altitude;
  Orbiter(super.name, DateTime super.launchDate, this.altitude);
}

// Mixins are a way of reusing code in multiple class hierarchies
mixin Piloted {
  int astronauts = 1;

  void describeCrew() {
    print('Number of astronauts: $astronauts');
  }
}

// class PilotedCraft extends Spacecraft with Piloted {
//   // ...
// }

class MockSpaceshio implements Spacecraft {
  @override
  DateTime? launchDate;

  @override
  String name = 'MockSpaceshio';

  @override
  void describe() {
    // TODO: implement describe
  }

  @override
  // TODO: implement launchYear
  int? get launchYear => throw UnimplementedError();
}

abstract class Describable {
  void describe();

  void describeWithEmphasis() {
    print('=========');
    describe();
    print('=========');
  }
}

Future<void> createDescriptions(Iterable<String> objects) async {
  for (var object in objects) {
    try {
      var file = File('$object.txt');
      if (await file.exists()) {
        var modified = await file.lastModified();
        print('File for $object already exists. It was modified on $modified.');
        continue;
      }
      await file.create();
      await file.writeAsString('Start describing $object in this file.');
    } on IOException catch (e) {
      print('Cannot create description for $object: $e');
    }
  }
}
