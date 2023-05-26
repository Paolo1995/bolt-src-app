package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f6902a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6903b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final DiffUtil.ItemCallback<T> f6904c;

    /* loaded from: classes.dex */
    public static final class Builder<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f6905d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f6906e;

        /* renamed from: a  reason: collision with root package name */
        private Executor f6907a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f6908b;

        /* renamed from: c  reason: collision with root package name */
        private final DiffUtil.ItemCallback<T> f6909c;

        public Builder(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            this.f6909c = itemCallback;
        }

        @NonNull
        public AsyncDifferConfig<T> a() {
            if (this.f6908b == null) {
                synchronized (f6905d) {
                    if (f6906e == null) {
                        f6906e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f6908b = f6906e;
            }
            return new AsyncDifferConfig<>(this.f6907a, this.f6908b, this.f6909c);
        }
    }

    AsyncDifferConfig(Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.f6902a = executor;
        this.f6903b = executor2;
        this.f6904c = itemCallback;
    }

    @NonNull
    public Executor a() {
        return this.f6903b;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> b() {
        return this.f6904c;
    }

    public Executor c() {
        return this.f6902a;
    }
}
