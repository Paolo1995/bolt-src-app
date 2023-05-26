package eu.bolt.chat.client;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.util.CoroutineRunner;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: DefaultChatSubscriber.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatSubscriber$subscribeFor$3", f = "DefaultChatSubscriber.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class DefaultChatSubscriber$subscribeFor$3 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38881g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatSubscriber f38882h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ FlowCollector<MqttMessage> f38883i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultChatSubscriber$subscribeFor$3(DefaultChatSubscriber defaultChatSubscriber, FlowCollector<? super MqttMessage> flowCollector, Continuation<? super DefaultChatSubscriber$subscribeFor$3> continuation) {
        super(2, continuation);
        this.f38882h = defaultChatSubscriber;
        this.f38883i = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatSubscriber$subscribeFor$3(this.f38882h, this.f38883i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((DefaultChatSubscriber$subscribeFor$3) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        MutableSharedFlow mutableSharedFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38881g;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            mutableSharedFlow = this.f38882h.f38866i;
            FlowCollector<MqttMessage> flowCollector = this.f38883i;
            this.f38881g = 1;
            if (mutableSharedFlow.a(flowCollector, this) == d8) {
                return d8;
            }
        }
        throw new KotlinNothingValueException();
    }
}
