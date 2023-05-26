package ee.mtakso.driver.ui.screens.settings.pricing;

import ee.mtakso.driver.network.client.driver.DriverPricingConfiguration;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.util.StringUtilsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricingConfigurationExt.kt */
/* loaded from: classes5.dex */
public final class DriverPricingConfigurationExtKt {

    /* compiled from: DriverPricingConfigurationExt.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33244a;

        static {
            int[] iArr = new int[DriverPricingConfiguration.InfoBlockAppearance.values().length];
            try {
                iArr[DriverPricingConfiguration.InfoBlockAppearance.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverPricingConfiguration.InfoBlockAppearance.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverPricingConfiguration.InfoBlockAppearance.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverPricingConfiguration.InfoBlockAppearance.NEUTRAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f33244a = iArr;
        }
    }

    public static final InfoBlockData a(DriverPricingConfiguration.InfoBlock infoBlock) {
        InfoBlockType infoBlockType;
        Text.Value value;
        CharSequence a8;
        Intrinsics.f(infoBlock, "<this>");
        int i8 = WhenMappings.f33244a[infoBlock.a().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        infoBlockType = InfoBlockType.INFO;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    infoBlockType = InfoBlockType.ALERT;
                }
            } else {
                infoBlockType = InfoBlockType.SUCCESS;
            }
        } else {
            infoBlockType = InfoBlockType.WARNING;
        }
        String d8 = infoBlock.d();
        Text.Value value2 = null;
        if (d8 != null && (a8 = StringUtilsKt.a(d8)) != null) {
            value = new Text.Value(a8);
        } else {
            value = null;
        }
        CharSequence a9 = StringUtilsKt.a(infoBlock.c());
        if (a9 != null) {
            value2 = new Text.Value(a9);
        }
        return new InfoBlockData(infoBlockType, value, value2, infoBlock.b());
    }
}
