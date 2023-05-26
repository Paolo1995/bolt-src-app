package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzjz implements zzlj {
    private static final zzjz zza = new zzjz();

    private zzjz() {
    }

    public static zzjz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzli zzb(Class cls) {
        if (zzke.class.isAssignableFrom(cls)) {
            try {
                return (zzli) zzke.zzbz(cls.asSubclass(zzke.class)).zzl(3, null, null);
            } catch (Exception e8) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e8);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzc(Class cls) {
        return zzke.class.isAssignableFrom(cls);
    }
}
