package io.ktor.client.call;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SavedCall.kt */
@DebugMetadata(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", l = {73}, m = "save")
/* loaded from: classes5.dex */
public final class SavedCallKt$save$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f46085f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f46086g;

    /* renamed from: h  reason: collision with root package name */
    int f46087h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedCallKt$save$1(Continuation<? super SavedCallKt$save$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f46086g = obj;
        this.f46087h |= Integer.MIN_VALUE;
        return SavedCallKt.a(null, this);
    }
}
