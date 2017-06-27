package de.hsb.gastromaster;

import android.app.Application;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;

import de.hsb.gastromaster.data.order.IOrderDataRepository;
import de.hsb.gastromaster.data.order.OrderDataRepository;
import de.hsb.gastromaster.data.order.local.OrderDataStore;
import de.hsb.gastromaster.data.table.ITableDataRepository;
import de.hsb.gastromaster.data.table.Table;
import de.hsb.gastromaster.data.table.TableDataRepository;
import de.hsb.gastromaster.data.table.local.TableDataStore;


/**
 * The Gastro master app.
 */
public class GastroMasterApp extends Application {

    private static OrderDataStore orderDataStore;
    private static TableDataStore tableDataStore;
    private static OrderDataRepository orderDataRepository;
    private static TableDataRepository tableDataRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {

            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        LeakCanary.install(this);

        initSingletons();
    }

    private void initSingletons(){

        orderDataStore = new OrderDataStore();
        tableDataStore = new TableDataStore(orderDataStore);

        orderDataStore.init();
        tableDataStore.init();


        orderDataRepository = new OrderDataRepository(orderDataStore);
        tableDataRepository = new TableDataRepository(tableDataStore);
    }

    /**
     * Get order data repository order data repository.
     *
     * @return the order data repository
     */
    public IOrderDataRepository getOrderDataRepository(){
        return orderDataRepository;
    }

    /**
     * Get table data repository table data repository.
     *
     * @return the table data repository
     */
    public ITableDataRepository getTableDataRepository(){
        return tableDataRepository;
    }


}
