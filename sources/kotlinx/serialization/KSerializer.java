package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: KSerializer.kt */
/* loaded from: classes5.dex */
public interface KSerializer<T> extends SerializationStrategy<T>, DeserializationStrategy<T> {
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    SerialDescriptor a();
}
