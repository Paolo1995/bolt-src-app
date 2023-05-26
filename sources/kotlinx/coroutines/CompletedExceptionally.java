package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CompletionState.kt */
/* loaded from: classes5.dex */
public class CompletedExceptionally {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51233b = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f51234a;

    public CompletedExceptionally(Throwable th, boolean z7) {
        this.f51234a = th;
        this._handled = z7 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f51233b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return DebugStringsKt.a(this) + '[' + this.f51234a + ']';
    }

    public /* synthetic */ CompletedExceptionally(Throwable th, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i8 & 2) != 0 ? false : z7);
    }
}
