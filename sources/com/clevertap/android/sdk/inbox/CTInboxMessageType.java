package com.clevertap.android.sdk.inbox;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
enum CTInboxMessageType {
    SimpleMessage("simple"),
    IconMessage("message-icon"),
    CarouselMessage("carousel"),
    CarouselImageMessage("carousel-image");
    

    /* renamed from: f  reason: collision with root package name */
    private final String f11580f;

    CTInboxMessageType(String str) {
        this.f11580f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CTInboxMessageType a(String str) {
        str.hashCode();
        char c8 = 65535;
        switch (str.hashCode()) {
            case -1799711058:
                if (str.equals("carousel-image")) {
                    c8 = 0;
                    break;
                }
                break;
            case -1332589953:
                if (str.equals("message-icon")) {
                    c8 = 1;
                    break;
                }
                break;
            case -902286926:
                if (str.equals("simple")) {
                    c8 = 2;
                    break;
                }
                break;
            case 2908512:
                if (str.equals("carousel")) {
                    c8 = 3;
                    break;
                }
                break;
        }
        switch (c8) {
            case 0:
                return CarouselImageMessage;
            case 1:
                return IconMessage;
            case 2:
                return SimpleMessage;
            case 3:
                return CarouselMessage;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.f11580f;
    }
}
