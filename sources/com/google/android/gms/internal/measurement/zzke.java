package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzke<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmo zzc = zzmo.zzc();
    protected int zzd = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkj zzbA() {
        return zzkf.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkk zzbB() {
        return zzla.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkk zzbC(zzkk zzkkVar) {
        int i8;
        int size = zzkkVar.size();
        if (size == 0) {
            i8 = 10;
        } else {
            i8 = size + size;
        }
        return zzkkVar.zze(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkl zzbD() {
        return zzlu.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkl zzbE(zzkl zzklVar) {
        int i8;
        int size = zzklVar.size();
        if (size == 0) {
            i8 = 10;
        } else {
            i8 = size + size;
        }
        return zzklVar.zzd(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzbH(Method method, Object obj, Object... objArr) {
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
    public static Object zzbI(zzll zzllVar, String str, Object[] objArr) {
        return new zzlv(zzllVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzbJ(Class cls, zzke zzkeVar) {
        zza.put(cls, zzkeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzke zzbz(Class cls) {
        Map map = zza;
        zzke zzkeVar = (zzke) map.get(cls);
        if (zzkeVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkeVar = (zzke) map.get(cls);
            } catch (ClassNotFoundException e8) {
                throw new IllegalStateException("Class initialization cannot fail.", e8);
            }
        }
        if (zzkeVar == null) {
            zzkeVar = (zzke) ((zzke) zzmx.zze(cls)).zzl(6, null, null);
            if (zzkeVar != null) {
                map.put(cls, zzkeVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkeVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzlt.zza().zzb(getClass()).zzj(this, (zzke) obj);
    }

    public final int hashCode() {
        int i8 = this.zzb;
        if (i8 != 0) {
            return i8;
        }
        int zzb = zzlt.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzln.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final /* synthetic */ zzlk zzbF() {
        return (zzka) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final /* synthetic */ zzlk zzbG() {
        zzka zzkaVar = (zzka) zzl(5, null, null);
        zzkaVar.zzaC(this);
        return zzkaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void zzbK(zzjl zzjlVar) throws IOException {
        zzlt.zza().zzb(getClass()).zzi(this, zzjm.zza(zzjlVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzll zzbO() {
        return (zzke) zzl(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzin
    public final int zzbr() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzin
    public final void zzbu(int i8) {
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int zzbw() {
        int i8 = this.zzd;
        if (i8 == -1) {
            int zza2 = zzlt.zza().zzb(getClass()).zza(this);
            this.zzd = zza2;
            return zza2;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzka zzbx() {
        return (zzka) zzl(5, null, null);
    }

    public final zzka zzby() {
        zzka zzkaVar = (zzka) zzl(5, null, null);
        zzkaVar.zzaC(this);
        return zzkaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzl(int i8, Object obj, Object obj2);
}
