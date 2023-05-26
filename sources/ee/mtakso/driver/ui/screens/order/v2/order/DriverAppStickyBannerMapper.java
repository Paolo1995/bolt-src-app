package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.network.client.order.DriverAppStickyBanner;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverColorMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.DriverColor;
import eu.bolt.driver.earnings.network.DriverImage;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverAppStickyBannerMapper.kt */
/* loaded from: classes3.dex */
public final class DriverAppStickyBannerMapper {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f32201a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverImageMapper f32202b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverColorMapper f32203c;

    @Inject
    public DriverAppStickyBannerMapper(HtmlEngine htmlEngine, DriverImageMapper driverImageMapper, DriverColorMapper driverColorMapper) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(driverImageMapper, "driverImageMapper");
        Intrinsics.f(driverColorMapper, "driverColorMapper");
        this.f32201a = htmlEngine;
        this.f32202b = driverImageMapper;
        this.f32203c = driverColorMapper;
    }

    public final AppStickyBanner a(DriverAppStickyBanner banner) {
        Image image;
        Intrinsics.f(banner, "banner");
        CharSequence a8 = this.f32201a.a(banner.c());
        DriverImage b8 = banner.b();
        Color color = null;
        if (b8 != null) {
            image = this.f32202b.a(b8);
        } else {
            image = null;
        }
        DriverColor a9 = banner.a();
        if (a9 != null) {
            color = this.f32203c.a(a9);
        }
        return new AppStickyBanner(a8, image, color);
    }
}
