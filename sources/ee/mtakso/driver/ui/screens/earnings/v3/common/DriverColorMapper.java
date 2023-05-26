package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.uikit.utils.Color;
import eu.bolt.driver.earnings.network.DriverColor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverColorMapper.kt */
/* loaded from: classes3.dex */
public final class DriverColorMapper {
    public final Color a(DriverColor color) {
        Intrinsics.f(color, "color");
        Integer a8 = color.a();
        if (a8 == null) {
            return new Color.Static(color.b());
        }
        return new Color.DarkLight(new Color.Static(a8.intValue()), new Color.Static(color.b()));
    }
}
