package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public final class zzlz extends zzmj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlz(int i8) {
        super(i8, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final void zza() {
        if (!zzj()) {
            for (int i8 = 0; i8 < zzb(); i8++) {
                Map.Entry zzg = zzg(i8);
                if (((zzju) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzju) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
