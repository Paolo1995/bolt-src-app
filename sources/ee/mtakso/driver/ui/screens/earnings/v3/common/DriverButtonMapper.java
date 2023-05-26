package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.ButtonItemDelegate;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.earnings.network.DriverButton;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverButtonMapper.kt */
/* loaded from: classes3.dex */
public final class DriverButtonMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverButtonSizeMapper f29024a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverButtonAppearanceMapper f29025b;

    @Inject
    public DriverButtonMapper(DriverButtonSizeMapper sizeMapper, DriverButtonAppearanceMapper appearanceMapper) {
        Intrinsics.f(sizeMapper, "sizeMapper");
        Intrinsics.f(appearanceMapper, "appearanceMapper");
        this.f29024a = sizeMapper;
        this.f29025b = appearanceMapper;
    }

    public final ButtonData<DriverButtonAction> a(DriverButton button) {
        Text.Value value;
        Intrinsics.f(button, "button");
        String e8 = button.e();
        if (e8 != null) {
            value = new Text.Value(e8);
        } else {
            value = null;
        }
        return new ButtonData<>(value, this.f29025b.a(button.b()), this.f29024a.a(button.d()), button.c(), button.a());
    }

    public final ButtonItemDelegate.Model<DriverButtonAction> b(String listId, DriverButton button) {
        Text.Value value;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(button, "button");
        String e8 = button.e();
        if (e8 != null) {
            value = new Text.Value(e8);
        } else {
            value = null;
        }
        return new ButtonItemDelegate.Model<>(listId, value, null, null, this.f29024a.a(button.d()), this.f29025b.a(button.b()), null, null, true, null, new Margins(Dimens.c(24), Dimens.c(6), Dimens.c(24), Dimens.c(6)), button.a(), false, null, null, 0.0f, false, false, 258764, null);
    }
}
