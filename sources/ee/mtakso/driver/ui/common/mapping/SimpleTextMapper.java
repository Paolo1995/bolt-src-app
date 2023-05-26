package ee.mtakso.driver.ui.common.mapping;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.SimpleTextDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleTextMapper.kt */
/* loaded from: classes3.dex */
public final class SimpleTextMapper {
    public final ListModel a(Text text, String listId, Color color, Object obj) {
        Intrinsics.f(listId, "listId");
        Color.Res res = new Color.Res(R.color.purple300);
        int c8 = Dimens.c(8);
        return new SimpleTextDelegate.Model(listId, text, color, Dimens.c(24), Dimens.c(24), c8, Dimens.c(8), 0.0f, null, res, true, obj, 384, null);
    }

    public final ListModel b(Text text, String listId, Color color) {
        Intrinsics.f(listId, "listId");
        int c8 = Dimens.c(8);
        return new SimpleTextDelegate.Model(listId, text, color, Dimens.c(24), Dimens.c(24), c8, Dimens.c(8), 0.0f, null, null, false, null, 3968, null);
    }
}
