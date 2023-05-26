package com.google.firebase.messaging;

import java.util.Locale;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public final class SendException extends Exception {

    /* renamed from: f  reason: collision with root package name */
    private final int f16569f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SendException(String str) {
        super(str);
        this.f16569f = a(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int a(String str) {
        char c8;
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        switch (lowerCase.hashCode()) {
            case -1743242157:
                if (lowerCase.equals("service_not_available")) {
                    c8 = 3;
                    break;
                }
                c8 = 65535;
                break;
            case -1290953729:
                if (lowerCase.equals("toomanymessages")) {
                    c8 = 4;
                    break;
                }
                c8 = 65535;
                break;
            case -920906446:
                if (lowerCase.equals("invalid_parameters")) {
                    c8 = 0;
                    break;
                }
                c8 = 65535;
                break;
            case -617027085:
                if (lowerCase.equals("messagetoobig")) {
                    c8 = 2;
                    break;
                }
                c8 = 65535;
                break;
            case -95047692:
                if (lowerCase.equals("missing_to")) {
                    c8 = 1;
                    break;
                }
                c8 = 65535;
                break;
            default:
                c8 = 65535;
                break;
        }
        if (c8 == 0 || c8 == 1) {
            return 1;
        }
        if (c8 == 2) {
            return 2;
        }
        if (c8 == 3) {
            return 3;
        }
        if (c8 != 4) {
            return 0;
        }
        return 4;
    }
}
