package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceState;
import ee.mtakso.driver.ui.screens.earnings.v3.common.BannerData;
import ee.mtakso.driver.ui.screens.earnings.v3.common.ButtonData;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverBannerMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.EarningsBalanceStateTypeMapper;
import ee.mtakso.driver.ui.views.infoblock.InfoBlockData;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.BalanceHeader;
import eu.bolt.driver.earnings.network.DriverBanner;
import eu.bolt.driver.earnings.network.DriverButton;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import eu.bolt.driver.earnings.network.DriverInfoBlock;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceHeaderMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceHeaderMapper {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsBalanceStateTypeMapper f28799a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverButtonMapper f28800b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverInfoBlockMapper f28801c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverBannerMapper f28802d;

    @Inject
    public EarningsBalanceHeaderMapper(EarningsBalanceStateTypeMapper balanceStateTypeMapper, DriverButtonMapper buttonModelMapper, DriverInfoBlockMapper infoBlockMapper, DriverBannerMapper bannerMapper) {
        Intrinsics.f(balanceStateTypeMapper, "balanceStateTypeMapper");
        Intrinsics.f(buttonModelMapper, "buttonModelMapper");
        Intrinsics.f(infoBlockMapper, "infoBlockMapper");
        Intrinsics.f(bannerMapper, "bannerMapper");
        this.f28799a = balanceStateTypeMapper;
        this.f28800b = buttonModelMapper;
        this.f28801c = infoBlockMapper;
        this.f28802d = bannerMapper;
    }

    public final EarningsBalanceState.PayoutHeader a(BalanceHeader header) {
        Text.Value value;
        ButtonData<DriverButtonAction> buttonData;
        InfoBlockData infoBlockData;
        BannerData<DriverButtonAction> bannerData;
        Intrinsics.f(header, "header");
        Color a8 = this.f28799a.a(header.d());
        Text.Value value2 = new Text.Value(header.f());
        String e8 = header.e();
        if (e8 != null) {
            value = new Text.Value(e8);
        } else {
            value = null;
        }
        DriverButton b8 = header.b();
        if (b8 != null) {
            buttonData = this.f28800b.a(b8);
        } else {
            buttonData = null;
        }
        DriverInfoBlock c8 = header.c();
        if (c8 != null) {
            infoBlockData = this.f28801c.a(c8);
        } else {
            infoBlockData = null;
        }
        DriverBanner a9 = header.a();
        if (a9 != null) {
            bannerData = this.f28802d.a(a9);
        } else {
            bannerData = null;
        }
        return new EarningsBalanceState.PayoutHeader(a8, value2, value, buttonData, infoBlockData, bannerData);
    }
}
