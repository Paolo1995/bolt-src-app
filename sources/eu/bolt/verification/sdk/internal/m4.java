package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.Paint;
import eu.bolt.verification.R$color;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m4 {

    /* renamed from: a  reason: collision with root package name */
    public static final m4 f44152a = new m4();

    private m4() {
    }

    public static /* synthetic */ t1 b(m4 m4Var, Context context, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = f2.b(context, R$color.green_500);
        }
        return m4Var.a(context, i8);
    }

    public final t1 a(Context context, int i8) {
        Intrinsics.f(context, "context");
        t1 t1Var = new t1(context);
        t1Var.g(i8);
        t1Var.f(Paint.Cap.ROUND);
        return t1Var;
    }
}
