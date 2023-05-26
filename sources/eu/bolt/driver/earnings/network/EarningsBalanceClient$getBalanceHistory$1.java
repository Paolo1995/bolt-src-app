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
@DebugMetadata(c = "eu.bolt.driver.earnings.network.EarningsBalanceClient$getBalanceHistory$1", f = "EarningsBalanceClient.kt", l = {20}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class EarningsBalanceClient$getBalanceHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BalanceHistory>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f41472g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ EarningsBalanceClient f41473h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ String f41474i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ String f41475j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsBalanceClient$getBalanceHistory$1(EarningsBalanceClient earningsBalanceClient, String str, String str2, Continuation<? super EarningsBalanceClient$getBalanceHistory$1> continuation) {
        super(2, continuation);
        this.f41473h = earningsBalanceClient;
        this.f41474i = str;
        this.f41475j = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarningsBalanceClient$getBalanceHistory$1(this.f41473h, this.f41474i, this.f41475j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super BalanceHistory> continuation) {
        return ((EarningsBalanceClient$getBalanceHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        EarningsBalanceApi earningsBalanceApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f41472g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            earningsBalanceApi = this.f41473h.f41471a;
            String str = this.f41474i;
            String str2 = this.f41475j;
            this.f41472g = 1;
            obj = earningsBalanceApi.a(str, str2, this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
