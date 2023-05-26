package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public abstract class zzeb implements Iterable<Byte>, Serializable {
    private static final Comparator<zzeb> zza;
    public static final zzeb zzb = new zzdz(zzev.zzc);
    private static final zzea zzd;
    private int zzc = 0;

    static {
        int i8 = zzdo.zza;
        zzd = new zzea(null);
        zza = new zzdu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) < 0) {
            if (i8 >= 0) {
                if (i9 < i8) {
                    StringBuilder sb = new StringBuilder(66);
                    sb.append("Beginning index larger than ending index: ");
                    sb.append(i8);
                    sb.append(", ");
                    sb.append(i9);
                    throw new IndexOutOfBoundsException(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("End index: ");
                sb2.append(i9);
                sb2.append(" >= ");
                sb2.append(i10);
                throw new IndexOutOfBoundsException(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder(32);
            sb3.append("Beginning index: ");
            sb3.append(i8);
            sb3.append(" < 0");
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        return i11;
    }

    public static zzeb zzk(byte[] bArr, int i8, int i9) {
        zzi(i8, i8 + i9, bArr.length);
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        return new zzdz(bArr2);
    }

    public static zzeb zzl(String str) {
        return new zzdz(str.getBytes(zzev.zza));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i8 = this.zzc;
        if (i8 == 0) {
            int zzd2 = zzd();
            i8 = zze(zzd2, 0, zzd2);
            if (i8 == 0) {
                i8 = 1;
            }
            this.zzc = i8;
        }
        return i8;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return new zzds(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            concat = zzgn.zza(this);
        } else {
            concat = String.valueOf(zzgn.zza(zzf(0, 47))).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i8);

    public abstract int zzd();

    protected abstract int zze(int i8, int i9, int i10);

    public abstract zzeb zzf(int i8, int i9);

    protected abstract String zzg(Charset charset);

    public abstract boolean zzh();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzj() {
        return this.zzc;
    }

    public final String zzm(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzg(charset);
    }
}
