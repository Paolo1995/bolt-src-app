package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class FactoryPools {

    /* renamed from: a  reason: collision with root package name */
    private static final Resetter<Object> f10790a = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void a(@NonNull Object obj) {
        }
    };

    /* loaded from: classes.dex */
    public interface Factory<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FactoryPool<T> implements Pools$Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Factory<T> f10791a;

        /* renamed from: b  reason: collision with root package name */
        private final Resetter<T> f10792b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools$Pool<T> f10793c;

        FactoryPool(@NonNull Pools$Pool<T> pools$Pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.f10793c = pools$Pool;
            this.f10791a = factory;
            this.f10792b = resetter;
        }

        @Override // androidx.core.util.Pools$Pool
        public boolean a(@NonNull T t7) {
            if (t7 instanceof Poolable) {
                ((Poolable) t7).e().b(true);
            }
            this.f10792b.a(t7);
            return this.f10793c.a(t7);
        }

        @Override // androidx.core.util.Pools$Pool
        public T b() {
            T b8 = this.f10793c.b();
            if (b8 == null) {
                b8 = this.f10791a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b8.getClass());
                }
            }
            if (b8 instanceof Poolable) {
                ((Poolable) b8).e().b(false);
            }
            return b8;
        }
    }

    /* loaded from: classes.dex */
    public interface Poolable {
        @NonNull
        StateVerifier e();
    }

    /* loaded from: classes.dex */
    public interface Resetter<T> {
        void a(@NonNull T t7);
    }

    private FactoryPools() {
    }

    @NonNull
    private static <T extends Poolable> Pools$Pool<T> a(@NonNull Pools$Pool<T> pools$Pool, @NonNull Factory<T> factory) {
        return b(pools$Pool, factory, c());
    }

    @NonNull
    private static <T> Pools$Pool<T> b(@NonNull Pools$Pool<T> pools$Pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new FactoryPool(pools$Pool, factory, resetter);
    }

    @NonNull
    private static <T> Resetter<T> c() {
        return (Resetter<T>) f10790a;
    }

    @NonNull
    public static <T extends Poolable> Pools$Pool<T> d(int i8, @NonNull Factory<T> factory) {
        return a(new Pools$SynchronizedPool(i8), factory);
    }

    @NonNull
    public static <T> Pools$Pool<List<T>> e() {
        return f(20);
    }

    @NonNull
    public static <T> Pools$Pool<List<T>> f(int i8) {
        return b(new Pools$SynchronizedPool(i8), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            @NonNull
            /* renamed from: b */
            public List<T> a() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            /* renamed from: b */
            public void a(@NonNull List<T> list) {
                list.clear();
            }
        });
    }
}
