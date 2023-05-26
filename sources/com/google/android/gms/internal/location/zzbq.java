package com.google.android.gms.internal.location;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public final class zzbq<E> extends zzbo<E> {
    private final zzbs<E> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(zzbs<E> zzbsVar, int i8) {
        super(zzbsVar.size(), i8);
        this.zza = zzbsVar;
    }

    @Override // com.google.android.gms.internal.location.zzbo
    protected final E zza(int i8) {
        return this.zza.get(i8);
    }
}
