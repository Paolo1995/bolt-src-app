package ee.mtakso.driver.ui.screens.settings.pricing;

import ee.mtakso.driver.network.client.driver.DriverPricingConfiguration;
import ee.mtakso.driver.network.client.settings.DriverPricingSetup;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.uikit.utils.Text;
import java.math.BigDecimal;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingSettings.kt */
/* loaded from: classes5.dex */
public final class PricingSettings {

    /* renamed from: a  reason: collision with root package name */
    private final Text f33247a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DriverPricingConfiguration.Option> f33248b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverPricingSetup f33249c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverPricingState f33250d;

    /* renamed from: e  reason: collision with root package name */
    private final int f33251e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Rate> f33252f;

    /* compiled from: PricingSettings.kt */
    /* loaded from: classes5.dex */
    public static final class Rate {

        /* renamed from: a  reason: collision with root package name */
        private final BigDecimal f33253a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33254b;

        public Rate(BigDecimal value, String str) {
            Intrinsics.f(value, "value");
            this.f33253a = value;
            this.f33254b = str;
        }

        public final String a() {
            return this.f33254b;
        }

        public final BigDecimal b() {
            return this.f33253a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Rate) {
                Rate rate = (Rate) obj;
                return Intrinsics.a(this.f33253a, rate.f33253a) && Intrinsics.a(this.f33254b, rate.f33254b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f33253a.hashCode() * 31;
            String str = this.f33254b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            BigDecimal bigDecimal = this.f33253a;
            String str = this.f33254b;
            return "Rate(value=" + bigDecimal + ", hint=" + str + ")";
        }
    }

    public PricingSettings(Text text, List<DriverPricingConfiguration.Option> options, DriverPricingSetup driverPricingSetup, DriverPricingState driverPricingState, int i8, List<Rate> rates) {
        Intrinsics.f(options, "options");
        Intrinsics.f(rates, "rates");
        this.f33247a = text;
        this.f33248b = options;
        this.f33249c = driverPricingSetup;
        this.f33250d = driverPricingState;
        this.f33251e = i8;
        this.f33252f = rates;
    }

    public static /* synthetic */ PricingSettings b(PricingSettings pricingSettings, Text text, List list, DriverPricingSetup driverPricingSetup, DriverPricingState driverPricingState, int i8, List list2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            text = pricingSettings.f33247a;
        }
        List<DriverPricingConfiguration.Option> list3 = list;
        if ((i9 & 2) != 0) {
            list3 = pricingSettings.f33248b;
        }
        List list4 = list3;
        if ((i9 & 4) != 0) {
            driverPricingSetup = pricingSettings.f33249c;
        }
        DriverPricingSetup driverPricingSetup2 = driverPricingSetup;
        if ((i9 & 8) != 0) {
            driverPricingState = pricingSettings.f33250d;
        }
        DriverPricingState driverPricingState2 = driverPricingState;
        if ((i9 & 16) != 0) {
            i8 = pricingSettings.f33251e;
        }
        int i10 = i8;
        List<Rate> list5 = list2;
        if ((i9 & 32) != 0) {
            list5 = pricingSettings.f33252f;
        }
        return pricingSettings.a(text, list4, driverPricingSetup2, driverPricingState2, i10, list5);
    }

    public final PricingSettings a(Text text, List<DriverPricingConfiguration.Option> options, DriverPricingSetup driverPricingSetup, DriverPricingState driverPricingState, int i8, List<Rate> rates) {
        Intrinsics.f(options, "options");
        Intrinsics.f(rates, "rates");
        return new PricingSettings(text, options, driverPricingSetup, driverPricingState, i8, rates);
    }

    public final DriverPricingSetup c() {
        return this.f33249c;
    }

    public final List<DriverPricingConfiguration.Option> d() {
        return this.f33248b;
    }

    public final List<Rate> e() {
        return this.f33252f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PricingSettings) {
            PricingSettings pricingSettings = (PricingSettings) obj;
            return Intrinsics.a(this.f33247a, pricingSettings.f33247a) && Intrinsics.a(this.f33248b, pricingSettings.f33248b) && Intrinsics.a(this.f33249c, pricingSettings.f33249c) && this.f33250d == pricingSettings.f33250d && this.f33251e == pricingSettings.f33251e && Intrinsics.a(this.f33252f, pricingSettings.f33252f);
        }
        return false;
    }

    public final int f() {
        return this.f33251e;
    }

    public final DriverPricingState g() {
        return this.f33250d;
    }

    public final Text h() {
        return this.f33247a;
    }

    public int hashCode() {
        Text text = this.f33247a;
        int hashCode = (((text == null ? 0 : text.hashCode()) * 31) + this.f33248b.hashCode()) * 31;
        DriverPricingSetup driverPricingSetup = this.f33249c;
        int hashCode2 = (hashCode + (driverPricingSetup == null ? 0 : driverPricingSetup.hashCode())) * 31;
        DriverPricingState driverPricingState = this.f33250d;
        return ((((hashCode2 + (driverPricingState != null ? driverPricingState.hashCode() : 0)) * 31) + this.f33251e) * 31) + this.f33252f.hashCode();
    }

    public String toString() {
        Text text = this.f33247a;
        List<DriverPricingConfiguration.Option> list = this.f33248b;
        DriverPricingSetup driverPricingSetup = this.f33249c;
        DriverPricingState driverPricingState = this.f33250d;
        int i8 = this.f33251e;
        List<Rate> list2 = this.f33252f;
        return "PricingSettings(title=" + text + ", options=" + list + ", driverPricingSetup=" + driverPricingSetup + ", selectedState=" + driverPricingState + ", selectedRatePosition=" + i8 + ", rates=" + list2 + ")";
    }
}
