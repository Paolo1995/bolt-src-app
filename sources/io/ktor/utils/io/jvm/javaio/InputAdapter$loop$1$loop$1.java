package io.ktor.utils.io.jvm.javaio;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Blocking.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1", f = "Blocking.kt", l = {319, 38}, m = "loop")
/* loaded from: classes5.dex */
public final class InputAdapter$loop$1$loop$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f47496f;

    /* renamed from: g  reason: collision with root package name */
    Object f47497g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f47498h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ InputAdapter$loop$1 f47499i;

    /* renamed from: j  reason: collision with root package name */
    int f47500j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1$loop$1(InputAdapter$loop$1 inputAdapter$loop$1, Continuation<? super InputAdapter$loop$1$loop$1> continuation) {
        super(continuation);
        this.f47499i = inputAdapter$loop$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47498h = obj;
        this.f47500j |= Integer.MIN_VALUE;
        return this.f47499i.h(this);
    }
}
