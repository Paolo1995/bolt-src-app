package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
final class zzlh {
    private static final zzlg zza;
    private static final zzlg zzb;

    static {
        zzlg zzlgVar;
        try {
            zzlgVar = (zzlg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlgVar = null;
        }
        zza = zzlgVar;
        zzb = new zzlg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlg zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlg zzb() {
        return zzb;
    }
}
