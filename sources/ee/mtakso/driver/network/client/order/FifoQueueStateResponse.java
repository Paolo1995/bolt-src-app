package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverButton;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueStateResponse.kt */
/* loaded from: classes3.dex */
public final class FifoQueueStateResponse {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22363a;
    @SerializedName("subtitle")

    /* renamed from: b  reason: collision with root package name */
    private final String f22364b;
    @SerializedName("queues")

    /* renamed from: c  reason: collision with root package name */
    private final List<Category> f22365c;
    @SerializedName("controls")

    /* renamed from: d  reason: collision with root package name */
    private final List<DriverButton> f22366d;

    /* compiled from: FifoQueueStateResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Category {
        @SerializedName("category_name")

        /* renamed from: a  reason: collision with root package name */
        private final String f22367a;
        @SerializedName("queue_length_appearance")

        /* renamed from: b  reason: collision with root package name */
        private final FifoQueueTextAppearance f22368b;
        @SerializedName("queue_length_value")

        /* renamed from: c  reason: collision with root package name */
        private final String f22369c;
        @SerializedName("queue_length_unit")

        /* renamed from: d  reason: collision with root package name */
        private final String f22370d;

        public final String a() {
            return this.f22367a;
        }

        public final FifoQueueTextAppearance b() {
            return this.f22368b;
        }

        public final String c() {
            return this.f22370d;
        }

        public final String d() {
            return this.f22369c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Category) {
                Category category = (Category) obj;
                return Intrinsics.a(this.f22367a, category.f22367a) && this.f22368b == category.f22368b && Intrinsics.a(this.f22369c, category.f22369c) && Intrinsics.a(this.f22370d, category.f22370d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f22367a.hashCode() * 31;
            FifoQueueTextAppearance fifoQueueTextAppearance = this.f22368b;
            int hashCode2 = (hashCode + (fifoQueueTextAppearance == null ? 0 : fifoQueueTextAppearance.hashCode())) * 31;
            String str = this.f22369c;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f22370d;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22367a;
            FifoQueueTextAppearance fifoQueueTextAppearance = this.f22368b;
            String str2 = this.f22369c;
            String str3 = this.f22370d;
            return "Category(categoryName=" + str + ", queueLengthAppearance=" + fifoQueueTextAppearance + ", queueLengthValue=" + str2 + ", queueLengthUnit=" + str3 + ")";
        }
    }

    public final List<DriverButton> a() {
        return this.f22366d;
    }

    public final List<Category> b() {
        return this.f22365c;
    }

    public final String c() {
        return this.f22364b;
    }

    public final String d() {
        return this.f22363a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FifoQueueStateResponse) {
            FifoQueueStateResponse fifoQueueStateResponse = (FifoQueueStateResponse) obj;
            return Intrinsics.a(this.f22363a, fifoQueueStateResponse.f22363a) && Intrinsics.a(this.f22364b, fifoQueueStateResponse.f22364b) && Intrinsics.a(this.f22365c, fifoQueueStateResponse.f22365c) && Intrinsics.a(this.f22366d, fifoQueueStateResponse.f22366d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f22363a.hashCode() * 31) + this.f22364b.hashCode()) * 31) + this.f22365c.hashCode()) * 31) + this.f22366d.hashCode();
    }

    public String toString() {
        String str = this.f22363a;
        String str2 = this.f22364b;
        List<Category> list = this.f22365c;
        List<DriverButton> list2 = this.f22366d;
        return "FifoQueueStateResponse(title=" + str + ", subtitle=" + str2 + ", queues=" + list + ", controls=" + list2 + ")";
    }
}
