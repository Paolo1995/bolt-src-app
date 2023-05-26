package ee.mtakso.driver.ui.views.infoblock;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoBlockController.kt */
/* loaded from: classes5.dex */
public final class InfoBlockController {

    /* renamed from: a  reason: collision with root package name */
    private final View f34358a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f34359b;

    public InfoBlockController(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f34359b = new LinkedHashMap();
        this.f34358a = containerView;
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f34359b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View c8 = c();
            if (c8 == null || (findViewById = c8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void b(InfoBlockData infoBlockData) {
        boolean z7;
        if (infoBlockData == null) {
            ViewExtKt.d(c(), false, 0, 2, null);
            return;
        }
        ViewExtKt.d(c(), false, 0, 3, null);
        View c8 = c();
        int i8 = R.id.gc;
        AppCompatTextView appCompatTextView = (AppCompatTextView) c8.findViewById(i8);
        Intrinsics.e(appCompatTextView, "containerView.titleText");
        TextViewExtKt.h(appCompatTextView, infoBlockData.c());
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) c().findViewById(i8);
        Intrinsics.e(appCompatTextView2, "containerView.titleText");
        boolean z8 = true;
        if (infoBlockData.c() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.d(appCompatTextView2, z7, 0, 2, null);
        TextViewCompat.o((AppCompatTextView) a(i8), InfoBlockDataKt.a(infoBlockData));
        AppCompatTextView titleText = (AppCompatTextView) a(i8);
        Intrinsics.e(titleText, "titleText");
        TextViewExtKt.i(titleText, infoBlockData.d().j());
        int i9 = R.id.f19833m7;
        AppCompatTextView messageText = (AppCompatTextView) a(i9);
        Intrinsics.e(messageText, "messageText");
        TextViewExtKt.h(messageText, infoBlockData.b());
        AppCompatTextView messageText2 = (AppCompatTextView) a(i9);
        Intrinsics.e(messageText2, "messageText");
        if (infoBlockData.b() == null) {
            z8 = false;
        }
        ViewExtKt.d(messageText2, z8, 0, 2, null);
        AppCompatTextView messageText3 = (AppCompatTextView) a(i9);
        Intrinsics.e(messageText3, "messageText");
        TextViewExtKt.i(messageText3, infoBlockData.d().h());
        ((AppCompatTextView) a(i9)).setMovementMethod(LinkMovementMethod.getInstance());
        int i10 = R.id.f19831l7;
        ConstraintLayout messageBody = (ConstraintLayout) a(i10);
        Intrinsics.e(messageBody, "messageBody");
        ViewExtKt.b(messageBody, infoBlockData.d().c());
        int i11 = R.id.Q5;
        ImageView icon = (ImageView) a(i11);
        Intrinsics.e(icon, "icon");
        ViewExtKt.d(icon, infoBlockData.a(), 0, 2, null);
        Image e8 = infoBlockData.d().e();
        if (e8 != null) {
            ImageView icon2 = (ImageView) a(i11);
            Intrinsics.e(icon2, "icon");
            ImageKt.b(e8, icon2, null, 2, null);
        }
        ImageView icon3 = (ImageView) a(i11);
        Intrinsics.e(icon3, "icon");
        ImageViewExtKt.a(icon3, infoBlockData.d().f());
        Context context = c().getContext();
        Intrinsics.e(context, "containerView.context");
        ((ConstraintLayout) a(i10)).setBackgroundResource(ContextUtilsKt.d(context, R.attr.infoBlockBackground));
    }

    public View c() {
        return this.f34358a;
    }
}
