package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzaa  reason: invalid package */
/* loaded from: classes.dex */
final class zzaa extends zzi {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzab zzabVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapiphone.zzj
    public final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }
}
