package zhangyanran20181018.bwie.com.myjddemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhangyanran20181018.bwie.com.myjddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Three extends Fragment  {


    public Fragment_Three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment__three, container, false);
        return inflate;
    }

}
