package com.google.firebase.encoders.json;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {

    /* renamed from: e  reason: collision with root package name */
    private static final ObjectEncoder<Object> f16207e = new ObjectEncoder() { // from class: c0.a
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final void a(Object obj, Object obj2) {
            JsonDataEncoderBuilder.l(obj, (ObjectEncoderContext) obj2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final ValueEncoder<String> f16208f = new ValueEncoder() { // from class: c0.b
        @Override // com.google.firebase.encoders.ValueEncoder
        public final void a(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).e((String) obj);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final ValueEncoder<Boolean> f16209g = new ValueEncoder() { // from class: c0.c
        @Override // com.google.firebase.encoders.ValueEncoder
        public final void a(Object obj, Object obj2) {
            JsonDataEncoderBuilder.n((Boolean) obj, (ValueEncoderContext) obj2);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final TimestampEncoder f16210h = new TimestampEncoder();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ObjectEncoder<?>> f16211a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, ValueEncoder<?>> f16212b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private ObjectEncoder<Object> f16213c = f16207e;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16214d = false;

    /* loaded from: classes3.dex */
    private static final class TimestampEncoder implements ValueEncoder<Date> {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f16216a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f16216a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        private TimestampEncoder() {
        }

        @Override // com.google.firebase.encoders.ValueEncoder
        /* renamed from: b */
        public void a(@NonNull Date date, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.e(f16216a.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        p(String.class, f16208f);
        p(Boolean.class, f16209g);
        p(Date.class, f16210h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Boolean bool, ValueEncoderContext valueEncoderContext) throws IOException {
        valueEncoderContext.g(bool.booleanValue());
    }

    @NonNull
    public DataEncoder i() {
        return new DataEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder.1
            @Override // com.google.firebase.encoders.DataEncoder
            public void a(@NonNull Object obj, @NonNull Writer writer) throws IOException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.f16211a, JsonDataEncoderBuilder.this.f16212b, JsonDataEncoderBuilder.this.f16213c, JsonDataEncoderBuilder.this.f16214d);
                jsonValueObjectEncoderContext.k(obj, false);
                jsonValueObjectEncoderContext.t();
            }

            @Override // com.google.firebase.encoders.DataEncoder
            public String b(@NonNull Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    a(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }

    @NonNull
    public JsonDataEncoderBuilder j(@NonNull Configurator configurator) {
        configurator.a(this);
        return this;
    }

    @NonNull
    public JsonDataEncoderBuilder k(boolean z7) {
        this.f16214d = z7;
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    /* renamed from: o */
    public <T> JsonDataEncoderBuilder a(@NonNull Class<T> cls, @NonNull ObjectEncoder<? super T> objectEncoder) {
        this.f16211a.put(cls, objectEncoder);
        this.f16212b.remove(cls);
        return this;
    }

    @NonNull
    public <T> JsonDataEncoderBuilder p(@NonNull Class<T> cls, @NonNull ValueEncoder<? super T> valueEncoder) {
        this.f16212b.put(cls, valueEncoder);
        this.f16211a.remove(cls);
        return this;
    }
}
