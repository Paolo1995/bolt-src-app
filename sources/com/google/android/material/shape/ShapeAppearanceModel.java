package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class ShapeAppearanceModel {

    /* renamed from: m  reason: collision with root package name */
    public static final CornerSize f14027m = new RelativeCornerSize(0.5f);

    /* renamed from: a  reason: collision with root package name */
    CornerTreatment f14028a;

    /* renamed from: b  reason: collision with root package name */
    CornerTreatment f14029b;

    /* renamed from: c  reason: collision with root package name */
    CornerTreatment f14030c;

    /* renamed from: d  reason: collision with root package name */
    CornerTreatment f14031d;

    /* renamed from: e  reason: collision with root package name */
    CornerSize f14032e;

    /* renamed from: f  reason: collision with root package name */
    CornerSize f14033f;

    /* renamed from: g  reason: collision with root package name */
    CornerSize f14034g;

    /* renamed from: h  reason: collision with root package name */
    CornerSize f14035h;

    /* renamed from: i  reason: collision with root package name */
    EdgeTreatment f14036i;

    /* renamed from: j  reason: collision with root package name */
    EdgeTreatment f14037j;

    /* renamed from: k  reason: collision with root package name */
    EdgeTreatment f14038k;

    /* renamed from: l  reason: collision with root package name */
    EdgeTreatment f14039l;

    /* loaded from: classes.dex */
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize a(@NonNull CornerSize cornerSize);
    }

    @NonNull
    public static Builder a() {
        return new Builder();
    }

    @NonNull
    public static Builder b(Context context, int i8, int i9) {
        return c(context, i8, i9, 0);
    }

    @NonNull
    private static Builder c(Context context, int i8, int i9, int i10) {
        return d(context, i8, i9, new AbsoluteCornerSize(i10));
    }

    @NonNull
    private static Builder d(Context context, int i8, int i9, @NonNull CornerSize cornerSize) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i8);
        if (i9 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i9);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.P5);
        try {
            int i10 = obtainStyledAttributes.getInt(R$styleable.Q5, 0);
            int i11 = obtainStyledAttributes.getInt(R$styleable.T5, i10);
            int i12 = obtainStyledAttributes.getInt(R$styleable.U5, i10);
            int i13 = obtainStyledAttributes.getInt(R$styleable.S5, i10);
            int i14 = obtainStyledAttributes.getInt(R$styleable.R5, i10);
            CornerSize m8 = m(obtainStyledAttributes, R$styleable.V5, cornerSize);
            CornerSize m9 = m(obtainStyledAttributes, R$styleable.Y5, m8);
            CornerSize m10 = m(obtainStyledAttributes, R$styleable.Z5, m8);
            CornerSize m11 = m(obtainStyledAttributes, R$styleable.X5, m8);
            return new Builder().y(i11, m9).C(i12, m10).u(i13, m11).q(i14, m(obtainStyledAttributes, R$styleable.W5, m8));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static Builder e(@NonNull Context context, AttributeSet attributeSet, int i8, int i9) {
        return f(context, attributeSet, i8, i9, 0);
    }

    @NonNull
    public static Builder f(@NonNull Context context, AttributeSet attributeSet, int i8, int i9, int i10) {
        return g(context, attributeSet, i8, i9, new AbsoluteCornerSize(i10));
    }

    @NonNull
    public static Builder g(@NonNull Context context, AttributeSet attributeSet, int i8, int i9, @NonNull CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.U4, i8, i9);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.V4, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.W4, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cornerSize);
    }

    @NonNull
    private static CornerSize m(TypedArray typedArray, int i8, @NonNull CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i8);
        if (peekValue == null) {
            return cornerSize;
        }
        int i9 = peekValue.type;
        if (i9 == 5) {
            return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i9 == 6) {
            return new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f));
        }
        return cornerSize;
    }

    @NonNull
    public EdgeTreatment h() {
        return this.f14038k;
    }

    @NonNull
    public CornerTreatment i() {
        return this.f14031d;
    }

    @NonNull
    public CornerSize j() {
        return this.f14035h;
    }

    @NonNull
    public CornerTreatment k() {
        return this.f14030c;
    }

    @NonNull
    public CornerSize l() {
        return this.f14034g;
    }

    @NonNull
    public EdgeTreatment n() {
        return this.f14039l;
    }

    @NonNull
    public EdgeTreatment o() {
        return this.f14037j;
    }

    @NonNull
    public EdgeTreatment p() {
        return this.f14036i;
    }

    @NonNull
    public CornerTreatment q() {
        return this.f14028a;
    }

    @NonNull
    public CornerSize r() {
        return this.f14032e;
    }

    @NonNull
    public CornerTreatment s() {
        return this.f14029b;
    }

    @NonNull
    public CornerSize t() {
        return this.f14033f;
    }

    public boolean u(@NonNull RectF rectF) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (this.f14039l.getClass().equals(EdgeTreatment.class) && this.f14037j.getClass().equals(EdgeTreatment.class) && this.f14036i.getClass().equals(EdgeTreatment.class) && this.f14038k.getClass().equals(EdgeTreatment.class)) {
            z7 = true;
        } else {
            z7 = false;
        }
        float a8 = this.f14032e.a(rectF);
        if (this.f14033f.a(rectF) == a8 && this.f14035h.a(rectF) == a8 && this.f14034g.a(rectF) == a8) {
            z8 = true;
        } else {
            z8 = false;
        }
        if ((this.f14029b instanceof RoundedCornerTreatment) && (this.f14028a instanceof RoundedCornerTreatment) && (this.f14030c instanceof RoundedCornerTreatment) && (this.f14031d instanceof RoundedCornerTreatment)) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z7 && z8 && z9) {
            return true;
        }
        return false;
    }

    @NonNull
    public Builder v() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel w(float f8) {
        return v().o(f8).m();
    }

    @NonNull
    public ShapeAppearanceModel x(@NonNull CornerSize cornerSize) {
        return v().p(cornerSize).m();
    }

    @NonNull
    public ShapeAppearanceModel y(@NonNull CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return v().B(cornerSizeUnaryOperator.a(r())).F(cornerSizeUnaryOperator.a(t())).t(cornerSizeUnaryOperator.a(j())).x(cornerSizeUnaryOperator.a(l())).m();
    }

    private ShapeAppearanceModel(@NonNull Builder builder) {
        this.f14028a = builder.f14040a;
        this.f14029b = builder.f14041b;
        this.f14030c = builder.f14042c;
        this.f14031d = builder.f14043d;
        this.f14032e = builder.f14044e;
        this.f14033f = builder.f14045f;
        this.f14034g = builder.f14046g;
        this.f14035h = builder.f14047h;
        this.f14036i = builder.f14048i;
        this.f14037j = builder.f14049j;
        this.f14038k = builder.f14050k;
        this.f14039l = builder.f14051l;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private CornerTreatment f14040a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private CornerTreatment f14041b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private CornerTreatment f14042c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private CornerTreatment f14043d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private CornerSize f14044e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private CornerSize f14045f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private CornerSize f14046g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private CornerSize f14047h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        private EdgeTreatment f14048i;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        private EdgeTreatment f14049j;
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        private EdgeTreatment f14050k;
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        private EdgeTreatment f14051l;

        public Builder() {
            this.f14040a = MaterialShapeUtils.b();
            this.f14041b = MaterialShapeUtils.b();
            this.f14042c = MaterialShapeUtils.b();
            this.f14043d = MaterialShapeUtils.b();
            this.f14044e = new AbsoluteCornerSize(0.0f);
            this.f14045f = new AbsoluteCornerSize(0.0f);
            this.f14046g = new AbsoluteCornerSize(0.0f);
            this.f14047h = new AbsoluteCornerSize(0.0f);
            this.f14048i = MaterialShapeUtils.c();
            this.f14049j = MaterialShapeUtils.c();
            this.f14050k = MaterialShapeUtils.c();
            this.f14051l = MaterialShapeUtils.c();
        }

        private static float n(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).f14026a;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).f13978a;
            }
            return -1.0f;
        }

        @NonNull
        public Builder A(float f8) {
            this.f14044e = new AbsoluteCornerSize(f8);
            return this;
        }

        @NonNull
        public Builder B(@NonNull CornerSize cornerSize) {
            this.f14044e = cornerSize;
            return this;
        }

        @NonNull
        public Builder C(int i8, @NonNull CornerSize cornerSize) {
            return D(MaterialShapeUtils.a(i8)).F(cornerSize);
        }

        @NonNull
        public Builder D(@NonNull CornerTreatment cornerTreatment) {
            this.f14041b = cornerTreatment;
            float n8 = n(cornerTreatment);
            if (n8 != -1.0f) {
                E(n8);
            }
            return this;
        }

        @NonNull
        public Builder E(float f8) {
            this.f14045f = new AbsoluteCornerSize(f8);
            return this;
        }

        @NonNull
        public Builder F(@NonNull CornerSize cornerSize) {
            this.f14045f = cornerSize;
            return this;
        }

        @NonNull
        public ShapeAppearanceModel m() {
            return new ShapeAppearanceModel(this);
        }

        @NonNull
        public Builder o(float f8) {
            return A(f8).E(f8).w(f8).s(f8);
        }

        @NonNull
        public Builder p(@NonNull CornerSize cornerSize) {
            return B(cornerSize).F(cornerSize).x(cornerSize).t(cornerSize);
        }

        @NonNull
        public Builder q(int i8, @NonNull CornerSize cornerSize) {
            return r(MaterialShapeUtils.a(i8)).t(cornerSize);
        }

        @NonNull
        public Builder r(@NonNull CornerTreatment cornerTreatment) {
            this.f14043d = cornerTreatment;
            float n8 = n(cornerTreatment);
            if (n8 != -1.0f) {
                s(n8);
            }
            return this;
        }

        @NonNull
        public Builder s(float f8) {
            this.f14047h = new AbsoluteCornerSize(f8);
            return this;
        }

        @NonNull
        public Builder t(@NonNull CornerSize cornerSize) {
            this.f14047h = cornerSize;
            return this;
        }

        @NonNull
        public Builder u(int i8, @NonNull CornerSize cornerSize) {
            return v(MaterialShapeUtils.a(i8)).x(cornerSize);
        }

        @NonNull
        public Builder v(@NonNull CornerTreatment cornerTreatment) {
            this.f14042c = cornerTreatment;
            float n8 = n(cornerTreatment);
            if (n8 != -1.0f) {
                w(n8);
            }
            return this;
        }

        @NonNull
        public Builder w(float f8) {
            this.f14046g = new AbsoluteCornerSize(f8);
            return this;
        }

        @NonNull
        public Builder x(@NonNull CornerSize cornerSize) {
            this.f14046g = cornerSize;
            return this;
        }

        @NonNull
        public Builder y(int i8, @NonNull CornerSize cornerSize) {
            return z(MaterialShapeUtils.a(i8)).B(cornerSize);
        }

        @NonNull
        public Builder z(@NonNull CornerTreatment cornerTreatment) {
            this.f14040a = cornerTreatment;
            float n8 = n(cornerTreatment);
            if (n8 != -1.0f) {
                A(n8);
            }
            return this;
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            this.f14040a = MaterialShapeUtils.b();
            this.f14041b = MaterialShapeUtils.b();
            this.f14042c = MaterialShapeUtils.b();
            this.f14043d = MaterialShapeUtils.b();
            this.f14044e = new AbsoluteCornerSize(0.0f);
            this.f14045f = new AbsoluteCornerSize(0.0f);
            this.f14046g = new AbsoluteCornerSize(0.0f);
            this.f14047h = new AbsoluteCornerSize(0.0f);
            this.f14048i = MaterialShapeUtils.c();
            this.f14049j = MaterialShapeUtils.c();
            this.f14050k = MaterialShapeUtils.c();
            this.f14051l = MaterialShapeUtils.c();
            this.f14040a = shapeAppearanceModel.f14028a;
            this.f14041b = shapeAppearanceModel.f14029b;
            this.f14042c = shapeAppearanceModel.f14030c;
            this.f14043d = shapeAppearanceModel.f14031d;
            this.f14044e = shapeAppearanceModel.f14032e;
            this.f14045f = shapeAppearanceModel.f14033f;
            this.f14046g = shapeAppearanceModel.f14034g;
            this.f14047h = shapeAppearanceModel.f14035h;
            this.f14048i = shapeAppearanceModel.f14036i;
            this.f14049j = shapeAppearanceModel.f14037j;
            this.f14050k = shapeAppearanceModel.f14038k;
            this.f14051l = shapeAppearanceModel.f14039l;
        }
    }

    public ShapeAppearanceModel() {
        this.f14028a = MaterialShapeUtils.b();
        this.f14029b = MaterialShapeUtils.b();
        this.f14030c = MaterialShapeUtils.b();
        this.f14031d = MaterialShapeUtils.b();
        this.f14032e = new AbsoluteCornerSize(0.0f);
        this.f14033f = new AbsoluteCornerSize(0.0f);
        this.f14034g = new AbsoluteCornerSize(0.0f);
        this.f14035h = new AbsoluteCornerSize(0.0f);
        this.f14036i = MaterialShapeUtils.c();
        this.f14037j = MaterialShapeUtils.c();
        this.f14038k = MaterialShapeUtils.c();
        this.f14039l = MaterialShapeUtils.c();
    }
}
