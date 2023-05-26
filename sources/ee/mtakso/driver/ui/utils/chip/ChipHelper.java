package ee.mtakso.driver.ui.utils.chip;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.image.ImageCallback;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChipHelper.kt */
/* loaded from: classes5.dex */
public final class ChipHelper {

    /* renamed from: a */
    private final Context f34305a;

    /* renamed from: b */
    private final Color.Attr f34306b;

    public ChipHelper(Context context) {
        Intrinsics.f(context, "context");
        this.f34305a = context;
        this.f34306b = new Color.Attr(R.attr.dynamicWhite);
    }

    public static /* synthetic */ void d(ChipHelper chipHelper, ViewGroup viewGroup, int i8, int i9, String str, float f8, int i10, Object obj) {
        float f9;
        if ((i10 & 16) != 0) {
            f9 = 4.0f;
        } else {
            f9 = f8;
        }
        chipHelper.a(viewGroup, i8, i9, str, f9);
    }

    public static /* synthetic */ void e(ChipHelper chipHelper, ViewGroup viewGroup, int i8, String str, float f8, Color color, int i9, Object obj) {
        float f9;
        if ((i9 & 8) != 0) {
            f9 = 4.0f;
        } else {
            f9 = f8;
        }
        if ((i9 & 16) != 0) {
            color = chipHelper.f34306b;
        }
        chipHelper.b(viewGroup, i8, str, f9, color);
    }

    public static /* synthetic */ void f(ChipHelper chipHelper, ViewGroup viewGroup, String str, int i8, String str2, float f8, int i9, Object obj) {
        float f9;
        if ((i9 & 16) != 0) {
            f9 = 4.0f;
        } else {
            f9 = f8;
        }
        chipHelper.c(viewGroup, str, i8, str2, f9);
    }

    public static /* synthetic */ Chip h(ChipHelper chipHelper, int i8, String str, float f8, Color color, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            f8 = 4.0f;
        }
        if ((i9 & 8) != 0) {
            color = chipHelper.f34306b;
        }
        return chipHelper.g(i8, str, f8, color);
    }

    public final void a(ViewGroup target, int i8, int i9, String title, float f8) {
        Intrinsics.f(target, "target");
        Intrinsics.f(title, "title");
        Chip h8 = h(this, i9, title, f8, null, 8, null);
        h8.setChipIcon(ContextCompat.getDrawable(this.f34305a, i8));
        target.addView(h8);
    }

    public final void b(ViewGroup target, int i8, String title, float f8, Color textColor) {
        Intrinsics.f(target, "target");
        Intrinsics.f(title, "title");
        Intrinsics.f(textColor, "textColor");
        target.addView(g(i8, title, f8, textColor));
    }

    public final void c(ViewGroup target, String iconUrl, int i8, String title, float f8) {
        Intrinsics.f(target, "target");
        Intrinsics.f(iconUrl, "iconUrl");
        Intrinsics.f(title, "title");
        Chip h8 = h(this, i8, title, f8, null, 8, null);
        ImageManager.Companion.b(ImageManager.f36075b, null, 1, null).b(new ImageRequest(iconUrl, null, new ColorDrawable(ContextCompat.getColor(this.f34305a, R.color.transparent)), null, 10, null), h8, new ImageCallback<Chip>() { // from class: ee.mtakso.driver.ui.utils.chip.ChipHelper$addChipToLayout$1
            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: e */
            public void b(Chip view, Drawable drawable, Exception exc) {
                Intrinsics.f(view, "view");
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: f */
            public void d(Chip view, Drawable drawable) {
                Intrinsics.f(view, "view");
                view.setChipIcon(null);
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: g */
            public void a(Chip view, Drawable drawable) {
                Intrinsics.f(view, "view");
                Intrinsics.f(drawable, "drawable");
                view.setChipIcon(drawable);
            }

            @Override // ee.mtakso.driver.uikit.utils.image.ImageCallback
            /* renamed from: h */
            public void c(Chip view, Drawable drawable) {
                Intrinsics.f(view, "view");
                view.setChipIcon(drawable);
            }
        });
        target.addView(h8);
    }

    public final Chip g(int i8, String title, float f8, Color textColor) {
        Intrinsics.f(title, "title");
        Intrinsics.f(textColor, "textColor");
        Chip chip = new Chip(this.f34305a);
        chip.setTextAppearanceResource(R.style.chipTextAppearance);
        chip.setChipMinHeight(Dimens.c(36.0f));
        chip.setChipCornerRadius(Dimens.c(f8));
        chip.setChipStartPadding(Dimens.c(12.0f));
        chip.setChipEndPadding(Dimens.c(12.0f));
        chip.setText(title);
        TextViewExtKt.i(chip, textColor);
        chip.setClickable(false);
        chip.setFocusable(false);
        chip.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        chip.setChipBackgroundColor(ContextUtilsKt.c(this.f34305a, i8));
        return chip;
    }
}
