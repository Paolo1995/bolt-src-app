package kotlinx.serialization;

/* compiled from: SerialFormat.kt */
/* loaded from: classes5.dex */
public interface BinaryFormat extends SerialFormat {
    <T> byte[] c(SerializationStrategy<? super T> serializationStrategy, T t7);

    <T> T e(DeserializationStrategy<T> deserializationStrategy, byte[] bArr);
}
