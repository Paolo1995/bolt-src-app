package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.y;
import java.util.ArrayList;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class t {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.k f14605a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14606b;

    /* renamed from: c  reason: collision with root package name */
    final com.google.android.play.integrity.internal.v f14607c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Context context, com.google.android.play.integrity.internal.k kVar) {
        this.f14606b = context.getPackageName();
        this.f14605a = kVar;
        if (!y.a(context)) {
            kVar.b("Phonesky is not installed.", new Object[0]);
            this.f14607c = null;
            return;
        }
        this.f14607c = new com.google.android.play.integrity.internal.v(context, kVar, "IntegrityService", u.f14608a, q.f14596a, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Bundle a(t tVar, byte[] bArr, Long l8) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", tVar.f14606b);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 1);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l8 != null) {
            bundle.putLong("cloud.prj", l8.longValue());
        }
        ArrayList<com.google.android.play.integrity.internal.e> arrayList = new ArrayList();
        arrayList.add(com.google.android.play.integrity.internal.e.c(3, System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        for (com.google.android.play.integrity.internal.e eVar : arrayList) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", 3);
            bundle2.putLong("event_timestamp", eVar.b());
            arrayList2.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(arrayList2));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f14607c == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.c(), 10);
            Long b8 = integrityTokenRequest.b();
            this.f14605a.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f14607c.p(new r(this, taskCompletionSource, decode, b8, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e8) {
            return Tasks.forException(new IntegrityServiceException(-13, e8));
        }
    }
}
