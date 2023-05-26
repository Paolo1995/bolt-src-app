package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Lottie;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverLottieMapper.kt */
/* loaded from: classes3.dex */
public final class DriverLottieMapper {
    public final Lottie a(DriverImage image) {
        Intrinsics.f(image, "image");
        if (!(image instanceof DriverImage.Lottie)) {
            return null;
        }
        DriverImage.Lottie lottie = (DriverImage.Lottie) image;
        DriverImage.Url a8 = lottie.a();
        DriverImage.Url b8 = lottie.b();
        if (a8 == null) {
            return new Lottie.Url(b8.a());
        }
        return new Lottie.DarkLight(new Lottie.Url(a8.a()), new Lottie.Url(b8.a()));
    }
}
