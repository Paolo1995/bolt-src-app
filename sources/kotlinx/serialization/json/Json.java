package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.TreeJsonDecoderKt;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* compiled from: Json.kt */
/* loaded from: classes5.dex */
public abstract class Json implements StringFormat {

    /* renamed from: d  reason: collision with root package name */
    public static final Default f52300d = new Default(null);

    /* renamed from: a  reason: collision with root package name */
    private final JsonConfiguration f52301a;

    /* renamed from: b  reason: collision with root package name */
    private final SerializersModule f52302b;

    /* renamed from: c  reason: collision with root package name */
    private final DescriptorSchemaCache f52303c;

    /* compiled from: Json.kt */
    /* loaded from: classes5.dex */
    public static final class Default extends Json {
        private Default() {
            super(new JsonConfiguration(false, false, false, false, false, false, null, false, false, null, false, false, 4095, null), SerializersModuleBuildersKt.a(), null);
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule) {
        this.f52301a = jsonConfiguration;
        this.f52302b = serializersModule;
        this.f52303c = new DescriptorSchemaCache();
    }

    public /* synthetic */ Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonConfiguration, serializersModule);
    }

    @Override // kotlinx.serialization.SerialFormat
    public SerializersModule a() {
        return this.f52302b;
    }

    @Override // kotlinx.serialization.StringFormat
    public final <T> T b(DeserializationStrategy<T> deserializer, String string) {
        Intrinsics.f(deserializer, "deserializer");
        Intrinsics.f(string, "string");
        StringJsonLexer stringJsonLexer = new StringJsonLexer(string);
        T t7 = (T) new StreamingJsonDecoder(this, WriteMode.OBJ, stringJsonLexer, deserializer.a(), null).G(deserializer);
        stringJsonLexer.w();
        return t7;
    }

    @Override // kotlinx.serialization.StringFormat
    public final <T> String d(SerializationStrategy<? super T> serializer, T t7) {
        Intrinsics.f(serializer, "serializer");
        JsonToStringWriter jsonToStringWriter = new JsonToStringWriter();
        try {
            JsonStreamsKt.a(this, jsonToStringWriter, serializer, t7);
            return jsonToStringWriter.toString();
        } finally {
            jsonToStringWriter.g();
        }
    }

    public final <T> T f(DeserializationStrategy<T> deserializer, JsonElement element) {
        Intrinsics.f(deserializer, "deserializer");
        Intrinsics.f(element, "element");
        return (T) TreeJsonDecoderKt.a(this, element, deserializer);
    }

    public final JsonConfiguration g() {
        return this.f52301a;
    }

    public final DescriptorSchemaCache h() {
        return this.f52303c;
    }
}
