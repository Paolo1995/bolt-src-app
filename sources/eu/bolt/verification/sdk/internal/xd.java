package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class xd extends yd {

    /* renamed from: f  reason: collision with root package name */
    public static final a f45645f = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private final Context f45646c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f45647d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f45648e;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd(Context context, boolean z7, boolean z8, zd view) {
        super(view);
        Intrinsics.f(context, "context");
        Intrinsics.f(view, "view");
        this.f45646c = context;
        this.f45647d = z7;
        this.f45648e = z8;
    }

    @Override // eu.bolt.verification.sdk.internal.yd
    public Path a(RectF cutoffRect) {
        Intrinsics.f(cutoffRect, "cutoffRect");
        Path path = new Path();
        path.addOval(cutoffRect, Path.Direction.CW);
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
        float b8 = ghVar != null ? ghVar.b() / ghVar.a() : 0.75f;
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
        if (this.f45648e) {
            k1 k1Var = new k1(this.f45646c);
            k1Var.setBounds(rect);
            return k1Var;
        }
        return null;
    }

    public final float f() {
        return this.f45647d ? 0.5f : 0.4f;
    }
}
