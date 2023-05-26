package eu.bolt.driver.chat.ui.screen.conversation.pager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.Conversation;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationPagerAdapter.kt */
/* loaded from: classes5.dex */
public final class ConversationPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40591a;

    /* renamed from: b  reason: collision with root package name */
    private final CoreFragmentFactory f40592b;

    /* renamed from: c  reason: collision with root package name */
    private List<Conversation> f40593c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationPagerAdapter(FragmentManager fm, Context context, CoreFragmentFactory fragmentFactory) {
        super(fm);
        List<Conversation> k8;
        Intrinsics.f(fm, "fm");
        Intrinsics.f(context, "context");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        this.f40591a = context;
        this.f40592b = fragmentFactory;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f40593c = k8;
    }

    public final void a(List<Conversation> list) {
        Intrinsics.f(list, "<set-?>");
        this.f40593c = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f40593c.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i8) {
        return this.f40592b.a(this.f40591a, ConversationFragment.class, ConversationFragment.H.a(this.f40593c.get(i8)));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i8) {
        return this.f40593c.get(i8).d();
    }
}
