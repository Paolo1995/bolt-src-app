package ee.mtakso.driver.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: ListExt.kt */
/* loaded from: classes5.dex */
public final class ListUtils {
    public static final JSONArray a(List<?> list) {
        Intrinsics.f(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }
}
