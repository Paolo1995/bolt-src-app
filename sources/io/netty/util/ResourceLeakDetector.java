package io.netty.util;

import androidx.camera.view.e;
import androidx.concurrent.futures.a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes5.dex */
public class ResourceLeakDetector<T> {
    private static final Level DEFAULT_LEVEL;
    static final int SAMPLING_INTERVAL;
    private static final int TARGET_RECORDS;
    private static final AtomicReference<String[]> excludedMethods;
    private static Level level;
    private static final InternalLogger logger;
    private final Set<DefaultResourceLeak<?>> allLeaks;
    private final ReferenceQueue<Object> refQueue;
    private final Set<String> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class DefaultResourceLeak<T> extends WeakReference<Object> implements ResourceLeakTracker<T> {
        private final Set<DefaultResourceLeak<?>> allLeaks;
        private volatile int droppedRecords;
        private volatile Record head;
        private final int trackedHash;
        private static final AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, Record> headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, Record.class, "head");
        private static final AtomicIntegerFieldUpdater<DefaultResourceLeak<?>> droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");

        DefaultResourceLeak(Object obj, ReferenceQueue<Object> referenceQueue, Set<DefaultResourceLeak<?>> set) {
            super(obj, referenceQueue);
            this.trackedHash = System.identityHashCode(obj);
            set.add(this);
            headUpdater.set(this, new Record(Record.BOTTOM));
            this.allLeaks = set;
        }

        private static void reachabilityFence0(Object obj) {
            if (obj != null) {
                synchronized (obj) {
                }
            }
        }

        private void record0(Object obj) {
            AtomicReferenceFieldUpdater<DefaultResourceLeak<?>, Record> atomicReferenceFieldUpdater;
            Record record;
            boolean z7;
            Record record2;
            Record record3;
            if (ResourceLeakDetector.TARGET_RECORDS > 0) {
                do {
                    atomicReferenceFieldUpdater = headUpdater;
                    record = atomicReferenceFieldUpdater.get(this);
                    if (record == null) {
                        return;
                    }
                    boolean z8 = true;
                    int i8 = record.pos + 1;
                    z7 = false;
                    if (i8 >= ResourceLeakDetector.TARGET_RECORDS) {
                        if (PlatformDependent.threadLocalRandom().nextInt(1 << Math.min(i8 - ResourceLeakDetector.TARGET_RECORDS, 30)) == 0) {
                            z8 = false;
                        }
                        if (z8) {
                            record2 = record.next;
                        } else {
                            record2 = record;
                        }
                        z7 = z8;
                    } else {
                        record2 = record;
                    }
                    if (obj != null) {
                        record3 = new Record(record2, obj);
                    } else {
                        record3 = new Record(record2);
                    }
                } while (!a.a(atomicReferenceFieldUpdater, this, record, record3));
                if (z7) {
                    droppedRecordsUpdater.incrementAndGet(this);
                }
            }
        }

        public boolean close() {
            if (this.allLeaks.remove(this)) {
                clear();
                headUpdater.set(this, null);
                return true;
            }
            return false;
        }

        boolean dispose() {
            clear();
            return this.allLeaks.remove(this);
        }

        @Override // io.netty.util.ResourceLeakTracker
        public void record() {
            record0(null);
        }

        public String toString() {
            Record andSet = headUpdater.getAndSet(this, null);
            if (andSet == null) {
                return "";
            }
            int i8 = droppedRecordsUpdater.get(this);
            int i9 = 0;
            int i10 = 1;
            int i11 = andSet.pos + 1;
            StringBuilder sb = new StringBuilder(i11 * 2048);
            String str = StringUtil.NEWLINE;
            sb.append(str);
            sb.append("Recent access records: ");
            sb.append(str);
            HashSet hashSet = new HashSet(i11);
            while (andSet != Record.BOTTOM) {
                String record = andSet.toString();
                if (hashSet.add(record)) {
                    if (andSet.next == Record.BOTTOM) {
                        sb.append("Created at:");
                        sb.append(StringUtil.NEWLINE);
                        sb.append(record);
                    } else {
                        sb.append('#');
                        sb.append(i10);
                        sb.append(':');
                        sb.append(StringUtil.NEWLINE);
                        sb.append(record);
                        i10++;
                    }
                } else {
                    i9++;
                }
                andSet = andSet.next;
            }
            if (i9 > 0) {
                sb.append(": ");
                sb.append(i9);
                sb.append(" leak records were discarded because they were duplicates");
                sb.append(StringUtil.NEWLINE);
            }
            if (i8 > 0) {
                sb.append(": ");
                sb.append(i8);
                sb.append(" leak records were discarded because the leak record count is targeted to ");
                sb.append(ResourceLeakDetector.TARGET_RECORDS);
                sb.append(". Use system property ");
                sb.append("io.netty.leakDetection.targetRecords");
                sb.append(" to increase the limit.");
                sb.append(StringUtil.NEWLINE);
            }
            sb.setLength(sb.length() - StringUtil.NEWLINE.length());
            return sb.toString();
        }

        @Override // io.netty.util.ResourceLeakTracker
        public void record(Object obj) {
            record0(obj);
        }

