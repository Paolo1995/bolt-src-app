package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ProtobufValueEncoderContext implements ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16250a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16251b = false;

    /* renamed from: c  reason: collision with root package name */
    private FieldDescriptor f16252c;

    /* renamed from: d  reason: collision with root package name */
    private final ProtobufDataEncoderContext f16253d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.f16253d = protobufDataEncoderContext;
    }

    private void a() {
        if (!this.f16250a) {
            this.f16250a = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FieldDescriptor fieldDescriptor, boolean z7) {
        this.f16250a = false;
        this.f16252c = fieldDescriptor;
        this.f16251b = z7;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext e(String str) throws IOException {
        a();
        this.f16253d.j(this.f16252c, str, this.f16251b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext g(boolean z7) throws IOException {
        a();
        this.f16253d.p(this.f16252c, z7, this.f16251b);
        return this;
    }
}
