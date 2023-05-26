package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Timeout.kt */
@DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {100}, m = "withTimeoutOrNull")
/* loaded from: classes5.dex */
public final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    long f51340f;

    /* renamed from: g  reason: collision with root package name */
    Object f51341g;

    /* renamed from: h  reason: collision with root package name */
    Object f51342h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f51343i;

    /* renamed from: j  reason: collision with root package name */
    int f51344j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutKt$withTimeoutOrNull$1(Continuation<? super TimeoutKt$withTimeoutOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51343i = obj;
        this.f51344j |= Integer.MIN_VALUE;
        return TimeoutKt.c(0L, null, this);
    }
}
