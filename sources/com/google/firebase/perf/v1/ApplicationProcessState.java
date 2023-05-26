package com.google.firebase.perf.v1;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum ApplicationProcessState implements Internal.EnumLite {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    

    /* renamed from: k  reason: collision with root package name */
    private static final Internal.EnumLiteMap<ApplicationProcessState> f16911k = new Internal.EnumLiteMap<ApplicationProcessState>() { // from class: com.google.firebase.perf.v1.ApplicationProcessState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public ApplicationProcessState a(int i8) {
            return ApplicationProcessState.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f16913f;

    /* loaded from: classes3.dex */
    private static final class ApplicationProcessStateVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f16914a = new ApplicationProcessStateVerifier();

        private ApplicationProcessStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean a(int i8) {
            if (ApplicationProcessState.a(i8) != null) {
                return true;
            }
            return false;
        }
    }

    ApplicationProcessState(int i8) {
        this.f16913f = i8;
    }

    public static ApplicationProcessState a(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return null;
                    }
                    return FOREGROUND_BACKGROUND;
                }
                return BACKGROUND;
            }
            return FOREGROUND;
        }
        return APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    public static Internal.EnumVerifier c() {
        return ApplicationProcessStateVerifier.f16914a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f16913f;
    }
}
