package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class DiskCacheWriteLocker {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WriteLock> f10233a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final WriteLockPool f10234b = new WriteLockPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WriteLock {

        /* renamed from: a  reason: collision with root package name */
        final Lock f10235a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f10236b;

        WriteLock() {
        }
    }

    /* loaded from: classes.dex */
    private static class WriteLockPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<WriteLock> f10237a = new ArrayDeque();

        WriteLockPool() {
        }

        WriteLock a() {
            WriteLock poll;
            synchronized (this.f10237a) {
                poll = this.f10237a.poll();
            }
            if (poll == null) {
                return new WriteLock();
            }
            return poll;
        }

        void b(WriteLock writeLock) {
            synchronized (this.f10237a) {
                if (this.f10237a.size() < 10) {
                    this.f10237a.offer(writeLock);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = this.f10233a.get(str);
            if (writeLock == null) {
                writeLock = this.f10234b.a();
                this.f10233a.put(str, writeLock);
            }
            writeLock.f10236b++;
        }
        writeLock.f10235a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.d(this.f10233a.get(str));
            int i8 = writeLock.f10236b;
            if (i8 >= 1) {
                int i9 = i8 - 1;
                writeLock.f10236b = i9;
                if (i9 == 0) {
                    WriteLock remove = this.f10233a.remove(str);
                    if (remove.equals(writeLock)) {
                        this.f10234b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.f10236b);
            }
        }
        writeLock.f10235a.unlock();
    }
}
