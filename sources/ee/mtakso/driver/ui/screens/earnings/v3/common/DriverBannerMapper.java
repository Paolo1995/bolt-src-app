package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.BannerItem;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.DriverBanner;
import eu.bolt.driver.earnings.network.DriverBannerComponent;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import eu.bolt.driver.earnings.network.DriverImage;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverBannerMapper.kt */
/* loaded from: classes3.dex */
public final class DriverBannerMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverImageMapper f29019a;

    /* compiled from: DriverBannerMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29020a;

        static {
            int[] iArr = new int[DriverBanner.Appearance.values().length];
            try {
                iArr[DriverBanner.Appearance.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverBanner.Appearance.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f29020a = iArr;
        }
    }

    @Inject
    public DriverBannerMapper(DriverImageMapper imageMapper) {
        Intrinsics.f(imageMapper, "imageMapper");
        this.f29019a = imageMapper;
    }

    private final BannerItem b(DriverBannerComponent driverBannerComponent) {
        if (driverBannerComponent instanceof DriverBannerComponent.Image) {
            return new BannerItem.Chevron(this.f29019a.a(((DriverBannerComponent.Image) driverBannerComponent).a()));
        }
        return null;
    }

    public final BannerData<DriverButtonAction> a(DriverBanner banner) {
        Text.Value value;
        Image image;
        Color.Attr attr;
        BannerItem bannerItem;
        Intrinsics.f(banner, "banner");
        Text.Value value2 = new Text.Value(banner.e());
        String d8 = banner.d();
        if (d8 != null) {
            value = new Text.Value(d8);
        } else {
            value = null;
        }
        DriverImage c8 = banner.c();
        if (c8 != null) {
            image = this.f29019a.a(c8);
        } else {
            image = null;
        }
        int i8 = WhenMappings.f29020a[banner.b().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                attr = new Color.Attr(R.attr.backPrimary);
            } else {
                attr = new Color.Attr(R.attr.backPrimary);
            }
        } else {
            attr = new Color.Attr(R.attr.dynamicPurple01);
        }
        Color.Attr attr2 = attr;
        DriverBannerComponent f8 = banner.f();
        if (f8 != null) {
            bannerItem = b(f8);
        } else {
            bannerItem = null;
        }
        return new BannerData<>(value2, value, image, attr2, bannerItem, banner.a());
    }
}
