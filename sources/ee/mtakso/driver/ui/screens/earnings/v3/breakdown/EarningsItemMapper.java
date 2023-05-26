package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.list.ItemOneLineDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.DriverImage;
import eu.bolt.driver.earnings.network.DriverListItem;
import eu.bolt.driver.earnings.network.DriverListItemComponent;
import eu.bolt.driver.earnings.network.DriverListItemWithNestedItems;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsItemMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsItemMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverImageMapper f28960a;

    /* renamed from: b  reason: collision with root package name */
    private final HtmlEngine f28961b;

    @Inject
    public EarningsItemMapper(DriverImageMapper imageMapper, HtmlEngine htmlEngine) {
        Intrinsics.f(imageMapper, "imageMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f28960a = imageMapper;
        this.f28961b = htmlEngine;
    }

    public final ListModel a(String listId, DriverListItemWithNestedItems item) {
        Image image;
        Color.Attr attr;
        Text.Value value;
        boolean z7;
        DividerModel dividerModel;
        DriverImage.Tintable tintable;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(item, "item");
        DriverListItemComponent d8 = item.d();
        Color.Attr attr2 = null;
        if (d8 instanceof DriverListItemComponent.TextImage) {
            DriverListItemComponent.TextImage textImage = (DriverListItemComponent.TextImage) d8;
            Text.Value value2 = new Text.Value(this.f28961b.a(textImage.b()));
            Image a8 = this.f28960a.a(textImage.a());
            DriverImage a9 = textImage.a();
            if (a9 instanceof DriverImage.Tintable) {
                tintable = (DriverImage.Tintable) a9;
            } else {
                tintable = null;
            }
            if (tintable != null) {
                attr2 = new Color.Attr(R.attr.contentSecondary);
            }
            value = value2;
            attr = attr2;
            image = a8;
        } else if (d8 instanceof DriverListItemComponent.Text) {
            value = new Text.Value(((DriverListItemComponent.Text) d8).a());
            image = null;
            attr = null;
        } else {
            image = null;
            attr = null;
            value = null;
        }
        List<DriverListItem> b8 = item.b();
        if (b8 != null && !b8.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            dividerModel = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
        } else {
            dividerModel = NoDivider.f34829a;
        }
        return new ItemOneLineDelegate.Model(listId, null, null, new Text.Value(item.c()), 2132017739, new Color.Attr(R.attr.contentPrimary), false, null, image, attr, value, 2132017739, new Color.Attr(R.attr.contentPrimary), null, Dimens.c(12), Dimens.c(12), false, item.a(), dividerModel, 0, 598214, null);
    }
}
