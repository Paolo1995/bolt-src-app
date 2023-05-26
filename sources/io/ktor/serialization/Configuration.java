package io.ktor.serialization;

import io.ktor.http.ContentType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentConverter.kt */
/* loaded from: classes5.dex */
public interface Configuration {

    /* compiled from: ContentConverter.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(Configuration configuration, ContentType contentType, ContentConverter contentConverter, Function1 function1, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 4) != 0) {
                    function1 = new Function1() { // from class: io.ktor.serialization.Configuration$register$1
                        public final void b(ContentConverter contentConverter2) {
                            Intrinsics.f(contentConverter2, "$this$null");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            b((ContentConverter) obj2);
                            return Unit.f50853a;
                        }
                    };
                }
                configuration.a(contentType, contentConverter, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
    }

    <T extends ContentConverter> void a(ContentType contentType, T t7, Function1<? super T, Unit> function1);
}
