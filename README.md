# flutter_mmkv_cache

[![pub package](https://img.shields.io/pub/v/flutter_mmkv_cache.svg)](https://pub.dartlang.org/packages/flutter_mmkv_cache)

> A cache for Flutter project implement it with mmkv framework. and support expires


## Getting Started


```yaml
dependencies:
  flutter_mmkv_cache: ^0.0.2
```

### Usage

```dart
import 'package:flutter_mmkv_cache/flutter_mmkv_cache.dart';

/// https://github.com/OpenFlutter/mmkv_flutter

/// ExpiredCache

/// add value to cache will expired in 1 hour
final boolRes = await ExpiredCache.add('key', 'value', expired: 1  );

/// get value from cache
final value = await ExpiredCache.get('key');

```


### Licenses

Original License https://github.com/OpenFlutter/mmkv_flutter
