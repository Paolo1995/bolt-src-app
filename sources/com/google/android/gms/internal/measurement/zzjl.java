package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzjl extends zzit {
    private static final Logger zzb = Logger.getLogger(zzjl.class.getName());
    private static final boolean zzc = zzmx.zzx();
    zzjm zza;

    private zzjl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjl(zzjk zzjkVar) {
    }

    public static int zzA(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzB(long j8) {
        int i8;
        if (((-128) & j8) == 0) {
            return 1;
        }
        if (j8 < 0) {
            return 10;
        }
        if (((-34359738368L) & j8) != 0) {
            j8 >>>= 28;
            i8 = 6;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j8) != 0) {
            i8 += 2;
            j8 >>>= 14;
        }
        return (j8 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public static zzjl zzC(byte[] bArr) {
        return new zzji(bArr, 0, bArr.length);
    }

    public static int zzt(zzjd zzjdVar) {
        int zzd = zzjdVar.zzd();
        return zzA(zzd) + zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzu(int i8, zzll zzllVar, zzlw zzlwVar) {
        int zzA = zzA(i8 << 3);
        int i9 = zzA + zzA;
        zzin zzinVar = (zzin) zzllVar;
        int zzbr = zzinVar.zzbr();
        if (zzbr == -1) {
            zzbr = zzlwVar.zza(zzinVar);
            zzinVar.zzbu(zzbr);
        }
        return i9 + zzbr;
    }

    public static int zzv(int i8) {
        if (i8 >= 0) {
            return zzA(i8);
        }
        return 10;
    }

    public static int zzw(zzkr zzkrVar) {
        int zza = zzkrVar.zza();
        return zzA(zza) + zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(zzll zzllVar, zzlw zzlwVar) {
        zzin zzinVar = (zzin) zzllVar;
        int zzbr = zzinVar.zzbr();
        if (zzbr == -1) {
            zzbr = zzlwVar.zza(zzinVar);
            zzinVar.zzbu(zzbr);
        }
        return zzA(zzbr) + zzbr;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zznc.zzc(str);
        } catch (zznb unused) {
            length = str.getBytes(zzkm.zzb).length;
        }
        return zzA(length) + length;
    }

    public static int zzz(int i8) {
        return zzA(i8 << 3);
    }

    public final void zzD() {
        if (zza() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE(String str, zznb zznbVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zznbVar);
        byte[] bytes = str.getBytes(zzkm.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e8) {
            throw new zzjj(e8);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b8) throws IOException;

    public abstract void zzd(int i8, boolean z7) throws IOException;

    public abstract void zze(int i8, zzjd zzjdVar) throws IOException;

    public abstract void zzf(int i8, int i9) throws IOException;

    public abstract void zzg(int i8) throws IOException;

    public abstract void zzh(int i8, long j8) throws IOException;

    public abstract void zzi(long j8) throws IOException;

    public abstract void zzj(int i8, int i9) throws IOException;

    public abstract void zzk(int i8) throws IOException;

    public abstract void zzl(byte[] bArr, int i8, int i9) throws IOException;

    public abstract void zzm(int i8, String str) throws IOException;

    public abstract void zzo(int i8, int i9) throws IOException;

    public abstract void zzp(int i8, int i9) throws IOException;

    public abstract void zzq(int i8) throws IOException;

    public abstract void zzr(int i8, long j8) throws IOException;

    public abstract void zzs(long j8) throws IOException;
}
