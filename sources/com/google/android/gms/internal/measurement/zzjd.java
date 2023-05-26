package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzjd implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzjd zzb = new zzja(zzkm.zzd);
    private static final zzjc zzd;
    private int zzc = 0;

    static {
        int i8 = zzip.zza;
        zzd = new zzjc(null);
        zza = new zziv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) < 0) {
            if (i8 >= 0) {
                if (i9 < i8) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i8 + ", " + i9);
                }
                throw new IndexOutOfBoundsException("End index: " + i9 + " >= " + i10);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i8 + " < 0");
        }
        return i11;
    }

    public static zzjd zzl(byte[] bArr, int i8, int i9) {
        zzj(i8, i8 + i9, bArr.length);
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        return new zzja(bArr2);
    }

    public static zzjd zzm(String str) {
        return new zzja(str.getBytes(zzkm.zzb));
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
    public final /* synthetic */ Iterator iterator() {
        return new zziu(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            concat = zzml.zza(this);
        } else {
            concat = zzml.zza(zzf(0, 47)).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i8);

    public abstract int zzd();

    protected abstract int zze(int i8, int i9, int i10);

    public abstract zzjd zzf(int i8, int i9);

    protected abstract String zzg(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzh(zzit zzitVar) throws IOException;

    public abstract boolean zzi();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzk() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzg(charset);
    }
}
