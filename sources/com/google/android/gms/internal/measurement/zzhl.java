package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzhl extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhl(zzhm zzhmVar, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z7) {
        zzia.zzd();
    }
}
