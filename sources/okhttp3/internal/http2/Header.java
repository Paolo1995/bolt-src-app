package okhttp3.internal.http2;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* compiled from: Header.kt */
/* loaded from: classes5.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    /* compiled from: Header.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ByteString.Companion companion = ByteString.f52591i;
        PSEUDO_PREFIX = companion.d(":");
        RESPONSE_STATUS = companion.d(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = companion.d(TARGET_METHOD_UTF8);
        TARGET_PATH = companion.d(TARGET_PATH_UTF8);
        TARGET_SCHEME = companion.d(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = companion.d(TARGET_AUTHORITY_UTF8);
    }

    public Header(ByteString name, ByteString value) {
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.z() + 32 + value.z();
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            byteString = header.name;
        }
        if ((i8 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    public final ByteString component1() {
        return this.name;
    }

    public final ByteString component2() {
        return this.value;
    }

    public final Header copy(ByteString name, ByteString value) {
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
        return new Header(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Header) {
            Header header = (Header) obj;
            return Intrinsics.a(this.name, header.name) && Intrinsics.a(this.value, header.value);
        }
        return false;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.D() + ": " + this.value.D();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Header(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            okio.ByteString$Companion r0 = okio.ByteString.f52591i
            okio.ByteString r2 = r0.d(r2)
            okio.ByteString r3 = r0.d(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Header.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString name, String value) {
        this(name, ByteString.f52591i.d(value));
        Intrinsics.f(name, "name");
        Intrinsics.f(value, "value");
    }
}
