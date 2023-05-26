package ee.mtakso.driver.uikit.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlideImageDelegate.kt */
/* loaded from: classes5.dex */
public final class GlideImageDelegate implements ImageDelegate {

    /* compiled from: GlideImageDelegate.kt */
    /* loaded from: classes5.dex */
    private static final class GlideTarget<V extends View> extends CustomViewTarget<V, Drawable> {

        /* renamed from: l  reason: collision with root package name */
        private final ImageCallback<V> f36072l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GlideTarget(V view, ImageCallback<V> imageCallback) {
            super(view);
            Intrinsics.f(view, "view");
            Intrinsics.f(imageCallback, "imageCallback");
            this.f36072l = imageCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bumptech.glide.request.target.Target
        public void i(Drawable drawable) {
            T view = this.f10728g;
            Intrinsics.e(view, "view");
            this.f36072l.b(view, drawable, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void m(Drawable drawable) {
            T view = this.f10728g;
            Intrinsics.e(view, "view");
            this.f36072l.d(view, drawable);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void n(Drawable drawable) {
            super.n(drawable);
            T view = this.f10728g;
            Intrinsics.e(view, "view");
            this.f36072l.c(view, drawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: p */
        public void e(Drawable resource, Transition<? super Drawable> transition) {
            Intrinsics.f(resource, "resource");
            T view = this.f10728g;
            Intrinsics.e(view, "view");
            this.f36072l.a(view, resource);
        }
    }

    private final <T> RequestBuilder<T> d(RequestBuilder<T> requestBuilder, ImageRequest imageRequest) {
        if (imageRequest.b() != null) {
            RequestBuilder Z = requestBuilder.Z(imageRequest.b().d(), imageRequest.b().c());
            Intrinsics.e(Z, "glideBuilder.override(re…, request.newSize.height)");
            Cloneable c8 = Z.c();
            Intrinsics.e(c8, "glideBuilder.centerInside()");
            requestBuilder = (RequestBuilder) c8;
        }
        if (imageRequest.c() != null) {
            Cloneable b02 = requestBuilder.b0(imageRequest.c());
            Intrinsics.e(b02, "glideBuilder.placeholder(request.placeholder)");
            requestBuilder = (RequestBuilder) b02;
        }
        if (imageRequest.a() != null) {
            Cloneable k8 = requestBuilder.k(imageRequest.a());
            Intrinsics.e(k8, "glideBuilder.error(request.error)");
            requestBuilder = (RequestBuilder) k8;
        }
        Cloneable c9 = requestBuilder.c();
        Intrinsics.e(c9, "glideBuilder.centerInside()");
        return (RequestBuilder) c9;
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageDelegate
    public <V extends View> void a(ImageRequest request, V view, ImageCallback<V> imageCallback) {
        Intrinsics.f(request, "request");
        Intrinsics.f(view, "view");
        Intrinsics.f(imageCallback, "imageCallback");
        RequestBuilder<Drawable> s7 = Glide.u(view).s(request.d());
        Intrinsics.e(s7, "with(view).load(request.url)");
        d(s7, request).y0(new GlideTarget(view, imageCallback));
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageDelegate
    public void b(ImageRequest request, ImageView imageView) {
        Intrinsics.f(request, "request");
        Intrinsics.f(imageView, "imageView");
        RequestBuilder<Drawable> s7 = Glide.u(imageView).s(request.d());
        Intrinsics.e(s7, "with(imageView).load(request.url)");
        d(s7, request).B0(imageView);
    }

    @Override // ee.mtakso.driver.uikit.utils.image.ImageDelegate
    public Bitmap c(ImageRequest request, Context context) {
        Intrinsics.f(request, "request");
        Intrinsics.f(context, "context");
        RequestBuilder<Bitmap> G0 = Glide.t(context).h().G0(request.d());
        Intrinsics.e(G0, "with(context).asBitmap().load(request.url)");
        FutureTarget L0 = d(G0, request).L0();
        Intrinsics.e(L0, "setUpGlideRequest(Glide.…t.url), request).submit()");
        try {
            R r7 = L0.get();
            Intrinsics.e(r7, "{\n            target.get()\n        }");
            return (Bitmap) r7;
        } finally {
            Glide.t(context).n(L0);
        }
    }
}
