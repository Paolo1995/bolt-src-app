package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public interface TileProvider {
    @NonNull
    public static final Tile NO_TILE = new Tile(-1, -1, null);

    Tile getTile(int i8, int i9, int i10);
}
