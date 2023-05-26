package com.jakewharton.rxrelay2;

import io.reactivex.Observer;

/* loaded from: classes3.dex */
final class SerializedRelay<T> extends Relay<T> {

    /* renamed from: f  reason: collision with root package name */
    private final Relay<T> f18959f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18960g;

    /* renamed from: h  reason: collision with root package name */
    private AppendOnlyLinkedArrayList<T> f18961h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SerializedRelay(Relay<T> relay) {
        this.f18959f = relay;
    }

    private void d() {
        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f18961h;
                if (appendOnlyLinkedArrayList == null) {
                    this.f18960g = false;
                    return;
                }
                this.f18961h = null;
            }
            appendOnlyLinkedArrayList.a(this.f18959f);
        }
    }

    @Override // com.jakewharton.rxrelay2.Relay, io.reactivex.functions.Consumer
    public void accept(T t7) {
        synchronized (this) {
            if (this.f18960g) {
                AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = this.f18961h;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f18961h = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.b(t7);
                return;
            }
            this.f18960g = true;
            this.f18959f.accept(t7);
            d();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.f18959f.subscribe(observer);
    }
}
