bool topLevel = true;

void main(List<String> args) {
  // named parameters
  // Named parameters are optional unless they’re explicitly marked as required.
  enableFlags();
  enableFlags(bold: true, hidden: false);

  enableFlags1();
  enableFlags1(hidden: true);

  enableFlags2(hidden: false);

  // optional positional parameters
  // Wrapping a set of function parameters in [] marks them as optional positional parameters. If you don’t provide a default value, their types must be nullable as their default value will be null:

  assert(say('from', 'msg') == 'from says msg');
  assert(say('from', 'msg', 'smoke') == 'from says msg with a smoke');

  assert(say1('from', 'msg') == 'from says msg with a device');

  // the main() function
  // Every app must have a top-level main() function, which serves as the entrypoint to the app. The main() function returns void and has an optional List<String> parameter for arguments.
  // dart "xx/samples/samples-dart/functions/functions_test.dart" 1 test
  print(args);
  assert(args.length == 2);
  assert(int.parse(args[0]) == 1);
  assert(args[1] == 'test');

  // functions as first-class-objects
  // You can pass a function as a parameter to another function
  var list = [1, 2, 3];
  list.forEach(printElement);

  var loudify = (msg) => '!!! ${msg.toUpperCase()} !!!';
  assert(loudify('hello') == '!!! HELLO !!!');

  // anonymous functions
  // An anonymous function looks similar to a named function—zero or more parameters, separated by commas and optional type annotations, between parentheses.

  const list1 = ['apples', 'bananas', 'cici'];
  list1.map((e) => e.toUpperCase()).forEach((element) {
    print('$element: ${element.length}');
  });

  // lexical scope
  // Dart is a lexically scoped language, which means that the scope of variables is determined statically, simply by the layout of the code.
  var insideMain = true;
  void myFunction() {
    var insideFunction = true;

    void nestedFunction() {
      var insideNestedFunction = true;

      print(topLevel);
      print(insideMain);
      print(insideFunction);
      print(insideNestedFunction);
    }

    nestedFunction();
  }

  myFunction();

  // lexical closures
  // A closure is a function object that has access to variables in its lexical scope, even when the function is used outside of its original scope.
  var add2 = makeAdder(2);

  var add4 = makeAdder(4);

  assert(add2(3) == 5);
  assert(add4(3) == 7);

  // return values
  // All functions return a value. If no return value is specified, the statement return null; is implicitly appended to the function body.
  assert(foo() == null);

  print(foo1());

  // generators
  // When you need to lazily produce a sequence of values, consider using a generator function.
  // 1. Synchronous generator: Returns an Iterable object.
  // 2. Asynchronous generator: Returns a Stream object.
  print(naturasTo(10));
  print(asyncNaturasTo(20));
}

var _nobleGases = {};

bool isNoble(int atomicNumber) {
  return _nobleGases[atomicNumber] != null;
}

// --- named parameters

void enableFlags({bool? bold, bool? hidden}) {
  print('$bold, $hidden');
}

void enableFlags1({bool bold = false, bool hidden = false}) {
  print('$bold, $hidden');
}

void enableFlags2({bool? bold, required bool hidden}) {
  print('$bold, $hidden');
}

// named parameters ---

// --- optional positional parameters

String say(String from, String msg, [String? device]) {
  var result = '$from says $msg';
  if (device != null) {
    result = '$result with a $device';
  }

  return result;
}

String say1(String from, String msg, [String device = 'device']) {
  var result = '$from says $msg with a $device';
  return result;
}

// optional positional parameters ---

void printElement(int element) {
  print(element);
}

Function makeAdder(int addBy) {
  return (int i) => addBy + i;
}

foo() {}

(String, int) foo1() {
  return ('something', 42);
}

// --- generators

Iterable<int> naturasTo(int n) sync* {
  int k = 0;
  while (k < n) yield k++;
}

Stream<int> asyncNaturasTo(int n) async* {
  int k = 0;
  while (k < n) yield k++;
}

Iterable<int> naturalsDownFrom(int n) sync* {
  if (n > 0) {
    yield n;
    yield* naturalsDownFrom(n - 1);
  }
}

// generators ---