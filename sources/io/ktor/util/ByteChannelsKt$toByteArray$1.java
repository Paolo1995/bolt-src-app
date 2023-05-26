package io.ktor.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", l = {90}, m = "toByteArray")
/* loaded from: classes5.dex */
public final class ByteChannelsKt$toByteArray$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f47027f;

    /* renamed from: g  reason: collision with root package name */
    int f47028g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteChannelsKt$toByteArray$1(Continuation<? super ByteChannelsKt$toByteArray$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f47027f = obj;
        this.f47028g |= Integer.MIN_VALUE;
        return ByteChannelsKt.c(null, this);
    }
}
