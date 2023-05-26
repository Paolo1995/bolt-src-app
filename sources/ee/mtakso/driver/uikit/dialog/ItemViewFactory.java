package ee.mtakso.driver.uikit.dialog;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.uikit.R$id;
import ee.mtakso.driver.uikit.R$layout;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.html.HtmlImageGetter;
import ee.mtakso.driver.uikit.utils.html.HtmlUtilsKt;
import ee.mtakso.driver.uikit.utils.image.ImageCallback;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.RoundButtonStyle;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonSize;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemViewFactory.kt */
/* loaded from: classes5.dex */
public final class ItemViewFactory extends BaseItemViewFactory {

    /* renamed from: a */
    public static final ItemViewFactory f35921a = new ItemViewFactory();

    private ItemViewFactory() {
    }

    public static /* synthetic */ RoundButton d(ItemViewFactory itemViewFactory, ViewGroup viewGroup, CharSequence charSequence, Rect rect, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.c(viewGroup, charSequence, rect);
    }

    public static /* synthetic */ ImageView g(ItemViewFactory itemViewFactory, ViewGroup viewGroup, int i8, Rect rect, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.e(viewGroup, i8, rect);
    }

    public static /* synthetic */ TextView i(ItemViewFactory itemViewFactory, ViewGroup viewGroup, CharSequence charSequence, Rect rect, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.h(viewGroup, charSequence, rect);
    }

    public static /* synthetic */ RoundButton l(ItemViewFactory itemViewFactory, ViewGroup viewGroup, CharSequence charSequence, Rect rect, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.k(viewGroup, charSequence, rect);
    }

    public static /* synthetic */ RoundButton n(ItemViewFactory itemViewFactory, ViewGroup viewGroup, CharSequence charSequence, Rect rect, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.m(viewGroup, charSequence, rect);
    }

    public static /* synthetic */ TextView p(ItemViewFactory itemViewFactory, ViewGroup viewGroup, CharSequence charSequence, Rect rect, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.o(viewGroup, charSequence, rect);
    }

    public static /* synthetic */ RoundButton r(ItemViewFactory itemViewFactory, ViewGroup viewGroup, CharSequence charSequence, Rect rect, RoundButtonStyle roundButtonStyle, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            rect = null;
        }
        return itemViewFactory.q(viewGroup, charSequence, rect, roundButtonStyle);
    }

    public final RoundButton c(ViewGroup parent, CharSequence text, Rect rect) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        return UiKitRoundButtonFactory.f35926a.c(parent, text, rect, new RoundButtonStyle(UiKitRoundButtonType.f36161k, UiKitRoundButtonSize.f36155i));
    }

    public final ImageView e(ViewGroup parent, int i8, Rect rect) {
        Intrinsics.f(parent, "parent");
        ImageView imageView = (ImageView) BaseItemViewFactory.b(this, parent, R$layout.f35774q, rect, Dimens.c(72), Dimens.c(72), null, 16, null);
        imageView.setImageResource(i8);
        return imageView;
    }

    public final ImageView f(final ViewGroup parent, String uri, Rect rect, final boolean z7) {
        int c8;
        int c9;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(uri, "uri");
        FrameLayout frameLayout = (FrameLayout) BaseItemViewFactory.b(this, parent, R$layout.dialog_item_icon_with_progress_bar, rect, -1, -2, null, 16, null);
        final ImageView icon = (ImageView) frameLayout.findViewById(R$id.f35755f);
        final CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) frameLayout.findViewById(R$id.f35756g);
        if (z7) {
            c8 = -1;
        } else {
            c8 = Dimens.c(72);
        }
        if (z7) {
            c9 = -2;
        } else {
            c9 = Dimens.c(72);
        }
        icon.setLayoutParams(new FrameLayout.LayoutParams(c8, c9, 1));
        ImageManager b8 = ImageManager.Companion.b(ImageManager.f36075b, null, 1, null);
        ImageRequest imageRequest = new ImageRequest(uri, null, null, null, 14, null);
        Intrinsics.e(icon, "icon");
        b8.b(imageRequest, icon, new ImageCallback<ImageView>() { // from class: ee.mtakso.driver.uikit.dialog.ItemViewFactory$inflateIcon$1
            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: e */
            public void b(ImageView view, Drawable drawable, Exception exc) {
                Intrinsics.f(view, "view");
                CircularProgressIndicator loading = CircularProgressIndicator.this;
                Intrinsics.e(loading, "loading");
                ViewExtKt.d(loading, false, 0, 2, null);
                icon.setImageDrawable(null);
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: f */
            public void d(ImageView view, Drawable drawable) {
                Intrinsics.f(view, "view");
                CircularProgressIndicator loading = CircularProgressIndicator.this;
                Intrinsics.e(loading, "loading");
                ViewExtKt.d(loading, false, 0, 2, null);
                icon.setImageDrawable(null);
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: g */
            public void a(ImageView view, Drawable drawable) {
                Intrinsics.f(view, "view");
                Intrinsics.f(drawable, "drawable");
                CircularProgressIndicator loading = CircularProgressIndicator.this;
                Intrinsics.e(loading, "loading");
                boolean z8 = false;
                ViewExtKt.d(loading, false, 0, 2, null);
                ImageView imageView = icon;
                if (z7 && drawable.getIntrinsicWidth() > parent.getWidth()) {
                    z8 = true;
                }
                imageView.setAdjustViewBounds(z8);
                icon.setImageDrawable(drawable);
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: h */
            public void c(ImageView view, Drawable drawable) {
                Intrinsics.f(view, "view");
                CircularProgressIndicator.this.q();
            }
        });
        return icon;
    }

    public final TextView h(ViewGroup parent, CharSequence text, Rect rect) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        TextView textView = (TextView) BaseItemViewFactory.b(this, parent, R$layout.f35775s, rect, 0, 0, null, 28, null);
        textView.setText(text);
        return textView;
    }

    public final TextView j(ViewGroup parent, CharSequence text, Rect rect, Integer num) {
        Drawable drawable;
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        TextView textView = (TextView) BaseItemViewFactory.b(this, parent, R$layout.f35775s, rect, 0, 0, null, 28, null);
        if (num != null) {
            num.intValue();
            drawable = AppCompatResources.b(textView.getContext(), num.intValue());
        } else {
            drawable = null;
        }
        textView.setText(HtmlUtilsKt.a(text.toString(), new HtmlImageGetter(textView, text.toString(), drawable)));
        return textView;
    }

    public final RoundButton k(ViewGroup parent, CharSequence text, Rect rect) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        return q(parent, text, rect, new RoundButtonStyle(UiKitRoundButtonType.f36164n, UiKitRoundButtonSize.f36155i));
    }

    public final RoundButton m(ViewGroup parent, CharSequence text, Rect rect) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        return q(parent, text, rect, new RoundButtonStyle(UiKitRoundButtonType.f36165o, UiKitRoundButtonSize.f36155i));
    }

    public final TextView o(ViewGroup parent, CharSequence text, Rect rect) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        TextView textView = (TextView) BaseItemViewFactory.b(this, parent, R$layout.f35776t, rect, 0, 0, null, 28, null);
        textView.setText(text);
        return textView;
    }

    public final RoundButton q(ViewGroup parent, CharSequence text, Rect rect, RoundButtonStyle style) {
        Intrinsics.f(parent, "parent");
        Intrinsics.f(text, "text");
        Intrinsics.f(style, "style");
        return UiKitRoundButtonFactory.f35926a.c(parent, text, rect, style);
    }
}
