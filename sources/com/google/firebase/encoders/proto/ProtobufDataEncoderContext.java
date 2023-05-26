package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f16233f = Charset.forName("UTF-8");

    /* renamed from: g  reason: collision with root package name */
    private static final FieldDescriptor f16234g = FieldDescriptor.a("key").b(AtProtobuf.b().c(1).a()).a();

    /* renamed from: h  reason: collision with root package name */
    private static final FieldDescriptor f16235h = FieldDescriptor.a(AppMeasurementSdk.ConditionalUserProperty.VALUE).b(AtProtobuf.b().c(2).a()).a();

    /* renamed from: i  reason: collision with root package name */
    private static final ObjectEncoder<Map.Entry<Object, Object>> f16236i = new ObjectEncoder() { // from class: com.google.firebase.encoders.proto.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            ProtobufDataEncoderContext.x((Map.Entry) obj, (ObjectEncoderContext) obj2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f16237a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f16238b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f16239c;

    /* renamed from: d  reason: collision with root package name */
    private final ObjectEncoder<Object> f16240d;

    /* renamed from: e  reason: collision with root package name */
    private final ProtobufValueEncoderContext f16241e = new ProtobufValueEncoderContext(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16242a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f16242a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16242a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16242a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.f16237a = outputStream;
        this.f16238b = map;
        this.f16239c = map2;
        this.f16240d = objectEncoder;
    }

    private static ByteBuffer q(int i8) {
        return ByteBuffer.allocate(i8).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long r(ObjectEncoder<T> objectEncoder, T t7) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.f16237a;
            this.f16237a = lengthCountingOutputStream;
            objectEncoder.a(t7, this);
            this.f16237a = outputStream;
            long a8 = lengthCountingOutputStream.a();
            lengthCountingOutputStream.close();
            return a8;
        } catch (Throwable th) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private <T> ProtobufDataEncoderContext s(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t7, boolean z7) throws IOException {
        long r7 = r(objectEncoder, t7);
        if (z7 && r7 == 0) {
            return this;
        }
        y((w(fieldDescriptor) << 3) | 2);
        z(r7);
        objectEncoder.a(t7, this);
        return this;
    }

    private <T> ProtobufDataEncoderContext t(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t7, boolean z7) throws IOException {
        this.f16241e.b(fieldDescriptor, z7);
        valueEncoder.a(t7, this.f16241e);
        return this;
    }

    private static Protobuf v(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int w(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.f(f16234g, entry.getKey());
        objectEncoderContext.f(f16235h, entry.getValue());
    }

    private void y(int i8) throws IOException {
        while ((i8 & (-128)) != 0) {
            this.f16237a.write((i8 & 127) | 128);
            i8 >>>= 7;
        }
        this.f16237a.write(i8 & 127);
    }

    private void z(long j8) throws IOException {
        while (((-128) & j8) != 0) {
            this.f16237a.write((((int) j8) & 127) | 128);
            j8 >>>= 7;
        }
        this.f16237a.write(((int) j8) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext d(@NonNull String str, int i8) throws IOException {
        return c(FieldDescriptor.d(str), i8);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext f(@NonNull FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return j(fieldDescriptor, obj, true);
    }

    ObjectEncoderContext g(@NonNull FieldDescriptor fieldDescriptor, double d8, boolean z7) throws IOException {
        if (z7 && d8 == 0.0d) {
            return this;
        }
        y((w(fieldDescriptor) << 3) | 1);
        this.f16237a.write(q(8).putDouble(d8).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext h(@NonNull String str, Object obj) throws IOException {
        return f(FieldDescriptor.d(str), obj);
    }

    ObjectEncoderContext i(@NonNull FieldDescriptor fieldDescriptor, float f8, boolean z7) throws IOException {
        if (z7 && f8 == 0.0f) {
            return this;
        }
        y((w(fieldDescriptor) << 3) | 5);
        this.f16237a.write(q(4).putFloat(f8).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectEncoderContext j(@NonNull FieldDescriptor fieldDescriptor, Object obj, boolean z7) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z7 && charSequence.length() == 0) {
                return this;
            }
            y((w(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f16233f);
            y(bytes.length);
            this.f16237a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                j(fieldDescriptor, obj2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                s(f16236i, fieldDescriptor, entry, false);
            }
            return this;
        } else if (obj instanceof Double) {
            return g(fieldDescriptor, ((Double) obj).doubleValue(), z7);
        } else {
            if (obj instanceof Float) {
                return i(fieldDescriptor, ((Float) obj).floatValue(), z7);
            }
            if (obj instanceof Number) {
                return n(fieldDescriptor, ((Number) obj).longValue(), z7);
            }
            if (obj instanceof Boolean) {
                return p(fieldDescriptor, ((Boolean) obj).booleanValue(), z7);
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z7 && bArr.length == 0) {
                    return this;
                }
                y((w(fieldDescriptor) << 3) | 2);
                y(bArr.length);
                this.f16237a.write(bArr);
                return this;
            }
            ObjectEncoder<?> objectEncoder = this.f16238b.get(obj.getClass());
            if (objectEncoder != null) {
                return s(objectEncoder, fieldDescriptor, obj, z7);
            }
            ValueEncoder<?> valueEncoder = this.f16239c.get(obj.getClass());
            if (valueEncoder != null) {
                return t(valueEncoder, fieldDescriptor, obj, z7);
            }
            if (obj instanceof ProtoEnum) {
                return c(fieldDescriptor, ((ProtoEnum) obj).getNumber());
            }
            if (obj instanceof Enum) {
                return c(fieldDescriptor, ((Enum) obj).ordinal());
            }
            return s(this.f16240d, fieldDescriptor, obj, z7);
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: k */
    public ProtobufDataEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, int i8) throws IOException {
        return l(fieldDescriptor, i8, true);
    }

    ProtobufDataEncoderContext l(@NonNull FieldDescriptor fieldDescriptor, int i8, boolean z7) throws IOException {
        if (z7 && i8 == 0) {
            return this;
        }
        Protobuf v7 = v(fieldDescriptor);
        int i9 = AnonymousClass1.f16242a[v7.intEncoding().ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    y((v7.tag() << 3) | 5);
                    this.f16237a.write(q(4).putInt(i8).array());
                }
            } else {
                y(v7.tag() << 3);
                y((i8 << 1) ^ (i8 >> 31));
            }
        } else {
            y(v7.tag() << 3);
            y(i8);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: m */
    public ProtobufDataEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, long j8) throws IOException {
        return n(fieldDescriptor, j8, true);
    }

    ProtobufDataEncoderContext n(@NonNull FieldDescriptor fieldDescriptor, long j8, boolean z7) throws IOException {
        if (z7 && j8 == 0) {
            return this;
        }
        Protobuf v7 = v(fieldDescriptor);
        int i8 = AnonymousClass1.f16242a[v7.intEncoding().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    y((v7.tag() << 3) | 1);
                    this.f16237a.write(q(8).putLong(j8).array());
                }
            } else {
                y(v7.tag() << 3);
                z((j8 >> 63) ^ (j8 << 1));
            }
        } else {
            y(v7.tag() << 3);
            z(j8);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: o */
    public ProtobufDataEncoderContext a(@NonNull FieldDescriptor fieldDescriptor, boolean z7) throws IOException {
        return p(fieldDescriptor, z7, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext p(@NonNull FieldDescriptor fieldDescriptor, boolean z7, boolean z8) throws IOException {
        return l(fieldDescriptor, z7 ? 1 : 0, z8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtobufDataEncoderContext u(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.f16238b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }
}
