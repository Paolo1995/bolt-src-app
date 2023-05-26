package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.contact.ChatContactDetails;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsData.kt */
/* loaded from: classes3.dex */
public final class ChatOptionsData {

    /* renamed from: a  reason: collision with root package name */
    private final ChatContactDetails f27904a;

    public ChatOptionsData(ChatContactDetails details) {
        Intrinsics.f(details, "details");
        this.f27904a = details;
    }

    public final ChatContactDetails a() {
        return this.f27904a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChatOptionsData) && Intrinsics.a(this.f27904a, ((ChatOptionsData) obj).f27904a);
    }

    public int hashCode() {
        return this.f27904a.hashCode();
    }

    public String toString() {
        ChatContactDetails chatContactDetails = this.f27904a;
        return "ChatOptionsData(details=" + chatContactDetails + ")";
    }
}
