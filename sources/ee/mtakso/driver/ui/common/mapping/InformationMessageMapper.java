package ee.mtakso.driver.ui.common.mapping;

import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.generic.InformationMessage;
import ee.mtakso.driver.ui.common.HighlightTypeExtKt;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.InfoBlockDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Background;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Margins;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.StringUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InformationMessageMapper.kt */
/* loaded from: classes3.dex */
public final class InformationMessageMapper {
    public static /* synthetic */ ListModel b(InformationMessageMapper informationMessageMapper, InformationMessage informationMessage, String str, Color color, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            color = null;
        }
        return informationMessageMapper.a(informationMessage, str, color);
    }

    public final ListModel a(InformationMessage informationMessage, String listId, Color color) {
        Text.Value value;
        Intrinsics.f(informationMessage, "informationMessage");
        Intrinsics.f(listId, "listId");
        String b8 = informationMessage.b();
        Text.Value value2 = null;
        if (b8 != null) {
            value = new Text.Value(b8);
        } else {
            value = null;
        }
        Color h8 = HighlightTypeExtKt.h(informationMessage.c());
        CharSequence a8 = StringUtilsKt.a(informationMessage.a());
        if (a8 != null) {
            value2 = new Text.Value(a8);
        }
        return new InfoBlockDelegate.Model(listId, value, 2132017743, h8, null, value2, HighlightTypeExtKt.c(informationMessage.c()), color, new Background.Attr(R.attr.infoBlockBackground), HighlightTypeExtKt.a(informationMessage.c()), new Image.Res(HighlightTypeExtKt.e(informationMessage.c())), HighlightTypeExtKt.f(informationMessage.c()), Dimens.c(24), Dimens.c(24), new Margins(Dimens.c(12), Dimens.c(12), Dimens.c(16), Dimens.c(12)), 16, null);
    }
}
