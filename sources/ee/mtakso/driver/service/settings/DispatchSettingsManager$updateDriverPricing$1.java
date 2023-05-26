package ee.mtakso.driver.service.settings;

import ee.mtakso.driver.network.client.settings.SettingsResponse;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DispatchSettingsManager.kt */
/* loaded from: classes3.dex */
public final class DispatchSettingsManager$updateDriverPricing$1 extends Lambda implements Function1<EmptyServerResponse, SingleSource<? extends EmptyServerResponse>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DispatchSettingsManager f25963f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DispatchSettingsManager$updateDriverPricing$1(DispatchSettingsManager dispatchSettingsManager) {
        super(1);
        this.f25963f = dispatchSettingsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmptyServerResponse e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (EmptyServerResponse) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: d */
    public final SingleSource<? extends EmptyServerResponse> invoke(final EmptyServerResponse response) {
        Single G;
        Intrinsics.f(response, "response");
        G = this.f25963f.G();
        final Function1<Optional<SettingsResponse>, EmptyServerResponse> function1 = new Function1<Optional<SettingsResponse>, EmptyServerResponse>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$updateDriverPricing$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final EmptyServerResponse invoke(Optional<SettingsResponse> it) {
                Intrinsics.f(it, "it");
                return EmptyServerResponse.this;
            }
        };
        Single x7 = G.x(new Function() { // from class: ee.mtakso.driver.service.settings.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                EmptyServerResponse e8;
                e8 = DispatchSettingsManager$updateDriverPricing$1.e(Function1.this, obj);
                return e8;
            }
        });
        final Function1<Throwable, SingleSource<? extends EmptyServerResponse>> function12 = new Function1<Throwable, SingleSource<? extends EmptyServerResponse>>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$updateDriverPricing$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends EmptyServerResponse> invoke(Throwable it) {
                Intrinsics.f(it, "it");
                Kalev.m(it, "Failed to refresh settings after driver pricing method was saved");
                return Single.w(EmptyServerResponse.this);
            }
        };
        return x7.B(new Function() { // from class: ee.mtakso.driver.service.settings.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource g8;
                g8 = DispatchSettingsManager$updateDriverPricing$1.g(Function1.this, obj);
                return g8;
            }
        });
    }
}
