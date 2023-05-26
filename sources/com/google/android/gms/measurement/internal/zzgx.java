package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public class zzgx implements zzgz {
    protected final zzge zzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgx(zzge zzgeVar) {
        Preconditions.checkNotNull(zzgeVar);
        this.zzs = zzgeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final Context zzau() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final Clock zzav() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final zzab zzaw() {
        throw null;
    }

    public void zzax() {
        this.zzs.zzaz().zzax();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final zzeu zzay() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final zzgb zzaz() {
        throw null;
    }

    public void zzg() {
        this.zzs.zzaz().zzg();
    }
}
