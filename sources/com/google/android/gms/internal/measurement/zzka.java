package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzke;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* loaded from: classes.dex */
public class zzka<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>> extends zzim<MessageType, BuilderType> {
    protected zzke zza;
    protected boolean zzb = false;
    private final zzke zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzka(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzke) messagetype.zzl(4, null, null);
    }

    private static final void zza(zzke zzkeVar, zzke zzkeVar2) {
        zzlt.zza().zzb(zzkeVar.getClass()).zzg(zzkeVar, zzkeVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    /* renamed from: zzaB */
    public final zzka zzau() {
        zzka zzkaVar = (zzka) this.zzc.zzl(5, null, null);
        zzkaVar.zzaC(zzaG());
        return zzkaVar;
    }

    public final zzka zzaC(zzke zzkeVar) {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        zza(this.zza, zzkeVar);
        return this;
    }

    public final zzka zzaD(byte[] bArr, int i8, int i9, zzjq zzjqVar) throws zzko {
        if (this.zzb) {
            zzaI();
            this.zzb = false;
        }
        try {
            zzlt.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i9, new zziq(zzjqVar));
            return this;
        } catch (zzko e8) {
            throw e8;
        } catch (IOException e9) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e9);
        } catch (IndexOutOfBoundsException unused) {
            throw zzko.zzf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r3 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final MessageType zzaE() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzke r0 = r5.zzaG()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L13
            goto L30
        L13:
            if (r3 == 0) goto L31
            com.google.android.gms.internal.measurement.zzlt r3 = com.google.android.gms.internal.measurement.zzlt.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.zzlw r3 = r3.zzb(r4)
            boolean r3 = r3.zzk(r0)
            if (r1 == r3) goto L29
            r1 = r2
            goto L2a
        L29:
            r1 = r0
        L2a:
            r4 = 2
            r0.zzl(r4, r1, r2)
            if (r3 == 0) goto L31
        L30:
            return r0
        L31:
            com.google.android.gms.internal.measurement.zzmm r1 = new com.google.android.gms.internal.measurement.zzmm
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zzaE():com.google.android.gms.internal.measurement.zzke");
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    /* renamed from: zzaF */
    public MessageType zzaG() {
        if (this.zzb) {
            return (MessageType) this.zza;
        }
        zzke zzkeVar = this.zza;
        zzlt.zza().zzb(zzkeVar.getClass()).zzf(zzkeVar);
        this.zzb = true;
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzaI() {
        zzke zzkeVar = (zzke) this.zza.zzl(4, null, null);
        zza(zzkeVar, this.zza);
        this.zza = zzkeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    protected final /* synthetic */ zzim zzav(zzin zzinVar) {
        zzaC((zzke) zzinVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    public final /* bridge */ /* synthetic */ zzim zzaw(byte[] bArr, int i8, int i9) throws zzko {
        zzaD(bArr, 0, i9, zzjq.zza());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzim
    public final /* bridge */ /* synthetic */ zzim zzax(byte[] bArr, int i8, int i9, zzjq zzjqVar) throws zzko {
        zzaD(bArr, 0, i9, zzjqVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzll zzbO() {
        return this.zzc;
    }
}
