package eu.bolt.android.engine.html.span.timer;

import android.os.Handler;
import android.os.Looper;
import eu.bolt.android.engine.html.util.UtilsExtenisonsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TickTimer.kt */
/* loaded from: classes5.dex */
public final class TickTimer {

    /* renamed from: a  reason: collision with root package name */
    public static final TickTimer f36898a = new TickTimer();

    /* renamed from: b  reason: collision with root package name */
    private static final Set<WeakReference<TickListener>> f36899b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private static final Handler f36900c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private static final TickTimer$callback$1 f36901d = new Runnable() { // from class: eu.bolt.android.engine.html.span.timer.TickTimer$callback$1
        @Override // java.lang.Runnable
        public void run() {
            Set<WeakReference> set;
            Set set2;
            Handler handler;
            long currentTimeMillis = System.currentTimeMillis();
            set = TickTimer.f36899b;
            ArrayList<TickListener> arrayList = new ArrayList();
            for (WeakReference weakReference : set) {
                TickListener tickListener = (TickListener) weakReference.get();
                if (tickListener != null) {
                    arrayList.add(tickListener);
                }
            }
            for (TickListener tickListener2 : arrayList) {
                tickListener2.a(currentTimeMillis);
            }
            TickTimer.f36898a.f(null);
            set2 = TickTimer.f36899b;
            if (!set2.isEmpty()) {
                handler = TickTimer.f36900c;
                handler.postDelayed(this, UtilsExtenisonsKt.b(System.currentTimeMillis()));
            }
        }
    };

    private TickTimer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(TickListener tickListener) {
        Iterator<WeakReference<TickListener>> it = f36899b.iterator();
        while (it.hasNext()) {
            if (Intrinsics.a(it.next().get(), tickListener)) {
                it.remove();
            }
        }
    }

    public final void d(TickListener listener) {
        Intrinsics.f(listener, "listener");
        UtilsExtenisonsKt.a();
        Set<WeakReference<TickListener>> set = f36899b;
        if (set.isEmpty()) {
            f36900c.postDelayed(f36901d, UtilsExtenisonsKt.b(System.currentTimeMillis()));
        }
        set.add(new WeakReference<>(listener));
    }

    public final void e(TickListener listener) {
        Intrinsics.f(listener, "listener");
        UtilsExtenisonsKt.a();
        f(listener);
        if (f36899b.isEmpty()) {
            f36900c.removeCallbacks(f36901d);
        }
    }
}
