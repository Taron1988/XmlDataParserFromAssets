package examen.com.showxmldata;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



public class ListAdapter extends BaseAdapter {

    private TextView tv_name;
    private TextView tv_email;
    private TextView tv_bender;
    private TextView tv_age;
    private Context context;
    private List<UserModel> list;
    private UserModel userModel;

    ListAdapter(Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.listview_item, viewGroup,false);
        userModel = (UserModel) getItem(i);
        findeViews(view);
        initVews();

        if (userModel.getGender().equalsIgnoreCase("male")){
            view.setBackgroundColor(Color.CYAN);
        }else {
            view.setBackgroundColor(Color.GREEN);
        }
        return view;
    }

    private void initVews() {
        tv_name.setText(userModel.getName());
        tv_email.setText(userModel.getEmail());
        tv_bender.setText(userModel.getGender());
        tv_age.setText(String.valueOf(userModel.getAge()));
    }

    private void findeViews(View view) {
        tv_name = view.findViewById(R.id.tv_name);
        tv_email = view.findViewById(R.id.tv_email);
        tv_bender = view.findViewById(R.id.tv_bender);
        tv_age = view.findViewById(R.id.tv_age);
    }
}
