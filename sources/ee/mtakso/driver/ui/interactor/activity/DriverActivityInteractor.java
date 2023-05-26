package ee.mtakso.driver.ui.interactor.activity;

import ee.mtakso.driver.network.client.driver.DriverActivityData;
import ee.mtakso.driver.network.client.driver.DriverCancels;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverHours;
import ee.mtakso.driver.network.client.driver.DriverRides;
import ee.mtakso.driver.ui.interactor.activity.DriverActivityInteractor;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function3;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverActivityInteractor.kt */
/* loaded from: classes3.dex */
public final class DriverActivityInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f26414a;

    @Inject
    public DriverActivityInteractor(DriverClient client) {
        Intrinsics.f(client, "client");
        this.f26414a = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverActivityData c(DriverHours t12, DriverRides t22, DriverCancels t32) {
        Intrinsics.f(t12, "t1");
        Intrinsics.f(t22, "t2");
        Intrinsics.f(t32, "t3");
        return new DriverActivityData(t12, t22, t32);
    }

    public final Single<DriverActivityData> b(String groupBy) {
        Intrinsics.f(groupBy, "groupBy");
        Single U = Single.U(this.f26414a.m(groupBy), this.f26414a.n(groupBy), this.f26414a.l(), new Function3() { // from class: o2.a
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                DriverActivityData c8;
                c8 = DriverActivityInteractor.c((DriverHours) obj, (DriverRides) obj2, (DriverCancels) obj3);
                return c8;
            }
        });
        Intrinsics.e(U, "zip(client.getDriverActi…)\n            }\n        )");
        return SingleExtKt.d(U);
    }
}
