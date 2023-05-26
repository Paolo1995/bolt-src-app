package ee.mtakso.driver.service.analytics.event;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.utils.ListUtils;
import eu.bolt.kalev.Kalev;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Event.kt */
/* loaded from: classes3.dex */
public final class Event {

    /* renamed from: a  reason: collision with root package name */
    private final String f23471a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23472b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f23473c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f23474d;

    public Event(String key, Map<String, ? extends Object> payload, AnalyticScope scope, Map<String, ? extends Object> metaInfo) {
        Map<String, Object> u7;
        Intrinsics.f(key, "key");
        Intrinsics.f(payload, "payload");
        Intrinsics.f(scope, "scope");
        Intrinsics.f(metaInfo, "metaInfo");
        this.f23471a = key;
        this.f23472b = scope;
        this.f23473c = metaInfo;
        u7 = MapsKt__MapsKt.u(payload);
        this.f23474d = u7;
    }

    public final Event a(String key, Object obj) {
        Intrinsics.f(key, "key");
        this.f23474d.put(key, obj);
        return this;
    }

    public final String b() {
        return this.f23471a;
    }

    public final Map<String, Object> c() {
        return this.f23474d;
    }

    public final AnalyticScope d() {
        return this.f23472b;
    }

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = this.f23474d.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            try {
                Object value = entry.getValue();
                if (value instanceof List) {
                    jSONObject.put((String) entry.getKey(), ListUtils.a((List) value));
                } else {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e8) {
                Kalev.o(e8).n("event key", this.f23471a).n("param key", entry.getKey()).n("param value", entry.getValue()).b("Failed to add event param");
            }
        }
        return jSONObject;
    }

    public /* synthetic */ Event(String str, Map map, AnalyticScope analyticScope, Map map2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? MapsKt__MapsKt.f() : map, (i8 & 4) != 0 ? Scopes.f23428a.c() : analyticScope, (i8 & 8) != 0 ? MapsKt__MapsKt.f() : map2);
    }
}
