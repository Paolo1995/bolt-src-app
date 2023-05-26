package com.google.android.gms.internal.location;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
abstract class zzbo<E> extends zzbv<E> {
    private final int zza;
    private int zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbo(int i8, int i9) {
        zzbm.zzb(i9, i8, "index");
        this.zza = i8;
        this.zzb = i9;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final E next() {
        if (hasNext()) {
            int i8 = this.zzb;
            this.zzb = i8 + 1;
            return zza(i8);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i8 = this.zzb - 1;
            this.zzb = i8;
            return zza(i8);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    protected abstract E zza(int i8);
}
