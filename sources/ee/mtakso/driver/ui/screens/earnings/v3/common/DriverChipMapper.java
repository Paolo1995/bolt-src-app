package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.DriverChip;
import eu.bolt.driver.earnings.network.DriverImage;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverChipMapper.kt */
/* loaded from: classes3.dex */
public final class DriverChipMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverImageMapper f29030a;

    /* compiled from: DriverChipMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29031a;

        static {
            int[] iArr = new int[DriverChip.Appearance.values().length];
            try {
                iArr[DriverChip.Appearance.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverChip.Appearance.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverChip.Appearance.PRIMARY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverChip.Appearance.CRITICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverChip.Appearance.NEUTRAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f29031a = iArr;
        }
    }

    @Inject
    public DriverChipMapper(DriverImageMapper imageMapper) {
        Intrinsics.f(imageMapper, "imageMapper");
        this.f29030a = imageMapper;
    }

    private final Color.Attr a(DriverChip driverChip) {
        int i8 = WhenMappings.f29031a[driverChip.a().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            return new Color.Attr(R.attr.labelBackgroundGraySmall);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Color.Attr(R.attr.colorBgDangerSecondary);
                }
                return new Color.Attr(R.attr.colorBgPromoPrimary);
            }
            return new Color.Attr(R.attr.colorBgWarningPrimary);
        }
        return new Color.Attr(R.attr.colorBgActionPrimary);
    }

    private final Color.Attr b(DriverChip driverChip) {
        int i8 = WhenMappings.f29031a[driverChip.a().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            return new Color.Attr(R.attr.labelContentGraySmall);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new Color.Attr(R.attr.colorContentDangerPrimary);
                }
                return new Color.Attr(R.attr.colorContentKeyLight);
            }
            return new Color.Attr(R.attr.colorContentKeyLight);
        }
        return new Color.Attr(R.attr.colorContentKeyLight);
    }

    public final ChipModel c(DriverChip chip) {
        Text.Value value;
        Intrinsics.f(chip, "chip");
        String c8 = chip.c();
        Image image = null;
        if (c8 != null) {
            value = new Text.Value(c8);
        } else {
            value = null;
        }
        Color.Attr b8 = b(chip);
        DriverImage b9 = chip.b();
        if (b9 != null) {
            image = this.f29030a.a(b9);
        }
        Image image2 = image;
        DriverImage b10 = chip.b();
        if (b10 instanceof DriverImage.Tintable) {
            DriverImage.Tintable tintable = (DriverImage.Tintable) b10;
        }
        return new ChipModel(value, b8, image2, new Color.Attr(R.attr.dynamicWhite), a(chip));
    }
}
