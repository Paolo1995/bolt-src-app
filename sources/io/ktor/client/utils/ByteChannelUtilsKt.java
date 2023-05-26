package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannelUtils.kt */
/* loaded from: classes5.dex */
public final class ByteChannelUtilsKt {
    public static final ByteReadChannel a(ByteReadChannel byteReadChannel, CoroutineContext context, Long l8, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> listener) {
        Intrinsics.f(byteReadChannel, "<this>");
        Intrinsics.f(context, "context");
        Intrinsics.f(listener, "listener");
        return CoroutinesKt.b(GlobalScope.f51286f, context, true, new ByteChannelUtilsKt$observable$1(l8, byteReadChannel, listener, null)).getChannel();
    }
}
