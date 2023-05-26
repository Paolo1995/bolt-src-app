package com.google.firebase.crashlytics.internal.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f15777a = new AutoCrashlyticsReportEncoder();

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoEncoder f15778a = new CrashlyticsReportApplicationExitInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15779b = FieldDescriptor.d("pid");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15780c = FieldDescriptor.d("processName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15781d = FieldDescriptor.d("reasonCode");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15782e = FieldDescriptor.d("importance");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15783f = FieldDescriptor.d("pss");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f15784g = FieldDescriptor.d("rss");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f15785h = FieldDescriptor.d("timestamp");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f15786i = FieldDescriptor.d("traceFile");

        private CrashlyticsReportApplicationExitInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.ApplicationExitInfo applicationExitInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f15779b, applicationExitInfo.c());
            objectEncoderContext.f(f15780c, applicationExitInfo.d());
            objectEncoderContext.c(f15781d, applicationExitInfo.f());
            objectEncoderContext.c(f15782e, applicationExitInfo.b());
            objectEncoderContext.b(f15783f, applicationExitInfo.e());
            objectEncoderContext.b(f15784g, applicationExitInfo.g());
            objectEncoderContext.b(f15785h, applicationExitInfo.h());
            objectEncoderContext.f(f15786i, applicationExitInfo.i());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportCustomAttributeEncoder f15787a = new CrashlyticsReportCustomAttributeEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15788b = FieldDescriptor.d("key");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15789c = FieldDescriptor.d(AppMeasurementSdk.ConditionalUserProperty.VALUE);

        private CrashlyticsReportCustomAttributeEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.CustomAttribute customAttribute, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15788b, customAttribute.b());
            objectEncoderContext.f(f15789c, customAttribute.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportEncoder f15790a = new CrashlyticsReportEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15791b = FieldDescriptor.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15792c = FieldDescriptor.d("gmpAppId");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15793d = FieldDescriptor.d("platform");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15794e = FieldDescriptor.d("installationUuid");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15795f = FieldDescriptor.d("buildVersion");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f15796g = FieldDescriptor.d("displayVersion");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f15797h = FieldDescriptor.d("session");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f15798i = FieldDescriptor.d("ndkPayload");

        private CrashlyticsReportEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15791b, crashlyticsReport.i());
            objectEncoderContext.f(f15792c, crashlyticsReport.e());
            objectEncoderContext.c(f15793d, crashlyticsReport.h());
            objectEncoderContext.f(f15794e, crashlyticsReport.f());
            objectEncoderContext.f(f15795f, crashlyticsReport.c());
            objectEncoderContext.f(f15796g, crashlyticsReport.d());
            objectEncoderContext.f(f15797h, crashlyticsReport.j());
            objectEncoderContext.f(f15798i, crashlyticsReport.g());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadEncoder f15799a = new CrashlyticsReportFilesPayloadEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15800b = FieldDescriptor.d("files");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15801c = FieldDescriptor.d("orgId");

        private CrashlyticsReportFilesPayloadEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.FilesPayload filesPayload, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15800b, filesPayload.b());
            objectEncoderContext.f(f15801c, filesPayload.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadFileEncoder f15802a = new CrashlyticsReportFilesPayloadFileEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15803b = FieldDescriptor.d("filename");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15804c = FieldDescriptor.d("contents");

        private CrashlyticsReportFilesPayloadFileEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.FilesPayload.File file, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15803b, file.c());
            objectEncoderContext.f(f15804c, file.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationEncoder f15805a = new CrashlyticsReportSessionApplicationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15806b = FieldDescriptor.d("identifier");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15807c = FieldDescriptor.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15808d = FieldDescriptor.d("displayVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15809e = FieldDescriptor.d("organization");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15810f = FieldDescriptor.d("installationUuid");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f15811g = FieldDescriptor.d("developmentPlatform");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f15812h = FieldDescriptor.d("developmentPlatformVersion");

        private CrashlyticsReportSessionApplicationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15806b, application.e());
            objectEncoderContext.f(f15807c, application.h());
            objectEncoderContext.f(f15808d, application.d());
            objectEncoderContext.f(f15809e, application.g());
            objectEncoderContext.f(f15810f, application.f());
            objectEncoderContext.f(f15811g, application.b());
            objectEncoderContext.f(f15812h, application.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationOrganizationEncoder f15813a = new CrashlyticsReportSessionApplicationOrganizationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15814b = FieldDescriptor.d("clsId");

        private CrashlyticsReportSessionApplicationOrganizationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Application.Organization organization, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15814b, organization.a());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionDeviceEncoder f15815a = new CrashlyticsReportSessionDeviceEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15816b = FieldDescriptor.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15817c = FieldDescriptor.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15818d = FieldDescriptor.d("cores");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15819e = FieldDescriptor.d("ram");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15820f = FieldDescriptor.d("diskSpace");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f15821g = FieldDescriptor.d("simulator");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f15822h = FieldDescriptor.d("state");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f15823i = FieldDescriptor.d("manufacturer");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f15824j = FieldDescriptor.d("modelClass");

        private CrashlyticsReportSessionDeviceEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f15816b, device.b());
            objectEncoderContext.f(f15817c, device.f());
            objectEncoderContext.c(f15818d, device.c());
            objectEncoderContext.b(f15819e, device.h());
            objectEncoderContext.b(f15820f, device.d());
            objectEncoderContext.a(f15821g, device.j());
            objectEncoderContext.c(f15822h, device.i());
            objectEncoderContext.f(f15823i, device.e());
            objectEncoderContext.f(f15824j, device.g());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEncoder f15825a = new CrashlyticsReportSessionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15826b = FieldDescriptor.d("generator");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15827c = FieldDescriptor.d("identifier");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15828d = FieldDescriptor.d("startedAt");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15829e = FieldDescriptor.d("endedAt");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15830f = FieldDescriptor.d("crashed");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f15831g = FieldDescriptor.d("app");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f15832h = FieldDescriptor.d("user");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f15833i = FieldDescriptor.d("os");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f15834j = FieldDescriptor.d("device");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f15835k = FieldDescriptor.d("events");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f15836l = FieldDescriptor.d("generatorType");

        private CrashlyticsReportSessionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session session, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15826b, session.f());
            objectEncoderContext.f(f15827c, session.i());
            objectEncoderContext.b(f15828d, session.k());
            objectEncoderContext.f(f15829e, session.d());
            objectEncoderContext.a(f15830f, session.m());
            objectEncoderContext.f(f15831g, session.b());
            objectEncoderContext.f(f15832h, session.l());
            objectEncoderContext.f(f15833i, session.j());
            objectEncoderContext.f(f15834j, session.c());
            objectEncoderContext.f(f15835k, session.e());
            objectEncoderContext.c(f15836l, session.g());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationEncoder f15837a = new CrashlyticsReportSessionEventApplicationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15838b = FieldDescriptor.d("execution");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15839c = FieldDescriptor.d("customAttributes");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15840d = FieldDescriptor.d("internalKeys");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15841e = FieldDescriptor.d("background");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15842f = FieldDescriptor.d("uiOrientation");

        private CrashlyticsReportSessionEventApplicationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15838b, application.d());
            objectEncoderContext.f(f15839c, application.c());
            objectEncoderContext.f(f15840d, application.e());
            objectEncoderContext.f(f15841e, application.b());
            objectEncoderContext.c(f15842f, application.f());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder f15843a = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15844b = FieldDescriptor.d("baseAddress");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15845c = FieldDescriptor.d("size");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15846d = FieldDescriptor.d("name");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15847e = FieldDescriptor.d("uuid");

        private CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f15844b, binaryImage.b());
            objectEncoderContext.b(f15845c, binaryImage.d());
            objectEncoderContext.f(f15846d, binaryImage.c());
            objectEncoderContext.f(f15847e, binaryImage.f());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionEncoder f15848a = new CrashlyticsReportSessionEventApplicationExecutionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15849b = FieldDescriptor.d("threads");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15850c = FieldDescriptor.d("exception");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15851d = FieldDescriptor.d("appExitInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15852e = FieldDescriptor.d("signal");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15853f = FieldDescriptor.d("binaries");

        private CrashlyticsReportSessionEventApplicationExecutionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution execution, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15849b, execution.f());
            objectEncoderContext.f(f15850c, execution.d());
            objectEncoderContext.f(f15851d, execution.b());
            objectEncoderContext.f(f15852e, execution.e());
            objectEncoderContext.f(f15853f, execution.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder f15854a = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15855b = FieldDescriptor.d("type");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15856c = FieldDescriptor.d("reason");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15857d = FieldDescriptor.d("frames");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15858e = FieldDescriptor.d("causedBy");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15859f = FieldDescriptor.d("overflowCount");

        private CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Exception exception, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15855b, exception.f());
            objectEncoderContext.f(f15856c, exception.e());
            objectEncoderContext.f(f15857d, exception.c());
            objectEncoderContext.f(f15858e, exception.b());
            objectEncoderContext.c(f15859f, exception.d());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder f15860a = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15861b = FieldDescriptor.d("name");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15862c = FieldDescriptor.d("code");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15863d = FieldDescriptor.d("address");

        private CrashlyticsReportSessionEventApplicationExecutionSignalEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15861b, signal.d());
            objectEncoderContext.f(f15862c, signal.c());
            objectEncoderContext.b(f15863d, signal.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder f15864a = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15865b = FieldDescriptor.d("name");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15866c = FieldDescriptor.d("importance");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15867d = FieldDescriptor.d("frames");

        private CrashlyticsReportSessionEventApplicationExecutionThreadEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Thread thread, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15865b, thread.d());
            objectEncoderContext.c(f15866c, thread.c());
            objectEncoderContext.f(f15867d, thread.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder f15868a = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15869b = FieldDescriptor.d("pc");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15870c = FieldDescriptor.d("symbol");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15871d = FieldDescriptor.d("file");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15872e = FieldDescriptor.d("offset");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15873f = FieldDescriptor.d("importance");

        private CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f15869b, frame.e());
            objectEncoderContext.f(f15870c, frame.f());
            objectEncoderContext.f(f15871d, frame.b());
            objectEncoderContext.b(f15872e, frame.d());
            objectEncoderContext.c(f15873f, frame.c());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventDeviceEncoder f15874a = new CrashlyticsReportSessionEventDeviceEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15875b = FieldDescriptor.d("batteryLevel");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15876c = FieldDescriptor.d("batteryVelocity");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15877d = FieldDescriptor.d("proximityOn");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15878e = FieldDescriptor.d("orientation");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15879f = FieldDescriptor.d("ramUsed");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f15880g = FieldDescriptor.d("diskUsed");

        private CrashlyticsReportSessionEventDeviceEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15875b, device.b());
            objectEncoderContext.c(f15876c, device.c());
            objectEncoderContext.a(f15877d, device.g());
            objectEncoderContext.c(f15878e, device.e());
            objectEncoderContext.b(f15879f, device.f());
            objectEncoderContext.b(f15880g, device.d());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventEncoder f15881a = new CrashlyticsReportSessionEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15882b = FieldDescriptor.d("timestamp");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15883c = FieldDescriptor.d("type");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15884d = FieldDescriptor.d("app");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15885e = FieldDescriptor.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f15886f = FieldDescriptor.d("log");

        private CrashlyticsReportSessionEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event event, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f15882b, event.e());
            objectEncoderContext.f(f15883c, event.f());
            objectEncoderContext.f(f15884d, event.b());
            objectEncoderContext.f(f15885e, event.c());
            objectEncoderContext.f(f15886f, event.d());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventLogEncoder f15887a = new CrashlyticsReportSessionEventLogEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15888b = FieldDescriptor.d("content");

        private CrashlyticsReportSessionEventLogEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Log log, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15888b, log.b());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionOperatingSystemEncoder f15889a = new CrashlyticsReportSessionOperatingSystemEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15890b = FieldDescriptor.d("platform");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f15891c = FieldDescriptor.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f15892d = FieldDescriptor.d("buildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f15893e = FieldDescriptor.d("jailbroken");

        private CrashlyticsReportSessionOperatingSystemEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.OperatingSystem operatingSystem, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f15890b, operatingSystem.c());
            objectEncoderContext.f(f15891c, operatingSystem.d());
            objectEncoderContext.f(f15892d, operatingSystem.b());
            objectEncoderContext.a(f15893e, operatingSystem.e());
        }
    }

    /* loaded from: classes3.dex */
    private static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionUserEncoder f15894a = new CrashlyticsReportSessionUserEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f15895b = FieldDescriptor.d("identifier");

        private CrashlyticsReportSessionUserEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(CrashlyticsReport.Session.User user, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f15895b, user.b());
        }
    }

    private AutoCrashlyticsReportEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig<?> encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.f15790a;
        encoderConfig.a(CrashlyticsReport.class, crashlyticsReportEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.f15825a;
        encoderConfig.a(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.f15805a;
        encoderConfig.a(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.f15813a;
        encoderConfig.a(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.f15894a;
        encoderConfig.a(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.f15889a;
        encoderConfig.a(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.f15815a;
        encoderConfig.a(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.f15881a;
        encoderConfig.a(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.f15837a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.f15848a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.f15864a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.f15868a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.f15854a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = CrashlyticsReportApplicationExitInfoEncoder.f15778a;
        encoderConfig.a(CrashlyticsReport.ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.f15860a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.f15843a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.f15787a;
        encoderConfig.a(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.f15874a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.f15887a;
        encoderConfig.a(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.f15799a;
        encoderConfig.a(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.f15802a;
        encoderConfig.a(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        encoderConfig.a(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
