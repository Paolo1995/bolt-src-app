package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzfh implements zzfo {
    private final zzfo[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfh(zzfo... zzfoVarArr) {
        this.zza = zzfoVarArr;
    }

    @Override // com.google.android.gms.internal.auth.zzfo
    public final zzfn zzb(Class<?> cls) {
        String str;
        zzfo[] zzfoVarArr = this.zza;
        for (int i8 = 0; i8 < 2; i8++) {
            zzfo zzfoVar = zzfoVarArr[i8];
            if (zzfoVar.zzc(cls)) {
                return zzfoVar.zzb(cls);
            }
        }
        String name = cls.getName();
        if (name.length() != 0) {
            str = "No factory is available for message type: ".concat(name);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }

    @Override // com.google.android.gms.internal.auth.zzfo
    public final boolean zzc(Class<?> cls) {
        zzfo[] zzfoVarArr = this.zza;
        for (int i8 = 0; i8 < 2; i8++) {
            if (zzfoVarArr[i8].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
