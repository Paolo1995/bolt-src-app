package ee.mtakso.driver.platform.store_integrity;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoreIntegrityVerificationResult.kt */
/* loaded from: classes3.dex */
public interface StoreIntegrityVerificationResult {

    /* compiled from: StoreIntegrityVerificationResult.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends Throwable implements StoreIntegrityVerificationResult {

        /* renamed from: f  reason: collision with root package name */
        private final String f23349f;

        /* renamed from: g  reason: collision with root package name */
        private final String f23350g;

        /* renamed from: h  reason: collision with root package name */
        private final ErrorType f23351h;

        public Error(String message, String str, ErrorType errorType) {
            Intrinsics.f(message, "message");
            Intrinsics.f(errorType, "errorType");
            this.f23349f = message;
            this.f23350g = str;
            this.f23351h = errorType;
        }

        @Override // ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult
        public String a() {
            return this.f23350g;
        }

        public final ErrorType b() {
            return this.f23351h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Error) {
                Error error = (Error) obj;
                return Intrinsics.a(getMessage(), error.getMessage()) && Intrinsics.a(a(), error.a()) && this.f23351h == error.f23351h;
            }
            return false;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f23349f;
        }

        public int hashCode() {
            return (((getMessage().hashCode() * 31) + (a() == null ? 0 : a().hashCode())) * 31) + this.f23351h.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            String message = getMessage();
            String a8 = a();
            ErrorType errorType = this.f23351h;
            return "Error(message=" + message + ", versionCode=" + a8 + ", errorType=" + errorType + ")";
        }
    }

    /* compiled from: StoreIntegrityVerificationResult.kt */
    /* loaded from: classes3.dex */
    public enum ErrorType {
        PLAY_STORE_UPDATE_REQUIRED,
        PLAY_SERVICE_UPDATE_REQUIRED,
        RETRY_OR_BACKEND_HANDLING_REQUIRED
    }

    /* compiled from: StoreIntegrityVerificationResult.kt */
    /* loaded from: classes3.dex */
    public static final class Success implements StoreIntegrityVerificationResult {

        /* renamed from: f  reason: collision with root package name */
        private final String f23356f;

        /* renamed from: g  reason: collision with root package name */
        private final String f23357g;

        public Success(String str, String str2) {
            this.f23356f = str;
            this.f23357g = str2;
        }

        @Override // ee.mtakso.driver.platform.store_integrity.StoreIntegrityVerificationResult
        public String a() {
            return this.f23356f;
        }

        public final String b() {
            return this.f23357g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.a(a(), success.a()) && Intrinsics.a(this.f23357g, success.f23357g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = (a() == null ? 0 : a().hashCode()) * 31;
            String str = this.f23357g;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            String str = this.f23357g;
            return "Success(versionCode=" + a8 + ", token=" + str + ")";
        }
    }

    String a();
}
