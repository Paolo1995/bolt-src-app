package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderCompletionReason.kt */
/* loaded from: classes3.dex */
public final class OrderCompletionReason {
    @SerializedName("state")

    /* renamed from: a  reason: collision with root package name */
    private final OrderState f22421a;
    @SerializedName("display_message")

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMessage f22422b;

    /* compiled from: OrderCompletionReason.kt */
    /* loaded from: classes3.dex */
    public static final class DisplayMessage {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f22423a;
        @SerializedName("description")

        /* renamed from: b  reason: collision with root package name */
        private final String f22424b;

        public final String a() {
            return this.f22424b;
        }

        public final String b() {
            return this.f22423a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DisplayMessage) {
                DisplayMessage displayMessage = (DisplayMessage) obj;
                return Intrinsics.a(this.f22423a, displayMessage.f22423a) && Intrinsics.a(this.f22424b, displayMessage.f22424b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f22423a.hashCode() * 31;
            String str = this.f22424b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f22423a;
            String str2 = this.f22424b;
            return "DisplayMessage(title=" + str + ", description=" + str2 + ")";
        }
    }

    public final DisplayMessage a() {
        return this.f22422b;
    }

    public final OrderState b() {
        return this.f22421a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderCompletionReason) {
            OrderCompletionReason orderCompletionReason = (OrderCompletionReason) obj;
            return this.f22421a == orderCompletionReason.f22421a && Intrinsics.a(this.f22422b, orderCompletionReason.f22422b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22421a.hashCode() * 31;
        DisplayMessage displayMessage = this.f22422b;
        return hashCode + (displayMessage == null ? 0 : displayMessage.hashCode());
    }

    public String toString() {
        OrderState orderState = this.f22421a;
        DisplayMessage displayMessage = this.f22422b;
        return "OrderCompletionReason(state=" + orderState + ", displayMessage=" + displayMessage + ")";
    }
}
