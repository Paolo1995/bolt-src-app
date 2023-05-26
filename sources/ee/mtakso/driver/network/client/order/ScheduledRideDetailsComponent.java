package ee.mtakso.driver.network.client.order;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScheduledRideDetailsComponent.kt */
/* loaded from: classes3.dex */
public abstract class ScheduledRideDetailsComponent {

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class Button extends ScheduledRideDetailsComponent {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f22557a;
        @SerializedName("appearance")

        /* renamed from: b  reason: collision with root package name */
        private final ButtonAppearance f22558b;
        @SerializedName("action")

        /* renamed from: c  reason: collision with root package name */
        private final ButtonAction f22559c;
        @SerializedName("confirmation_dialog")

        /* renamed from: d  reason: collision with root package name */
        private final ConfirmationDialog f22560d;

        public final ButtonAction a() {
            return this.f22559c;
        }

        public final ButtonAppearance b() {
            return this.f22558b;
        }

        public final ConfirmationDialog c() {
            return this.f22560d;
        }

        public final String d() {
            return this.f22557a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Button) {
                Button button = (Button) obj;
                return Intrinsics.a(this.f22557a, button.f22557a) && this.f22558b == button.f22558b && this.f22559c == button.f22559c && Intrinsics.a(this.f22560d, button.f22560d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f22557a.hashCode() * 31) + this.f22558b.hashCode()) * 31) + this.f22559c.hashCode()) * 31;
            ConfirmationDialog confirmationDialog = this.f22560d;
            return hashCode + (confirmationDialog == null ? 0 : confirmationDialog.hashCode());
        }

        public String toString() {
            String str = this.f22557a;
            ButtonAppearance buttonAppearance = this.f22558b;
            ButtonAction buttonAction = this.f22559c;
            ConfirmationDialog confirmationDialog = this.f22560d;
            return "Button(title=" + str + ", appearance=" + buttonAppearance + ", action=" + buttonAction + ", confirmationDialog=" + confirmationDialog + ")";
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public enum ButtonAction {
        CANCEL,
        START_DRIVING,
        ACCEPT,
        UNKNOWN
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public enum ButtonAppearance {
        ACTION,
        PRIMARY,
        CRITICAL,
        UNKNOWN
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmationDialog {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f22561a;
        @SerializedName("text")

        /* renamed from: b  reason: collision with root package name */
        private final String f22562b;

        public final String a() {
            return this.f22562b;
        }

        public final String b() {
            return this.f22561a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ConfirmationDialog) {
                ConfirmationDialog confirmationDialog = (ConfirmationDialog) obj;
                return Intrinsics.a(this.f22561a, confirmationDialog.f22561a) && Intrinsics.a(this.f22562b, confirmationDialog.f22562b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f22561a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f22562b.hashCode();
        }

        public String toString() {
            String str = this.f22561a;
            String str2 = this.f22562b;
            return "ConfirmationDialog(title=" + str + ", textHtml=" + str2 + ")";
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends ScheduledRideDetailsComponent {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f22563a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class Header extends ScheduledRideDetailsComponent {
        @SerializedName("title_html")

        /* renamed from: a  reason: collision with root package name */
        private final String f22564a;
        @SerializedName("ride_detail_chips")

        /* renamed from: b  reason: collision with root package name */
        private final List<RideDetailChip> f22565b;
        @SerializedName("ride_details")

        /* renamed from: c  reason: collision with root package name */
        private final List<RideDetailLabel> f22566c;
        @SerializedName("map_points")

        /* renamed from: d  reason: collision with root package name */
        private final List<OrderMapPoint> f22567d;
        @SerializedName("route_points")

        /* renamed from: e  reason: collision with root package name */
        private final List<RideDetailRoutePoint> f22568e;
        @SerializedName("infoblock")

        /* renamed from: f  reason: collision with root package name */
        private final RideDetailInfoBlock f22569f;

        public final RideDetailInfoBlock a() {
            return this.f22569f;
        }

        public final List<OrderMapPoint> b() {
            return this.f22567d;
        }

        public final List<RideDetailLabel> c() {
            return this.f22566c;
        }

        public final List<RideDetailChip> d() {
            return this.f22565b;
        }

        public final List<RideDetailRoutePoint> e() {
            return this.f22568e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Header) {
                Header header = (Header) obj;
                return Intrinsics.a(this.f22564a, header.f22564a) && Intrinsics.a(this.f22565b, header.f22565b) && Intrinsics.a(this.f22566c, header.f22566c) && Intrinsics.a(this.f22567d, header.f22567d) && Intrinsics.a(this.f22568e, header.f22568e) && Intrinsics.a(this.f22569f, header.f22569f);
            }
            return false;
        }

        public final String f() {
            return this.f22564a;
        }

        public int hashCode() {
            int hashCode = ((((((((this.f22564a.hashCode() * 31) + this.f22565b.hashCode()) * 31) + this.f22566c.hashCode()) * 31) + this.f22567d.hashCode()) * 31) + this.f22568e.hashCode()) * 31;
            RideDetailInfoBlock rideDetailInfoBlock = this.f22569f;
            return hashCode + (rideDetailInfoBlock == null ? 0 : rideDetailInfoBlock.hashCode());
        }

        public String toString() {
            String str = this.f22564a;
            List<RideDetailChip> list = this.f22565b;
            List<RideDetailLabel> list2 = this.f22566c;
            List<OrderMapPoint> list3 = this.f22567d;
            List<RideDetailRoutePoint> list4 = this.f22568e;
            RideDetailInfoBlock rideDetailInfoBlock = this.f22569f;
            return "Header(titleHtml=" + str + ", rideDetailsChips=" + list + ", rideDetails=" + list2 + ", mapPoints=" + list3 + ", routePoints=" + list4 + ", infoBlock=" + rideDetailInfoBlock + ")";
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class Link extends ScheduledRideDetailsComponent {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f22570a;
        @SerializedName(ImagesContract.URL)

        /* renamed from: b  reason: collision with root package name */
        private final String f22571b;

        public final String a() {
            return this.f22570a;
        }

        public final String b() {
            return this.f22571b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Link) {
                Link link = (Link) obj;
                return Intrinsics.a(this.f22570a, link.f22570a) && Intrinsics.a(this.f22571b, link.f22571b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f22570a.hashCode() * 31) + this.f22571b.hashCode();
        }

        public String toString() {
            String str = this.f22570a;
            String str2 = this.f22571b;
            return "Link(title=" + str + ", url=" + str2 + ")";
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class ListItem extends ScheduledRideDetailsComponent {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f22572a;
        @SerializedName("subtitle")

        /* renamed from: b  reason: collision with root package name */
        private final String f22573b;
        @SerializedName("tintable_icon_url")

        /* renamed from: c  reason: collision with root package name */
        private final String f22574c;
        @SerializedName("has_divider")

        /* renamed from: d  reason: collision with root package name */
        private final boolean f22575d;

        public final boolean a() {
            return this.f22575d;
        }

        public final String b() {
            return this.f22573b;
        }

        public final String c() {
            return this.f22574c;
        }

        public final String d() {
            return this.f22572a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListItem) {
                ListItem listItem = (ListItem) obj;
                return Intrinsics.a(this.f22572a, listItem.f22572a) && Intrinsics.a(this.f22573b, listItem.f22573b) && Intrinsics.a(this.f22574c, listItem.f22574c) && this.f22575d == listItem.f22575d;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f22572a.hashCode() * 31;
            String str = this.f22573b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f22574c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z7 = this.f22575d;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode3 + i8;
        }

        public String toString() {
            String str = this.f22572a;
            String str2 = this.f22573b;
            String str3 = this.f22574c;
            boolean z7 = this.f22575d;
            return "ListItem(title=" + str + ", subtitle=" + str2 + ", tintableIconUrl=" + str3 + ", hasDivider=" + z7 + ")";
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class SectionDivider extends ScheduledRideDetailsComponent {

        /* renamed from: a  reason: collision with root package name */
        public static final SectionDivider f22576a = new SectionDivider();

        private SectionDivider() {
            super(null);
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public static final class Text extends ScheduledRideDetailsComponent {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f22577a;

        public final String a() {
            return this.f22577a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Text) && Intrinsics.a(this.f22577a, ((Text) obj).f22577a);
        }

        public int hashCode() {
            return this.f22577a.hashCode();
        }

        public String toString() {
            String str = this.f22577a;
            return "Text(text=" + str + ")";
        }
    }

    /* compiled from: ScheduledRideDetailsComponent.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        HEADER,
        TEXT,
        LIST_ITEM,
        LINK,
        BUTTON,
        SECTION_DIVIDER,
        UNKNOWN
    }

    private ScheduledRideDetailsComponent() {
    }

    public /* synthetic */ ScheduledRideDetailsComponent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
