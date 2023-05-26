package kotlinx.serialization.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: Tuples.kt */
/* loaded from: classes5.dex */
public final class MapEntrySerializer<K, V> extends KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f52204c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Tuples.kt */
    /* loaded from: classes5.dex */
    public static final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {

        /* renamed from: f  reason: collision with root package name */
        private final K f52205f;

        /* renamed from: g  reason: collision with root package name */
        private final V f52206g;

        public MapEntry(K k8, V v7) {
            this.f52205f = k8;
            this.f52206g = v7;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MapEntry) {
                MapEntry mapEntry = (MapEntry) obj;
                return Intrinsics.a(getKey(), mapEntry.getKey()) && Intrinsics.a(getValue(), mapEntry.getValue());
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f52205f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f52206g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return ((getKey() == null ? 0 : getKey().hashCode()) * 31) + (getValue() != null ? getValue().hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + getKey() + ", value=" + getValue() + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer(final KSerializer<K> keySerializer, final KSerializer<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        Intrinsics.f(keySerializer, "keySerializer");
        Intrinsics.f(valueSerializer, "valueSerializer");
        this.f52204c = SerialDescriptorsKt.c("kotlin.collections.Map.Entry", StructureKind.MAP.f52126a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.MapEntrySerializer$descriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                Intrinsics.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "key", keySerializer.a(), null, false, 12, null);
                ClassSerialDescriptorBuilder.b(buildSerialDescriptor, AppMeasurementSdk.ConditionalUserProperty.VALUE, valueSerializer.a(), null, false, 12, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                b(classSerialDescriptorBuilder);
                return Unit.f50853a;
            }
        });
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return this.f52204c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.KeyValueSerializer
    /* renamed from: i */
    public K f(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "<this>");
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.KeyValueSerializer
    /* renamed from: j */
    public V g(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.f(entry, "<this>");
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.KeyValueSerializer
    /* renamed from: k */
    public Map.Entry<K, V> h(K k8, V v7) {
        return new MapEntry(k8, v7);
    }
}
