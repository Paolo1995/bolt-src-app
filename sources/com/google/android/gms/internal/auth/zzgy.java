package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public abstract class zzgy {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgy(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j8);

    public abstract float zzb(Object obj, long j8);

    public abstract void zzc(Object obj, long j8, boolean z7);

    public abstract void zzd(Object obj, long j8, double d8);

    public abstract void zze(Object obj, long j8, float f8);

    public abstract boolean zzf(Object obj, long j8);

    public final int zzg(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzh(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzi(Object obj, long j8) {
        return this.zza.getInt(obj, j8);
    }

    public final long zzj(Object obj, long j8) {
        return this.zza.getLong(obj, j8);
    }

    public final long zzk(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzl(Object obj, long j8) {
        return this.zza.getObject(obj, j8);
    }

    public final void zzm(Object obj, long j8, int i8) {
        this.zza.putInt(obj, j8, i8);
    }

    public final void zzn(Object obj, long j8, long j9) {
        this.zza.putLong(obj, j8, j9);
    }

    public final void zzo(Object obj, long j8, Object obj2) {
        this.zza.putObject(obj, j8, obj2);
    }
}
