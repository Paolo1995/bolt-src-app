package eu.bolt.driver.stories.ui.story_preview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import eu.bolt.android.stories.model.StoryPreview;
import eu.bolt.android.stories.widget.preview.StoryPreviewView;
import eu.bolt.driver.stories.R$id;
import eu.bolt.driver.stories.R$layout;
import eu.bolt.driver.stories.ui.story_preview.StoryPreviewDelegate;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryPreviewDelegate.kt */
/* loaded from: classes5.dex */
public final class StoryPreviewDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f41577b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f41578c;

    /* compiled from: StoryPreviewDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f41579a;

        /* renamed from: b  reason: collision with root package name */
        private final StoryPreview f41580b;

        public Model(String listId, StoryPreview payload) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(payload, "payload");
            this.f41579a = listId;
            this.f41580b = payload;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f41580b, model.f41580b);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (m().hashCode() * 31) + this.f41580b.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f41579a;
        }

        public final StoryPreview n() {
            return this.f41580b;
        }

        public String toString() {
            String m8 = m();
            StoryPreview storyPreview = this.f41580b;
            return "Model(listId=" + m8 + ", payload=" + storyPreview + ")";
        }
    }

    /* compiled from: StoryPreviewDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final StoryPreviewView f41581u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.f(itemView, "itemView");
            StoryPreviewView storyPreviewView = (StoryPreviewView) itemView.findViewById(R$id.storyPreview);
            Intrinsics.e(storyPreviewView, "itemView.storyPreview");
            this.f41581u = storyPreviewView;
        }

        public final StoryPreviewView O() {
            return this.f41581u;
        }
    }

    public /* synthetic */ StoryPreviewDelegate(int i8, Function1 function1, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? R$layout.delegate_story_preview : i8, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(StoryPreviewDelegate this$0, Model model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f41578c.invoke(model.n().b());
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f41577b;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View v7 = inflater.inflate(e(), parent, false);
        Intrinsics.e(v7, "v");
        return new ViewHolder(v7);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: t */
    public void g(ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        holder.O().E(model.n());
        holder.O().setOnClickListener(new View.OnClickListener() { // from class: j7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryPreviewDelegate.u(StoryPreviewDelegate.this, model, view);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: v */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoryPreviewDelegate(int i8, Function1<? super String, Unit> onItemClick) {
        Intrinsics.f(onItemClick, "onItemClick");
        this.f41577b = i8;
        this.f41578c = onItemClick;
    }
}
