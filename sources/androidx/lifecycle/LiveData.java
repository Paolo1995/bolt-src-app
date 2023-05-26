package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: p  reason: collision with root package name */
    static final Object f6694p = new Object();

    /* renamed from: f  reason: collision with root package name */
    final Object f6695f;

    /* renamed from: g  reason: collision with root package name */
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> f6696g;

    /* renamed from: h  reason: collision with root package name */
    int f6697h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6698i;

    /* renamed from: j  reason: collision with root package name */
    private volatile Object f6699j;

    /* renamed from: k  reason: collision with root package name */
    volatile Object f6700k;

    /* renamed from: l  reason: collision with root package name */
    private int f6701l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6702m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f6703n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f6704o;

    /* loaded from: classes.dex */
    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean e() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        final LifecycleOwner f6707j;

        LifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.f6707j = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        void c() {
            this.f6707j.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean d(LifecycleOwner lifecycleOwner) {
            if (this.f6707j == lifecycleOwner) {
                return true;
            }
            return false;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean e() {
            return this.f6707j.getLifecycle().b().a(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Lifecycle.State b8 = this.f6707j.getLifecycle().b();
            if (b8 == Lifecycle.State.DESTROYED) {
                LiveData.this.n(this.f6709f);
                return;
            }
            Lifecycle.State state = null;
            while (state != b8) {
                b(e());
                state = b8;
                b8 = this.f6707j.getLifecycle().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class ObserverWrapper {

        /* renamed from: f  reason: collision with root package name */
        final Observer<? super T> f6709f;

        /* renamed from: g  reason: collision with root package name */
        boolean f6710g;

        /* renamed from: h  reason: collision with root package name */
        int f6711h = -1;

        ObserverWrapper(Observer<? super T> observer) {
            this.f6709f = observer;
        }

        void b(boolean z7) {
            int i8;
            if (z7 == this.f6710g) {
                return;
            }
            this.f6710g = z7;
            LiveData liveData = LiveData.this;
            if (z7) {
                i8 = 1;
            } else {
                i8 = -1;
            }
            liveData.c(i8);
            if (this.f6710g) {
                LiveData.this.e(this);
            }
        }

        void c() {
        }

        boolean d(LifecycleOwner lifecycleOwner) {
            return false;
        }

        abstract boolean e();
    }

    public LiveData(T t7) {
        this.f6695f = new Object();
        this.f6696g = new SafeIterableMap<>();
        this.f6697h = 0;
        this.f6700k = f6694p;
        this.f6704o = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                synchronized (LiveData.this.f6695f) {
                    obj = LiveData.this.f6700k;
                    LiveData.this.f6700k = LiveData.f6694p;
                }
                LiveData.this.o(obj);
            }
        };
        this.f6699j = t7;
        this.f6701l = 0;
    }

    static void b(String str) {
        if (ArchTaskExecutor.e().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(LiveData<T>.ObserverWrapper observerWrapper) {
        if (!observerWrapper.f6710g) {
            return;
        }
        if (!observerWrapper.e()) {
            observerWrapper.b(false);
            return;
        }
        int i8 = observerWrapper.f6711h;
        int i9 = this.f6701l;
        if (i8 >= i9) {
            return;
        }
        observerWrapper.f6711h = i9;
        observerWrapper.f6709f.onChanged((Object) this.f6699j);
    }

    void c(int i8) {
        boolean z7;
        boolean z8;
        int i9 = this.f6697h;
        this.f6697h = i8 + i9;
        if (this.f6698i) {
            return;
        }
        this.f6698i = true;
        while (true) {
            try {
                int i10 = this.f6697h;
                if (i9 != i10) {
                    if (i9 == 0 && i10 > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (i9 > 0 && i10 == 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z7) {
                        k();
                    } else if (z8) {
                        l();
                    }
                    i9 = i10;
                } else {
                    return;
                }
            } finally {
                this.f6698i = false;
            }
        }
    }

    void e(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.f6702m) {
            this.f6703n = true;
            return;
        }
        this.f6702m = true;
        do {
            this.f6703n = false;
            if (observerWrapper != null) {
                d(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper>.IteratorWithAdditions f8 = this.f6696g.f();
                while (f8.hasNext()) {
                    d((ObserverWrapper) f8.next().getValue());
                    if (this.f6703n) {
                        break;
                    }
                }
            }
        } while (this.f6703n);
        this.f6702m = false;
    }

    public T f() {
        T t7 = (T) this.f6699j;
        if (t7 != f6694p) {
            return t7;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f6701l;
    }

    public boolean h() {
        if (this.f6697h > 0) {
            return true;
        }
        return false;
    }

    public void i(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        b("observe");
        if (lifecycleOwner.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        LiveData<T>.ObserverWrapper k8 = this.f6696g.k(observer, lifecycleBoundObserver);
        if (k8 != null && !k8.d(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (k8 != null) {
            return;
        }
        lifecycleOwner.getLifecycle().a(lifecycleBoundObserver);
    }

    public void j(@NonNull Observer<? super T> observer) {
        b("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper k8 = this.f6696g.k(observer, alwaysActiveObserver);
        if (!(k8 instanceof LifecycleBoundObserver)) {
            if (k8 != null) {
                return;
            }
            alwaysActiveObserver.b(true);
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    protected void k() {
    }

    protected void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(T t7) {
        boolean z7;
        synchronized (this.f6695f) {
            if (this.f6700k == f6694p) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f6700k = t7;
        }
        if (!z7) {
            return;
        }
        ArchTaskExecutor.e().c(this.f6704o);
    }

    public void n(@NonNull Observer<? super T> observer) {
        b("removeObserver");
        LiveData<T>.ObserverWrapper m8 = this.f6696g.m(observer);
        if (m8 == null) {
            return;
        }
        m8.c();
        m8.b(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(T t7) {
        b("setValue");
        this.f6701l++;
        this.f6699j = t7;
        e(null);
    }

    public LiveData() {
        this.f6695f = new Object();
        this.f6696g = new SafeIterableMap<>();
        this.f6697h = 0;
        Object obj = f6694p;
        this.f6700k = obj;
        this.f6704o = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f6695f) {
                    obj2 = LiveData.this.f6700k;
                    LiveData.this.f6700k = LiveData.f6694p;
                }
                LiveData.this.o(obj2);
            }
        };
        this.f6699j = obj;
        this.f6701l = -1;
    }
}
