package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f6658f;

    public CloseableCoroutineScope(CoroutineContext context) {
        Intrinsics.f(context, "context");
        this.f6658f = context;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JobKt__JobKt.e(j(), null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext j() {
        return this.f6658f;
    }
}
