package eu.bolt.verification.sdk.internal;

import android.os.Build;
import android.os.FileObserver;
import j$.util.Spliterator;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes5.dex */
public final class g7 {

    @DebugMetadata(c = "eu.bolt.client.stories.screenshot.FileCreationEventsRepository$fileCreationDetectorFlow$1", f = "FileCreationEventsRepository.kt", l = {50}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class a extends SuspendLambda implements Function2<ProducerScope<? super File>, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43123g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f43124h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ File f43125i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: eu.bolt.verification.sdk.internal.g7$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0056a extends Lambda implements Function0<Unit> {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FileObserver f43126f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0056a(FileObserver fileObserver) {
                super(0);
                this.f43126f = fileObserver;
            }

            public final void b() {
                this.f43126f.stopWatching();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends FileObserver {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ File f43127a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ProducerScope<File> f43128b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(File file, ProducerScope<? super File> producerScope) {
                super(file, (int) Spliterator.NONNULL);
                this.f43127a = file;
                this.f43128b = producerScope;
            }

            @Override // android.os.FileObserver
            public void onEvent(int i8, String str) {
                g7.c(this.f43128b, this.f43127a, i8, str);
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends FileObserver {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProducerScope<File> f43129a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f43130b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(ProducerScope<? super File> producerScope, File file, String str) {
                super(str, (int) Spliterator.NONNULL);
                this.f43129a = producerScope;
                this.f43130b = file;
            }

            @Override // android.os.FileObserver
            public void onEvent(int i8, String str) {
                g7.c(this.f43129a, this.f43130b, i8, str);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f43125i = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.f43125i, continuation);
            aVar.f43124h = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(ProducerScope<? super File> producerScope, Continuation<? super Unit> continuation) {
            return ((a) create(producerScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            FileObserver cVar;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f43123g;
            if (i8 == 0) {
                ResultKt.b(obj);
                ProducerScope producerScope = (ProducerScope) this.f43124h;
                if (Build.VERSION.SDK_INT >= 29) {
                    cVar = new b(this.f43125i, producerScope);
                } else {
                    cVar = new c(producerScope, this.f43125i, this.f43125i.getAbsolutePath());
                }
                cVar.startWatching();
                C0056a c0056a = new C0056a(cVar);
                this.f43123g = 1;
                if (ProduceKt.a(producerScope, c0056a, this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ProducerScope<? super File> producerScope, File file, int i8, String str) {
        if (str == null || i8 != 256) {
            return;
        }
        producerScope.u(new File(file, str));
    }

    public final Flow<File> a(File inDirectory) {
        Intrinsics.f(inDirectory, "inDirectory");
        return !inDirectory.isDirectory() ? FlowKt.m() : FlowKt.d(new a(inDirectory, null));
    }
}
