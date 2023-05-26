package androidx.constraintlayout.core;

import j$.util.Spliterator;

/* loaded from: classes.dex */
public class Cache {

    /* renamed from: a  reason: collision with root package name */
    Pools$Pool<ArrayRow> f4338a = new Pools$Pool<T>(Spliterator.NONNULL) { // from class: androidx.constraintlayout.core.Pools$SimplePool

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f4395a;

        /* renamed from: b  reason: collision with root package name */
        private int f4396b;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            if (r2 > 0) {
                this.f4395a = new Object[r2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public boolean a(T t7) {
            int i8 = this.f4396b;
            Object[] objArr = this.f4395a;
            if (i8 < objArr.length) {
                objArr[i8] = t7;
                this.f4396b = i8 + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public T b() {
            int i8 = this.f4396b;
            if (i8 <= 0) {
                return null;
            }
            int i9 = i8 - 1;
            Object[] objArr = this.f4395a;
            T t7 = (T) objArr[i9];
            objArr[i9] = null;
            this.f4396b = i8 - 1;
            return t7;
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public void c(T[] tArr, int i8) {
            if (i8 > tArr.length) {
                i8 = tArr.length;
            }
            for (int i9 = 0; i9 < i8; i9++) {
                T t7 = tArr[i9];
                int i10 = this.f4396b;
                Object[] objArr = this.f4395a;
                if (i10 < objArr.length) {
                    objArr[i10] = t7;
                    this.f4396b = i10 + 1;
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    Pools$Pool<ArrayRow> f4339b = new Pools$Pool<T>(Spliterator.NONNULL) { // from class: androidx.constraintlayout.core.Pools$SimplePool

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f4395a;

        /* renamed from: b  reason: collision with root package name */
        private int f4396b;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            if (r2 > 0) {
                this.f4395a = new Object[r2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public boolean a(T t7) {
            int i8 = this.f4396b;
            Object[] objArr = this.f4395a;
            if (i8 < objArr.length) {
                objArr[i8] = t7;
                this.f4396b = i8 + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public T b() {
            int i8 = this.f4396b;
            if (i8 <= 0) {
                return null;
            }
            int i9 = i8 - 1;
            Object[] objArr = this.f4395a;
            T t7 = (T) objArr[i9];
            objArr[i9] = null;
            this.f4396b = i8 - 1;
            return t7;
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public void c(T[] tArr, int i8) {
            if (i8 > tArr.length) {
                i8 = tArr.length;
            }
            for (int i9 = 0; i9 < i8; i9++) {
                T t7 = tArr[i9];
                int i10 = this.f4396b;
                Object[] objArr = this.f4395a;
                if (i10 < objArr.length) {
                    objArr[i10] = t7;
                    this.f4396b = i10 + 1;
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    Pools$Pool<SolverVariable> f4340c = new Pools$Pool<T>(Spliterator.NONNULL) { // from class: androidx.constraintlayout.core.Pools$SimplePool

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f4395a;

        /* renamed from: b  reason: collision with root package name */
        private int f4396b;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            if (r2 > 0) {
                this.f4395a = new Object[r2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public boolean a(T t7) {
            int i8 = this.f4396b;
            Object[] objArr = this.f4395a;
            if (i8 < objArr.length) {
                objArr[i8] = t7;
                this.f4396b = i8 + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public T b() {
            int i8 = this.f4396b;
            if (i8 <= 0) {
                return null;
            }
            int i9 = i8 - 1;
            Object[] objArr = this.f4395a;
            T t7 = (T) objArr[i9];
            objArr[i9] = null;
            this.f4396b = i8 - 1;
            return t7;
        }

        @Override // androidx.constraintlayout.core.Pools$Pool
        public void c(T[] tArr, int i8) {
            if (i8 > tArr.length) {
                i8 = tArr.length;
            }
            for (int i9 = 0; i9 < i8; i9++) {
                T t7 = tArr[i9];
                int i10 = this.f4396b;
                Object[] objArr = this.f4395a;
                if (i10 < objArr.length) {
                    objArr[i10] = t7;
                    this.f4396b = i10 + 1;
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    SolverVariable[] f4341d = new SolverVariable[32];
}
