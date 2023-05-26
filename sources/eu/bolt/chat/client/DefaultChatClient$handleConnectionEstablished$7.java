package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.data.ClientStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$7", f = "DefaultChatClient.kt", l = {167}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$handleConnectionEstablished$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38762g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ DefaultChatClient f38763h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultChatClient.kt */
    @DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$7$1", f = "DefaultChatClient.kt", l = {168}, m = "invokeSuspend")
    /* renamed from: eu.bolt.chat.client.DefaultChatClient$handleConnectionEstablished$7$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f38764g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ DefaultChatClient f38765h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DefaultChatClient defaultChatClient, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.f38765h = defaultChatClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.f38765h, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: h */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            MutableStateFlow mutableStateFlow;
            Logger logger;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f38764g;
            if (i8 != 0) {
                if (i8 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.b(obj);
                mutableStateFlow = this.f38765h.f38655m;
                ClientStatus clientStatus = ClientStatus.CONNECTED;
                this.f38764g = 1;
                if (mutableStateFlow.b(clientStatus, this) == d8) {
                    return d8;
                }
            }
            logger = this.f38765h.f38643a;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Info;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "Chat client is all set and ready to be used");
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleConnectionEstablished$7(DefaultChatClient defaultChatClient, Continuation<? super DefaultChatClient$handleConnectionEstablished$7> continuation) {
        super(2, continuation);
        this.f38763h = defaultChatClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultChatClient$handleConnectionEstablished$7(this.f38763h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultChatClient$handleConnectionEstablished$7) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        Object l02;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f38762g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            DefaultChatClient defaultChatClient = this.f38763h;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(defaultChatClient, null);
            this.f38762g = 1;
            l02 = defaultChatClient.l0(anonymousClass1, this);
            if (l02 == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
