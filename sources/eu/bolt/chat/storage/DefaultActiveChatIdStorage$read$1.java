package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveChatIdStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.DefaultActiveChatIdStorage", f = "ActiveChatIdStorage.kt", l = {68, 41}, m = "read")
/* loaded from: classes5.dex */
public final class DefaultActiveChatIdStorage$read$1<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39548f;

    /* renamed from: g  reason: collision with root package name */
    Object f39549g;

    /* renamed from: h  reason: collision with root package name */
    Object f39550h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39551i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ DefaultActiveChatIdStorage f39552j;

    /* renamed from: k  reason: collision with root package name */
    int f39553k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultActiveChatIdStorage$read$1(DefaultActiveChatIdStorage defaultActiveChatIdStorage, Continuation<? super DefaultActiveChatIdStorage$read$1> continuation) {
        super(continuation);
        this.f39552j = defaultActiveChatIdStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39551i = obj;
        this.f39553k |= Integer.MIN_VALUE;
        return this.f39552j.a(null, this);
    }
}
