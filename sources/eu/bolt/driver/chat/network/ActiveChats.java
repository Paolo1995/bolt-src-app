package eu.bolt.driver.chat.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveChats.kt */
/* loaded from: classes5.dex */
public final class ActiveChats {
    @SerializedName("active_chats")

    /* renamed from: a  reason: collision with root package name */
    private final List<ActiveChat> f40427a;

    public final List<ActiveChat> a() {
        return this.f40427a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActiveChats) && Intrinsics.a(this.f40427a, ((ActiveChats) obj).f40427a);
    }

    public int hashCode() {
        List<ActiveChat> list = this.f40427a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        List<ActiveChat> list = this.f40427a;
        return "ActiveChats(activeChats=" + list + ")";
    }
}
