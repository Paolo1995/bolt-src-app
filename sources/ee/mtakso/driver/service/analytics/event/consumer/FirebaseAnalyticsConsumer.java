package ee.mtakso.driver.service.analytics.event.consumer;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.service.analytics.event.Property;
import ee.mtakso.driver.utils.AssertUtils;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: FirebaseAnalyticsConsumer.kt */
/* loaded from: classes3.dex */
public final class FirebaseAnalyticsConsumer implements AnalyticsConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseAnalytics f23481a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23482b;

    @Inject
    public FirebaseAnalyticsConsumer(FirebaseAnalytics firebaseAnalytics) {
        Intrinsics.f(firebaseAnalytics, "firebaseAnalytics");
        this.f23481a = firebaseAnalytics;
        this.f23482b = Scopes.f23428a.d();
    }

    private final Bundle f(Event event) {
        boolean z7;
        String E;
        Bundle bundle = new Bundle();
        if (event.c().entrySet().size() < 26) {
            z7 = true;
        } else {
            z7 = false;
        }
        String b8 = event.b();
        AssertUtils.f(z7, "Firebase event " + b8 + " have more then 25 fields");
        Iterator<T> it = event.c().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            E = StringsKt__StringsJVMKt.E((String) entry.getKey(), '.', '_', false, 4, null);
            Object value = entry.getValue();
            if (value == null) {
                bundle.putString(E, "null");
            } else if (value instanceof Integer) {
                bundle.putInt(E, ((Number) value).intValue());
            } else if (value instanceof String) {
                String str = (String) value;
                if (str.length() > 100) {
                    String b9 = event.b();
                    Object key = entry.getKey();
                    AssertUtils.a("Firebase event param " + b9 + " - " + key + " have more then 100 chars");
                    String substring = str.substring(0, 99);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    bundle.putString(E, substring);
                } else {
                    bundle.putString(E, str);
                }
            } else if (value instanceof Boolean) {
                bundle.putBoolean(E, ((Boolean) value).booleanValue());
            } else if (value instanceof Enum) {
                bundle.putString(E, ((Enum) value).name());
            } else if (value instanceof Long) {
                bundle.putLong(E, ((Number) value).longValue());
            } else if (value instanceof Float) {
                bundle.putFloat(E, ((Number) value).floatValue());
            } else {
                String b10 = event.b();
                Object key2 = entry.getKey();
                Object value2 = entry.getValue();
                throw new IllegalArgumentException("Failed to convert event params to bundle: [" + b10 + "] " + key2 + " - " + value2);
            }
        }
        return bundle;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public AnalyticScope a() {
        return this.f23482b;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void b(String id) {
        Intrinsics.f(id, "id");
        this.f23481a.b(id);
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void c(Property property) {
        Intrinsics.f(property, "property");
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void d(Event event) {
        String F;
        Intrinsics.f(event, "event");
        F = StringsKt__StringsJVMKt.F(event.b(), " ", "_", false, 4, null);
        this.f23481a.a(F, f(event));
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void e(Property property) {
        Intrinsics.f(property, "property");
        this.f23481a.c(property.a(), property.c());
    }
}
