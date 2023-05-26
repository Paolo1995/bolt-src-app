package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private StringBuilder lineBuf;
    private final boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf, boolean z7) {
        this(byteBuf, byteBuf.readableBytes(), z7);
    }

    private void checkAvailable(int i8) throws IOException {
        if (i8 >= 0) {
            if (i8 <= available()) {
                return;
            }
            throw new EOFException("fieldSize is too long! Length is " + i8 + ", but maximum is " + available());
        }
        throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
        }
    }

    @Override // java.io.InputStream
    public void mark(int i8) {
        this.buffer.markReaderIndex();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (available() == 0) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        checkAvailable(1);
        if (read() != 0) {
            return true;
        }
        return false;
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        if (available() != 0) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        int available = available();
        if (available == 0) {
            return null;
        }
        StringBuilder sb = this.lineBuf;
        if (sb != null) {
            sb.setLength(0);
        }
        while (true) {
            short readUnsignedByte = this.buffer.readUnsignedByte();
            available--;
            if (readUnsignedByte == 10) {
                break;
            } else if (readUnsignedByte != 13) {
                if (this.lineBuf == null) {
                    this.lineBuf = new StringBuilder();
                }
                this.lineBuf.append((char) readUnsignedByte);
                if (available <= 0) {
                    break;
                }
            } else if (available > 0) {
                ByteBuf byteBuf = this.buffer;
                if (((char) byteBuf.getUnsignedByte(byteBuf.readerIndex())) == '\n') {
                    this.buffer.skipBytes(1);
                }
            }
        }
        StringBuilder sb2 = this.lineBuf;
        if (sb2 != null && sb2.length() > 0) {
            return this.lineBuf.toString();
        }
        return "";
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return readShort() & 65535;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.buffer.resetReaderIndex();
    }

    @Override // java.io.InputStream
    public long skip(long j8) throws IOException {
        int skipBytes;
        if (j8 > 2147483647L) {
            skipBytes = skipBytes(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            skipBytes = skipBytes((int) j8);
        }
        return skipBytes;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i8) throws IOException {
        int min = Math.min(available(), i8);
        this.buffer.skipBytes(min);
        return min;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i8, boolean z7) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        if (i8 < 0) {
            if (z7) {
                byteBuf.release();
            }
            throw new IllegalArgumentException("length: " + i8);
        } else if (i8 > byteBuf.readableBytes()) {
            if (z7) {
                byteBuf.release();
            }
            throw new IndexOutOfBoundsException("Too many bytes to be read - Needs " + i8 + ", maximum is " + byteBuf.readableBytes());
        } else {
            this.releaseOnClose = z7;
            this.buffer = byteBuf;
            int readerIndex = byteBuf.readerIndex();
            this.startIndex = readerIndex;
            this.endIndex = readerIndex + i8;
            byteBuf.markReaderIndex();
        }
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i8, int i9) throws IOException {
        checkAvailable(i9);
        this.buffer.readBytes(bArr, i8, i9);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        int min = Math.min(available, i9);
        this.buffer.readBytes(bArr, i8, min);
        return min;
    }
}
