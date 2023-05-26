package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.R$id;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CTCarouselMessageViewHolder extends CTInboxBaseMessageViewHolder {
    private final RelativeLayout J;
    private final CTCarouselViewPager K;
    private final ImageView L;
    private ImageView M;
    private final LinearLayout N;
    private final TextView O;
    private final TextView P;
    private final TextView Q;

    /* loaded from: classes.dex */
    class CarouselPageChangeListener implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final Context f11476a;

        /* renamed from: b  reason: collision with root package name */
        private final ImageView[] f11477b;

        /* renamed from: c  reason: collision with root package name */
        private final CTInboxMessage f11478c;

        /* renamed from: d  reason: collision with root package name */
        private final CTCarouselMessageViewHolder f11479d;

        CarouselPageChangeListener(Context context, CTCarouselMessageViewHolder cTCarouselMessageViewHolder, ImageView[] imageViewArr, CTInboxMessage cTInboxMessage) {
            this.f11476a = context;
            this.f11479d = cTCarouselMessageViewHolder;
            this.f11477b = imageViewArr;
            this.f11478c = cTInboxMessage;
            imageViewArr[0].setImageDrawable(ResourcesCompat.f(context.getResources(), R$drawable.ct_selected_dot, null));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void a(int i8, float f8, int i9) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void c(int i8) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void d(int i8) {
            for (ImageView imageView : this.f11477b) {
                imageView.setImageDrawable(ResourcesCompat.f(this.f11476a.getResources(), R$drawable.ct_unselected_dot, null));
            }
            this.f11477b[i8].setImageDrawable(ResourcesCompat.f(this.f11476a.getResources(), R$drawable.ct_selected_dot, null));
            this.f11479d.O.setText(this.f11478c.f().get(i8).r());
            this.f11479d.O.setTextColor(Color.parseColor(this.f11478c.f().get(i8).s()));
            this.f11479d.P.setText(this.f11478c.f().get(i8).o());
            this.f11479d.P.setTextColor(Color.parseColor(this.f11478c.f().get(i8).p()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTCarouselMessageViewHolder(@NonNull View view) {
        super(view);
        this.K = (CTCarouselViewPager) view.findViewById(R$id.image_carousel_viewpager);
        this.N = (LinearLayout) view.findViewById(R$id.sliderDots);
        this.O = (TextView) view.findViewById(R$id.messageTitle);
        this.P = (TextView) view.findViewById(R$id.f11084x0);
        this.Q = (TextView) view.findViewById(R$id.timestamp);
        this.L = (ImageView) view.findViewById(R$id.read_circle);
        this.J = (RelativeLayout) view.findViewById(R$id.body_linear_layout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder
    public void R(final CTInboxMessage cTInboxMessage, final CTInboxListViewFragment cTInboxListViewFragment, final int i8) {
        super.R(cTInboxMessage, cTInboxListViewFragment, i8);
        final CTInboxListViewFragment U = U();
        Context applicationContext = cTInboxListViewFragment.getActivity().getApplicationContext();
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.f().get(0);
        this.O.setVisibility(0);
        this.P.setVisibility(0);
        this.O.setText(cTInboxMessageContent.r());
        this.O.setTextColor(Color.parseColor(cTInboxMessageContent.s()));
        this.P.setText(cTInboxMessageContent.o());
        this.P.setTextColor(Color.parseColor(cTInboxMessageContent.p()));
        if (cTInboxMessage.o()) {
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(0);
        }
        this.Q.setVisibility(0);
        this.Q.setText(Q(cTInboxMessage.d()));
        this.Q.setTextColor(Color.parseColor(cTInboxMessageContent.s()));
        this.J.setBackgroundColor(Color.parseColor(cTInboxMessage.a()));
        this.K.setAdapter(new CTCarouselViewPagerAdapter(applicationContext, cTInboxListViewFragment, cTInboxMessage, (LinearLayout.LayoutParams) this.K.getLayoutParams(), i8));
        int size = cTInboxMessage.f().size();
        if (this.N.getChildCount() > 0) {
            this.N.removeAllViews();
        }
        ImageView[] imageViewArr = new ImageView[size];
        Z(imageViewArr, size, applicationContext, this.N);
        imageViewArr[0].setImageDrawable(ResourcesCompat.f(applicationContext.getResources(), R$drawable.ct_selected_dot, null));
        this.K.c(new CarouselPageChangeListener(cTInboxListViewFragment.getActivity().getApplicationContext(), this, imageViewArr, cTInboxMessage));
        this.J.setOnClickListener(new CTInboxButtonClickListener(i8, cTInboxMessage, (String) null, U, this.K));
        new Handler().postDelayed(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTCarouselMessageViewHolder.1
            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity = cTInboxListViewFragment.getActivity();
                if (activity == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTCarouselMessageViewHolder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1;
                        CTInboxListViewFragment cTInboxListViewFragment2;
                        AnonymousClass1 anonymousClass12;
                        CTInboxListViewFragment cTInboxListViewFragment3;
                        if (cTInboxMessage.l() == CTInboxMessageType.CarouselImageMessage) {
                            if (CTCarouselMessageViewHolder.this.M.getVisibility() == 0 && (cTInboxListViewFragment3 = U) != null) {
                                cTInboxListViewFragment3.E(null, i8);
                            }
                            CTCarouselMessageViewHolder.this.M.setVisibility(8);
                            return;
                        }
                        if (CTCarouselMessageViewHolder.this.L.getVisibility() == 0 && (cTInboxListViewFragment2 = U) != null) {
                            cTInboxListViewFragment2.E(null, i8);
                        }
                        CTCarouselMessageViewHolder.this.L.setVisibility(8);
                    }
                });
            }
        }, 2000L);
    }
}
