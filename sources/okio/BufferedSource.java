package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.kt */
/* loaded from: classes5.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    long A0() throws IOException;

    long B(ByteString byteString) throws IOException;

    void E(Buffer buffer, long j8) throws IOException;

    long G(ByteString byteString) throws IOException;

    String J(long j8) throws IOException;

    String L0(Charset charset) throws IOException;

    ByteString N0() throws IOException;

    boolean R(long j8, ByteString byteString) throws IOException;

    Buffer b();

    String b0() throws IOException;

    byte[] e0(long j8) throws IOException;

    long e1(Sink sink) throws IOException;

    boolean f(long j8) throws IOException;

    long i1() throws IOException;

    void j0(long j8) throws IOException;

    InputStream j1();

    int k1(Options options) throws IOException;

    ByteString o0(long j8) throws IOException;

    BufferedSource peek();

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    Buffer s();

    void skip(long j8) throws IOException;

    byte[] w0() throws IOException;

    boolean y0() throws IOException;
}
