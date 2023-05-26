package ee.mtakso.driver.network.client.boltclub.model;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntegrationData.kt */
/* loaded from: classes3.dex */
public final class IntegrationData {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final Icon.IntegrationType f21553a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21554b;
    @SerializedName("action_url")

    /* renamed from: c  reason: collision with root package name */
    private final String f21555c;
    @SerializedName("icon")

    /* renamed from: d  reason: collision with root package name */
    private final Icon f21556d;
    @SerializedName("action_type")

    /* renamed from: e  reason: collision with root package name */
    private final String f21557e;

    /* compiled from: IntegrationData.kt */
    /* loaded from: classes3.dex */
    public static final class Icon {
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final IntegrationType f21558a;
        @SerializedName(ImagesContract.URL)

        /* renamed from: b  reason: collision with root package name */
        private final String f21559b;

        /* compiled from: IntegrationData.kt */
        /* loaded from: classes3.dex */
        public enum IntegrationType {
            BUTTON,
            ICON
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Icon) {
                Icon icon = (Icon) obj;
                return this.f21558a == icon.f21558a && Intrinsics.a(this.f21559b, icon.f21559b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f21558a.hashCode() * 31) + this.f21559b.hashCode();
        }

        public String toString() {
            IntegrationType integrationType = this.f21558a;
            String str = this.f21559b;
            return "Icon(type=" + integrationType + ", iconUrl=" + str + ")";
        }
    }

    public final String a() {
        return this.f21557e;
    }

    public final String b() {
        return this.f21555c;
    }

    public final String c() {
        return this.f21554b;
    }

    public final Icon.IntegrationType d() {
        return this.f21553a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntegrationData) {
            IntegrationData integrationData = (IntegrationData) obj;
            return this.f21553a == integrationData.f21553a && Intrinsics.a(this.f21554b, integrationData.f21554b) && Intrinsics.a(this.f21555c, integrationData.f21555c) && Intrinsics.a(this.f21556d, integrationData.f21556d) && Intrinsics.a(this.f21557e, integrationData.f21557e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f21553a.hashCode() * 31) + this.f21554b.hashCode()) * 31) + this.f21555c.hashCode()) * 31;
        Icon icon = this.f21556d;
        int hashCode2 = (hashCode + (icon == null ? 0 : icon.hashCode())) * 31;
        String str = this.f21557e;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        Icon.IntegrationType integrationType = this.f21553a;
        String str = this.f21554b;
        String str2 = this.f21555c;
        Icon icon = this.f21556d;
        String str3 = this.f21557e;
        return "IntegrationData(type=" + integrationType + ", title=" + str + ", action_url=" + str2 + ", icon=" + icon + ", action_type=" + str3 + ")";
    }
}
