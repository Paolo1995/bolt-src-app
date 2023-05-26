package androidx.core.util;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Pools$SimplePool<T> implements Pools$Pool<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f5910a;

    /* renamed from: b  reason: collision with root package name */
    private int f5911b;

    public Pools$SimplePool(int i8) {
        if (i8 > 0) {
            this.f5910a = new Object[i8];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(@NonNull T t7) {
        for (int i8 = 0; i8 < this.f5911b; i8++) {
            if (this.f5910a[i8] == t7) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.Pools$Pool
    public boolean a(@NonNull T t7) {
        if (!c(t7)) {
            int i8 = this.f5911b;
            Object[] objArr = this.f5910a;
            if (i8 < objArr.length) {
                objArr[i8] = t7;
                this.f5911b = i8 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // androidx.core.util.Pools$Pool
    public T b() {
        int i8 = this.f5911b;
        if (i8 <= 0) {
            return null;
        }
        int i9 = i8 - 1;
        Object[] objArr = this.f5910a;
        T t7 = (T) objArr[i9];
        objArr[i9] = null;
        this.f5911b = i8 - 1;
        return t7;
    }
}
