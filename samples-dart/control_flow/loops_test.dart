void main(List<String> args) {
  // for loops
  var message = StringBuffer('Dart is fun');
  print(message);
  for (var i = 0; i < 5; i++) {
    message.write('!');
  }
  print(message);

  var callbacks = [];
  for (var i = 0; i < 2; i++) {
    callbacks.add(() => print(i));
  }

  for (final c in callbacks) {
    c();
  }

  var colletion = [1, 2, 3];
  colletion.forEach(print);

  // while and do-while
  // while (!isDone()) {
  //   doSomething();
  // }

  // do {
  //   printLine();
  // } while (!atEndOfPage());

  // break and continue
  // 1. Use break to stop looping
  // 2. Use continue to skip to the next loop iteration
}
