package eu.bolt.driver.earnings.network;

import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalClient.kt */
/* loaded from: classes5.dex */
public final class EarningsGoalClient {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsGoalApi f41494a;

    @Inject
    public EarningsGoalClient(EarningsGoalApi earningsGoalApi) {
        Intrinsics.f(earningsGoalApi, "earningsGoalApi");
        this.f41494a = earningsGoalApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetEarningsGoalResponse d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (GetEarningsGoalResponse) tmp0.invoke(obj);
    }

    public final Completable b() {
        Completable v7 = this.f41494a.a().v();
        Intrinsics.e(v7, "earningsGoalApi.deleteDr…ngsGoal().ignoreElement()");
        return v7;
    }

    public final Single<GetEarningsGoalResponse> c() {
        Single<ServerResponse<GetEarningsGoalResponse>> b8 = this.f41494a.b();
        final EarningsGoalClient$getDriverEarningsGoal$1 earningsGoalClient$getDriverEarningsGoal$1 = new Function1<ServerResponse<GetEarningsGoalResponse>, GetEarningsGoalResponse>() { // from class: eu.bolt.driver.earnings.network.EarningsGoalClient$getDriverEarningsGoal$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final GetEarningsGoalResponse invoke(ServerResponse<GetEarningsGoalResponse> it) {
                Intrinsics.f(it, "it");
                return (GetEarningsGoalResponse) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: eu.bolt.driver.earnings.network.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GetEarningsGoalResponse d8;
                d8 = EarningsGoalClient.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(x7, "earningsGoalApi.getDrive…).map { it.exposeData() }");
        return x7;
    }

    public final Completable e() {
        Completable v7 = this.f41494a.c().v();
        Intrinsics.e(v7, "earningsGoalApi.keepDriv…lTarget().ignoreElement()");
        return v7;
    }

    public final Completable f(SetEarningsGoalRequest request) {
        Intrinsics.f(request, "request");
        Completable v7 = this.f41494a.d(request).v();
        Intrinsics.e(v7, "earningsGoalApi.setDrive…(request).ignoreElement()");
        return v7;
    }
}
