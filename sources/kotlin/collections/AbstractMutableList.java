package kotlin.collections;

import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: AbstractMutableList.kt */
/* loaded from: classes5.dex */
public abstract class AbstractMutableList<E> extends java.util.AbstractList<E> implements KMutableList {
    public abstract int b();

    public abstract E d(int i8);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i8) {
        return d(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return b();
    }
}
