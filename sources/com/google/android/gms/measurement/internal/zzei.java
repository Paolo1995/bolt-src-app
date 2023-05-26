package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzei extends com.google.android.gms.internal.measurement.zzbm implements zzek {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzei(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final String zzd(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        Parcel zzb = zzb(11, zza);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final List zze(zzq zzqVar, boolean z7) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, z7);
        Parcel zzb = zzb(7, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzli.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final List zzf(String str, String str2, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        Parcel zzb = zzb(16, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final List zzg(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(17, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final List zzh(String str, String str2, boolean z7, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, z7);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        Parcel zzb = zzb(14, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzli.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final List zzi(String str, String str2, String str3, boolean z7) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        com.google.android.gms.internal.measurement.zzbo.zzd(zza, z7);
        Parcel zzb = zzb(15, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzli.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzj(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzk(zzaw zzawVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzawVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzl(zzaw zzawVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzm(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzn(zzac zzacVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzacVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzo(zzac zzacVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzp(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzq(long j8, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j8);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzr(Bundle bundle, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, bundle);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzs(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final void zzt(zzli zzliVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzliVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzek
    public final byte[] zzu(zzaw zzawVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzawVar);
        zza.writeString(str);
        Parcel zzb = zzb(9, zza);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }
}
