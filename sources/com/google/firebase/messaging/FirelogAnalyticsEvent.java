package com.google.firebase.messaging;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@KeepForSdk
/* loaded from: classes3.dex */
public final class FirelogAnalyticsEvent {

    /* renamed from: a  reason: collision with root package name */
    private final String f16513a = Preconditions.checkNotEmpty("MESSAGE_DELIVERED", "evenType must be non-null");

    /* renamed from: b  reason: collision with root package name */
    private final Intent f16514b;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    static class FirelogAnalyticsEventEncoder implements ObjectEncoder<FirelogAnalyticsEvent> {
        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(FirelogAnalyticsEvent firelogAnalyticsEvent, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
            Intent b8 = firelogAnalyticsEvent.b();
            objectEncoderContext.d("ttl", MessagingAnalytics.q(b8));
            objectEncoderContext.h("event", firelogAnalyticsEvent.a());
            objectEncoderContext.h("instanceId", MessagingAnalytics.e(b8));
            objectEncoderContext.d("priority", MessagingAnalytics.n(b8));
            objectEncoderContext.h("packageName", MessagingAnalytics.m());
            objectEncoderContext.h("sdkPlatform", "ANDROID");
            objectEncoderContext.h("messageType", MessagingAnalytics.k(b8));
            String g8 = MessagingAnalytics.g(b8);
            if (g8 != null) {
                objectEncoderContext.h("messageId", g8);
            }
            String p8 = MessagingAnalytics.p(b8);
            if (p8 != null) {
                objectEncoderContext.h("topic", p8);
            }
            String b9 = MessagingAnalytics.b(b8);
            if (b9 != null) {
                objectEncoderContext.h("collapseKey", b9);
            }
            if (MessagingAnalytics.h(b8) != null) {
                objectEncoderContext.h("analyticsLabel", MessagingAnalytics.h(b8));
            }
            if (MessagingAnalytics.d(b8) != null) {
                objectEncoderContext.h("composerLabel", MessagingAnalytics.d(b8));
            }
            String o8 = MessagingAnalytics.o(b8);
            if (o8 != null) {
                objectEncoderContext.h("projectNumber", o8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static final class FirelogAnalyticsEventWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final FirelogAnalyticsEvent f16515a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FirelogAnalyticsEventWrapper(@NonNull FirelogAnalyticsEvent firelogAnalyticsEvent) {
            this.f16515a = (FirelogAnalyticsEvent) Preconditions.checkNotNull(firelogAnalyticsEvent);
        }

        @NonNull
        FirelogAnalyticsEvent a() {
            return this.f16515a;
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    static final class FirelogAnalyticsEventWrapperEncoder implements ObjectEncoder<FirelogAnalyticsEventWrapper> {
        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(FirelogAnalyticsEventWrapper firelogAnalyticsEventWrapper, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
            objectEncoderContext.h("messaging_client_event", firelogAnalyticsEventWrapper.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirelogAnalyticsEvent(@NonNull String str, @NonNull Intent intent) {
        this.f16514b = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    @NonNull
    String a() {
        return this.f16513a;
    }

    @NonNull
    Intent b() {
        return this.f16514b;
    }
}
