package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class mf extends yd {

    /* renamed from: f  reason: collision with root package name */
    public static final a f44176f = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private final Context f44177c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f44178d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f44179e;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mf(Context context, boolean z7, boolean z8, zd view) {
        super(view);
        Intrinsics.f(context, "context");
        Intrinsics.f(view, "view");
        this.f44177c = context;
        this.f44178d = z7;
        this.f44179e = z8;
    }

    @Override // eu.bolt.verification.sdk.internal.yd
    public Path a(RectF cutoffRect) {
        Intrinsics.f(cutoffRect, "cutoffRect");
        Path path = new Path();
        float i8 = f2.i(this.f44177c, 12.0f);
        path.addRoundRect(cutoffRect, i8, i8, Path.Direction.CW);
        return path;
    }

    @Override // eu.bolt.verification.sdk.internal.yd
    public RectF c(int i8, int i9, gh ghVar) {
        int f8;
        int i10;
        float f9 = i8;
        float f10 = f9 * 0.5f;
        float f11 = i9;
        float f12 = 0.5f * f11;
        float b8 = ghVar != null ? ghVar.b() / ghVar.a() : 1.0f;
        if (f9 / f11 > b8) {
            i10 = (int) (f11 * f());
            f8 = (int) (i10 * b8);
        } else {
            f8 = (int) (f9 * f());
            i10 = (int) (f8 / b8);
        }
        float f13 = f8;
        float f14 = i10;
        return new RectF(f10 - f13, f12 - f14, f10 + f13, f12 + f14);
    }

    @Override // eu.bolt.verification.sdk.internal.yd
    public Drawable d(Rect rect) {
        Intrinsics.f(rect, "rect");
        if (this.f44179e) {
            m1 m1Var = new m1(this.f44177c);
            m1Var.setBounds(rect);
            return m1Var;
        }
        return null;
    }

    public final float f() {
        return this.f44178d ? 0.5f : 0.45f;
    }
}
