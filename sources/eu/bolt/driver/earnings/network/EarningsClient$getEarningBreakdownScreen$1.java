package eu.bolt.driver.earnings.network;

import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarningsClient.kt */
@DebugMetadata(c = "eu.bolt.driver.earnings.network.EarningsClient$getEarningBreakdownScreen$1", f = "EarningsClient.kt", l = {20}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class EarningsClient$getEarningBreakdownScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EarningBreakdownScreen>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f41482g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ EarningsClient f41483h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ long f41484i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ long f41485j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsClient$getEarningBreakdownScreen$1(EarningsClient earningsClient, long j8, long j9, Continuation<? super EarningsClient$getEarningBreakdownScreen$1> continuation) {
        super(2, continuation);
        this.f41483h = earningsClient;
        this.f41484i = j8;
        this.f41485j = j9;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarningsClient$getEarningBreakdownScreen$1(this.f41483h, this.f41484i, this.f41485j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super EarningBreakdownScreen> continuation) {
        return ((EarningsClient$getEarningBreakdownScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        EarningsApi earningsApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f41482g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            earningsApi = this.f41483h.f41479a;
            long j8 = this.f41484i;
            long j9 = this.f41485j;
            this.f41482g = 1;
            obj = earningsApi.a(j8, j9, this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
