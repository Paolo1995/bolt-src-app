package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import eu.bolt.verification.sdk.internal.aa;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r4 {
    public static final Drawable a(aa.e eVar, Context context) {
        Intrinsics.f(eVar, "<this>");
        Intrinsics.f(context, "context");
        Drawable o8 = f2.o(context, eVar.b());
        if (eVar.c() == null) {
            return o8;
        }
        Drawable mutate = o8.mutate();
        Intrinsics.e(mutate, "drawable.mutate()");
        return new wf(mutate, f2.a(context, eVar.c().b()), f2.a(context, eVar.c().a()));
    }
}
