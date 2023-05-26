package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InMemoryChatStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.InMemoryChatStorage", f = "InMemoryChatStorage.kt", l = {96}, m = "getMessagesCount")
/* loaded from: classes5.dex */
public final class InMemoryChatStorage$getMessagesCount$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f39625f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ InMemoryChatStorage f39626g;

    /* renamed from: h  reason: collision with root package name */
    int f39627h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryChatStorage$getMessagesCount$1(InMemoryChatStorage inMemoryChatStorage, Continuation<? super InMemoryChatStorage$getMessagesCount$1> continuation) {
        super(continuation);
        this.f39626g = inMemoryChatStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39625f = obj;
        this.f39627h |= Integer.MIN_VALUE;
        return this.f39626g.f(null, null, this);
    }
}
