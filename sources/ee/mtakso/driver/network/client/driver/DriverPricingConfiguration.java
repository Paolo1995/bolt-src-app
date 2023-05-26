package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.settings.DriverPricingSetup;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPricingConfiguration.kt */
/* loaded from: classes3.dex */
public final class DriverPricingConfiguration {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21938a;
    @SerializedName("options")

    /* renamed from: b  reason: collision with root package name */
    private final List<Option> f21939b;
    @SerializedName("setup")

    /* renamed from: c  reason: collision with root package name */
    private final DriverPricingSetup f21940c;

    /* compiled from: DriverPricingConfiguration.kt */
    /* loaded from: classes3.dex */
    public static final class Dialog {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f21941a;
        @SerializedName("message")

        /* renamed from: b  reason: collision with root package name */
        private final String f21942b;

        public final String a() {
            return this.f21942b;
        }

        public final String b() {
            return this.f21941a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dialog) {
                Dialog dialog = (Dialog) obj;
                return Intrinsics.a(this.f21941a, dialog.f21941a) && Intrinsics.a(this.f21942b, dialog.f21942b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f21941a.hashCode() * 31;
            String str = this.f21942b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f21941a;
            String str2 = this.f21942b;
            return "Dialog(title=" + str + ", message=" + str2 + ")";
        }
    }

    /* compiled from: DriverPricingConfiguration.kt */
    /* loaded from: classes3.dex */
    public static final class InfoBlock {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f21943a;
        @SerializedName("subtitle")

        /* renamed from: b  reason: collision with root package name */
        private final String f21944b;
        @SerializedName("show_icon")

        /* renamed from: c  reason: collision with root package name */
        private final boolean f21945c;
        @SerializedName("appearance")

        /* renamed from: d  reason: collision with root package name */
        private final InfoBlockAppearance f21946d;

        public final InfoBlockAppearance a() {
            return this.f21946d;
        }

        public final boolean b() {
            return this.f21945c;
        }

        public final String c() {
            return this.f21944b;
        }

        public final String d() {
            return this.f21943a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InfoBlock) {
                InfoBlock infoBlock = (InfoBlock) obj;
                return Intrinsics.a(this.f21943a, infoBlock.f21943a) && Intrinsics.a(this.f21944b, infoBlock.f21944b) && this.f21945c == infoBlock.f21945c && this.f21946d == infoBlock.f21946d;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.f21943a;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.f21944b.hashCode()) * 31;
            boolean z7 = this.f21945c;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((hashCode + i8) * 31) + this.f21946d.hashCode();
        }

        public String toString() {
            String str = this.f21943a;
            String str2 = this.f21944b;
            boolean z7 = this.f21945c;
            InfoBlockAppearance infoBlockAppearance = this.f21946d;
            return "InfoBlock(title=" + str + ", subtitle=" + str2 + ", showIcon=" + z7 + ", appearance=" + infoBlockAppearance + ")";
        }
    }

    /* compiled from: DriverPricingConfiguration.kt */
    /* loaded from: classes3.dex */
    public enum InfoBlockAppearance {
        WARNING,
        PRIMARY,
        CRITICAL,
        NEUTRAL
    }

    /* compiled from: DriverPricingConfiguration.kt */
    /* loaded from: classes3.dex */
    public static final class ListItem {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f21947a;
        @SerializedName("subtitle")

        /* renamed from: b  reason: collision with root package name */
        private final String f21948b;

        public final String a() {
            return this.f21948b;
        }

        public final String b() {
            return this.f21947a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListItem) {
                ListItem listItem = (ListItem) obj;
                return Intrinsics.a(this.f21947a, listItem.f21947a) && Intrinsics.a(this.f21948b, listItem.f21948b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f21947a.hashCode() * 31;
            String str = this.f21948b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f21947a;
            String str2 = this.f21948b;
            return "ListItem(title=" + str + ", subtitle=" + str2 + ")";
        }
    }

    /* compiled from: DriverPricingConfiguration.kt */
    /* loaded from: classes3.dex */
    public static final class Option {
        @SerializedName("item")

        /* renamed from: a  reason: collision with root package name */
        private final ListItem f21949a;
        @SerializedName("info_block")

        /* renamed from: b  reason: collision with root package name */
        private final InfoBlock f21950b;
        @SerializedName("type")

        /* renamed from: c  reason: collision with root package name */
        private final Type f21951c;
        @SerializedName("confirm_dialog")

        /* renamed from: d  reason: collision with root package name */
        private final Dialog f21952d;

        /* compiled from: DriverPricingConfiguration.kt */
        /* loaded from: classes3.dex */
        public enum Type {
            STANDARD_PRICING(DriverPricingState.STANDARD_PRICING),
            CUSTOM_PRICING(DriverPricingState.CUSTOM_PRICING);
            
            private final DriverPricingState state;

            Type(DriverPricingState driverPricingState) {
                this.state = driverPricingState;
            }

            public final DriverPricingState getState() {
                return this.state;
            }
        }

        public final Dialog a() {
            return this.f21952d;
        }

        public final InfoBlock b() {
            return this.f21950b;
        }

        public final ListItem c() {
            return this.f21949a;
        }

        public final Type d() {
            return this.f21951c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Option) {
                Option option = (Option) obj;
                return Intrinsics.a(this.f21949a, option.f21949a) && Intrinsics.a(this.f21950b, option.f21950b) && this.f21951c == option.f21951c && Intrinsics.a(this.f21952d, option.f21952d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f21949a.hashCode() * 31;
            InfoBlock infoBlock = this.f21950b;
            return ((((hashCode + (infoBlock == null ? 0 : infoBlock.hashCode())) * 31) + this.f21951c.hashCode()) * 31) + this.f21952d.hashCode();
        }

        public String toString() {
            ListItem listItem = this.f21949a;
            InfoBlock infoBlock = this.f21950b;
            Type type = this.f21951c;
            Dialog dialog = this.f21952d;
            return "Option(item=" + listItem + ", infoBlock=" + infoBlock + ", type=" + type + ", confirmDialog=" + dialog + ")";
        }
    }

    public final List<Option> a() {
        return this.f21939b;
    }

    public final DriverPricingSetup b() {
        return this.f21940c;
    }

    public final String c() {
        return this.f21938a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverPricingConfiguration) {
            DriverPricingConfiguration driverPricingConfiguration = (DriverPricingConfiguration) obj;
            return Intrinsics.a(this.f21938a, driverPricingConfiguration.f21938a) && Intrinsics.a(this.f21939b, driverPricingConfiguration.f21939b) && Intrinsics.a(this.f21940c, driverPricingConfiguration.f21940c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21938a.hashCode() * 31) + this.f21939b.hashCode()) * 31) + this.f21940c.hashCode();
    }

    public String toString() {
        String str = this.f21938a;
        List<Option> list = this.f21939b;
        DriverPricingSetup driverPricingSetup = this.f21940c;
        return "DriverPricingConfiguration(title=" + str + ", options=" + list + ", setup=" + driverPricingSetup + ")";
    }
}
