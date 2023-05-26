package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveChatIdStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.DefaultActiveChatIdStorage", f = "ActiveChatIdStorage.kt", l = {68, 36}, m = "write")
/* loaded from: classes5.dex */
public final class DefaultActiveChatIdStorage$write$1<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39554f;

    /* renamed from: g  reason: collision with root package name */
    Object f39555g;

    /* renamed from: h  reason: collision with root package name */
    Object f39556h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39557i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ DefaultActiveChatIdStorage f39558j;

    /* renamed from: k  reason: collision with root package name */
    int f39559k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultActiveChatIdStorage$write$1(DefaultActiveChatIdStorage defaultActiveChatIdStorage, Continuation<? super DefaultActiveChatIdStorage$write$1> continuation) {
        super(continuation);
        this.f39558j = defaultActiveChatIdStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39557i = obj;
        this.f39559k |= Integer.MIN_VALUE;
        return this.f39558j.b(null, this);
    }
}
