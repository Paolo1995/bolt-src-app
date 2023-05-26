package com.google.android.play.core.integrity;

import android.content.Context;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static j f14590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized j a(Context context) {
        j jVar;
        synchronized (l.class) {
            if (f14590a == null) {
                h hVar = new h(null);
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                hVar.a(context);
                f14590a = hVar.b();
            }
            jVar = f14590a;
        }
        return jVar;
    }
}
