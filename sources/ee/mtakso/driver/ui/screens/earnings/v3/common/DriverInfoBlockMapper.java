package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockDataKt;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverInfoBlockMapper.kt */
/* loaded from: classes3.dex */
public final class DriverInfoBlockMapper {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f29040a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverImageMapper f29041b;

    /* compiled from: DriverInfoBlockMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29042a;

        static {
            int[] iArr = new int[DriverInfoBlock.Appearance.values().length];
            try {
                iArr[DriverInfoBlock.Appearance.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverInfoBlock.Appearance.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverInfoBlock.Appearance.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverInfoBlock.Appearance.NEUTRAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29042a = iArr;
        }
    }

    @Inject
    public DriverInfoBlockMapper(HtmlEngine htmlEngine, DriverImageMapper driverImageMapper) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(driverImageMapper, "driverImageMapper");
        this.f29040a = htmlEngine;
        this.f29041b = driverImageMapper;
    }

    public final InfoBlockData a(DriverInfoBlock infoBlock) {
        InfoBlockType infoBlockType;
        Text.Value value;
        Intrinsics.f(infoBlock, "infoBlock");
        int i8 = WhenMappings.f29042a[infoBlock.a().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        infoBlockType = InfoBlockType.INFO;
                    } else {
                        infoBlockType = InfoBlockType.INFO;
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
        String e8 = infoBlock.e();
        if (e8 != null) {
            value = new Text.Value(this.f29040a.a(e8));
        } else {
            value = null;
        }
        return new InfoBlockData(infoBlockType, value, new Text.Value(this.f29040a.a(infoBlock.d())), infoBlock.c());
    }

    public final InfoBlockDelegate.Model b(String listId, DriverInfoBlock infoBlock) {
        Image image;
        int c8;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(infoBlock, "infoBlock");
        InfoBlockData a8 = a(infoBlock);
        Text c9 = a8.c();
        int a9 = InfoBlockDataKt.a(a8);
        Color j8 = a8.d().j();
        Text b8 = a8.b();
        Color h8 = a8.d().h();
        Color c10 = a8.d().c();
        Background.Attr attr = new Background.Attr(R.attr.infoBlockBackground);
        if (a8.a()) {
            image = this.f29041b.a(infoBlock.b());
            if (image == null) {
                image = a8.d().e();
            }
        } else {
            image = null;
        }
        Image image2 = image;
        Color f8 = a8.d().f();
        int c11 = Dimens.c(16);
        int c12 = Dimens.c(16);
        if (a8.a()) {
            c8 = Dimens.c(12);
        } else {
            c8 = Dimens.c(16);
        }
        return new InfoBlockDelegate.Model(listId, c9, Integer.valueOf(a9), j8, null, b8, h8, null, attr, c10, image2, f8, c11, c12, new Margins(c8, Dimens.c(12), Dimens.c(16), Dimens.c(12)), 144, null);
    }
}
