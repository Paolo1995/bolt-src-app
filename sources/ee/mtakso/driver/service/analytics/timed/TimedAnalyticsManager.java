package ee.mtakso.driver.service.analytics.timed;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimedAnalyticsManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class TimedAnalyticsManager {

    /* renamed from: a  reason: collision with root package name */
    private Set<TimedConsumer> f23532a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, CompositeTimedEvent> f23533b;

    @Inject
    public TimedAnalyticsManager(Set<TimedConsumer> consumers) {
        Intrinsics.f(consumers, "consumers");
        this.f23532a = consumers;
        this.f23533b = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(TimedAnalyticsManager timedAnalyticsManager, AnalyticScope analyticScope, String str, Map map, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            map = MapsKt__MapsKt.f();
        }
        timedAnalyticsManager.c(analyticScope, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(TimedAnalyticsManager timedAnalyticsManager, String str, Map map, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            map = MapsKt__MapsKt.f();
        }
        timedAnalyticsManager.f(str, map);
    }

    public final void a(TimedConsumer consumer) {
        Set<TimedConsumer> i8;
        Intrinsics.f(consumer, "consumer");
        i8 = SetsKt___SetsKt.i(this.f23532a, consumer);
        this.f23532a = i8;
    }

    public final void b(TimedConsumer consumer) {
        Set<TimedConsumer> g8;
        Intrinsics.f(consumer, "consumer");
        g8 = SetsKt___SetsKt.g(this.f23532a, consumer);
        this.f23532a = g8;
    }

    public final void c(AnalyticScope scope, String key, Map<String, String> attrs) {
        Intrinsics.f(scope, "scope");
        Intrinsics.f(key, "key");
        Intrinsics.f(attrs, "attrs");
        d(new TimedEventRequest(key, scope, attrs));
    }

    public final void d(TimedEventRequest request) {
        int v7;
        Intrinsics.f(request, "request");
        if (this.f23533b.get(request.a()) != null) {
            String a8 = request.a();
            Kalev.e(new IllegalStateException("Running trace " + a8 + " cancelled"), "Timed event overridden");
        }
        Set<TimedConsumer> set = this.f23532a;
        ArrayList<TimedConsumer> arrayList = new ArrayList();
        for (Object obj : set) {
            if (((TimedConsumer) obj).a().b(request.c())) {
                arrayList.add(obj);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (TimedConsumer timedConsumer : arrayList) {
            arrayList2.add(timedConsumer.c(request));
        }
        this.f23533b.put(request.a(), new CompositeTimedEvent(request, arrayList2));
    }

    public final void f(String key, Map<String, String> attrs) {
        Intrinsics.f(key, "key");
        Intrinsics.f(attrs, "attrs");
        CompositeTimedEvent remove = this.f23533b.remove(key);
        if (remove == null) {
            FastLog g8 = Kalev.f41674e.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "Not able to stop timed event. Trace " + key + " is not running", null, 2, null);
                return;
            }
            return;
        }
        CompositeTimedEventKt.a(remove, attrs);
        Set<TimedConsumer> set = this.f23532a;
        ArrayList<TimedConsumer> arrayList = new ArrayList();
        for (Object obj : set) {
            if (((TimedConsumer) obj).a().b(remove.c().c())) {
                arrayList.add(obj);
            }
        }
        for (TimedConsumer timedConsumer : arrayList) {
            timedConsumer.b(remove);
        }
    }
}
