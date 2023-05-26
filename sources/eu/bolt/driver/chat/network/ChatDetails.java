package eu.bolt.driver.chat.network;

import com.google.gson.annotations.SerializedName;
import eu.bolt.chat.chatcore.network.model.OrderHandleNetworkModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDetails.kt */
/* loaded from: classes5.dex */
public final class ChatDetails {
    @SerializedName("description")

    /* renamed from: a  reason: collision with root package name */
    private final String f40431a;
    @SerializedName("start_date")

    /* renamed from: b  reason: collision with root package name */
    private final long f40432b;
    @SerializedName("thumbnail_url")

    /* renamed from: c  reason: collision with root package name */
    private final String f40433c;
    @SerializedName("title")

    /* renamed from: d  reason: collision with root package name */
    private final String f40434d;
    @SerializedName("order_handle")

    /* renamed from: e  reason: collision with root package name */
    private final OrderHandleNetworkModel f40435e;

    public final String a() {
        return this.f40431a;
    }

    public final OrderHandleNetworkModel b() {
        return this.f40435e;
    }

    public final long c() {
        return this.f40432b;
    }

    public final String d() {
        return this.f40433c;
    }

    public final String e() {
        return this.f40434d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatDetails) {
            ChatDetails chatDetails = (ChatDetails) obj;
            return Intrinsics.a(this.f40431a, chatDetails.f40431a) && this.f40432b == chatDetails.f40432b && Intrinsics.a(this.f40433c, chatDetails.f40433c) && Intrinsics.a(this.f40434d, chatDetails.f40434d) && Intrinsics.a(this.f40435e, chatDetails.f40435e);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f40431a;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + i0.a.a(this.f40432b)) * 31;
        String str2 = this.f40433c;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f40434d.hashCode()) * 31) + this.f40435e.hashCode();
    }

    public String toString() {
        String str = this.f40431a;
        long j8 = this.f40432b;
        String str2 = this.f40433c;
        String str3 = this.f40434d;
        OrderHandleNetworkModel orderHandleNetworkModel = this.f40435e;
        return "ChatDetails(description=" + str + ", startDate=" + j8 + ", thumbnailUrl=" + str2 + ", title=" + str3 + ", orderHandleNetworkModel=" + orderHandleNetworkModel + ")";
    }
}
