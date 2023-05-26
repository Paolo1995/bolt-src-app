package eu.bolt.android.rib;

import eu.bolt.android.rib.lifecycle.ActivityCallbackEvent;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import io.reactivex.Observable;

/* compiled from: RxActivityEvents.kt */
/* loaded from: classes5.dex */
public interface RxActivityEvents {
    Observable<ActivityLifecycleEvent> A();

    Observable<ActivityLifecycleEvent> C();

    Observable<ActivityLifecycleEvent> f();

    Observable<ActivityLifecycleEvent> k();

    Observable<ActivityLifecycleEvent> o();

    Observable<ActivityCallbackEvent> t();
}
