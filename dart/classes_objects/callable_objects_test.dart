void main(List<String> args) {
  // 若要允许像函数一样调用 Dart 类的实例，请实现该 call() 方法。
  var wannableFunction = WannableFunction();
  print(wannableFunction);

  var out = wannableFunction('lie', 'shi', 'wudu');
  print(out);
}

class WannableFunction {
  String call(String a, String b, String c) => '$a $b $c';
}
