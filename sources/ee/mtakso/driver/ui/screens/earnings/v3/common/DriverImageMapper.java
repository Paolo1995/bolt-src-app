package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Image;
import eu.bolt.driver.earnings.network.DriverImage;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverImageMapper.kt */
/* loaded from: classes3.dex */
public final class DriverImageMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverNormalImageMapper f29036a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverTintableImageMapper f29037b;

    @Inject
    public DriverImageMapper(DriverNormalImageMapper normalImageMapper, DriverTintableImageMapper tintableImageMapper) {
        Intrinsics.f(normalImageMapper, "normalImageMapper");
        Intrinsics.f(tintableImageMapper, "tintableImageMapper");
        this.f29036a = normalImageMapper;
        this.f29037b = tintableImageMapper;
    }

    public final Image a(DriverImage image) {
        Intrinsics.f(image, "image");
        if (image instanceof DriverImage.Normal) {
            return this.f29036a.a((DriverImage.Normal) image);
        }
        if (image instanceof DriverImage.Tintable) {
            return this.f29037b.a((DriverImage.Tintable) image);
        }
        return null;
    }
}
