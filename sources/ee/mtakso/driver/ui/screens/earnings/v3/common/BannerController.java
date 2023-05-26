package ee.mtakso.driver.ui.screens.earnings.v3.common;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.BannerItem;
import ee.mtakso.driver.uikit.internal.drawable.RippleDrawableHelper;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerController.kt */
/* loaded from: classes3.dex */
public final class BannerController {

    /* renamed from: a  reason: collision with root package name */
    private final View f28979a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f28980b;

    public BannerController(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f28980b = new LinkedHashMap();
        this.f28979a = containerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 onClick, View view) {
        Intrinsics.f(onClick, "$onClick");
        onClick.invoke();
    }

    public View b(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28980b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View e8 = e();
            if (e8 == null || (findViewById = e8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void c(BannerData<?> bannerData, final Function0<Unit> onClick) {
        boolean z7;
        CharSequence charSequence;
        boolean z8;
        Intrinsics.f(onClick, "onClick");
        if (bannerData == null) {
            ViewExtKt.d(e(), false, 0, 2, null);
            return;
        }
        boolean z9 = true;
        ViewExtKt.d(e(), true, 0, 2, null);
        Context context = e().getContext();
        Text e8 = bannerData.e();
        Intrinsics.e(context, "context");
        ((TextView) b(R.id.bannerTitle)).setText(TextKt.a(e8, context));
        int i8 = R.id.bannerSubtitle;
        TextView bannerSubtitle = (TextView) b(i8);
        Intrinsics.e(bannerSubtitle, "bannerSubtitle");
        if (bannerData.d() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(bannerSubtitle, z7, 0, 2, null);
        TextView textView = (TextView) b(i8);
        Text d8 = bannerData.d();
        if (d8 != null) {
            charSequence = TextKt.a(d8, context);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        int i9 = R.id.bannerImage;
        ImageView bannerImage = (ImageView) b(i9);
        Intrinsics.e(bannerImage, "bannerImage");
        if (bannerData.b() != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        ViewExtKt.d(bannerImage, z8, 0, 2, null);
        Image b8 = bannerData.b();
        if (b8 != null) {
            ImageView bannerImage2 = (ImageView) b(i9);
            Intrinsics.e(bannerImage2, "bannerImage");
            ImageKt.b(b8, bannerImage2, null, 2, null);
        }
        if (bannerData.f() instanceof BannerItem.Chevron) {
            int i10 = R.id.bannerChevron;
            ImageView bannerChevron = (ImageView) b(i10);
            Intrinsics.e(bannerChevron, "bannerChevron");
            if (((BannerItem.Chevron) bannerData.f()).a() == null) {
                z9 = false;
            }
            ViewExtKt.d(bannerChevron, z9, 0, 2, null);
            Image a8 = ((BannerItem.Chevron) bannerData.f()).a();
            if (a8 != null) {
                ImageView bannerChevron2 = (ImageView) b(i10);
                Intrinsics.e(bannerChevron2, "bannerChevron");
                ImageKt.b(a8, bannerChevron2, null, 2, null);
            }
        } else {
            ImageView bannerChevron3 = (ImageView) b(R.id.bannerChevron);
            Intrinsics.e(bannerChevron3, "bannerChevron");
            ViewExtKt.d(bannerChevron3, false, 0, 2, null);
        }
        RippleDrawableHelper rippleDrawableHelper = RippleDrawableHelper.f35939a;
        int i11 = R.id.bannerBackground;
        ImageView bannerBackground = (ImageView) b(i11);
        Intrinsics.e(bannerBackground, "bannerBackground");
        int a9 = ColorKt.a(bannerData.a(), context);
        int b9 = ContextUtilsKt.b(context, R.attr.dynamicNeutral01);
        float b10 = Dimens.b(8.0f);
        bannerBackground.setBackground(rippleDrawableHelper.c(a9, b9, new RippleDrawableHelper.CornerRadiuses(b10, b10, b10, b10), 0.0f, Paint.Style.FILL, new Rect()));
        ((ImageView) b(i11)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerController.d(Function0.this, view);
            }
        });
    }

    public View e() {
        return this.f28979a;
    }
}
