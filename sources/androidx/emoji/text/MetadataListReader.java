package androidx.emoji.text;

import android.content.res.AssetManager;
import androidx.text.emoji.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class MetadataListReader {

    /* loaded from: classes.dex */
    private static class ByteBufferReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f6374a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f6374a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public int a() throws IOException {
            return this.f6374a.getInt();
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public void b(int i8) throws IOException {
            ByteBuffer byteBuffer = this.f6374a;
            byteBuffer.position(byteBuffer.position() + i8);
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public long c() throws IOException {
            return MetadataListReader.e(this.f6374a.getInt());
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f6374a.position();
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.f(this.f6374a.getShort());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InputStreamOpenTypeReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f6375a;

        /* renamed from: b  reason: collision with root package name */
        private final ByteBuffer f6376b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream f6377c;

        /* renamed from: d  reason: collision with root package name */
        private long f6378d = 0;

        InputStreamOpenTypeReader(InputStream inputStream) {
            this.f6377c = inputStream;
            byte[] bArr = new byte[4];
            this.f6375a = bArr;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f6376b = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        private void d(int i8) throws IOException {
            if (this.f6377c.read(this.f6375a, 0, i8) == i8) {
                this.f6378d += i8;
                return;
            }
            throw new IOException("read failed");
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public int a() throws IOException {
            this.f6376b.position(0);
            d(4);
            return this.f6376b.getInt();
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public void b(int i8) throws IOException {
            while (i8 > 0) {
                int skip = (int) this.f6377c.skip(i8);
                if (skip >= 1) {
                    i8 -= skip;
                    this.f6378d += skip;
                } else {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
            }
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public long c() throws IOException {
            this.f6376b.position(0);
            d(4);
            return MetadataListReader.e(this.f6376b.getInt());
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f6378d;
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            this.f6376b.position(0);
            d(2);
            return MetadataListReader.f(this.f6376b.getShort());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class OffsetInfo {

        /* renamed from: a  reason: collision with root package name */
        private final long f6379a;

        /* renamed from: b  reason: collision with root package name */
        private final long f6380b;

        OffsetInfo(long j8, long j9) {
            this.f6379a = j8;
            this.f6380b = j9;
        }

        long a() {
            return this.f6380b;
        }

        long b() {
            return this.f6379a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface OpenTypeReader {
        int a() throws IOException;

        void b(int i8) throws IOException;

        long c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private MetadataListReader() {
    }

    private static OffsetInfo a(OpenTypeReader openTypeReader) throws IOException {
        long j8;
        openTypeReader.b(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.b(6);
            int i8 = 0;
            while (true) {
                if (i8 < readUnsignedShort) {
                    int a8 = openTypeReader.a();
                    openTypeReader.b(4);
                    j8 = openTypeReader.c();
                    openTypeReader.b(4);
                    if (1835365473 == a8) {
                        break;
                    }
                    i8++;
                } else {
                    j8 = -1;
                    break;
                }
            }
            if (j8 != -1) {
                openTypeReader.b((int) (j8 - openTypeReader.getPosition()));
                openTypeReader.b(12);
                long c8 = openTypeReader.c();
                for (int i9 = 0; i9 < c8; i9++) {
                    int a9 = openTypeReader.a();
                    long c9 = openTypeReader.c();
                    long c10 = openTypeReader.c();
                    if (1164798569 == a9 || 1701669481 == a9) {
                        return new OffsetInfo(c9 + j8, c10);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList b(AssetManager assetManager, String str) throws IOException {
        InputStream open = assetManager.open(str);
        try {
            MetadataList c8 = c(open);
            if (open != null) {
                open.close();
            }
            return c8;
        } catch (Throwable th) {
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static MetadataList c(InputStream inputStream) throws IOException {
        InputStreamOpenTypeReader inputStreamOpenTypeReader = new InputStreamOpenTypeReader(inputStream);
        OffsetInfo a8 = a(inputStreamOpenTypeReader);
        inputStreamOpenTypeReader.b((int) (a8.b() - inputStreamOpenTypeReader.getPosition()));
        ByteBuffer allocate = ByteBuffer.allocate((int) a8.a());
        int read = inputStream.read(allocate.array());
        if (read == a8.a()) {
            return MetadataList.g(allocate);
        }
        throw new IOException("Needed " + a8.a() + " bytes, got " + read);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList d(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new ByteBufferReader(duplicate)).b());
        return MetadataList.g(duplicate);
    }

    static long e(int i8) {
        return i8 & 4294967295L;
    }

    static int f(short s7) {
        return s7 & 65535;
    }
}
