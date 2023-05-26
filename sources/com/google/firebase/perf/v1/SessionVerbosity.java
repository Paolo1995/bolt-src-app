package com.google.firebase.perf.v1;

import com.google.protobuf.Internal;

/* loaded from: classes3.dex */
public enum SessionVerbosity implements Internal.EnumLite {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    

    /* renamed from: i  reason: collision with root package name */
    private static final Internal.EnumLiteMap<SessionVerbosity> f16989i = new Internal.EnumLiteMap<SessionVerbosity>() { // from class: com.google.firebase.perf.v1.SessionVerbosity.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: b */
        public SessionVerbosity a(int i8) {
            return SessionVerbosity.a(i8);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final int f16991f;

    /* loaded from: classes3.dex */
    private static final class SessionVerbosityVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f16992a = new SessionVerbosityVerifier();

        private SessionVerbosityVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean a(int i8) {
            if (SessionVerbosity.a(i8) != null) {
                return true;
            }
            return false;
        }
    }

    SessionVerbosity(int i8) {
        this.f16991f = i8;
    }

    public static SessionVerbosity a(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                return null;
            }
            return GAUGES_AND_SYSTEM_EVENTS;
        }
        return SESSION_VERBOSITY_NONE;
    }

    public static Internal.EnumVerifier c() {
        return SessionVerbosityVerifier.f16992a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f16991f;
    }
}
