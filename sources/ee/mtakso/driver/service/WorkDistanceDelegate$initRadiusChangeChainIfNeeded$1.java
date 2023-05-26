package ee.mtakso.driver.service;

import ee.mtakso.driver.network.response.EmptyServerResponse;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: WorkDistanceDelegate.kt */
/* loaded from: classes3.dex */
final class WorkDistanceDelegate$initRadiusChangeChainIfNeeded$1 extends Lambda implements Function1<DriverAppConfig.MaxClientDistance, SingleSource<? extends DriverAppConfig.MaxClientDistance>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ WorkDistanceDelegate f23416f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkDistanceDelegate$initRadiusChangeChainIfNeeded$1(WorkDistanceDelegate workDistanceDelegate) {
        super(1);
        this.f23416f = workDistanceDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverAppConfig.MaxClientDistance d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverAppConfig.MaxClientDistance) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final SingleSource<? extends DriverAppConfig.MaxClientDistance> invoke(final DriverAppConfig.MaxClientDistance maxClientDistance) {
        Intrinsics.f(maxClientDistance, "maxClientDistance");
        Single<EmptyServerResponse> x7 = this.f23416f.o().x(maxClientDistance.a() / 1000.0d);
        final Function1<EmptyServerResponse, DriverAppConfig.MaxClientDistance> function1 = new Function1<EmptyServerResponse, DriverAppConfig.MaxClientDistance>() { // from class: ee.mtakso.driver.service.WorkDistanceDelegate$initRadiusChangeChainIfNeeded$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverAppConfig.MaxClientDistance invoke(EmptyServerResponse it) {
                Intrinsics.f(it, "it");
                return DriverAppConfig.MaxClientDistance.this;
            }
        };
        return x7.x(new Function() { // from class: ee.mtakso.driver.service.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverAppConfig.MaxClientDistance d8;
                d8 = WorkDistanceDelegate$initRadiusChangeChainIfNeeded$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
