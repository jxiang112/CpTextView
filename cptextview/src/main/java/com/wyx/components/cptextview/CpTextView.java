package com.wyx.components.cptextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * @author: yongxiang.wei
 * @version: 1.2.0, 2019/4/26 14:25
 * @since: 1.2.0
 */
public class CpTextView extends ConstraintLayout {

    TextView mTvTitle;
    TextView mTvContent;
    View mLine;

    final int DEFAULT_TEXT_SIZE = 14;
    final int DEFAULT_TEXT_COLOR = Color.parseColor("#333333");

    public CpTextView(Context context) {
        this(context, null);
    }

    public CpTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CpTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        View view = LayoutInflater.from(context).inflate(R.layout.cptextview_content_view, this);
        mTvTitle = view.findViewById(R.id.tv_title);
        mTvContent = view.findViewById(R.id.tv_content);
        mLine = view.findViewById(R.id.line);

        int defaultHorizontalSpace = dip2px(15);
        int defaultDrawablePadding = dip2px(10);

        if(attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CpTextView);

            //title
            if(a.hasValue(R.styleable.CpTextView_title_text)){
                mTvTitle.setText(a.getString(R.styleable.CpTextView_title_text));
            }

            if(a.hasValue(R.styleable.CpTextView_title_text_size)){
                mTvTitle.setTextSize(a.getInt(R.styleable.CpTextView_title_text_size, DEFAULT_TEXT_SIZE));
            }

            if(a.hasValue(R.styleable.CpTextView_title_text_color)){
                mTvTitle.setTextColor(a.getColor(R.styleable.CpTextView_title_text_color, DEFAULT_TEXT_COLOR));
            }

            if(a.hasValue(R.styleable.CpTextView_title_left_ico)){
                mTvTitle.setCompoundDrawablesWithIntrinsicBounds(a.getDrawable(R.styleable.CpTextView_title_left_ico), null, null, null);
            }

            if(a.hasValue(R.styleable.CpTextView_title_ico_padding)){
                mTvTitle.setCompoundDrawablePadding(a.getDimensionPixelSize(R.styleable.CpTextView_title_ico_padding, defaultDrawablePadding));
            }
            ConstraintLayout.LayoutParams clp = null;
            int leftMargin = defaultHorizontalSpace;
            int rightMargin = 0;
            if(a.hasValue(R.styleable.CpTextView_title_left_margin)){
                leftMargin = a.getDimensionPixelSize(R.styleable.CpTextView_title_left_margin, defaultHorizontalSpace);
            }
            if(a.hasValue(R.styleable.CpTextView_title_right_margin)){
                rightMargin = a.getDimensionPixelSize(R.styleable.CpTextView_title_right_margin, 0);
            }
            if(leftMargin != defaultHorizontalSpace || rightMargin != 0){
                clp = (LayoutParams) mTvTitle.getLayoutParams();
                clp.leftMargin = leftMargin;
                clp.rightMargin = rightMargin;
                mTvTitle.setLayoutParams(clp);
            }


            //content
            if(a.hasValue(R.styleable.CpTextView_content_text)){
                mTvContent.setText(a.getString(R.styleable.CpTextView_content_text));
            }

            if(a.hasValue(R.styleable.CpTextView_content_text_size)){
                mTvContent.setTextSize(a.getInt(R.styleable.CpTextView_content_text_size, DEFAULT_TEXT_SIZE));
            }

            if(a.hasValue(R.styleable.CpTextView_content_text_color)){
                mTvContent.setTextColor(a.getColor(R.styleable.CpTextView_content_text_color, DEFAULT_TEXT_COLOR));
            }

            if(a.hasValue(R.styleable.CpTextView_content_right_ico)){
                mTvContent.setCompoundDrawablesWithIntrinsicBounds(null, null, a.getDrawable(R.styleable.CpTextView_content_right_ico), null);
            }

            if(a.hasValue(R.styleable.CpTextView_content_ico_padding)){
                mTvContent.setCompoundDrawablePadding(a.getDimensionPixelSize(R.styleable.CpTextView_content_ico_padding, defaultDrawablePadding));
            }

