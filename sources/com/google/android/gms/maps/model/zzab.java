package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzal;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
final class zzab extends zzal {
    final /* synthetic */ TileProvider zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final Tile zzb(int i8, int i9, int i10) {
        return this.zza.getTile(i8, i9, i10);
    }
}
