package eu.bolt.driver.chat.network;

import com.google.gson.annotations.SerializedName;
import eu.bolt.chat.chatcore.network.model.OrderHandleNetworkModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveChat.kt */
/* loaded from: classes5.dex */
public final class ActiveChat {
    @SerializedName("description")

    /* renamed from: a  reason: collision with root package name */
    private final String f40421a;
    @SerializedName("start_date")

    /* renamed from: b  reason: collision with root package name */
    private final long f40422b;
    @SerializedName("thumbnail_url")

    /* renamed from: c  reason: collision with root package name */
    private final String f40423c;
    @SerializedName("title")

    /* renamed from: d  reason: collision with root package name */
    private final String f40424d;
    @SerializedName("order_handle")

    /* renamed from: e  reason: collision with root package name */
    private final OrderHandleNetworkModel f40425e;
    @SerializedName("chat_id")

    /* renamed from: f  reason: collision with root package name */
    private final String f40426f;

    public final String a() {
        return this.f40426f;
    }

    public final String b() {
        return this.f40421a;
    }

    public final OrderHandleNetworkModel c() {
        return this.f40425e;
    }

    public final long d() {
        return this.f40422b;
    }

    public final String e() {
        return this.f40423c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActiveChat) {
            ActiveChat activeChat = (ActiveChat) obj;
            return Intrinsics.a(this.f40421a, activeChat.f40421a) && this.f40422b == activeChat.f40422b && Intrinsics.a(this.f40423c, activeChat.f40423c) && Intrinsics.a(this.f40424d, activeChat.f40424d) && Intrinsics.a(this.f40425e, activeChat.f40425e) && Intrinsics.a(this.f40426f, activeChat.f40426f);
        }
        return false;
    }

    public final String f() {
        return this.f40424d;
    }

    public int hashCode() {
        String str = this.f40421a;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + i0.a.a(this.f40422b)) * 31;
        String str2 = this.f40423c;
        return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f40424d.hashCode()) * 31) + this.f40425e.hashCode()) * 31) + this.f40426f.hashCode();
    }

    public String toString() {
        String str = this.f40421a;
        long j8 = this.f40422b;
        String str2 = this.f40423c;
        String str3 = this.f40424d;
        OrderHandleNetworkModel orderHandleNetworkModel = this.f40425e;
        String str4 = this.f40426f;
        return "ActiveChat(description=" + str + ", startDate=" + j8 + ", thumbnailUrl=" + str2 + ", title=" + str3 + ", orderHandleNetworkModel=" + orderHandleNetworkModel + ", chatId=" + str4 + ")";
    }
}
