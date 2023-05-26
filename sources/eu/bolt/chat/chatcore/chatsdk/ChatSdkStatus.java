package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.client.ChatClientManager;
import eu.bolt.chat.client.ChatNotificationManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSdkInitializer.kt */
/* loaded from: classes5.dex */
public interface ChatSdkStatus {

    /* compiled from: ChatSdkInitializer.kt */
    /* loaded from: classes5.dex */
    public static final class Initialized implements ChatSdkStatus {

        /* renamed from: a  reason: collision with root package name */
        private final ChatClientManager f38058a;

        /* renamed from: b  reason: collision with root package name */
        private final ChatNotificationManager f38059b;

        public Initialized(ChatClientManager chatClientManager, ChatNotificationManager notificationManager) {
            Intrinsics.f(chatClientManager, "chatClientManager");
            Intrinsics.f(notificationManager, "notificationManager");
            this.f38058a = chatClientManager;
            this.f38059b = notificationManager;
        }

        public final ChatClientManager a() {
            return this.f38058a;
        }

        public final ChatNotificationManager b() {
            return this.f38059b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initialized) {
                Initialized initialized = (Initialized) obj;
                return Intrinsics.a(this.f38058a, initialized.f38058a) && Intrinsics.a(this.f38059b, initialized.f38059b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f38058a.hashCode() * 31) + this.f38059b.hashCode();
        }

        public String toString() {
            return "Initialized(chatClientManager=" + this.f38058a + ", notificationManager=" + this.f38059b + ')';
        }
    }

    /* compiled from: ChatSdkInitializer.kt */
    /* loaded from: classes5.dex */
    public static final class Uninitialized implements ChatSdkStatus {

        /* renamed from: a  reason: collision with root package name */
        public static final Uninitialized f38060a = new Uninitialized();

        private Uninitialized() {
        }
    }
}
