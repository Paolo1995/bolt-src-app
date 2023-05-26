package ee.mtakso.driver.uikit.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import eu.bolt.kalev.Kalev;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageManager.kt */
/* loaded from: classes5.dex */
public final class ImageManager {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f36075b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static ImageLibrary f36076c = ImageLibrary.GLIDE;

    /* renamed from: a  reason: collision with root package name */
    private final ImageDelegate f36077a;

    /* compiled from: ImageManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* compiled from: ImageManager.kt */
        /* loaded from: classes5.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f36078a;

            static {
                int[] iArr = new int[ImageLibrary.values().length];
                try {
                    iArr[ImageLibrary.GLIDE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f36078a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ImageManager b(Companion companion, ImageLibrary imageLibrary, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                imageLibrary = companion.c();
            }
            return companion.a(imageLibrary);
        }

        public final ImageManager a(ImageLibrary imageLibrary) {
            Intrinsics.f(imageLibrary, "imageLibrary");
            Kalev.b("get imageLibrary: " + imageLibrary);
            if (WhenMappings.f36078a[imageLibrary.ordinal()] == 1) {
                return new ImageManager(new GlideImageDelegate());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final ImageLibrary c() {
            return ImageManager.f36076c;
        }
    }

    public ImageManager(ImageDelegate imageDelegate) {
        Intrinsics.f(imageDelegate, "imageDelegate");
        this.f36077a = imageDelegate;
    }

    public final <V extends View> void b(ImageRequest request, V view, ImageCallback<V> imageCallback) {
        Intrinsics.f(request, "request");
        Intrinsics.f(view, "view");
        Intrinsics.f(imageCallback, "imageCallback");
        this.f36077a.a(request, view, imageCallback);
    }

    public final void c(ImageRequest request, ImageView imageView) {
        Intrinsics.f(request, "request");
        Intrinsics.f(imageView, "imageView");
        this.f36077a.b(request, imageView);
    }

    public final Bitmap d(ImageRequest request, Context context) {
        Intrinsics.f(request, "request");
        Intrinsics.f(context, "context");
        return this.f36077a.c(request, context);
    }
}
