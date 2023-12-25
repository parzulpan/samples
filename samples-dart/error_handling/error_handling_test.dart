void main(List<String> args) {
  // 与 Java 不同，Dart 的所有异常都是未经检查的异常。方法不声明它们可能抛出哪些异常，并且您不需要捕获任何异常。

  // throw

  // throw1();

  // throw2();

  // throw3();

  // catch

  try {
    throw1();
  } on FormatException {
    print('catch FormatException');
  }

  try {
    throw2();
  } on FormatException {
    print('catch FormatException');
  } on Exception catch (e) {
    print('Unknown exception: $e');
  } catch (e) {
    print('Something really unknown: $e');
  }

  try {
    throw3();
  } on Exception catch (e) {
    print('Exception details:\n $e');
  } catch (e, s) {
    print('Exception details:\n $e');
    print('Stack trace:\n $s');
  }

  // 要部分处理异常，同时允许其传播，请使用rethrow关键字

  // finally
  // 为了确保无论是否抛出异常，某些代码都会运行，请使用finally子句。如果没有catch子句与异常匹配，则在finally子句运行后传播异常
  try {
    throw1();
  } catch (e) {
    print('Error: $e'); // Handle the exception first.
  } finally {
    print('Then clean up.');
  }

  // assert
  // 在开发过程中，使用断言语句assert(<condition>, <optionalMessage>);——如果布尔条件为假，则中断正常执行
}

void throw1() {
  throw FormatException('Expected at least 1 section');
}

void throw2() {
  throw 'Out of llamas!';
}

void throw3() => throw UnimplementedError('test');

void assertException(int number) {
  assert(number > 100, 'assert msg');
}
