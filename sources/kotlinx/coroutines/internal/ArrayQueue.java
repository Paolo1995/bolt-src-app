package kotlinx.coroutines.internal;

import kotlin.collections.ArraysKt___ArraysJvmKt;

/* compiled from: ArrayQueue.kt */
/* loaded from: classes5.dex */
public class ArrayQueue<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f51770a = new Object[16];

    /* renamed from: b  reason: collision with root package name */
    private int f51771b;

    /* renamed from: c  reason: collision with root package name */
    private int f51772c;

    private final void b() {
        Object[] objArr = this.f51770a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        ArraysKt___ArraysJvmKt.i(objArr, objArr2, 0, this.f51771b, 0, 10, null);
        Object[] objArr3 = this.f51770a;
        int length2 = objArr3.length;
        int i8 = this.f51771b;
        ArraysKt___ArraysJvmKt.i(objArr3, objArr2, length2 - i8, 0, i8, 4, null);
        this.f51770a = objArr2;
        this.f51771b = 0;
        this.f51772c = length;
    }

    public final void a(T t7) {
        Object[] objArr = this.f51770a;
        int i8 = this.f51772c;
        objArr[i8] = t7;
        int length = (objArr.length - 1) & (i8 + 1);
        this.f51772c = length;
        if (length == this.f51771b) {
            b();
        }
    }

    public final boolean c() {
        if (this.f51771b == this.f51772c) {
            return true;
        }
        return false;
    }

    public final T d() {
        int i8 = this.f51771b;
        if (i8 == this.f51772c) {
            return null;
        }
        Object[] objArr = this.f51770a;
        T t7 = (T) objArr[i8];
        objArr[i8] = null;
        this.f51771b = (i8 + 1) & (objArr.length - 1);
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
