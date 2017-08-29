package com.vladimirdanielyan.customviews.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.vladimirdanielyan.customviews.R;

/**
 * Created by vlad on 8/4/17.
 * Custom Edit Text View
 */

@SuppressWarnings("unused")
public class EditTextViewWithIcon extends RelativeLayout {

//    The Image View Variable, That Is Defining Icon Of The Edit Text View
    private ImageView iconImageView;

//    The Edit Text View Variable, That Is Defining Edit Text View
    private EditText editTextView;


    /**
     * The Constructor Of The View With Only Context Of The Top Activity
     * @param context - It is context of the activity, in which view will be used
     */

    public EditTextViewWithIcon(Context context) {
        this(context, null);
        initializeViews(context);
    }


    /**
     * The Constructor Of The View With Context and Attributes Of The Top Activity
     * @param context - It is context of the activity, in which view will be used
     * @param attrs - It is attributes of the of the view
     */

    public EditTextViewWithIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);

//        Getting All Attributes
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.EditTextWithIcon, 0, 0);
        Drawable imagePath = a.getDrawable(R.styleable.EditTextWithIcon_image);
        int imageBackgroundColor = a.getInt(R.styleable.EditTextWithIcon_imageBackgroundColor, R.color.transparent);

        int imagePadding = a.getDimensionPixelOffset(R.styleable.EditTextWithIcon_imagePadding, 0);

        String hintString = a.getString(R.styleable.EditTextWithIcon_hint);
        int editTextInputType = a.getInt(R.styleable.EditTextWithIcon_textType, 0);
        Drawable editTextViewBackground = a.getDrawable(R.styleable.EditTextWithIcon_viewBackgroundColor);
        int iconPosition = a.getInt(R.styleable.EditTextWithIcon_iconPosition, 0);

        a.recycle();

//        Setting Icon Of The Edit Text View
        if (imagePath != null) {
            setIcon(imagePath);
        }

//        Setting Icon Padding
        if ( imagePadding != 0) {
            setIconPadding(imagePadding);
        }

//        Setting Icon Background Color
        if (imageBackgroundColor != 0) {
            setImageBackground(imageBackgroundColor);
        }

//        Setting Edit View Hint Text
        if (hintString != null) {
            setHint(hintString);
        }

        int editTextInput = InputType.TYPE_CLASS_TEXT;

        if (editTextInputType == 0) {
            editTextInput = InputType.TYPE_CLASS_TEXT;
        } else if (editTextInputType == 1) {
            editTextInput = InputType.TYPE_TEXT_VARIATION_PASSWORD;
        } else if (editTextInputType == 2) {
            editTextInput = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
        } else if (editTextInputType == 3) {
            editTextInput = InputType.TYPE_CLASS_NUMBER;
        }

        setTextType(editTextInput);

        if (editTextViewBackground != null) {
            setEditTextViewBackground(editTextViewBackground);
        }

        if (iconPosition == 0) {
            setIconLeft();
        } else {
            setIconRight();
        }
    }


    /**
     * The Method Is Initializing @link iconImageView and @link editTextView variables
     * @param context - It is context of the activity, in which view will be used
     */

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.edit_text_with_icon_layout, this);

        iconImageView = findViewById(R.id.user_icon);
        editTextView = findViewById(R.id.user_name_edit_view);
    }


    /**
     * The Method Is Setting Image View Icon
     * @param drawable - Drawable path of the icon
     */

    public void setIcon(Drawable drawable) {
        iconImageView.setImageDrawable(drawable);
        //noinspection SuspiciousNameCombination
        iconImageView.getLayoutParams().width = iconImageView.getLayoutParams().height;
    }


    /**
     * The Method Is Setting Edit Text View Background
     * @param drawable - Drawable path of the edit text view
     */

    public void setEditTextViewBackground(Drawable drawable) {
        editTextView.setBackground(drawable);
    }


    /**
     * The Method Is Setting Text To Edit Text View
     * @param text - The text which need to set to edit text view
     */

    public void setText(String text) {
        editTextView.setText(text);
    }


    /**
     * The Method Is Setting Text Input Type
     * @param textType - Input types. Available values are
     *                 VALUE    |   Description
     *                 ----------------------------------------------
     *                 0        |   TYPE_CLASS_TEXT
     *                 1        |   TYPE_TEXT_VARIATION_PASSWORD
     *                 2        |   TYPE_TEXT_VARIATION_EMAIL_ADDRESS
     *                 3        |   TYPE_CLASS_NUMBER
     */

    public void setTextType(int textType) {
        editTextView.setInputType(textType);
    }


    /**
     * Setting Hint Text Of The Edit Text View
     * @param text - hint text
     */

    public void setHint(String text) {
        editTextView.setHint(text);
    }


    /**
     * The Method Is Returning ImageView Object Of The Custom View
     * @return - ImageView Object
     */

    public ImageView getIcon() {
        return iconImageView;
    }


    /**
     * The Method Is Changing Position Of The Icon To Left
     */

    public void setIconLeft() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iconImageView.getLayoutParams();
        params.setMarginStart(16);
        params.addRule(RelativeLayout.ALIGN_PARENT_START);
        iconImageView.setLayoutParams(params);
    }


    /**
     * The Method Is Changing Position Of The Icon To Right
     */

    public void setIconRight() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iconImageView.getLayoutParams();
        params.setMarginEnd(16);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        iconImageView.setLayoutParams(params);
    }

    /**
     * The Method is changing background color of image view area
     * @param selectedColor - image view background color
     */

    public void setImageBackground(int selectedColor) {
        iconImageView.setBackgroundColor(selectedColor);
    }


    /**
     * The Method Is Setting Edit Text View Padding
     * @param paddingNumber - padding value
     */

    public void setIconPadding(int paddingNumber) {
        iconImageView.setPadding(paddingNumber, paddingNumber, paddingNumber, paddingNumber);
    }


    /**
     * The Method Is Giving edit text view text
     * @return - edit text view String text
     */

    public String getText() {
        return editTextView.getText().toString();
    }
}
