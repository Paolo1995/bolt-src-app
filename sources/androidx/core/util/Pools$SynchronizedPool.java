package androidx.core.util;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Pools$SynchronizedPool<T> extends Pools$SimplePool<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f5912c;

    public Pools$SynchronizedPool(int i8) {
        super(i8);
        this.f5912c = new Object();
    }

    @Override // androidx.core.util.Pools$SimplePool, androidx.core.util.Pools$Pool
    public boolean a(@NonNull T t7) {
        boolean a8;
        synchronized (this.f5912c) {
            a8 = super.a(t7);
        }
        return a8;
    }

    @Override // androidx.core.util.Pools$SimplePool, androidx.core.util.Pools$Pool
    public T b() {
        T t7;
        synchronized (this.f5912c) {
            t7 = (T) super.b();
        }
        return t7;
    }
}
