package eu.bolt.chat.network.engine;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.engine.PublishingEvent;
import eu.bolt.chat.network.exception.PublishingException;
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
@DebugMetadata(c = "eu.bolt.chat.network.engine.PlatformMqttClientDelegateImpl$onPublishError$1", f = "PlatformMqttClientDelegateImpl.kt", l = {78, 79}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class PlatformMqttClientDelegateImpl$onPublishError$1 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f39509g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ PlatformMqttClientDelegateImpl f39510h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ PublishingException f39511i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ int f39512j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformMqttClientDelegateImpl$onPublishError$1(PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl, PublishingException publishingException, int i8, Continuation<? super PlatformMqttClientDelegateImpl$onPublishError$1> continuation) {
        super(2, continuation);
        this.f39510h = platformMqttClientDelegateImpl;
        this.f39511i = publishingException;
        this.f39512j = i8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlatformMqttClientDelegateImpl$onPublishError$1(this.f39510h, this.f39511i, this.f39512j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((PlatformMqttClientDelegateImpl$onPublishError$1) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Logger logger;
        MutableSharedFlow mutableSharedFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f39509g;
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
            logger = this.f39510h.f39477b;
            PublishingException publishingException = this.f39511i;
            int i9 = this.f39512j;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Warn;
            if (a8.compareTo(severity) <= 0) {
                String d9 = logger.d();
                logger.f(severity, d9, publishingException, "Unable to publish message: " + i9);
            }
            PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl = this.f39510h;
            int i10 = this.f39512j;
            this.f39509g = 1;
            obj = platformMqttClientDelegateImpl.r(i10, this);
            if (obj == d8) {
                return d8;
            }
        }
        MqttMessage mqttMessage = (MqttMessage) obj;
        if (mqttMessage != null) {
            PlatformMqttClientDelegateImpl platformMqttClientDelegateImpl2 = this.f39510h;
            int i11 = this.f39512j;
            PublishingException publishingException2 = this.f39511i;
            mutableSharedFlow = platformMqttClientDelegateImpl2.f39482g;
            IdentifiablePublishingEvent identifiablePublishingEvent = new IdentifiablePublishingEvent(i11, new PublishingEvent.Failure(mqttMessage, publishingException2));
            this.f39509g = 2;
            if (mutableSharedFlow.b(identifiablePublishingEvent, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
