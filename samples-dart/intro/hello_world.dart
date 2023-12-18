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
