package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InMemoryChatStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.InMemoryChatStorage", f = "InMemoryChatStorage.kt", l = {106}, m = "updateChatDetails")
/* loaded from: classes5.dex */
public final class InMemoryChatStorage$updateChatDetails$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39628f;

    /* renamed from: g  reason: collision with root package name */
    Object f39629g;

    /* renamed from: h  reason: collision with root package name */
    Object f39630h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f39631i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ InMemoryChatStorage f39632j;

    /* renamed from: k  reason: collision with root package name */
    int f39633k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryChatStorage$updateChatDetails$1(InMemoryChatStorage inMemoryChatStorage, Continuation<? super InMemoryChatStorage$updateChatDetails$1> continuation) {
        super(continuation);
        this.f39632j = inMemoryChatStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39631i = obj;
        this.f39633k |= Integer.MIN_VALUE;
        return this.f39632j.a(null, this);
    }
}
