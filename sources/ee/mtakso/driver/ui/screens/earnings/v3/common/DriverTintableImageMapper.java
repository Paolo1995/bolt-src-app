package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Image;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverTintableImageMapper.kt */
/* loaded from: classes3.dex */
public final class DriverTintableImageMapper {
    public final Image a(DriverImage.Tintable image) {
        Intrinsics.f(image, "image");
        return new Image.Url(image.a().a());
    }
}
