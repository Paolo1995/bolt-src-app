package ee.mtakso.driver.service.voip.extractor;

import ee.mtakso.driver.network.client.contact.VoipConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipInfoExtractor.kt */
/* loaded from: classes3.dex */
public interface VoipInfoExtractor {

    /* compiled from: VoipInfoExtractor.kt */
    /* loaded from: classes3.dex */
    public static final class Info {

        /* renamed from: a  reason: collision with root package name */
        private final String f26141a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26142b;

        /* renamed from: c  reason: collision with root package name */
        private final String f26143c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26144d;

        public Info(String userId, String applicationKey, String token, String str) {
            Intrinsics.f(userId, "userId");
            Intrinsics.f(applicationKey, "applicationKey");
            Intrinsics.f(token, "token");
            this.f26141a = userId;
            this.f26142b = applicationKey;
            this.f26143c = token;
            this.f26144d = str;
        }

        public final String a() {
            return this.f26142b;
        }

        public final String b() {
            return this.f26143c;
        }

        public final String c() {
            return this.f26141a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Info) {
                Info info = (Info) obj;
                return Intrinsics.a(this.f26141a, info.f26141a) && Intrinsics.a(this.f26142b, info.f26142b) && Intrinsics.a(this.f26143c, info.f26143c) && Intrinsics.a(this.f26144d, info.f26144d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f26141a.hashCode() * 31) + this.f26142b.hashCode()) * 31) + this.f26143c.hashCode()) * 31;
            String str = this.f26144d;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f26141a;
            String str2 = this.f26142b;
            String str3 = this.f26143c;
            String str4 = this.f26144d;
            return "Info(userId=" + str + ", applicationKey=" + str2 + ", token=" + str3 + ", extraData=" + str4 + ")";
        }
    }

    Info a(VoipConfiguration voipConfiguration);
}
