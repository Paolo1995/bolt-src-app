package ee.mtakso.driver.utils.ext;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONObjectExt.kt */
/* loaded from: classes5.dex */
public final class JSONObjectExtKt {
    public static final Map<String, Object> a(JSONObject jSONObject) {
        Intrinsics.f(jSONObject, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object data = jSONObject.get(key);
            if (!(data instanceof JSONObject) && !(data instanceof JSONArray)) {
                Intrinsics.e(key, "key");
                Intrinsics.e(data, "data");
                linkedHashMap.put(key, data);
            } else {
                Intrinsics.e(key, "key");
                linkedHashMap.put(key, data.toString());
            }
        }
        return linkedHashMap;
    }
}
