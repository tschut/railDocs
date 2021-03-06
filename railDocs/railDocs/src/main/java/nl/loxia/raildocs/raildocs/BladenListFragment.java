package nl.loxia.raildocs.raildocs;

import android.app.Fragment;
import android.app.ListFragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import nl.loxia.raildocs.raildocs.util.BundleKeys;
import nl.loxia.raildocs.raildocs.util.CredentialsStore;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
@EFragment(R.layout.fragment_list_blad)
public class BladenListFragment extends ListFragment {
    @ViewById(android.R.id.list)
    protected ListView listView;
    @RestService
    protected IRailCloud railCloud;
    @Bean
    protected CredentialsStore credentialsStore;

    @Bean
    BladArrayAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BladenListFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().getActionBar().setTitle(R.string.title_activity_bladen_list);
        getActivity().getActionBar().setSubtitle(getArguments().getString(BundleKeys.DOCUMENT));
    }

    @AfterViews
    protected void bindAdapter() {
        listView.addFooterView(new View(getActivity()), null, false);
        listView.addHeaderView(new View(getActivity()), null, false);
        setListAdapter(adapter);

        String post = getArguments().getString(BundleKeys.POST);
        String dossier = getArguments().getString(BundleKeys.DOSSIER);
        String document = getArguments().getString(BundleKeys.DOCUMENT);
        adapter.initAdapter(post, dossier, document);
    }
}
