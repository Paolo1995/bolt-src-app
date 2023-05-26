package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzms extends AbstractList implements RandomAccess, zzkt {
    private final zzkt zza;

    public zzms(zzkt zzktVar) {
        this.zza = zzktVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i8) {
        return ((zzks) this.zza).get(i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzmr(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i8) {
        return new zzmq(this, i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final zzkt zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final Object zzf(int i8) {
        return this.zza.zzf(i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final void zzi(zzjd zzjdVar) {
        throw new UnsupportedOperationException();
    }
}
