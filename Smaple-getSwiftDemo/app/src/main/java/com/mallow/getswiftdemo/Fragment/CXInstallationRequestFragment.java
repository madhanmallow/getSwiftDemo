package com.mallow.getswiftdemo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mallow.getswiftdemo.GSApp;
import com.mallow.getswiftdemo.GSAppConstants;
import com.mallow.getswiftdemo.GSUtilities;
import com.mallow.getswiftdemo.R;
import com.mallow.getswiftdemo.datamodel.GSDataModelResponseHandler;
import com.mallow.getswiftdemo.getswift.CXBookJob;
import com.mallow.getswiftdemo.getswift.CXDatum;
import com.mallow.getswiftdemo.http.GSHttpClientResponse;

import java.util.ArrayList;


/**
 * Created by manikandan on 17/05/16.
 */
public class CXInstallationRequestFragment extends Fragment {
    FloatingActionButton floatActionBtnAdd;
    private ArrayList<CXDatum> book_list = new ArrayList<CXDatum>();
    //Tab tag name
    private TextView tvEmptyView;
    private ListView lvDevices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.cx_fragment_installation_request, container, false);
        tvEmptyView = (TextView) rootView.findViewById(R.id.tv_noDevices);
        floatActionBtnAdd = (FloatingActionButton) rootView.findViewById(R.id.btn_Add);
        lvDevices = (ListView) rootView.findViewById(R.id.lv_devices);
        View footerView = View.inflate(getActivity(), R.layout.cx_list_footerview, null);
        lvDevices.addFooterView(footerView, null, false);
        floatActionBtnAdd.setVisibility(View.VISIBLE);
        setTypeface(tvEmptyView, CXFonts.Prime_regular);
        // get swift Book a delivery API
        getSwiftBookingAllDetailWebservices();

        lvDevices.setOnItemClickListener((parent, view, position, id) -> {
            try {
                Intent installRequestIntent = new Intent(getActivity(), CXInstallationRequestDetailActivity.class);
                installRequestIntent.putExtra(GSAppConstants.INSTALLATION_REQUEST_NAME, book_list.get(position).getId());
                installRequestIntent.putExtra(GSAppConstants.INSTALLATION_REQUEST_REFERENCE, book_list.get(position).getReference());
                installRequestIntent.putExtra(GSAppConstants.INSTALLATION_REQUEST_ADD, "false");
                startActivity(installRequestIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        floatActionBtnAdd.setOnClickListener(v -> {
            try {
                Intent installRequestIntent = new Intent(getActivity(), CXInstallationRequestDetailActivity.class);
                installRequestIntent.putExtra(GSAppConstants.INSTALLATION_REQUEST_NAME, getString(R.string.app_name));
                installRequestIntent.putExtra(GSAppConstants.INSTALLATION_REQUEST_REFERENCE, getString(R.string.app_name));
                installRequestIntent.putExtra(GSAppConstants.INSTALLATION_REQUEST_ADD, "true");
                startActivity(installRequestIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return rootView;
    }

    private void getSwiftBookingAllDetailWebservices() {
        try {
            if (!GSUtilities.checkNetworkConnection(getActivity())) {
                showAlertDialog(getString(R.string.info_title), getString(R.string.no_internet_connection));
            } else {
                GSApp.getInstance().getDataModelController().getJobDetail(getActivity(), new GSDataModelResponseHandler() {
                    @Override
                    public void onSuccess(GSHttpClientResponse response) {
                        try {
                            hideProgressDialog();
                            Log.v(TAG, "book deetail received success" + response.getJSONObject());
                            Gson gson = new Gson();
                            CXBookJob requestData = gson.fromJson(response.getJSONObject().toString(), CXBookJob.class);
                            book_list.clear();
                            book_list = requestData.getData();
                            if (book_list != null) {
                                setGridViewAdapter();
                            } else {
                                tvEmptyView.setVisibility(View.VISIBLE);
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(GSHttpClientResponse response) {
                        try {
                            GSApp.v(TAG, "request received failed" + response.getJSONObject());
                            hideProgressDialog();
                            showDeviceCommandFailureAlert(response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGridViewAdapter() {
        try {
            CXInstallationRequestAdapter CXInstallationRequestAdapter = new CXInstallationRequestAdapter(getActivity(), book_list);
            lvDevices.setAdapter(CXInstallationRequestAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (GSAppConstants.isAddJobGiven == true) {
            GSAppConstants.isAddJobGiven = false;
            getSwiftBookingAllDetailWebservices();
        }
    }

    class CXInstallationRequestAdapter extends BaseAdapter {
        FragmentActivity activity;
        ArrayList<CXDatum> book_list;

        public CXInstallationRequestAdapter(FragmentActivity activity, ArrayList<CXDatum> book_list) {
            this.activity = activity;
            this.book_list = book_list;
        }

        @Override
        public int getCount() {
            return book_list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.cx_devices_griditem, parent, false);
                //Configure view holder
                holder = new ViewHolder();
                //UI Initialise
                holder.tvDeviceName = (AutofitTextView) convertView.findViewById(R.id.tv_device_name);
                holder.tvUserName = (AutofitTextView) convertView.findViewById(R.id.tv_user_name);
                holder.iv_right = (ImageView) convertView.findViewById(R.id.iv_right);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            try {
                holder.iv_right.setColorFilter(activity.getResources().getColor(R.color.gray_sec_text));
                String firstName = null;
                String shortName = null;
                firstName = book_list.get(position).getReference();
                shortName = book_list.get(position).getCurrentStatus();
                holder.tvDeviceName.setText("Job" + " " + firstName);
                holder.tvUserName.setText(shortName);
                holder.tvUserName.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return convertView;
        }

        private class ViewHolder {
            AutofitTextView tvDeviceName, tvUserName;
            ImageView iv_right;
        }
    }
}