        @Override // io.netty.util.ResourceLeakTracker
        public boolean close(T t7) {
            try {
                return close();
            } finally {
                reachabilityFence0(t7);
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        static Level parseLevel(String str) {
            Level[] values;
            String trim = str.trim();
            for (Level level : values()) {
                if (trim.equalsIgnoreCase(level.name()) || trim.equals(String.valueOf(level.ordinal()))) {
                    return level;
                }
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    static {
        Level level2 = Level.SIMPLE;
        DEFAULT_LEVEL = level2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ResourceLeakDetector.class);
        logger = internalLoggerFactory;
        boolean z7 = false;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z7 = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLoggerFactory.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z7));
            internalLoggerFactory.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", "io.netty.leakDetection.level", level2.name().toLowerCase());
        }
        if (z7) {
            level2 = Level.DISABLED;
        }
        Level parseLevel = Level.parseLevel(SystemPropertyUtil.get("io.netty.leakDetection.level", SystemPropertyUtil.get("io.netty.leakDetectionLevel", level2.name())));
        int i8 = SystemPropertyUtil.getInt("io.netty.leakDetection.targetRecords", 4);
        TARGET_RECORDS = i8;
        SAMPLING_INTERVAL = SystemPropertyUtil.getInt("io.netty.leakDetection.samplingInterval", 128);
        level = parseLevel;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.level", parseLevel.name().toLowerCase());
            internalLoggerFactory.debug("-D{}: {}", "io.netty.leakDetection.targetRecords", Integer.valueOf(i8));
        }
        excludedMethods = new AtomicReference<>(EmptyArrays.EMPTY_STRINGS);
    }

    @Deprecated
    public ResourceLeakDetector(Class<?> cls, int i8, long j8) {
        this(cls, i8);
    }

    public static void addExclusions(Class cls, String... strArr) {
        String[] strArr2;
        String[] strArr3;
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        for (int i8 = 0; i8 < length && (!hashSet.remove(declaredMethods[i8].getName()) || !hashSet.isEmpty()); i8++) {
        }
        if (hashSet.isEmpty()) {
            do {
                strArr2 = excludedMethods.get();
                strArr3 = (String[]) Arrays.copyOf(strArr2, strArr2.length + (strArr.length * 2));
                for (int i9 = 0; i9 < strArr.length; i9++) {
                    int i10 = i9 * 2;
                    strArr3[strArr2.length + i10] = cls.getName();
                    strArr3[strArr2.length + i10 + 1] = strArr[i9];
                }
            } while (!e.a(excludedMethods, strArr2, strArr3));
            return;
        }
        throw new IllegalArgumentException("Can't find '" + hashSet + "' in " + cls.getName());
    }

    private void clearRefQueue() {
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            defaultResourceLeak.dispose();
        }
    }

    public static Level getLevel() {
        return level;
    }

    public static boolean isEnabled() {
        if (getLevel().ordinal() > Level.DISABLED.ordinal()) {
            return true;
        }
        return false;
    }

    private void reportLeak() {
        if (!needReport()) {
            clearRefQueue();
            return;
        }
        while (true) {
            DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
            if (defaultResourceLeak == null) {
                return;
            }
            if (defaultResourceLeak.dispose()) {
                String defaultResourceLeak2 = defaultResourceLeak.toString();
                if (this.reportedLeaks.add(defaultResourceLeak2)) {
                    if (defaultResourceLeak2.isEmpty()) {
                        reportUntracedLeak(this.resourceType);
                    } else {
                        reportTracedLeak(this.resourceType, defaultResourceLeak2);
                    }
                }
            }
        }
    }

    private DefaultResourceLeak track0(T t7) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() < Level.PARANOID.ordinal()) {
            if (PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) != 0) {
                return null;
            }
            reportLeak();
            return new DefaultResourceLeak(t7, this.refQueue, this.allLeaks);
        }
        reportLeak();
        return new DefaultResourceLeak(t7, this.refQueue, this.allLeaks);
    }

    protected boolean needReport() {
        return logger.isErrorEnabled();
    }

    protected void reportTracedLeak(String str, String str2) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", str, str2);
    }

    protected void reportUntracedLeak(String str) {
        logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", str, "io.netty.leakDetection.level", Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
    }

    public final ResourceLeakTracker<T> track(T t7) {
        return track0(t7);
    }

    public ResourceLeakDetector(Class<?> cls, int i8) {
        this(StringUtil.simpleClassName(cls), i8, Long.MAX_VALUE);
    }

    @Deprecated
    public ResourceLeakDetector(String str, int i8, long j8) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.resourceType = (String) ObjectUtil.checkNotNull(str, "resourceType");
        this.samplingInterval = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Record extends Throwable {
        private static final Record BOTTOM = new Record();
        private final String hintString;
        private final Record next;
        private final int pos;

        Record(Record record, Object obj) {
            this.hintString = obj instanceof ResourceLeakHint ? ((ResourceLeakHint) obj).toHintString() : obj.toString();
            this.next = record;
            this.pos = record.pos + 1;
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder(2048);
            if (this.hintString != null) {
                sb.append("\tHint: ");
                sb.append(this.hintString);
                sb.append(StringUtil.NEWLINE);
            }
            StackTraceElement[] stackTrace = getStackTrace();
            for (int i8 = 3; i8 < stackTrace.length; i8++) {
                StackTraceElement stackTraceElement = stackTrace[i8];
                String[] strArr = (String[]) ResourceLeakDetector.excludedMethods.get();
                int i9 = 0;
                while (true) {
                    if (i9 < strArr.length) {
                        if (!strArr[i9].equals(stackTraceElement.getClassName()) || !strArr[i9 + 1].equals(stackTraceElement.getMethodName())) {
                            i9 += 2;
                        }
                    } else {
                        sb.append('\t');
                        sb.append(stackTraceElement.toString());
                        sb.append(StringUtil.NEWLINE);
                        break;
                    }
                }
            }
            return sb.toString();
        }

        Record(Record record) {
            this.hintString = null;
            this.next = record;
            this.pos = record.pos + 1;
        }

        private Record() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }
    }
}
