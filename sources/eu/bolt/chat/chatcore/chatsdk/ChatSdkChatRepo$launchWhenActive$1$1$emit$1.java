package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkChatRepo.kt */
@DebugMetadata(c = "eu.bolt.chat.chatcore.chatsdk.ChatSdkChatRepo$launchWhenActive$1$1", f = "ChatSdkChatRepo.kt", l = {378}, m = "emit")
/* loaded from: classes5.dex */
public final class ChatSdkChatRepo$launchWhenActive$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f38028f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f38029g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ChatSdkChatRepo$launchWhenActive$1.AnonymousClass1<T> f38030h;

    /* renamed from: i  reason: collision with root package name */
    int f38031i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatSdkChatRepo$launchWhenActive$1$1$emit$1(ChatSdkChatRepo$launchWhenActive$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super ChatSdkChatRepo$launchWhenActive$1$1$emit$1> continuation) {
        super(continuation);
        this.f38030h = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f38029g = obj;
        this.f38031i |= Integer.MIN_VALUE;
        return this.f38030h.b(null, this);
    }
}
