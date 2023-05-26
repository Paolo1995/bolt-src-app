package retrofit2.converter.simplexml;

import java.io.IOException;
import java.io.OutputStreamWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

/* loaded from: classes4.dex */
final class SimpleXmlRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final String CHARSET = "UTF-8";
    private static final MediaType MEDIA_TYPE = MediaType.get("application/xml; charset=UTF-8");
    private final Serializer serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleXmlRequestBodyConverter(Serializer serializer) {
        this.serializer = serializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert2((SimpleXmlRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    /* renamed from: convert  reason: avoid collision after fix types in other method */
    public RequestBody convert2(T t7) throws IOException {
        Buffer buffer = new Buffer();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(buffer.O(), CHARSET);
            this.serializer.write(t7, outputStreamWriter);
            outputStreamWriter.flush();
            return RequestBody.create(MEDIA_TYPE, buffer.N0());
        } catch (IOException e8) {
            throw e8;
        } catch (RuntimeException e9) {
            throw e9;
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
