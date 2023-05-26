package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzeo;
import com.google.android.gms.internal.auth.zzeq;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public abstract class zzeq<MessageType extends zzeq<MessageType, BuilderType>, BuilderType extends zzeo<MessageType, BuilderType>> extends zzdm<MessageType, BuilderType> {
    private static final Map<Object, zzeq<?, ?>> zzb = new ConcurrentHashMap();
    protected zzgq zzc = zzgq.zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzeq> T zza(Class<T> cls) {
        Map<Object, zzeq<?, ?>> map = zzb;
        zzeq<?, ?> zzeqVar = map.get(cls);
        if (zzeqVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzeqVar = map.get(cls);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException("Class initialization cannot fail.", e8);
            }
        }
        if (zzeqVar == null) {
            zzeqVar = (zzeq) ((zzeq) zzgz.zze(cls)).zzj(6, null, null);
            if (zzeqVar != null) {
                map.put(cls, zzeqVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzeqVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzeq<T, ?>> T zzb(T t7, byte[] bArr) throws zzew {
        Object obj;
        boolean z7 = false;
        T t8 = (T) zzc(t7, bArr, 0, bArr.length, zzeg.zza());
        if (t8 != null) {
            byte byteValue = ((Byte) t8.zzj(1, null, null)).byteValue();
            if (byteValue == 1) {
                z7 = true;
            } else if (byteValue != 0) {
                z7 = zzfy.zza().zzb(t8.getClass()).zzi(t8);
                if (true != z7) {
                    obj = null;
                } else {
                    obj = t8;
                }
                t8.zzj(2, obj, null);
            }
            if (!z7) {
                zzew zzewVar = new zzew(new zzgo(t8).getMessage());
                zzewVar.zze(t8);
                throw zzewVar;
            }
        }
        return t8;
    }

    static <T extends zzeq<T, ?>> T zzc(T t7, byte[] bArr, int i8, int i9, zzeg zzegVar) throws zzew {
        T t8 = (T) t7.zzj(4, null, null);
        try {
            zzgb zzb2 = zzfy.zza().zzb(t8.getClass());
            zzb2.zzg(t8, bArr, 0, i9, new zzdp(zzegVar));
            zzb2.zze(t8);
            if (t8.zza == 0) {
                return t8;
            }
            throw new RuntimeException();
        } catch (zzew e8) {
            e8.zze(t8);
            throw e8;
        } catch (IOException e9) {
            if (e9.getCause() instanceof zzew) {
                throw ((zzew) e9.getCause());
            }
            zzew zzewVar = new zzew(e9);
            zzewVar.zze(t8);
            throw zzewVar;
        } catch (IndexOutOfBoundsException unused) {
            zzew zzf = zzew.zzf();
            zzf.zze(t8);
            throw zzf;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzeu<E> zzd() {
        return zzfz.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzf(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e8);
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzg(zzfq zzfqVar, String str, Object[] objArr) {
        return new zzga(zzfqVar, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzeq> void zzi(Class<T> cls, T t7) {
        zzb.put(cls, t7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzfy.zza().zzb(getClass()).zzh(this, (zzeq) obj);
    }

    public final int hashCode() {
        int i8 = this.zza;
        if (i8 != 0) {
            return i8;
        }
        int zza = zzfy.zza().zzb(getClass()).zza(this);
        this.zza = zza;
        return zza;
    }

    public final String toString() {
        return zzfs.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.auth.zzfq
    public final /* bridge */ /* synthetic */ zzfp zze() {
        zzeo zzeoVar = (zzeo) zzj(5, null, null);
        zzeoVar.zze(this);
        return zzeoVar;
    }

    @Override // com.google.android.gms.internal.auth.zzfr
    public final /* bridge */ /* synthetic */ zzfq zzh() {
        return (zzeq) zzj(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzj(int i8, Object obj, Object obj2);
}
