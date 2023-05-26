package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzge extends zzgl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(int i8) {
        super(i8, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgl
    public final void zza() {
        if (!zzj()) {
            for (int i8 = 0; i8 < zzb(); i8++) {
                Map.Entry zzg = zzg(i8);
                if (((zzek) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzek) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
