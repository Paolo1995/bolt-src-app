package androidx.room.util;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class CopyLock {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Lock> f7662e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final File f7663a;

    /* renamed from: b  reason: collision with root package name */
    private final Lock f7664b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7665c;

    /* renamed from: d  reason: collision with root package name */
    private FileChannel f7666d;

    public CopyLock(@NonNull String str, @NonNull File file, boolean z7) {
        File file2 = new File(file, str + ".lck");
        this.f7663a = file2;
        this.f7664b = a(file2.getAbsolutePath());
        this.f7665c = z7;
    }

    private static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = f7662e;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f7664b.lock();
        if (this.f7665c) {
            try {
                FileChannel channel = new FileOutputStream(this.f7663a).getChannel();
                this.f7666d = channel;
                channel.lock();
            } catch (IOException e8) {
                throw new IllegalStateException("Unable to grab copy lock.", e8);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f7666d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f7664b.unlock();
    }
}
