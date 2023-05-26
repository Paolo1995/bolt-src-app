package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public abstract class ContactOption {

    /* compiled from: AvailableContactOptions.kt */
    /* loaded from: classes3.dex */
    public static final class Chat extends ContactOption {
        @SerializedName("recipient_type")

        /* renamed from: a  reason: collision with root package name */
        private final RecipientType f21783a;
        @SerializedName("contact_details")

        /* renamed from: b  reason: collision with root package name */
        private final ChatData f21784b;

        public final ChatData a() {
            return this.f21784b;
        }

        public RecipientType b() {
            return this.f21783a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Chat) {
                Chat chat = (Chat) obj;
                return b() == chat.b() && Intrinsics.a(this.f21784b, chat.f21784b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = b().hashCode() * 31;
            ChatData chatData = this.f21784b;
            return hashCode + (chatData == null ? 0 : chatData.hashCode());
        }

        public String toString() {
            RecipientType b8 = b();
            ChatData chatData = this.f21784b;
            return "Chat(recipientType=" + b8 + ", chatData=" + chatData + ")";
        }
    }

    /* compiled from: AvailableContactOptions.kt */
    /* loaded from: classes3.dex */
    public static final class PhoneCall extends ContactOption {
        @SerializedName("recipient_type")

        /* renamed from: a  reason: collision with root package name */
        private final RecipientType f21785a;

        public RecipientType a() {
            return this.f21785a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PhoneCall) && a() == ((PhoneCall) obj).a();
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            RecipientType a8 = a();
            return "PhoneCall(recipientType=" + a8 + ")";
        }
    }

    /* compiled from: AvailableContactOptions.kt */
    /* loaded from: classes3.dex */
    public static final class PhoneCallSuport extends ContactOption {
        @SerializedName("recipient_type")

        /* renamed from: a  reason: collision with root package name */
        private final RecipientType f21786a;

        public RecipientType a() {
            return this.f21786a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PhoneCallSuport) && a() == ((PhoneCallSuport) obj).a();
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            RecipientType a8 = a();
            return "PhoneCallSuport(recipientType=" + a8 + ")";
        }
    }

    /* compiled from: AvailableContactOptions.kt */
    /* loaded from: classes3.dex */
    public static final class SimpleMessage extends ContactOption {
        @SerializedName("recipient_type")

        /* renamed from: a  reason: collision with root package name */
        private final RecipientType f21787a;

        public RecipientType a() {
            return this.f21787a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SimpleMessage) && a() == ((SimpleMessage) obj).a();
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            RecipientType a8 = a();
            return "SimpleMessage(recipientType=" + a8 + ")";
        }
    }

    /* compiled from: AvailableContactOptions.kt */
    /* loaded from: classes3.dex */
    public static final class Voip extends ContactOption {
        @SerializedName("recipient_type")

        /* renamed from: a  reason: collision with root package name */
        private final RecipientType f21788a;

        public RecipientType a() {
            return this.f21788a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Voip) && a() == ((Voip) obj).a();
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            RecipientType a8 = a();
            return "Voip(recipientType=" + a8 + ")";
        }
    }

    private ContactOption() {
    }
}
