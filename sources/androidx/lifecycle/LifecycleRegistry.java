package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: b  reason: collision with root package name */
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> f6680b;

    /* renamed from: c  reason: collision with root package name */
    private Lifecycle.State f6681c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<LifecycleOwner> f6682d;

    /* renamed from: e  reason: collision with root package name */
    private int f6683e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6684f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6685g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Lifecycle.State> f6686h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f6687i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ObserverWithState {

        /* renamed from: a  reason: collision with root package name */
        Lifecycle.State f6688a;

        /* renamed from: b  reason: collision with root package name */
        LifecycleEventObserver f6689b;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.f6689b = Lifecycling.f(lifecycleObserver);
            this.f6688a = state;
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State c8 = event.c();
            this.f6688a = LifecycleRegistry.k(this.f6688a, c8);
            this.f6689b.onStateChanged(lifecycleOwner, event);
            this.f6688a = c8;
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }

    private void d(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.f6680b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f6685g) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
            ObserverWithState value = next.getValue();
            while (value.f6688a.compareTo(this.f6681c) > 0 && !this.f6685g && this.f6680b.contains(next.getKey())) {
                Lifecycle.Event a8 = Lifecycle.Event.a(value.f6688a);
                if (a8 != null) {
                    n(a8.c());
                    value.a(lifecycleOwner, a8);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + value.f6688a);
                }
            }
        }
    }

    private Lifecycle.State e(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state;
        ArrayList<Lifecycle.State> arrayList;
        Map.Entry<LifecycleObserver, ObserverWithState> n8 = this.f6680b.n(lifecycleObserver);
        Lifecycle.State state2 = null;
        if (n8 != null) {
            state = n8.getValue().f6688a;
        } else {
            state = null;
        }
        if (!this.f6686h.isEmpty()) {
            state2 = this.f6686h.get(arrayList.size() - 1);
        }
        return k(k(this.f6681c, state), state2);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (this.f6687i && !ArchTaskExecutor.e().b()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void g(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions f8 = this.f6680b.f();
        while (f8.hasNext() && !this.f6685g) {
            Map.Entry next = f8.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.f6688a.compareTo(this.f6681c) < 0 && !this.f6685g && this.f6680b.contains((LifecycleObserver) next.getKey())) {
                n(observerWithState.f6688a);
                Lifecycle.Event e8 = Lifecycle.Event.e(observerWithState.f6688a);
                if (e8 != null) {
                    observerWithState.a(lifecycleOwner, e8);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.f6688a);
                }
            }
        }
    }

    private boolean i() {
        if (this.f6680b.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.f6680b.b().getValue().f6688a;
        Lifecycle.State state2 = this.f6680b.g().getValue().f6688a;
        if (state == state2 && this.f6681c == state2) {
            return true;
        }
        return false;
    }

    static Lifecycle.State k(@NonNull Lifecycle.State state, Lifecycle.State state2) {
        if (state2 != null && state2.compareTo(state) < 0) {
            return state2;
        }
        return state;
    }

    private void l(Lifecycle.State state) {
        Lifecycle.State state2 = this.f6681c;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f6681c);
        }
        this.f6681c = state;
        if (!this.f6684f && this.f6683e == 0) {
            this.f6684f = true;
            p();
            this.f6684f = false;
            if (this.f6681c == Lifecycle.State.DESTROYED) {
                this.f6680b = new FastSafeIterableMap<>();
                return;
            }
            return;
        }
        this.f6685g = true;
    }

    private void m() {
        ArrayList<Lifecycle.State> arrayList = this.f6686h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(Lifecycle.State state) {
        this.f6686h.add(state);
    }

    private void p() {
        LifecycleOwner lifecycleOwner = this.f6682d.get();
        if (lifecycleOwner != null) {
            while (!i()) {
                this.f6685g = false;
                if (this.f6681c.compareTo(this.f6680b.b().getValue().f6688a) < 0) {
                    d(lifecycleOwner);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> g8 = this.f6680b.g();
                if (!this.f6685g && g8 != null && this.f6681c.compareTo(g8.getValue().f6688a) > 0) {
                    g(lifecycleOwner);
                }
            }
            this.f6685g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        boolean z7;
        f("addObserver");
        Lifecycle.State state = this.f6681c;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (this.f6680b.k(lifecycleObserver, observerWithState) != null || (lifecycleOwner = this.f6682d.get()) == null) {
            return;
        }
        if (this.f6683e == 0 && !this.f6684f) {
            z7 = false;
        } else {
            z7 = true;
        }
        Lifecycle.State e8 = e(lifecycleObserver);
        this.f6683e++;
        while (observerWithState.f6688a.compareTo(e8) < 0 && this.f6680b.contains(lifecycleObserver)) {
            n(observerWithState.f6688a);
            Lifecycle.Event e9 = Lifecycle.Event.e(observerWithState.f6688a);
            if (e9 != null) {
                observerWithState.a(lifecycleOwner, e9);
                m();
                e8 = e(lifecycleObserver);
            } else {
                throw new IllegalStateException("no event up from " + observerWithState.f6688a);
            }
        }
        if (!z7) {
            p();
        }
        this.f6683e--;
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State b() {
        return this.f6681c;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void c(@NonNull LifecycleObserver lifecycleObserver) {
        f("removeObserver");
        this.f6680b.m(lifecycleObserver);
    }

    public void h(@NonNull Lifecycle.Event event) {
        f("handleLifecycleEvent");
        l(event.c());
    }

    @Deprecated
    public void j(@NonNull Lifecycle.State state) {
        f("markState");
        o(state);
    }

    public void o(@NonNull Lifecycle.State state) {
        f("setCurrentState");
        l(state);
    }

    private LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner, boolean z7) {
        this.f6680b = new FastSafeIterableMap<>();
        this.f6683e = 0;
        this.f6684f = false;
        this.f6685g = false;
        this.f6686h = new ArrayList<>();
        this.f6682d = new WeakReference<>(lifecycleOwner);
        this.f6681c = Lifecycle.State.INITIALIZED;
        this.f6687i = z7;
    }
}
