package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private JsonValueObjectEncoderContext f16217a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16218b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f16219c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f16220d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f16221e;

    /* renamed from: f  reason: collision with root package name */
    private final ObjectEncoder<Object> f16222f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f16223g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonValueObjectEncoderContext(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z7) {
        this.f16219c = new JsonWriter(writer);
        this.f16220d = map;
        this.f16221e = map2;
        this.f16222f = objectEncoder;
        this.f16223g = z7;
    }

    private boolean s(Object obj) {
        if (obj != null && !obj.getClass().isArray() && !(obj instanceof Collection) && !(obj instanceof Date) && !(obj instanceof Enum) && !(obj instanceof Number)) {
            return false;
        }
        return true;
    }

    private JsonValueObjectEncoderContext v(@NonNull String str, Object obj) throws IOException, EncodingException {
        x();
        this.f16219c.name(str);
        if (obj == null) {
            this.f16219c.nullValue();
            return this;
        }
        return k(obj, false);
    }

    private JsonValueObjectEncoderContext w(@NonNull String str, Object obj) throws IOException, EncodingException {
        if (obj == null) {
            return this;
        }
        x();
        this.f16219c.name(str);
        return k(obj, false);
    }

    private void x() throws IOException {
        if (this.f16218b) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.f16217a;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.x();
                this.f16217a.f16218b = false;
                this.f16217a = null;
                this.f16219c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext a(@NonNull FieldDescriptor fieldDescriptor, boolean z7) throws IOException {
        return p(fieldDescriptor.b(), z7);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext b(@NonNull FieldDescriptor fieldDescriptor, long j8) throws IOException {
        return n(fieldDescriptor.b(), j8);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext c(@NonNull FieldDescriptor fieldDescriptor, int i8) throws IOException {
        return d(fieldDescriptor.b(), i8);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public ObjectEncoderContext f(@NonNull FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return h(fieldDescriptor.b(), obj);
    }

    @NonNull
    public JsonValueObjectEncoderContext i(int i8) throws IOException {
        x();
        this.f16219c.value(i8);
        return this;
    }

    @NonNull
    public JsonValueObjectEncoderContext j(long j8) throws IOException {
        x();
        this.f16219c.value(j8);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public JsonValueObjectEncoderContext k(Object obj, boolean z7) throws IOException {
        int[] iArr;
        Class<?> cls;
        int i8 = 0;
        if (z7 && s(obj)) {
            Object[] objArr = new Object[1];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            objArr[0] = cls;
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        } else if (obj == null) {
            this.f16219c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f16219c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return r((byte[]) obj);
            }
            this.f16219c.beginArray();
            if (obj instanceof int[]) {
                int length = ((int[]) obj).length;
                while (i8 < length) {
                    this.f16219c.value(iArr[i8]);
                    i8++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i8 < length2) {
                    j(jArr[i8]);
                    i8++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i8 < length3) {
                    this.f16219c.value(dArr[i8]);
                    i8++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i8 < length4) {
                    this.f16219c.value(zArr[i8]);
                    i8++;
                }
            } else if (obj instanceof Number[]) {
                for (Number number : (Number[]) obj) {
                    k(number, false);
                }
            } else {
                for (Object obj2 : (Object[]) obj) {
                    k(obj2, false);
                }
            }
            this.f16219c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f16219c.beginArray();
            for (Object obj3 : (Collection) obj) {
                k(obj3, false);
            }
            this.f16219c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f16219c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    h((String) key, entry.getValue());
                } catch (ClassCastException e8) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e8);
                }
            }
            this.f16219c.endObject();
            return this;
        } else {
            ObjectEncoder<?> objectEncoder = this.f16220d.get(obj.getClass());
            if (objectEncoder != null) {
                return u(objectEncoder, obj, z7);
            }
            ValueEncoder<?> valueEncoder = this.f16221e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.a(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                e(((Enum) obj).name());
                return this;
            } else {
                return u(this.f16222f, obj, z7);
            }
        }
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: l */
    public JsonValueObjectEncoderContext e(String str) throws IOException {
        x();
        this.f16219c.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: m */
    public JsonValueObjectEncoderContext d(@NonNull String str, int i8) throws IOException {
        x();
        this.f16219c.name(str);
        return i(i8);
    }

    @NonNull
    public JsonValueObjectEncoderContext n(@NonNull String str, long j8) throws IOException {
        x();
        this.f16219c.name(str);
        return j(j8);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    /* renamed from: o */
    public JsonValueObjectEncoderContext h(@NonNull String str, Object obj) throws IOException {
        if (this.f16223g) {
            return w(str, obj);
        }
        return v(str, obj);
    }

    @NonNull
    public JsonValueObjectEncoderContext p(@NonNull String str, boolean z7) throws IOException {
        x();
        this.f16219c.name(str);
        return g(z7);
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    /* renamed from: q */
    public JsonValueObjectEncoderContext g(boolean z7) throws IOException {
        x();
        this.f16219c.value(z7);
        return this;
    }

    @NonNull
    public JsonValueObjectEncoderContext r(byte[] bArr) throws IOException {
        x();
        if (bArr == null) {
            this.f16219c.nullValue();
        } else {
            this.f16219c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() throws IOException {
        x();
        this.f16219c.flush();
    }

    JsonValueObjectEncoderContext u(ObjectEncoder<Object> objectEncoder, Object obj, boolean z7) throws IOException {
        if (!z7) {
            this.f16219c.beginObject();
        }
        objectEncoder.a(obj, this);
        if (!z7) {
            this.f16219c.endObject();
        }
        return this;
    }
}
