package kotlinx.serialization.internal;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

/* compiled from: Tuples.kt */
/* loaded from: classes5.dex */
public final class PairSerializer<K, V> extends KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {

    /* renamed from: c  reason: collision with root package name */
    private final SerialDescriptor f52225c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PairSerializer(final KSerializer<K> keySerializer, final KSerializer<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        Intrinsics.f(keySerializer, "keySerializer");
        Intrinsics.f(valueSerializer, "valueSerializer");
        this.f52225c = SerialDescriptorsKt.b("kotlin.Pair", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.internal.PairSerializer$descriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
                Intrinsics.f(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
                ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "first", keySerializer.a(), null, false, 12, null);
                ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "second", valueSerializer.a(), null, false, 12, null);
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
        return this.f52225c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.KeyValueSerializer
    /* renamed from: i */
    public K f(Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(pair, "<this>");
        return pair.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.KeyValueSerializer
    /* renamed from: j */
    public V g(Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(pair, "<this>");
        return pair.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.KeyValueSerializer
    /* renamed from: k */
    public Pair<K, V> h(K k8, V v7) {
        return kotlin.TuplesKt.a(k8, v7);
    }
}