            leftMargin = 0;
            rightMargin = defaultHorizontalSpace;
            if(a.hasValue(R.styleable.CpTextView_content_left_margin)){
                leftMargin = a.getDimensionPixelSize(R.styleable.CpTextView_content_left_margin, dip2px(10));
            }
            if(a.hasValue(R.styleable.CpTextView_content_right_margin)){
                rightMargin = a.getDimensionPixelSize(R.styleable.CpTextView_content_right_margin, defaultHorizontalSpace);
            }
            if(leftMargin != 0 || rightMargin != defaultHorizontalSpace){
                clp = (LayoutParams) mTvContent.getLayoutParams();
                clp.leftMargin = leftMargin;
                clp.rightMargin = rightMargin;
                mTvContent.setLayoutParams(clp);
            }


            //line
            if(a.hasValue(R.styleable.CpTextView_line_color)){
                mLine.setBackgroundColor(a.getColor(R.styleable.CpTextView_line_color, Color.parseColor("#DDDDDD")));
            }
            int height = 0;
            if(a.hasValue(R.styleable.CpTextView_line_size)){
                height = a.getDimensionPixelSize(R.styleable.CpTextView_line_size, dip2px(0.4f));
            }
            leftMargin = defaultHorizontalSpace;
            rightMargin = 0;
            if(a.hasValue(R.styleable.CpTextView_line_left_margin)){
                leftMargin = a.getDimensionPixelSize(R.styleable.CpTextView_line_left_margin, defaultHorizontalSpace);
            }
            if(a.hasValue(R.styleable.CpTextView_line_right_margin)){
                rightMargin = a.getDimensionPixelSize(R.styleable.CpTextView_line_right_margin, 0);
            }
            if(height != 0 || leftMargin != defaultHorizontalSpace || rightMargin != 0){
                clp = (LayoutParams) mLine.getLayoutParams();
                clp.leftMargin = leftMargin;
                clp.rightMargin = rightMargin;
                clp.height = height;
                mLine.setLayoutParams(clp);
            }

