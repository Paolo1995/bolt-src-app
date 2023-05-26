package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.SystemPropsKt;

/* compiled from: Channel.kt */
/* loaded from: classes5.dex */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final Factory f51402e = Factory.f51403a;

    /* compiled from: Channel.kt */
    /* loaded from: classes5.dex */
    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Factory f51403a = new Factory();

        /* renamed from: b  reason: collision with root package name */
        private static final int f51404b = SystemPropsKt.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private Factory() {
        }

        public final int a() {
            return f51404b;
        }
    }
}
