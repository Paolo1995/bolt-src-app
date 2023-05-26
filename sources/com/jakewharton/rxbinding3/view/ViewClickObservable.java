package com.jakewharton.rxbinding3.view;

import android.view.View;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewClickObservable.kt */
/* loaded from: classes3.dex */
public final class ViewClickObservable extends Observable<Unit> {

    /* renamed from: f  reason: collision with root package name */
    private final View f18933f;

    /* compiled from: ViewClickObservable.kt */
    /* loaded from: classes3.dex */
    private static final class Listener extends MainThreadDisposable implements View.OnClickListener {

        /* renamed from: g  reason: collision with root package name */
        private final View f18934g;

        /* renamed from: h  reason: collision with root package name */
        private final Observer<? super Unit> f18935h;

        public Listener(View view, Observer<? super Unit> observer) {
            Intrinsics.g(view, "view");
            Intrinsics.g(observer, "observer");
            this.f18934g = view;
            this.f18935h = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f18934g.setOnClickListener(null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v7) {
            Intrinsics.g(v7, "v");
            if (!isDisposed()) {
                this.f18935h.onNext(Unit.f50853a);
            }
        }
    }

    public ViewClickObservable(View view) {
        Intrinsics.g(view, "view");
        this.f18933f = view;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Unit> observer) {
        Intrinsics.g(observer, "observer");
        if (!Preconditions.a(observer)) {
            return;
        }
        Listener listener = new Listener(this.f18933f, observer);
        observer.onSubscribe(listener);
        this.f18933f.setOnClickListener(listener);
    }
}
