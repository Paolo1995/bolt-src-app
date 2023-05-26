package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import ee.mtakso.driver.network.client.campaign.InfoBlock;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockType;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignInfoBlockMapper.kt */
/* loaded from: classes3.dex */
public final class CampaignInfoBlockMapper {

    /* renamed from: a  reason: collision with root package name */
    private final HtmlEngine f27476a;

    /* compiled from: CampaignInfoBlockMapper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27477a;

        static {
            int[] iArr = new int[InfoBlock.Appearance.values().length];
            try {
                iArr[InfoBlock.Appearance.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InfoBlock.Appearance.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InfoBlock.Appearance.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InfoBlock.Appearance.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InfoBlock.Appearance.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f27477a = iArr;
        }
    }

    @Inject
    public CampaignInfoBlockMapper(HtmlEngine htmlEngine) {
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f27476a = htmlEngine;
    }

    public final InfoBlockData a(InfoBlock infoBlock) {
        InfoBlockType infoBlockType;
        Text.Value value;
        Intrinsics.f(infoBlock, "infoBlock");
        int i8 = WhenMappings.f27477a[infoBlock.a().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            infoBlockType = InfoBlockType.INFO;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        infoBlockType = InfoBlockType.INFO;
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
        Text.Value value2 = new Text.Value(this.f27476a.a(infoBlock.d()));
        String c8 = infoBlock.c();
        if (c8 != null) {
            value = new Text.Value(this.f27476a.a(c8));
        } else {
            value = null;
        }
        return new InfoBlockData(infoBlockType, value2, value, infoBlock.b());
    }
}
