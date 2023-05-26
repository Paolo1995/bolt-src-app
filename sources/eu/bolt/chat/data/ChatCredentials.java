package eu.bolt.chat.data;

import eu.bolt.chat.util.SensitiveString;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatCredentials.kt */
/* loaded from: classes5.dex */
public interface ChatCredentials {
    SensitiveString a();

    /* compiled from: ChatCredentials.kt */
    /* loaded from: classes5.dex */
    public static final class Bearer implements ChatCredentials {

        /* renamed from: a  reason: collision with root package name */
        private final SensitiveString f38931a;

        public Bearer(SensitiveString secret) {
            Intrinsics.f(secret, "secret");
            this.f38931a = secret;
        }

        @Override // eu.bolt.chat.data.ChatCredentials
        public SensitiveString a() {
            return this.f38931a;
        }

        public final SensitiveString b() {
            return a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Bearer) && Intrinsics.a(a(), ((Bearer) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            return "ChatCredentials(token='" + ((Object) a()) + "')";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Bearer(String token) {
            this(new SensitiveString(token));
            Intrinsics.f(token, "token");
        }
    }

    /* compiled from: ChatCredentials.kt */
    /* loaded from: classes5.dex */
    public static final class Basic implements ChatCredentials {

        /* renamed from: a  reason: collision with root package name */
        private final String f38929a;

        /* renamed from: b  reason: collision with root package name */
        private final SensitiveString f38930b;

        public Basic(String username, SensitiveString secret) {
            Intrinsics.f(username, "username");
            Intrinsics.f(secret, "secret");
            this.f38929a = username;
            this.f38930b = secret;
        }

        @Override // eu.bolt.chat.data.ChatCredentials
        public SensitiveString a() {
            return this.f38930b;
        }

        public final SensitiveString b() {
            return a();
        }

        public final String c() {
            return this.f38929a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Basic) {
                Basic basic = (Basic) obj;
                return Intrinsics.a(this.f38929a, basic.f38929a) && Intrinsics.a(a(), basic.a());
            }
            return false;
        }

        public int hashCode() {
            return (this.f38929a.hashCode() * 31) + a().hashCode();
        }

        public String toString() {
            return "ChatCredentials(username='" + this.f38929a + "', password='" + ((Object) a()) + "')";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Basic(String username, String password) {
            this(username, new SensitiveString(password));
            Intrinsics.f(username, "username");
            Intrinsics.f(password, "password");
        }
    }
}
