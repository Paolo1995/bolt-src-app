package eu.bolt.client.extensions;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class LiveDataExtKt$waitForStartEvent$1 implements LifecycleObserver {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f40264f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function1<Object, Unit> f40265g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Object f40266h;

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        this.f40264f.getLifecycle().c(this);
        this.f40265g.invoke(this.f40266h);
    }
}
