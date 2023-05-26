package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InMemoryChatStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.InMemoryChatStorage", f = "InMemoryChatStorage.kt", l = {106}, m = "updateMessage")
/* loaded from: classes5.dex */
public final class InMemoryChatStorage$updateMessage$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39634f;

    /* renamed from: g  reason: collision with root package name */
    Object f39635g;

    /* renamed from: h  reason: collision with root package name */
    Object f39636h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39637i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ InMemoryChatStorage f39638j;

    /* renamed from: k  reason: collision with root package name */
    int f39639k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryChatStorage$updateMessage$1(InMemoryChatStorage inMemoryChatStorage, Continuation<? super InMemoryChatStorage$updateMessage$1> continuation) {
        super(continuation);
        this.f39638j = inMemoryChatStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39637i = obj;
        this.f39639k |= Integer.MIN_VALUE;
        return this.f39638j.b(null, this);
    }
}
