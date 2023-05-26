package ee.mtakso.driver.network.client.driver;

import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
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
/* compiled from: DriverConfigurationClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.driver.DriverConfigurationClient$loadDriverConfiguration$1", f = "DriverConfigurationClient.kt", l = {18}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DriverConfigurationClient$loadDriverConfiguration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DriverConfiguration>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f21911g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DriverConfigurationClient f21912h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DriverConfigurationClient$loadDriverConfiguration$1(DriverConfigurationClient driverConfigurationClient, Continuation<? super DriverConfigurationClient$loadDriverConfiguration$1> continuation) {
        super(2, continuation);
        this.f21912h = driverConfigurationClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DriverConfigurationClient$loadDriverConfiguration$1(this.f21912h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super DriverConfiguration> continuation) {
        return ((DriverConfigurationClient$loadDriverConfiguration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        DriverConfigurationApi driverConfigurationApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f21911g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            driverConfigurationApi = this.f21912h.f21910b;
            this.f21911g = 1;
            obj = driverConfigurationApi.a(this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
