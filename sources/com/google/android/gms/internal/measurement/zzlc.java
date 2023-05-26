package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzlc implements zzlj {
    private final zzlj[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlc(zzlj... zzljVarArr) {
        this.zza = zzljVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzli zzb(Class cls) {
        zzlj[] zzljVarArr = this.zza;
        for (int i8 = 0; i8 < 2; i8++) {
            zzlj zzljVar = zzljVarArr[i8];
            if (zzljVar.zzc(cls)) {
                return zzljVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzc(Class cls) {
        zzlj[] zzljVarArr = this.zza;
        for (int i8 = 0; i8 < 2; i8++) {
            if (zzljVarArr[i8].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
