/**
 * 拓展 String，以支持 '42'.parseInt() 类似的功能
 */
extension NumberParsing on String {
  int parseInt() {
    return int.parse(this);
  }
}
