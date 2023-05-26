package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.data.message.ChatMessage;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Merge.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1", f = "ChatSdkChatRepo.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends ChatMessageEntity>>, ChatClient, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37949g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37950h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f37951i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ String f37952j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f37953k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1(Continuation continuation, String str, ChatSdkChatRepo chatSdkChatRepo) {
        super(3, continuation);
        this.f37952j = str;
        this.f37953k = chatSdkChatRepo;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super List<? extends ChatMessageEntity>> flowCollector, ChatClient chatClient, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1 chatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1 = new ChatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1(continuation, this.f37952j, this.f37953k);
        chatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1.f37950h = flowCollector;
        chatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1.f37951i = chatClient;
        return chatSdkChatRepo$observeChatMessages$$inlined$flatMapLatest$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37949g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            final ObservableStateFlow<List<ChatMessage>> j8 = ((ChatClient) this.f37951i).c(this.f37952j).j();
            final ChatSdkChatRepo chatSdkChatRepo = this.f37953k;
            Flow<List<? extends ChatMessageEntity>> flow = new Flow<List<? extends ChatMessageEntity>>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f37956f;

                    /* renamed from: g  reason: collision with root package name */
                    final /* synthetic */ ChatSdkChatRepo f37957g;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1$2", f = "ChatSdkChatRepo.kt", l = {223}, m = "emit")
                    /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: f  reason: collision with root package name */
                        /* synthetic */ Object f37958f;

                        /* renamed from: g  reason: collision with root package name */
                        int f37959g;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f37958f = obj;
                            this.f37959g |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.b(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, ChatSdkChatRepo chatSdkChatRepo) {
                        this.f37956f = flowCollector;
                        this.f37957g = chatSdkChatRepo;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object b(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f37959g
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f37959g = r1
                            goto L18
                        L13:
                            eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.f37958f
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                            int r2 = r0.f37959g
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r8)
                            goto L88
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            kotlin.ResultKt.b(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.f37956f
                            java.util.List r7 = (java.util.List) r7
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r2.<init>()
                            java.util.Iterator r7 = r7.iterator()
                        L41:
                            boolean r4 = r7.hasNext()
                            if (r4 == 0) goto L56
                            java.lang.Object r4 = r7.next()
                            r5 = r4
                            eu.bolt.chat.data.message.ChatMessage r5 = (eu.bolt.chat.data.message.ChatMessage) r5
                            boolean r5 = r5 instanceof eu.bolt.chat.data.message.EndingServiceMessage
                            if (r5 != 0) goto L41
                            r2.add(r4)
                            goto L41
                        L56:
                            java.util.ArrayList r7 = new java.util.ArrayList
                            r4 = 10
                            int r4 = kotlin.collections.CollectionsKt.v(r2, r4)
                            r7.<init>(r4)
                            java.util.Iterator r2 = r2.iterator()
                        L65:
                            boolean r4 = r2.hasNext()
                            if (r4 == 0) goto L7f
                            java.lang.Object r4 = r2.next()
                            eu.bolt.chat.data.message.ChatMessage r4 = (eu.bolt.chat.data.message.ChatMessage) r4
                            eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo r5 = r6.f37957g
                            eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper r5 = eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.w(r5)
                            eu.bolt.chat.chatcore.entity.ChatMessageEntity r4 = r5.a(r4)
                            r7.add(r4)
                            goto L65
                        L7f:
                            r0.f37959g = r3
                            java.lang.Object r7 = r8.b(r7, r0)
                            if (r7 != r1) goto L88
                            return r1
                        L88:
                            kotlin.Unit r7 = kotlin.Unit.f50853a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeChatMessages$lambda$16$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object a(FlowCollector<? super List<? extends ChatMessageEntity>> flowCollector, Continuation continuation) {
                    Object d9;
                    Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, chatSdkChatRepo), continuation);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (a8 == d9) {
                        return a8;
                    }
                    return Unit.f50853a;
                }
            };
            this.f37949g = 1;
            if (FlowKt.l((FlowCollector) this.f37950h, flow, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
