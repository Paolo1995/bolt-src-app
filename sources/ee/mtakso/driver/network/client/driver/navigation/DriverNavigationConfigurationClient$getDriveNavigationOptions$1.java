package ee.mtakso.driver.network.client.driver.navigation;

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
/* compiled from: DriverNavigationConfigurationClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationClient$getDriveNavigationOptions$1", f = "DriverNavigationConfigurationClient.kt", l = {17}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DriverNavigationConfigurationClient$getDriveNavigationOptions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DynamicNavigation>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f22059g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DriverNavigationConfigurationClient f22060h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DriverNavigationConfigurationClient$getDriveNavigationOptions$1(DriverNavigationConfigurationClient driverNavigationConfigurationClient, Continuation<? super DriverNavigationConfigurationClient$getDriveNavigationOptions$1> continuation) {
        super(2, continuation);
        this.f22060h = driverNavigationConfigurationClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DriverNavigationConfigurationClient$getDriveNavigationOptions$1(this.f22060h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super DynamicNavigation> continuation) {
        return ((DriverNavigationConfigurationClient$getDriveNavigationOptions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        DriverNavigationConfigurationApi driverNavigationConfigurationApi;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f22059g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            driverNavigationConfigurationApi = this.f22060h.f22058b;
            this.f22059g = 1;
            obj = driverNavigationConfigurationApi.a(this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
