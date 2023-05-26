package eu.bolt.android.rib.worker.scope;

import eu.bolt.android.rib.worker.Worker;
import eu.bolt.android.rib.worker.WorkerGroup;
import eu.bolt.coroutines.base.BaseScopeKt;
import eu.bolt.coroutines.extensions.FlowExtensionsKt;
import eu.bolt.coroutines.extensions.ScopeExtKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* compiled from: BaseScopedWorkerGroup.kt */
/* loaded from: classes5.dex */
public abstract class BaseScopedWorkerGroup implements Worker {

    /* renamed from: a  reason: collision with root package name */
    private final WorkerGroup f37387a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineScope f37388b;

    /* renamed from: c  reason: collision with root package name */
    private final CompositeDisposable f37389c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f37390d;

    public BaseScopedWorkerGroup(WorkerGroup group) {
        Intrinsics.f(group, "group");
        this.f37387a = group;
        this.f37388b = BaseScopeKt.b("BaseScopedWorkerGroup.scope", null, null, null, Dispatchers.c().R0(), 14, null);
        this.f37389c = new CompositeDisposable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Disposable disposable) {
        Intrinsics.f(disposable, "<this>");
        this.f37389c.b(disposable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.f37390d) {
            for (Worker worker : this.f37387a.a()) {
                worker.onStop();
            }
            this.f37390d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> void c(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onNext) {
        Intrinsics.f(flow, "<this>");
        Intrinsics.f(onNext, "onNext");
        FlowExtensionsKt.f(flow, this.f37388b, onNext, null, null, null, false, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (!this.f37390d) {
            for (Worker worker : this.f37387a.a()) {
                worker.onStart();
            }
            this.f37390d = true;
        }
    }

    @Override // eu.bolt.android.rib.worker.Worker
    public void onStop() {
        ScopeExtKt.b(this.f37388b, null, 1, null);
        this.f37389c.d();
        b();
    }
}
