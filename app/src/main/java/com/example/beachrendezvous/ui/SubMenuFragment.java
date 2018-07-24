package com.example.beachrendezvous.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.beachrendezvous.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link SubMenuFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link SubMenuFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class SubMenuFragment extends Fragment {
    //    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM2 = "param2";
//
    // TODO: Rename and change types of parameters
    private String mParam;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;

    Unbinder mUnbinder;

    @BindView(R.id.subMenu_btn_food)
    Button btnFood;

    @BindView(R.id.subMenu_btn_movies)
    Button btnMovies;

    @BindView(R.id.subMenu_btn_sports)
    Button btnSports;

    private static final String TAG = "sub_menu_fragment";
    private static final String ARG_PARAM = "param";

    public SubMenuFragment () {
        // Required empty public constructor
    }

    //    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment SubMenuFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static SubMenuFragment newInstance (String param1, String param2) {
//        SubMenuFragment fragment = new SubMenuFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
            Log.i(TAG, "onCreate: mParam = " + mParam);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = null;

        if (mParam != null) {
            if (mParam.equals("create")) {
                Log.i(TAG, "onCreateView: type equals create");
                view = inflater.inflate(R.layout.fragment_sub_menu_create, container, false);
            } else {
                Log.i(TAG, "onCreateView: type not equal to create");
                view = inflater.inflate(R.layout.fragment_sub_menu_search, container, false);
            }
        }

        // Bind view using ButterKnife
        mUnbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();

        // Unbind view to free some memory
        mUnbinder.unbind();
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed (Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach (Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                                               + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach () {
//        super.onDetach();
//        mListener = null;
//    }
//

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction (Uri uri);
    }
}
