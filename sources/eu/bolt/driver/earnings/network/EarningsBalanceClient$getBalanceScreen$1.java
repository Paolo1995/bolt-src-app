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
/* compiled from: EarningsBalanceClient.kt */
@DebugMetadata(c = "eu.bolt.driver.earnings.network.EarningsBalanceClient$getBalanceScreen$1", f = "EarningsBalanceClient.kt", l = {14}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class EarningsBalanceClient$getBalanceScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BalanceScreen>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f41476g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ EarningsBalanceClient f41477h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsBalanceClient$getBalanceScreen$1(EarningsBalanceClient earningsBalanceClient, Continuation<? super EarningsBalanceClient$getBalanceScreen$1> continuation) {
        super(2, continuation);
        this.f41477h = earningsBalanceClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarningsBalanceClient$getBalanceScreen$1(this.f41477h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super BalanceScreen> continuation) {
        return ((EarningsBalanceClient$getBalanceScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        EarningsBalanceApi earningsBalanceApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f41476g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            earningsBalanceApi = this.f41477h.f41471a;
            this.f41476g = 1;
            obj = earningsBalanceApi.b(this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
