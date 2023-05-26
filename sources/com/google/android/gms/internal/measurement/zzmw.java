package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzmw {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmw(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j8);

    public abstract float zzb(Object obj, long j8);

    public abstract void zzc(Object obj, long j8, boolean z7);

    public abstract void zzd(Object obj, long j8, byte b8);

    public abstract void zze(Object obj, long j8, double d8);

    public abstract void zzf(Object obj, long j8, float f8);

    public abstract boolean zzg(Object obj, long j8);

    public final int zzh(Class cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzi(Class cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzj(Object obj, long j8) {
        return this.zza.getInt(obj, j8);
    }

    public final long zzk(Object obj, long j8) {
        return this.zza.getLong(obj, j8);
    }

    public final long zzl(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzm(Object obj, long j8) {
        return this.zza.getObject(obj, j8);
    }

    public final void zzn(Object obj, long j8, int i8) {
        this.zza.putInt(obj, j8, i8);
    }

    public final void zzo(Object obj, long j8, long j9) {
        this.zza.putLong(obj, j8, j9);
    }

    public final void zzp(Object obj, long j8, Object obj2) {
        this.zza.putObject(obj, j8, obj2);
    }
}
