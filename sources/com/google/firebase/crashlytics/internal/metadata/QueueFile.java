package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class QueueFile implements Closeable {

    /* renamed from: l  reason: collision with root package name */
    private static final Logger f15741l = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: f  reason: collision with root package name */
    private final RandomAccessFile f15742f;

    /* renamed from: g  reason: collision with root package name */
    int f15743g;

    /* renamed from: h  reason: collision with root package name */
    private int f15744h;

    /* renamed from: i  reason: collision with root package name */
    private Element f15745i;

    /* renamed from: j  reason: collision with root package name */
    private Element f15746j;

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f15747k = new byte[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Element {

        /* renamed from: c  reason: collision with root package name */
        static final Element f15751c = new Element(0, 0);

        /* renamed from: a  reason: collision with root package name */
        final int f15752a;

        /* renamed from: b  reason: collision with root package name */
        final int f15753b;

        Element(int i8, int i9) {
            this.f15752a = i8;
            this.f15753b = i9;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f15752a + ", length = " + this.f15753b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class ElementInputStream extends InputStream {

        /* renamed from: f  reason: collision with root package name */
        private int f15754f;

        /* renamed from: g  reason: collision with root package name */
        private int f15755g;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i8, int i9) throws IOException {
            QueueFile.w(bArr, "buffer");
            if ((i8 | i9) >= 0 && i9 <= bArr.length - i8) {
                int i10 = this.f15755g;
                if (i10 > 0) {
                    if (i9 > i10) {
                        i9 = i10;
                    }
                    QueueFile.this.Y(this.f15754f, bArr, i8, i9);
                    this.f15754f = QueueFile.this.f0(this.f15754f + i9);
                    this.f15755g -= i9;
                    return i9;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private ElementInputStream(Element element) {
            this.f15754f = QueueFile.this.f0(element.f15752a + 4);
            this.f15755g = element.f15753b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f15755g == 0) {
                return -1;
            }
            QueueFile.this.f15742f.seek(this.f15754f);
            int read = QueueFile.this.f15742f.read();
            this.f15754f = QueueFile.this.f0(this.f15754f + 1);
            this.f15755g--;
            return read;
        }
    }

    /* loaded from: classes3.dex */
    public interface ElementReader {
        void a(InputStream inputStream, int i8) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            q(file);
        }
        this.f15742f = y(file);
        I();
    }

    private Element F(int i8) throws IOException {
        if (i8 == 0) {
            return Element.f15751c;
        }
        this.f15742f.seek(i8);
        return new Element(i8, this.f15742f.readInt());
    }

    private void I() throws IOException {
        this.f15742f.seek(0L);
        this.f15742f.readFully(this.f15747k);
        int N = N(this.f15747k, 0);
        this.f15743g = N;
        if (N <= this.f15742f.length()) {
            this.f15744h = N(this.f15747k, 4);
            int N2 = N(this.f15747k, 8);
            int N3 = N(this.f15747k, 12);
            this.f15745i = F(N2);
            this.f15746j = F(N3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f15743g + ", Actual length: " + this.f15742f.length());
    }

    private static int N(byte[] bArr, int i8) {
        return ((bArr[i8] & 255) << 24) + ((bArr[i8 + 1] & 255) << 16) + ((bArr[i8 + 2] & 255) << 8) + (bArr[i8 + 3] & 255);
    }

    private int O() {
        return this.f15743g - d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i8, byte[] bArr, int i9, int i10) throws IOException {
        int f02 = f0(i8);
        int i11 = f02 + i10;
        int i12 = this.f15743g;
        if (i11 <= i12) {
            this.f15742f.seek(f02);
            this.f15742f.readFully(bArr, i9, i10);
            return;
        }
        int i13 = i12 - f02;
        this.f15742f.seek(f02);
        this.f15742f.readFully(bArr, i9, i13);
        this.f15742f.seek(16L);
        this.f15742f.readFully(bArr, i9 + i13, i10 - i13);
    }

    private void Z(int i8, byte[] bArr, int i9, int i10) throws IOException {
        int f02 = f0(i8);
        int i11 = f02 + i10;
        int i12 = this.f15743g;
        if (i11 <= i12) {
            this.f15742f.seek(f02);
            this.f15742f.write(bArr, i9, i10);
            return;
        }
        int i13 = i12 - f02;
        this.f15742f.seek(f02);
        this.f15742f.write(bArr, i9, i13);
        this.f15742f.seek(16L);
        this.f15742f.write(bArr, i9 + i13, i10 - i13);
    }

    private void c0(int i8) throws IOException {
        this.f15742f.setLength(i8);
        this.f15742f.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f0(int i8) {
        int i9 = this.f15743g;
        if (i8 >= i9) {
            return (i8 + 16) - i9;
        }
        return i8;
    }

    private void k0(int i8, int i9, int i10, int i11) throws IOException {
        v0(this.f15747k, i8, i9, i10, i11);
        this.f15742f.seek(0L);
        this.f15742f.write(this.f15747k);
    }

    private void l(int i8) throws IOException {
        int i9 = i8 + 4;
        int O = O();
        if (O >= i9) {
            return;
        }
        int i10 = this.f15743g;
        do {
            O += i10;
            i10 <<= 1;
        } while (O < i9);
        c0(i10);
        Element element = this.f15746j;
        int f02 = f0(element.f15752a + 4 + element.f15753b);
        if (f02 < this.f15745i.f15752a) {
            FileChannel channel = this.f15742f.getChannel();
            channel.position(this.f15743g);
            long j8 = f02 - 4;
            if (channel.transferTo(16L, j8, channel) != j8) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i11 = this.f15746j.f15752a;
        int i12 = this.f15745i.f15752a;
        if (i11 < i12) {
            int i13 = (this.f15743g + i11) - 16;
            k0(i10, this.f15744h, i12, i13);
            this.f15746j = new Element(i13, this.f15746j.f15753b);
        } else {
            k0(i10, this.f15744h, i12, i11);
        }
        this.f15743g = i10;
    }

    private static void q(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile y7 = y(file2);
        try {
            y7.setLength(4096L);
            y7.seek(0L);
            byte[] bArr = new byte[16];
            v0(bArr, 4096, 0, 0, 0);
            y7.write(bArr);
            y7.close();
            if (file2.renameTo(file)) {
                return;
            }
            throw new IOException("Rename failed!");
        } catch (Throwable th) {
            y7.close();
            throw th;
        }
    }

    private static void s0(byte[] bArr, int i8, int i9) {
        bArr[i8] = (byte) (i9 >> 24);
        bArr[i8 + 1] = (byte) (i9 >> 16);
        bArr[i8 + 2] = (byte) (i9 >> 8);
        bArr[i8 + 3] = (byte) i9;
    }

    private static void v0(byte[] bArr, int... iArr) {
        int i8 = 0;
        for (int i9 : iArr) {
            s0(bArr, i8, i9);
            i8 += 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T w(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile y(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    public synchronized void X() throws IOException {
        if (!t()) {
            if (this.f15744h == 1) {
                k();
            } else {
                Element element = this.f15745i;
                int f02 = f0(element.f15752a + 4 + element.f15753b);
                Y(f02, this.f15747k, 0, 4);
                int N = N(this.f15747k, 0);
                k0(this.f15743g, this.f15744h - 1, f02, this.f15746j.f15752a);
                this.f15744h--;
                this.f15745i = new Element(f02, N);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f15742f.close();
    }

    public int d0() {
        if (this.f15744h == 0) {
            return 16;
        }
        Element element = this.f15746j;
        int i8 = element.f15752a;
        int i9 = this.f15745i.f15752a;
        if (i8 >= i9) {
            return (i8 - i9) + 4 + element.f15753b + 16;
        }
        return (((i8 + 4) + element.f15753b) + this.f15743g) - i9;
    }

    public void h(byte[] bArr) throws IOException {
        j(bArr, 0, bArr.length);
    }

    public synchronized void j(byte[] bArr, int i8, int i9) throws IOException {
        int f02;
        int i10;
        w(bArr, "buffer");
        if ((i8 | i9) >= 0 && i9 <= bArr.length - i8) {
            l(i9);
            boolean t7 = t();
            if (t7) {
                f02 = 16;
            } else {
                Element element = this.f15746j;
                f02 = f0(element.f15752a + 4 + element.f15753b);
            }
            Element element2 = new Element(f02, i9);
            s0(this.f15747k, 0, i9);
            Z(element2.f15752a, this.f15747k, 0, 4);
            Z(element2.f15752a + 4, bArr, i8, i9);
            if (t7) {
                i10 = element2.f15752a;
            } else {
                i10 = this.f15745i.f15752a;
            }
            k0(this.f15743g, this.f15744h + 1, i10, element2.f15752a);
            this.f15746j = element2;
            this.f15744h++;
            if (t7) {
                this.f15745i = element2;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void k() throws IOException {
        k0(4096, 0, 0, 0);
        this.f15744h = 0;
        Element element = Element.f15751c;
        this.f15745i = element;
        this.f15746j = element;
        if (this.f15743g > 4096) {
            c0(4096);
        }
        this.f15743g = 4096;
    }

    public synchronized void m(ElementReader elementReader) throws IOException {
        int i8 = this.f15745i.f15752a;
        for (int i9 = 0; i9 < this.f15744h; i9++) {
            Element F = F(i8);
            elementReader.a(new ElementInputStream(F), F.f15753b);
            i8 = f0(F.f15752a + 4 + F.f15753b);
        }
    }

    public synchronized boolean t() {
        boolean z7;
        if (this.f15744h == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        return z7;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f15743g);
        sb.append(", size=");
        sb.append(this.f15744h);
        sb.append(", first=");
        sb.append(this.f15745i);
        sb.append(", last=");
        sb.append(this.f15746j);
        sb.append(", element lengths=[");
        try {
            m(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1

                /* renamed from: a  reason: collision with root package name */
                boolean f15748a = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void a(InputStream inputStream, int i8) throws IOException {
                    if (this.f15748a) {
                        this.f15748a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i8);
                }
            });
        } catch (IOException e8) {
            f15741l.log(Level.WARNING, "read error", (Throwable) e8);
        }
        sb.append("]]");
        return sb.toString();
    }
}
