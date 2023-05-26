package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: KSerializer.kt */
/* loaded from: classes5.dex */
public interface DeserializationStrategy<T> {
    SerialDescriptor a();

    T b(Decoder decoder);
}
