package io.reactivex.observables;

import io.reactivex.Observable;

/* loaded from: classes5.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {

    /* renamed from: f  reason: collision with root package name */
    final K f49822f;

    /* JADX INFO: Access modifiers changed from: protected */
    public GroupedObservable(K k8) {
        this.f49822f = k8;
    }
}
