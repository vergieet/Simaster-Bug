package com.ikaru19.simaster_bug.adapters;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ikaru19.simaster_bug.R;
import com.ikaru19.simaster_bug.models.Contact;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

public class ContactAdapter extends BaseQuickAdapter<Contact, BaseViewHolder> {

    Context context;
    public ContactAdapter(@Nullable List<Contact> data , Context context) {
        super(R.layout.item_contact, data);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Contact item) {
        helper.setText(R.id.tv_contact_name, item.getNama())
              .setText(R.id.tv_contact_jab, item.getJabatan());


        ImageView imageView = helper.getView(R.id.iv_contact);
        Picasso.get()
                .load("https://simasterbugs2.com/upload/kontak/"+item.getImg())
                .placeholder(R.drawable.img_placeholder)
                .into(imageView);
        imageView.setScaleType(CENTER_CROP);
    }

    public void refill(List<Contact> data){
        this.mData = data;
    }
}
