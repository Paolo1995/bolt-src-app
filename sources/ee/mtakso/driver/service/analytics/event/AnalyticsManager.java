package ee.mtakso.driver.service.analytics.event;

import java.util.ArrayList;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class AnalyticsManager {

    /* renamed from: a  reason: collision with root package name */
    private Set<AnalyticsConsumer> f23469a;

    @Inject
    public AnalyticsManager(Set<AnalyticsConsumer> consumers) {
        Intrinsics.f(consumers, "consumers");
        this.f23469a = consumers;
    }

    public final void a(AnalyticsConsumer consumer) {
        Set<AnalyticsConsumer> i8;
        Intrinsics.f(consumer, "consumer");
        i8 = SetsKt___SetsKt.i(this.f23469a, consumer);
        this.f23469a = i8;
    }

    public final void b(AnalyticsConsumer consumer) {
        Set<AnalyticsConsumer> g8;
        Intrinsics.f(consumer, "consumer");
        g8 = SetsKt___SetsKt.g(this.f23469a, consumer);
        this.f23469a = g8;
    }

    public final void c(Event event) {
        Intrinsics.f(event, "event");
        Set<AnalyticsConsumer> set = this.f23469a;
        ArrayList<AnalyticsConsumer> arrayList = new ArrayList();
        for (Object obj : set) {
            if (((AnalyticsConsumer) obj).a().b(event.d())) {
                arrayList.add(obj);
            }
        }
        for (AnalyticsConsumer analyticsConsumer : arrayList) {
            analyticsConsumer.d(event);
        }
    }

    public final void d(Property property) {
        Intrinsics.f(property, "property");
        Set<AnalyticsConsumer> set = this.f23469a;
        ArrayList<AnalyticsConsumer> arrayList = new ArrayList();
        for (Object obj : set) {
            if (((AnalyticsConsumer) obj).a().b(property.b())) {
                arrayList.add(obj);
            }
        }
        for (AnalyticsConsumer analyticsConsumer : arrayList) {
            analyticsConsumer.c(property);
        }
    }

    public final void e(String id) {
        Intrinsics.f(id, "id");
        for (AnalyticsConsumer analyticsConsumer : this.f23469a) {
            analyticsConsumer.b(id);
        }
    }

    public final void f(Property property) {
        Intrinsics.f(property, "property");
        Set<AnalyticsConsumer> set = this.f23469a;
        ArrayList<AnalyticsConsumer> arrayList = new ArrayList();
        for (Object obj : set) {
            if (((AnalyticsConsumer) obj).a().b(property.b())) {
                arrayList.add(obj);
            }
        }
        for (AnalyticsConsumer analyticsConsumer : arrayList) {
            analyticsConsumer.e(property);
        }
    }
}
