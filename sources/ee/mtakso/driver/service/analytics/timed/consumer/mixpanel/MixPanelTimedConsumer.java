package ee.mtakso.driver.service.analytics.timed.consumer.mixpanel;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.timed.CompositeTimedEvent;
import ee.mtakso.driver.service.analytics.timed.TimedConsumer;
import ee.mtakso.driver.service.analytics.timed.TimedEvent;
import ee.mtakso.driver.service.analytics.timed.TimedEventRequest;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MixPanelTimedConsumer.kt */
/* loaded from: classes3.dex */
public final class MixPanelTimedConsumer implements TimedConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final MixpanelAPI f23548a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticScope f23549b;

    public MixPanelTimedConsumer(MixpanelAPI api) {
        Intrinsics.f(api, "api");
        this.f23548a = api;
        this.f23549b = Scopes.f23428a.g();
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public AnalyticScope a() {
        return this.f23549b;
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public void b(CompositeTimedEvent event) {
        Intrinsics.f(event, "event");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : event.b().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        this.f23548a.V(event.c().a(), jSONObject);
    }

    @Override // ee.mtakso.driver.service.analytics.timed.TimedConsumer
    public TimedEvent c(TimedEventRequest request) {
        Intrinsics.f(request, "request");
        this.f23548a.T(request.a());
        return MixpanelTimedEvent.f23550a;
    }
}
