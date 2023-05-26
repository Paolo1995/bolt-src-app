package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzin;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public abstract class zzim<MessageType extends zzin<MessageType, BuilderType>, BuilderType extends zzim<MessageType, BuilderType>> implements zzlk {
    @Override // com.google.android.gms.internal.measurement.zzlk
    public final /* synthetic */ zzlk zzaA(byte[] bArr, zzjq zzjqVar) throws zzko {
        return zzax(bArr, 0, bArr.length, zzjqVar);
    }

    @Override // 
    /* renamed from: zzau */
    public abstract zzim clone();

    protected abstract zzim zzav(zzin zzinVar);

    public zzim zzaw(byte[] bArr, int i8, int i9) throws zzko {
        throw null;
    }

    public zzim zzax(byte[] bArr, int i8, int i9, zzjq zzjqVar) throws zzko {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final /* bridge */ /* synthetic */ zzlk zzay(zzll zzllVar) {
        if (zzbO().getClass().isInstance(zzllVar)) {
            return zzav((zzin) zzllVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final /* synthetic */ zzlk zzaz(byte[] bArr) throws zzko {
        return zzaw(bArr, 0, bArr.length);
    }
}
