package ee.mtakso.driver.ui.screens.order;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.android.maps.core.plugin.driver.MarkerParams;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerParamsFactory.kt */
/* loaded from: classes3.dex */
public final class MarkerParamsFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30972a;

    /* renamed from: b  reason: collision with root package name */
    private final AppThemeManager f30973b;

    /* compiled from: MarkerParamsFactory.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30974a;

        static {
            int[] iArr = new int[MapStyle.values().length];
            try {
                iArr[MapStyle.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStyle.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f30974a = iArr;
        }
    }

    @Inject
    public MarkerParamsFactory(Context context, AppThemeManager appThemeManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(appThemeManager, "appThemeManager");
        this.f30972a = context;
        this.f30973b = appThemeManager;
    }

    private final View A(CharSequence charSequence, int i8, int i9, int i10, int i11) {
        int i12 = i8 & 112;
        int i13 = R.layout.map_pin_view_top;
        if (i12 != 48 && i12 == 80) {
            i13 = R.layout.map_pin_view_bottom;
        }
        View inflate = View.inflate(this.f30972a, i13, null);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        linearLayout.setGravity(i8 & 7);
        TextView textView = (TextView) linearLayout.findViewById(R.id.mapPinLabel);
        textView.setText(charSequence);
        textView.setTextColor(ContextCompat.getColor(this.f30972a, i9));
        ViewCompat.x0(textView, ContextCompat.getColorStateList(this.f30972a, i10));
        ((ImageView) linearLayout.findViewById(R.id.mapPinTriangle)).setColorFilter(ContextCompat.getColor(this.f30972a, i10), PorterDuff.Mode.SRC_IN);
        ((ImageView) linearLayout.findViewById(R.id.mapPinPin)).setImageResource(i11);
        return linearLayout;
    }

    private final Bitmap B(int i8) {
        Drawable drawable = ContextCompat.getDrawable(this.f30972a, i8);
        if (drawable != null) {
            Intrinsics.e(drawable, "checkNotNull(ContextComp…Drawable(context, resId))");
            Canvas canvas = new Canvas();
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            canvas.setBitmap(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            Intrinsics.e(bitmap, "bitmap");
            return bitmap;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final Bitmap C(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        Intrinsics.e(bitmap, "bitmap");
        return bitmap;
    }

    private final PointF a(View view, View view2) {
        return new PointF(((view.getWidth() * 0.5f) + view.getLeft()) / view2.getWidth(), ((view.getHeight() * 0.5f) + view.getTop()) / view2.getHeight());
    }

    private final MarkerParams b(Locatable locatable, CharSequence charSequence, int i8, int i9, int i10) {
        View z7 = z(charSequence, i8, ContextCompat.getColor(this.f30972a, i9), ContextCompat.getColor(this.f30972a, i10));
        Bitmap C = C(z7);
        ImageView imageView = (ImageView) z7.findViewById(R.id.mapPinTriangle);
        return new MarkerParams(locatable, null, C, new PointF(((imageView.getWidth() * 0.5f) + imageView.getLeft()) / z7.getWidth(), 1.0f), 0.0f, 1, false, 18, null);
    }

    private final MarkerParams g(Locatable locatable, int i8) {
        View inflate = View.inflate(this.f30972a, R.layout.map_pin_view, null);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        View view = (ViewGroup) inflate;
        ImageView pin = (ImageView) view.findViewById(R.id.mapPinPin);
        pin.setImageResource(i8);
        Bitmap C = C(view);
        Intrinsics.e(pin, "pin");
        return new MarkerParams(locatable, null, C, a(pin, view), 0.0f, 1, false, 18, null);
    }

    private final int o(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.neutral500;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.neutral600;
    }

    private final int p(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.drawable.ic_map_marker_destination_24dp_dark;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.drawable.ic_map_marker_destination_24dp_light;
    }

    private final int q(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.neutral900;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.white;
    }

    private final int r(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.white;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.neutral900;
    }

    private final int s(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1 && i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return R.color.white;
    }

    private final int t(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.drawable.ic_map_marker_pickup_24dp_dark;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.drawable.ic_map_marker_pickup_24dp_light;
    }

    private final int u(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.green500;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.green700;
    }

    private final int v(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.neutral900;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.white;
    }

    private final int w(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.drawable.ic_map_marker_mid_stop_24dp_dark;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.drawable.ic_map_marker_mid_stop_24dp_light;
    }

    private final int x(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return R.color.purple300;
            }
            throw new NoWhenBranchMatchedException();
        }
        return R.color.purple500;
    }

    private final int y(MapStyle mapStyle) {
        int i8 = WhenMappings.f30974a[mapStyle.ordinal()];
        if (i8 != 1 && i8 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return R.color.white;
    }

    private final View z(CharSequence charSequence, int i8, int i9, int i10) {
        int i11;
        int i12 = i8 & 112;
        if (i12 != 48) {
            if (i12 != 80) {
                i11 = R.layout.map_pin_view_top;
            } else {
                i11 = R.layout.map_bubble_view_bottom;
            }
        } else {
            i11 = R.layout.map_bubble_view_top;
        }
        View inflate = View.inflate(this.f30972a, i11, null);
        Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) linearLayout.findViewById(R.id.mapPinLabel);
        linearLayout.setGravity(i8 & 7);
        textView.setTextColor(i9);
        textView.setText(charSequence);
        ViewCompat.x0(textView, ColorStateList.valueOf(i10));
        ImageViewCompat.c((ImageView) linearLayout.findViewById(R.id.mapPinTriangle), ColorStateList.valueOf(i10));
        return linearLayout;
    }

    public final MarkerParams c(Locatable position, CharSequence bubbleText, int i8) {
        Intrinsics.f(position, "position");
        Intrinsics.f(bubbleText, "bubbleText");
        AppThemeUtils appThemeUtils = AppThemeUtils.f34255a;
        return b(position, bubbleText, i8, y(appThemeUtils.c(this.f30973b.d())), x(appThemeUtils.c(this.f30973b.d())));
    }

    public final MarkerParams d(Locatable position) {
        Intrinsics.f(position, "position");
        return g(position, p(AppThemeUtils.f34255a.c(this.f30973b.d())));
    }

    public final MarkerParams e(Locatable position, CharSequence bubbleText, int i8) {
        Intrinsics.f(position, "position");
        Intrinsics.f(bubbleText, "bubbleText");
        AppThemeUtils appThemeUtils = AppThemeUtils.f34255a;
        View A = A(bubbleText, i8, r(appThemeUtils.c(this.f30973b.d())), q(appThemeUtils.c(this.f30973b.d())), p(appThemeUtils.c(this.f30973b.d())));
        Bitmap C = C(A);
        View findViewById = A.findViewById(R.id.mapPinPin);
        Intrinsics.e(findViewById, "view.findViewById(R.id.mapPinPin)");
        return new MarkerParams(position, null, C, a(findViewById, A), 0.0f, 1, false, 18, null);
    }

    public final MarkerParams f(Locatable position, CharSequence text, Drawable drawable, Integer num) {
        boolean z7;
        Intrinsics.f(position, "position");
        Intrinsics.f(text, "text");
        MapStyle c8 = AppThemeUtils.f34255a.c(this.f30973b.d());
        View labelView = View.inflate(this.f30972a, R.layout.map_fifo_label, null);
        ImageView imageView = (ImageView) labelView.findViewById(R.id.fifoQueueLabelBackground);
        ImageView imageView2 = (ImageView) labelView.findViewById(R.id.fifoQueueLabelImage);
        TextView textView = (TextView) labelView.findViewById(R.id.fifoQueueLabelText);
        int color = ContextCompat.getColor(this.f30972a, o(c8));
        int color2 = ContextCompat.getColor(this.f30972a, s(c8));
        if (num != null) {
            color = num.intValue();
        }
        ViewCompat.x0(imageView, ColorStateList.valueOf(color));
        ImageViewCompat.c(imageView2, ColorStateList.valueOf(color2));
        textView.setTextColor(ColorStateList.valueOf(color2));
        Intrinsics.e(imageView2, "imageView");
        if (drawable != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(imageView2, z7, 0, 2, null);
        imageView2.setImageDrawable(drawable);
        textView.setText(text);
        Intrinsics.e(labelView, "labelView");
        return new MarkerParams(position, null, C(labelView), new PointF(0.5f, 0.5f), 0.0f, 1, false, 18, null);
    }

    public final MarkerParams h(Locatable position) {
        Intrinsics.f(position, "position");
        return g(position, t(AppThemeUtils.f34255a.c(this.f30973b.d())));
    }

    public final MarkerParams i(Locatable position, CharSequence bubbleText, int i8) {
        Intrinsics.f(position, "position");
        Intrinsics.f(bubbleText, "bubbleText");
        AppThemeUtils appThemeUtils = AppThemeUtils.f34255a;
        View A = A(bubbleText, i8, v(appThemeUtils.c(this.f30973b.d())), u(appThemeUtils.c(this.f30973b.d())), t(appThemeUtils.c(this.f30973b.d())));
        Bitmap C = C(A);
        View findViewById = A.findViewById(R.id.mapPinPin);
        Intrinsics.e(findViewById, "view.findViewById(R.id.mapPinPin)");
        return new MarkerParams(position, null, C, a(findViewById, A), 0.0f, 1, false, 18, null);
    }

    public final MarkerParams j(Locatable position, CharSequence bubbleText, int i8) {
        Intrinsics.f(position, "position");
        Intrinsics.f(bubbleText, "bubbleText");
        AppThemeUtils appThemeUtils = AppThemeUtils.f34255a;
        return b(position, bubbleText, i8, v(appThemeUtils.c(this.f30973b.d())), u(appThemeUtils.c(this.f30973b.d())));
    }

    public final MarkerParams k(Locatable position) {
        Intrinsics.f(position, "position");
        return new MarkerParams(position, null, B(R.drawable.ic_rider_location_marker), new PointF(0.5f, 1.0f), 0.0f, 0, false, 50, null);
    }

    public final MarkerParams l(Locatable position, CharSequence charSequence, Drawable drawable, int i8, int i9) {
        boolean z7;
        Intrinsics.f(position, "position");
        View inflate = View.inflate(this.f30972a, R.layout.map_waiting_time_label, null);
        Intrinsics.d(inflate, "null cannot be cast to non-null type androidx.cardview.widget.CardView");
        CardView cardView = (CardView) inflate;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.waitingTimeLabelImage);
        TextView textView = (TextView) cardView.findViewById(R.id.waitingTimeLabelText);
        cardView.setCardBackgroundColor(ColorStateList.valueOf(i9));
        Intrinsics.e(imageView, "imageView");
        boolean z8 = true;
        if (drawable != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(imageView, z7, 0, 2, null);
        imageView.setImageDrawable(drawable);
        Intrinsics.e(textView, "textView");
        if (charSequence == null) {
            z8 = false;
        }
        ViewExtKt.d(textView, z8, 0, 2, null);
        textView.setText(charSequence);
        textView.setTextColor(ColorStateList.valueOf(i8));
        return new MarkerParams(position, null, C(cardView), new PointF(0.5f, 0.5f), 0.0f, 0, false, 18, null);
    }

    public final MarkerParams m(Locatable position, CharSequence bubbleText, int i8) {
        Intrinsics.f(position, "position");
        Intrinsics.f(bubbleText, "bubbleText");
        AppThemeUtils appThemeUtils = AppThemeUtils.f34255a;
        return b(position, bubbleText, i8, y(appThemeUtils.c(this.f30973b.d())), x(appThemeUtils.c(this.f30973b.d())));
    }

    public final MarkerParams n(Locatable position) {
        Intrinsics.f(position, "position");
        return g(position, w(AppThemeUtils.f34255a.c(this.f30973b.d())));
    }
}
