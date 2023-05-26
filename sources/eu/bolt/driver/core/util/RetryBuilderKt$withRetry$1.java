package eu.bolt.driver.core.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetryBuilder.kt */
@DebugMetadata(c = "eu.bolt.driver.core.util.RetryBuilderKt", f = "RetryBuilder.kt", l = {12, 15}, m = "withRetry")
/* loaded from: classes5.dex */
public final class RetryBuilderKt$withRetry$1<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f41318f;

    /* renamed from: g  reason: collision with root package name */
    Object f41319g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f41320h;

    /* renamed from: i  reason: collision with root package name */
    int f41321i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryBuilderKt$withRetry$1(Continuation<? super RetryBuilderKt$withRetry$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f41320h = obj;
        this.f41321i |= Integer.MIN_VALUE;
        return RetryBuilderKt.a(null, null, this);
    }
}
