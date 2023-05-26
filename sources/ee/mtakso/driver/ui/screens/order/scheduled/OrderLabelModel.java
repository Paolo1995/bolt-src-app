package ee.mtakso.driver.ui.screens.order.scheduled;

import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderLabelModel.kt */
/* loaded from: classes3.dex */
public final class OrderLabelModel {

    /* renamed from: a  reason: collision with root package name */
    private final Image f31606a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f31607b;

    public OrderLabelModel(Image image, Text text) {
        Intrinsics.f(text, "text");
        this.f31606a = image;
        this.f31607b = text;
    }

    public final Image a() {
        return this.f31606a;
    }

    public final Text b() {
        return this.f31607b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderLabelModel) {
            OrderLabelModel orderLabelModel = (OrderLabelModel) obj;
            return Intrinsics.a(this.f31606a, orderLabelModel.f31606a) && Intrinsics.a(this.f31607b, orderLabelModel.f31607b);
        }
        return false;
    }

    public int hashCode() {
        Image image = this.f31606a;
        return ((image == null ? 0 : image.hashCode()) * 31) + this.f31607b.hashCode();
    }

    public String toString() {
        Image image = this.f31606a;
        Text text = this.f31607b;
        return "OrderLabelModel(icon=" + image + ", text=" + text + ")";
    }
}
