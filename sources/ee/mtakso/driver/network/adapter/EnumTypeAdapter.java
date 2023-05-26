package ee.mtakso.driver.network.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnumTypeAdapter.kt */
/* loaded from: classes3.dex */
public final class EnumTypeAdapter extends TypeAdapter<Enum<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Enum<?>> f21295a;

    /* renamed from: b  reason: collision with root package name */
    private final Enum<?> f21296b;

    /* JADX WARN: Multi-variable type inference failed */
    public EnumTypeAdapter(Map<String, ? extends Enum<?>> map, Enum<?> r32) {
        Intrinsics.f(map, "map");
        this.f21295a = map;
        this.f21296b = r32;
    }

    private final String a(Enum<?> r52) {
        Object obj;
        if (r52 == null) {
            return null;
        }
        Iterator<T> it = this.f21295a.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((Map.Entry) obj).getValue(), r52)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (String) entry.getKey();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Enum<?> read(JsonReader reader) {
        Intrinsics.f(reader, "reader");
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return this.f21296b;
        }
        Enum<?> r32 = this.f21295a.get(reader.nextString());
        return r32 == null ? this.f21296b : r32;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter writer, Enum<?> r32) {
        Intrinsics.f(writer, "writer");
        String a8 = a(r32);
        if (a8 == null) {
            writer.nullValue();
        } else {
            writer.value(a8);
        }
    }
}
