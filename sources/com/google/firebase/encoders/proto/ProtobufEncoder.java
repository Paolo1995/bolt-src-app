package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ProtobufEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f16243a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f16244b;

    /* renamed from: c  reason: collision with root package name */
    private final ObjectEncoder<Object> f16245c;

    /* loaded from: classes3.dex */
    public static final class Builder implements EncoderConfig<Builder> {

        /* renamed from: d  reason: collision with root package name */
        private static final ObjectEncoder<Object> f16246d = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.b
            @Override // com.google.firebase.encoders.ObjectEncoder
            public final void a(Object obj, Object obj2) {
                ProtobufEncoder.Builder.e(obj, (ObjectEncoderContext) obj2);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, ObjectEncoder<?>> f16247a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<Class<?>, ValueEncoder<?>> f16248b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private ObjectEncoder<Object> f16249c = f16246d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public ProtobufEncoder c() {
            return new ProtobufEncoder(new HashMap(this.f16247a), new HashMap(this.f16248b), this.f16249c);
        }

        @NonNull
        public Builder d(@NonNull Configurator configurator) {
            configurator.a(this);
            return this;
        }

        @Override // com.google.firebase.encoders.config.EncoderConfig
        @NonNull
        /* renamed from: f */
        public <U> Builder a(@NonNull Class<U> cls, @NonNull ObjectEncoder<? super U> objectEncoder) {
            this.f16247a.put(cls, objectEncoder);
            this.f16248b.remove(cls);
            return this;
        }
    }

    ProtobufEncoder(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f16243a = map;
        this.f16244b = map2;
        this.f16245c = objectEncoder;
    }

    public static Builder a() {
        return new Builder();
    }

    public void b(@NonNull Object obj, @NonNull OutputStream outputStream) throws IOException {
        new ProtobufDataEncoderContext(outputStream, this.f16243a, this.f16244b, this.f16245c).u(obj);
    }

    @NonNull
    public byte[] c(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
