package eu.bolt.client.design.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import eu.bolt.verification.R$style;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.n4;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class DesignCollapsingToolbarView extends CollapsingToolbarLayout {
    private static final c M = new c(null);
    private final n4 L;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<String, Unit> {
        a() {
            super(1);
        }

        public final void b(String it) {
            Intrinsics.f(it, "it");
            DesignCollapsingToolbarView.this.setTitle(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            b(str);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Context f40239g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(1);
            this.f40239g = context;
        }

        public final void b(TypedArray it) {
            Intrinsics.f(it, "it");
            DesignCollapsingToolbarView.this.setExpandedTitleMarginStart(it.getDimensionPixelSize(R$styleable.G0, f2.a(this.f40239g, 24.0f)));
            DesignCollapsingToolbarView.this.setExpandedTitleMarginBottom(it.getDimensionPixelSize(R$styleable.F0, f2.a(this.f40239g, 15.0f)));
            DesignCollapsingToolbarView.this.L.f44290b.setMaxLines(it.getInteger(R$styleable.H0, 1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignCollapsingToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignCollapsingToolbarView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        n4 a8 = n4.a(LayoutInflater.from(context), this);
        Intrinsics.e(a8, "inflate(LayoutInflater.from(context), this)");
        this.L = a8;
        if (attributeSet != null) {
            uq.w(this, attributeSet, "title", new a());
        }
        setExpandedTitleTextAppearance(R$style.ToolbarExpandedText_Dark);
        setExpandedTitleTypeface(ResourcesCompat.h(context, u4.f45319u.c().c()));
        setCollapsedTitleTypeface(ResourcesCompat.h(context, u4.f45317s.c().c()));
        a8.f44290b.setTypeface(getExpandedTitleTypeface());
        int[] DesignCollapsingToolbarView = R$styleable.E0;
        Intrinsics.e(DesignCollapsingToolbarView, "DesignCollapsingToolbarView");
        uq.x(this, attributeSet, DesignCollapsingToolbarView, new b(context));
        ViewCompat.G0(this, null);
    }

    public /* synthetic */ DesignCollapsingToolbarView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void A() {
        this.L.f44290b.setText(getTitle());
    }

    public final DesignToolbarView getToolbar() {
        DesignToolbarView designToolbarView = this.L.f44291c;
        Intrinsics.e(designToolbarView, "binding.toolbar");
        return designToolbarView;
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        super.setBackgroundColor(i8);
        getToolbar().setBackgroundColor(i8);
    }

    public final void setBackgroundColorResource(int i8) {
        Context context = getContext();
        Intrinsics.e(context, "context");
        setBackgroundColor(f2.b(context, i8));
    }

    public final void setBackgroundHexColor(String hexColor) {
        Intrinsics.f(hexColor, "hexColor");
        setBackgroundColor(Color.parseColor(hexColor));
    }

    public final void setHomeButtonOnClickAction(Function0<Unit> function0) {
        this.L.f44291c.setHomeButtonOnClickAction(function0);
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        if (isAttachedToWindow()) {
            A();
        }
    }

    public final void setTitleTextColor(int i8) {
        setExpandedTitleColor(i8);
        setCollapsedTitleTextColor(i8);
    }

    public final Observable<Unit> z() {
        return this.L.f44291c.a0();
    }
}
