package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Produce.kt */
@DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
/* loaded from: classes5.dex */
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51418f;

    /* renamed from: g  reason: collision with root package name */
    Object f51419g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f51420h;

    /* renamed from: i  reason: collision with root package name */
    int f51421i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProduceKt$awaitClose$1(Continuation<? super ProduceKt$awaitClose$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51420h = obj;
        this.f51421i |= Integer.MIN_VALUE;
        return ProduceKt.a(null, null, this);
    }
}
