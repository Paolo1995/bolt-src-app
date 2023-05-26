package eu.bolt.android.chat.recyclerview;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import eu.bolt.android.chat.recyclerview.ChatReadDelegate;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.tools.logger.Logger;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatReadDelegate.kt */
/* loaded from: classes5.dex */
public final class ChatReadDelegate {

    /* renamed from: c  reason: collision with root package name */
    private static final Companion f36714c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ReadMessageInteractor f36715a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f36716b;

    /* compiled from: ChatReadDelegate.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ChatReadDelegate(ReadMessageInteractor readMessageInteractor, Logger logger) {
        Intrinsics.f(readMessageInteractor, "readMessageInteractor");
        Intrinsics.f(logger, "logger");
        this.f36715a = readMessageInteractor;
        this.f36716b = logger;
    }

    private final int b(Context context, float f8) {
        return (int) TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    private final Integer c(RecyclerView recyclerView, int i8) {
        boolean z7;
        RecyclerView.ViewHolder c02 = recyclerView.c0(i8);
        if (c02 == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(c02.k());
        if (valueOf.intValue() != -1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return null;
        }
        return valueOf;
    }

    private final View.OnLayoutChangeListener d(final RecyclerView recyclerView, final ChatAdapter chatAdapter) {
        return new View.OnLayoutChangeListener() { // from class: d6.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                ChatReadDelegate.e(ChatReadDelegate.this, recyclerView, chatAdapter, view, i8, i9, i10, i11, i12, i13, i14, i15);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ChatReadDelegate this$0, RecyclerView recyclerView, ChatAdapter chatAdapter, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(recyclerView, "$recyclerView");
        Intrinsics.f(chatAdapter, "$chatAdapter");
        if (i15 - i13 != i11 - i9) {
            this$0.i(recyclerView, chatAdapter);
        }
    }

    private final RecyclerView.OnScrollListener f(RecyclerView recyclerView, final ChatAdapter chatAdapter) {
        Context context = recyclerView.getContext();
        Intrinsics.e(context, "recyclerView.context");
        final int b8 = b(context, 10.0f);
        return new RecyclerView.OnScrollListener() { // from class: eu.bolt.android.chat.recyclerview.ChatReadDelegate$getScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(RecyclerView recyclerView2, int i8) {
                Intrinsics.f(recyclerView2, "recyclerView");
                if (i8 == 0) {
                    ChatReadDelegate.this.i(recyclerView2, chatAdapter);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i8, int i9) {
                Intrinsics.f(recyclerView2, "recyclerView");
                if (Math.abs(i9) > b8) {
                    ChatReadDelegate.this.i(recyclerView2, chatAdapter);
                }
            }
        };
    }

    private final void h(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager, ChatAdapter chatAdapter) {
        ChatMessageEntity a8;
        boolean z7;
        int k22 = linearLayoutManager.k2();
        int n22 = linearLayoutManager.n2();
        if (k22 != -1 && n22 != -1) {
            ArrayList arrayList = new ArrayList();
            if (k22 <= n22) {
                while (true) {
                    Integer c8 = c(recyclerView, k22);
                    if (c8 != null && (a8 = chatAdapter.a(c8.intValue())) != null) {
                        if (!a8.n() && Intrinsics.a(a8.i(), ChatMessageStatus.DeliveredToBackend.f38163b)) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (!z7) {
                            a8 = null;
                        }
                        if (a8 != null) {
                            arrayList.add(a8);
                        }
                    }
                    if (k22 == n22) {
                        break;
                    }
                    k22++;
                }
            }
            if (!arrayList.isEmpty()) {
                Logger logger = this.f36716b;
                logger.b("reading messages " + arrayList);
                this.f36715a.b(arrayList).E();
            }
        }
    }

    public final Function0<Unit> g(final RecyclerView recyclerView, ChatAdapter chatAdapter) {
        Intrinsics.f(recyclerView, "recyclerView");
        Intrinsics.f(chatAdapter, "chatAdapter");
        final RecyclerView.OnScrollListener f8 = f(recyclerView, chatAdapter);
        recyclerView.l(f8);
        final View.OnLayoutChangeListener d8 = d(recyclerView, chatAdapter);
        recyclerView.addOnLayoutChangeListener(d8);
        return new Function0<Unit>() { // from class: eu.bolt.android.chat.recyclerview.ChatReadDelegate$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                RecyclerView.this.g1(f8);
                RecyclerView.this.removeOnLayoutChangeListener(d8);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        };
    }

    public final void i(RecyclerView recyclerView, ChatAdapter chatAdapter) {
        LinearLayoutManager linearLayoutManager;
        Intrinsics.f(recyclerView, "recyclerView");
        Intrinsics.f(chatAdapter, "chatAdapter");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            h(recyclerView, linearLayoutManager, chatAdapter);
        }
    }
}
