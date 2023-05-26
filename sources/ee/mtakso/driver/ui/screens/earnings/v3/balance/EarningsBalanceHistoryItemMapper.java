package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHistoryDelegate;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverContentTypeMapper;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.earnings.network.DriverContentType;
import eu.bolt.driver.earnings.network.DriverListItem;
import eu.bolt.driver.earnings.network.DriverListItemComponent;
import eu.bolt.kalev.Kalev;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceHistoryItemMapper.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceHistoryItemMapper {

    /* renamed from: a  reason: collision with root package name */
    private final DriverContentTypeMapper f28822a;

    /* renamed from: b  reason: collision with root package name */
    private final HtmlEngine f28823b;

    @Inject
    public EarningsBalanceHistoryItemMapper(DriverContentTypeMapper contentTypeMapper, HtmlEngine htmlEngine) {
        Intrinsics.f(contentTypeMapper, "contentTypeMapper");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f28822a = contentTypeMapper;
        this.f28823b = htmlEngine;
    }

    public final EarningsBalanceHistoryDelegate.Model a(String listId, DriverListItem listItem, DividerModel divider) {
        Color color;
        Color color2;
        Text.Value value;
        Text.Value value2;
        Color color3;
        Color color4;
        Color attr;
        Color color5;
        Intrinsics.f(listId, "listId");
        Intrinsics.f(listItem, "listItem");
        Intrinsics.f(divider, "divider");
        DriverListItemComponent e8 = listItem.e();
        Text.Value value3 = null;
        if (e8 instanceof DriverListItemComponent.Text) {
            DriverListItemComponent.Text text = (DriverListItemComponent.Text) e8;
            Text.Value value4 = new Text.Value(this.f28823b.a(text.a()));
            DriverContentType b8 = text.b();
            if (b8 != null) {
                color = this.f28822a.a(b8);
            } else {
                color = null;
            }
            color2 = null;
            value2 = null;
            value = value4;
        } else if (e8 instanceof DriverListItemComponent.TitleSubtitle) {
            DriverListItemComponent.TitleSubtitle titleSubtitle = (DriverListItemComponent.TitleSubtitle) e8;
            Text.Value value5 = new Text.Value(this.f28823b.a(titleSubtitle.c()));
            DriverContentType d8 = titleSubtitle.d();
            if (d8 != null) {
                color3 = this.f28822a.a(d8);
            } else {
                color3 = null;
            }
            Text.Value value6 = new Text.Value(this.f28823b.a(titleSubtitle.a()));
            DriverContentType b9 = titleSubtitle.b();
            if (b9 != null) {
                color4 = this.f28822a.a(b9);
            } else {
                color4 = null;
            }
            value2 = value6;
            value = value5;
            Color color6 = color3;
            color2 = color4;
            color = color6;
        } else {
            if (e8 != null) {
                Kalev.m(new IllegalArgumentException("Unsupported trailing_component type"), "Unsupported trailing_component type");
            }
            color = null;
            color2 = null;
            value = null;
            value2 = null;
        }
        Text.Value value7 = new Text.Value(this.f28823b.a(listItem.c()));
        DriverContentType d9 = listItem.d();
        if (d9 == null || (attr = this.f28822a.a(d9)) == null) {
            attr = new Color.Attr(R.attr.contentPrimary);
        }
        String b10 = listItem.b();
        if (b10 != null) {
            value3 = new Text.Value(this.f28823b.a(b10));
        }
        Text.Value value8 = value3;
        Color.Attr attr2 = new Color.Attr(R.attr.contentSecondary);
        if (color == null) {
            color = new Color.Attr(R.attr.contentPrimary);
        }
        Color color7 = color;
        if (color2 == null) {
            color5 = new Color.Attr(R.attr.contentSecondary);
        } else {
            color5 = color2;
        }
        return new EarningsBalanceHistoryDelegate.Model(listId, value7, attr, value8, attr2, value, color7, value2, color5, listItem.a(), divider);
    }
}
