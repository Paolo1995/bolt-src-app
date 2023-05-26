package eu.bolt.chat.network.endpoint;

import io.ktor.http.HttpStatusCode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EndpointError.kt */
/* loaded from: classes5.dex */
public interface EndpointError {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f39364a = Companion.f39365a;

    /* compiled from: EndpointError.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f39365a = new Companion();

        private Companion() {
        }

        public final EndpointError a(int i8, String str) {
            if (i8 != -1) {
                if (i8 != 400) {
                    return new Unknown(i8, str);
                }
                return new NotExists(str);
            }
            return new InvalidResponse(str);
        }

        public final EndpointError b(HttpStatusCode code) {
            Intrinsics.f(code, "code");
            return new HttpError(code.b0(), code.a0());
        }
    }

    /* compiled from: EndpointError.kt */
    /* loaded from: classes5.dex */
    public static final class HttpError implements EndpointError {

        /* renamed from: b  reason: collision with root package name */
        private final int f39366b;

        /* renamed from: c  reason: collision with root package name */
        private final String f39367c;

        public HttpError(int i8, String str) {
            this.f39366b = i8;
            this.f39367c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HttpError) {
                HttpError httpError = (HttpError) obj;
                return getCode() == httpError.getCode() && Intrinsics.a(getMessage(), httpError.getMessage());
            }
            return false;
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public int getCode() {
            return this.f39366b;
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public String getMessage() {
            return this.f39367c;
        }

        public int hashCode() {
            return (getCode() * 31) + (getMessage() == null ? 0 : getMessage().hashCode());
        }

        public String toString() {
            return "HttpError(code=" + getCode() + ", message=" + getMessage() + ')';
        }
    }

    /* compiled from: EndpointError.kt */
    /* loaded from: classes5.dex */
    public static final class InvalidResponse implements EndpointError {

        /* renamed from: b  reason: collision with root package name */
        private final String f39368b;

        /* renamed from: c  reason: collision with root package name */
        private final int f39369c = -1;

        public InvalidResponse(String str) {
            this.f39368b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidResponse) && Intrinsics.a(getMessage(), ((InvalidResponse) obj).getMessage());
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public int getCode() {
            return this.f39369c;
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public String getMessage() {
            return this.f39368b;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        public String toString() {
            return "InvalidResponse(message=" + getMessage() + ')';
        }
    }

    /* compiled from: EndpointError.kt */
    /* loaded from: classes5.dex */
    public static final class NotExists implements EndpointError {

        /* renamed from: b  reason: collision with root package name */
        private final String f39370b;

        /* renamed from: c  reason: collision with root package name */
        private final int f39371c = 400;

        public NotExists(String str) {
            this.f39370b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotExists) && Intrinsics.a(getMessage(), ((NotExists) obj).getMessage());
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public int getCode() {
            return this.f39371c;
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public String getMessage() {
            return this.f39370b;
        }

        public int hashCode() {
            if (getMessage() == null) {
                return 0;
            }
            return getMessage().hashCode();
        }

        public String toString() {
            return "NotExists(message=" + getMessage() + ')';
        }
    }

    /* compiled from: EndpointError.kt */
    /* loaded from: classes5.dex */
    public static final class Unknown implements EndpointError {

        /* renamed from: b  reason: collision with root package name */
        private final int f39372b;

        /* renamed from: c  reason: collision with root package name */
        private final String f39373c;

        public Unknown(int i8, String str) {
            this.f39372b = i8;
            this.f39373c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unknown) {
                Unknown unknown = (Unknown) obj;
                return getCode() == unknown.getCode() && Intrinsics.a(getMessage(), unknown.getMessage());
            }
            return false;
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public int getCode() {
            return this.f39372b;
        }

        @Override // eu.bolt.chat.network.endpoint.EndpointError
        public String getMessage() {
            return this.f39373c;
        }

        public int hashCode() {
            return (getCode() * 31) + (getMessage() == null ? 0 : getMessage().hashCode());
        }

        public String toString() {
            return "Unknown(code=" + getCode() + ", message=" + getMessage() + ')';
        }
    }

    int getCode();

    String getMessage();
}
