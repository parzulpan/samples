void main(List<String> args) {
  // using libraries
  // import 'dart:html';
  // import 'package:test/test.dart';

  // specifying a library prefix
  /**
  import 'package:lib1/lib1.dart';
  import 'package:lib2/lib2.dart' as lib2;

  // Uses Element from lib1.
  Element element1 = Element();

  // Uses Element from lib2.
  lib2.Element element2 = lib2.Element();
   */

  // importing only part of a library
  /**
  // Import only foo.
  import 'package:lib1/lib1.dart' show foo;

  // Import all names EXCEPT foo.
  import 'package:lib2/lib2.dart' hide foo;
   */

  // the library directive
  /**
  /// A really great test library.
  @TestOn('browser')
  library;
   */
}
