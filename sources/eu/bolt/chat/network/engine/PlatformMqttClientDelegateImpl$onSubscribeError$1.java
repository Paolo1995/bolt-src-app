package eu.bolt.chat.network.engine;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.network.engine.SubscriptionEvent;
import eu.bolt.chat.network.exception.SubscriptionException;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: PlatformMqttClientDelegateImpl.kt */
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$onSubscribeError$1", f = "PlatformMqttClientDelegateImpl.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class PlatformMqttClientDelegateImpl$onSubscribeError$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39513g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39514h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ SubscriptionException f39515i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ String f39516j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$onSubscribeError$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, SubscriptionException subscriptionException, String str, Continuation<? super PlatformMqttClientDelegateImpl$onSubscribeError$1> continuation) {
        super(2, continuation);
        this.f39514h = platformMqttClientDelegateImpl;
        this.f39515i = subscriptionException;
        this.f39516j = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformMqttClientDelegateImpl$onSubscribeError$1(this.f39514h, this.f39515i, this.f39516j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((PlatformMqttClientDelegateImpl$onSubscribeError$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Logger logger;
        MutableSharedFlow mutableSharedFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39513g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            logger = this.f39514h.f39477b;
            SubscriptionException subscriptionException = this.f39515i;
            String str = this.f39516j;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Warn;
            if (a8.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, subscriptionException, "Unable to subscribe topic '" + str + '\'');
            }
            mutableSharedFlow = this.f39514h.f39481f;
            SubscriptionEvent.Failure failure = new SubscriptionEvent.Failure(this.f39516j, this.f39515i);
            this.f39513g = 1;
            if (mutableSharedFlow.b(failure, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
