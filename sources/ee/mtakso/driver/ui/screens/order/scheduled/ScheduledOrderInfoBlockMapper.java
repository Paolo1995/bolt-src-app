package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.network.client.order.RideDetailInfoBlock;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledOrderInfoBlockMapper.kt */
/* loaded from: classes3.dex */
public final class ScheduledOrderInfoBlockMapper {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f31742a;

    /* compiled from: ScheduledOrderInfoBlockMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31743a;

        static {
            int[] iArr = new int[RideDetailInfoBlock.Type.values().length];
            try {
                iArr[RideDetailInfoBlock.Type.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RideDetailInfoBlock.Type.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RideDetailInfoBlock.Type.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RideDetailInfoBlock.Type.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f31743a = iArr;
        }
    }

    @Inject
    public ScheduledOrderInfoBlockMapper(HtmlEngine htmlEngine) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f31742a = htmlEngine;
    }

    public final InfoBlockData a(RideDetailInfoBlock infoBlock) {
        InfoBlockType infoBlockType;
        Text.Value value;
        Intrinsics.f(infoBlock, "infoBlock");
        int i8 = WhenMappings.f31743a[infoBlock.d().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        infoBlockType = InfoBlockType.INFO;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    infoBlockType = InfoBlockType.WARNING;
                }
            } else {
                infoBlockType = InfoBlockType.ALERT;
            }
        } else {
            infoBlockType = InfoBlockType.SUCCESS;
        }
        Text.Value value2 = new Text.Value(this.f31742a.a(infoBlock.c()));
        String b8 = infoBlock.b();
        if (b8 != null) {
            value = new Text.Value(b8);
        } else {
            value = null;
        }
        return new InfoBlockData(infoBlockType, value2, value, infoBlock.a());
    }
}
