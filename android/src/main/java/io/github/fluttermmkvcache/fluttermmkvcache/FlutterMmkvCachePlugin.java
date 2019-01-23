package io.github.fluttermmkvcache.fluttermmkvcache;

import android.content.Context;

import com.tencent.mmkv.MMKV;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterMmkvCachePlugin
 */
public class FlutterMmkvCachePlugin implements MethodCallHandler {

    public static final String KEY = "key";
    public static final String VALUE = "value";

    private final MMKV mmkv;

    private FlutterMmkvCachePlugin(Context context) {
        MMKV.initialize(context);
        mmkv = MMKV.defaultMMKV();
    }

    /**
     * Plugin registration.
     */
    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_mmkv_cache");
        channel.setMethodCallHandler(new FlutterMmkvCachePlugin(registrar.context()));

    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {

        String key = call.argument(KEY);
        try {

            switch (call.method) {
                case "setBool":
                    boolean setBoolStatus = mmkv.encode(key, (boolean) call.argument(VALUE));
                    result.success(setBoolStatus);
                    break;
                case "getBool":
                    boolean getBoolStatus = mmkv.decodeBool(key);
                    result.success(getBoolStatus);
                    break;
                case "setInt":
                    boolean setIntStatus = mmkv.encode(key, (int) call.argument(VALUE));
                    result.success(setIntStatus);
                    break;
                case "getInt":
                    int getIntStatus = mmkv.decodeInt(key);
                    result.success(getIntStatus);
                    break;
                case "setLong":
                    boolean setLongStatus = mmkv.encode(key, (long) call.argument(VALUE));
                    result.success(setLongStatus);
                    break;
                case "getLong":
                    long getLongStatus = mmkv.decodeLong(key);
                    result.success(getLongStatus);
                    break;
                case "setDouble":
                    boolean setDoubleStatus = mmkv.encode(key, (double) call.argument(VALUE));
                    result.success(setDoubleStatus);
                    break;
                case "getDouble":
                    double getDoubleStatus = mmkv.decodeDouble(key);
                    result.success(getDoubleStatus);
                    break;
                case "setString":
                    boolean setStringStatus = mmkv.encode(key, (String) call.argument(VALUE));
                    result.success(setStringStatus);
                    break;
                case "getString":
                    String getStringStatus = mmkv.decodeString(key, "");
                    result.success(getStringStatus);
                    break;
                case "removeByKey":
                    mmkv.removeValueForKey(key);
                    result.success(true);
                    break;
                case "getValueSizeForKey":
                    result.success(mmkv.getValueSize(key));
                    break;
                case "allKeys":
                    result.success(mmkv.allKeys());
                    break;
                case "clear":
                    mmkv.clearAll();
                    result.success(true);
                    break;
                default:
                    result.notImplemented();
                    break;
            }

        } catch (Exception e) {
            result.error("Exception encountered", call.method, e);
        }
    }
}