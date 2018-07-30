package Dao.impl;

import Dao.TestDao;
import com.coreos.jetcd.Client;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.kv.GetResponse;
import com.coreos.jetcd.options.GetOption;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by BenBen嚓 on 2018/4/3.
 */

public class TestDaoImol implements TestDao{

    @Override
    public String intertest() {
        Client client = Client.builder().endpoints("http://15.45.192.206:2379").build();
        KV kvClient = client.getKVClient();

        ByteSequence key = ByteSequence.fromString("/camera");
        ByteSequence key1 = ByteSequence.fromString("/camera/forword");
        ByteSequence value = ByteSequence.fromString("test_value");


// put the key-value
        try {
            GetOption option = GetOption.newBuilder().withPrefix(key).withKeysOnly(true).build();
            GetOption option1 = GetOption.newBuilder().withPrefix(key1).withKeysOnly(true).build();
                int a = kvClient.get(key, option).get().getKvs().size();
            int b = kvClient.get(key, option1).get().getKvs().size();
//            kvClient.put(key, value).get();
            // get the CompletableFuture
            CompletableFuture<GetResponse> getFuture = kvClient.get(key);
            CompletableFuture<GetResponse> getFuture1 = kvClient.get(key1);
// get the value from CompletableFuture
            GetResponse response = getFuture.get();
            GetResponse response1 = getFuture.get();
            System.out.println("================"+a);
            System.out.println("================"+b);
            return String.valueOf(a+";"+b);
// delete the key
//            DeleteResponse deleteRangeResponse = kvClient.delete(key).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
}
}
