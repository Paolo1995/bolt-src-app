package ee.mtakso.driver.service.integration.clevertap;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapInboxMessagePreview.kt */
/* loaded from: classes3.dex */
public final class CleverTapInboxMessagePreview {

    /* renamed from: a  reason: collision with root package name */
    private final String f24528a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24529b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24530c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24531d;

    /* renamed from: e  reason: collision with root package name */
    private final long f24532e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24533f;

    public CleverTapInboxMessagePreview(String messageId, String str, String str2, String str3, long j8, boolean z7) {
        Intrinsics.f(messageId, "messageId");
        this.f24528a = messageId;
        this.f24529b = str;
        this.f24530c = str2;
        this.f24531d = str3;
        this.f24532e = j8;
        this.f24533f = z7;
    }

    public final String a() {
        return this.f24530c;
    }

    public final String b() {
        return this.f24529b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CleverTapInboxMessagePreview) {
            CleverTapInboxMessagePreview cleverTapInboxMessagePreview = (CleverTapInboxMessagePreview) obj;
            return Intrinsics.a(this.f24528a, cleverTapInboxMessagePreview.f24528a) && Intrinsics.a(this.f24529b, cleverTapInboxMessagePreview.f24529b) && Intrinsics.a(this.f24530c, cleverTapInboxMessagePreview.f24530c) && Intrinsics.a(this.f24531d, cleverTapInboxMessagePreview.f24531d) && this.f24532e == cleverTapInboxMessagePreview.f24532e && this.f24533f == cleverTapInboxMessagePreview.f24533f;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f24528a.hashCode() * 31;
        String str = this.f24529b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f24530c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f24531d;
        int hashCode4 = (((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + i0.a.a(this.f24532e)) * 31;
        boolean z7 = this.f24533f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode4 + i8;
    }

    public String toString() {
        String str = this.f24528a;
        String str2 = this.f24529b;
        String str3 = this.f24530c;
        String str4 = this.f24531d;
        long j8 = this.f24532e;
        boolean z7 = this.f24533f;
        return "CleverTapInboxMessagePreview(messageId=" + str + ", title=" + str2 + ", message=" + str3 + ", imageUrl=" + str4 + ", timestamp=" + j8 + ", isRead=" + z7 + ")";
    }
}
