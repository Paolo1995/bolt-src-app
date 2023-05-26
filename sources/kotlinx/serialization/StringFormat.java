package kotlinx.serialization;

/* compiled from: SerialFormat.kt */
/* loaded from: classes5.dex */
public interface StringFormat extends SerialFormat {
    <T> T b(DeserializationStrategy<T> deserializationStrategy, String str);

    <T> String d(SerializationStrategy<? super T> serializationStrategy, T t7);
}
