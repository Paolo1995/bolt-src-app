package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.util.StringUtilsKt;
import eu.bolt.driver.earnings.network.DriverImage;
import eu.bolt.driver.earnings.network.DriverListItem;
import eu.bolt.driver.earnings.network.DriverListItemComponent;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsNestedItemMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsNestedItemMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverImageMapper f28964a;

    @Inject
    public EarningsNestedItemMapper(DriverImageMapper imageMapper) {
        Intrinsics.f(imageMapper, "imageMapper");
        this.f28964a = imageMapper;
    }

    public final ListModel a(String listId, DriverListItem item, DividerModel divider) {
        Image image;
        Color.Attr attr;
        Text.Value value;
        Text.Value value2;
        EarningsNestedItemMapper earningsNestedItemMapper;
        Text.Value value3;
        DriverImage.Tintable tintable;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(item, "item");
        Intrinsics.f(divider, "divider");
        DriverListItemComponent e8 = item.e();
        Color.Attr attr2 = null;
        if (e8 instanceof DriverListItemComponent.TextImage) {
            DriverListItemComponent.TextImage textImage = (DriverListItemComponent.TextImage) e8;
            CharSequence a8 = StringUtilsKt.a(textImage.b());
            if (a8 != null) {
                value3 = new Text.Value(a8);
                earningsNestedItemMapper = this;
            } else {
                earningsNestedItemMapper = this;
                value3 = null;
            }
            Image a9 = earningsNestedItemMapper.f28964a.a(textImage.a());
            DriverImage a10 = textImage.a();
            if (a10 instanceof DriverImage.Tintable) {
                tintable = (DriverImage.Tintable) a10;
            } else {
                tintable = null;
            }
            if (tintable != null) {
                attr2 = new Color.Attr(R.attr.contentSecondary);
            }
            image = a9;
            attr = attr2;
            value = value3;
        } else if (e8 instanceof DriverListItemComponent.Text) {
            CharSequence a11 = StringUtilsKt.a(((DriverListItemComponent.Text) e8).a());
            if (a11 != null) {
                value2 = new Text.Value(a11);
            } else {
                value2 = null;
            }
            value = value2;
            image = null;
            attr = null;
        } else {
            image = null;
            attr = null;
            value = null;
        }
        return new ItemOneLineDelegate.Model(listId, null, null, new Text.Value(item.c()), 2132017739, new Color.Attr(R.attr.contentSecondary), false, null, image, attr, value, 2132017739, new Color.Attr(R.attr.contentPrimary), null, Dimens.c(12), Dimens.c(12), false, item.a(), divider, 1, 73926, null);
    }
}
