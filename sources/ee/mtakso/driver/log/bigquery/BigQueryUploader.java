package ee.mtakso.driver.log.bigquery;

import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.utils.ext.JSONObjectExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BigQueryUploader.kt */
/* loaded from: classes3.dex */
public final class BigQueryUploader {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsManager f21080a;

    /* renamed from: b  reason: collision with root package name */
    private final InternalLog f21081b;

    @Inject
    public BigQueryUploader(AnalyticsManager analyticsManager, InternalLog internalLog) {
        Intrinsics.f(analyticsManager, "analyticsManager");
        Intrinsics.f(internalLog, "internalLog");
        this.f21080a = analyticsManager;
        this.f21081b = internalLog;
    }

    private final Event a(LogEntity logEntity) {
        Map<String, Object> f8;
        Map i8;
        Map m8;
        try {
            f8 = JSONObjectExtKt.a(new JSONObject(logEntity.a()));
        } catch (JSONException e8) {
            this.f21081b.a(e8);
            f8 = MapsKt__MapsKt.f();
        }
        if (Intrinsics.a(logEntity.b(), "network")) {
            f8 = d(f8);
        } else if (Intrinsics.a(logEntity.b(), "Found incoming order")) {
            f8 = c(f8);
        }
        AnalyticScope d8 = Scopes.f23428a.d();
        i8 = MapsKt__MapsKt.i(TuplesKt.a("timestamp", Long.valueOf(logEntity.e())), TuplesKt.a("message", logEntity.b()), TuplesKt.a("level", logEntity.c()), TuplesKt.a("tag", logEntity.d()));
        m8 = MapsKt__MapsKt.m(i8, f8);
        return new Event("log", m8, d8, null, 8, null);
    }

    private final void b(Map<String, Object> map, String str) {
        String obj;
        List Z0;
        Object obj2 = map.get(str);
        if (obj2 != null && (obj = obj2.toString()) != null && obj.length() > 100) {
            map.remove(str);
            Z0 = StringsKt___StringsKt.Z0(obj, 95);
            int i8 = 0;
            for (Object obj3 : Z0) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                map.put(str + "_" + i8, (String) obj3);
                i8 = i9;
            }
        }
    }

    private final Map<String, Object> c(Map<String, ? extends Object> map) {
        Map<String, Object> u7;
        u7 = MapsKt__MapsKt.u(map);
        b(u7, "order");
        return u7;
    }

    private final Map<String, Object> d(Map<String, ? extends Object> map) {
        Map<String, Object> u7;
        u7 = MapsKt__MapsKt.u(map);
        b(u7, "request.body");
        b(u7, "response.body");
        u7.remove("country");
        u7.remove("deviceId");
        u7.remove("device_os_version");
        u7.remove("language");
        u7.remove("device_name");
        u7.remove("tag");
        u7.remove("level");
        u7.remove("gps_age");
        u7.remove("gps_lat");
        u7.remove("gps_lng");
        u7.remove("gps_accuracy_meters");
        u7.remove("gps_bearing");
        u7.remove("gps_timestamp");
        return u7;
    }

    public final void e(List<LogEntity> logs) {
        int v7;
        Intrinsics.f(logs, "logs");
        v7 = CollectionsKt__IterablesKt.v(logs, 10);
        ArrayList<Event> arrayList = new ArrayList(v7);
        for (LogEntity logEntity : logs) {
            arrayList.add(a(logEntity));
        }
        for (Event event : arrayList) {
            this.f21080a.c(event);
        }
    }
}
