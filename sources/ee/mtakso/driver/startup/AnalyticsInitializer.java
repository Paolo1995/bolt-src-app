package ee.mtakso.driver.startup;

import android.content.Context;
import androidx.startup.Initializer;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsInitializer.kt */
/* loaded from: classes3.dex */
public final class AnalyticsInitializer implements Initializer<Unit> {
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public MixpanelController f26217a;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    public AppsflyerManager f26218b;

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit a(Context context) {
        b(context);
        return Unit.f50853a;
    }

    public void b(Context context) {
        Intrinsics.f(context, "context");
        Injector.f20166d.b().v0(this);
        c().c();
    }

    public final AppsflyerManager c() {
        AppsflyerManager appsflyerManager = this.f26218b;
        if (appsflyerManager != null) {
            return appsflyerManager;
        }
        Intrinsics.w("appsflyerManager");
        return null;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        List<Class<? extends Initializer<?>>> n8;
        n8 = CollectionsKt__CollectionsKt.n(DaggerInitializer.class, LogManagerInitializer.class, WorkManagerInitializer.class);
        return n8;
    }
}
