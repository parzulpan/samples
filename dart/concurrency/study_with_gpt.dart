import 'dart:async';
import 'dart:io';
import 'dart:isolate';

void main(List<String> args) {
  // exec();

  // exec2();

  // exec3();

  exec4().listen(
    (count) => print('Count: $count'),
    onDone: () => print('Done!'),
  );

  /**
   * 创建一个新的 Isolate 的基本步骤如下：
   * 1. 创建一个 ReceivePort，以便新的 Isolate 可以发送消息回来。
   * 2. 启动新的 Isolate，传递一个函数和 ReceivePort.sendPort。
   * 3. 在新的 Isolate 中，使用传递进来的 SendPort 来发送消息。
   */
  // exec5();
}

// --- 使用 Future

Future<String> fetchUserData() {
  return Future.delayed(Duration(seconds: 2), () => 'Fetched user data');
}

void exec() {
  fetchUserData().then((data) {
    print(data);
  });
  print('Fetching user data...');
}

// 使用 Future ---

// --- 使用 async 和 await

Future<String> fetchUserData2() async {
  await Future.delayed(Duration(seconds: 4));
  return 'Fetched user data 2';
}

void exec2() async {
  print('Fetching user data 2...');
  var data = await fetchUserData2();
  print(data);
}

// 使用 async 和 await ---

// --- 使用 Stream

/**
 * 创建了一个每秒产生一个数字的 Stream，直到达到最大数量。可以使用 Stream 的 listen 方法来注册回调，处理数据和结束事件。
 */
Stream<int> timedCounter(Duration interval, [int? maxCount]) {
  StreamController<int>? controller;
  Timer? timer;
  int counter = 0;

  void tick(_) {
    counter++;
    // 向流中添加数据
    controller!.add(counter);
    if (maxCount != null && counter >= maxCount) {
      timer!.cancel();
      controller.close();
    }
  }

  void startTimer() {
    timer = Timer.periodic(interval, tick);
  }

  controller = StreamController<int>(
    onListen: startTimer,
    onPause: timer?.cancel,
    onResume: startTimer,
    onCancel: () => timer?.cancel(),
  );

  return controller.stream;
}

void exec3() {
  timedCounter(Duration(seconds: 1), 10).listen(
    (count) => print('Count: $count'),
    onDone: () => print('Done!'),
  );
}

Stream<int> getStream() {
  return Stream.periodic(const Duration(seconds: 1), (i) => i * i);
}

Stream<int> exec4() async* {
  var sum = 0;
  await for (final value in getStream()) {
    yield sum += value;
  }
}

// 使用 Stream ---

// --- 使用 Isolate

void runIsolate(SendPort sendPort) {
  int counter = 0;
  Timer.periodic(Duration(seconds: 1), (timer) {
    counter++;
    String msg = 'notification $counter';
    print('Sending message: $msg');
    sendPort.send(msg); // 发送消息回 Main Isolate

    if (counter > 10) {
      timer.cancel();
      exit(0);
    }
  });
}

void exec5() async {
  // 创建一个 ReceivePort 以接收来自新 Isolate 的消息
  var receivePort = ReceivePort();

  // 创建并启动新的 Isolate
  await Isolate.spawn(runIsolate, receivePort.sendPort);

  // 监听来自新 Isolate 的消息
  receivePort.listen((data) {
    print('Received: $data');
  });
}

// 使用 Isolate ---