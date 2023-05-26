package ee.mtakso.driver.service.analytics.controller;

import android.content.Context;
import android.view.WindowManager;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.Property;
import ee.mtakso.driver.service.analytics.event.consumer.MixpanelAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager;
import ee.mtakso.driver.service.analytics.timed.consumer.mixpanel.MixPanelTimedConsumer;
import ee.mtakso.driver.uicore.utils.WindowExtKt;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.driver.core.utils.AssertUtils;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MixpanelController.kt */
@Singleton
/* loaded from: classes3.dex */
public final class MixpanelController {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f23439a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f23440b;

    /* renamed from: c  reason: collision with root package name */
    private final AnalyticsManager f23441c;

    /* renamed from: d  reason: collision with root package name */
    private final TimedAnalyticsManager f23442d;

    /* renamed from: e  reason: collision with root package name */
    private final LanguageManager f23443e;

    /* renamed from: f  reason: collision with root package name */
    private MixpanelAnalyticsConsumer f23444f;

    /* renamed from: g  reason: collision with root package name */
    private MixPanelTimedConsumer f23445g;

    /* renamed from: h  reason: collision with root package name */
    private MixpanelAPI f23446h;

    @Inject
    public MixpanelController(DriverProvider provider, Context context, AnalyticsManager analyticsManager, TimedAnalyticsManager timedAnalyticsManager, LanguageManager languageManager) {
        Intrinsics.f(provider, "provider");
        Intrinsics.f(context, "context");
        Intrinsics.f(analyticsManager, "analyticsManager");
        Intrinsics.f(timedAnalyticsManager, "timedAnalyticsManager");
        Intrinsics.f(languageManager, "languageManager");
        this.f23439a = provider;
        this.f23440b = context;
        this.f23441c = analyticsManager;
        this.f23442d = timedAnalyticsManager;
        this.f23443e = languageManager;
    }

    private final void b() {
        Kalev.l("Mixpanel: initialize");
        MixpanelAPI api = this.f23446h;
        if (api != null) {
            return;
        }
        if (api == null) {
            api = MixpanelAPI.z(this.f23440b.getApplicationContext(), "16b2ba60f4d49b1f69fcf78aea1521a3");
        }
        MixpanelAnalyticsConsumer mixpanelAnalyticsConsumer = this.f23444f;
        if (mixpanelAnalyticsConsumer == null) {
            Intrinsics.e(api, "api");
            mixpanelAnalyticsConsumer = new MixpanelAnalyticsConsumer(api);
        }
        this.f23444f = mixpanelAnalyticsConsumer;
        MixPanelTimedConsumer mixPanelTimedConsumer = this.f23445g;
        if (mixPanelTimedConsumer == null) {
            Intrinsics.e(api, "api");
            mixPanelTimedConsumer = new MixPanelTimedConsumer(api);
        }
        this.f23445g = mixPanelTimedConsumer;
        this.f23446h = api;
        Kalev.n("distinct id", api.y()).a("Mixpanel initied");
    }

    public final void a() {
        boolean z7;
        boolean z8;
        String F = this.f23439a.m().F();
        String str = "";
        if (F == null) {
            F = "";
        }
        boolean z9 = true;
        if (F.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        AssertUtils.f(z7, null, 2, null);
        String c8 = this.f23439a.n().c();
        if (c8 != null) {
            str = c8;
        }
        if (str.length() > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        AssertUtils.f(z8, null, 2, null);
        MixpanelAnalyticsConsumer mixpanelAnalyticsConsumer = this.f23444f;
        if (mixpanelAnalyticsConsumer != null) {
            mixpanelAnalyticsConsumer.f(str);
            Object systemService = this.f23440b.getSystemService("window");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            mixpanelAnalyticsConsumer.e(new Property("country", this.f23439a.m().j(), null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("driver_id", this.f23439a.f(), null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("language", this.f23443e.e(), null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("driver_city", this.f23439a.m().g(), null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("is_new_sign_in_design_enabled", "true", null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("Has Driver Score", String.valueOf((this.f23439a.q().k() && this.f23439a.n().e()) ? false : false), null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("screen_width", String.valueOf(WindowExtKt.a(windowManager).b()), null, 4, null));
            mixpanelAnalyticsConsumer.e(new Property("screen_height", String.valueOf(WindowExtKt.a(windowManager).a()), null, 4, null));
        }
    }

    public final void c() {
        MixpanelAnalyticsConsumer mixpanelAnalyticsConsumer = this.f23444f;
        if (mixpanelAnalyticsConsumer != null) {
            mixpanelAnalyticsConsumer.g();
            this.f23441c.b(mixpanelAnalyticsConsumer);
        }
        MixPanelTimedConsumer mixPanelTimedConsumer = this.f23445g;
        if (mixPanelTimedConsumer != null) {
            this.f23442d.b(mixPanelTimedConsumer);
        }
    }

    public final void d() {
        if (this.f23446h == null) {
            b();
        } else {
            Kalev.l("Mixpanel: Already initialized");
        }
        MixPanelTimedConsumer mixPanelTimedConsumer = this.f23445g;
        if (mixPanelTimedConsumer != null) {
            this.f23442d.a(mixPanelTimedConsumer);
        }
        MixpanelAnalyticsConsumer mixpanelAnalyticsConsumer = this.f23444f;
        if (mixpanelAnalyticsConsumer != null) {
            this.f23441c.a(mixpanelAnalyticsConsumer);
        }
    }
}
