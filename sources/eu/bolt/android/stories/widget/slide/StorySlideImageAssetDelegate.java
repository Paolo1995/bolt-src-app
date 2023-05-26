package eu.bolt.android.stories.widget.slide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import eu.bolt.android.stories.util.ContextExtKt;
import eu.bolt.android.stories.widget.slide.StorySlideAsset;
import eu.bolt.android.stories.widget.slide.StorySlideImageAssetDelegate;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideImageAssetDelegate.kt */
/* loaded from: classes5.dex */
public final class StorySlideImageAssetDelegate implements StorySlideAssetListener {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f37729k = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final StorySlideAssetListener f37730f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f37731g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends LottieAnimationView> f37732h;

    /* renamed from: i  reason: collision with root package name */
    private final Set<StorySlideAsset> f37733i;

    /* renamed from: j  reason: collision with root package name */
    private RequestManager f37734j;

    /* compiled from: StorySlideImageAssetDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StorySlideImageAssetDelegate(StorySlideAssetListener listener) {
        List<? extends LottieAnimationView> k8;
        Intrinsics.f(listener, "listener");
        this.f37730f = listener;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f37732h = k8;
        this.f37733i = new LinkedHashSet();
    }

    private final void g(LottieAnimationView lottieAnimationView) {
        RequestManager requestManager;
        Context context = lottieAnimationView.getContext();
        Intrinsics.e(context, "view.context");
        if (ContextExtKt.a(context) && (requestManager = this.f37734j) != null) {
            requestManager.m(lottieAnimationView);
        }
        lottieAnimationView.clearAnimation();
        lottieAnimationView.setImageDrawable(null);
    }

    private final void m(final StorySlideAsset storySlideAsset, LottieAnimationView lottieAnimationView) {
        RequestBuilder<Drawable> s7;
        RequestBuilder<Drawable> D0;
        final String b8 = storySlideAsset.b();
        if (b8 == null) {
            return;
        }
        Context context = lottieAnimationView.getContext();
        Intrinsics.e(context, "view.context");
        if (!ContextExtKt.a(context)) {
            return;
        }
        Kalev.d("Loading " + b8 + " " + lottieAnimationView);
        e(storySlideAsset);
        RequestManager t7 = Glide.t(lottieAnimationView.getContext());
        this.f37734j = t7;
        if (t7 != null && (s7 = t7.s(b8)) != null && (D0 = s7.D0(new RequestListener<Drawable>() { // from class: eu.bolt.android.stories.widget.slide.StorySlideImageAssetDelegate$showImageSlideAsset$1
            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a */
            public boolean j(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z7) {
                StorySlideImageAssetDelegate.this.c(storySlideAsset);
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean h(GlideException glideException, Object obj, Target<Drawable> target, boolean z7) {
                if (glideException != null) {
                    glideException.printStackTrace();
                }
                StorySlideImageAssetDelegate.this.a(storySlideAsset, new SlideAssetNotLoadedException("Drawable", b8, glideException));
                return false;
            }
        })) != null) {
            D0.B0(lottieAnimationView);
        }
    }

    private final void n(final StorySlideAsset storySlideAsset, LottieAnimationView lottieAnimationView) {
        final String b8 = storySlideAsset.b();
        if (b8 == null) {
            return;
        }
        lottieAnimationView.y();
        lottieAnimationView.j(new LottieOnCompositionLoadedListener() { // from class: j6.d
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void a(LottieComposition lottieComposition) {
                StorySlideImageAssetDelegate.o(StorySlideImageAssetDelegate.this, storySlideAsset, lottieComposition);
            }
        });
        lottieAnimationView.setFailureListener(new LottieListener() { // from class: j6.e
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                StorySlideImageAssetDelegate.p(b8, this, storySlideAsset, (Throwable) obj);
            }
        });
        lottieAnimationView.setAnimationFromUrl(b8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(StorySlideImageAssetDelegate this$0, StorySlideAsset asset, LottieComposition lottieComposition) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(asset, "$asset");
        this$0.c(asset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String lottieUrl, StorySlideImageAssetDelegate this$0, StorySlideAsset asset, Throwable th) {
        Intrinsics.f(lottieUrl, "$lottieUrl");
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(asset, "$asset");
        this$0.a(asset, new SlideAssetNotLoadedException("Lottie", lottieUrl, th));
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideAssetListener
    public void a(StorySlideAsset storySlideAsset, SlideAssetNotLoadedException exception) {
        Intrinsics.f(exception, "exception");
        this.f37733i.remove(storySlideAsset);
        this.f37730f.a(storySlideAsset, exception);
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideAssetListener
    public void c(StorySlideAsset storySlideAsset) {
        this.f37733i.remove(storySlideAsset);
        if (this.f37733i.isEmpty()) {
            if (this.f37731g) {
                for (LottieAnimationView lottieAnimationView : this.f37732h) {
                    lottieAnimationView.x();
                }
            }
            this.f37730f.c(storySlideAsset);
        }
    }

    @Override // eu.bolt.android.stories.widget.slide.StorySlideAssetListener
    public void e(StorySlideAsset storySlideAsset) {
        if (this.f37733i.isEmpty()) {
            this.f37730f.e(storySlideAsset);
        }
        this.f37733i.add(storySlideAsset);
    }

    public void f(StorySlideAsset storySlideAsset, LottieAnimationView view) {
        Unit unit;
        Intrinsics.f(view, "view");
        g(view);
        e(storySlideAsset);
        if (storySlideAsset != null) {
            if (storySlideAsset instanceof StorySlideAsset.Drawable) {
                m(storySlideAsset, view);
            } else if (storySlideAsset instanceof StorySlideAsset.Lottie) {
                n(storySlideAsset, view);
            }
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            c(storySlideAsset);
        }
    }

    public void h() {
        this.f37733i.clear();
        for (LottieAnimationView lottieAnimationView : this.f37732h) {
            g(lottieAnimationView);
        }
    }

    public void i() {
        for (LottieAnimationView lottieAnimationView : this.f37732h) {
            lottieAnimationView.l();
        }
    }

    public void j() {
        this.f37731g = false;
        for (LottieAnimationView lottieAnimationView : this.f37732h) {
            lottieAnimationView.w();
        }
    }

    public void k() {
        this.f37731g = true;
        for (LottieAnimationView lottieAnimationView : this.f37732h) {
            if (lottieAnimationView.getProgress() > 0.0f) {
                lottieAnimationView.z();
            } else {
                lottieAnimationView.x();
            }
        }
    }

    public void l(List<? extends LottieAnimationView> views) {
        Intrinsics.f(views, "views");
        this.f37732h = views;
    }
}
