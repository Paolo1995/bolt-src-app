package eu.bolt.chat.network.engine;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.engine.PublishingEvent;
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
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$onMessagePublished$1", f = "PlatformMqttClientDelegateImpl.kt", l = {63, 64}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class PlatformMqttClientDelegateImpl$onMessagePublished$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39503g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39504h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ int f39505i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$onMessagePublished$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, int i8, Continuation<? super PlatformMqttClientDelegateImpl$onMessagePublished$1> continuation) {
        super(2, continuation);
        this.f39504h = platformMqttClientDelegateImpl;
        this.f39505i = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformMqttClientDelegateImpl$onMessagePublished$1(this.f39504h, this.f39505i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((PlatformMqttClientDelegateImpl$onMessagePublished$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Logger logger;
        MutableSharedFlow mutableSharedFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39503g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            logger = this.f39504h.f39477b;
            int i9 = this.f39505i;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Info;
            if (a8.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, null, "Message with ID = " + i9 + " is published");
            }
            PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl = this.f39504h;
            int i10 = this.f39505i;
            this.f39503g = 1;
            obj = platformMqttClientDelegateImpl.r(i10, this);
            if (obj == d8) {
                return d8;
            }
        }
        MqttMessage mqttMessage = (MqttMessage) obj;
        if (mqttMessage != null) {
            PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl2 = this.f39504h;
            int i11 = this.f39505i;
            mutableSharedFlow = platformMqttClientDelegateImpl2.f39482g;
            IdentifiablePublishingEvent identifiablePublishingEvent = new IdentifiablePublishingEvent(i11, new PublishingEvent.Success(mqttMessage));
            this.f39503g = 2;
            if (mutableSharedFlow.b(identifiablePublishingEvent, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
