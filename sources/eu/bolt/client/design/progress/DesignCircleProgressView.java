package eu.bolt.client.design.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.m4;
import eu.bolt.verification.sdk.internal.t1;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class DesignCircleProgressView extends ProgressBar {

    /* renamed from: f  reason: collision with root package name */
    private b f40149f;

    /* renamed from: g  reason: collision with root package name */
    private final t1 f40150g;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {
        a() {
            super(1);
        }

        public final void b(TypedArray ta) {
            Intrinsics.f(ta, "ta");
            int integer = ta.getInteger(R$styleable.B0, DesignCircleProgressView.this.f40149f.ordinal());
            DesignCircleProgressView.this.f40149f = b.values()[integer];
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        BIG(48.0f),
        MEDIUM(32.0f),
        MEDIUM_SMALL(28.0f),
        SMALL(24.0f),
        SMALLEST(16.0f);
        

        /* renamed from: f  reason: collision with root package name */
        private final float f40158f;

        b(float f8) {
            this.f40158f = f8;
        }

        public final float c() {
            return this.f40158f;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignCircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignCircleProgressView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f40149f = b.BIG;
        t1 b8 = m4.b(m4.f44152a, context, 0, 2, null);
        this.f40150g = b8;
        setIndeterminate(true);
        setIndeterminateDrawable(b8);
        int[] DesignCircleProgressView = R$styleable.A0;
        Intrinsics.e(DesignCircleProgressView, "DesignCircleProgressView");
        uq.x(this, attributeSet, DesignCircleProgressView, new a());
    }

    public /* synthetic */ DesignCircleProgressView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i8, int i9) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = f2.a(context, this.f40149f.c());
        setMeasuredDimension(a8, a8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f40150g.h(Math.min(i8, i9) * 0.166f);
    }

    public final void setProgressDrawableColorInt(int i8) {
        this.f40150g.g(i8);
    }

    public final void setProgressDrawableColorRes(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setProgressDrawableColorInt(f2.b(context, i8));
    }

    public final void setSize(b size) {
        Intrinsics.f(size, "size");
        if (this.f40149f != size) {
            this.f40149f = size;
            requestLayout();
        }
    }
}
