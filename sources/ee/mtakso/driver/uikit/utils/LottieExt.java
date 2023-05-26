package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.utils.Lottie;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LottieExt.kt */
/* loaded from: classes5.dex */
public final class LottieExt {

    /* renamed from: a  reason: collision with root package name */
    public static final LottieExt f36047a = new LottieExt();

    private LottieExt() {
    }

    private final Lottie b(Lottie.DarkLight darkLight, Context context) {
        if (ContextUtilsKt.a(context, R$attr.A)) {
            return darkLight.b();
        }
        return darkLight.a();
    }

    public final void a(Lottie lottie, LottieAnimationView lottieView) {
        Intrinsics.f(lottie, "<this>");
        Intrinsics.f(lottieView, "lottieView");
        if (lottie instanceof Lottie.Res) {
            lottieView.setAnimation(((Lottie.Res) lottie).a());
        } else if (lottie instanceof Lottie.Url) {
            lottieView.setAnimationFromUrl(((Lottie.Url) lottie).a());
        } else if (lottie instanceof Lottie.DarkLight) {
            Context context = lottieView.getContext();
            Intrinsics.e(context, "lottieView.context");
            a(b((Lottie.DarkLight) lottie, context), lottieView);
        }
    }
}
