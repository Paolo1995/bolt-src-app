package ee.mtakso.driver.service.analytics.event.wrapper;

import android.annotation.SuppressLint;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributedAnalyticsDelegate.kt */
/* loaded from: classes3.dex */
public final class AttributedAnalyticsDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsImpl f23513a;

    /* renamed from: b  reason: collision with root package name */
    private final AdvertiserIdProvider f23514b;

    /* renamed from: c  reason: collision with root package name */
    private final AppsflyerManager f23515c;

    /* renamed from: d  reason: collision with root package name */
    private String f23516d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23517e;

    @Inject
    public AttributedAnalyticsDelegate(AnalyticsImpl analyticsImpl, AdvertiserIdProvider advertiserIdProvider, AppsflyerManager appsflyerManager) {
        Intrinsics.f(analyticsImpl, "analyticsImpl");
        Intrinsics.f(advertiserIdProvider, "advertiserIdProvider");
        Intrinsics.f(appsflyerManager, "appsflyerManager");
        this.f23513a = analyticsImpl;
        this.f23514b = advertiserIdProvider;
        this.f23515c = appsflyerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional i(AttributedAnalyticsDelegate this$0) {
        Intrinsics.f(this$0, "this$0");
        return Optional.f(this$0.f23514b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"CheckResult"})
    public final void h() {
        if (this.f23517e) {
            AnalyticsImpl analyticsImpl = this.f23513a;
            String b8 = this.f23515c.b();
            if (b8 == null) {
                b8 = "";
            }
            analyticsImpl.A4(b8, this.f23516d);
            return;
        }
        Single u7 = Single.u(new Callable() { // from class: ee.mtakso.driver.service.analytics.event.wrapper.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional i8;
                i8 = AttributedAnalyticsDelegate.i(AttributedAnalyticsDelegate.this);
                return i8;
            }
        });
        Intrinsics.e(u7, "fromCallable { // do not…          )\n            }");
        Single c8 = SingleExtKt.c(u7);
        final Function1<Optional<String>, Unit> function1 = new Function1<Optional<String>, Unit>() { // from class: ee.mtakso.driver.service.analytics.event.wrapper.AttributedAnalyticsDelegate$trackGoOnline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<String> optional) {
                AnalyticsImpl analyticsImpl2;
                AppsflyerManager appsflyerManager;
                AttributedAnalyticsDelegate.this.f23517e = true;
                AttributedAnalyticsDelegate.this.f23516d = optional.c();
                analyticsImpl2 = AttributedAnalyticsDelegate.this.f23513a;
                appsflyerManager = AttributedAnalyticsDelegate.this.f23515c;
                String b9 = appsflyerManager.b();
                if (b9 == null) {
                    b9 = "";
                }
                analyticsImpl2.A4(b9, optional.c());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<String> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.analytics.event.wrapper.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AttributedAnalyticsDelegate.j(Function1.this, obj);
            }
        };
        final AttributedAnalyticsDelegate$trackGoOnline$3 attributedAnalyticsDelegate$trackGoOnline$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.analytics.event.wrapper.AttributedAnalyticsDelegate$trackGoOnline$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Error sendng trackGoOnline");
            }
        };
        c8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.analytics.event.wrapper.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AttributedAnalyticsDelegate.k(Function1.this, obj);
            }
        });
    }
}
