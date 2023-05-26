package io.ktor.util;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [To] */
/* compiled from: DelegatingMutableSet.kt */
/* loaded from: classes5.dex */
public final class DelegatingMutableSet$iterator$1<To> implements Iterator<To>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private final Iterator<From> f47041f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DelegatingMutableSet<From, To> f47042g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegatingMutableSet$iterator$1(DelegatingMutableSet<From, To> delegatingMutableSet) {
        Set set;
        this.f47042g = delegatingMutableSet;
        set = ((DelegatingMutableSet) delegatingMutableSet).f47037f;
        this.f47041f = set.iterator();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        return this.f47041f.hasNext();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public To next() {
        Function1 function1;
        function1 = ((DelegatingMutableSet) this.f47042g).f47038g;
        return (To) function1.invoke(this.f47041f.next());
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        this.f47041f.remove();
    }
}
