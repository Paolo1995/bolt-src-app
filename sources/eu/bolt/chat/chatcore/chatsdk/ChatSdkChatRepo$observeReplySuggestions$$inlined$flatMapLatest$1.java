package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.async.ObservableStateFlow;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.client.ChatClient;
import eu.bolt.chat.data.QuickReplySuggestion;
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
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1", f = "ChatSdkChatRepo.kt", l = {190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends QuickReplyEntity>>, ChatClient, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37978g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37979h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f37980i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ String f37981j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo f37982k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1(Continuation continuation, String str, ChatSdkChatRepo chatSdkChatRepo) {
        super(3, continuation);
        this.f37981j = str;
        this.f37982k = chatSdkChatRepo;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super List<? extends QuickReplyEntity>> flowCollector, ChatClient chatClient, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1 chatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1 = new ChatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1(continuation, this.f37981j, this.f37982k);
        chatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1.f37979h = flowCollector;
        chatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1.f37980i = chatClient;
        return chatSdkChatRepo$observeReplySuggestions$$inlined$flatMapLatest$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37978g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            final ObservableStateFlow<List<QuickReplySuggestion>> m8 = ((ChatClient) this.f37980i).c(this.f37981j).m();
            final ChatSdkChatRepo chatSdkChatRepo = this.f37982k;
            Flow<List<? extends QuickReplyEntity>> flow = new Flow<List<? extends QuickReplyEntity>>() { // from class: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f37985f;

                    /* renamed from: g  reason: collision with root package name */
                    final /* synthetic */ ChatSdkChatRepo f37986g;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1$2", f = "ChatSdkChatRepo.kt", l = {223}, m = "emit")
                    /* renamed from: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: f  reason: collision with root package name */
                        /* synthetic */ Object f37987f;

                        /* renamed from: g  reason: collision with root package name */
                        int f37988g;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f37987f = obj;
                            this.f37988g |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.b(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, ChatSdkChatRepo chatSdkChatRepo) {
                        this.f37985f = flowCollector;
                        this.f37986g = chatSdkChatRepo;
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
                            boolean r0 = r8 instanceof eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1$2$1 r0 = (eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f37988g
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f37988g = r1
                            goto L18
                        L13:
                            eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1$2$1 r0 = new eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.f37987f
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                            int r2 = r0.f37988g
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r8)
                            goto L6a
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            kotlin.ResultKt.b(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.f37985f
                            java.util.List r7 = (java.util.List) r7
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r4 = 10
                            int r4 = kotlin.collections.CollectionsKt.v(r7, r4)
                            r2.<init>(r4)
                            java.util.Iterator r7 = r7.iterator()
                        L47:
                            boolean r4 = r7.hasNext()
                            if (r4 == 0) goto L61
                            java.lang.Object r4 = r7.next()
                            eu.bolt.chat.data.QuickReplySuggestion r4 = (eu.bolt.chat.data.QuickReplySuggestion) r4
                            eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo r5 = r6.f37986g
                            eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper r5 = eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo.w(r5)
                            eu.bolt.chat.chatcore.entity.QuickReplyEntity r4 = r5.g(r4)
                            r2.add(r4)
                            goto L47
                        L61:
                            r0.f37988g = r3
                            java.lang.Object r7 = r8.b(r2, r0)
                            if (r7 != r1) goto L6a
                            return r1
                        L6a:
                            kotlin.Unit r7 = kotlin.Unit.f50853a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$observeReplySuggestions$lambda$29$$inlined$map$1.AnonymousClass2.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object a(FlowCollector<? super List<? extends QuickReplyEntity>> flowCollector, Continuation continuation) {
                    Object d9;
                    Object a8 = Flow.this.a(new AnonymousClass2(flowCollector, chatSdkChatRepo), continuation);
                    d9 = IntrinsicsKt__IntrinsicsKt.d();
                    if (a8 == d9) {
                        return a8;
                    }
                    return Unit.f50853a;
                }
            };
            this.f37978g = 1;
            if (FlowKt.l((FlowCollector) this.f37979h, flow, this) == d8) {
                return d8;
            }
        }
        return Unit.f50853a;
    }
}
