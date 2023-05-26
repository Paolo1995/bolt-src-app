package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class Edge<T> implements Consumer<T> {

    /* renamed from: a  reason: collision with root package name */
    private Consumer<T> f3972a;

    public void a(@NonNull Consumer<T> consumer) {
        this.f3972a = consumer;
    }

    @Override // androidx.core.util.Consumer
    public void accept(@NonNull T t7) {
        Intrinsics.d(this.f3972a, "Listener is not set.");
        this.f3972a.accept(t7);
    }
}
