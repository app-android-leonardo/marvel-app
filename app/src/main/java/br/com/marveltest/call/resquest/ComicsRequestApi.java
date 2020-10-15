package br.com.marveltest.call.resquest;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import java.util.ArrayList;
import java.util.List;

import br.com.marveltest.base.Configurations;
import br.com.marveltest.R;
import br.com.marveltest.adapter.ItemAdapter;
import br.com.marveltest.api.IApiConnection;
import br.com.marveltest.base.AndroidComponent;
import br.com.marveltest.call.response.ComicsResponseApi;
import br.com.marveltest.model.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicsRequestApi {
    private Activity activity;
    private AndroidComponent android;

    public ComicsRequestApi(Activity activity) {
        this.activity = activity;
        android = new AndroidComponent(activity);
    }

    public void call(final IApiConnection service, final DiscreteScrollView scrollView, int idCharacter, final boolean isDetail) {
        if (new AndroidComponent(activity).isOnline()){
            Call<ComicsResponseApi> call = service.comics(idCharacter, Configurations.TS, Configurations.API_KEY, Configurations.HASH);
            android.showProgress(activity.getString(R.string.aguarde_));
            call.enqueue(new Callback<ComicsResponseApi>() {
                @Override
                public void onResponse(@NonNull Call<ComicsResponseApi> call, @NonNull Response<ComicsResponseApi> response) {
                    android.hideProgress();
                    if (response.isSuccessful()){
                        ComicsResponseApi body = response.body();
                        List<Item> itemList = new ArrayList<>();
                        if (body != null){
                            ComicsResponseApi.Data data = body.data;
                            for (ComicsResponseApi.Results item : data.results){
                                Item i = new Item(item.id, item.title, item.thumbnail.path + "." +item.thumbnail.extension);
                                i.setResourceURI(item.resourceuri);
                                i.setDescription(item.description);
                                for (ComicsResponseApi.Urls itemUrl : item.urls){
                                    if ("detail".equals(itemUrl.type)) {
                                        i.setUrlDetail(itemUrl.url);
                                    }
                                }
                                itemList.add(i);
                            }

                            if (itemList.isEmpty()){
                                new AndroidComponent(activity).alert(activity.getString(R.string.atencao), activity.getString(R.string.not_comics), true);
                                return;
                            }

                            scrollView.setAdapter(InfiniteScrollAdapter.wrap(new ItemAdapter(activity, itemList, isDetail)));
                            ScaleTransformer transformer = new ScaleTransformer.Builder()
                                    .setMaxScale(1.05f)
                                    .setMinScale(0.8f)
                                    .build();
                            scrollView.setItemTransformer(transformer);
                        }
                    } else {
                        android.showMessage(activity.getString(R.string.erro) + response.code());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ComicsResponseApi> call, @NonNull Throwable t) {
                    android.hideProgress();
                    android.showMessage(activity.getString(R.string.falha) + t.getMessage());
                }
            });
        } else {
            android.showMessage(activity.getString(R.string.verifique_sua_conexao));
        }
    }
}