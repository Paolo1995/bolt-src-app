package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.metadata.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes3.dex */
class QueueFileLogStore implements FileLogStore {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f15757d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final File f15758a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15759b;

    /* renamed from: c  reason: collision with root package name */
    private QueueFile f15760c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class LogBytes {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f15764a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15765b;

        LogBytes(byte[] bArr, int i8) {
            this.f15764a = bArr;
            this.f15765b = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueueFileLogStore(File file, int i8) {
        this.f15758a = file;
        this.f15759b = i8;
    }

    private void f(long j8, String str) {
        int i8;
        if (this.f15760c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > this.f15759b / 4) {
                str = "..." + str.substring(str.length() - i8);
            }
            this.f15760c.h(String.format(Locale.US, "%d %s%n", Long.valueOf(j8), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f15757d));
            while (!this.f15760c.t() && this.f15760c.d0() > this.f15759b) {
                this.f15760c.X();
            }
        } catch (IOException e8) {
            Logger.f().e("There was a problem writing to the Crashlytics log.", e8);
        }
    }

    private LogBytes g() {
        if (!this.f15758a.exists()) {
            return null;
        }
        h();
        QueueFile queueFile = this.f15760c;
        if (queueFile == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[queueFile.d0()];
        try {
            this.f15760c.m(new QueueFile.ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.1
                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void a(InputStream inputStream, int i8) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i8);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i8;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e8) {
            Logger.f().e("A problem occurred while reading the Crashlytics log file.", e8);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void h() {
        if (this.f15760c == null) {
            try {
                this.f15760c = new QueueFile(this.f15758a);
            } catch (IOException e8) {
                Logger f8 = Logger.f();
                f8.e("Could not open log file: " + this.f15758a, e8);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void a() {
        CommonUtils.e(this.f15760c, "There was a problem closing the Crashlytics log file.");
        this.f15760c = null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public String b() {
        byte[] c8 = c();
        if (c8 != null) {
            return new String(c8, f15757d);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public byte[] c() {
        LogBytes g8 = g();
        if (g8 == null) {
            return null;
        }
        int i8 = g8.f15765b;
        byte[] bArr = new byte[i8];
        System.arraycopy(g8.f15764a, 0, bArr, 0, i8);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void d() {
        a();
        this.f15758a.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void e(long j8, String str) {
        h();
        f(j8, str);
    }
}
