package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class CrashlyticsReport {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f16110a = Charset.forName("UTF-8");

    /* loaded from: classes3.dex */
    public static abstract class ApplicationExitInfo {

        /* loaded from: classes3.dex */
        public static abstract class Builder {
            @NonNull
            public abstract ApplicationExitInfo a();

            @NonNull
            public abstract Builder b(@NonNull int i8);

            @NonNull
            public abstract Builder c(@NonNull int i8);

            @NonNull
            public abstract Builder d(@NonNull String str);

            @NonNull
            public abstract Builder e(@NonNull long j8);

            @NonNull
            public abstract Builder f(@NonNull int i8);

            @NonNull
            public abstract Builder g(@NonNull long j8);

            @NonNull
            public abstract Builder h(@NonNull long j8);

            @NonNull
            public abstract Builder i(String str);
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
        }

        @NonNull
        public abstract int b();

        @NonNull
        public abstract int c();

        @NonNull
        public abstract String d();

        @NonNull
        public abstract long e();

        @NonNull
        public abstract int f();

        @NonNull
        public abstract long g();

        @NonNull
        public abstract long h();

        public abstract String i();
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        @NonNull
        public abstract CrashlyticsReport a();

        @NonNull
        public abstract Builder b(@NonNull String str);

        @NonNull
        public abstract Builder c(@NonNull String str);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(@NonNull String str);

        @NonNull
        public abstract Builder f(FilesPayload filesPayload);

        @NonNull
        public abstract Builder g(int i8);

        @NonNull
        public abstract Builder h(@NonNull String str);

        @NonNull
        public abstract Builder i(@NonNull Session session);
    }

    /* loaded from: classes3.dex */
    public static abstract class CustomAttribute {

        /* loaded from: classes3.dex */
        public static abstract class Builder {
            @NonNull
            public abstract CustomAttribute a();

            @NonNull
            public abstract Builder b(@NonNull String str);

            @NonNull
            public abstract Builder c(@NonNull String str);
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
        }

        @NonNull
        public abstract String b();

        @NonNull
        public abstract String c();
    }

    /* loaded from: classes3.dex */
    public static abstract class FilesPayload {

        /* loaded from: classes3.dex */
        public static abstract class Builder {
            public abstract FilesPayload a();

            public abstract Builder b(ImmutableList<File> immutableList);

            public abstract Builder c(String str);
        }

        /* loaded from: classes3.dex */
        public static abstract class File {

            /* loaded from: classes3.dex */
            public static abstract class Builder {
                public abstract File a();

                public abstract Builder b(byte[] bArr);

                public abstract Builder c(String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
            }

            @NonNull
            public abstract byte[] b();

            @NonNull
            public abstract String c();
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
        }

        @NonNull
        public abstract ImmutableList<File> b();

        public abstract String c();
    }

    /* loaded from: classes3.dex */
    public static abstract class Session {

        /* loaded from: classes3.dex */
        public static abstract class Application {

            /* loaded from: classes3.dex */
            public static abstract class Builder {
                @NonNull
                public abstract Application a();

                @NonNull
                public abstract Builder b(String str);

                @NonNull
                public abstract Builder c(String str);

                @NonNull
                public abstract Builder d(@NonNull String str);

                @NonNull
                public abstract Builder e(@NonNull String str);

                @NonNull
                public abstract Builder f(@NonNull String str);

                @NonNull
                public abstract Builder g(@NonNull String str);
            }

            /* loaded from: classes3.dex */
            public static abstract class Organization {
                @NonNull
                public abstract String a();
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Application.Builder();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();

            @NonNull
            public abstract String e();

            public abstract String f();

            public abstract Organization g();

            @NonNull
            public abstract String h();
        }

        /* loaded from: classes3.dex */
        public static abstract class Builder {
            @NonNull
            public abstract Session a();

            @NonNull
            public abstract Builder b(@NonNull Application application);

            @NonNull
            public abstract Builder c(boolean z7);

            @NonNull
            public abstract Builder d(@NonNull Device device);

            @NonNull
            public abstract Builder e(@NonNull Long l8);

            @NonNull
            public abstract Builder f(@NonNull ImmutableList<Event> immutableList);

            @NonNull
            public abstract Builder g(@NonNull String str);

            @NonNull
            public abstract Builder h(int i8);

            @NonNull
            public abstract Builder i(@NonNull String str);

            @NonNull
            public Builder j(@NonNull byte[] bArr) {
                return i(new String(bArr, CrashlyticsReport.f16110a));
            }

            @NonNull
            public abstract Builder k(@NonNull OperatingSystem operatingSystem);

            @NonNull
            public abstract Builder l(long j8);

            @NonNull
            public abstract Builder m(@NonNull User user);
        }

        /* loaded from: classes3.dex */
        public static abstract class Device {

            /* loaded from: classes3.dex */
            public static abstract class Builder {
                @NonNull
                public abstract Device a();

                @NonNull
                public abstract Builder b(int i8);

                @NonNull
                public abstract Builder c(int i8);

                @NonNull
                public abstract Builder d(long j8);

                @NonNull
                public abstract Builder e(@NonNull String str);

                @NonNull
                public abstract Builder f(@NonNull String str);

                @NonNull
                public abstract Builder g(@NonNull String str);

                @NonNull
                public abstract Builder h(long j8);

                @NonNull
                public abstract Builder i(boolean z7);

                @NonNull
                public abstract Builder j(int i8);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Device.Builder();
            }

            @NonNull
            public abstract int b();

            public abstract int c();

            public abstract long d();

            @NonNull
            public abstract String e();

            @NonNull
            public abstract String f();

            @NonNull
            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        /* loaded from: classes3.dex */
        public static abstract class Event {

            /* loaded from: classes3.dex */
            public static abstract class Application {

                /* loaded from: classes3.dex */
                public static abstract class Builder {
                    @NonNull
                    public abstract Application a();

                    @NonNull
                    public abstract Builder b(Boolean bool);

                    @NonNull
                    public abstract Builder c(@NonNull ImmutableList<CustomAttribute> immutableList);

                    @NonNull
                    public abstract Builder d(@NonNull Execution execution);

                    @NonNull
                    public abstract Builder e(@NonNull ImmutableList<CustomAttribute> immutableList);

                    @NonNull
                    public abstract Builder f(int i8);
                }

                /* loaded from: classes3.dex */
                public static abstract class Execution {

                    /* loaded from: classes3.dex */
                    public static abstract class BinaryImage {

                        /* loaded from: classes3.dex */
                        public static abstract class Builder {
                            @NonNull
                            public abstract BinaryImage a();

                            @NonNull
                            public abstract Builder b(long j8);

                            @NonNull
                            public abstract Builder c(@NonNull String str);

                            @NonNull
                            public abstract Builder d(long j8);

                            @NonNull
                            public abstract Builder e(String str);

                            @NonNull
                            public Builder f(@NonNull byte[] bArr) {
                                return e(new String(bArr, CrashlyticsReport.f16110a));
                            }
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
                        }

                        @NonNull
                        public abstract long b();

                        @NonNull
                        public abstract String c();

                        public abstract long d();

                        public abstract String e();

                        public byte[] f() {
                            String e8 = e();
                            if (e8 != null) {
                                return e8.getBytes(CrashlyticsReport.f16110a);
                            }
                            return null;
                        }
                    }

                    /* loaded from: classes3.dex */
                    public static abstract class Builder {
                        @NonNull
                        public abstract Execution a();

                        @NonNull
                        public abstract Builder b(@NonNull ApplicationExitInfo applicationExitInfo);

                        @NonNull
                        public abstract Builder c(@NonNull ImmutableList<BinaryImage> immutableList);

                        @NonNull
                        public abstract Builder d(@NonNull Exception exception);

                        @NonNull
                        public abstract Builder e(@NonNull Signal signal);

                        @NonNull
                        public abstract Builder f(@NonNull ImmutableList<Thread> immutableList);
                    }

                    /* loaded from: classes3.dex */
                    public static abstract class Exception {

                        /* loaded from: classes3.dex */
                        public static abstract class Builder {
                            @NonNull
                            public abstract Exception a();

                            @NonNull
                            public abstract Builder b(@NonNull Exception exception);

                            @NonNull
                            public abstract Builder c(@NonNull ImmutableList<Thread.Frame> immutableList);

                            @NonNull
                            public abstract Builder d(int i8);

                            @NonNull
                            public abstract Builder e(@NonNull String str);

                            @NonNull
                            public abstract Builder f(@NonNull String str);
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
                        }

                        public abstract Exception b();

                        @NonNull
                        public abstract ImmutableList<Thread.Frame> c();

                        public abstract int d();

                        public abstract String e();

                        @NonNull
                        public abstract String f();
                    }

                    /* loaded from: classes3.dex */
                    public static abstract class Signal {

                        /* loaded from: classes3.dex */
                        public static abstract class Builder {
                            @NonNull
                            public abstract Signal a();

                            @NonNull
                            public abstract Builder b(long j8);

                            @NonNull
                            public abstract Builder c(@NonNull String str);

                            @NonNull
                            public abstract Builder d(@NonNull String str);
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
                        }

                        @NonNull
                        public abstract long b();

                        @NonNull
                        public abstract String c();

                        @NonNull
                        public abstract String d();
                    }

                    /* loaded from: classes3.dex */
                    public static abstract class Thread {

                        /* loaded from: classes3.dex */
                        public static abstract class Builder {
                            @NonNull
                            public abstract Thread a();

                            @NonNull
                            public abstract Builder b(@NonNull ImmutableList<Frame> immutableList);

                            @NonNull
                            public abstract Builder c(int i8);

                            @NonNull
                            public abstract Builder d(@NonNull String str);
                        }

                        /* loaded from: classes3.dex */
                        public static abstract class Frame {

                            /* loaded from: classes3.dex */
                            public static abstract class Builder {
                                @NonNull
                                public abstract Frame a();

                                @NonNull
                                public abstract Builder b(@NonNull String str);

                                @NonNull
                                public abstract Builder c(int i8);

                                @NonNull
                                public abstract Builder d(long j8);

                                @NonNull
                                public abstract Builder e(long j8);

                                @NonNull
                                public abstract Builder f(@NonNull String str);
                            }

                            @NonNull
                            public static Builder a() {
                                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
                            }

                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            @NonNull
                            public abstract String f();
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
                        }

                        @NonNull
                        public abstract ImmutableList<Frame> b();

                        public abstract int c();

                        @NonNull
                        public abstract String d();
                    }

                    @NonNull
                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
                    }

                    public abstract ApplicationExitInfo b();

                    @NonNull
                    public abstract ImmutableList<BinaryImage> c();

                    public abstract Exception d();

                    @NonNull
                    public abstract Signal e();

                    public abstract ImmutableList<Thread> f();
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
                }

                public abstract Boolean b();

                public abstract ImmutableList<CustomAttribute> c();

                @NonNull
                public abstract Execution d();

                public abstract ImmutableList<CustomAttribute> e();

                public abstract int f();

                @NonNull
                public abstract Builder g();
            }

            /* loaded from: classes3.dex */
            public static abstract class Builder {
                @NonNull
                public abstract Event a();

                @NonNull
                public abstract Builder b(@NonNull Application application);

                @NonNull
                public abstract Builder c(@NonNull Device device);

                @NonNull
                public abstract Builder d(@NonNull Log log);

                @NonNull
                public abstract Builder e(long j8);

                @NonNull
                public abstract Builder f(@NonNull String str);
            }

            /* loaded from: classes3.dex */
            public static abstract class Device {

                /* loaded from: classes3.dex */
                public static abstract class Builder {
                    @NonNull
                    public abstract Device a();

                    @NonNull
                    public abstract Builder b(Double d8);

                    @NonNull
                    public abstract Builder c(int i8);

                    @NonNull
                    public abstract Builder d(long j8);

                    @NonNull
                    public abstract Builder e(int i8);

                    @NonNull
                    public abstract Builder f(boolean z7);

                    @NonNull
                    public abstract Builder g(long j8);
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                }

                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            /* loaded from: classes3.dex */
            public static abstract class Log {

                /* loaded from: classes3.dex */
                public static abstract class Builder {
                    @NonNull
                    public abstract Log a();

                    @NonNull
                    public abstract Builder b(@NonNull String str);
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
                }

                @NonNull
                public abstract String b();
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Event.Builder();
            }

            @NonNull
            public abstract Application b();

            @NonNull
            public abstract Device c();

            public abstract Log d();

            public abstract long e();

            @NonNull
            public abstract String f();

            @NonNull
            public abstract Builder g();
        }

        /* loaded from: classes3.dex */
        public static abstract class OperatingSystem {

            /* loaded from: classes3.dex */
            public static abstract class Builder {
                @NonNull
                public abstract OperatingSystem a();

                @NonNull
                public abstract Builder b(@NonNull String str);

                @NonNull
                public abstract Builder c(boolean z7);

                @NonNull
                public abstract Builder d(int i8);

                @NonNull
                public abstract Builder e(@NonNull String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
            }

            @NonNull
            public abstract String b();

            public abstract int c();

            @NonNull
            public abstract String d();

            public abstract boolean e();
        }

        /* loaded from: classes3.dex */
        public static abstract class User {

            /* loaded from: classes3.dex */
            public static abstract class Builder {
                @NonNull
                public abstract User a();

                @NonNull
                public abstract Builder b(@NonNull String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_User.Builder();
            }

            @NonNull
            public abstract String b();
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_Session.Builder().c(false);
        }

        @NonNull
        public abstract Application b();

        public abstract Device c();

        public abstract Long d();

        public abstract ImmutableList<Event> e();

        @NonNull
        public abstract String f();

        public abstract int g();

        @NonNull
        public abstract String h();

        @NonNull
        public byte[] i() {
            return h().getBytes(CrashlyticsReport.f16110a);
        }

        public abstract OperatingSystem j();

        public abstract long k();

        public abstract User l();

        public abstract boolean m();

        @NonNull
        public abstract Builder n();

        @NonNull
        Session o(@NonNull ImmutableList<Event> immutableList) {
            return n().f(immutableList).a();
        }

        @NonNull
        Session p(long j8, boolean z7, String str) {
            Builder n8 = n();
            n8.e(Long.valueOf(j8));
            n8.c(z7);
            if (str != null) {
                n8.m(User.a().b(str).a());
            }
            return n8.a();
        }
    }

    @NonNull
    public static Builder b() {
        return new AutoValue_CrashlyticsReport.Builder();
    }

    @NonNull
    public abstract String c();

    @NonNull
    public abstract String d();

    @NonNull
    public abstract String e();

    @NonNull
    public abstract String f();

    public abstract FilesPayload g();

    public abstract int h();

    @NonNull
    public abstract String i();

    public abstract Session j();

    @NonNull
    protected abstract Builder k();

    @NonNull
    public CrashlyticsReport l(@NonNull ImmutableList<Session.Event> immutableList) {
        if (j() != null) {
            return k().i(j().o(immutableList)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    @NonNull
    public CrashlyticsReport m(@NonNull FilesPayload filesPayload) {
        return k().i(null).f(filesPayload).a();
    }

    @NonNull
    public CrashlyticsReport n(long j8, boolean z7, String str) {
        Builder k8 = k();
        if (j() != null) {
            k8.i(j().p(j8, z7, str));
        }
        return k8.a();
    }
}
