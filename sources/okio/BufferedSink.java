package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.kt */
/* loaded from: classes5.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink H() throws IOException;

    BufferedSink M0(long j8) throws IOException;

    BufferedSink Q(String str) throws IOException;

    BufferedSink U(String str, int i8, int i9) throws IOException;

    long V(Source source) throws IOException;

    BufferedSink a1(ByteString byteString) throws IOException;

    Buffer b();

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    BufferedSink l0(long j8) throws IOException;

    BufferedSink v() throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i8, int i9) throws IOException;

    BufferedSink writeByte(int i8) throws IOException;

    BufferedSink writeInt(int i8) throws IOException;

    BufferedSink writeShort(int i8) throws IOException;
}
