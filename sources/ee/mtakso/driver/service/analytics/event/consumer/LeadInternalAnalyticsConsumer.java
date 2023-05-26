package ee.mtakso.driver.service.analytics.event.consumer;

import android.annotation.SuppressLint;
import ee.mtakso.driver.network.client.analytics.AnalyticsClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.Event;
import ee.mtakso.driver.service.analytics.event.Property;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeadInternalAnalyticsConsumer.kt */
/* loaded from: classes3.dex */
public final class LeadInternalAnalyticsConsumer implements AnalyticsConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsClient f23488a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23489b;

    @Inject
    public LeadInternalAnalyticsConsumer(AnalyticsClient apiClient) {
        Intrinsics.f(apiClient, "apiClient");
        this.f23488a = apiClient;
        this.f23489b = Scopes.f23428a.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public AnalyticScope a() {
        return this.f23489b;
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void b(String id) {
        Intrinsics.f(id, "id");
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void c(Property property) {
        Intrinsics.f(property, "property");
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    @SuppressLint({"CheckResult"})
    public void d(Event event) {
        Intrinsics.f(event, "event");
        Single<EmptyServerResponse> K = this.f23488a.b(event.b(), event.c()).K(Schedulers.c());
        Consumer<? super EmptyServerResponse> g8 = Functions.g();
        final LeadInternalAnalyticsConsumer$sendEvent$1 leadInternalAnalyticsConsumer$sendEvent$1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.analytics.event.consumer.LeadInternalAnalyticsConsumer$sendEvent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to send event");
            }
        };
        K.I(g8, new Consumer() { // from class: ee.mtakso.driver.service.analytics.event.consumer.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LeadInternalAnalyticsConsumer.g(Function1.this, obj);
            }
        });
    }

    @Override // ee.mtakso.driver.service.analytics.event.AnalyticsConsumer
    public void e(Property property) {
        Intrinsics.f(property, "property");
    }
}
