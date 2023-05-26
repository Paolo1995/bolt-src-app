package eu.bolt.client.design.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.material.appbar.MaterialToolbar;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import eu.bolt.coroutines.flows.PublishFlow;
import eu.bolt.verification.R$attr;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$string;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.a6;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.k5;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.vl;
import io.reactivex.Observable;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class DesignToolbarView extends MaterialToolbar {

    /* renamed from: o0  reason: collision with root package name */
    public static final b f40240o0 = new b(null);

    /* renamed from: j0  reason: collision with root package name */
    private final PublishFlow<Unit> f40241j0;

    /* renamed from: k0  reason: collision with root package name */
    private View.OnClickListener f40242k0;

    /* renamed from: l0  reason: collision with root package name */
    private Integer f40243l0;

    /* renamed from: m0  reason: collision with root package name */
    private final int f40244m0;

    /* renamed from: n0  reason: collision with root package name */
    private final k5 f40245n0;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f40246f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ DesignToolbarView f40247g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, DesignToolbarView designToolbarView) {
            super(1);
            this.f40246f = context;
            this.f40247g = designToolbarView;
        }

        public final void b(TypedArray it) {
            Unit unit;
            Intrinsics.f(it, "it");
            String a8 = vl.a(it, R$styleable.J2, this.f40246f);
            if (a8 != null) {
                this.f40247g.setTitle(a8);
            }
            this.f40247g.setTitleTextColor(it.getColor(R$styleable.K2, f2.b(this.f40246f, R$color.content_primary)));
            Drawable drawable = it.getDrawable(R$styleable.E2);
            if (drawable != null) {
                this.f40247g.setBackground(drawable);
                unit = Unit.f50853a;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.f40247g.setBackgroundColor(it.getColor(R$styleable.F2, f2.b(this.f40246f, R$color.content_primary_inv)));
            }
            this.f40247g.f40243l0 = Integer.valueOf(it.getColor(R$styleable.I2, f2.b(this.f40246f, R$color.icon_dark)));
            Drawable drawable2 = it.getDrawable(R$styleable.G2);
            if (drawable2 != null) {
                this.f40247g.setHomeButtonIcon(drawable2);
            }
            String a9 = vl.a(it, R$styleable.H2, this.f40246f);
            if (a9 != null) {
                this.f40247g.setNavigationContentDescription(a9);
            }
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

    /* loaded from: classes5.dex */
    public static abstract class c implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final int f40248f;

        /* renamed from: g  reason: collision with root package name */
        private final int f40249g;

        /* loaded from: classes5.dex */
        public static final class a extends c {

            /* renamed from: h  reason: collision with root package name */
            public static final a f40250h = new a();

            private a() {
                super(R$drawable.ic_arrow_left, R$string.cd_back, null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends c {

            /* renamed from: h  reason: collision with root package name */
            public static final b f40251h = new b();

            private b() {
                super(R$drawable.ic_cross, R$string.cd_close, null);
            }
        }

        /* renamed from: eu.bolt.client.design.toolbar.DesignToolbarView$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0026c extends c {

            /* renamed from: h  reason: collision with root package name */
            public static final C0026c f40252h = new C0026c();

            private C0026c() {
                super(-1, -1, null);
            }
        }

        private c(int i8, int i9) {
            this.f40248f = i8;
            this.f40249g = i9;
        }

        public /* synthetic */ c(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(i8, i9);
        }

        public final int a() {
            return this.f40249g;
        }

        public final int b() {
            return this.f40248f;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignToolbarView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Drawable drawable;
        Drawable mutate;
        Intrinsics.f(context, "context");
        this.f40241j0 = new PublishFlow<>();
        this.f40244m0 = getTitleMarginStart();
        k5 a8 = k5.a(LayoutInflater.from(context), this);
        Intrinsics.e(a8, "inflate(LayoutInflater.from(context), this)");
        this.f40245n0 = a8;
        int[] DesignToolbarView = R$styleable.D2;
        Intrinsics.e(DesignToolbarView, "DesignToolbarView");
        uq.x(this, attributeSet, DesignToolbarView, new a(context, this));
        if (getNavigationIcon() == null) {
            setHomeButtonIcon(c.a.f40250h);
        } else {
            Integer num = this.f40243l0;
            if (num != null) {
                int intValue = num.intValue();
                Drawable navigationIcon = getNavigationIcon();
                if (navigationIcon == null || (mutate = navigationIcon.mutate()) == null) {
                    drawable = null;
                } else {
                    Intrinsics.e(mutate, "mutate()");
                    drawable = a6.a(mutate, intValue);
                }
                setNavigationIcon(drawable);
            }
        }
        setNavigationOnClickListener(new View.OnClickListener() { // from class: u6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DesignToolbarView.c0(DesignToolbarView.this, view);
            }
        });
    }

    public /* synthetic */ DesignToolbarView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f41692f : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(DesignToolbarView this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f40241j0.f(Unit.f50853a);
        View.OnClickListener onClickListener = this$0.f40242k0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHomeButtonIcon(Drawable drawable) {
        Integer num = this.f40243l0;
        if (num != null) {
            int intValue = num.intValue();
            Drawable mutate = drawable.mutate();
            Intrinsics.e(mutate, "drawable.mutate()");
            Drawable a8 = a6.a(mutate, intValue);
            if (a8 != null) {
                drawable = a8;
            }
        }
        setNavigationIcon(drawable);
    }

    public final Observable<Unit> a0() {
        return RxConvertKt.e(this.f40241j0, null, 1, null);
    }

    public final k5 getBinding() {
        return this.f40245n0;
    }

    public final void setHomeButtonIcon(c viewMode) {
        Intrinsics.f(viewMode, "viewMode");
        if (viewMode instanceof c.C0026c) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            setTitleMarginStart(f2.a(context, 24.0f));
            setNavigationIcon((Drawable) null);
            return;
        }
        setTitleMarginStart(this.f40244m0);
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        setHomeButtonIcon(f2.o(context2, viewMode.b()));
        setNavigationContentDescription(viewMode.a());
    }

    public final void setHomeButtonOnClickAction(final Function0<Unit> function0) {
        this.f40242k0 = new View.OnClickListener() { // from class: u6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DesignToolbarView.e0(Function0.this, view);
            }
        };
    }

    public final void setHomeButtonOnClickListener(View.OnClickListener onClickListener) {
        this.f40242k0 = onClickListener;
    }

    public final void setHomeButtonTintColor(int i8) {
        Drawable mutate;
        int d8 = uq.d(this, i8);
        this.f40243l0 = Integer.valueOf(d8);
        if (getNavigationIcon() != null) {
            Drawable navigationIcon = getNavigationIcon();
            setNavigationIcon((navigationIcon == null || (mutate = navigationIcon.mutate()) == null) ? null : a6.a(mutate, d8));
        }
    }
}
