package retrofit2.converter.simplexml;

import java.io.IOException;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

/* loaded from: classes4.dex */
final class SimpleXmlResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Class<T> cls;
    private final Serializer serializer;
    private final boolean strict;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleXmlResponseBodyConverter(Class<T> cls, Serializer serializer, boolean z7) {
        this.cls = cls;
        this.serializer = serializer;
        this.strict = z7;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        try {
            try {
                T t7 = (T) this.serializer.read((Class<? extends Object>) this.cls, responseBody.charStream(), this.strict);
                if (t7 != null) {
                    return t7;
                }
                throw new IllegalStateException("Could not deserialize body as " + this.cls);
            } catch (IOException e8) {
                throw e8;
            } catch (RuntimeException e9) {
                throw e9;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        } finally {
            responseBody.close();
        }
    }
}
