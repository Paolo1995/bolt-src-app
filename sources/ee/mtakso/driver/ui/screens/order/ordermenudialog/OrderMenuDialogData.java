package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderMenuDialogData.kt */
/* loaded from: classes3.dex */
public final class OrderMenuDialogData {

    /* renamed from: a  reason: collision with root package name */
    private final Text f31533a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f31534b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f31535c;

    /* renamed from: d  reason: collision with root package name */
    private final Destination f31536d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderMenuSection f31537e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f31538f;

    /* compiled from: OrderMenuDialogData.kt */
    /* loaded from: classes3.dex */
    public enum ButtonType {
        ADD_STOP,
        END_RIDE
    }

    /* compiled from: OrderMenuDialogData.kt */
    /* loaded from: classes3.dex */
    public enum OrderMenuSection {
        SHARE_TRIP,
        CANCEL_RIDE,
        CONTACT,
        NAVIGATION,
        PRICE,
        WAYBILL,
        STOPS,
        CANCEL_NEXT_RIDE,
        MATCH_TO_DESTINATION
    }

    public OrderMenuDialogData(Text title, Text text, Text text2, Destination destination, OrderMenuSection type, boolean z7) {
        Intrinsics.f(title, "title");
        Intrinsics.f(type, "type");
        this.f31533a = title;
        this.f31534b = text;
        this.f31535c = text2;
        this.f31536d = destination;
        this.f31537e = type;
        this.f31538f = z7;
    }

    public static /* synthetic */ OrderMenuDialogData b(OrderMenuDialogData orderMenuDialogData, Text text, Text text2, Text text3, Destination destination, OrderMenuSection orderMenuSection, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            text = orderMenuDialogData.f31533a;
        }
        if ((i8 & 2) != 0) {
            text2 = orderMenuDialogData.f31534b;
        }
        Text text4 = text2;
        if ((i8 & 4) != 0) {
            text3 = orderMenuDialogData.f31535c;
        }
        Text text5 = text3;
        if ((i8 & 8) != 0) {
            destination = orderMenuDialogData.f31536d;
        }
        Destination destination2 = destination;
        if ((i8 & 16) != 0) {
            orderMenuSection = orderMenuDialogData.f31537e;
        }
        OrderMenuSection orderMenuSection2 = orderMenuSection;
        if ((i8 & 32) != 0) {
            z7 = orderMenuDialogData.f31538f;
        }
        return orderMenuDialogData.a(text, text4, text5, destination2, orderMenuSection2, z7);
    }

    public final OrderMenuDialogData a(Text title, Text text, Text text2, Destination destination, OrderMenuSection type, boolean z7) {
        Intrinsics.f(title, "title");
        Intrinsics.f(type, "type");
        return new OrderMenuDialogData(title, text, text2, destination, type, z7);
    }

    public final Destination c() {
        return this.f31536d;
    }

    public final Text d() {
        return this.f31535c;
    }

    public final boolean e() {
        return this.f31538f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderMenuDialogData) {
            OrderMenuDialogData orderMenuDialogData = (OrderMenuDialogData) obj;
            return Intrinsics.a(this.f31533a, orderMenuDialogData.f31533a) && Intrinsics.a(this.f31534b, orderMenuDialogData.f31534b) && Intrinsics.a(this.f31535c, orderMenuDialogData.f31535c) && Intrinsics.a(this.f31536d, orderMenuDialogData.f31536d) && this.f31537e == orderMenuDialogData.f31537e && this.f31538f == orderMenuDialogData.f31538f;
        }
        return false;
    }

    public final Text f() {
        return this.f31534b;
    }

    public final Text g() {
        return this.f31533a;
    }

    public final OrderMenuSection h() {
        return this.f31537e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f31533a.hashCode() * 31;
        Text text = this.f31534b;
        int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
        Text text2 = this.f31535c;
        int hashCode3 = (hashCode2 + (text2 == null ? 0 : text2.hashCode())) * 31;
        Destination destination = this.f31536d;
        int hashCode4 = (((hashCode3 + (destination != null ? destination.hashCode() : 0)) * 31) + this.f31537e.hashCode()) * 31;
        boolean z7 = this.f31538f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode4 + i8;
    }

    public String toString() {
        Text text = this.f31533a;
        Text text2 = this.f31534b;
        Text text3 = this.f31535c;
        Destination destination = this.f31536d;
        OrderMenuSection orderMenuSection = this.f31537e;
        boolean z7 = this.f31538f;
        return "OrderMenuDialogData(title=" + text + ", subtitle=" + text2 + ", endLabel=" + text3 + ", destination=" + destination + ", type=" + orderMenuSection + ", loadingEnabled=" + z7 + ")";
    }

    public /* synthetic */ OrderMenuDialogData(Text text, Text text2, Text text3, Destination destination, OrderMenuSection orderMenuSection, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(text, (i8 & 2) != 0 ? null : text2, (i8 & 4) != 0 ? null : text3, (i8 & 8) != 0 ? null : destination, orderMenuSection, (i8 & 32) != 0 ? false : z7);
    }
}
