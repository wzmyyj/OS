package top.wzmyyj.wzm_sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import top.wzmyyj.wzm_sdk.R;

/**
 * Created by yyj on 2018/12/07.
 *
 * 有圆角的ImageView。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class RoundAngleImageView extends AppCompatImageView {
    float width, height;

    private int radiusLeftTop = 0;
    private int radiusLeftBottom = 0;
    private int radiusRightTop = 0;
    private int radiusRightBottom = 0;
    private int mBorderColor = Color.RED;
    private int mBorderWidth = 5;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 获取属性。
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundAngleImageView, defStyleAttr, 0);
        int radius = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_radiusAll, 0);
        radiusLeftTop = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_radiusLeftTop, radius);
        radiusLeftBottom = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_radiusLeftBottom, radius);
        radiusRightTop = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_radiusRightTop, radius);
        radiusRightBottom = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_radiusRightBottom, radius);

        mBorderWidth = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_border_width_r, 0);
        mBorderColor = a.getColor(R.styleable.RoundAngleImageView_border_color_r, 0);
        a.recycle();

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    /**
     * @return
     */
    public int getBorderColor() {
        return mBorderColor;
    }

    /**
     * @param borderColor
     */
    public void setBorderColor(int borderColor) {
        if (borderColor == mBorderColor) {
            return;
        }
        mBorderColor = borderColor;
        invalidate();
    }

    /**
     * @return
     */
    public int getBorderWidth() {
        return mBorderWidth;
    }

    /**
     * @param borderWidth
     */
    public void setBorderWidth(int borderWidth) {
        if (borderWidth == mBorderWidth) {
            return;
        }

        mBorderWidth = borderWidth;
        invalidate();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        if (width >= (radiusLeftTop + radiusRightTop)
                && width >= (radiusLeftBottom + radiusRightBottom)
                && height >= (radiusLeftTop + radiusLeftBottom)
                && height >= (radiusRightTop + radiusRightBottom)) {
            //四个圆角
            Paint paint = new Paint();
            Path path = new Path();

            path.moveTo(radiusLeftTop, 0);
            path.lineTo(width - radiusRightTop, 0);
            path.quadTo(width, 0, width, radiusRightTop);
            path.lineTo(width, height - radiusRightBottom);
            path.quadTo(width, height, width - radiusRightBottom, height);
            path.lineTo(radiusLeftBottom, height);
            path.quadTo(0, height, 0, height - radiusLeftBottom);
            path.lineTo(0, radiusLeftTop);
            path.quadTo(0, 0, radiusLeftTop, 0);
            canvas.clipPath(path);
            super.onDraw(canvas);
            if (mBorderWidth > 0) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setColor(mBorderColor);
                paint.setStrokeWidth(mBorderWidth);
                canvas.drawPath(path, paint);
            }
            path.close();
        } else {
            super.onDraw(canvas);
        }
    }

}