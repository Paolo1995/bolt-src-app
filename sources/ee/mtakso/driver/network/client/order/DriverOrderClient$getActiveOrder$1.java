package ee.mtakso.driver.network.client.order;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DriverOrderClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.order.DriverOrderClient", f = "DriverOrderClient.kt", l = {19}, m = "getActiveOrder")
/* loaded from: classes3.dex */
public final class DriverOrderClient$getActiveOrder$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f22337f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DriverOrderClient f22338g;

    /* renamed from: h  reason: collision with root package name */
    int f22339h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DriverOrderClient$getActiveOrder$1(DriverOrderClient driverOrderClient, Continuation<? super DriverOrderClient$getActiveOrder$1> continuation) {
        super(continuation);
        this.f22338g = driverOrderClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f22337f = obj;
        this.f22339h |= Integer.MIN_VALUE;
        return this.f22338g.c(null, this);
    }
}
