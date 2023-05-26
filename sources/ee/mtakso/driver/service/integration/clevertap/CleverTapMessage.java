package ee.mtakso.driver.service.integration.clevertap;

import android.annotation.SuppressLint;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.inbox.CTInboxMessageContent;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapMessage.kt */
/* loaded from: classes3.dex */
public final class CleverTapMessage {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f24546b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final CTInboxMessage f24547a;

    /* compiled from: CleverTapMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CleverTapMessage(CTInboxMessage impl) {
        Intrinsics.f(impl, "impl");
        this.f24547a = impl;
    }

    public final String a() {
        String g8 = this.f24547a.g();
        Intrinsics.e(g8, "impl.messageId");
        return g8;
    }

    @SuppressLint({"RestrictedApi"})
    public final CleverTapInboxMessagePreview b() {
        Integer num;
        ArrayList<CTInboxMessageContent> f8 = this.f24547a.f();
        if (f8 != null) {
            num = Integer.valueOf(f8.size());
        } else {
            num = null;
        }
        boolean z7 = true;
        if (num != null && num.intValue() != 0) {
            z7 = false;
        }
        if (z7) {
            String g8 = this.f24547a.g();
            Intrinsics.e(g8, "impl.messageId");
            return new CleverTapInboxMessagePreview(g8, this.f24547a.j(), this.f24547a.b(), this.f24547a.e(), this.f24547a.d() * 1000, this.f24547a.o());
        }
        CTInboxMessageContent cTInboxMessageContent = this.f24547a.f().get(0);
        String g9 = this.f24547a.g();
        Intrinsics.e(g9, "impl.messageId");
        return new CleverTapInboxMessagePreview(g9, cTInboxMessageContent.r(), cTInboxMessageContent.o(), cTInboxMessageContent.c(), this.f24547a.d() * 1000, this.f24547a.o());
    }
}
