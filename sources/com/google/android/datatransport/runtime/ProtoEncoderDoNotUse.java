package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.proto.ProtobufEncoder;

/* loaded from: classes.dex */
public abstract class ProtoEncoderDoNotUse {

    /* renamed from: a  reason: collision with root package name */
    private static final ProtobufEncoder f12103a = ProtobufEncoder.a().d(AutoProtoEncoderDoNotUseEncoder.f12036a).c();

    private ProtoEncoderDoNotUse() {
    }

    public static byte[] a(Object obj) {
        return f12103a.c(obj);
    }

    public abstract ClientMetrics b();
}
