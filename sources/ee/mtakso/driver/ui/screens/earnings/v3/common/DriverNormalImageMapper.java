package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Image;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverNormalImageMapper.kt */
/* loaded from: classes3.dex */
public final class DriverNormalImageMapper {
    public final Image a(DriverImage.Normal image) {
        Intrinsics.f(image, "image");
        DriverImage.Url a8 = image.a();
        DriverImage.Url b8 = image.b();
        if (a8 == null) {
            return new Image.Url(b8.a());
        }
        return new Image.DarkLight(new Image.Url(a8.a()), new Image.Url(b8.a()));
    }
}
