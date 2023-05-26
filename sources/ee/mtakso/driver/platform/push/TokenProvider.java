package ee.mtakso.driver.platform.push;

import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenProvider.kt */
/* loaded from: classes3.dex */
public interface TokenProvider {

    /* compiled from: TokenProvider.kt */
    /* loaded from: classes3.dex */
    public static final class PushTokenData {

        /* renamed from: a  reason: collision with root package name */
        private final String f23347a;

        /* renamed from: b  reason: collision with root package name */
        private final String f23348b;

        public PushTokenData(String str, String token) {
            Intrinsics.f(token, "token");
            this.f23347a = str;
            this.f23348b = token;
        }

        public final String a() {
            return this.f23347a;
        }

        public final String b() {
            return this.f23348b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PushTokenData) {
                PushTokenData pushTokenData = (PushTokenData) obj;
                return Intrinsics.a(this.f23347a, pushTokenData.f23347a) && Intrinsics.a(this.f23348b, pushTokenData.f23348b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f23347a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f23348b.hashCode();
        }

        public String toString() {
            String str = this.f23347a;
            String str2 = this.f23348b;
            return "PushTokenData(id=" + str + ", token=" + str2 + ")";
        }
    }

    Single<PushTokenData> a();

    Single<String> b();
}
