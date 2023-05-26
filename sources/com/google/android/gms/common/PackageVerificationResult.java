package com.google.android.gms.common;

import androidx.annotation.NonNull;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i8, boolean z7, @Nullable String str2, @Nullable Throwable th) {
        this.zza = str;
        this.zzb = z7;
        this.zzc = str2;
        this.zzd = th;
    }

    @NonNull
    public static PackageVerificationResult zza(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    @NonNull
    public static PackageVerificationResult zzd(@NonNull String str, int i8) {
        return new PackageVerificationResult(str, i8, true, null, null);
    }

    public final void zzb() {
        if (!this.zzb) {
            String concat = "PackageVerificationRslt: ".concat(String.valueOf(this.zzc));
            Throwable th = this.zzd;
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
