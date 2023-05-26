package ee.mtakso.driver.service.analytics.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Property.kt */
/* loaded from: classes3.dex */
public final class PropertyKt {
    public static final JSONObject a(Property property) {
        Intrinsics.f(property, "<this>");
        JSONObject put = new JSONObject().put(property.a(), property.c());
        Intrinsics.e(put, "props.put(this.key, this.value)");
        return put;
    }
}
