package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: Reading.kt */
/* loaded from: classes5.dex */
public final class ReadingKt {
    public static final ByteReadChannel a(InputStream inputStream, CoroutineContext context, ObjectPool<byte[]> pool) {
        Intrinsics.f(inputStream, "<this>");
        Intrinsics.f(context, "context");
        Intrinsics.f(pool, "pool");
        return CoroutinesKt.b(GlobalScope.f51286f, context, true, new ReadingKt$toByteReadChannel$2(pool, inputStream, null)).getChannel();
    }

    public static /* synthetic */ ByteReadChannel b(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = Dispatchers.b();
        }
        if ((i8 & 2) != 0) {
            objectPool = ByteArrayPoolKt.a();
        }
        return a(inputStream, coroutineContext, objectPool);
    }
}
