package eu.bolt.verification.sdk.internal;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.sdk.internal.tj;
import j$.util.Spliterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class gk implements uj {

    /* renamed from: j  reason: collision with root package name */
    public static final a f43147j = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final uj f43148f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f43149g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends DesignImageView> f43150h;

    /* renamed from: i  reason: collision with root package name */
    private final Set<tj> f43151i;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements v9 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ tj f43153b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f43154c;

        b(tj tjVar, String str) {
            this.f43153b = tjVar;
            this.f43154c = str;
        }

        @Override // eu.bolt.verification.sdk.internal.v9
        public void a(Throwable error) {
            Intrinsics.f(error, "error");
            gk.this.e(this.f43153b, new jh("Drawable", this.f43154c, error));
        }

        @Override // eu.bolt.verification.sdk.internal.v9
        public void b(Drawable image) {
            Intrinsics.f(image, "image");
            gk.this.c(this.f43153b);
        }
    }

    public gk(uj listener) {
        List<? extends DesignImageView> k8;
        Intrinsics.f(listener, "listener");
        this.f43148f = listener;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f43150h = k8;
        this.f43151i = new LinkedHashSet();
    }

    private final void h(DesignImageView designImageView) {
        u9.c(designImageView);
        designImageView.clearAnimation();
        designImageView.setImageDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DesignImageView view, gk this$0, tj asset, Throwable it) {
        Intrinsics.f(view, "$view");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(asset, "$asset");
        String animationUrl = view.getAnimationUrl();
        if (animationUrl == null) {
            t3.f(new IllegalStateException("Wrong asset type, expected lottie"), null, null, 6, null);
            return;
        }
        Intrinsics.e(it, "it");
        this$0.e(asset, new jh("Lottie", animationUrl, it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(gk this$0, tj asset, LottieComposition lottieComposition) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(asset, "$asset");
        this$0.c(asset);
    }

    private final void n(tj tjVar, DesignImageView designImageView) {
        String b8 = tjVar.b();
        if (b8 == null) {
            return;
        }
        u9.d(designImageView, b8, (r24 & 2) != 0 ? null : null, (r24 & 4) != 0 ? null : null, (r24 & 8) != 0 ? null : null, (r24 & 16) != 0 ? null : null, (r24 & 32) != 0 ? null : null, (r24 & 64) != 0 ? null : null, (r24 & 128) != 0 ? null : null, (r24 & Spliterator.NONNULL) != 0 ? null : null, (r24 & 512) == 0 ? new b(tjVar, b8) : null, (r24 & Spliterator.IMMUTABLE) != 0 ? false : false, (r24 & 2048) != 0);
    }

    private final void p(final tj tjVar, final DesignImageView designImageView) {
        String b8 = tjVar.b();
        if (b8 == null) {
            return;
        }
        designImageView.y();
        designImageView.j(new LottieOnCompositionLoadedListener() { // from class: eu.bolt.verification.sdk.internal.rs
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void a(LottieComposition lottieComposition) {
                gk.j(gk.this, tjVar, lottieComposition);
            }
        });
        designImageView.setFailureListener(new LottieListener() { // from class: eu.bolt.verification.sdk.internal.ss
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                gk.i(DesignImageView.this, this, tjVar, (Throwable) obj);
            }
        });
        designImageView.setAnimationFromUrl(b8);
    }

    @Override // eu.bolt.verification.sdk.internal.uj
    public void c(tj tjVar) {
        this.f43151i.remove(tjVar);
        if (this.f43151i.isEmpty()) {
            if (this.f43149g) {
                for (DesignImageView designImageView : this.f43150h) {
                    designImageView.x();
                }
            }
            this.f43148f.c(tjVar);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.uj
    public void d(tj tjVar) {
        if (this.f43151i.isEmpty()) {
            this.f43148f.d(tjVar);
        }
        this.f43151i.add(tjVar);
    }

    @Override // eu.bolt.verification.sdk.internal.uj
    public void e(tj tjVar, jh exception) {
        Intrinsics.f(exception, "exception");
        this.f43151i.remove(tjVar);
        this.f43148f.e(tjVar, exception);
    }

    public void k(tj tjVar, DesignImageView view) {
        Unit unit;
        Intrinsics.f(view, "view");
        h(view);
        d(tjVar);
        if (tjVar != null) {
            if (tjVar instanceof tj.a) {
                n(tjVar, view);
            } else if (tjVar instanceof tj.b) {
                p(tjVar, view);
            }
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            c(tjVar);
        }
    }

    public void l(List<? extends DesignImageView> views) {
        Intrinsics.f(views, "views");
        this.f43150h = views;
    }

    public void m() {
        this.f43151i.clear();
        for (DesignImageView designImageView : this.f43150h) {
            h(designImageView);
        }
    }

    public void o() {
        for (DesignImageView designImageView : this.f43150h) {
            designImageView.l();
        }
    }

    public void q() {
        this.f43149g = false;
        for (DesignImageView designImageView : this.f43150h) {
            designImageView.w();
        }
    }

    public void r() {
        this.f43149g = true;
        for (DesignImageView designImageView : this.f43150h) {
            if (designImageView.getProgress() > 0.0f) {
                designImageView.z();
            } else {
                designImageView.x();
            }
        }
    }
}
