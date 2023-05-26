package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo;
import eu.bolt.chat.client.ChatClient;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Merge.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1", f = "ChatSdkChatRepo.kt", l = {217, 190}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, ChatSdkChatRepo.RepoStatus, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f37920g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f37921h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f37922i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ Function2 f37923j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Object f37924k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1(Continuation continuation, Function2 function2, Object obj) {
        super(3, continuation);
        this.f37923j = function2;
        this.f37924k = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(FlowCollector<? super T> flowCollector, ChatSdkChatRepo.RepoStatus repoStatus, Continuation<? super Unit> continuation) {
        ChatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1 chatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1 = new ChatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1(continuation, this.f37923j, this.f37924k);
        chatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1.f37921h = flowCollector;
        chatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1.f37922i = repoStatus;
        return chatSdkChatRepo$flatMapWhenActive$$inlined$flatMapLatest$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        FlowCollector flowCollector;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f37920g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.f37921h;
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            flowCollector = (FlowCollector) this.f37921h;
            ChatSdkChatRepo.RepoStatus repoStatus = (ChatSdkChatRepo.RepoStatus) this.f37922i;
            if (repoStatus instanceof ChatSdkChatRepo.RepoStatus.Active) {
                Function2 function2 = this.f37923j;
                ChatClient a8 = ((ChatSdkChatRepo.RepoStatus.Active) repoStatus).a();
                this.f37921h = flowCollector;
                this.f37920g = 1;
                InlineMarker.c(6);
                obj = function2.s(a8, this);
                InlineMarker.c(7);
                if (obj == d8) {
                    return d8;
                }
            } else if (repoStatus instanceof ChatSdkChatRepo.RepoStatus.Idle) {
                Object obj2 = this.f37924k;
                if (obj2 != null) {
                    obj = FlowKt.A(obj2);
                } else {
                    obj = FlowKt.m();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        this.f37921h = null;
        this.f37920g = 2;
        if (FlowKt.l(flowCollector, (Flow) obj, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
