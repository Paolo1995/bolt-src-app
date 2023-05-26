package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

/* loaded from: classes5.dex */
public final class LoggerFactory {

    /* renamed from: a  reason: collision with root package name */
    static volatile int f52812a;

    /* renamed from: b  reason: collision with root package name */
    static final SubstituteLoggerFactory f52813b = new SubstituteLoggerFactory();

    /* renamed from: c  reason: collision with root package name */
    static final NOPLoggerFactory f52814c = new NOPLoggerFactory();

    /* renamed from: d  reason: collision with root package name */
    static boolean f52815d = Util.f("slf4j.detectLoggerNameMismatch");

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f52816e = {"1.6", "1.7"};

    /* renamed from: f  reason: collision with root package name */
    private static String f52817f = "org/slf4j/impl/StaticLoggerBinder.class";

    private LoggerFactory() {
    }

    private static final void a() {
        Set<URL> set = null;
        try {
            try {
                if (!l()) {
                    set = f();
                    t(set);
                }
                StaticLoggerBinder.getSingleton();
                f52812a = 3;
                s(set);
            } catch (Exception e8) {
                e(e8);
                throw new IllegalStateException("Unexpected initialization failure", e8);
            } catch (NoClassDefFoundError e9) {
                if (m(e9.getMessage())) {
                    f52812a = 4;
                    Util.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                    Util.c("Defaulting to no-operation (NOP) logger implementation");
                    Util.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                } else {
                    e(e9);
                    throw e9;
                }
            } catch (NoSuchMethodError e10) {
                String message = e10.getMessage();
                if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    f52812a = 2;
                    Util.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    Util.c("Your binding is version 1.5.5 or earlier.");
                    Util.c("Upgrade your binding to version 1.6.x.");
                }
                throw e10;
            }
        } finally {
            p();
        }
    }

    private static void b(SubstituteLoggingEvent substituteLoggingEvent, int i8) {
        if (substituteLoggingEvent.a().d()) {
            c(i8);
        } else if (!substituteLoggingEvent.a().e()) {
            d();
        }
    }

    private static void c(int i8) {
        Util.c("A number (" + i8 + ") of logging calls during the initialization phase have been intercepted and are");
        Util.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Util.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        Util.c("The following set of substitute loggers may have been accessed");
        Util.c("during the initialization phase. Logging calls during this");
        Util.c("phase were not honored. However, subsequent logging calls to these");
        Util.c("loggers will work as normally expected.");
        Util.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        f52812a = 2;
        Util.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set<URL> f() {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f52817f);
            } else {
                resources = classLoader.getResources(f52817f);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e8) {
            Util.d("Error getting resources from path", e8);
        }
        return linkedHashSet;
    }

    private static void g() {
        SubstituteLoggerFactory substituteLoggerFactory = f52813b;
        synchronized (substituteLoggerFactory) {
            substituteLoggerFactory.e();
            for (SubstituteLogger substituteLogger : substituteLoggerFactory.d()) {
                substituteLogger.h(j(substituteLogger.getName()));
            }
        }
    }

    public static ILoggerFactory h() {
        if (f52812a == 0) {
            synchronized (LoggerFactory.class) {
                if (f52812a == 0) {
                    f52812a = 1;
                    o();
                }
            }
        }
        int i8 = f52812a;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return f52814c;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return StaticLoggerBinder.getSingleton().getLoggerFactory();
            }
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        return f52813b;
    }

    public static Logger i(Class<?> cls) {
        Class<?> a8;
        Logger j8 = j(cls.getName());
        if (f52815d && (a8 = Util.a()) != null && n(cls, a8)) {
            Util.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", j8.getName(), a8.getName()));
            Util.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return j8;
    }

    public static Logger j(String str) {
        return h().a(str);
    }

    private static boolean k(Set<URL> set) {
        if (set.size() > 1) {
            return true;
        }
        return false;
    }

    private static boolean l() {
        String g8 = Util.g("java.vendor.url");
        if (g8 == null) {
            return false;
        }
        return g8.toLowerCase().contains("android");
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        if (!str.contains("org/slf4j/impl/StaticLoggerBinder") && !str.contains("org.slf4j.impl.StaticLoggerBinder")) {
            return false;
        }
        return true;
    }

    private static boolean n(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void o() {
        a();
        if (f52812a == 3) {
            u();
        }
    }

    private static void p() {
        g();
        q();
        f52813b.b();
    }

    private static void q() {
        LinkedBlockingQueue<SubstituteLoggingEvent> c8 = f52813b.c();
        int size = c8.size();
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList(128);
        int i8 = 0;
        while (c8.drainTo(arrayList, 128) != 0) {
            for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
                r(substituteLoggingEvent);
                int i9 = i8 + 1;
                if (i8 == 0) {
                    b(substituteLoggingEvent, size);
                }
                i8 = i9;
            }
            arrayList.clear();
        }
    }

    private static void r(SubstituteLoggingEvent substituteLoggingEvent) {
        if (substituteLoggingEvent == null) {
            return;
        }
        SubstituteLogger a8 = substituteLoggingEvent.a();
        String name = a8.getName();
        if (!a8.f()) {
            if (!a8.e()) {
                if (a8.d()) {
                    a8.g(substituteLoggingEvent);
                    return;
                } else {
                    Util.c(name);
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    }

    private static void s(Set<URL> set) {
        if (set != null && k(set)) {
            Util.c("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
        }
    }

    private static void t(Set<URL> set) {
        if (k(set)) {
            Util.c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                Util.c("Found binding in [" + it.next() + "]");
            }
            Util.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void u() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z7 = false;
            for (String str2 : f52816e) {
                if (str.startsWith(str2)) {
                    z7 = true;
                }
            }
            if (!z7) {
                Util.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f52816e).toString());
                Util.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            Util.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
