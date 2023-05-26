package eu.bolt.chat.storage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InMemoryChatStorage.kt */
@DebugMetadata(c = "eu.bolt.chat.storage.InMemoryChatStorage", f = "InMemoryChatStorage.kt", l = {106}, m = "getMessages")
/* loaded from: classes5.dex */
public final class InMemoryChatStorage$getMessages$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f39618f;

    /* renamed from: g  reason: collision with root package name */
    Object f39619g;

    /* renamed from: h  reason: collision with root package name */
    Object f39620h;

    /* renamed from: i  reason: collision with root package name */
    Object f39621i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f39622j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ InMemoryChatStorage f39623k;

    /* renamed from: l  reason: collision with root package name */
    int f39624l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InMemoryChatStorage$getMessages$1(InMemoryChatStorage inMemoryChatStorage, Continuation<? super InMemoryChatStorage$getMessages$1> continuation) {
        super(continuation);
        this.f39623k = inMemoryChatStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39622j = obj;
        this.f39624l |= Integer.MIN_VALUE;
        return this.f39623k.d(null, null, this);
    }
}
