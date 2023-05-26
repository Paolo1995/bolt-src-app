package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
abstract class zzhb {
    abstract int zza(int i8, byte[] bArr, int i9, int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(byte[] bArr, int i8, int i9) {
        if (zza(0, bArr, i8, i9) != 0) {
            return false;
        }
        return true;
    }
}
