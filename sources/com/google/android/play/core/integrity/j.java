package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ab;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.z;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private final j f14585a = this;

    /* renamed from: b  reason: collision with root package name */
    private final ac f14586b;

    /* renamed from: c  reason: collision with root package name */
    private final ac f14587c;

    /* renamed from: d  reason: collision with root package name */
    private final ac f14588d;

    /* renamed from: e  reason: collision with root package name */
    private final ac f14589e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(Context context, i iVar) {
        p pVar;
        aa b8 = ab.b(context);
        this.f14586b = b8;
        pVar = o.f14595a;
        ac b9 = z.b(pVar);
        this.f14587c = b9;
        ac b10 = z.b(new v(b8, b9));
        this.f14588d = b10;
        this.f14589e = z.b(new n(b10));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f14589e.a();
    }
}
