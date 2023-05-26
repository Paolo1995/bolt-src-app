package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$styleable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ij {

    /* renamed from: f  reason: collision with root package name */
    public static final b f43568f = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private int f43569a;

    /* renamed from: b  reason: collision with root package name */
    private int f43570b;

    /* renamed from: c  reason: collision with root package name */
    private int f43571c;

    /* renamed from: d  reason: collision with root package name */
    private int f43572d;

    /* renamed from: e  reason: collision with root package name */
    private float f43573e;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {
        a() {
            super(1);
        }

        public final void b(TypedArray styledAttrs) {
            Intrinsics.f(styledAttrs, "styledAttrs");
            ij.this.g(styledAttrs.getInt(R$styleable.M4, 1));
            ij ijVar = ij.this;
            ijVar.c(styledAttrs.getColor(R$styleable.I4, ijVar.a()));
            ij ijVar2 = ij.this;
            ijVar2.e(styledAttrs.getColor(R$styleable.K4, ijVar2.f()));
            ij ijVar3 = ij.this;
            ijVar3.i(styledAttrs.getDimensionPixelSize(R$styleable.L4, ijVar3.j()));
            ij ijVar4 = ij.this;
            ijVar4.b(styledAttrs.getDimension(R$styleable.J4, ijVar4.d()));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ij(Context context, AttributeSet attributeSet) {
        Intrinsics.f(context, "context");
        this.f43569a = 1;
        this.f43570b = f2.b(context, R$color.story_progress_view_background_default);
        this.f43571c = f2.b(context, R$color.story_progress_view_foreground_default);
        this.f43572d = f2.a(context, 2.0f);
        this.f43573e = f2.i(context, 6.0f);
        int[] StoryProgressView = R$styleable.H4;
        Intrinsics.e(StoryProgressView, "StoryProgressView");
        f2.e(context, attributeSet, StoryProgressView, new a());
    }

    public final int a() {
        return this.f43570b;
    }

    public final void b(float f8) {
        this.f43573e = f8;
    }

    public final void c(int i8) {
        this.f43570b = i8;
    }

    public final float d() {
        return this.f43573e;
    }

    public final void e(int i8) {
        this.f43571c = i8;
    }

    public final int f() {
        return this.f43571c;
    }

    public final void g(int i8) {
        this.f43569a = i8;
    }

    public final int h() {
        return this.f43569a;
    }

    public final void i(int i8) {
        this.f43572d = i8;
    }

    public final int j() {
        return this.f43572d;
    }
}
