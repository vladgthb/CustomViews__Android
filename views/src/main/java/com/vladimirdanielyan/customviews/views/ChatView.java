package com.vladimirdanielyan.customviews.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.vladimirdanielyan.customviews.R;

/**
 * Created by vlad on 8/24/17.
 * The Custom Chat View Class
 */

@SuppressWarnings("unused")
public class ChatView extends RelativeLayout {

    /**
     * The Constructor Of The View With Only Context Of The Top Activity
     * @param context - It is context of the activity, in which view will be used
     */

    public ChatView(Context context) {
        this(context, null);
        initializeViews(context);
    }


    /**
     * The Constructor Of The View With Context and Attributes Of The Top Activity
     * @param context - It is context of the activity, in which view will be used
     * @param attrs - It is attributes of the of the view
     */

    public ChatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);

//        Getting All Attributes
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ChatView, 0, 0);
        Drawable imagePath = a.getDrawable(R.styleable.ChatView_chatViewImage);
        int imageBackgroundColor = a.getInt(R.styleable.ChatView_chatViewImageBackgroundColor, R.color.transparent);

        int imagePadding = a.getDimensionPixelOffset(R.styleable.ChatView_chatViewImagePadding, 0);

        String hintString = a.getString(R.styleable.ChatView_chatViewHint);
        int editTextInputType = a.getInt(R.styleable.ChatView_chatViewTextType, 0);
        Drawable editTextViewBackground = a.getDrawable(R.styleable.ChatView_chatViewBackgroundColor);
        int iconPosition = a.getInt(R.styleable.ChatView_chatIconPosition, 0);

        a.recycle();

////        Setting Icon Of The Edit Text View
//        if (imagePath != null) {
//            setIcon(imagePath);
//        }
//
////        Setting Icon Padding
//        if ( imagePadding != 0) {
//            setIconPadding(imagePadding);
//        }
//
////        Setting Icon Background Color
//        if (imageBackgroundColor != 0) {
//            setImageBackground(imageBackgroundColor);
//        }
//
////        Setting Edit View Hint Text
//        if (hintString != null) {
//            setHint(hintString);
//        }
//
//        int editTextInput = InputType.TYPE_CLASS_TEXT;
//
//        if (editTextInputType == 0) {
//            editTextInput = InputType.TYPE_CLASS_TEXT;
//        } else if (editTextInputType == 1) {
//            editTextInput = InputType.TYPE_TEXT_VARIATION_PASSWORD;
//        } else if (editTextInputType == 2) {
//            editTextInput = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
//        } else if (editTextInputType == 3) {
//            editTextInput = InputType.TYPE_CLASS_NUMBER;
//        }
//
//        setTextType(editTextInput);
//
//        if (editTextViewBackground != null) {
//            setEditTextViewBackground(editTextViewBackground);
//        }
//
//        if (iconPosition == 0) {
//            setIconLeft();
//        } else {
//            setIconRight();
//        }
    }


    // The Relative Layout Variable Of The Chat View
    private RelativeLayout chatViewTopView;


    // The Relative Layout Variable For Message Typing Area
    private RelativeLayout messageArea;


    // The Edit Text View For Message Typing Edit Text View
    private EditText messageTypingEditTextView;


    // The Image Button Variable To Send Message
    private ImageButton messageSendImageButton;


    /**
     * The Method Is Initializing @link iconImageView and @link editTextView variables
     * @param context - It is context of the activity, in which view will be used
     */

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_chat_view, this);

        chatViewTopView = findViewById(R.id.chat_view_top_view);
        messageArea = findViewById(R.id.message_area_edit_text);
        messageTypingEditTextView = findViewById(R.id.new_message_edit_text_view);
        messageSendImageButton = findViewById(R.id.messageSendImageButton);
    }

}
