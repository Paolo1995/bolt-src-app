package eu.bolt.driver.core.ui.common.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: LiveEvent.kt */
/* loaded from: classes5.dex */
public final class LiveEvent<T> extends MediatorLiveData<T> {

    /* renamed from: r  reason: collision with root package name */
    private final HashSet<ObserverWrapper<? super T>> f41114r = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LiveEvent.kt */
    /* loaded from: classes5.dex */
    public static final class ObserverWrapper<T> implements Observer<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Observer<T> f41115a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f41116b;

        public ObserverWrapper(Observer<T> observer) {
            Intrinsics.f(observer, "observer");
            this.f41115a = observer;
        }

        public final Observer<T> a() {
            return this.f41115a;
        }

        public final void b() {
            this.f41116b = true;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(T t7) {
            if (this.f41116b) {
                this.f41116b = false;
                this.f41115a.onChanged(t7);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void i(LifecycleOwner owner, Observer<? super T> observer) {
        Intrinsics.f(owner, "owner");
        Intrinsics.f(observer, "observer");
        ObserverWrapper<? super T> observerWrapper = new ObserverWrapper<>(observer);
        this.f41114r.add(observerWrapper);
        super.i(owner, observerWrapper);
    }

    @Override // androidx.lifecycle.LiveData
    public void j(Observer<? super T> observer) {
        Intrinsics.f(observer, "observer");
        ObserverWrapper<? super T> observerWrapper = new ObserverWrapper<>(observer);
        this.f41114r.add(observerWrapper);
        super.j(observerWrapper);
    }

    @Override // androidx.lifecycle.LiveData
    public void n(Observer<? super T> observer) {
        Intrinsics.f(observer, "observer");
        if (TypeIntrinsics.a(this.f41114r).remove(observer)) {
            super.n(observer);
            return;
        }
        Iterator<ObserverWrapper<? super T>> it = this.f41114r.iterator();
        Intrinsics.e(it, "observers.iterator()");
        while (it.hasNext()) {
            ObserverWrapper<? super T> next = it.next();
            Intrinsics.e(next, "iterator.next()");
            ObserverWrapper<? super T> observerWrapper = next;
            if (Intrinsics.a(observerWrapper.a(), observer)) {
                it.remove();
                super.n(observerWrapper);
                return;
            }
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void o(T t7) {
        Iterator<T> it = this.f41114r.iterator();
        while (it.hasNext()) {
            ((ObserverWrapper) it.next()).b();
        }
        super.o(t7);
    }
}