            a.recycle();
        }

    }

    public TextView getTitleTextView(){
        return mTvTitle;
    }

    public TextView getContentTextView(){
        return mTvContent;
    }

    public View getLineView(){
        return mLine;
    }

    public CpTextView setTitle(int pTitleResId){
        return setTitle(pTitleResId == 0 ? null : getResources().getString(pTitleResId));
    }

    public CpTextView setTitle(String pTitle){
        mTvTitle.setText(pTitle);
        return this;
    }

    public CpTextView setTitleTextSize(float pTextSize){
        mTvTitle.setTextSize(pTextSize);
        return this;
    }

    public CpTextView setTitleTextResourceColor(int pTextColorResId){
        if(pTextColorResId == 0){
            return this;
        }
        return setTitleTextColor(getResources().getColor(pTextColorResId));
    }

    public CpTextView setTitleTextColor(int pTextColor){
        mTvTitle.setTextColor(pTextColor);
        return this;
    }

    public CpTextView setTitleLeftIco(int pIcoResId){
        return setTitleLeftIco(pIcoResId == 0 ? null : getResources().getDrawable(pIcoResId));
    }

    public CpTextView setTitleLeftIco(Drawable pLeftDrawable){
        mTvTitle.setCompoundDrawablesWithIntrinsicBounds(pLeftDrawable, null, null, null);
        return this;
    }

    public CpTextView setTitleIcoPaddingDimenId(int pDimenId){
        if(pDimenId == 0){
            return this;
        }
        return setTitleIcoPadding(getResources().getDimensionPixelSize(pDimenId));
    }

    public CpTextView setTitleIcoPadding(int pPadding){
        mTvTitle.setCompoundDrawablePadding(pPadding);
        return this;
    }

    public CpTextView setTitleMargin(int pLeftMargin){
        return setTitleMargin(pLeftMargin, 0, 0, 0);
    }

    public CpTextView setTitleMargin(int pLeftMargin, int pRightMargin){
        return setTitleMargin(pLeftMargin, 0, pRightMargin, 0);
    }

    public CpTextView setTitleMargin(int pLeftMargin, int pTopMargin, int pRightMargin, int pBottomMargin){
        ConstraintLayout.LayoutParams clp = (LayoutParams) mTvTitle.getLayoutParams();
        clp.leftMargin = pLeftMargin;
        clp.topMargin = pTopMargin;
        clp.rightMargin = pRightMargin;
        clp.bottomMargin = pBottomMargin;
        mTvTitle.setLayoutParams(clp);
        return this;
    }



    //set content
    public CpTextView setContent(int pContentResId){
        return setContent(pContentResId == 0 ? null : getResources().getString(pContentResId));
    }

    public CpTextView setContent(String pContent){
        mTvContent.setText(pContent);
        return this;
    }

    public CpTextView setContentTextSize(float pTextSize){
        mTvContent.setTextSize(pTextSize);
        return this;
    }

    public CpTextView setContentTextResourceColor(int pTextColorResId){
        if(pTextColorResId == 0){
            return this;
        }
        return setContentTextColor(getResources().getColor(pTextColorResId));
    }

    public CpTextView setContentTextColor(int pTextColor){
        mTvContent.setTextColor(pTextColor);
        return this;
    }

    public CpTextView setContentRightIco(int pIcoResId){
        return setContentRightIco(pIcoResId == 0 ? null : getResources().getDrawable(pIcoResId));
    }

    public CpTextView setContentRightIco(Drawable pRightDrawable){
        mTvContent.setCompoundDrawablesWithIntrinsicBounds(null, null, pRightDrawable, null);
        return this;
    }

    public CpTextView setContentIcoPaddingDimenId(int pDimenId){
        if(pDimenId == 0){
            return this;
        }
        return setContentIcoPadding(getResources().getDimensionPixelSize(pDimenId));
    }

    public CpTextView setContentIcoPadding(int pPadding){
        mTvContent.setCompoundDrawablePadding(pPadding);
        return this;
    }

    public CpTextView setContentMargin(int pRightMargin){
        return setContentMargin(0, 0, pRightMargin, 0);
    }

    public CpTextView setContentMargin(int pLeftMargin, int pRightMargin){
        return setContentMargin(pLeftMargin, 0, pRightMargin, 0);
    }

    public CpTextView setContentMargin(int pLeftMargin, int pTopMargin, int pRightMargin, int pBottomMargin){
        ConstraintLayout.LayoutParams clp = (LayoutParams) mTvContent.getLayoutParams();
        clp.leftMargin = pLeftMargin;
        clp.topMargin = pTopMargin;
        clp.rightMargin = pRightMargin;
        clp.bottomMargin = pBottomMargin;
        mTvContent.setLayoutParams(clp);
        return this;
    }


    //set line
    public CpTextView setLineResourceColor(int pLineColorResId){
        if(pLineColorResId == 0){
            return this;
        }
       return setLineColor(getResources().getColor(pLineColorResId));
    }

    public CpTextView setLineColor(int pLineColor){
        mLine.setBackgroundColor(pLineColor);
        return this;
    }

    public CpTextView setLineSize(int pLineSize){
        ConstraintLayout.LayoutParams clp = (LayoutParams) mLine.getLayoutParams();
        clp.height = pLineSize;
        mLine.setLayoutParams(clp);
        return this;
    }

    public CpTextView setLineMargin(int pLeftMargin){
        return setLineMargin(pLeftMargin, 0, 0, 0);
    }

    public CpTextView setLineMargin(int pLeftMargin, int pRightMargin){
        return setContentMargin(pLeftMargin, 0, pRightMargin, 0);
    }

    public CpTextView setLineMargin(int pLeftMargin, int pTopMargin, int pRightMargin, int pBottomMargin){
        ConstraintLayout.LayoutParams clp = (LayoutParams) mLine.getLayoutParams();
        clp.leftMargin = pLeftMargin;
        clp.topMargin = pTopMargin;
        clp.rightMargin = pRightMargin;
        clp.bottomMargin = pBottomMargin;
        mLine.setLayoutParams(clp);
        return this;
    }



    public int dip2px(float dipValue){
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
