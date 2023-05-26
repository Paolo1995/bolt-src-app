package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import eu.bolt.verification.R$color;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final n0 f44232a = new n0();

    private n0() {
    }

    public static final Drawable a(Context context, float f8, float f9, int i8) {
        Intrinsics.f(context, "context");
        float i9 = f2.i(context, f8);
        float i10 = f2.i(context, f9);
        MaterialShapeDrawable m8 = MaterialShapeDrawable.m(context, i9);
        Intrinsics.e(m8, "createWithElevationOverlay(context, elevationPx)");
        m8.R(context);
        m8.setShapeAppearanceModel(m8.F().v().A(i10).E(i10).w(0.0f).s(0.0f).m());
        m8.setTint(i8);
        if (!(f8 == 0.0f)) {
            m8.j0(2);
        }
        m8.f0(Paint.Style.FILL);
        return m8;
    }

    public static /* synthetic */ Drawable b(Context context, float f8, float f9, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            f8 = 12.0f;
        }
        if ((i9 & 4) != 0) {
            f9 = 16.0f;
        }
        if ((i9 & 8) != 0) {
            i8 = f2.b(context, R$color.F);
        }
        return a(context, f8, f9, i8);
    }
}
