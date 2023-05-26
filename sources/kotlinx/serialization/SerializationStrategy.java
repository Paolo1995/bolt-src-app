package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: KSerializer.kt */
/* loaded from: classes5.dex */
public interface SerializationStrategy<T> {
    SerialDescriptor a();

    void c(Encoder encoder, T t7);
}
