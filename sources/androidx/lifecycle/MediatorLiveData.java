package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: q  reason: collision with root package name */
    private SafeIterableMap<LiveData<?>, Source<?>> f6713q = new SafeIterableMap<>();

    /* loaded from: classes.dex */
    private static class Source<V> implements Observer<V> {

        /* renamed from: a  reason: collision with root package name */
        final LiveData<V> f6714a;

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super V> f6715b;

        /* renamed from: c  reason: collision with root package name */
        int f6716c = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.f6714a = liveData;
            this.f6715b = observer;
        }

        void a() {
            this.f6714a.j(this);
        }

        void b() {
            this.f6714a.n(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V v7) {
            if (this.f6716c != this.f6714a.g()) {
                this.f6716c = this.f6714a.g();
                this.f6715b.onChanged(v7);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void k() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.f6713q.iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void l() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.f6713q.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    public <S> void p(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        if (liveData != null) {
            Source<?> source = new Source<>(liveData, observer);
            Source<?> k8 = this.f6713q.k(liveData, source);
            if (k8 != null && k8.f6715b != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            }
            if (k8 == null && h()) {
                source.a();
                return;
            }
            return;
        }
        throw new NullPointerException("source cannot be null");
    }

    public <S> void q(@NonNull LiveData<S> liveData) {
        Source<?> m8 = this.f6713q.m(liveData);
        if (m8 != null) {
            m8.b();
        }
    }
}
