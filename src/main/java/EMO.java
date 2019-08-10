import sort.QuickSort;

import javax.security.sasl.SaslClient;
import java.lang.ref.PhantomReference;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class EMO {


    private EMO() {
    }

    private EMO instance;

    public EMO getInstance() {
        if (instance == null) {
            synchronized (EMO.class) {
                if (instance == null) {
                    instance = new EMO();
                }
            }
        }
        return instance;
    }


}