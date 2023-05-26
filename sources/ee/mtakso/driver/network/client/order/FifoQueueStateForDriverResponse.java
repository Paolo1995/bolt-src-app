package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverImage;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueStateForDriverResponse.kt */
/* loaded from: classes3.dex */
public final class FifoQueueStateForDriverResponse {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22351a;
    @SerializedName("subtitle")

    /* renamed from: b  reason: collision with root package name */
    private final String f22352b;
    @SerializedName("info_image")

    /* renamed from: c  reason: collision with root package name */
    private final DriverImage f22353c;
    @SerializedName("info_text_html")

    /* renamed from: d  reason: collision with root package name */
    private final String f22354d;
    @SerializedName("queues")

    /* renamed from: e  reason: collision with root package name */
    private final List<Category> f22355e;
    @SerializedName("dispatch_area_id")

    /* renamed from: f  reason: collision with root package name */
    private final String f22356f;
    @SerializedName("dispatch_area_state")

    /* renamed from: g  reason: collision with root package name */
    private final FifoQueueDispatchAreaState f22357g;

    /* compiled from: FifoQueueStateForDriverResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Category {
        @SerializedName("category_name")

        /* renamed from: a  reason: collision with root package name */
        private final String f22358a;
        @SerializedName("driver_position_appearance")

        /* renamed from: b  reason: collision with root package name */
        private final FifoQueueTextAppearance f22359b;
        @SerializedName("driver_position_value")

        /* renamed from: c  reason: collision with root package name */
        private final String f22360c;
        @SerializedName("driver_position_unit")

        /* renamed from: d  reason: collision with root package name */
        private final String f22361d;

        public final String a() {
            return this.f22358a;
        }

        public final FifoQueueTextAppearance b() {
            return this.f22359b;
        }

        public final String c() {
            return this.f22361d;
        }

        public final String d() {
            return this.f22360c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Category) {
                Category category = (Category) obj;
                return Intrinsics.a(this.f22358a, category.f22358a) && this.f22359b == category.f22359b && Intrinsics.a(this.f22360c, category.f22360c) && Intrinsics.a(this.f22361d, category.f22361d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f22358a.hashCode() * 31;
            FifoQueueTextAppearance fifoQueueTextAppearance = this.f22359b;
            int hashCode2 = (hashCode + (fifoQueueTextAppearance == null ? 0 : fifoQueueTextAppearance.hashCode())) * 31;
            String str = this.f22360c;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f22361d;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22358a;
            FifoQueueTextAppearance fifoQueueTextAppearance = this.f22359b;
            String str2 = this.f22360c;
            String str3 = this.f22361d;
            return "Category(categoryName=" + str + ", driverPositionAppearance=" + fifoQueueTextAppearance + ", driverPositionValue=" + str2 + ", driverPositionUnit=" + str3 + ")";
        }
    }

    public final String a() {
        return this.f22356f;
    }

    public final FifoQueueDispatchAreaState b() {
        return this.f22357g;
    }

    public final DriverImage c() {
        return this.f22353c;
    }

    public final String d() {
        return this.f22354d;
    }

    public final List<Category> e() {
        return this.f22355e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FifoQueueStateForDriverResponse) {
            FifoQueueStateForDriverResponse fifoQueueStateForDriverResponse = (FifoQueueStateForDriverResponse) obj;
            return Intrinsics.a(this.f22351a, fifoQueueStateForDriverResponse.f22351a) && Intrinsics.a(this.f22352b, fifoQueueStateForDriverResponse.f22352b) && Intrinsics.a(this.f22353c, fifoQueueStateForDriverResponse.f22353c) && Intrinsics.a(this.f22354d, fifoQueueStateForDriverResponse.f22354d) && Intrinsics.a(this.f22355e, fifoQueueStateForDriverResponse.f22355e) && Intrinsics.a(this.f22356f, fifoQueueStateForDriverResponse.f22356f) && this.f22357g == fifoQueueStateForDriverResponse.f22357g;
        }
        return false;
    }

    public final String f() {
        return this.f22352b;
    }

    public final String g() {
        return this.f22351a;
    }

    public int hashCode() {
        return (((((((((((this.f22351a.hashCode() * 31) + this.f22352b.hashCode()) * 31) + this.f22353c.hashCode()) * 31) + this.f22354d.hashCode()) * 31) + this.f22355e.hashCode()) * 31) + this.f22356f.hashCode()) * 31) + this.f22357g.hashCode();
    }

    public String toString() {
        String str = this.f22351a;
        String str2 = this.f22352b;
        DriverImage driverImage = this.f22353c;
        String str3 = this.f22354d;
        List<Category> list = this.f22355e;
        String str4 = this.f22356f;
        FifoQueueDispatchAreaState fifoQueueDispatchAreaState = this.f22357g;
        return "FifoQueueStateForDriverResponse(title=" + str + ", subtitle=" + str2 + ", infoImage=" + driverImage + ", infoTextHtml=" + str3 + ", queues=" + list + ", dispatchAreaId=" + str4 + ", dispatchAreaState=" + fifoQueueDispatchAreaState + ")";
    }
}
