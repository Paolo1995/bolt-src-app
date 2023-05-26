package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jakewharton.rxbinding3.view.RxView;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.sdk.internal.bn;
import eu.bolt.verification.sdk.internal.k7;
import eu.bolt.verification.sdk.internal.ll;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class cn implements bn {

    /* renamed from: a  reason: collision with root package name */
    private final jn f42525a;

    /* renamed from: b  reason: collision with root package name */
    private final z7 f42526b;

    /* renamed from: c  reason: collision with root package name */
    private final x9 f42527c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f42528d;

    /* renamed from: e  reason: collision with root package name */
    private int f42529e;

    /* renamed from: f  reason: collision with root package name */
    private final xd f42530f;

    /* renamed from: g  reason: collision with root package name */
    private final mf f42531g;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<Unit, bn.b.a> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f42532f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final bn.b.a invoke(Unit it) {
            Intrinsics.f(it, "it");
            return bn.b.a.f42376a;
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Unit, bn.b.c> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f42533f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final bn.b.c invoke(Unit it) {
            Intrinsics.f(it, "it");
            return bn.b.c.f42380a;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<Unit, bn.b.C0038b> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final bn.b.C0038b invoke(Unit it) {
            Intrinsics.f(it, "it");
            cn.this.a();
            int P = cn.this.P();
            int N = cn.this.N();
            Rect rect = cn.this.f42528d;
            cn cnVar = cn.this;
            rect.top += cnVar.f42529e;
            rect.bottom += cnVar.f42529e;
            Unit unit = Unit.f50853a;
            return new bn.b.C0038b(P, N, rect);
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function0<Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1 f42535f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ cn f42536g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Integer f42537h;

        /* loaded from: classes5.dex */
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f42538a;

            static {
                int[] iArr = new int[hh.values().length];
                try {
                    iArr[hh.RECTANGLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[hh.OVAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f42538a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l1 l1Var, cn cnVar, Integer num) {
            super(0);
            this.f42535f = l1Var;
            this.f42536g = cnVar;
            this.f42537h = num;
        }

        public final void b() {
            yd ydVar;
            int i8 = a.f42538a[this.f42535f.c().ordinal()];
            if (i8 == 1) {
                ydVar = this.f42536g.f42531g;
            } else if (i8 != 2) {
                return;
            } else {
                ydVar = this.f42536g.f42530f;
            }
            this.f42536g.F(ydVar.b(this.f42535f.b(), this.f42537h));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    @Inject
    public cn(jn view, z7 formToolbarHomeModeMapper, x9 imageUiMapper) {
        Intrinsics.f(view, "view");
        Intrinsics.f(formToolbarHomeModeMapper, "formToolbarHomeModeMapper");
        Intrinsics.f(imageUiMapper, "imageUiMapper");
        this.f42525a = view;
        this.f42526b = formToolbarHomeModeMapper;
        this.f42527c = imageUiMapper;
        this.f42528d = new Rect();
        Context context = view.getContext();
        Intrinsics.e(context, "view.context");
        this.f42530f = new xd(context, false, true, view);
        Context context2 = view.getContext();
        Intrinsics.e(context2, "view.context");
        this.f42531g = new mf(context2, false, true, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bn.b.a D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (bn.b.a) tmp0.invoke(obj);
    }

    private final Integer E(wl wlVar, l1 l1Var) {
        Integer num;
        Float a8 = l1Var.a();
        if (a8 != null) {
            num = Integer.valueOf(z1.a(uq.d(this.f42525a, wlVar.c()), a8.floatValue()));
            int intValue = num.intValue();
            this.f42525a.getBinding().f43861b.setBackgroundColor(intValue);
            this.f42525a.getBinding().f43869j.setBackgroundColor(intValue);
        } else {
            num = null;
        }
        this.f42525a.getBinding().f43869j.setTitleTextColor(uq.d(this.f42525a, wlVar.f()));
        this.f42525a.getBinding().f43869j.setHomeButtonTintColor(wlVar.b());
        this.f42525a.getBinding().f43865f.setTextColor(uq.d(this.f42525a, wlVar.f()));
        this.f42525a.getBinding().f43866g.setBackgroundResource(wlVar.d());
        this.f42525a.getBinding().f43868i.setBackgroundResource(wlVar.e());
        this.f42525a.getBinding().f43866g.setImageResource(wlVar.a());
        jn jnVar = this.f42525a;
        jnVar.setBackgroundColor(uq.d(jnVar, wlVar.c()));
        return num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(Rect rect) {
        this.f42528d = rect;
        DesignImageView designImageView = this.f42525a.getBinding().f43862c;
        Intrinsics.e(designImageView, "view.binding.cameraOverlayImageView");
        ViewGroup.MarginLayoutParams a02 = uq.a0(designImageView);
        if (a02 != null) {
            uq.E(a02, 0, rect.top, 0, 0, null, 29, null);
        }
        DesignImageView designImageView2 = this.f42525a.getBinding().f43862c;
        Intrinsics.e(designImageView2, "view.binding.cameraOverlayImageView");
        uq.R(designImageView2, rect.right - rect.left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bn.b.c I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (bn.b.c) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final bn.b.C0038b J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (bn.b.C0038b) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int N() {
        return this.f42525a.getBinding().f43864e.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.f42525a.getBinding().f43864e.getWidth();
    }

    @Override // eu.bolt.verification.sdk.internal.kf
    public void a() {
        FrameLayout frameLayout = this.f42525a.getBinding().f43867h;
        Intrinsics.e(frameLayout, "view.binding.progressContainer");
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = this.f42525a.getBinding().f43861b;
        Intrinsics.e(frameLayout2, "view.binding.bottomPanel");
        uq.G(frameLayout2, false);
    }

    @Override // eu.bolt.verification.sdk.internal.kf
    public void b() {
        FrameLayout frameLayout = this.f42525a.getBinding().f43867h;
        Intrinsics.e(frameLayout, "view.binding.progressContainer");
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = this.f42525a.getBinding().f43861b;
        Intrinsics.e(frameLayout2, "view.binding.bottomPanel");
        uq.G(frameLayout2, true);
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void c(String str) {
        if (str != null) {
            DesignTextView designTextView = this.f42525a.getBinding().f43865f;
            Intrinsics.e(designTextView, "view.binding.description");
            il.d(designTextView, new ll.b(str));
        }
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void f(boolean z7) {
        this.f42525a.getBinding().f43866g.setImageResource(z7 ? R$drawable.ic_flash : R$drawable.ic_flash_off);
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Observable<bn.b> h() {
        List n8;
        Observable<Unit> a02 = this.f42525a.getBinding().f43869j.a0();
        final a aVar = a.f42532f;
        ImageButton imageButton = this.f42525a.getBinding().f43866g;
        Intrinsics.e(imageButton, "view.binding.flashlight");
        Observable<Unit> a8 = RxView.a(imageButton);
        final b bVar = b.f42533f;
        View view = this.f42525a.getBinding().f43868i;
        Intrinsics.e(view, "view.binding.takePicture");
        Observable<Unit> a9 = RxView.a(view);
        final c cVar = new c();
        n8 = CollectionsKt__CollectionsKt.n(a02.map(new Function() { // from class: eu.bolt.verification.sdk.internal.rr
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                bn.b.a D;
                D = cn.D(Function1.this, obj);
                return D;
            }
        }), a8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.sr
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                bn.b.c I;
                I = cn.I(Function1.this, obj);
                return I;
            }
        }), a9.map(new Function() { // from class: eu.bolt.verification.sdk.internal.tr
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                bn.b.C0038b J;
                J = cn.J(Function1.this, obj);
                return J;
            }
        }));
        Observable<bn.b> merge = Observable.merge(n8);
        Intrinsics.e(merge, "override fun observeUiEv…        )\n        )\n    }");
        return merge;
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void i(String str) {
        this.f42525a.getBinding().f43869j.setTitle(str);
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void j(p9 p9Var) {
        DesignImageView designImageView = this.f42525a.getBinding().f43862c;
        Intrinsics.e(designImageView, "view.binding.cameraOverlayImageView");
        DesignImageView.K(designImageView, this.f42527c.j(p9Var), false, null, 6, null);
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void l(l1 overlay, wl theme) {
        Intrinsics.f(overlay, "overlay");
        Intrinsics.f(theme, "theme");
        uq.m(this.f42525a, new d(overlay, this, E(theme, overlay)));
    }

    @Override // eu.bolt.android.rib.BaseViewRibPresenter
    public Flow<bn.b> p() {
        return bn.a.a(this);
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void t(k7.a backNavigation) {
        Intrinsics.f(backNavigation, "backNavigation");
        this.f42525a.getBinding().f43869j.setHomeButtonIcon(this.f42526b.a(backNavigation));
    }

    @Override // eu.bolt.verification.sdk.internal.bn
    public void x(ff previewConfig) {
        Intrinsics.f(previewConfig, "previewConfig");
        ViewGroup.LayoutParams layoutParams = this.f42525a.getBinding().f43864e.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = previewConfig.c();
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = previewConfig.a();
        this.f42525a.getBinding().f43864e.setLayoutParams(layoutParams2);
        this.f42529e = previewConfig.b();
    }
}
