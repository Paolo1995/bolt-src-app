package ee.mtakso.driver.network.adapter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RuntimeTypeAdapterFactory<T> implements TypeAdapterFactory {

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f21297f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21298g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Class<?>> f21299h = new LinkedHashMap();

    /* renamed from: i  reason: collision with root package name */
    private final Map<Class<?>, String> f21300i = new LinkedHashMap();

    /* renamed from: j  reason: collision with root package name */
    private final boolean f21301j;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str, boolean z7) {
        if (str != null && cls != null) {
            this.f21297f = cls;
            this.f21298g = str;
            this.f21301j = z7;
            return;
        }
        throw null;
    }

    public static <T> RuntimeTypeAdapterFactory<T> e(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str, false);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.f21297f) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.f21299h.entrySet()) {
            TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), delegateAdapter);
            linkedHashMap2.put(entry.getValue(), delegateAdapter);
        }
        return new TypeAdapter<R>() { // from class: ee.mtakso.driver.network.adapter.RuntimeTypeAdapterFactory.1
            @Override // com.google.gson.TypeAdapter
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement remove;
                JsonElement parse = Streams.parse(jsonReader);
                if (RuntimeTypeAdapterFactory.this.f21301j) {
                    remove = parse.getAsJsonObject().get(RuntimeTypeAdapterFactory.this.f21298g);
                } else {
                    remove = parse.getAsJsonObject().remove(RuntimeTypeAdapterFactory.this.f21298g);
                }
                if (remove != null) {
                    String asString = remove.getAsString();
                    TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(asString);
                    if (typeAdapter != null) {
                        return (R) typeAdapter.fromJsonTree(parse);
                    }
                    throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.f21297f + " subtype named " + asString + "; did you forget to register a subtype?");
                }
                throw new JsonParseException("cannot deserialize " + RuntimeTypeAdapterFactory.this.f21297f + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.f21298g);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, R r7) throws IOException {
                Class<?> cls = r7.getClass();
                String str = (String) RuntimeTypeAdapterFactory.this.f21300i.get(cls);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls);
                if (typeAdapter != null) {
                    JsonObject asJsonObject = typeAdapter.toJsonTree(r7).getAsJsonObject();
                    if (RuntimeTypeAdapterFactory.this.f21301j) {
                        Streams.write(asJsonObject, jsonWriter);
                        return;
                    }
                    JsonObject jsonObject = new JsonObject();
                    if (!asJsonObject.has(RuntimeTypeAdapterFactory.this.f21298g)) {
                        jsonObject.add(RuntimeTypeAdapterFactory.this.f21298g, new JsonPrimitive(str));
                        for (Map.Entry<String, JsonElement> entry2 : asJsonObject.entrySet()) {
                            jsonObject.add(entry2.getKey(), entry2.getValue());
                        }
                        Streams.write(jsonObject, jsonWriter);
                        return;
                    }
                    throw new JsonParseException("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.f21298g);
                }
                throw new JsonParseException("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
            }
        }.nullSafe();
    }

    public RuntimeTypeAdapterFactory<T> f(Class<? extends T> cls, String str) {
        if (cls != null && str != null) {
            if (!this.f21300i.containsKey(cls) && !this.f21299h.containsKey(str)) {
                this.f21299h.put(str, cls);
                this.f21300i.put(cls, str);
                return this;
            }
            throw new IllegalArgumentException("types and labels must be unique");
        }
        throw null;
    }
}
