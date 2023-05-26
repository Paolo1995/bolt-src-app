package eu.bolt.chat.client;

import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$handleChatLifeCycleEvent$2", f = "DefaultChatClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class DefaultChatClient$handleChatLifeCycleEvent$2 extends SuspendLambda implements Function2<Set<String>, Continuation<? super Boolean>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38742g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38743h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ String f38744i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$handleChatLifeCycleEvent$2(String str, Continuation<? super DefaultChatClient$handleChatLifeCycleEvent$2> continuation) {
        super(2, continuation);
        this.f38744i = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultChatClient$handleChatLifeCycleEvent$2 defaultChatClient$handleChatLifeCycleEvent$2 = new DefaultChatClient$handleChatLifeCycleEvent$2(this.f38744i, continuation);
        defaultChatClient$handleChatLifeCycleEvent$2.f38743h = obj;
        return defaultChatClient$handleChatLifeCycleEvent$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Set<String> set, Continuation<? super Boolean> continuation) {
        return ((DefaultChatClient$handleChatLifeCycleEvent$2) create(set, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38742g == 0) {
            ResultKt.b(obj);
            return Boxing.a(((Set) this.f38743h).add(this.f38744i));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
