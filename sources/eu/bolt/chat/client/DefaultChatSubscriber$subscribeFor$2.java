package eu.bolt.chat.client;

import eu.bolt.chat.client.DefaultChatSubscriber;
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
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: DefaultChatSubscriber.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatSubscriber$subscribeFor$2", f = "DefaultChatSubscriber.kt", l = {43}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class DefaultChatSubscriber$subscribeFor$2 extends SuspendLambda implements Function2<CoroutineRunner, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38878g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatSubscriber f38879h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ FlowCollector<DefaultChatSubscriber.SubscriptionStatus> f38880i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultChatSubscriber$subscribeFor$2(DefaultChatSubscriber defaultChatSubscriber, FlowCollector<? super DefaultChatSubscriber.SubscriptionStatus> flowCollector, Continuation<? super DefaultChatSubscriber$subscribeFor$2> continuation) {
        super(2, continuation);
        this.f38879h = defaultChatSubscriber;
        this.f38880i = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatSubscriber$subscribeFor$2(this.f38879h, this.f38880i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineRunner coroutineRunner, Continuation<? super Unit> continuation) {
        return ((DefaultChatSubscriber$subscribeFor$2) create(coroutineRunner, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        MutableStateFlow mutableStateFlow;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38878g;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            mutableStateFlow = this.f38879h.f38865h;
            FlowCollector<DefaultChatSubscriber.SubscriptionStatus> flowCollector = this.f38880i;
            this.f38878g = 1;
            if (mutableStateFlow.a(flowCollector, this) == d8) {
                return d8;
            }
        }
        throw new KotlinNothingValueException();
    }
}
