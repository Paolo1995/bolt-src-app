package ee.mtakso.driver.ui.screens.settings;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import j$.util.Spliterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsItemFactory.kt */
/* loaded from: classes5.dex */
public final class SettingsItemFactory {

    /* renamed from: a */
    public static final SettingsItemFactory f33091a = new SettingsItemFactory();

    private SettingsItemFactory() {
    }

    public static /* synthetic */ TwoLinesItemDelegate.Model b(SettingsItemFactory settingsItemFactory, String str, Text text, Text text2, Color color, Image image, Color color2, Image image2, TwoLinesItemDelegate.Indicator indicator, Object obj, DividerModel dividerModel, int i8, Object obj2) {
        Text text3;
        Text text4;
        Color color3;
        Image image3;
        Color color4;
        Image image4;
        TwoLinesItemDelegate.Indicator indicator2;
        DividerModel dividerModel2;
        Object obj3 = null;
        if ((i8 & 2) != 0) {
            text3 = null;
        } else {
            text3 = text;
        }
        if ((i8 & 4) != 0) {
            text4 = null;
        } else {
            text4 = text2;
        }
        if ((i8 & 8) != 0) {
            color3 = new Color.Attr(R.attr.accentNeutral);
        } else {
            color3 = color;
        }
        if ((i8 & 16) != 0) {
            image3 = null;
        } else {
            image3 = image;
        }
        if ((i8 & 32) != 0) {
            color4 = new Color.Attr(R.attr.dynamicNeutral04);
        } else {
            color4 = color2;
        }
        if ((i8 & 64) != 0) {
            image4 = new Image.Res(R.drawable.ic_chevron_right);
        } else {
            image4 = image2;
        }
        if ((i8 & 128) != 0) {
            indicator2 = null;
        } else {
            indicator2 = indicator;
        }
        if ((i8 & Spliterator.NONNULL) == 0) {
            obj3 = obj;
        }
        if ((i8 & 512) != 0) {
            dividerModel2 = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
        } else {
            dividerModel2 = dividerModel;
        }
        return settingsItemFactory.a(str, text3, text4, color3, image3, color4, image4, indicator2, obj3, dividerModel2);
    }

    public final <T> TwoLinesItemDelegate.Model<T> a(String listId, Text text, Text text2, Color color, Image image, Color color2, Image image2, TwoLinesItemDelegate.Indicator indicator, T t7, DividerModel divider) {
        Intrinsics.f(listId, "listId");
        Intrinsics.f(divider, "divider");
        return new TwoLinesItemDelegate.Model<>(listId, text, null, new Color.Attr(R.attr.contentPrimary), null, text2, null, new Color.Attr(R.attr.contentSecondary), color, image, null, color2, image2, null, null, null, new Color.Attr(R.attr.backPrimary), indicator, t7, false, 0, 0, divider.e(), divider.d(), divider.f(), divider.i(), divider.j(), divider.k(), false, 272163924, null);
    }
}
