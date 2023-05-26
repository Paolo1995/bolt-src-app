package eu.bolt.chat.client;

import eu.bolt.chat.data.Chat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$syncActiveChats$lastKnownActiveChats$1", f = "DefaultChatClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$syncActiveChats$lastKnownActiveChats$1 extends SuspendLambda implements Function2<Set<String>, Continuation<? super Set<? extends String>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38822g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38823h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ List<Chat> f38824i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatClient$syncActiveChats$lastKnownActiveChats$1(List<Chat> list, Continuation<? super DefaultChatClient$syncActiveChats$lastKnownActiveChats$1> continuation) {
        super(2, continuation);
        this.f38824i = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultChatClient$syncActiveChats$lastKnownActiveChats$1 defaultChatClient$syncActiveChats$lastKnownActiveChats$1 = new DefaultChatClient$syncActiveChats$lastKnownActiveChats$1(this.f38824i, continuation);
        defaultChatClient$syncActiveChats$lastKnownActiveChats$1.f38823h = obj;
        return defaultChatClient$syncActiveChats$lastKnownActiveChats$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(Set<String> set, Continuation<? super Set<String>> continuation) {
        return ((DefaultChatClient$syncActiveChats$lastKnownActiveChats$1) create(set, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Set w02;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38822g == 0) {
            ResultKt.b(obj);
            Set set = (Set) this.f38823h;
            HashSet hashSet = new HashSet(set);
            set.clear();
            for (Chat chat : this.f38824i) {
                set.add(chat.d());
            }
            w02 = CollectionsKt___CollectionsKt.w0(hashSet, set);
            return w02;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
