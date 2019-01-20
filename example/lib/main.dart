import 'package:flutter/material.dart';

import 'package:flutter_mmkv_cache/flutter_mmkv_cache.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  _incrementCounter() async {
    FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
    int counter = await mmkv.getInt('intKey') + 1;
    print('GetSetIntTest is $counter ');
    await mmkv.setInt('intKey', counter);
  }

  _incrementString() async {
    FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
    String stringtest = await mmkv.getString('stringKey') + '1';
    print('GetSetStringTest is $stringtest');
    await mmkv.setString('stringKey', stringtest);
  }

  _setBool() async {
    FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
    mmkv.setBool('boolKey', true);
  }

  _getBool() async {
    FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
    print('get bool value is ${await mmkv.getBool('boolKey')}');
  }

  _clear() async {
    FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
    await mmkv.clear();
  }

  _setNullTest() async {
    FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
    await mmkv.setString('boolKey', null);
  }

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: const Text('Plugin example app'),
        ),
        body: new Column(
          children: <Widget>[
            new RaisedButton(
              onPressed: _incrementCounter,
              child: new Text('GetSetIntTest'),
            ),
            new RaisedButton(
              onPressed: _incrementString,
              child: new Text('GetSetStringTest'),
            ),
            new RaisedButton(
              onPressed: _clear,
              child: new Text('clear'),
            ),
            new RaisedButton(
              onPressed: _getBool,
              child: new Text('GetBoolTest'),
            ),
            new RaisedButton(
              onPressed: _setBool,
              child: new Text('SetBoolTest'),
            ),
            new RaisedButton(
              onPressed: _setNullTest,
              child: new Text('SetNullTest'),
            ),
            new RaisedButton(
              onPressed: () async {
                FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
                final allKeys = await mmkv.allKeys();
                print(allKeys);
              },
              child: new Text('Get All Keys'),
            ),
            new RaisedButton(
              onPressed: () async {
                FlutterMmkvCache mmkv = await FlutterMmkvCache.getInstance();
                final allKeys = await mmkv.getValueSizeForKey('boolKey');
                print(allKeys);
              },
              child: new Text('GetValueSizeForKey'),
            )
          ],
        ),
      ),
    );
  }
}
