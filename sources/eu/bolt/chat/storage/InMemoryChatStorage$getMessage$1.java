package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InMemoryChatStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.InMemoryChatStorage", f = "InMemoryChatStorage.kt", l = {106}, m = "getMessage")
/* loaded from: classes5.dex */
public final class InMemoryChatStorage$getMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39612f;

    /* renamed from: g  reason: collision with root package name */
    Object f39613g;

    /* renamed from: h  reason: collision with root package name */
    Object f39614h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39615i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ InMemoryChatStorage f39616j;

    /* renamed from: k  reason: collision with root package name */
    int f39617k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryChatStorage$getMessage$1(InMemoryChatStorage inMemoryChatStorage, Continuation<? super InMemoryChatStorage$getMessage$1> continuation) {
        super(continuation);
        this.f39616j = inMemoryChatStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39615i = obj;
        this.f39617k |= Integer.MIN_VALUE;
        return this.f39616j.c(null, this);
    }
}
