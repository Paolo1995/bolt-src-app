package com.google.android.gms.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public final class zzj implements zzk<Boolean> {
    final /* synthetic */ String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(String str) {
        this.zza = str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.auth.zzl.zzd(java.lang.Object):java.lang.Object
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        */
    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ java.lang.Boolean zza(android.os.IBinder r7) throws android.os.RemoteException, java.io.IOException, com.google.android.gms.auth.GoogleAuthException {
        /*
            r6 = this;
            com.google.android.gms.internal.auth.zzf r7 = com.google.android.gms.internal.auth.zze.zzb(r7)
            java.lang.String r0 = r6.zza
            android.os.Bundle r7 = r7.zzg(r0)
            com.google.android.gms.auth.zzl.zzd(r7)
            java.lang.String r0 = "Error"
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "userRecoveryIntent"
            android.os.Parcelable r7 = r7.getParcelable(r1)
            android.content.Intent r7 = (android.content.Intent) r7
            com.google.android.gms.internal.auth.zzby r1 = com.google.android.gms.internal.auth.zzby.zza(r0)
            com.google.android.gms.internal.auth.zzby r2 = com.google.android.gms.internal.auth.zzby.SUCCESS
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L2a
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            return r7
        L2a:
            boolean r2 = com.google.android.gms.internal.auth.zzby.zzb(r1)
            if (r2 == 0) goto L60
            com.google.android.gms.common.logging.Logger r2 = com.google.android.gms.auth.zzl.zzc()
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r4 = r4 + 31
            r5.<init>(r4)
            java.lang.String r4 = "isUserRecoverableError status: "
            r5.append(r4)
            r5.append(r1)
            r1 = 0
            java.lang.String r4 = r5.toString()
            r3[r1] = r4
            java.lang.String r1 = "GoogleAuthUtil"
            r2.w(r1, r3)
            com.google.android.gms.auth.UserRecoverableAuthException r1 = new com.google.android.gms.auth.UserRecoverableAuthException
            r1.<init>(r0, r7)
            throw r1
        L60:
            com.google.android.gms.auth.GoogleAuthException r7 = new com.google.android.gms.auth.GoogleAuthException
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzj.zza(android.os.IBinder):java.lang.Object");
    }
}
