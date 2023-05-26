package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.ChatData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsData.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsData {

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f27905a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27906b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27907c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f27908d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatData f27909e;

    public ContactOptionsData(OrderHandle orderHandle, boolean z7, boolean z8, boolean z9, ChatData chatData) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f27905a = orderHandle;
        this.f27906b = z7;
        this.f27907c = z8;
        this.f27908d = z9;
        this.f27909e = chatData;
    }

    public static /* synthetic */ ContactOptionsData b(ContactOptionsData contactOptionsData, OrderHandle orderHandle, boolean z7, boolean z8, boolean z9, ChatData chatData, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            orderHandle = contactOptionsData.f27905a;
        }
        if ((i8 & 2) != 0) {
            z7 = contactOptionsData.f27906b;
        }
        boolean z10 = z7;
        if ((i8 & 4) != 0) {
            z8 = contactOptionsData.f27907c;
        }
        boolean z11 = z8;
        if ((i8 & 8) != 0) {
            z9 = contactOptionsData.f27908d;
        }
        boolean z12 = z9;
        if ((i8 & 16) != 0) {
            chatData = contactOptionsData.f27909e;
        }
        return contactOptionsData.a(orderHandle, z10, z11, z12, chatData);
    }

    public final ContactOptionsData a(OrderHandle orderHandle, boolean z7, boolean z8, boolean z9, ChatData chatData) {
        Intrinsics.f(orderHandle, "orderHandle");
        return new ContactOptionsData(orderHandle, z7, z8, z9, chatData);
    }

    public final ChatData c() {
        return this.f27909e;
    }

    public final OrderHandle d() {
        return this.f27905a;
    }

    public final boolean e() {
        return this.f27908d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContactOptionsData) {
            ContactOptionsData contactOptionsData = (ContactOptionsData) obj;
            return Intrinsics.a(this.f27905a, contactOptionsData.f27905a) && this.f27906b == contactOptionsData.f27906b && this.f27907c == contactOptionsData.f27907c && this.f27908d == contactOptionsData.f27908d && Intrinsics.a(this.f27909e, contactOptionsData.f27909e);
        }
        return false;
    }

    public final boolean f() {
        return this.f27907c;
    }

    public final boolean g() {
        return this.f27906b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f27905a.hashCode() * 31;
        boolean z7 = this.f27906b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f27907c;
        int i10 = z8;
        if (z8 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z9 = this.f27908d;
        int i12 = (i11 + (z9 ? 1 : z9 ? 1 : 0)) * 31;
        ChatData chatData = this.f27909e;
        return i12 + (chatData == null ? 0 : chatData.hashCode());
    }

    public String toString() {
        OrderHandle orderHandle = this.f27905a;
        boolean z7 = this.f27906b;
        boolean z8 = this.f27907c;
        boolean z9 = this.f27908d;
        ChatData chatData = this.f27909e;
        return "ContactOptionsData(orderHandle=" + orderHandle + ", shouldShowVoipCallSection=" + z7 + ", shouldShowPhoneCallSection=" + z8 + ", shouldShowChatSection=" + z9 + ", chatData=" + chatData + ")";
    }
}
